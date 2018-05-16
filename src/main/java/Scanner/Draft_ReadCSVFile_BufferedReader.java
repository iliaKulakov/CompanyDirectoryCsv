package Scanner;

import storage.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Тут экспериментировал как нормальный парсинг сделать в итоге
public class Draft_ReadCSVFile_BufferedReader {
    //Delimiters used in the CSV file
    private static final String COMMA_DELIMITER = ";";
/*
    private String FIO;
    private Date DateInfo;
    private Integer NumOfProjects;
    private Float Rate;
    private String Comments;*/
    public static void main(String args[])
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("db.csv"));
            List<Person> personList = new ArrayList<Person>();
            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] personsDetails = line.split(COMMA_DELIMITER);

                if(personsDetails.length > 0 )
                {
                    Person person = new Person(personsDetails[0], //FIO


                            //открытый вопрос как дату сохранять
                             personsDetails[1],                    //Date
                            Integer.parseInt(personsDetails[2]),  //NumOfProjects
                            Float.parseFloat(personsDetails[3]),  // Rate
                            personsDetails[4]);                    //Comments
                    personList.add(person);
                }
            }
            //Print persons
            for(Person p : personList)
            {
                System.out.println(p.getFIO()+"   "+p.getDateInfo()+"   "
                        +p.getNumOfProjects()+"   "+p.getRate()+"   "+p.getComments());
            }
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
    }


}
