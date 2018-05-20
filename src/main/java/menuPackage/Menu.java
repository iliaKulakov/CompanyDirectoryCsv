package menuPackage;

import service.ValidatonException;

import java.io.FileNotFoundException;

public interface Menu {

    void printMenu() throws ValidatonException;

    void interactWithMenu() throws FileNotFoundException,ValidatonException;
}
