package himedia.java;

public enum B_day_2 {
    SUNDAY("Holiday"),
    MONDAY("Work day"),
    TUESDAY("Work day"),
    WEDNESDAY("Work day"),
    THURSDAY("Work day"),
    FRIDAY("Work day"),
    SATURDAY("Half day"),;

    // 필드
    private String description;

    B_day_2(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
