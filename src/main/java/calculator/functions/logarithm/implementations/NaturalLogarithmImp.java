package calculator.functions.logarithm.implementations;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NaturalLogarithmImp {

    protected boolean toLog;

    public double ln(final double x, final double d) {
        if (Math.abs(x - 1) >= 1 || x <= 0) {
            throw new ArithmeticException("|x - 1| must be < 1 and x must be > 0 for row to be convergent");
        }
        double result = 0;
        int sign = 1;
        double newOperand = d + 1;
        int i = 1;
        while (Math.abs(newOperand) >= d * d) {
            newOperand = sign * Math.pow(x - 1, i) / i;
            result += newOperand;
            sign = -sign;
            i += 1;
        }
        if (toLog) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("log.csv"), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {

                writer.write(x + ";ln;" + result + "\n");
                writer.flush();

            } catch (IOException ignored) {
            }
        }
        return result;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }
}
