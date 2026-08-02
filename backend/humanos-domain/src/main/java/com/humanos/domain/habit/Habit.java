package com.humanos.domain.habit;

import java.util.UUID;

public class Habit {

    private final UUID id;
    private final String name;
    private final String description;
    private final HabitCategory category;
    private final HabitMeasurement measurement;
    private final HabitDirection direction;

    public Habit(
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