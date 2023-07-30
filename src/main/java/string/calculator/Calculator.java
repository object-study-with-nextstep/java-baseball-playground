package string.calculator;

public class Calculator {
    private Separator separator;
    private int result;
    Calculator(Separator separator){
        this.separator = separator;
    }
    public int calculate(String expression){
        separator = new Separator(expression);

        String[] separatedString = separator.separate();;

        return this.result;
    }

    private void resolve(String separatedString){
        this.result = 1;
    }
}
