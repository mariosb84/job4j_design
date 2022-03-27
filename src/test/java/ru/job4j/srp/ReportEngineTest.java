package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;" +
                System.lineSeparator() +
                worker.getName() + ";" +
                worker.getHired() + ";" +
                worker.getFired() + ";" +
                worker.getSalary() + ";" +
                System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenNewGeneratedProgrammer() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        String expect = "Name; Hired; Fired; Salary;" +
                System.lineSeparator() +
                worker.getName() + ";" +
                worker.getHired() + ";" +
                worker.getFired() + ";" +
                worker.getSalary() + ";" +
                System.lineSeparator();
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
        String expect = "Name; Salary;" +
                System.lineSeparator() +
                worker3.getName() + ";" +
                worker3.getSalary() + ";" +
                System.lineSeparator() +
                worker2.getName() + ";" +
                worker2.getSalary() + ";" +
                System.lineSeparator() +
                worker.getName() + ";" +
                worker.getSalary() + ";" +
                System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenNewGeneratedAccounting () {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportAcc(store);
        String expect = "Name; Hired; Fired; Salary;" +
                System.lineSeparator() +
                worker.getName() + ";" +
                worker.getHired() + ";" +
                worker.getFired() + ";" +
                (worker.getSalary() / 100) +
                "USD" + ";" +
                System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }
}
