package calculator.functions.trigonometry.dummies;

import calculator.functions.trigonometry.implementations.CosineImp;
import calculator.functions.trigonometry.implementations.SecantImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class SecantDummy extends SecantImp {
    public SecantDummy(final CosineImp cosine) {
        super(cosine);
    }

    @Override
    public double sec(final double x, final double d) {
        final double result = 1 / Math.cos(x);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";secD;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(SecantDummy.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
