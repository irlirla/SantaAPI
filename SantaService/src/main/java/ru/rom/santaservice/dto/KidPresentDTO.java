package ru.rom.santaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KidPresentDTO {
    private String fio;
    private String presentType;
}
