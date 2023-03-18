package calculator.functions.logarithm.dummies;

import calculator.functions.logarithm.implementations.LogarithmImp;
import calculator.functions.logarithm.implementations.NaturalLogarithmImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class LogarithmDummy extends LogarithmImp {

    public LogarithmDummy(final NaturalLogarithmImp naturalLogarithm) {
        super(naturalLogarithm);
    }

    @Override
    public double log(final double x, final double base, final double d) {
        final double result = Math.log(x) / Math.log(base);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";logD_" + base + ";" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(LogarithmDummy.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
