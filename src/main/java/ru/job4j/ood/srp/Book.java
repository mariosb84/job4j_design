package ru.job4j.ood.srp;

import java.util.Objects;

/* Модель данных "Книга" */

public class Book {

    private  String name;
    private  String authorName;
    private  int year;
    private  int price;

    public Book(String name, String authorName, int year, int price) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return getYear() == book.getYear()
                && getPrice() == book.getPrice()
                && getName().equals(book.getName())
                && getAuthorName().equals(book.getAuthorName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthorName(), getYear(), getPrice());
    }
}
