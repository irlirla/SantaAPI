package ro.rom.factoryservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.rom.factoryservice.dto.CreatePresentsOrderDTO;
import ro.rom.factoryservice.service.IFactoryService;

@RestController
@RequestMapping("/factory")
@RequiredArgsConstructor
public class FactoryController {
    private final IFactoryService service;

    @PostMapping("/order")
    public void submitOrder(@RequestBody CreatePresentsOrderDTO request)
            throws InterruptedException, JsonProcessingException {
        service.buildPresents(request.getPresentType(), request.getMinAmountToCreate());
    }
}
