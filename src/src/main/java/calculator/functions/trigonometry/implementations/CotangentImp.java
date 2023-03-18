package calculator.functions.trigonometry.implementations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class CotangentImp {

    private final SineImp sine;
    private final CosineImp cosine;

    protected boolean toLog;

    public CotangentImp(final SineImp sine, final CosineImp cosine) {
        this.sine = sine;
        this.cosine = cosine;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }

    public double cot(final double x, final double d) {
        final double result = 1 / (sine.sin(x, d) / cosine.cos(x, d));
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";cot;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(CotangentImp.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
