package service;

import Scanner.Draft_ReadCSVFile_BufferedReader;
import storage.Person;

public class CompanyDirectoryService implements ICompanyDirectoryService {

    public void searchByName(String Name) {
        //Заглушка для поиска

        Person person = Person.newBuilderPerson().build();



        String FIO = "Иванов ИванИванович";
        FIO = FIO.toLowerCase();
        Name = Name.toLowerCase();
        System.out.println(FIO);
        boolean isContain = FIO.contains(Name);
        if (isContain) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }


}
