package string.calculator;

import java.util.Scanner;
public class Separator {
    private final String stringExpression;
    private final String DELIMITER;

    Separator(String stringExpression, String delimiter){
        this.stringExpression = stringExpression;
        DELIMITER = delimiter;
    }

    public String[] separate() throws Exception {
        Scanner scanner = new Scanner(this.stringExpression);
        String[] splitStrings = scanner.nextLine().split(DELIMITER);

        validateExpressionOrder(splitStrings);

        return splitStrings;
    }

    private void validateExpressionOrder(String[] strings) throws Exception {
        for (int i = 0; i < strings.length; i++) {
            char baseChar = strings[i].charAt(0);

            if(i == 0 && !Character.isDigit(baseChar)){
                throw new Exception("첫번째는 숫자값이어야 합니다.");
            } else if (i + 1 == strings.length) {
                if(!Character.isDigit(baseChar)){
                    throw new Exception("마지막 문자열은 숫자여야 합니다.");
                }
            } else if(i != 0){
                validateExpressionOrder(strings[i].charAt(0), strings[i + 1].charAt(0));
            }
        }
    }

    private void validateExpressionOrder(char beforeChar, char afterChar) throws Exception {
        if(Character.isDigit(beforeChar) && Character.isDigit(afterChar)){
            throw new Exception("숫자값 뒤에는 연산자가 추가되어야 합니다.");
        } else if (!Character.isDigit(beforeChar) && !Character.isDigit(afterChar)) {
            throw new Exception("연산자 뒤에는 숫자값이 추가되어야 합니다.");
        }
    }
}
