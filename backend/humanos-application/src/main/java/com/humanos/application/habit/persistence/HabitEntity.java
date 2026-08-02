package com.humanos.application.habit.persistence;

import com.humanos.domain.habit.HabitCategory;
import com.humanos.domain.habit.HabitDirection;
import com.humanos.domain.habit.HabitMeasurement;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "habits")
public class HabitEntity {

    @Id
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HabitCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HabitMeasurement measurement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HabitDirection direction;

    protected HabitEntity() {
    }

    public HabitEntity(
            UUID id,
            String name,
            String description,
            HabitCategory category,
            HabitMeasurement measurement,
            HabitDirection direction
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.measurement = measurement;
        this.direction = direction;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HabitCategory getCategory() {
        return category;
    }

    public HabitMeasurement getMeasurement() {
        return measurement;
    }

    public HabitDirection getDirection() {
        return direction;
    }
}