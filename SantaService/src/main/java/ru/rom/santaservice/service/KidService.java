package ru.rom.santaservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rom.santaservice.entity.Kid;
import ru.rom.santaservice.entity.Present;
import ru.rom.santaservice.exception.ApplicationException;
import ru.rom.santaservice.repository.IKidRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KidService implements IKidService {
    private final IKidRepository repository;

    @Override
    public Kid getKidByFio(String fio) {
        Optional<Kid> kid = repository.findByFio(fio);
        if (kid.isEmpty()) {
            throw new ApplicationException("Kid with such fio was not found. fio: " + fio);
        }
        return kid.get();
    }

    @Override
    public void attachPresent(String fio, Present present) {
        Kid kid = getKidByFio(fio);
        kid.setPresent(present);
        repository.save(kid);
    }
}
