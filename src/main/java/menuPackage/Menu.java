package menuPackage;

import service.ValidatonException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Menu {

    void printMenu() throws ValidatonException;

    void interactWithMenu() throws FileNotFoundException,ValidatonException,IOException;
}
