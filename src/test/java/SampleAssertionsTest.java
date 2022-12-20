import base.dto.T001Form;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

class SampleAssertionsTest {

    @Test
    void standardAssertions() {
        assertEquals(2, 2);
    }

    @Test
    void groupedAssertions() {
        T001Form form = new T001Form("John", "Doe");
        assertAll("任意のグループ名（テスト失敗時に出力されます）",
                () -> assertEquals("John", form.getText1()),
                () -> assertEquals("Doe1", form.getText2())
        );
    }
    @Test
    void testOutOfBounds() {
        List<Object> it = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> it.get(1));
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(2), () -> {
            // ２秒以内に処理が終わったらこのアサーションは成功する。
        });
    }

    @Test
    void timeoutExceeded() {
        assertTimeout(ofMillis(10), () -> {
            // この処理は100ミリかかるので失敗する。
            Thread.sleep(100);
        });
    }

    @Test
    void trueAssertion() {
        assertTrue("abc".length() > 1);
    }

    @Test
    void falseAssertion() {
        assertFalse("abc".length() < 1);
    }

    @Test
    void array() {
        int[] expected = { 1, 2, 3 };
        int[] actual   = { 1, 2, 3 };
        assertArrayEquals(expected, actual);
    }

    @Test
    void sameAssertion() {
        List<String> expected = new ArrayList<>();
        List<String> actual = expected;
        assertSame(expected, actual);
    }

    @Test
    void notSameAssertion() {
        List<String> expected = new ArrayList<>();
        List<String> actual = new ArrayList<>(expected);
        assertNotSame(expected, actual);
    }

    @Test
    void testOk() {
        List<String> it = Arrays.asList("a", "b", "c");
        assertDoesNotThrow(() -> it.get(1));
    }
}