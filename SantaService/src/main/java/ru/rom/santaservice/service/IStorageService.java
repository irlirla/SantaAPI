package ru.rom.santaservice.service;

import ru.rom.santaservice.dto.NotifyMessageDTO;

public interface IStorageService {

    void assignPresentToKid(String presentType, String fio);

    void increasePresentAmount(NotifyMessageDTO message);
}
