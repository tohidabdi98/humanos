package com.humanos.application.habit.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface HabitJpaRepository extends JpaRepository<HabitEntity, UUID> {
}