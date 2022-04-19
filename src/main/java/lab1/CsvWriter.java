package lab1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CsvWriter {
    private static final String SAMPLE_CSV_FILE = "employees.csv";
    public static void main(String[] args) {

        try(
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE), StandardOpenOption.CREATE_NEW);
                CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, CSVFormat.DEFAULT
                        .withHeader("id", "first_name", "last_name", "email"))
        ){
            csvPrinter.printRecord("100", "Steven", "King", "SKING");
            csvPrinter.printRecord("101", "Neena", "Kochar", "NKOCHAR");
            csvPrinter.printRecord("102", "Lex", "De Haan", "LDEHAAN");
            csvPrinter.printRecord("103", "Alexander", "Hunold", "AHUNOLD");
            csvPrinter.printRecord("104", "Bruce", "Ernst", "BERNST");
            csvPrinter.printRecord("105", "Daniel", "Faviet", "DFAVIET");
            csvPrinter.printRecord("106", "John", "Chen", "JCHEN");

            csvPrinter.flush();


        }catch (Exception e){

        }
    }
}
