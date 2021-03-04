package ru.geekbrains.lesson03.exceptions;

public class MyArray {
    private String[][] myArray;
    private String message;
    private int arrayRow;
    private int arrayColumn;
    private int myArrayElementsTotalCount;

    public MyArray(int a, int b) {
        myArray = new String[a][b];
    }

    public String[][] getMyArray() {
        return myArray;
    }

    public int getMyArrayElementsTotalCount() {
        return myArrayElementsTotalCount;
    }

    public void printMyArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.err.print(array[i][j] + " ");
            }
            System.err.println();
        }
    }

    public boolean checkMyArraySize(int maxPermArg1, int maxPermArg2) {
        System.err.println("=== Производим проверку размера созданного массива");
        if (myArray.length == maxPermArg1 && myArray[0].length == maxPermArg2) {
            return true;
        } else {
            throw new MyArraySizeException(myArray.length, myArray[0].length, maxPermArg1, maxPermArg2);
        }
    }

    public void fillMyArray() {
        System.err.println("=== Производим наполнение текстового массива цифрами");
        this.myArray = new String[][]{{"0", "1", "2", "3"}, {"4", "5", "6", "7"}, {"8", "9", "0", "11"}, {"12", "13", "14", "15"}};
    }

    public boolean aggregateMyArrayElements(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            arrayRow = i + 1;
            for (int j = 0; j < array[0].length; j++) {
                arrayColumn = j + 1;
//                myArrayElementsTotalCount = myArrayElementsTotalCount + Integer.parseInt(array[i][j]);
                try {
                    myArrayElementsTotalCount = myArrayElementsTotalCount + Integer.parseInt(array[i][j]);
//                } catch (MyArrayDataException e) {
//                    e.printStackTrace();
//                }
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(arrayRow, arrayColumn);
                }
            }
            System.err.println("=== Общая сумма елементов " + arrayRow + "-й строки массива равна: " + myArrayElementsTotalCount);
        }
        System.err.println("=== Общая сумма елементов всего массива равна: " + myArrayElementsTotalCount);
        return true;
    }
}