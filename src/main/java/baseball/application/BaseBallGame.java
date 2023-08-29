package baseball.application;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import baseball.domain.Balls;

import java.util.Map;
import java.util.TreeMap;

public class BaseBallGame {
    private static final int RESULT_DEFAULT_VALUE = 0;
    private final Balls answerBalls;

    public BaseBallGame(Balls balls) {
        this.answerBalls = balls;
    }

    public Balls getAnswerBalls() {
        return answerBalls;
    }


    public Map<BallStatus, Integer> playGame(Balls balls) {
        Map<BallStatus, Integer> gameResult = new TreeMap<>();

        balls.getBalls().stream()
                .map(answerBalls::play)
                .forEach(status -> gameResult.put(
                        status,
                        gameResult.getOrDefault(status, RESULT_DEFAULT_VALUE) + 1
                ));

        return gameResult;
    }
}
