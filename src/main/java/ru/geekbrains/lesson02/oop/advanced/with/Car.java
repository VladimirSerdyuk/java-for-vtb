package ru.geekbrains.lesson02.oop.advanced.with;

public class Car implements Transport {
    private String model;
    private String color;

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public void start(String username) {
        System.out.println(username + " поехал на машине");
    }

    @Override
    public void stop(String username) {
        System.out.println(username + " остановился и вышел с машины");
    }
}
