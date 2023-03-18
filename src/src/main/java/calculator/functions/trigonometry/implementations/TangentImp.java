package calculator.functions.trigonometry.implementations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class TangentImp {

    private final SineImp sine;
    private final CosineImp cosine;

    protected boolean toLog;

    public TangentImp(final SineImp sine, final CosineImp cosine) {
        this.sine = sine;
        this.cosine = cosine;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }

    public double tan(final double x, final double d) {
        final double result = sine.sin(x, d) / cosine.cos(x, d);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";tan;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(TangentImp.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
