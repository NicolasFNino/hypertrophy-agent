package main;

import util.Enums;
import main.WorkoutDay;

public class WorkoutPlan {
    public int experienceLevel;
    public Splits trainingSplit;
    public String targetProgram;

    public WorkoutDay[] days; 

    public WorkoutPlan(int experienceLevel, String trainingSplit, int trainingDays, String targetProgram) {
        this.experienceLevel = experienceLevel;
        this.trainingSplit = getSplitFromString(trainingSplit);
        this.targetProgram = targetProgram;
        this.days = new WorkoutDay[trainingDays];
    }

    public void populatePlan() {
        craftSplit();
        addExercisesToDays();
    }

    private void craftSplit() {
        switch (this.trainingSplit) {
            case FULL_BODY:
                for (int i = 0; i < this.days.length; i++) {
                    this.days[i] = new WorkoutDay(FB_Days.FULL_BODY);
                }
                break;
            case UPPER_LOWER:
                for (int i = 0; i < this.days.length; i++) {
                    if (i % 2 == 0) {
                        this.days[i] = new WorkoutDay(UL_Days.UPPER);
                    } else {
                        this.days[i] = new WorkoutDay(UL_Days.LOWER);
                    }
                }
                break;
            case PUSH_PULL_LEGS:
                for (int i = 0; i < this.days.length; i++) {
                    if (i % 3 == 0) {
                        this.days[i] = new WorkoutDay(PPL_Days.PUSH);
                    } else if (i % 3 == 1) {
                        this.days[i] = new WorkoutDay(PPL_Days.PULL);
                    } else {
                        this.days[i] = new WorkoutDay(PPL_Days.LEGS);
                    }
                }
                break;
            case PUSH_PULL_LEGS_TWO:
                String[] cycle = {PPL_Days.PUSH.name(), PPL_Days.PULL.name(), PPL_Days.LEGS.name(),
                                  PPL_Days.PUSH.name(), PPL_Days.PULL.name(), PPL_Days.LEGS.name()};
                for (int i = 0; i < this.days.length; i++) {
                    this.days[i] = new WorkoutDay(Enums.PPL_Days.valueOf(cycle[i]));
                }
                break;
            case BODY_PART_SPLIT:
                String[] bpCycle = {BP_Days.CHEST.name(), BP_Days.BACK.name(), BP_Days.LEGS.name(),
                                    BP_Days.SHOULDERS.name(), BP_Days.CORE.name()};
                for (int i = 0; i < this.days.length; i++) {
                    this.days[i] = new WorkoutDay(Enums.BP_Days.valueOf(bpCycle[i]));
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid training split: " + this.trainingSplit);
        }
    }

    private void addExercisesToDays() {
        for (WorkoutDay day : this.days) {
            day.addExercise(new Exercise("Sample Exercise", 3, 10, "60s"), 0);
        }
    }

    private Splits getSplitFromString(String split) {
        switch (split.toUpperCase()) {
            case "FULL_BODY":
                return Splits.FULL_BODY;
            case "UPPER_LOWER":
                return Splits.UPPER_LOWER;
            case "PUSH_PULL_LEGS":
                return Splits.PUSH_PULL_LEGS;
            case "PUSH_PULL_LEGS_TWO":
                return Splits.PUSH_PULL_LEGS_TWO;
            case "BODY_PART_SPLIT":
                return Splits.BODY_PART_SPLIT;
            default:
                throw new IllegalArgumentException("Invalid training split: " + split);
        }
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