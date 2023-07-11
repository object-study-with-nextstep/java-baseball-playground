package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        //given
        //when
        String actual = "abc".replace("b", "d");

        //then
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    @DisplayName("요구사항1: \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void split_test_expect_string_array() {
        //given
        String targetString = "1,2";

        //when
        String[] actual = targetString.split(",");

        //then
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
        assertThat(actual).containsExactly("1", "2");

    }

    @Test
    @DisplayName("요구사항1: \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void split_test_expect_single_string_array() {
        //given
        String targetString = "1";

        //when
        String[] actual = targetString.split(",");

        //then
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1");

    }

    @Test
    @DisplayName("요구사항2: \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void substring_test_expect_removing_brace() {
        //given
        String targetString = "(1,2)";

        //when
        String actual = targetString.substring(1,4);

        //then
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3: \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void charAt_test_expect_getting_index_of_string() {
        //given
        String targetString = "abc";

        //when
        String actual = String.valueOf(targetString.charAt(1));

        //then
        assertThat(actual).isEqualTo("b");
    }

    @Test
    @DisplayName("요구사항3: String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void charAt_test_expect_throwing_StringIndexOutOfBoundsException() {

        assertThatThrownBy(() -> {
            //given
            String targetString = "abc";

            //when
            String actual = String.valueOf(targetString.charAt(5));
        }).isInstanceOf(IndexOutOfBoundsException.class)

                //then
                .hasMessageContaining("String index out of range: 5");
    }
}
