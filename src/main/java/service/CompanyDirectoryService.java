package service;

import Scanner.ReadCsvFile;
import storage.Person;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.io.IOException;
import java.util.List;

public class CompanyDirectoryService implements ICompanyDirectoryService {

    public void searchByName(String Name) throws ValidatonException, IOException{
        //Заглушка для поиска
        String fioForCompare=Name;
        //Person person = Person.newBuilderPerson().build();
        ReadCsvFile readFile = new ReadCsvFile();
        List<Person> listForSearch = readFile.saveInfoFromBufferToBuilder2();

        for (Person p : listForSearch) {

            if (p.getFIO().equals(fioForCompare)) {
                System.out.println("Строка найдена");
            } else {
                System.out.println("Строка не найдена");
            }

            }

        }



        //String FIO = "Иванов ИванИванович";
        /*
        FIO = FIO.toLowerCase();
        Name = Name.toLowerCase();
        System.out.println(FIO);
        boolean isContain = FIO.contains(Name);
        if (isContain) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }*/
    }



