import Scanner.ScannerCsv;
import menuPackage.MainMenu;
import menuPackage.Menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {

          //  System.out.println(new App().getGreeting());
            Menu mainMenu = new MainMenu();
            // mainMenu.printMenu();
            mainMenu.interactWithMenu();
        } //end try
        catch (Exception mainException)
        {
            System.err.println("Error in main method");
        }

           // ScannerCsv readFromFile = new ScannerCsv();
           // readFromFile.toReadFromFile(); Вызов первого реализованного метода считывания из файла и просто показ в консоль
          //  readFromFile.toReadFromFile2();


    }
}
