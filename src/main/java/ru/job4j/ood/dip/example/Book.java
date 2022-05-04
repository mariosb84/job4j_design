package ru.job4j.ood.dip.example;

public class Book {

    private final String text;

    public Book(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
        }
    public ConsolePrinter printer() {
        return new ConsolePrinter();
    }
/*
  Класс Book, представляющий книгу, использует для печати класс ConsolePrinter.
  При подобном определении класс Book зависит от класса ConsolePrinter. Более того
  мы жестко определили, что печатать книгу можно только на консоли с помощью класса ConsolePrinter.
  Другие же варианты, например, вывод на принтер, вывод в файл или с использованием каких-то элементов
  графического интерфейса - все это в данном случае исключено.
  Абстракция печати книги не отделена от деталей класса ConsolePrinter.
  Все это является нарушением принципа инверсии зависимостей.
* */
    public void print() {
        printer().print(text);
    }
}

class ConsolePrinter {
    public void print(String text) {
        System.out.println(text);
    }
}
