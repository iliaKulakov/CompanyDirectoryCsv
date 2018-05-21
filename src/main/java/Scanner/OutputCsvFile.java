package Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputCsvFile implements IOutputCsvFile {

    public void saveInfoInCsvFileOutput()throws IOException{

        BufferedWriter bw = new BufferedWriter(new FileWriter("dbOutput.csv"));
        try
        {
            String text = "test.";
            bw.write(text);
        }
        catch(IOException exc){

            System.out.println(exc.getMessage());
        }
        finally { // закрытие ресурсов обязательно в finally
           // Оба вызова обязательно в отдельных try-catch
           try {
               bw.close();
           } catch (IOException ex) {
               // log here
           }
        }

    }
}
