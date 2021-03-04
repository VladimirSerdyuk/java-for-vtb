package ru.geekbrains.lesson02.oop.advanced.without;

public class Bicycle {
    private String color;

    public Bicycle(String color) {
        this.color = color;
    }

    public void start(String username) {
        System.out.println(username + " поехал на велосипеде [ " + color + " ]");
    }

    public void stop(String username) {
        System.out.println(username + " остановился и слез с велосипеда [ " + color + " ]");
    }

    public String getColor() {
        return color;
    }
}
