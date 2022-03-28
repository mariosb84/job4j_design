package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportAcc implements Report {

    private Store store;

    public ReportAcc(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; SalaryModified;");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / 100.0).append("USD")
                    .append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}
