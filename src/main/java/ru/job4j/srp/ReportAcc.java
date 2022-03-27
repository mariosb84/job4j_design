package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportAcc implements Report {

    private Store store;

    public ReportAcc(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
