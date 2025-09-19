package com.fitness.app.main;

import com.fitness.app.main.WorkoutPlan;

public class UserProfile {
    public String name;
    public int age;
    public double weight;
    public String targetProgram;
    public int trainingDays;
    public int trainingHours;
    public int programVolume;
    public int experienceLevel;
    public String trainingSplit;
    public WorkoutPlan workoutPlan;

    public UserProfile(String name, int age, double weight, String targetProgram, int trainingDays, int trainingHours, int experienceLevel) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.targetProgram = targetProgram;
        this.trainingDays = trainingDays;
        this.trainingHours = trainingHours;
        this.programVolume = calculateProgramVolume();
        this.experienceLevel = experienceLevel;
        this.trainingSplit = determineTrainingSplit();
        this.workoutPlan = null;
    }

    private int calculateProgramVolume() {
        return (int)(trainingDays * trainingHours);
    }

    private String determineTrainingSplit() {
        if (trainingDays <= 3) {
            return "Full Body "+trainingDays+"x";
        } else if (trainingDays == 4) {
            return "Upper/Lower Split";
        } else if (trainingDays == 5) {
            return "Push/Pull/Legs + Upper/Lower";
        } else if(trainingDays == 6) {
            return "Push/Pull/Legs x2";
        } else {
            return "Body Part Split";
        }
    }

    protected WorkoutPlan generateWorkoutPlan() {
        return new WorkoutPlan(this.experienceLevel, this.trainingSplit, this.programVolume, this.targetProgram);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", targetProgram='" + targetProgram + '\'' +
                ", trainingDays=" + trainingDays +
                ", trainingHours=" + trainingHours +
                ", programVolume=" + programVolume + 
                ", experienceLevel=" + experienceLevel +
                '}';
    }

}