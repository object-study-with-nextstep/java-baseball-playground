package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.domain.BallStatus.*;
import static baseball.domain.BaseBallErrors.OUT_OF_BOUNDARY_POSITION;
import static baseball.domain.BaseBallErrors.OUT_OF_BOUNDARY_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Ball(단일 number 객체) 테스트")
class BallTest {

    @DisplayName("[성공] Ball 객체 생성 테스트")
    @Test
    void success_Ball_create() throws Exception {
        // given / when
        Ball ball = new Ball(1, 9);

        // then
        assertThat(ball).isInstanceOf(Ball.class);
    }

    @DisplayName("[예외] 범위를 벗어난 숫자")
    @Test
    void failed_Ball_create_out_boundary_number() throws Exception {
        // given / when / then
        assertThatThrownBy(() -> new Ball(1, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_BOUNDARY_VALUE.getExceptionMessage());

        assertThatThrownBy(() -> new Ball(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_BOUNDARY_VALUE.getExceptionMessage());
    }

    @DisplayName("[예외] 범위를 벗어난 위치")
    @Test
    void failed_Ball_create_out_boundary_position() throws Exception {
        // given / when / then
        assertThatThrownBy(() -> new Ball(0, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_BOUNDARY_POSITION.getExceptionMessage());

        assertThatThrownBy(() -> new Ball(4, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_BOUNDARY_POSITION.getExceptionMessage());
    }

    @DisplayName("[성공] 스트라이크 테스트")
    @Test
    void success_strike() throws Exception {
        // given
        Ball ball = new Ball(1, 1);

        // when
        BallStatus status = ball.play(new Ball(1, 1));

        // then
        assertThat(status).isEqualTo(STRIKE);
    }

    @DisplayName("[성공] 볼 테스트")
    @Test
    void success_ball() throws Exception {
        // given
        Ball ball = new Ball(1, 1);

        // when
        BallStatus status = ball.play(new Ball(2, 1));

        // then
        assertThat(status).isEqualTo(BALL);
    }

    @DisplayName("[성공] 아웃 테스트")
    @Test
    void success_nothing() throws Exception {
        // given
        Ball ball = new Ball(1, 1);

        // when
        BallStatus status = ball.play(new Ball(1, 2));

        // then
        assertThat(status).isEqualTo(NOTHING);
    }
}
