package baseball.domain;

import java.util.*;

import static baseball.domain.BaseBallErrors.*;
import static baseball.domain.BusinessConstant.*;

public class Balls {
    private final List<Ball> balls;


    public Balls(List<Integer> balls) {
        validationBalls(balls);
        this.balls = mapBalls(balls);
    }

    private void validationBalls(List<Integer> balls) {
        Set<Integer> setBalls = new HashSet<>(balls);
        if (setBalls.size() != MAX_BALL_POSITION) {
            throw new IllegalArgumentException(INVALID_LENGTH_BALLS.getExceptionMessage());
        }
    }

    private List<Ball> mapBalls(List<Integer> balls) {
        List<Ball> ballMaps = new ArrayList<>();

        for (int i = 0; i < balls.size(); i++) {
            ballMaps.add(new Ball(i + 1, balls.get(i)));
        }

        return ballMaps;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
                .map(answerBall -> answerBall.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
