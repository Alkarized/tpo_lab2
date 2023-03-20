package unit.functions;

import calculator.Calculator;
import calculator.functions.logarithm.dummies.LogarithmDummy;
import calculator.functions.logarithm.dummies.NaturalLogarithmDummy;
import calculator.functions.trigonometry.dummies.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {
    private static Calculator calculator;
    private static double d;

    @BeforeAll
    static void setupAll() {
        final SineDummy sineDummy = new SineDummy();
        final CosineDummy cosineDummy = new CosineDummy(sineDummy);
        final SecantDummy secantDummy = new SecantDummy(cosineDummy);
        final CosecantDummy cosecantDummy = new CosecantDummy(sineDummy);
        final TangentDummy tangentDummy = new TangentDummy(sineDummy, cosineDummy);
        final CotangentDummy cotangentDummy = new CotangentDummy(sineDummy, cosineDummy);
        final LogarithmDummy logarithmDummy = new LogarithmDummy(new NaturalLogarithmDummy());
        calculator = new Calculator(cosineDummy, secantDummy, cosecantDummy, tangentDummy, cotangentDummy, logarithmDummy);
        d = 0.001;
    }

    // Тут по графику примерно видно такие моменты: у нас функция эквивалентна y = 0, y = kx + b, где  А так же дуги соединяющие y = 0 и y = kx + b
    // при этом у нас симметрия есть, k - ну ооочень маленький коэф,
    // 1 -> NaN
    // pi/2 + pi*k = 0
    //(Симметрия ) (-3pi/2 -> -3.8)(-3.8 -> -3.47)(-3.47 -> -2.81),(-2.81 -> -pi/2 ) | (-pi/2 -> -0.66), (-0.66 -> -0.33), (-0.33 -> 0), (0 -> 1) | (1 -> 1.5), (1.5 -> 2.5), (2.5 -> 4.3), (4.3 -> 6.8), (6.8 -> 12) (12 -> +inf)


    @ParameterizedTest
    @CsvSource(value = {"-4.61238898038469;-1.975031612557273E9",
                    "-3.8;-0.9688025445997948",
                    "-3.7;-0.21905850987620443",
                    "-3.47;-0.004084936282451552",
                    "-3.0;-1.5733260658953836E-5",
                    "-2.81;-0.0030844225965445254",
                    "-2.5;-0.3524840061336373",
                    "-1.6707963267948966;-1.4739117316106489E7",
                    "-1.4707963267948965;1.4739117316106342E7",
                    "-0.66;0.44819759803302367",
                    "-0.5;0.05076684677476234",
                    "-0.33;0.0029942725886223155",
                    "-0.2;1.2984351527408825E-4",
                    "0.5;465.24263002292815",
                    "0.9;154.03344514585814",
                    "1.1;97.22426906553241",
                    "1.5;42.175992553770584",
                    "1.6;34.59702220282328",
                    "-1.57079632679; 0"}, delimiter = ';')
    void testCalculatorInput(final double value, final double expectedResult) {
        final double result = calculator.function(value, d);
        Assertions.assertEquals(expectedResult, result, d*10);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;NaN"}, delimiter = ';')
    void testCalculatorNotValidInput(final double value, final double expectedResult) {
        final double result = calculator.function(value, d);
        Assertions.assertEquals(expectedResult, result, d*10);
    }

}
