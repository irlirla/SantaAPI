package ru.rom.behaviorservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rom.behaviorservice.service.IBehaviorService;

@RestController
@RequestMapping("/behavior")
@RequiredArgsConstructor
public class BehaviorController {
    private final IBehaviorService service;

    @GetMapping("/")
    public HttpEntity<Boolean> checkBehavior(@RequestParam("kidId") Long kidId) {
        return ResponseEntity.ok().body(service.getBehavior(kidId));
    }
}
