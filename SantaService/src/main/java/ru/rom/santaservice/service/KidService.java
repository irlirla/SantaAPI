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
    public void createKid(String fio) {
        if (getKidByFio(fio) != null) {
            throw new ApplicationException("We already have a record with a kid named: " + fio);
        }
        Kid kid = new Kid();
        kid.setFio(fio);
        repository.save(kid);
    }

    @Override
    public void deleteKid(String fio) {
        Optional<Kid> kid = repository.findByFio(fio);
        if (kid.isEmpty()) {
            throw new ApplicationException("In our records there is no kid named: " + fio);
        }
        repository.delete(kid.get());
    }

    @Override
    public Kid getKidByFio(String fio) {
        Optional<Kid> kid = repository.findByFio(fio);
        if (kid.isEmpty()) {
            throw new ApplicationException("In our records there is no kid named: " + fio +
                    ". Please, firstly add this kid name in the records.");
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
