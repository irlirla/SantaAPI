package ru.rom.santaservice.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Storage")
@Getter
@Setter
public class Storage {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "present_id", referencedColumnName = "id")
    private Present presentId;

    @Column(name = "amount")
    private Integer amount;
}
