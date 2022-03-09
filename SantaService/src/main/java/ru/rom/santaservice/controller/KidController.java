package ru.rom.santaservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.rom.santaservice.dto.KidDTO;
import ru.rom.santaservice.service.IKidService;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/kid")
public class KidController {
    private final IKidService service;

    @PostMapping("/record")
    public ResponseEntity<String> recordKid(@RequestBody KidDTO kidDTO) {
        service.createKid(kidDTO.getFio());
        return ResponseEntity.ok().body("This kid was successfully recorded!");
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteKid(@RequestBody KidDTO kidDTO) {
        service.deleteKid(kidDTO.getFio());
        return ResponseEntity.ok().body("This kid was successfully removed from records!");
    }
}
