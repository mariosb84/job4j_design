package ru.job4j.ood;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.ood.lsp.parking.Auto;
import ru.job4j.ood.lsp.parking.Car;
import ru.job4j.ood.lsp.parking.ParkingJob;
import ru.job4j.ood.lsp.parking.Truck;
import java.util.List;

public class ParkingJobTest {

    List<Auto> list = List.of(
            new Car("1"),
            new Car("2"),
            new Car("3"),
            new Car("4"),
            new Car("5"),
            new Truck(2, "11"),
            new Truck(3, "22"),
            new Truck(4, "33"),
            new Truck(5, "44"),
            new Truck(1, "55")
    );

    @Test
    public void whenCarParkingOnTheCarPark() {
        ParkingJob parkingJob = new ParkingJob(1, 0);
        boolean rsl = parkingJob.accept(list.get(0));
        Assert.assertTrue(rsl);
    }

    @Test
    public void whenCarNotParkingOnTheCarPark() {
        ParkingJob parkingJob = new ParkingJob(0, 1);
        boolean rsl = parkingJob.accept(list.get(0));
        Assert.assertFalse(rsl);
    }

    @Test
    public void whenTruckParkingOnTheTruckPark() {
        ParkingJob parkingJob = new ParkingJob(0, 1);
        boolean rsl = parkingJob.accept(list.get(5));
        Assert.assertTrue(rsl);
    }

    @Test
    public void whenTruckNotParkingOnTheTruckPark() {
        ParkingJob parkingJob = new ParkingJob(1, 0);
        boolean rsl = parkingJob.accept(list.get(5));
        Assert.assertFalse(rsl);
    }

    @Test
    public void whenTruckParkingOnTheCarPark() {
        ParkingJob parkingJob = new ParkingJob(5, 0);
        boolean rsl = parkingJob.accept(list.get(8));
        Assert.assertTrue(rsl);
    }
}
