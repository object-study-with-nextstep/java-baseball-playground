package baseball.domain;

public enum BusinessConstant {
    MIN_BALL_VALUE(1),
    MAX_BALL_VALUE(9),
    MIN_BALL_POSITION(1),
    MAX_BALL_POSITION(3),
    ;

    private final int number;

    BusinessConstant(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
