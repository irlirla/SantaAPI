package ru.rom.santaservice.service;

import ru.rom.santaservice.entity.Kid;
import ru.rom.santaservice.entity.Present;

public interface IKidService {

    Kid getKidByFio(String fio);

    void attachPresent(String fio, Present present);
}
