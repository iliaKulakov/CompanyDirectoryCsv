package Scanner;

import com.google.common.io.LittleEndianDataOutputStream;
import storage.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputCsvFile implements IOutputCsvFile {

    public void saveInfoInCsvFileOutput(Person person)throws IOException{

        Person personOutputResult = person;
       // System.out.println(personOutputResult.toString());


        BufferedWriter bw = new BufferedWriter(new FileWriter("dbOutput.csv"));
        try
        {
            String text = personOutputResult.getFIO() + "   " + personOutputResult.getBirthDate() + "   "
                    + personOutputResult.getNumOfProjects() + "   " + personOutputResult.getRate() + "   " + personOutputResult.getComments();
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
