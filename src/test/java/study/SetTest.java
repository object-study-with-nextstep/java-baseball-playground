package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set Collection 요구사항1: Set의 size() 메소드를 활용해 Set의 크기를 확인")
    void setSize_test_expect_equal_size() {
        // given
        // setUp()
        int expect = 3;

        // when
        // then
        assertThat(numbers).hasSize(expect);
    }

    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set Collection 요구사항2: Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    void contain_test_expect_true(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest()
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:false",
            "5:false"
    }, delimiter = ':')
    @DisplayName("Set Collection 요구사항3: 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    void equal_test_compare_csvSource(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }

}
