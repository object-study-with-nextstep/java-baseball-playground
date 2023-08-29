package baseball.domain;

public enum BallStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("아웃"),
    ;

    private final String comment;

    BallStatus(String comment) {
        this.comment = comment;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }

    public boolean isNotStrike() {
        return this != STRIKE;
    }

    public boolean isNotBall() {
        return this != BALL;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public String comment() {
        return comment;
    }
}
