package ru.rom.santaservice.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "presents")
@Getter
@Setter
public class Present {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "min_amount")
    private Integer minAmount;

    @OneToMany(mappedBy = "present")
    private Set<Kid> kids;
}
