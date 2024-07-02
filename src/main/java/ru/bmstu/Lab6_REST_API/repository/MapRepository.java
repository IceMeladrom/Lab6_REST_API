package ru.bmstu.Lab6_REST_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.Lab6_REST_API.entity.MapData;

import java.util.List;
import java.util.Optional;

public interface MapRepository extends JpaRepository<MapData, Long> {
    @Override
    Optional<MapData> findById(Long aLong);

    List<MapData> findByPlayerLogin(String playerLogin);
}
