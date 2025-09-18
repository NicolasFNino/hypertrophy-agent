package main;

import util.Enums;
import main.Exercise;

public class WorkoutDay {
    public Day name;
    public Exercise[] exercises;

    public WorkoutDay() {
        this.name = null;
        this.exercises = new Exercise[]{};
    }

    public WorkoutDay(Day name) {
        this.name = name;
        this.exercises = new Exercise[7];
    }

    public WorkoutDay(Day name, Exercise[] exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    protected void addExercise(Exercise exercise, int index) {
        if (index >= 0 && index < this.exercises.length) {
            this.exercises[index] = exercise;
        } else {
            System.out.println("Index out of bounds. Cannot add exercise.");
        }
    }
    
}   