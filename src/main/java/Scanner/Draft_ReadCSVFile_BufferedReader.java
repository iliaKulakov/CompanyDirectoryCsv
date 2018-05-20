package Scanner;

import service.ValidatonException;
import storage.Person;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

//Тут экспериментировал как нормальный парсинг сделать в итоге
public class Draft_ReadCSVFile_BufferedReader implements IReadCsvFile {
    //Delimiters used in the CSV file
    private static final String COMMA_DELIMITER = ";";

    //Метод для проверки первого поля из файла ФИО
    public String getFirstName(String FIO) throws ValidatonException{
        String FirstLastName = "";
        //Проверки ФИО
        FirstLastName = FIO;
        return FirstLastName;
    }

    //Метод для проверки и перевода строки в дату
    public Date getDateInfo(String DateInfo) throws ValidatonException {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String dateInString = DateInfo;
        try {
            date = formatter.parse(DateInfo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }//getBirthDate

    //Метод для проверки корректного количества проектов
    public int getNumberOfProjects(String personDetails) throws ValidatonException{
        String String = personDetails;
        int numberOfProjects = Integer.parseInt(String);
        if(numberOfProjects<0)
        {
            String testmessage = "Поле 'Количество проектов' содержит некорректное число " + numberOfProjects;
            ValidatonException e = new ValidatonException(testmessage);
            throw e;

            //Что делать когда проверка не пройдена, например количество проектов отрицательное?
        }
        return numberOfProjects;
    }

    /*public String getComments (String personDetails){
        String Comments="";
        Comments=personDetails;
        Comments=

        return Comments
    }*/


    //парсинг и сохранение строк в билдер
    public void saveInfoFromBufferToBuilder() throws ValidatonException,IOException {
        //создаю обьект класса внутри класса, чтобы обращаться к методам валидации
        Draft_ReadCSVFile_BufferedReader FileParserObject = new Draft_ReadCSVFile_BufferedReader();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("db.csv"));
            List<Person> personList = new ArrayList<Person>();
            String line = "";

                while ((line = br.readLine()) != null) {

                    String[] personsDetails = line.split(COMMA_DELIMITER, 5);

                    try{
                        if (personsDetails.length > 0) {
                            // Методы валидации
                            String FIO = FileParserObject.getFirstName(personsDetails[0].trim());
                            Date birthDate = FileParserObject.getDateInfo(personsDetails[1].trim());
                            // int numberOfProjects = Integer.parseInt(personsDetails[2].trim());
                            int numberOfProjects = getNumberOfProjects(personsDetails[2].trim());
                            float rate = Float.parseFloat(personsDetails[3].trim());
                            String comments = personsDetails[4].trim();

                            //Сохранение в билдер через сеттеры
                            Person person = Person.newBuilderPerson()
                                    .setFIO(FIO)
                                    .setBirthDate(birthDate)
                                    .setNumOfProjects(numberOfProjects)
                                    .setRate(rate)
                                    .setComments(comments)
                                    .build();                     //Comments
                            personList.add(person);
                        }//if

                    }//try
                    catch (ValidatonException e)
                    {

                        System.out.println(e);
                        System.out.println("Ошибки данных в загруженном файле - ошибочные строки пропущены");
                    }

                }//while


            //Print persons
            //Пока не понял почему у меня на печать не выводится обьект
            for (Person p : personList) {
                System.out.println(p.getFIO() + "   " + p.getBirthDate() + "   "
                        + p.getNumOfProjects() + "   " + p.getRate() + "   " + p.getComments());
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ie) {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }

    }

    }//saveInfoFromBufferToBuilder



