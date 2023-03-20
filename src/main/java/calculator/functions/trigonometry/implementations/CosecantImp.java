package calculator.functions.trigonometry.implementations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

public class CosecantImp {

    private final SineImp sine;
    protected boolean toLog;

    public CosecantImp(final SineImp sine) {
        this.sine = sine;
    }

    public double csc(final double x, final double d) {
        final double result = 1 / sine.sin(x, d);
        if (toLog) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("log.csv"), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {

                writer.write(x + ";csc;" + result + "\n");
                writer.flush();

            } catch (IOException e) {
                Logger.getLogger(CosecantImp.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }

}
