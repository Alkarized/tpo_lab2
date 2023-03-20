package unit.functions.trigonometry;

import calculator.functions.trigonometry.dummies.CosineDummy;
import calculator.functions.trigonometry.dummies.SineDummy;
import calculator.functions.trigonometry.implementations.SecantImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SecantTest {
    private static SecantImp secantImp;
    private static double d;


    @BeforeAll
    static void setupAll() {
        secantImp = new SecantImp(new CosineDummy(new SineDummy()));
        d = 0.001;
    }

    // Ограничения на cos != 0 -> x != Pi/2 + pi * n

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -Math.PI - 0.1, -Math.PI + 0.1, -Math.PI/2 + 0.1, -Math.PI/2 - 0.1, 0, 0.1, -0.1,
            Math.PI/2 + 0.1, Math.PI/2 - 0.1, Math.PI + 0.1, Math.PI - 0.1 })
    void testCosecantValidInput(final double value) {
        final double result = secantImp.sec(value, d);
        final double expectedResult = 1 / Math.cos(value);
        Assertions.assertTrue(Math.abs(result - expectedResult) <= d);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI*3/2, -Math.PI/2, Math.PI/2, Math.PI*3/2})
    void testCosecantBadInput(final double value) {
        final double result = secantImp.sec(value, d);
        final double expectedResult = 1 / Math.cos(value);
        Assertions.assertEquals(expectedResult, result, d);

        // final ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> cosecantImp.csc(value, d));
        // Assertions.assertEquals("x != pi * n, where n is int", thrown.getMessage());
    }
}
