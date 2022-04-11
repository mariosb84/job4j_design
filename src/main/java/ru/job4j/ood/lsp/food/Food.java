package ru.job4j.ood.lsp.food;

import java.time.LocalDate;
import java.util.Objects;

public class Food {

    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Food)) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.getPrice(), getPrice()) == 0
                && Double.compare(food.getDiscount(), getDiscount()) == 0
                && Objects.equals(getName(), food.getName())
                && Objects.equals(getExpiryDate(), food.getExpiryDate())
                && Objects.equals(getCreateDate(), food.getCreateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExpiryDate(),
                getCreateDate(), getPrice(), getDiscount());
    }

}
