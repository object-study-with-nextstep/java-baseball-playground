package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("[성공] 기본 케이스 : 2 + 3 * 4 / 2 = 10")
    @Test
    void success_complex_formula() {
        int result = Disassembler.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }
    @DisplayName("[성공] 두 숫자의 더하는 수식을 입력받아 결과를 반환한다.")
    @Test
    void success_add() {
        int result = Disassembler.calculate("2 + 3");

        assertThat(result).isEqualTo(5);
    }

    @DisplayName("[성공] 두 숫자의 빼기 수식을 입력받아 결과를 반환한다.")
    @Test
    void success_subtract() {
        int result = Disassembler.calculate("2 - 3");

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("[성공] 두 숫자를 곱하는 수식을 입력받아 결과를 반환한다.")
    @Test
    void success_multiply() {
        int result = Disassembler.calculate("2 * 3");

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("[성공] 두 숫자를 나누는 수식을 입력받아 결과를 반환한다.")
    @Test
    void success_divide() {
        int result = Disassembler.calculate("4 / 2");

        assertThat(result).isEqualTo(2);
    }
}
