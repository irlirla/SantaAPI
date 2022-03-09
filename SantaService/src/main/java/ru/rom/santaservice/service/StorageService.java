package ru.rom.santaservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.rom.santaservice.dto.CreatePresentsOrderDTO;
import ru.rom.santaservice.dto.NotifyMessageDTO;
import ru.rom.santaservice.entity.Kid;
import ru.rom.santaservice.entity.Present;
import ru.rom.santaservice.entity.Storage;
import ru.rom.santaservice.exception.ApplicationException;
import ru.rom.santaservice.exception.BadBehavior;
import ru.rom.santaservice.repository.IStorageRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StorageService implements IStorageService {
    private final IPresentService presentService;
    private final IKidService kidService;
    private final IStorageRepository repository;
    private final RestTemplate restTemplate; //requests

    @Value("${factory.url}")
    private String factoryURL;

    @Value("${behavior.url}")
    private String behaviorURL;

    @Override
    public void assignPresentToKid(String presentType, String fio) {
        ensurePresentAmount(presentType);
        if (repository.findStorageInfoByType(presentType).getAmount() > 0) {
            Kid kid = kidService.getKidByFio(fio);
            reducePresentAmount(presentType);
            Boolean isKidGood = restTemplate.getForObject(behaviorURL + "?kidId={kidId}",
                    Boolean.class, Map.of("kidId", kid.getId()));
            if (isKidGood == null) {
                throw new ApplicationException("Sorry, unable to connect to Behavior service.");
            }
            if (!isKidGood) {
                throw new BadBehavior("Sorry, no presents for misbehaving kid with id: " + kid.getId());
            }
            kidService.attachPresent(fio, presentService.getPresentByType(presentType));
        } else {
            throw new ApplicationException("Sorry, this type of presents not available now, try again later!");
        }
    }

    @Override
    public void increasePresentAmount(NotifyMessageDTO message) {
        Storage presentByType = repository.findStorageInfoByType(message.getPresentType());
        presentByType.setAmount(message.getAmountOfCreated() + presentByType.getAmount());
        repository.save(presentByType);
    }

    private void reducePresentAmount(String presentType) {
        Storage presentByType = repository.findStorageInfoByType(presentType);
        presentByType.setAmount(presentByType.getAmount() - 1);
        repository.save(presentByType);
    }

    private void ensurePresentAmount(String presentType) {
        Present presentByType = presentService.getPresentByType(presentType);
        if (presentByType.getMinAmount() >= repository.findStorageInfoByType(presentType).getAmount()) {
            CreatePresentsOrderDTO orderDTO = new CreatePresentsOrderDTO(
                    presentType, presentByType.getMinAmount());
            restTemplate.postForEntity(factoryURL, new HttpEntity<>(orderDTO), Object.class);
        }
    }
}
