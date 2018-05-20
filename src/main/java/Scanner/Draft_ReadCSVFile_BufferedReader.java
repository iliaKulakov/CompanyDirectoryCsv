package Scanner;

import service.ValidatonException;
import storage.Person;

import javax.xml.stream.events.Comment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Draft_ReadCSVFile_BufferedReader implements IReadCsvFile {
    //Delimiters used in the CSV file
    private static final String COMMA_DELIMITER = ";";

    //Метод для проверки первого поля из файла ФИО
    public String getFirstName(String FIO) throws ValidatonException{
        String FirstLastName = "";
        //Что проверять в ФИО?
        FirstLastName = FIO;
        return FirstLastName;
    }

    //Метод для проверки и перевода строки в дату
    public Date getDateInfo(String DateInfo) throws ValidatonException,ParseException {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String dateInString = DateInfo;
        String dayString = dateInString.substring(0,2);
        String monthString = dateInString.substring(4,5);
        int day = Integer.parseInt(dayString);
        int month = Integer.parseInt(monthString);

            if(day<=31){
                if(month<=12) {
                date = formatter.parse(dateInString);
            } else { String testmessage = "Поле 'Дата' содержит некорректные данные " + dateInString;
                ValidatonException e = new ValidatonException(testmessage);
                throw e;}
            } else {
                String testmessage = "Поле 'Дата' содержит некорректные данные " + dateInString;
                ValidatonException e = new ValidatonException(testmessage);
                throw e;
            }
        return date;
    }//getBirthDate

    //Метод для проверки корректного количества проектов
    public int getNumberOfProjects(String personDetails) throws ValidatonException{
        String String = personDetails;
        int numberOfProjects = Integer.parseInt(String);
        if(numberOfProjects<0) {
            String testmessage = "Поле 'Количество проектов' содержит некорректное число " + numberOfProjects;
            ValidatonException e = new ValidatonException(testmessage);
            throw e;
        }
        return numberOfProjects;
    }

    //метод проверки рейтинга, проверяем что значение положительное
    public Float getRate (String stringRate) throws ValidatonException {
        Float Rate = Float.parseFloat(stringRate);
        if(Rate<0) {
                String testmessage = "Поле 'Рейтинг' содержит некорректное значение " + stringRate;
                ValidatonException e = new ValidatonException(testmessage);
                throw e;
        }
        return Rate;
    }

    //метод проверки комментариев. Просто проверяем что длина комментария не длинее 50 символов (просто взял из головы
    //чтобы сделать метод валидации
    public String getComments(String commentsString) throws ValidatonException {
        String comments=commentsString;
        int variableForCheck=50;

        if (comments.length()>variableForCheck) {
            String testmessage = "Поле 'Комментарий' превышает допустимое количество символов " + comments;
            ValidatonException e = new ValidatonException(testmessage);
            throw e;
        }
        return comments;
    }

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
                            int numberOfProjects = getNumberOfProjects(personsDetails[2].trim());
                            float rate = getRate(personsDetails[3].trim());
                            String comments = getComments(personsDetails[4].trim());

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
                    catch (ValidatonException e) {
                        System.out.println(e);
                        System.out.println("Ошибки данных в загруженном файле - ошибочные строки пропущены");
                    }

                }//while

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



