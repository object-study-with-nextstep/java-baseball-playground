package string.calculator;

public class Disassembler {
    public static int calculate(String mathExpression) {
        int calculateResult = 0;
        int currentInteger;
        String currentExpression = "";

        String[] integersAndExpressions = mathExpression.split(" ");

        for (String candidate : integersAndExpressions) {
            if (isInteger(candidate)) {
                currentInteger = Integer.parseInt(candidate);
                calculateResult = calculate(calculateResult, currentInteger, currentExpression);
            } else {
                currentExpression = candidate;
            }
        }

        return calculateResult;
    }

    private static int calculate(int calculateResult, int currentInteger, String currentExpression) {
        switch (currentExpression) {
            case "+":
                calculateResult = calculateResult + currentInteger;
                break;
            case "-":
                calculateResult = calculateResult - currentInteger;
                break;
            case "*":
                calculateResult = calculateResult * currentInteger;
                break;
            case "/":
                calculateResult = calculateResult / currentInteger;
                break;
            default:
                calculateResult = currentInteger;
                break;
        }
        return calculateResult;
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
