package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportPrg implements Report {

    private Store store;

    public ReportPrg(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!ECOTYPE HTML><html><head>")
                .append("<title>HTML отчёт.</title></head>")
                .append("<body><table>")
                .append("<tr><th>Name</th><th>Hired</th>")
                .append("<th>Fired</th><th>Salary</th></tr>");
        for (Employee employee: store.findBy(filter)) {
            text.append("<tr><td>")
                    .append(employee.getName()).append("</td>").append("<td>")
                    .append(employee.getFired()).append("</td>").append("<td>")
                    .append(employee.getHired()).append("</td>").append("<td>")
                    .append(employee.getSalary()).append("</td></tr>");
        }
        text.append("</table></body></html>");
        text.append(System.lineSeparator());
        return text.toString();
    }

}
