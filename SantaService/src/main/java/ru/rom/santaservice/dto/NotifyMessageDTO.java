package ru.rom.santaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotifyMessageDTO {
    private String presentType;
    private Integer amountOfCreated;
}
