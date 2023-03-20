package unit.functions.trigonometry;

import calculator.functions.trigonometry.implementations.SineImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SineTest {

    private static SineImp sineImp;
    private static double d;

    @BeforeAll
    static void setupAll() {
        sineImp = new SineImp();
        d = 0.001;
    }
    // Нет ограничения
    @ParameterizedTest
    @ValueSource(doubles = {0, 0.1, 0.5, 1, Math.PI / 2, Math.PI, Math.PI * 1.5, Math.PI * 2
            -0.1, -0.5, -1, -Math.PI / 2, -Math.PI, -Math.PI * 1.5, -Math.PI * 2})
    void testSinValidInput(final double value) {
        final double result = sineImp.sin(value, d);
        final double expectedResult = Math.sin(value);
        Assertions.assertTrue(Math.abs(result - expectedResult) <= d);
    }
}
