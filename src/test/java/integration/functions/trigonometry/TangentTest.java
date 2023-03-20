package integration.functions.trigonometry;

import calculator.functions.trigonometry.implementations.CosineImp;
import calculator.functions.trigonometry.implementations.SineImp;
import calculator.functions.trigonometry.implementations.TangentImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TangentTest {
    private static TangentImp tangentImp;
    private static double d;

    @BeforeAll
    static void setupAll() {
        final SineImp sineImp = new SineImp();
        tangentImp = new TangentImp(sineImp, new CosineImp(sineImp));
        d = 0.001;
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -Math.PI - 0.1, -Math.PI + 0.1, -Math.PI/2 + 0.1, -Math.PI/2 - 0.1, 0, 0.1, -0.1,
            Math.PI/2 + 0.1, Math.PI/2 - 0.1, Math.PI + 0.1, Math.PI - 0.1 })
    void testCosecantValidInput(final double value) {
        final double result = tangentImp.tan(value, d);
        final double expectedResult = Math.tan(value);
        Assertions.assertEquals(expectedResult, result, d*10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI*3/2, -Math.PI/2, Math.PI/2, Math.PI*3/2})
    void testCosecantBadInput(final double value) {
        final double result = tangentImp.tan(value, d);
        final double expectedResult = Double.NaN;
        Assertions.assertEquals(expectedResult, result, d);

        // final ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> cosecantImp.csc(value, d));
        // Assertions.assertEquals("x != pi * n, where n is int", thrown.getMessage());
    }
}
