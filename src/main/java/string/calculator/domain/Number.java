package string.calculator.domain;

import static string.calculator.domain.CalculatorError.*;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String numberString) {
        validationNumberString(numberString);

        this.number = Integer.parseInt(numberString);
    }

    private void validationNumberString(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NUMBER_CASTING_EXCEPTION.getExceptionMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
