package string.calculator;

public enum OperatorType {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char value;

    OperatorType(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static OperatorType getOperatorTypeByValue(char value){
        for(OperatorType operatorType : OperatorType.values()){
            if(operatorType.value == value){
                return operatorType;
            }
        }
        return null;
    }
}
