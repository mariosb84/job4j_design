package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHr implements Report {

    private Store store;

    public ReportHr(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> arrayList = store.findBy(filter);
        arrayList.sort(Comparator.comparing(Employee::getSalary).reversed());
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        text.append(System.lineSeparator());
        for (Employee employee : arrayList) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

}
