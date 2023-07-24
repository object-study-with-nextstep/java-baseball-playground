package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
