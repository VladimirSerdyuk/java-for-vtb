package ru.geekbrains.lesson05.collections;

import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Задание 1: Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).");
        // Реализация 1:
        List<String> dictionary = Arrays.asList(
                "Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять",
                "Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять");
        System.out.println(dictionary);
        List<String> uniqueElements = dictionary.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueElements);
        // Реализация 2:
        List<String> dictionary2 = Arrays.asList(
                "Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять",
                "Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять");
        System.out.println(dictionary2);
        Set<String> uniqueElements2 = new LinkedHashSet<String>(dictionary2);
        System.out.println(uniqueElements2);
        // Посчитать, сколько раз встречается каждое слово.
        for (int i = 0; i < uniqueElements.size(); i++) {
            int counter = 0;
            for (int j = 0; j < dictionary.size(); j++) {
                if (dictionary.get(j).equals(uniqueElements.get(i))) {
                    counter++;
                }
            }
            System.out.println("Слово \"" + uniqueElements.get(i) + "\" встречается в массиве " + counter + " раз(а).");
        }
        System.out.println();

        System.out.println("Задание 2:");
        YellowPages<Object, Collections> phonebook = new YellowPages<>();
        phonebook.addToPhoneBook("Сердюк Владимир Юрьевич", "+79261111111");
        phonebook.addToPhoneBook("Сердюк Владимир Юрьевич", "+79261111112");
        phonebook.addToPhoneBook("Сердюк Владимир Юрьевич", "+79261111113");
        phonebook.addToPhoneBook("Сердюк Владимир Юрьевич", "+79261111113");
        phonebook.addToPhoneBook("Иванов Иван Иванович", "+79037548692");
        phonebook.addToPhoneBook("Иванов Иван Иванович", "+79098546813");
        phonebook.addToPhoneBook("Иванов Николай Иванович", "+79085216235");
        phonebook.addToPhoneBook("Иванов Алексей Иванович", "+79169562486");
        phonebook.addToPhoneBook("Сидоров Василий Иванович", "+79192596487");
        phonebook.addToPhoneBook("Сидорова Анна Вячеславовна", "+79205963845");
        phonebook.printPhoneBook();
        phonebook.findPhoneNumbersByName("Иванов");
    }
}
