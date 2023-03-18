package calculator.functions.logarithm.implementations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class LogarithmImp{

    private final NaturalLogarithmImp naturalLogarithm;
    protected boolean toLog;

    public LogarithmImp(final NaturalLogarithmImp naturalLogarithm) {
        this.naturalLogarithm = naturalLogarithm;
    }

    public double log(final double x, final double base, final double d) {
        final double result = naturalLogarithm.ln(x, d) / Math.log(base);
        if (toLog) {
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";log_" + base + ";" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(LogarithmImp.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }
}
