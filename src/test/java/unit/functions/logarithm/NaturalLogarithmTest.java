package unit.functions.logarithm;

import calculator.functions.logarithm.implementations.NaturalLogarithmImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NaturalLogarithmTest {

    private static NaturalLogarithmImp naturalLogarithmImp;
    private static double d;

    @BeforeAll
    static void setupAll() {
        naturalLogarithmImp = new NaturalLogarithmImp();
        naturalLogarithmImp.setToLog(true);

        d = 0.001;
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.01, 0.1, 0.5, 1, 1.1, 1.5, 1.9})
    void testNaturalLogValidInput(final double value) {
        final double result = naturalLogarithmImp.ln(value, d);
        final double expectedResult = Math.log(value);
        Assertions.assertTrue(Math.abs(result - expectedResult) <= d);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.5, 0, 2})
    void testNaturalLogInvalidInput(final double value) {
        final ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> naturalLogarithmImp.ln(value, d));
        Assertions.assertEquals("|x - 1| must be < 1 and x must be > 0 for row to be convergent", thrown.getMessage());
    }
}
