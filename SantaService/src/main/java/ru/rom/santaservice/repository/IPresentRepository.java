package ru.rom.santaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rom.santaservice.entity.Present;

public interface IPresentRepository extends JpaRepository<Present, Long> {

    Present getPresentByType(String type);
}
