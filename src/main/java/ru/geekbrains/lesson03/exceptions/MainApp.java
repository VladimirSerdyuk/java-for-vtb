package ru.geekbrains.lesson03.exceptions;

public class MainApp {
    public static void main(String[] args) {
        int argument1 = 4; // количество создаваемых одномерных массивов в двумерном массиве
        int argument2 = 4; // размер каждого одномерного массива
        int maxPermittedArg1 = 4; // требуемое значение аргумента 1
        int maxPermittedArg2 = 4; // требуемое значение аргумента 2
        boolean isArraySizeCheckSuccessful = false; // флаг успешной проверки размера массива требуемым значениям
        boolean isArrayElementsAggregated = false; // флаг успешной агрегации эллементов массива

        System.err.println("=== Производим создание текстового массива размером " + argument1 + "x" + argument2);
        MyArray myArray = new MyArray(argument1, argument2);
        System.err.println("=== Результат:");
        myArray.printMyArray(myArray.getMyArray());

        try {
            isArraySizeCheckSuccessful = myArray.checkMyArraySize(maxPermittedArg1, maxPermittedArg2);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        if (isArraySizeCheckSuccessful) {
            System.err.println("=== Результат проверки размера массива: УСПЕШНО");
            myArray.fillMyArray();
            System.err.println("=== Результат:");
            myArray.printMyArray(myArray.getMyArray());
            try {
                isArrayElementsAggregated = myArray.aggregateMyArrayElements(myArray.getMyArray());
            } catch (MyArrayDataException e) {
                e.printStackTrace();
            }

            if (isArrayElementsAggregated) {
                System.err.println("=== Работа программы успешно завершена.");
            } else {
                System.err.println("=== Результат аггрегирования элементов массива: ОШИБКА. Работа программы завершена.");
            }

        } else {
            System.err.println("=== Результат проверки размера массива: ОШИБКА. Работа программы завершена.");
        }
    }
}
