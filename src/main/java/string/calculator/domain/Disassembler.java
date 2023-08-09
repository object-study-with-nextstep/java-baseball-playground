package string.calculator.domain;

import java.util.Queue;

public class Disassembler {
    private static final int ODD_NUMBER = 1;
    private static final int EVEN_NUMBER = 0;
    private static final int DIVIDER = 2;

    public static void disassemble(Queue<Number> numbers, Queue<Expression> expressions, String mathExpression) {
        String[] integersAndExpressions = mathExpression.split(" ");

        for (int index = 0; index < integersAndExpressions.length; index++) {
            assignNumber(index, numbers, integersAndExpressions[index]);
            assignExpression(index, expressions, integersAndExpressions[index]);
        }

        validationMathExpression(numbers, expressions);
    }

    private static void validationMathExpression(Queue<Number> numbers, Queue<Expression> expressions) {
        if (numbers.size() != expressions.size() + 1) {
            throw new IllegalStateException(CalculatorError.DISASSEMBLE_EXCEPTION.getExceptionMessage());
        }
    }

    private static void assignExpression(int index, Queue<Expression> expressions, String integersAndExpression) {
        if (index % DIVIDER == ODD_NUMBER) {
            expressions.add(new Expression(integersAndExpression));
        }

    }

    private static void assignNumber(int index, Queue<Number> numbers, String integersAndExpression) {
        if (index % DIVIDER == EVEN_NUMBER) {
            numbers.add(new Number(integersAndExpression));
        }
    }
}
