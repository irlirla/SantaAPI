package ro.rom.factoryservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.scheduling.annotation.Async;

public interface IFactoryService {
    @Async
    void buildPresents(String presentType, Integer minAmountToCreate)
            throws InterruptedException, JsonProcessingException;
}
