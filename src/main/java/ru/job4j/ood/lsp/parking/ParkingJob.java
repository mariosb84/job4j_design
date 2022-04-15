package ru.job4j.ood.lsp.parking;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

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
      if (auto.getSpaceAmount() == 1 && truckSpace > 0) {
          truckSpace--;
          carStorage.add(auto);
          return true;
      } else if (auto.getSpaceAmount()  > 1 && carSpace > 0) {
            carSpace--;
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
        ParkingJob parkingJob = new ParkingJob(10, 50);
        Auto car = new Car(1, "1");
        Auto car2= new Car(1, "2");
        Auto car3 = new Car(1, "3");
        Auto car4 = new Car(1, "4");
        Auto car5 = new Car(1, "5");
        Auto truck = new Truck(2, "11");
        Auto truck2 = new Truck(3, "22");
        Auto truck3 = new Truck(4, "33");
        Auto truck4 = new Truck(5, "44");
        Auto truck5 = new Truck(10, "55");
        System.out.println(parkingJob.accept(car));
    }

}
