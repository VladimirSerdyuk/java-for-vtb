package ru.geekbrains.lesson02.oop.advanced.without;

public class MainApp {
    // Alt + Insert (code auto-generation)
    // Ctrl + Alt + L reformat
    // Alt + Enter import
    // Alt + 1
    // Ctrl + / - comment
    // Ctrl + X, Ctrl + D
    // Ctrl + Alf + F - поиск текста по проекту
    // Ctrl + Alf + N - поиск файла
    // Shift + F10 - запуск
    // Ctrl + P - подсказка по спискам аргументов методов и конструкторов
    // Ctrl + LMouse по методу/классу - прыжок в код метода/класса

    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle("Red");
        Bicycle bicycle2 = new Bicycle("Green");

        User user = new User("Bob");

        user.startBicycleRide(bicycle);
        user.startBicycleRide(bicycle2);
    }
}
