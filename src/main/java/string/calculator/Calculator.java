package string.calculator;

import string.calculator.domain.Disassembler;
import string.calculator.domain.Expression;
import string.calculator.domain.Number;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private Calculator() {
    }

    public static int calculate(String mathExpression) {
        Queue<Number> numbers = new LinkedList<>();
        Queue<Expression> expressions = new LinkedList<>();

        Disassembler.disassemble(numbers, expressions, mathExpression); // numbers, expressions 생성

        return calculate(numbers, expressions);
    }

    private static int calculate(Queue<Number> numbers, Queue<Expression> expressions) {
        int calculateResult = 0;
        Number preNumber = numbers.poll();
        Number postNumber = numbers.poll();
        for (Expression expression : expressions) {
            calculateResult = calculate(preNumber, postNumber, expression);

            preNumber = new Number(calculateResult);
            postNumber = numbers.poll();
        }
        return calculateResult;
    }

    private static int calculate(Number preNumber, Number postNumber, Expression expression) {
        int calculateResult = 0;

        switch (expression.getExpression()) {
            case '+':
                calculateResult = preNumber.getNumber() + postNumber.getNumber();
                break;
            case '-':
                calculateResult = preNumber.getNumber() - postNumber.getNumber();
                break;
            case '*':
                calculateResult = preNumber.getNumber() * postNumber.getNumber();
                break;
            case '/':
                calculateResult = preNumber.getNumber() / postNumber.getNumber();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + expression.getExpression());
        }

        return calculateResult;
    }
}
