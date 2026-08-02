package com.humanos.application.habit.persistence;

import com.humanos.application.habit.HabitRepository;
import com.humanos.domain.habit.Habit;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class HabitRepositoryImpl implements HabitRepository {

    private final HabitJpaRepository jpaRepository;

    public HabitRepositoryImpl(HabitJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Habit save(Habit habit) {

        HabitEntity entity = new HabitEntity(
                habit.getId(),
                habit.getName(),
                habit.getDescription(),
                habit.getCategory(),
                habit.getMeasurement(),
                habit.getDirection()
        );

        HabitEntity saved = jpaRepository.save(entity);

        return new Habit(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getCategory(),
                saved.getMeasurement(),
                saved.getDirection()
        );
    }

    @Override
    public Optional<Habit> findById(UUID id) {

        return jpaRepository.findById(id)
                .map(entity -> new Habit(
                        entity.getId(),
                        entity.getName(),
                        entity.getDescription(),
                        entity.getCategory(),
                        entity.getMeasurement(),
                        entity.getDirection()
                ));
    }

    @Override
    public List<Habit> findAll() {

        return jpaRepository.findAll()
                .stream()
                .map(entity -> new Habit(
                        entity.getId(),
                        entity.getName(),
                        entity.getDescription(),
                        entity.getCategory(),
                        entity.getMeasurement(),
                        entity.getDirection()
                ))
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}