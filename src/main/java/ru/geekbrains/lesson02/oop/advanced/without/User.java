package ru.geekbrains.lesson02.oop.advanced.without;

public class User {
    private String name;

    private Bicycle currentBicycle;
    private Car currentCar;
    private Moto currentMoto;

    public User(String name) {
        this.name = name;
    }

    public void startBicycleRide(Bicycle bicycle) {
        if (currentBicycle == bicycle) {
            System.out.println(name + " уже на нем едет");
            return;
        }
        if (currentBicycle != null && currentBicycle != bicycle) {
            System.out.println(name + " не может перепрыгнуть на другой велосипед " + bicycle.getColor());
            return;
        }
        if (currentBicycle == null) {
            bicycle.start(name);
            currentBicycle = bicycle;
        }
    }

    public void stopMotoRide() {
        if (currentMoto != null) {
            currentMoto.stop(name);
            currentMoto = null;
        } else {
            System.out.println(name + " не может остановить мотоцикл, так как его у него нету");
        }
    }

    public void startMotoRide(Moto moto) {
        if (currentMoto == moto) {
            System.out.println(name + " уже на нем едет");
            return;
        }
        if (currentMoto != null && currentMoto != moto) {
            System.out.println(name + " не может перепрыгнуть на другой мотоцикл " + moto.getColor());
            return;
        }
        if (currentMoto == null) {
            moto.start(name);
            currentMoto = moto;
        }
    }

    public void stopBicycleRide() {
        if (currentBicycle != null) {
            currentBicycle.stop(name);
            currentBicycle = null;
        } else {
            System.out.println(name + " не может остановить велосипед, так как его у него нету");
        }
    }

    public void startCarDriving(Car car) {
        if (currentCar == car) {
            System.out.println(name + " уже на нем едет");
            return;
        }
        if (currentCar != null && currentCar != car) {
            System.out.println(name + " не может перепрыгнуть на другую машину " + car.getColor());
            return;
        }
        if (currentCar == null) {
            car.startCar(name);
            currentCar = car;
        }
    }

    public void stopCarDriving() {
        if (currentCar != null) {
            currentCar.stopCar(name);
            currentCar = null;
        } else {
            System.out.println(name + " не может остановить велосипед, так как его у него нету");
        }
    }
}
