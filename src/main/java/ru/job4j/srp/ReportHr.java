package ru.job4j.srp;

import java.util.ArrayList;
import java.util.Calendar;
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
        text.append("Name; Salary");
        text.append(System.lineSeparator());
        for (Employee employee : arrayList) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Report engine = new ReportHr(store);
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan1", now, now, 100);
        Employee worker2 = new Employee("Ivan2", now, now, 200);
        Employee worker3 = new Employee("Ivan3", now, now, 300);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        System.out.println(engine.generate(em -> em.getSalary() > 90));
    }
}
