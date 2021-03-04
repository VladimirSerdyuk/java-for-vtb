package ru.geekbrains.lesson06.multithreading.home_work;

public class Array {
    private float[] array;
    long a;

    public Array(float[] array) {
        this.array = array;
    }

    public void fillArrayByNumbers(int number) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
        }
    }

    public long runSingleThreadProcessing() {
        a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return (System.currentTimeMillis() - a) / 1000;
    }

    public long runMultiThreadProcessing() {
        int size = array.length / 2;
        float[] part1 = new float[size];
        float[] part2 = new float[size];
        a = System.currentTimeMillis();
        System.arraycopy(array, 0, part1, 0, size);
        System.arraycopy(array, size, part2, 0, size);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < part1.length; i++) {
                    part1[i] = (float) (part1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < part2.length; i++) {
                    part2[i] = (float) (part2[i] * Math.sin(0.2f + (size + i) / 5) * Math.cos(0.2f + (size + i) / 5) * Math.cos(0.4f + (size + i) / 2));
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.arraycopy(part1, 0, array, 0, 5);
            System.arraycopy(part2, 0, array, 5, 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (System.currentTimeMillis() - a) / 1000;
    }

//        System.out.println(part1.length);
//        for (int i=0; i< part1.length; i++){
//            System.out.print(part1[i]+" ");
//        }
//        System.out.println();
//        System.out.println(part2.length);
//        for (int i=0; i< part2.length; i++){
//            System.out.print(part2[i]+" ");
//        }
//        System.out.println();
//
//        for (int i=0; i< part1.length; i++){
//            part1[i] = (float)(part1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        for (int i=0; i< part1.length; i++){
//            System.out.print(part1[i]+" ");
//        }
//
//        System.out.println();
//
//        for (int i=0; i< part2.length; i++){
//            part2[i] = (float)(part2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        for (int i=0; i< part2.length; i++){
//            System.out.print(part2[i]+" ");
//        }
//        System.out.println();
//        System.out.println(size);
//
//        System.arraycopy(part1, 0,array,0, 5);
//        System.arraycopy(part2,0,array,5,5);
//
//        for (int i=0; i< array.length; i++){
//            System.out.println(array[i]+" ");
//        }
//        return (System.currentTimeMillis() - a)/1000;
//    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

}
