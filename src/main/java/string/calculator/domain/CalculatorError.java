package string.calculator.domain;

public enum CalculatorError {
    NUMBER_CASTING_EXCEPTION("지원하지 않는 숫자 형태입니다.(정수형만 가능)"),
    EXPRESSION_CASTING_EXCEPTION("지원하지 않는 수식입니다.(+, -, *, / 만 가능)"),
    DISASSEMBLE_EXCEPTION("수식 split 중 오류 발생"),
    ;

    private String exceptionMessage;

    CalculatorError(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
