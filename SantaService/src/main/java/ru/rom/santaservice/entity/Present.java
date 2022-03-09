package ru.rom.santaservice.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty
    private String type;

    @Column(name = "min_amount")
    @NotNull
    private Integer minAmount;

    @OneToMany(mappedBy = "present")
    private Set<Kid> kids;
}
