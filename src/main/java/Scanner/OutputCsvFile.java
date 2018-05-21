package Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputCsvFile implements IOutputCsvFile{

    public void saveInfoInCsvFileOutput()throws IOException{

       try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("dbOutput.txt"));
            String text = "test.";
            bw.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }



    }}
