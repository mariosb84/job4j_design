package ru.job4j.io;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "carJaxb")
public class CarJaxb {
    @XmlAttribute
    private int yearOfManufacture;
    @XmlAttribute
    private String colour;

    public CarJaxb() {}

    public CarJaxb(int yearOfManufacture, String colour) {
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
        return "CarJaxb{"
                + "yearOfManufacture=" + yearOfManufacture
                + ", colour='" + colour + '\''
                + '}';
    }
}
