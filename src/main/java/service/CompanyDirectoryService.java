package service;

import java.util.*;
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
    //И оно даже работает, проверил с другими полями
    public void sortByFio() throws ValidatonException,IOException{
        //Читаем файл и можем работать уже с прочитанными элементами
        ReadCsvFile readFile = new ReadCsvFile();
        List<Person> listForSearch = readFile.saveInfoFromBufferToBuilder2();
        //Сортировка через внутренний анонимный класс
        Collections.sort(listForSearch, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return    o1.getFIO().compareTo(o2.getFIO());
               // return    o1.getRate().compareTo(o2.getRate());
               // return    o1.getNumOfProjects().compareTo(o2.getNumOfProjects());
            }
        });



        for(Person p : listForSearch){

            System.out.println(p.getFIO() + "   " + p.getBirthDate() + "   "
                    + p.getNumOfProjects() + "   " + p.getRate() + "   " + p.getComments());
        }

    }


}



