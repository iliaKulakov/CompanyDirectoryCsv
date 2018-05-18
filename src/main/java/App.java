import menuPackage.MainMenu;
import menuPackage.Menu;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            Menu mainMenu = new MainMenu();
            mainMenu.interactWithMenu();
        } catch (Exception mainException) {
            System.err.println("Error in main method");
        }
    }
}
