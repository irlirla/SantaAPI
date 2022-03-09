package ru.rom.santaservice.service;

import ru.rom.santaservice.entity.Present;

public interface IPresentService {

    Present getPresentByType(String presentType);
}
