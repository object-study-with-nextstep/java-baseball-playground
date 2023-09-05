package string.calculator


import spock.lang.Specification

class CalculatorTest extends Specification {

    def "SUCCESS: 정상 계산 테스트"() {
        given:
        String expression = "2 + 3 * 4 / 2"

        Separator separator = new Separator(expression, " ")
        Calculator calculator = new Calculator(separator)

        when:
        int result = calculator.calculate()
        result.println()

        then:
        result == 10
    }

    def "EXCEPTION: 잘못된 표현식 예외 처리 테스트"() {

        Separator separator = new Separator(expression, " ")
        Calculator calculator = new Calculator(separator)

        when:
        calculator.calculate()

        then:
        def exception = thrown(Exception)

        var message = exception.getMessage()
        message == expect

        where:
        expression | expect
        "/ + 3 * 4 / 2" | "첫번째는 숫자값이어야 합니다."
        "2 + 3 3 4 / 2" | "숫자값 뒤에는 연산자가 추가되어야 합니다."
        "2 + 3 * 4 / + 2" | "연산자 뒤에는 숫자값이 추가되어야 합니다."
        "2 + 3 * 4 / 2 -" | "마지막 문자열은 숫자여야 합니다."
    }

}