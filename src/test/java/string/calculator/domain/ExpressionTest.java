package string.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionTest {
    @DisplayName("[성공검증] 지원하는 수식 문자열을 입력받아 Expression 객체 생성")
    @ParameterizedTest
    @CsvSource(value = {
            "+:+",
            "-:-",
            "*:*",
            "/:/",
    }, delimiter = ':')
    void success_createExpression(String expressionString, char expressionChar) {
        Expression expression = new Expression(expressionString);

        assertThat(expression).isInstanceOf(Expression.class);
        assertThat(expression.getExpression()).isEqualTo(expressionChar);
    }

    @DisplayName("[실패검증] 지원하지 않는 수식 문자열을 입력받아 Expression 객체 생성시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"3", "1", "156", "475", "-1", "-2",})
    void failed_createExpression_Not_ExpressionFormat(String expressionString) {
        // when / then
        assertThatThrownBy(() -> new Expression(expressionString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CalculatorError.EXPRESSION_CASTING_EXCEPTION.getExceptionMessage());
    }
}