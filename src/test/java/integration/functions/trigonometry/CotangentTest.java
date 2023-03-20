package integration.functions.trigonometry;

import calculator.functions.trigonometry.implementations.CosineImp;
import calculator.functions.trigonometry.implementations.CotangentImp;
import calculator.functions.trigonometry.implementations.SineImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CotangentTest {
    private static CotangentImp cotangentImp;
    private static double d;


    @BeforeAll
    static void setupAll() {
        final SineImp sineImp = new SineImp();
        cotangentImp = new CotangentImp(sineImp, new CosineImp(sineImp));
        d = 0.001;
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2.889, -2, -1, -0.254, 0.254, 1, 2, 2.889})
    void testCosecantValidInput(final double value) {
        final double result = cotangentImp.cot(value, d);
        final double expectedResult = 1 / Math.tan(value);
        Assertions.assertEquals(expectedResult, result, d*10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2 * Math.PI, 0, 2 * Math.PI})
    void testCosecantBadInput(final double value) {
        final double result = cotangentImp.cot(value, d);
        final double expectedResult = Double.POSITIVE_INFINITY;
        Assertions.assertEquals(expectedResult, result, d);

        // final ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> cosecantImp.csc(value, d));
        // Assertions.assertEquals("x != pi * n, where n is int", thrown.getMessage());
    }
}
