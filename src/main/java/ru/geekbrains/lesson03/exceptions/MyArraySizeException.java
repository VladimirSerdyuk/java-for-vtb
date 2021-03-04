package ru.geekbrains.lesson03.exceptions;

public class MyArraySizeException extends RuntimeException {
    private int currArg1;
    private int currArg2;
    private int maxPermArg1;
    private int maxPermArg2;

    public int getCurrArg1() {
        return currArg1;
    }

    public int getCurrArg2() {
        return currArg2;
    }

    public int getMaxPermArg1() {
        return maxPermArg1;
    }

    public int getMaxPermArg2() {
        return maxPermArg2;
    }

    public MyArraySizeException(int currArg1, int currArg2, int maxPermArg1, int maxPermArg2) {
        super("ОШИБКА: Длинна массива не соответствует требуемым размерам! Требуемые параметры: " + maxPermArg1 + "x" + maxPermArg2 + ". Текущие параметры: " + currArg1 + "x" + currArg2 + ".");
        this.currArg1 = currArg1;
        this.currArg2 = currArg2;
        this.maxPermArg1 = maxPermArg1;
        this.maxPermArg2 = maxPermArg2;
    }
}
