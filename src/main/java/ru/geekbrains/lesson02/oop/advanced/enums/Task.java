package ru.geekbrains.lesson02.oop.advanced.enums;

public class Task {
    private String title;
    private Status status;

    public Task(String title) {
        this.title = title;
        this.status = Status.REJECTED;
    }
}
