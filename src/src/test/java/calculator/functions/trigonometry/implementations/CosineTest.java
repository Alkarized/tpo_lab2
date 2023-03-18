package calculator.functions.trigonometry.implementations;

import calculator.functions.trigonometry.dummies.SineDummy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CosineTest {

    private static CosineImp cosineImp;
    private static double d;

    @BeforeAll
    static void setupAll() {
        cosineImp = new CosineImp(new SineDummy());
        d = 0.001;
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, 0.1, 0.5, 1, Math.PI / 2, Math.PI, Math.PI * 1.5,
            -0.1, -0.5, -1, -Math.PI / 2, -Math.PI, -Math.PI * 1.5})
    void testCosValidInput(final double value) {
        final double result = cosineImp.cos(value, d);
        final double expectedResult = Math.cos(value);
        Assertions.assertTrue(Math.abs(result - expectedResult) <= d);
    }
}
