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
    @ValueSource(doubles = {-2.889, -2, -1.57, -1, -0.254, 0.254, 1, 1.57, 2, 2.889})
    void testCosecantValidInput(final double value) {
        final double result = cotangentImp.cot(value, d);
        final double expectedResult = 1 / Math.tan(value);
        Assertions.assertTrue(Math.abs(result - expectedResult) <= d*10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, 0 , Math.PI, 2 * Math.PI})
    void testCosecantBadInput(final double value) {
        final double result = cotangentImp.cot(value, d);
        final double expectedResult = Double.NaN;
        Assertions.assertEquals(expectedResult, result, d);

        // final ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> cosecantImp.csc(value, d));
        // Assertions.assertEquals("x != pi * n, where n is int", thrown.getMessage());
    }
}
