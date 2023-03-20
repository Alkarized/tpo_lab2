package unit.functions.logarithm;

import dummies.NaturalLogarithmDummy;
import calculator.functions.logarithm.implementations.LogarithmImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LogarithmTest {

    private static LogarithmImp logarithmImp;
    private static double d;

    private static double[] bases;

    @BeforeAll
    static void setupAll() {
        logarithmImp = new LogarithmImp(new NaturalLogarithmDummy());
        logarithmImp.setToLog(true);
        d = 0.001;
        bases = new double[]{2, 3, 10};
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.01, 0.1, 0.5, 1, 1.1, 1.5, 1.9})
    void testLogValidInput(final double value) {
        for (final double base : bases) {
            final double result = logarithmImp.log(value, base, d);
            final double expectedResult = Math.log(value)/Math.log(base);
            Assertions.assertTrue(Math.abs(result - expectedResult) <= d);
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.5, 0, 2})
    void testLogInvalidInput(final double value) {
        final ArithmeticException thrown = Assertions.assertThrows(ArithmeticException.class, () -> logarithmImp.log(value, 2, d));
        Assertions.assertEquals("|x - 1| must be < 1 and x must be > 0 for row to be convergent", thrown.getMessage());
    }
}
