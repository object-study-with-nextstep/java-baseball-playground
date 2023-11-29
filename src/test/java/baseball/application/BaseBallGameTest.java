package baseball.application;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static baseball.domain.BallStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 테스트")
class BaseBallGameTest {
    @DisplayName("[성공] 게임 객체 생성")
    @Test
    void success_game_create() throws Exception {
        // given / when
        BaseBallGame baseBallGame = new BaseBallGame(new Balls(Arrays.asList(1, 2, 3)));

        // then
        assertThat(baseBallGame).isInstanceOf(BaseBallGame.class);
        assertThat(baseBallGame.getAnswerBalls().getBalls()).contains(new Ball(1, 1));
    }

    @DisplayName("[성공] 3 스트라이크")
    @Test
    void success_3strike() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new Balls(Arrays.asList(1, 2, 3)));

        // when
        Map<BallStatus, Integer> resultMap = baseBallGame.playGame(new Balls(Arrays.asList(1, 2, 3)));

        // then
        assertThat(resultMap).containsEntry(STRIKE, 3);
    }

    @DisplayName("[성공] 1 스트라이크 2 볼")
    @Test
    void success_1strike_2ball() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new Balls(Arrays.asList(1, 2, 3)));

        // when
        Map<BallStatus, Integer> resultMap = baseBallGame.playGame(new Balls(Arrays.asList(1, 3, 2)));

        // then
        assertThat(resultMap)
                .containsEntry(STRIKE, 1)
                .containsEntry(BALL, 2);
    }

    @DisplayName("[성공] 3 아웃")
    @Test
    void success_3out() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame(new Balls(Arrays.asList(1, 2, 3)));

        // when
        Map<BallStatus, Integer> resultMap = baseBallGame.playGame(new Balls(Arrays.asList(4, 5, 6)));

        // then
        assertThat(resultMap).containsEntry(NOTHING, 3);
    }
}
