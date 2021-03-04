package ru.geekbrains.lesson02.oop.advanced.without;

public class Car {
    public void startCar(String username) {
        System.out.println(username + " поехал на машине");
    }

    public void stopCar(String username) {
        System.out.println(username + " остановился и вышел с машины");
    }

    public String getColor() {
        return "Red";
    }
}
