package calculator.functions.trigonometry.implementations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SineImp {

    protected boolean toLog;

    private long factorial(final int x) {
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
            if (result < 0) {
                throw new ArithmeticException("Long overflow - cannot count factorial of this number");
            }
        }
        return result;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }

    public double sin(final double x, final double d) {
        double currentX = x;
        while (currentX - Math.PI * 2 >= -Math.PI) {
            currentX -= Math.PI * 2;
        }
        while (currentX + Math.PI * 2 < Math.PI) {
            currentX += Math.PI * 2;
        }
        double result = 0;
        int sign = 1;
        double newOperand = d + 1;
        int i = 1;
        while (Math.abs(newOperand) >= d) {
            newOperand = sign * Math.pow(currentX, i) / factorial(i);
            result += newOperand;
            sign = -sign;
            i += 2;
        }
        if (toLog) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("log.csv"), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {

                writer.write(x + ";sin;" + result + "\n");
                writer.flush();

            } catch (IOException ignored) {
            }
        }
        return result;
    }
}
