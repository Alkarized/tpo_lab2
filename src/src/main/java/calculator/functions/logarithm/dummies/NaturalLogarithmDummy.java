package calculator.functions.logarithm.dummies;

import calculator.functions.logarithm.implementations.NaturalLogarithmImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class NaturalLogarithmDummy extends NaturalLogarithmImp {

    @Override
    public double ln(final double x, final double d) {
        if (Math.abs(x - 1) >= 1 || x <= 0) {
            throw new ArithmeticException("|x - 1| must be < 1 and x must be > 0 for row to be convergent");
        }
        final double result = Math.log(x);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";lnD;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(NaturalLogarithmDummy.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
