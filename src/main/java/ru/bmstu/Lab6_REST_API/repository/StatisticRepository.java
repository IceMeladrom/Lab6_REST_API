package ru.bmstu.Lab6_REST_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.Lab6_REST_API.entity.Statistic;

import java.util.List;
import java.util.Optional;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
    @Override
    Optional<Statistic> findById(Long aLong);

    List<Statistic> findByPlayerLogin(String playerLogin);
}
