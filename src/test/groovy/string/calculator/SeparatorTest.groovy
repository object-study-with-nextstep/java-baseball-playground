package string.calculator

import spock.lang.Specification

class SeparatorTest extends Specification{

    def "SUCCESS: 문자열 모두 쪼개기"() {
        setup:
        String expression = "2 + 3 * 4 / 2"
        String delimiter = " "
        Separator separator = new Separator(expression, delimiter)

        when:
        String[] result = separator.separate()
        println(result)
        println(result.size())

        then:
        result.size() > 0
    }

    def "nextInt 테스트"() {
        setup:
        String expression = "2 + 3 * 4 / 2"

        when:
        Scanner scanner = new Scanner(expression)
        var total = 0;

        while(scanner.hasNext()){
            total += scanner.nextInt()
        }

        then:
        total == 11
    }
}
