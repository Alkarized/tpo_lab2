package calculator.functions.trigonometry.implementations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("log.csv"), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {

                writer.write(x + ";sec;" + result + "\n");
                writer.flush();

            }  catch (IOException ignored) {
            }
        }
        return result;
    }

}
