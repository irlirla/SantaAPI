package ru.rom.santaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rom.santaservice.entity.Kid;

import java.util.Optional;

@Repository
public interface IKidRepository extends JpaRepository<Kid, Long> {
    Optional<Kid> findByFio(String fio);
}
