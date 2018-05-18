import Scanner.Draft_ReadCSVFile_BufferedReader;
import menuPackage.MainMenu;
import menuPackage.Menu;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

       try {

            //  System.out.println(new App().getGreeting());
            Menu mainMenu = new MainMenu();
            // mainMenu.printMenu();
            mainMenu.interactWithMenu();
        } catch (Exception mainException) {
            System.err.println("Error in main method");
        }

        // ScannerCsv readFromFile = new ScannerCsv();
        // readFromFile.toReadFromFile(); Вызов первого реализованного метода считывания из файла и просто показ в консоль
        //  readFromFile.toReadFromFile2();


    }
}
