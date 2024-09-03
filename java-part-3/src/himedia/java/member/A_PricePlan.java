package himedia.java.member;

public enum A_PricePlan {
    LITE("보급 요금제", 10),
    BASIC("기본 요금제", 20),
    PREMIUM("프리미엄 요금제", 30),
    FREE("프리패스 요금제", -1);
    
    private final String description;
    private final int count;

    A_PricePlan(String description, int count) {
        this.description = description;
        this.count = count;            
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }
}
