package dummies;

import calculator.functions.trigonometry.implementations.CosineImp;
import calculator.functions.trigonometry.implementations.SineImp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

public class CosineDummy extends CosineImp {

    public CosineDummy(final SineImp sine) {
        super(sine);
    }

    @Override
    public double cos(final double x, final double d) {
        final double result = Math.cos(x);
        if (toLog) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("log.csv"), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {

                writer.write(x + ";cosD;" + result + "\n");
                writer.flush();

            } catch (IOException e) {
                Logger.getLogger(CosineDummy.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }

}
