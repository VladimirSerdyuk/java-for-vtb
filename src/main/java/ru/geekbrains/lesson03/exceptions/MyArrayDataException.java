package ru.geekbrains.lesson03.exceptions;

public class MyArrayDataException extends RuntimeException {
    private int arrayRow;
    private int arrayColumn;

    public int getArrayRow() {
        return arrayRow;
    }

    public int arrayColumn() {
        return arrayColumn;
    }

    public MyArrayDataException(int arrayRow, int arrayColumn) {
        super("При преобразовании данных массива произошла ошибка. Элемент массива с некорректным типом данных:\nСтрока массива: " + arrayRow + "\nСтолбец массива: " + arrayColumn);
        this.arrayRow = arrayRow;
        this.arrayColumn = arrayColumn;
    }
}