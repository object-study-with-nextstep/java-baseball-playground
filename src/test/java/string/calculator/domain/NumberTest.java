package string.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @DisplayName("[성공검증] 숫자형태의 String으로 number 생성")
    @ParameterizedTest
    @CsvSource(value = {
            "3:3",
            "1:1",
            "156:156",
            "475:475",
            "-456:-456",
            "-11:-11",
    }, delimiter = ':')
    void success_createNumber(String numberString, int intNumber) {
        // when
        Number number = new Number(numberString);

        // then
        assertThat(number).isInstanceOf(Number.class);
        assertThat(number.getNumber()).isEqualTo(intNumber);
    }

    @DisplayName("[실패검증] 숫자형태가 아닌 String을 number 로 생성할 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void failed_createNumber_Not_NumberFormat(String numberString) {
        // when / then
        assertThatThrownBy(() -> new Number(numberString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CalculatorError.NUMBER_CASTING_EXCEPTION.getExceptionMessage());
    }
}
