package ru.geekbrains.lesson04.generics.home_work;

import java.util.ArrayList;
import java.util.List;

public class Box<F extends Fruit> {
    private List<F> elements = new ArrayList<>();

    public List<F> getElements() {
        return elements;
    }

    public void putFruit(F fruit) {
        elements.add(fruit);
    }

    public float getWeight() {
        float total = 0;
        for (F element : elements) {
            total += element.getFruitWeight();
        }
        return total;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void shiftFruitsFromAnotherBox(Box<?> anotherBox) {
        List<F> anotherArray = (List<F>) anotherBox.getElements();
        System.out.println(elements.get(0).getClass());
        System.out.println(anotherArray.get(0).getClass());
        if (anotherArray.get(0).getClass().equals(elements.get(0).getClass())) {
            for (int i = 0; i < anotherArray.size(); i++) {
                elements.add(anotherArray.get(i));
                anotherArray.clear();
            }
        } else {
            throw new BoxDataMismatchException("ОШИБКА: вы пытаетесь положить яблоки в коробку с апельсинами.");
        }
    }
}
