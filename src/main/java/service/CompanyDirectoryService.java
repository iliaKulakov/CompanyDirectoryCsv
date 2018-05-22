package service;

import Scanner.OutputCsvFile;
import Scanner.ReadCsvFile;
import storage.Person;
import storage.PersonComparator;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CompanyDirectoryService implements ICompanyDirectoryService {

    public void searchByName(String Name) throws ValidatonException, IOException{
        //Заглушка для поиска
        String fioForCompare=Name;
        //Person person = Person.newBuilderPerson().build();
        ReadCsvFile readFile = new ReadCsvFile();
        List<Person> listForSearch = readFile.saveInfoFromBufferToBuilder2();
        int resultFlag=0;
        for (Person p : listForSearch) {

             if(p.getFIO().equals(fioForCompare)){

                 System.out.println(p.getFIO() + "   " + p.getBirthDate() + "   "
                         + p.getNumOfProjects() + "   " + p.getRate() + "   " + p.getComments());

                 OutputCsvFile OutputCsvFile = new OutputCsvFile();
                 OutputCsvFile.saveInfoInCsvFileOutput(p);

                resultFlag=1;
                break;
            }
            }//for

            if (resultFlag==1) {
                System.out.println("Строка найдена");
            } else {
                System.out.println("Строка не найдена");
            }

       // OutputCsvFile OutputCsvFile = new OutputCsvFile();
       // OutputCsvFile.saveInfoInCsvFileOutput();

            }//searchByName

    //Заготовка для сортировки
    public void sortByFio() throws ValidatonException,IOException{
        //Читаем файл и можем работать уже с прочитанными элементами
     //   PersonComparator personComparator = new PersonComparator();
        ReadCsvFile readFile = new ReadCsvFile();
        List<Person> listForSearch = readFile.saveInfoFromBufferToBuilder2();
        listForSearch.sort(Comparator.comparing(Person.newBuilderPerson().));


        for(Person p : listForSearch){
           // listForSearch.sort(personComparator.compare(p.build(),p.build()));

            System.out.println(p.getFIO() + "   " + p.getBirthDate() + "   "
                    + p.getNumOfProjects() + "   " + p.getRate() + "   " + p.getComments());
        }

    }


}



