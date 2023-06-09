package integration.functions.trigonometry;

import calculator.functions.trigonometry.implementations.CosineImp;
import calculator.functions.trigonometry.implementations.SineImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CosineTest {

    private static CosineImp cosineImp;
    private static double d;

    @BeforeAll
    static void setupAll() {
        cosineImp = new CosineImp(new SineImp());
        d = 0.001;
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.1, 0.5, 1, Math.PI,
            -0.1, -0.5, -1, -Math.PI})
    void testCosValidInput(final double value) {
        final double result = cosineImp.cos(value, d);
        final double expectedResult = Math.cos(value);
        Assertions.assertEquals(expectedResult, result, d*10);
    }
}
