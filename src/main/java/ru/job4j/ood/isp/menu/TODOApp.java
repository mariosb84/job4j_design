package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {


    public static void main(String[] args) {
        ActionDelegate actionDelegate = System.out::println;
        Menu menu = new SimpleMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите корневой элемент");
        menu.add(Menu.ROOT, scanner.nextLine(), actionDelegate);
        System.out.println("Введите еще один корневой элемент");
        menu.add(Menu.ROOT, scanner.nextLine(), actionDelegate);
        System.out.println("Введите еще раз первый корневой элемент и его подменю");
        menu.add(scanner.nextLine(), scanner.nextLine(), actionDelegate);
        MenuPrintConsole menuPrintConsole = new MenuPrintConsole();
        menuPrintConsole.print(menu);
    }
}
