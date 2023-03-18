package calculator.functions.trigonometry.implementations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class SecantImp {

    private final CosineImp cosine;

    protected boolean toLog;

    public SecantImp(final CosineImp cosine) {
        this.cosine = cosine;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }

    public double sec(final double x, final double d) {
        final double result = 1 / cosine.cos(x, d);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";sec;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(SecantImp.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }

}
