package ru.job4j.ood.isp.menu;

public class MenuPrintConsole implements MenuPrinter {

    private final String indent = "";

    @Override
    public void print(Menu menu) {

        menu.forEach(i -> System.out.println(
                indent + i.getNumber() + i.getName()));


    }

    public static void main(String[] args) {
        ActionDelegate actionDelegate = System.out::println;
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", actionDelegate);
        menu.add(Menu.ROOT, "Покормить собаку", actionDelegate);
        menu.add("Сходить в магазин", "Купить продукты", actionDelegate);
        menu.add("Купить продукты", "Купить хлеб", actionDelegate);
        menu.add("Купить продукты", "Купить молоко", actionDelegate);
        MenuPrintConsole menuPrintConsole = new MenuPrintConsole();
        menuPrintConsole.print(menu);

    }
}
