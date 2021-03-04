package ru.geekbrains.lesson04.generics;

public class MainApp {
    public static void main(String[] args) {
/*
         Значения, применяемые при использовании дженериков в JDK:
         E - Element
         K - Key
         N - Number
         T - Type
         V - Value
*/

//        Rock[] rocks = {new Rock(10), new Rock(15), new Rock(5), new Rock(7), new Rock(22)};
//        System.out.println(Arrays.toString(rocks));
//        Arrays.sort(rocks);
//        System.out.println(Arrays.toString(rocks));

//        String[] strings = {"ZZ", "AAAAAA", "BBB", "BB", "CCCCC", "D"};
//        System.out.println(Arrays.toString(strings));
//        Arrays.sort(strings, (s, t1) -> s.length() - t1.length());
//        System.out.println(Arrays.toString(strings));
//
//        BoxWithNumbers bwn = new BoxWithNumbers();

        SimpleBox box1 = new SimpleBox(10);
        SimpleBox box2 = new SimpleBox(20);
        // ...
        // box1.setObj("Java");
        // ...
        if (box1.getObj() instanceof Integer && box2.getObj() instanceof Integer) {
            int sum = (Integer) box1.getObj() + (Integer) box2.getObj();
            System.out.println(sum);
        }

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
    }
}