package menuPackage;

import Scanner.Draft_ReadCSVFile_BufferedReader;
import service.CompanyDirectoryService;
import service.ValidatonException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainMenu extends AbstractMenu {
    private CompanyDirectoryService service;

    public MainMenu() {
        super();
        initMenuItems();
        this.service = new CompanyDirectoryService();
    }

    private void initMenuItems() {
        this.items.add("Load file");
        this.items.add("Search clients");
        this.items.add("Sort clients");
    }

    @Override
    public void interactWithMenu() throws FileNotFoundException , ValidatonException{
        //TODO: Обработка ввода и вызов метода контроллера
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
            switch (command) {
                case 1:
                    System.out.println("Вы ввели число 1 - Загрузка файла ");
                    //Чтение из файла, сохранение и вывод
                    //ScannerCsv readFromFile = new ScannerCsv();
                    //readFromFile.toReadFromFile2();
                    Draft_ReadCSVFile_BufferedReader ReadCsvFile = new Draft_ReadCSVFile_BufferedReader();
                    ReadCsvFile.saveInfoFromBufferToBuilder();
                    exit = false;
                    break;
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










