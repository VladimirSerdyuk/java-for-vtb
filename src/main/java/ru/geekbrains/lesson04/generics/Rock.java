package ru.geekbrains.lesson04.generics;

public class Rock implements Comparable<Rock> {
    private int size;

    public Rock(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Rock o) {
        return this.size - o.size;
    }

    @Override
    public String toString() {
        return "Rock{" +
                "size=" + size +
                '}';
    }
}
