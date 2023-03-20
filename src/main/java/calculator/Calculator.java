package calculator;

import calculator.functions.logarithm.implementations.LogarithmImp;
import calculator.functions.trigonometry.implementations.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Calculator {

    private boolean toLog;
    final private CosineImp cosineImp;
    final private SecantImp secantImp;
    final private CosecantImp cosecantImp;
    final private TangentImp tangentImp;
    final private CotangentImp cotangentImp;
    final private LogarithmImp logarithmImp;

    public Calculator(final CosineImp cosineImp, final SecantImp secantImp, final CosecantImp cosecantImp, final TangentImp tangentImp, final CotangentImp cotangentImp, final LogarithmImp logarithmImp) {
        this.cosecantImp = cosecantImp;
        this.secantImp = secantImp;
        this.cosineImp = cosineImp;
        this.tangentImp = tangentImp;
        this.cotangentImp = cotangentImp;
        this.logarithmImp = logarithmImp;
    }

    public void setToLog(final boolean toLog) {
        this.toLog = toLog;
    }

    public double function(final double x, final double d) {
        final double result;
        if (x <= 0) {
            result = (Math.pow(Math.pow(secantImp.sec(x, d) / cotangentImp.cot(x, d), 2), 2) * ((secantImp.sec(x, d) + cosineImp.cos(x, d) + tangentImp.tan(x, d)) / cosecantImp.csc(x, d))) / cosecantImp.csc(x, d);
        } else {
            result = Math.pow(Math.pow((Math.pow(logarithmImp.log(x, 3, d), 2) - logarithmImp.log(x, 2, d)) / logarithmImp.log(x, 10, d), 2), 2);
        }
        if (toLog) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("log.csv"), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {

                writer.write(x + ";" + result + "\n");
                writer.flush();

            }  catch (IOException ignored) {
            }
        }
        return result;
    }

}
