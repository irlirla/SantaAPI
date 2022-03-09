package ru.rom.santaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePresentsOrderDTO {
    private String presentType;
    private Integer minAmountToCreate;
}
