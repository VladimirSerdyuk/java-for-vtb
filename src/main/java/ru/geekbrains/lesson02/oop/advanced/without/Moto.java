package ru.geekbrains.lesson02.oop.advanced.without;

public class Moto {
    private String color;

    public Moto(String color) {
        this.color = color;
    }

    public void start(String username) {
        System.out.println(username + " поехал на мотоцикле [ " + color + " ]");
    }

    public void stop(String username) {
        System.out.println(username + " остановился и слез с мотоцикла [ " + color + " ]");
    }

    public String getColor() {
        return color;
    }
}
