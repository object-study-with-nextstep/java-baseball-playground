package string.calculator

import spock.lang.Specification

class SeparatorTest extends Specification{

    def "성공: separator생성 및 쪼갠 문자열의 크기가 동일한지 테스트"(){
        given:
        String expression = "2 + 3 * 4 / 2"

        when:
        Separator separator = new Separator(expression)

        then:
        separator.separate().size() == 7
    }
}
