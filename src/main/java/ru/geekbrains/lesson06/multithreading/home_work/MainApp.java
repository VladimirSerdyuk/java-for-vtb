package ru.geekbrains.lesson06.multithreading.home_work;

public class MainApp {
    public static void main(String[] args) {
        int size = 10000000;
        float[] nullArray = new float[size];
        Array array = new Array(nullArray);
        array.fillArrayByNumbers(1);
        System.out.println(array.runSingleThreadProcessing());
//        array.printArray();
        System.out.println(array.runMultiThreadProcessing());
//        array.printArray();
    }
}
