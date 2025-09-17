package util;

public class Enums {
    
    public enum Splits {
        FULL_BODY,
        UPPER_LOWER,
        PUSH_PULL_LEGS,
        PUSH_PULL_LEGS_TWO,
        BODY_PART_SPLIT
    }

    public interface Day {}

    public enum FB_Days implements Day {
        FULL_BODY
    }

    public enum UL_Days implements Day {
        UPPER,
        LOWER
    }
    
    public enum PPL_Days implements Day {
        PUSH,
        PULL,
        LEGS
    }

    public enum BP_Days implements Day {
        CHEST,
        BACK,
        LEGS,
        SHOULDERS,
        CORE
    }
}