package ru.job4j.ood.ocp;

import java.util.List;

public class Gun {
    public void shot() {
        System.out.println("...");
    }

    public static class Pistol extends Gun {

        public void shot() {
            System.out.println("Puff");
        }
    }

    public static class MachineGun extends Gun {

        public void shot() {
            System.out.println("Tra-ta-ta...");
        }
    }

    public static class GrenadeGun extends Gun {

        public void shot() {
            System.out.println("Boom...");
        }
    }

    /*
    * Расширили за счет наследования,
    * но класс изначально спроектирован неверно,
    * так как штык - холодное оружие и не может стрелять,
    *  нужно делать изначально с помощью интерфейса
    * */
    public static class Bayonet extends Gun {

        public void shot() {
            System.out.println("Bayonet does not shoot ...");
        }
    }

    public static void main(String[] args) {
        List<Gun> guns = List.of(new Pistol(), new MachineGun(), new GrenadeGun(), new Bayonet());
        guns.forEach(Gun::shot);
    }

}


