package classes;

import classes.irasai.IslaiduIrasas;
import classes.irasai.PajamuIrasas;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public final class FileProcessor {
    Biudzetas budget = Biudzetas.object;

    public void fileWriter() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("duomenys.CSV"));
            budget.gautiPajamuIrasus().forEach(pajamuIrasas -> {
                try {
                    writer.write(budget.getCSVLine(pajamuIrasas)+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            budget.gautiIslaiduIrasus().forEach(islaiduIrasas -> {
                try {
                    writer.write(budget.getCSVLine(islaiduIrasas)+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    public List<String> fileReader() {
        try {
            var reader = new BufferedReader(new FileReader("duomenys.CSV"));
            List<String> lines = reader.lines().toList();
            reader.close();
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
