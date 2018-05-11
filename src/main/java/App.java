import menuPackage.MainMenu;
import menuPackage.Menu;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());


        Menu mainMenu = new MainMenu();
        mainMenu.printMenu();
     //   mainMenu.interactWithMenu();
    }
}
