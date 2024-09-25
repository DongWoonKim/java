package com.example.tobi.springtobi.ch05.ex_5_1.domain;

public enum Level {
    GOLD(3, null),
    SILVER(2, GOLD),
    BASIC(1, SILVER);

    private final int value;
    private final Level level;

    Level(int value, Level level) {
        this.value = value;
        this.level = level;
    }

    public Level nextLevel() {
        return level;
    }

    public int getValue() {
        return value;
    }

    public static Level valueOf(int value) {
        switch (value) {
            case 1:
                return BASIC;
            case 2:
                return SILVER;
            case 3:
                return GOLD;
            default:
                throw new IllegalArgumentException("Unknown level: " + value);
        }
    }
}
