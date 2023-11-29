package baseball.infrastructure;

import baseball.application.BaseBallGame;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("ReporterTest")
class ReporterTest {

    @DisplayName("1스 1볼 1아웃 리포트")
    @Test
    void reporting() throws Exception {
        // given
        Balls answerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls inputBalls = new Balls(Arrays.asList(1, 4, 2));

        Map<BallStatus, Integer> gameResult = new BaseBallGame(answerBalls)
                .playGame(inputBalls);
        String expectedResult = "1 스트라이크 1 볼 1 아웃";

        // when
        String actualResult = Reporter.report(gameResult);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("3아웃 리포트")
    @Test
    void reporting_3out() throws Exception {
        // given
        Balls answerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls inputBalls = new Balls(Arrays.asList(4, 5, 6));

        Map<BallStatus, Integer> gameResult = new BaseBallGame(answerBalls)
                .playGame(inputBalls);
        String expectedResult = "3 아웃";

        // when
        String actualResult = Reporter.report(gameResult);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("3스 리포트")
    @Test
    void reporting_3strike() throws Exception {
        // given
        Balls answerBalls = new Balls(Arrays.asList(1, 2, 3));
        Balls inputBalls = new Balls(Arrays.asList(1, 2, 3));

        Map<BallStatus, Integer> gameResult = new BaseBallGame(answerBalls)
                .playGame(inputBalls);
        String expectedResult = "3 스트라이크";

        // when
        String actualResult = Reporter.report(gameResult);

        // then
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
