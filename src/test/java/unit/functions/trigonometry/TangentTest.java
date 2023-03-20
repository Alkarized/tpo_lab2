package unit.functions.trigonometry;

import dummies.CosineDummy;
import dummies.SineDummy;
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
        final SineDummy sineDummy = new SineDummy();
        tangentImp = new TangentImp(sineDummy, new CosineDummy(sineDummy));
        tangentImp.setToLog(true);

        d = 0.001;
    }

    //Де факто тут ограничение на cos (x) != 0 -> x != pi/2 + pi * n;

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -Math.PI - 0.1, -Math.PI + 0.1, -Math.PI/2 + 0.1, -Math.PI/2 - 0.1, 0, 0.1, -0.1,
            Math.PI/2 + 0.1, Math.PI/2 - 0.1, Math.PI + 0.1, Math.PI - 0.1 })
    void testCosecantValidInput(final double value) {
        final double result = tangentImp.tan(value, d);
        final double expectedResult = Math.tan(value);
        Assertions.assertTrue(Math.abs(result - expectedResult) <= d);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI*3/2, -Math.PI/2, Math.PI/2, Math.PI*3/2})
    void testCosecantBadInput(final double value) {
        final double result = tangentImp.tan(value, d);
        final double expectedResult = Math.tan(value);
        Assertions.assertEquals(expectedResult, result, d);

        // final ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> cosecantImp.csc(value, d));
        // Assertions.assertEquals("x != pi * n, where n is int", thrown.getMessage());
    }
}
