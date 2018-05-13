package Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ScannerCsv implements IScannerCsv {

    //Сделал чтение из файла и просто вывод на экран
   public void toReadFromFile() throws FileNotFoundException {
         String csvFile = "C:\\Users\\Angron\\Desktop\\csv\\test2.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use separator
                String[] lineFromFile = line.split(cvsSplitBy);

                System.out.println("Line from file[" + lineFromFile[0] + lineFromFile[1] + lineFromFile[2] + lineFromFile[3] + lineFromFile[4] + lineFromFile[5]);
                System.out.println();

        } //try
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

}} //toReadFromFile


}
