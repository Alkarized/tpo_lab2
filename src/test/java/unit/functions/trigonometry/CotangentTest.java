package unit.functions.trigonometry;

import calculator.functions.trigonometry.dummies.CosineDummy;
import calculator.functions.trigonometry.dummies.SineDummy;
import calculator.functions.trigonometry.implementations.CotangentImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CotangentTest {
    private static CotangentImp cotangentImp;
    private static double d;


    @BeforeAll
    static void setupAll() {
        final SineDummy sineDummy = new SineDummy();
        cotangentImp = new CotangentImp(sineDummy, new CosineDummy(sineDummy));
        d = 0.001;
    }

    // Тут как и у синуса ограничение на pi * n

    @ParameterizedTest
    @ValueSource(doubles = {-2.889, -2, -1.57, -1, -0.254, 0.254, 1, 1.57, 2, 2.889})
    void testCosecantValidInput(final double value) {
        final double result = cotangentImp.cot(value, d);
        final double expectedResult = 1 / Math.tan(value);
        Assertions.assertTrue(Math.abs(result - expectedResult) <= d);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, 0 , Math.PI, 2 * Math.PI})
    void testCosecantBadInput(final double value) {
        final double result = cotangentImp.cot(value, d);
        final double expectedResult = 1 / Math.tan(value);
        Assertions.assertEquals(expectedResult, result, d);

        // final ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> cosecantImp.csc(value, d));
        // Assertions.assertEquals("x != pi * n, where n is int", thrown.getMessage());
    }
}
