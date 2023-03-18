package calculator;

import calculator.functions.logarithm.implementations.LogarithmImp;
import calculator.functions.trigonometry.implementations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Calculator {

    private boolean toLog;
    private CosineImp cosineImp;
    private SecantImp secantImp;
    private CosecantImp cosecantImp;
    private TangentImp tangentImp;
    private CotangentImp cotangentImp;
    private LogarithmImp logarithmImp;
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
            try {
                Files.newBufferedWriter(Paths.get("log.csv")).write(x + ";function;" + result + "\n");
            } catch (IOException e) {
                Logger.getLogger(Calculator.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }

    public void setCosecantImp(final CosecantImp cosecantImp) {
        this.cosecantImp = cosecantImp;
    }

    public void setCosineImp(final CosineImp cosineImp) {
        this.cosineImp = cosineImp;
    }

    public void setCotangentImp(final CotangentImp cotangentImp) {
        this.cotangentImp = cotangentImp;
    }

    public void setLogarithmImp(final LogarithmImp logarithmImp) {
        this.logarithmImp = logarithmImp;
    }

    public void setSecantImp(final SecantImp secantImp) {
        this.secantImp = secantImp;
    }

    public void setTangentImp(final TangentImp tangentImp) {
        this.tangentImp = tangentImp;
    }
}
