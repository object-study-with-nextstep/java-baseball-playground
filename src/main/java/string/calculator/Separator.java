package string.calculator;

import java.util.Scanner;

public class Separator {
    private final String stringExpression;
    private final String DELIMITER;

    Separator(String stringExpression, String delimiter){
        this.stringExpression = stringExpression;
        DELIMITER = delimiter;
    }

    public String[] separate(){
        Scanner scanner = new Scanner(this.stringExpression);
        String[] splitStrings = scanner.nextLine().split(DELIMITER);
        try {
            validateExpressionOrder(splitStrings);
        } catch (Exception e){
            return null;
        }
        return splitStrings;
    }

    private void validateExpressionForCalculate(char targetChar) throws Exception {
        if(!Character.isDigit(targetChar) || OperatorType.getOperatorTypeByValue(targetChar) == null){
            throw new Exception("숫자값 뒤에는 연산자가 추가되어야 합니다.");
        }
    }

    private void validateExpressionOrder(String[] strings) throws Exception {
        for (int i = 0; i < strings.length; i++) {
            char baseChar = strings[i].charAt(i);
            validateExpressionForCalculate(baseChar);

            if(i == 0 && !Character.isDigit(baseChar)){
                throw new Exception("첫번째는 숫자값이어야 합니다.");
            } else if(i != 0){
                validateExpressionOrder(strings[i].charAt(i), strings[i].charAt(i + 1));
            }
        }
    }

    private void validateExpressionOrder(char beforeChar, char nextChar) throws Exception {
        if(Character.isDigit(beforeChar) && Character.isDigit(nextChar)){
            throw new Exception("숫자값 뒤에는 연산자가 추가되어야 합니다.");
        } else if (!Character.isDigit(beforeChar) && Character.isDigit(nextChar)) {
            throw new Exception("연산자 뒤에는 숫자값이 추가되어야 합니다.");
        }
    }
}
