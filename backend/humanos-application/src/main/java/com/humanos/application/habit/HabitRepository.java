package com.humanos.application.habit;

import com.humanos.domain.habit.Habit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HabitRepository {
    Habit save(Habit habit);
    Optional<Habit> findById(UUID id);
    List<Habit> findAll();
    void deleteById(UUID id);
}