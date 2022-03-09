package ru.rom.santaservice.service;

import ru.rom.santaservice.entity.Kid;
import ru.rom.santaservice.entity.Present;

public interface IKidService {

    void createKid(String fio);

    void deleteKid(String fio);

    Kid getKidByFio(String fio);

    void attachPresent(String fio, Present present);

    Boolean isKidRecorded(String fio);
}
