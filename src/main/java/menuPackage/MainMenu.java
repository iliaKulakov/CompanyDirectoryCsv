package menuPackage;
import java.util.Scanner;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super();
        initMenuItems();
    }

    private void initMenuItems() {
        this.items.add("Download file");
        this.items.add("Search clients");
        this.items.add("Sort clients");
    }

    @Override
    public void interactWithMenu() {
//TODO: Обработка ввода и вызов метода контроллера
        Scanner sc1 = new Scanner(System.in);
        boolean exit = false;
        do {
            printMenu(); //вызываю печать меню от menu.AbstractMenu
            System.out.println("Ввод пункта меню с клавиатуры: ");
            int command = sc1.nextInt();//
            switch (command) {
                case 1:
                    System.out.println("Вы ввели число 1 - Загрузка файла ");
                    Scanner scName = new Scanner(System.in);
                    String nameFromKeyBoard = scName.nextLine();


                    exit = false;
                    break;
                case 2:

                    exit = false;
                    break;
                case 3:

                    exit = false;
                    break;
                default:
                    System.out.println("Ошибка! Повторите выбор меню: ");
                    exit = false;
                    break;
            }
        } while (exit != true);






    }
}