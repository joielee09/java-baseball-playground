package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("예시코드")
    void example() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    @Test
    @DisplayName("split 메소드 구현")
    void test1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
    }

    // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환
    @Test
    @DisplayName("substring 메소드 구현")
    void test2() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현
    // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현
    // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    @Test
    @DisplayName("charAt 구현")
    void test3() {
        String str = "abc";

        Character index0 = str.charAt(0);
        Character index1 = str.charAt(1);
        Character index2 = str.charAt(2);
        assertThat(index0).isEqualTo('a');
        assertThat(index1).isEqualTo('b');
        assertThat(index2).isEqualTo('c');
    }
    
    
    @Test
    @DisplayName("예외처리하기")
    void test4() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(4);
        }).hasMessage("String index out of range: 4");
    }
}
