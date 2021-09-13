package ru.job4j.io;

public class Car {
    private final int yearOfManufacture;
    private final String colour;

    public Car(int yearOfManufacture, String colour) {
        this.yearOfManufacture = yearOfManufacture;
        this.colour = colour;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Car{"
                + "yearOfManufacture=" + yearOfManufacture
                + ", colour='" + colour + '\''
                + '}';
    }
}
