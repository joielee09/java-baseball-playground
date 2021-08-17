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

    // Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트
    @Test
    @DisplayName("set size 테스트")
    void test1() {
        Integer result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    // Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트
    // JUnit의 ParameterizedTest를 활용해 중복 코드를 제거
    @Test
    @DisplayName("Set contains() 테스트")
    void test2() {
        Set testSet = numbers;
        assertThat(testSet).contains(1);
        assertThat(testSet).contains(2);
        assertThat(testSet).contains(3);
    }
    @ParameterizedTest
    @DisplayName("ParameterizedTest 테스트")
    @ValueSource(ints={1,2,3})
    void test3(int number) {
        Set testSet = numbers;
        assertThat(testSet).contains(number);
    }

    // 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현
    // 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현
    @ParameterizedTest
    @DisplayName("CsvSource 테스트")
    @CsvSource(value={"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void test4(Integer input, String expected){
        Boolean result = numbers.contains(input);
        assertThat(String.valueOf(result)).isEqualTo(expected);
    }
}
