package calculator.functions.trigonometry.dummies;

import calculator.functions.trigonometry.implementations.SineImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class SineDummy extends SineImp {

    @Override
    public double sin(final double x, final double d) {
        final double result = Math.sin(x);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";sinD;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(SineDummy.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
