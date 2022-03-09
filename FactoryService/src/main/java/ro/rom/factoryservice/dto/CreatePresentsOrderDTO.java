package ro.rom.factoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePresentsOrderDTO {
    private String presentType;
    private Integer minAmountToCreate;
}
