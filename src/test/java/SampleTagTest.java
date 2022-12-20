import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@Tag("tag1")
class SampleTagTest {

    @Nested
    class inputCheck {
        @Test
        @Tag("tagMethod1")
        void test1() {
            assertEquals(2, 1 + 1);
        }
        @Test
        void test2() {
            assertEquals(2, 1 + 1);
        }
    }

}