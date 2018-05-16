package Scanner;

import storage.PersonStorage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerCsv implements IScannerCsv {

    //Сделал чтение из через буффер ридер и просто вывод на экран что в файле
    public void toReadFromFile() throws FileNotFoundException {
        String csvFile = "db.csv";
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

        }
    } //toReadFromFile реализация по другому

    public void toReadFromFile2() throws FileNotFoundException {
        String csvFile = "db.csv";
        //String line = "";
        String cvsSplitBy = ";";
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<PersonStorage> personList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        try {
            while ((line = br.readLine()) != null) {
                PersonStorage persons = new PersonStorage();
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0)
                        persons.setFIO(data);
                    else if (index == 1)
                        persons.setDate(data);
                    else if (index == 2)
                        persons.setNumOfProjects(data);
                    else if (index == 3)
                        persons.setRate(data);
                    else if (index == 4)
                        persons.setComments(data);
                    else
                        System.out.println("Некорректные данные::" + data);
                    index++;
                }
                
                index = 0;
                personList.add(persons);
            }
            br.close();
            System.out.println(personList);
        }//try
        catch (FileNotFoundException e) {
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
        }
    }
}




