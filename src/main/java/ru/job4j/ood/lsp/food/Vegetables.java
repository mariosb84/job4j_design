package ru.job4j.ood.lsp.food;

import java.time.LocalDate;

public class Vegetables extends Food {
    public Vegetables(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
