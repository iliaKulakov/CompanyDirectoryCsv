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
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Тут экспериментировал как нормальный парсинг сделать в итоге
public class Draft_ReadCSVFile_BufferedReader {
    //Delimiters used in the CSV file
    private static final String COMMA_DELIMITER = ";";
    //Метод для проверки первого поля из файла ФИО
    public String getFirstName(String FIO) {
        String FirstLastName="";
        //Проверки ФИО
        FirstLastName=FIO;
        return FirstLastName;
    }
    //Метод для проверки и перевода строки в дату
    //public Date getDateInfo(String Date){
    public Date getDateInfo(String DateInfo){
        Date date= new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        //String dateInString = "07.06.2013";
        String dateInString = DateInfo;
        try {

            //Тут делаю проверку даты которая поступает, если дата корректная начинаю проверку месяца
            String  checkInputDay   = dateInString.substring(0, dateInString.length()-8);
            String checkInputMonth = dateInString.substring(3, dateInString.length()-5);
            //Преобразовываю в инт, хотя тут наверно можно было бы сделать через equals
            int intCheckInputDay  = Integer.parseInt(checkInputDay);
            int intCheckInputMonth = Integer.parseInt(checkInputMonth);
            if (intCheckInputDay<=31){
                if (intCheckInputDay<=12)
                {
                    //Прошли все проверки, можно преобразовывать в дату
                     date = formatter.parse(dateInString);
                  //  System.out.println(date);
                    // System.out.println(formatter.format(date));
                }
            }
            else {
                //Что делать в случае некорректной даты? кидать exception?
                //или самому менять например местами месяц и дату?
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }//getDateInfo

    // метод main в парсере
    public static void main(String args[])
    {
        Draft_ReadCSVFile_BufferedReader FileParserObject = new Draft_ReadCSVFile_BufferedReader();
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
                    // Методы валидации
                    String firstName = FileParserObject.getFirstName(personsDetails[0]);
                    Date DateInfo = FileParserObject.getDateInfo(personsDetails[1]);

                    //Сохранение в билдер
                    Person person = new Person(firstName,   //FIO
                    DateInfo,                               //Date
                    Integer.parseInt(personsDetails[2]),    //NumOfProjects
                    Float.parseFloat(personsDetails[3]),    // Rate
                    personsDetails[4]);                     //Comments
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
