package string.calculator;

import java.util.Stack;

public class Calculator {
    private final Separator separator;

    Calculator(Separator separator){
        this.separator = separator;
    }
    public int calculate() throws Exception {
        String[] separatedString = separator.separate();

        return calculate(separatedString);
    }

    private int calculate(String[] input){
        Stack<Integer> stack = new Stack<>();
        char operator = OperatorType.ADDITION.getValue();
        int index = 0;

        for (String string : input) {
            int number = 0;

            char splitChar = string.charAt(0);

            if (Character.isDigit(splitChar) && index == 0) {
                number = Character.getNumericValue(splitChar);
                stack.push(number);

            } else if (!Character.isDigit(splitChar)) {
                operator = splitChar;

            } else if(Character.isDigit(splitChar) && index != 0){
                number = Character.getNumericValue(splitChar);
                calculate(stack, operator, number);
            }

            index++;
        }

        int result = 0;
        if(input.length == index){
            result += stack.pop();
        }

        return result;
    }

    private void calculate(Stack<Integer> stack, char operator, int number) {
        if (operator == OperatorType.ADDITION.getValue()) {
            stack.push(stack.pop() + number);
        } else if (operator == OperatorType.SUBTRACTION.getValue()) {
            stack.push(stack.pop() - number);
        } else if (operator == OperatorType.MULTIPLICATION.getValue()) {
            stack.push(stack.pop() * number);
        } else if (operator == OperatorType.DIVISION.getValue()) {
            stack.push(stack.pop() / number);
        }
    }
}
