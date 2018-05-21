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
        int resultFlag=0;
        for (Person p : listForSearch) {

             if(p.getFIO().equals(fioForCompare)){
                 System.out.println(p.getFIO() + "   " + p.getBirthDate() + "   "
                         + p.getNumOfProjects() + "   " + p.getRate() + "   " + p.getComments());
                resultFlag=1;
                break;
            }
            }//for

            if (resultFlag==1) {
                System.out.println("Строка найдена");


            } else {
                System.out.println("Строка не найдена");
            }
            }
        }



