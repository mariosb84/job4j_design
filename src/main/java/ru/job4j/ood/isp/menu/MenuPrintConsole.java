package ru.job4j.ood.isp.menu;

public class MenuPrintConsole implements MenuPrinter {

  public static final String INDENT = "____";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo m : menu) {
            String indent;
            long count = m.getNumber().chars().
                    filter(ch -> ch == '.').count();
            indent = INDENT.repeat((int) count - 1);
            System.out.println(indent + m.getNumber() + m.getName());
        }
      }

   }
