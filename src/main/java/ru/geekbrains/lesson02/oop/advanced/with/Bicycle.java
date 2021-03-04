package ru.geekbrains.lesson02.oop.advanced.with;

public class Bicycle implements Transport {
    private String color;

    public String getColor() {
        return color;
    }

    public Bicycle(String color) {
        this.color = color;
    }

    @Override
    public void start(String username) {
        System.out.println(username + " поехал на велосипеде [ " + color + " ]");
    }

    @Override
    public void stop(String username) {
        System.out.println(username + " остановился и слез с велосипеда [ " + color + " ]");
    }
}
