package baseball.domain;

import java.util.Objects;

import static baseball.domain.BallStatus.*;
import static baseball.domain.BaseBallErrors.OUT_OF_BOUNDARY_POSITION;
import static baseball.domain.BaseBallErrors.OUT_OF_BOUNDARY_VALUE;
import static baseball.domain.BusinessConstant.*;

public class Ball {
    private final int position;
    private final int ballNo;

    public Ball(int position, int ballNo) {
        validationPosition(position);
        validationNumber(ballNo);

        this.position = position;
        this.ballNo = ballNo;
    }

    public int position() {
        return position;
    }

    public int ballNo() {
        return ballNo;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return STRIKE;
        }

        if (this.matchBallNo(ball.ballNo)) {
            return BALL;
        }

        return NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    private void validationNumber(int ballNo) {
        if (ballNo < MIN_BALL_VALUE.number() || ballNo > MAX_BALL_VALUE.number()) {
            throw new IllegalArgumentException(OUT_OF_BOUNDARY_VALUE.getExceptionMessage());
        }
    }

    private void validationPosition(int position) {
        if (position < MIN_BALL_POSITION.number() || position > MAX_BALL_POSITION.number()) {
            throw new IllegalArgumentException(OUT_OF_BOUNDARY_POSITION.getExceptionMessage());
        }
    }
}
