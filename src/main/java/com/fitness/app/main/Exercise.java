package com.fitness.app.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Exercise {
    public String name;
    public String muscleGroup;
    public String primaryMuscle;
    public String[] secondaryMuscles;
    // keep a generic map for difficulty => equipment as in exercises.json
    @JsonProperty("difficultyEquipment")
    public Map<String, String> difficultyEquipment;
    public String equipment;

    public int sets;
    public int reps;
    public String restPeriod;

    public Exercise() {
        this.name = "";
        this.muscleGroup = "";
        this.primaryMuscle = "";
        this.secondaryMuscles = new String[0];
        this.equipment = "";
        this.sets = 0;
        this.reps = 0;
        this.restPeriod = "";
    }

    public Exercise(String name, int sets, int reps, String restPeriod) {
        this.name = name;
        this.muscleGroup = "";
        this.primaryMuscle = "";
        this.secondaryMuscles = new String[0];
        this.equipment = "";
        this.sets = sets;
        this.reps = reps;
        this.restPeriod = restPeriod;
    }

    /***
     * Choose appropriate equipment based on user's experience level.
     * @param experienceLevel
     */
    public void chooseEquipmentForLevel(int experienceLevel) {
        if (difficultyEquipment == null || difficultyEquipment.isEmpty()) return;
        String levelKey;
        if (experienceLevel >= 3) {
            levelKey = "Advanced";
        } else if (experienceLevel == 2) {
            levelKey = "Intermediate";
        } else {
            levelKey = "Beginner";
        }
        // fall back to any available entry if specific level is missing
        if (difficultyEquipment.containsKey(levelKey)) {
            this.equipment = difficultyEquipment.get(levelKey);
        } else {
            // pick first value
            String first = difficultyEquipment.values().stream().findFirst().orElse("");
            this.equipment = first;
        }
    }
}