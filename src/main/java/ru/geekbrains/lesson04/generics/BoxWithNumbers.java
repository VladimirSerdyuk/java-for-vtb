package ru.geekbrains.lesson04.generics;

public class BoxWithNumbers<N extends Number> {
    private N[] array;

    public BoxWithNumbers(N... array) {
        this.array = array;
    }

    public double average() {
        double out = 0.0;
        for (int i = 0; i < array.length; i++) {
            out += array[i].doubleValue();
        }
        out /= array.length;
        return out;
    }

    public boolean sameAverage(BoxWithNumbers<?> another) {
        return Math.abs(this.average() - another.average()) < 0.001;
    }
}
