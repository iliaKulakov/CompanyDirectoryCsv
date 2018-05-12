package menuPackage;
import java.util.Scanner;
import service.CompanyDirectoryService;
public class MainMenu extends AbstractMenu {
    private CompanyDirectoryService service;
    public MainMenu() {
        super();
        initMenuItems();
        this.service= new CompanyDirectoryService();
    }
    private void initMenuItems() {
        this.items.add("Download file");
        this.items.add("Search clients");
        this.items.add("Sort clients");
    }
    @Override
    public void interactWithMenu() {
    //TODO: Обработка ввода и вызов метода контроллера
       // Scanner sc = new Scanner(System.in);
        boolean exit = false;
        do {
            printMenu(); //вызываю печать меню от menu.AbstractMenu
            Scanner sc = new Scanner(System.in);
            int command;
            do {
                System.out.println("Enter a number here: ");
                while (!sc.hasNextInt()) {
                    System.out.println("That not a number! Please try again");
                    sc.next();
                }
                command = sc.nextInt();
            } while (command <= 0);
           // System.out.println("Thank you! Got " + command);
                switch (command) {
                    case 1:
                        System.out.println("Вы ввели число 1 - Загрузка файла ");
                        Scanner scName = new Scanner(System.in);
                        String nameFromKeyBoard = scName.nextLine();
                        exit = false;
                        break;
                    // catch (Exception incorrectInput){
                    //    System.out.println("IncorrectInput");throw incorrectInput;}
                    case 2:
                        System.out.println("You have entered the number 2. Search Persons");
                        System.out.println("Type a name from the keyboard to search");
                        Scanner scName2 = new Scanner(System.in);
                        String Name = scName2.nextLine();
                        service.searchByName(Name);
                        exit = false;
                        break;
                    case 3:
                        exit = false;
                        break;
                    default:
                        System.out.println("Error! Please try again:  ");
                        exit = false;
                        break;

                } // end switch

        } while (exit != true);



    }
}










