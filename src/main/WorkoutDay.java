package main;

import util.Enums;

public class WorkoutDay {
    public Day name;
    public String[] exercises;

    public WorkoutDay() {
        this.name = null;
        this.exercises = new String[]{};
    }

    public WorkoutDay(Day name) {
        this.name = name;
    }

    public WorkoutDay(Day name, String[] exercises) {
        this.name = name;
        this.exercises = exercises;
    }
}   