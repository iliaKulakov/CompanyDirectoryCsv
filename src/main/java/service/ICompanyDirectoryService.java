package service;

import java.io.IOException;

public interface ICompanyDirectoryService  {

    void searchByName(String Name) throws ValidatonException,IOException;

}
