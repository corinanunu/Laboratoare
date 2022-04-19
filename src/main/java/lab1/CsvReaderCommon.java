package lab1;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvReaderCommon {
    private static final String SAMPLE_CSV_FILE = "employees.csv";

    public static void main(String[] args) {
        try(
                Reader reader = new BufferedReader(new FileReader(SAMPLE_CSV_FILE));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())
        ){
            for(CSVRecord csvRecord : csvParser){
                int id = Integer.parseInt(csvRecord.get(0));
                String firstName = csvRecord.get(1);
                String lastName = csvRecord.get(2);
                String email = csvRecord.get(3);


                System.out.println("--------------------------------");
                System.out.println("Record No - "+csvRecord.getRecordNumber());
                System.out.println("Employee id : "+id);
                System.out.println("First name : "+firstName);
                System.out.println("Last name : "+lastName);
                System.out.println("E-mail : "+email);
                System.out.println("--------------------------------\n\n");
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
