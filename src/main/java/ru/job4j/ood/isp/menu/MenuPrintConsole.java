package ru.job4j.ood.isp.menu;

public class MenuPrintConsole implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo m : menu) {
            long count = m.getNumber().chars().
                    filter(ch -> ch == '.').count();
            StringBuilder indent = new StringBuilder();
            for (int i = 1; i < count; i++) {
                indent.append("____");
            }
            System.out.println(indent + m.getNumber() + m.getName());
        }
      }

   }
