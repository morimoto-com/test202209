import base.dto.T001Form;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;

@TestInstance(PER_CLASS)
//@TestInstance(PER_METHOD) ・・・ デフォルト
class SampleTest {

    @Nested
    class inputCheck {
        @Test
        void test1() {
            assertEquals(2, 1 + 1);
        }
        @Test
        void test2() {
            assertEquals(2, 1 + 1);
        }
    }

    @Nested
    class outputCheck {
        @Test
        void test1() {
            assertEquals(2, 1 + 1);
        }
        @Test
        void test2() {
            assertEquals(2, 1 + 1);
        }
    }

    @BeforeEach
    void beforeEach() {
        // 各テストメソッド実行前に実行される
    }

    @AfterEach
    void afterEach() {
        // 各テストメソッド実行後に実行される
    }

    @BeforeAll
    void beforeAll() {
        // 現在のクラスの実行前に１度だけ実行される
    }

    @AfterAll
    void afterAll() {
        // 現在のクラスの実行後に１度だけ実行される
    }

    @Test
    @DisplayName("サンプルテスト")
    void test() {
        assertEquals(2, 1 + 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"soccer", "tennis", "baseball"})
    void parameter1(String params) {
        assertTrue(params.contains("i"));
    }

    @ParameterizedTest
    @CsvSource({
            "12345, 0",
            "1234, 1"
    })
    void parameter2(ArgumentsAccessor arguments) {
        assertTrue(arguments.getString(0).length() <= 5);
        assertTrue(arguments.getString(1).length() <= 1);
    }

    @RepeatedTest(5)
    void repeated() {
        Random rand = new Random();
        int num = rand.nextInt(10);
        assertTrue(num < 10);
    }

    @TestFactory
    List<DynamicTest> dynamicTest1() {
        List<DynamicTest> list = new ArrayList<>();
        list.add(dynamicTest("test1", () -> assertEquals(2, 2 + 1)));
        System.out.println("test1 end");
        list.add(dynamicTest("test2", () -> assertEquals(2, 1 + 1)));
        System.out.println("test2 end");
        return list;
    }


}