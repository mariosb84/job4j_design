package ru.job4j.srp;

/* Класс, содержащий методы работы с моделью данных "Книга"  */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private final List<Book> booksLibrary;
    private final Book book;
    private final int quantity;
    private final double discountRate;
    private final double taxRate;
    private final double total;

    public Invoice(List<Book> booksLibrary, Book book, int quantity, double discountRate, double taxRate) {
        this.booksLibrary = booksLibrary;
        this.book = book;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
        this.total = this.calculateTotal();
    }

/*
* Метод для подсчета общей суммы */

    public double calculateTotal() {
        double price = ((book.getPrice() - book.getPrice() * discountRate) * this.quantity);
        return price * (1 + taxRate);
    }

    /*
     * "printInvoice()" - Метод для вывода инвойса в консоль
     *
     * Первое нарушение — наш метод printInvoice, содержащий логику вывода. SRP гласит,
     * что наш класс должен иметь единственную причину для изменения.
     * Таковой причиной для нашего класса должно быть изменение системы подсчета.
     * Но при существующей архитектуре, если мы захотим изменить формат вывода,
     * нам придется изменить наш класс. Вот почему нам не следует смешивать в
     * одном классе логику вывода с бизнес-логикой.*/

    public void printInvoice() {
        System.out.println(quantity + "x " + book.getName() + " " + book.getPrice() + "$");
        System.out.println("Discount Rate: " + discountRate);
        System.out.println("Tax Rate: " + taxRate);
        System.out.println("Total: " + total);
    }

    /*
     * "saveToFile()" - Метод для записи инвойса в файл
     *
     * Второе нарушение — в нашем классе есть еще один метод, нарушающий SRP,
     *  — метод saveToFile. Смешивание долгоживущей логики с бизнес-логикой
     * это еще одна распространенная ошибка.*/

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }

    /*
     * "findBook()" - Метод для поиска книги
     *
     * Третье нарушение — в нашем классе есть еще один метод, нарушающий SRP,
     *  — метод findBook(). Поиск производится по конкретному критерию - по
     * названию книги, а должен - по предикату, чтобы можно было легко поменять условие
     * поиска.*/

    public List<Book> findBook(String bookName) {
        ArrayList<Book> arrayList = new ArrayList<>();
        for (Book book : booksLibrary) {
            if (bookName.equals(book.getName())) {
             arrayList.add(book);
            }
        }
        return arrayList;
    }
}
