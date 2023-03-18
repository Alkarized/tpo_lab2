package calculator.functions.trigonometry.dummies;

import calculator.functions.trigonometry.implementations.CosineImp;
import calculator.functions.trigonometry.implementations.SineImp;
import calculator.functions.trigonometry.implementations.TangentImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class TangentDummy extends TangentImp {
    public TangentDummy(final SineImp sine, final CosineImp cosine) {
        super(sine, cosine);
    }

    @Override
    public double tan(final double x, final double d) {
        final double result = Math.sin(x) / Math.cos(x);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";tanD;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(TangentDummy.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
