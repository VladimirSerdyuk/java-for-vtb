package ru.geekbrains.lesson02.oop.advanced.with;

public class Moto implements Transport {
    private String color;

    public String getColor() {
        return color;
    }

    public Moto(String color) {
        this.color = color;
    }

    @Override
    public void start(String username) {
        System.out.println(username + " поехал на мотоцикле [ " + color + " ]");
    }

    @Override
    public void stop(String username) {
        System.out.println(username + " остановился и слез с мотоцикла [ " + color + " ]");
    }
}
