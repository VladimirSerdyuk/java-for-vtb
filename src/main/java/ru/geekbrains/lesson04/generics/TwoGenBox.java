package ru.geekbrains.lesson04.generics;

public class TwoGenBox<T, K> {
    private T obj1;
    private K obj2;

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public K getObj2() {
        return obj2;
    }

    public void setObj2(K obj2) {
        this.obj2 = obj2;
    }

    public TwoGenBox(T obj1, K obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
}
