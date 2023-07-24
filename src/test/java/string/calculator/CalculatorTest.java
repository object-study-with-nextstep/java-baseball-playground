package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("[성공] 기본 케이스 : 2 + 3 * 4 / 2 = 10")
    @Test
    void success_complex_formula() {
        // given
        String mathExpression = "2 + 3 * 4 / 2";
        int expected = 10;

        // when
        int result = Disassembler.calculate(mathExpression);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("[성공] 두 숫자의 더하는 수식을 입력받아 결과를 반환한다.")
    @Test
    void success_add() {
        // given
        String mathExpression = "2 + 3";
        int expected = 5;

        // when
        int result = Disassembler.calculate(mathExpression);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("[성공] 두 숫자의 빼기 수식을 입력받아 결과를 반환한다.")
    @Test
    void success_subtract() {
        // given
        String mathExpression = "2 - 3";
        int expected = -1;

        // when
        int result = Disassembler.calculate(mathExpression);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("[성공] 두 숫자를 곱하는 수식을 입력받아 결과를 반환한다.")
    @Test
    void success_multiply() {
        // given
        String mathExpression = "2 * 3";
        int expected = 6;

        // when
        int result = Disassembler.calculate(mathExpression);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("[성공] 두 숫자를 나누는 수식을 입력받아 결과를 반환한다.")
    @Test
    void success_divide() {
        // given
        String mathExpression = "4 / 2";
        int expected = 2;

        // when
        int result = Disassembler.calculate(mathExpression);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("[실패] 입력에 수식이 없는 경우 예외 검증 - 아예 수식이 없는 경우")
    @Test
    void failure_without_expression_1() {
        // given
        String mathExpression = "4 2";

        // when / then
        assertThatThrownBy(() -> Disassembler.calculate(mathExpression))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("[실패] 입력에 수식이 없는 경우 예외 검증 - 중간에 없는 경우")
    @Test
    void failure_without_expression_2() {
        // given
        String mathExpression = "4 - 2 3";

        // when / then
        assertThatThrownBy(() -> Disassembler.calculate(mathExpression))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("[실패] 수식이 여러번 나온 경우")
    @Test
    void failure_without_expression_3() {
        // given
        String mathExpression = "4 - /";

        // when / then
        assertThatThrownBy(() -> Disassembler.calculate(mathExpression))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("[실패] 입력값에 숫자로 시작하지 않는 경우 - 처음부터 숫자가 누락된 경우")
    @Test
    void failure_without_number_1() {
        // given
        String mathExpression = "- 2";

        // when / then
        assertThatThrownBy(() -> Disassembler.calculate(mathExpression))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("[실패] 중간에 숫자가 누락된 경우")
    @Test
    void failure_without_number_2() {
        // given
        String mathExpression = "2 -";

        // when / then
        assertThatThrownBy(() -> Disassembler.calculate(mathExpression))
                .isInstanceOf(IllegalStateException.class);
    }
}
