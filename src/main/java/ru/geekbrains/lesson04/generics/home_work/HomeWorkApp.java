package ru.geekbrains.lesson04.generics.home_work;

import java.util.ArrayList;

public class HomeWorkApp {
    public static void main(String[] args) {

        // Задание 1:
        System.out.println("Задание 1:"); // Прочто, что б разделить вывод в консоли 3-х заданий одновременно.
        int[] array = new int[]{6, 3, 7, 1, 9, 2, 3, 8, 5, 0};
        int firstElementIndex = 3;
        int secondElementIndex = 6;
        // Выводим масив на экран
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        // Производим замену элементов массива
        if (firstElementIndex < secondElementIndex) {
            if (firstElementIndex < array.length && secondElementIndex < array.length) {
                int temp = array[firstElementIndex];
                array[firstElementIndex] = array[secondElementIndex];
                array[secondElementIndex] = temp;
            } else {
                System.out.println("Ошибка: заданные значения ме могут превышать размер самого массива!");
            }
        } else {
            System.out.println("Ошибка: первый элемент массива, который надо заменить не может быть больше второго элемента массива, с которым его надо поменять местами!");
        }
        // Выводим изменёный массив на экран
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // Прочто, что б разделить вывод в консоли 3-х заданий одновременно.
        System.out.println(); // Прочто, что б разделить вывод в консоли 3-х заданий одновременно.


        // Задание 2:
        System.out.println("Задание 2:"); // Прочто, что б разделить вывод в консоли 3-х заданий одновременно.
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        System.out.println(arrayList);
        System.out.println(); // Прочто, что б разделить вывод в консоли 3-х заданий одновременно.


        // Задание 3:
        System.out.println("Задание 3:"); // Прочто, что б разделить вывод в консоли 3-х заданий одновременно.
        Box<Apple> apples = new Box();
        apples.putFruit(new Apple());
        apples.putFruit(new Apple());
        apples.putFruit(new Apple());
        System.out.println("Общий вес коробки с яблоками: " + apples.getWeight());

        Box<Orange> oranges = new Box();
        oranges.putFruit(new Orange());
        oranges.putFruit(new Orange());
        oranges.getWeight();
        System.out.println("Общий вес коробки с апельсинами: " + oranges.getWeight());

        if (apples.compare(oranges)) {
            System.out.println("Массы коробок равны.");
        } else {
            System.out.println("Массы коробок не равны.");
        }

        System.out.println("Масса первой коробки с апельсинами до объединения равна: " + oranges.getWeight());
        Box<Orange> oranges2 = new Box();
        oranges2.putFruit(new Orange());
        oranges2.putFruit(new Orange());
        System.out.println("Масса второй коробки с апельсинами до объединения с первой коробкой: " + oranges2.getWeight());
        oranges.shiftFruitsFromAnotherBox(oranges2);
        System.out.println("Масса первой коробки с апельсинами после объединения со второй коробкой: " + oranges.getWeight());
        System.out.println("Масса второй коробки с апельсинами после объединения с первой коробкой: " + oranges2.getWeight());


        Box<Orange> oranges3 = new Box();
        oranges3.putFruit(new Orange());
        oranges3.putFruit(new Orange());
        oranges.shiftFruitsFromAnotherBox(apples);
        System.out.println("Масса первой коробки с апельсинами после папытки объединения с коробкой с яблоками: " + oranges.getWeight());
    }
}
//        Rock[] rocks = {new Rock(10), new Rock(15), new Rock(5), new Rock(7), new Rock(22)};
//        System.out.println(Arrays.toString(rocks));
//        Arrays.sort(rocks);
//        System.out.println(Arrays.toString(rocks));
//
//        String[] strings = {"ZZ", "AAAAAA", "BBB", "BB", "CCCCC", "D"};
//        System.out.println(Arrays.toString(strings));
//        Arrays.sort(strings, (s, t1) -> s.length() - t1.length());
//        System.out.println(Arrays.toString(strings));
//
//        BoxWithNumbers bwn = new BoxWithNumbers();

//        SimpleBox box1 = new SimpleBox(10);
//        SimpleBox box2 = new SimpleBox(20);
//        // ...
//        // box1.setObj("Java");
//        // ...
//        if (box1.getObj() instanceof Integer && box2.getObj() instanceof Integer) {
//            int sum = (Integer) box1.getObj() + (Integer) box2.getObj();
//            System.out.println(sum);
//        }

//        GenBox<Integer> gbInt1 = new GenBox<>(10);
//        GenBox<Integer> gbInt2 = new GenBox<>(20);
//        int sum = gbInt1.getObj() + gbInt2.getObj();
//        System.out.println(sum);
//
//        GenBox<String> gbStr = new GenBox<>("Java");
//
//        TwoGenBox<String, Integer> tgBox = new TwoGenBox<>("A", 100);

//        BoxWithNumbers<Integer> bn1 = new BoxWithNumbers<>(15, 15, 30);
//        BoxWithNumbers<Integer> bn2 = new BoxWithNumbers<>(10, 20, 30);
//        BoxWithNumbers<Float> bf1 = new BoxWithNumbers<>(10.0f, 20.0f, 30.0f);
//        System.out.println(bn1.sameAverage(bn2));
//        System.out.println(bn1.sameAverage(bf1));
//
//        System.out.println(bn1.getClass().getName());
//        System.out.println(bf1.getClass().getName());
//
//        String[] sarr = {"A", "B", "C"};
//        String resS = getFirstElement(sarr);
//        Integer[] iarr = {1, 2, 3};
//        Integer resI = getFirstElement(iarr);

//        Number n = new Integer(1000);
//        ArrayList<Number> listN = new ArrayList<>();
//
//        ArrayList<String> numbers = new ArrayList<>();
//        numbers.add("A");
//        numbers.add("Z");
//
//    }
//
//    public static double getSum(ArrayList<? extends Number> numbers) {
//        double sum = 0.0;
//        for (int i = 0; i < numbers.size(); i++) {
//            sum += numbers.get(i).doubleValue();
//        }
//        return sum;
//    }
//
//    public static <T> T getFirstElement(ArrayList<T> list) {
//        return list.get(0);
//    }
//
//    public static <T> T getFirstElement(T[] array) {
//        return array[0];
//    }
//}