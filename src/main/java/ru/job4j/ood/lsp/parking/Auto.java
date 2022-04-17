package ru.job4j.ood.lsp.parking;

import java.util.Objects;

public abstract class  Auto {

    private int spaceAmount;
    private String name;

    public Auto(int spaceAmount, String name) {
      this.spaceAmount = spaceAmount;
      this.name = name;
    }

    public void setSpaceAmount(int spaceAmount) {
        this.spaceAmount = spaceAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpaceAmount() {
        return spaceAmount;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Auto)) {
            return false;
        }
        Auto auto = (Auto) o;
        return Double.compare(auto.getSpaceAmount(),
                getSpaceAmount()) == 0 && getName().equals(auto.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpaceAmount(), getName());
    }


}
