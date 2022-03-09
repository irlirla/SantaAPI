package ru.rom.behaviorservice.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class BehaviorService implements IBehaviorService {
    @Override
    public Boolean getBehavior(Long kidId) {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
