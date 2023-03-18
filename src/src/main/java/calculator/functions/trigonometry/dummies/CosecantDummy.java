package calculator.functions.trigonometry.dummies;

import calculator.functions.trigonometry.implementations.CosecantImp;
import calculator.functions.trigonometry.implementations.SineImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class CosecantDummy extends CosecantImp {

    public CosecantDummy(final SineImp sine) {
        super(sine);
    }

    @Override
    public double csc(final double x, final double d) {
        final double result = 1 / Math.sin(x);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";cscD;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(CosecantDummy.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
