package ru.rom.santaservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "kids")
@Getter
@Setter
@ToString
public class Kid {
    @Id
    @GeneratedValue() //why doesnt generate?
    private Long id;

    @Column(name = "fio", nullable = false)
    @NotEmpty(message = "Name and surname must not be empty!")
    @Size(min = 2, max = 50, message = "Please, enter name in size between 2 and 25 characters.")
    private String fio;

    @ManyToOne
    @JoinColumn(name = "present_id")
    private Present present;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kid kid = (Kid) o;
        return id.equals(kid.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
