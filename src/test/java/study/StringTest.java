package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * 요구사항 1
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     * 힌트
     * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
     * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
     */
    @DisplayName("요구사항1 - 1,2 split")
    @Test
    void split_test1() {
        // given
        String splitCandidate = "1,2";

        // when
        String[] splitResult = splitCandidate.split(",");

        // then
        assertThat(splitResult)
                .contains("1")
                .contains("2")
                .containsExactly("1", "2");
    }

    @DisplayName("요구사항1 - 1 split")
    @Test
    void split_test2() {
        // given
        String splitCandidate = "1";

        // when
        String[] splitResult = splitCandidate.split(",");

        // then
        assertThat(splitResult)
                .contains("1")
                .containsExactly("1");
    }

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @DisplayName("요구사항2 - substring")
    @Test
    void substring() {
        // given
        String substringCandidate = "(1,2)";

        // when
        int beginOffset = 1;
        int beginIndex = substringCandidate.indexOf("(") + beginOffset;
        int endIndex = substringCandidate.indexOf(")");
        String substring = substringCandidate.substring(beginIndex, endIndex);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    /**
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @DisplayName("요구사항3 - charAt 활용")
    @Test
    void charAt_test1() {
        // given
        String charAtCandidate = "abc";

        // when / then
        assertThat(charAtCandidate.charAt(0)).isEqualTo('a');
        assertThat(charAtCandidate.charAt(1)).isEqualTo('b');
        assertThat(charAtCandidate.charAt(2)).isEqualTo('c');
    }

    @DisplayName("요구사항3 - 문자의 위치값을 벗어난 경우")
    @Test
    void charAt_test2() {
        // given
        String charAtCandidate = "abc";

        // when / then
        assertThatThrownBy(() -> charAtCandidate.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4")
                .hasMessageMatching("String index out of range: \\d+");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> charAtCandidate.charAt(6))
                .withMessageContaining("String index out of range: 6")
                .withMessageMatching("String index out of range: \\d+");
    }
}
