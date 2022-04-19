package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvReaderScanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("employees.csv"));
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
