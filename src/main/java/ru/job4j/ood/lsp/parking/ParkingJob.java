package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingJob implements Parking {

    private int carSpace;
    private int truckSpace;
    private final ArrayList<Auto> truckStorage;
    private  final ArrayList<Auto> carStorage;

    public ParkingJob(int carSpace, int truckSpace) {
        this.carSpace = carSpace;
        this.truckSpace = truckSpace;
        truckStorage = new ArrayList<>();
        carStorage = new ArrayList<>();
    }

    @Override
    public boolean accept(Auto auto) {
      if (auto.getSpaceAmount() == 1 && carSpace > 0) {
          carSpace--;
          carStorage.add(auto);
          return true;
      } else if (auto.getSpaceAmount()  > 1 && truckSpace > 0) {
            truckSpace--;
            truckStorage.add(auto);
            return true;
        } else if (auto.getSpaceAmount() <= carSpace) {
            carSpace -= auto.getSpaceAmount();
            truckStorage.add(auto);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingJob parkingJob = new ParkingJob(1, 0);
        List<Auto> list = List.of(
                new Car(1, "1"),
                new Car(1, "2"),
                new Car(1, "3"),
                new Car(1, "4"),
                new Car(1, "5"),
                new Truck(2, "11"),
                new Truck(3, "22"),
                new Truck(4, "33"),
                new Truck(5, "44"),
                new Truck(1, "55")
        );
        list.forEach(parkingJob::accept);
        System.out.println("car:");
        System.out.println(parkingJob.carSpace);
        System.out.println("truck:");
        System.out.println(parkingJob.truckSpace);
        System.out.println("car:");
        System.out.println(parkingJob.carStorage.toString());
        System.out.println("truck:");
        System.out.println(parkingJob.truckStorage.toString());

    }

}
