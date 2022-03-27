package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportPrg implements Report {

    private Store store;

    public ReportPrg(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return null;
    }
}
