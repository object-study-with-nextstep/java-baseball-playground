package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static baseball.domain.BallStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @DisplayName("[성공] Balls 객체 생성")
    @Test
    void success_create_balls() throws Exception {
        // given / when
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        // then
        assertThat(balls).isInstanceOf(Balls.class);
    }

    @DisplayName("[예외] Balls 객체 생성 - duplicate number")
    @Test
    void failed_create_balls_duplicate_number() throws Exception {
        // given / when / then
        assertThatThrownBy(() -> new Balls(Arrays.asList(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BaseBallErrors.INVALID_LENGTH_BALLS.getExceptionMessage());
    }

    @DisplayName("[성공] 스트라이크")
    @Test
    void success_strike() throws Exception {
        // given
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(1, 1);

        // when
        BallStatus status = answer.play(ball);

        // then
        assertThat(status).isEqualTo(STRIKE);
    }

    @DisplayName("[성공] 볼")
    @Test
    void success_ball() throws Exception {
        // given
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(1, 2);

        // when
        BallStatus status = answer.play(ball);

        // then
        assertThat(status).isEqualTo(BALL);
    }

    @DisplayName("[성공] 아웃")
    @Test
    void success_nothing() throws Exception {
        // given
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ball ball = new Ball(1, 5);

        // when
        BallStatus status = answer.play(ball);

        // then
        assertThat(status).isEqualTo(NOTHING);
    }
}
