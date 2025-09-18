package main;

public class Exercise {
    public String name;
    public String muscleGroup;
    public String primaryMuscle;
    public String[] secondaryMuscles;
    public String equipment;

    public int sets;
    public int reps;
    public String restPeriod;

    public Exercise() {
        this.name = "";
        this.muscleGroup = "";
        this.primaryMuscle = "";
        this.secondaryMuscles = new String[3];
        this.equipment = "";
        this.sets = 0;
        this.reps = 0;
        this.restPeriod = "";
    }

    public Exercise(String name, int sets, int reps, String restPeriod) {
        this.name = name;
        this.muscleGroup = "";
        this.primaryMuscle = "";
        this.secondaryMuscles = new String[3];
        this.equipment = "";
        this.sets = sets;
        this.reps = reps;
        this.restPeriod = restPeriod;
    }
}