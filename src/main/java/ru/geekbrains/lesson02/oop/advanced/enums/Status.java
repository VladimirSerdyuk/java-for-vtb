package ru.geekbrains.lesson02.oop.advanced.enums;

public enum Status {
    CREATED(10), PROCESSING(5), CLOSED(2), REJECTED(1);

    private int priority;

    public int getPriority() {
        return priority;
    }

    Status(int priority) {
        this.priority = priority;
    }
}
