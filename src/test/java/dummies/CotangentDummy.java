package dummies;

import calculator.functions.trigonometry.implementations.CosineImp;
import calculator.functions.trigonometry.implementations.CotangentImp;
import calculator.functions.trigonometry.implementations.SineImp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

public class CotangentDummy extends CotangentImp {
    public CotangentDummy(final SineImp sine, final CosineImp cosine) {
        super(sine, cosine);
    }

    @Override
    public double cot(final double x, final double d) {
        final double result = Math.cos(x) / Math.sin(x);
        if (toLog) {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("log.csv"), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {

                writer.write(x + ";cotD;" + result + "\n");
                writer.flush();

            } catch (IOException e) {
                Logger.getLogger(CotangentDummy.class.getName()).fine("Could not log: IOException");
            }
        }
        return result;
    }
}
