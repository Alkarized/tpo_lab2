package integration.functions;

import calculator.Calculator;
import calculator.functions.logarithm.implementations.*;
import calculator.functions.trigonometry.implementations.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {
    private static Calculator calculator;
    private static double d;

    @BeforeAll
    static void setupAll() {
        final SineImp sineImp = new SineImp();
        sineImp.setToLog(true);
        final CosineImp cosineImp = new CosineImp(sineImp);
        cosineImp.setToLog(true);
        final SecantImp secantImp = new SecantImp(cosineImp);
        secantImp.setToLog(true);
        final CosecantImp cosecantImp = new CosecantImp(sineImp);
        cosecantImp.setToLog(true);
        final TangentImp tangentImp = new TangentImp(sineImp, cosineImp);
        tangentImp.setToLog(true);
        final CotangentImp cotangentImp = new CotangentImp(sineImp, cosineImp);
        cotangentImp.setToLog(true);
        final NaturalLogarithmImp naturalLogarithmImp = new NaturalLogarithmImp();
        naturalLogarithmImp.setToLog(true);
        final LogarithmImp logarithmImp = new LogarithmImp(naturalLogarithmImp);
        logarithmImp.setToLog(true);
        calculator = new Calculator(cosineImp, secantImp, cosecantImp, tangentImp, cotangentImp, logarithmImp);
        d = 0.001;
    }

    @ParameterizedTest
    @CsvSource(value = {"-4.61238898038469;-1.9875254143297124E9",
            "-3.8;-0.9784137332789241",
            "-3.7;-0.21905850987620443",
            "-3.47;-0.004084936282451552",
            "-3.0;-1.5733260658953836E-5",
            "-2.81;-0.0030844225965445254",
            "-2.5;-0.3524840061336373",
            "-1.6707963267948966;-1.4811745490412688E7",
            "-1.4707963267948965;1.4757012198166324E7",
            "-0.66;0.44819759803302367",
            "-0.5;0.05076684677476234",
            "-0.33;0.0029942725886223155",
            "-0.2;1.2984351527408825E-4",
            "0.5;465.2419784904277",
            "0.9;154.03344514585814",
            "1.1;97.22426906553241",
            "1.5;42.179839664242564",
            "1.6;34.59920726240837",
            }, delimiter = ';')
    void testCalculatorInput(final double value, final double expectedResult) {
        final double result = calculator.function(value, d);
        Assertions.assertEquals(expectedResult, result, d*10);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;NaN",
                        "-1.57079632679; NaN"}, delimiter = ';')
    void testCalculatorNotValidInput(final double value, final double expectedResult) {
        final double result = calculator.function(value, d);
        Assertions.assertEquals(expectedResult, result, d);
    }

}