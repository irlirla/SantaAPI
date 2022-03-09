package ru.rom.santaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.rom.santaservice.entity.Storage;

public interface IStorageRepository extends JpaRepository<Storage, Long> {
    @Query(value = "select s from Storage s join s.presentId p where p.type = :type")
    Storage findStorageInfoByType(@Param("type") String type);
}
