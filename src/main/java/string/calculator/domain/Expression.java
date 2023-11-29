package string.calculator.domain;

import static string.calculator.domain.CalculatorError.*;

public class Expression {
    private final char expression;

    public Expression(String expressionString) {
        validateExpressionString(expressionString);

        this.expression = expressionString.toCharArray()[0];
    }

    private void validateExpressionString(String expressionString) {
        switch (expressionString) {
            case "+":
            case "-":
            case "*":
            case "/":
                break;
            default:
                throw new IllegalArgumentException(EXPRESSION_CASTING_EXCEPTION.getExceptionMessage());
        }
    }

    public char getExpression() {
        return expression;
    }
}
