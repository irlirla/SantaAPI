package ru.rom.santaservice.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Storage")
@Getter
@Setter
public class Storage {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "present_id", referencedColumnName = "id")
    @NotNull
    private Present presentId;

    @Column(name = "amount")
    @NotNull
    private Integer amount;
}
