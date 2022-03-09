package ru.rom.santaservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rom.santaservice.dto.KidDTO;
import ru.rom.santaservice.service.IKidService;

@RestController
@RequiredArgsConstructor
public class KidController {
    private final IKidService service;

    @PostMapping("/recordkid")
    public ResponseEntity<String> recordKid(@RequestBody KidDTO kidDTO) {
        service.createKid(kidDTO.getFio());
        return ResponseEntity.ok().body("This kid was successfully recorded!");
    }

    @GetMapping("/deletekid")
    public ResponseEntity<String> deleteKid(@RequestBody KidDTO kidDTO) {
        service.deleteKid(kidDTO.getFio());
        return ResponseEntity.ok().body("This kid was successfully removed from records!");
    }
}
