package string.calculator


import spock.lang.Specification

class CalculatorTest extends Specification {

    def "calculator 테스트"() {
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
}