package ru.job4j.ood;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.ood.srp.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName()
                + ";"
                + worker.getHired()
                + ";"
                + worker.getFired()
                + ";"
                + worker.getSalary()
                + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenNewGeneratedProgrammer() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportPrg(store);
        String expect =
                        "<!ECOTYPE HTML><html><head>"
                                + "<title>HTML отчёт.</title></head>"
                                + "<body><table>"
                                + "<tr><th>Name</th><th>Hired</th>"
                                + "<th>Fired</th><th>Salary</th></tr>"
                                + "<tr><td>"
                                + worker.getName()
                                + "</td>"
                                + "<td>"
                                + worker.getFired()
                                + "</td>"
                                + "<td>"
                                + worker.getHired()
                                + "</td>"
                                + "<td>"
                                + worker.getSalary()
                                + "</td></tr>"
                                + "</table></body></html>"
                                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenNewGeneratedHr() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan1", now, now, 100);
        Employee worker2 = new Employee("Ivan2", now, now, 200);
        Employee worker3 = new Employee("Ivan3", now, now, 300);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportHr(store);
        String expect = "Name; Salary;"
                + System.lineSeparator()
                + worker3.getName()
                + ";"
                + worker3.getSalary()
                + ";"
                + System.lineSeparator()
                + worker2.getName()
                + ";"
                + worker2.getSalary()
                + ";"
                + System.lineSeparator()
                + worker.getName()
                + ";"
                + worker.getSalary()
                + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenNewGeneratedAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportAcc(store);
        String expect = "Name; Hired; Fired; SalaryModified;"
                + System.lineSeparator()
                + worker.getName()
                + ";"
                + worker.getHired()
                + ";"
                + worker.getFired()
                + ";"
                + (worker.getSalary() / ReportAcc.DOLLAR)
                + "USD"
                + ";"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenReportJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportJSON(store);
        String expected = "[{\"name\":\"Ivan\",\"hired\":{\"year\":"
                + worker.getHired().get(Calendar.YEAR)
                + "," + "\"month\":"
                + worker.getHired().get(Calendar.MONTH)
                + "," + "\"dayOfMonth\":"
                + worker.getHired().get(Calendar.DAY_OF_MONTH)
                + "," + "\"hourOfDay\":"
                + worker.getHired().get(Calendar.HOUR_OF_DAY)
                + "," + "\"minute\":"
                + worker.getHired().get(Calendar.MINUTE)
                + "," + "\"second\":"
                + worker.getHired().get(Calendar.SECOND)
                + "}," + "\"fired\":{\"year\":"
                + worker.getHired().get(Calendar.YEAR)
                + "," + "\"month\":"
                + worker.getHired().get(Calendar.MONTH)
                + "," + "\"dayOfMonth\":"
                + worker.getHired().get(Calendar.DAY_OF_MONTH)
                + "," + "\"hourOfDay\":"
                + worker.getHired().get(Calendar.HOUR_OF_DAY)
                + "," + "\"minute\":"
                + worker.getHired().get(Calendar.MINUTE)
                + "," + "\"second\":"
                + worker.getHired().get(Calendar.SECOND)
                + "}," + "\"salary\":100.0}]";
        assertThat(engine.generate(em -> true), is(expected));
    }

    @Test
    public void whenReportXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportXML(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employee>\n"
                + "        <fired>" + format.format(worker.getHired().getTime()) + "</fired>\n"
                + "        <hired>" + format.format(worker.getHired().getTime()) + "</hired>\n"
                + "        <name>Ivan</name>\n"
                + "        <salary>100.0</salary>\n"
                + "    </employee>\n"
                + "</employees>\n";
        assertThat(engine.generate(em -> true), is(expect));
    }

}
