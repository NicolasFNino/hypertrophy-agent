package main;

import main.WorkoutDay;

public class WorkoutPlan {
    public int experienceLevel;
    public String trainingSplit;
    public String targetProgram;

    public WorkoutDay[] days; 

    public WorkoutPlan(int experienceLevel, String trainingSplit, int trainingDays, String targetProgram) {
        this.experienceLevel = experienceLevel;
        this.trainingSplit = trainingSplit;
        this.targetProgram = targetProgram;
        this.days = new WorkoutDay[trainingDays];
    }

    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "experienceLevel=" + experienceLevel +
                ", trainingSplit='" + trainingSplit + '\'' +
                ", trainingDays=" + this.days +
                ", targetProgram='" + targetProgram + '\'' +
                '}';
    }
}