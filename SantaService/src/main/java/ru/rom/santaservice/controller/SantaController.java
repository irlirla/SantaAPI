package ru.rom.santaservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rom.santaservice.dto.KidDTO;
import ru.rom.santaservice.service.IStorageService;

@RestController
@RequiredArgsConstructor
@Transactional
public class SantaController {
    private final IStorageService service;

    @PostMapping("/sendpresent")
    public ResponseEntity<String> sendPresent(@RequestBody KidDTO kidDTO) {
        service.assignPresentToKid(kidDTO.getPresentType(), kidDTO.getFio());
        return ResponseEntity.ok().body("Present was successfully sent!");
    }
}
