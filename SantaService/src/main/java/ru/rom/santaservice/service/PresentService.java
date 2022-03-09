package ru.rom.santaservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rom.santaservice.entity.Present;
import ru.rom.santaservice.repository.IPresentRepository;

@Service
@RequiredArgsConstructor
public class PresentService implements IPresentService {
    private final IPresentRepository repository;

    @Override
    public Present getPresentByType(String presentType) {
        return repository.getPresentByType(presentType);
    }
}
