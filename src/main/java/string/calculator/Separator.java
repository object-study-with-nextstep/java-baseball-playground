package string.calculator;

import java.util.Scanner;

public class Separator {
    private String stringExpression;
    private String[] separatedString;

    Separator(String stringExpression){
        this.stringExpression = stringExpression;
    }

    public String[] separate(){
        String delimiter = " ";
        Scanner scanner = new Scanner(this.stringExpression);

        String value = scanner.nextLine();
        this.separatedString = value.split(delimiter);

        return this.separatedString;
    }
}
