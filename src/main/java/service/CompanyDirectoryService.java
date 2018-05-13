package service;
import java.io.*;

public class CompanyDirectoryService implements ICompanyDirectoryService{

   public void searchByName(String Name) {
    //Заглушка для поиска

    String FIO = "Иванов ИванИванович";
    FIO=FIO.toLowerCase();
    Name=Name.toLowerCase();
    System.out.println(FIO);
    boolean isContain = FIO.contains(Name);
    if (isContain){
        System.out.println("Found");
    }
    else
    {
        System.out.println("Not Found");
    }
    //return Name;
    }


}
