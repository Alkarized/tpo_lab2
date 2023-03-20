package calculator.functions.trigonometry.implementations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

public class CosineImp {

    private final SineImp sine;

    protected boolean toLog;

    public CosineImp(final SineImp sine) {
        this.sine = sine;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }

    public double cos(final double x, final double d) {
        double currentX = x;
        while (currentX - Math.PI * 2 >= -Math.PI) {
            currentX -= Math.PI * 2;
        }
        while (currentX + Math.PI * 2 < Math.PI) {
            currentX += Math.PI * 2;
        }
        int sign = -1;
        if (currentX > -Math.PI / 2 && currentX < Math.PI / 2) {
            sign = 1;
        }
        final double result = sign * Math.sqrt(1 - Math.pow(sine.sin(currentX, d), 2));
        if (toLog) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("log.csv"), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {

                writer.write(x + ";cos;" + result + "\n");
                writer.flush();

            } catch (IOException e) {
                Logger.getLogger(CosineImp.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }

}
