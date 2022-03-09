package ro.rom.factoryservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ro.rom.factoryservice.dto.NotifyMessageDTO;
import ro.rom.factoryservice.producer.OrderReadyNotificationProducer;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class FactoryService implements IFactoryService {
    private final OrderReadyNotificationProducer producer;
    private final ObjectMapper mapper;

    @Async
    @Override
    public void buildPresents(String presentType, Integer minAmountToCreate)
            throws InterruptedException, JsonProcessingException {
        log.info("Factory started to create presents of type: " + presentType);
        Thread.sleep(10000);
        NotifyMessageDTO messageDTO = new NotifyMessageDTO(presentType,
                ThreadLocalRandom.current().nextInt(minAmountToCreate, 50));
        producer.notifyOrderReady(mapper.writeValueAsString(messageDTO));
    }
}
