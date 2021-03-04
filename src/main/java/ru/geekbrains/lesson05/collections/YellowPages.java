package ru.geekbrains.lesson05.collections;

import java.util.*;

public class YellowPages<K extends Object, T extends Collections> {
    private Map<String, Set> yellowPages = new HashMap<>();
//    private Set<String> phoneNumbers = new HashSet<>();

    public void addToPhoneBook(String name, String number) {
        if (yellowPages.size() > 0) {
            //System.out.println(yellowPages.containsKey(name));
            if (yellowPages.containsKey(name)) {
                //System.out.println(yellowPages.get(name));
                if (yellowPages.get(name).contains(number)) {
                    System.out.println("Номер \"" + number + "\" ранее уже был добавлен абоненту " + name);
                } else {
                    Set<String> existedPhoneNumbers = yellowPages.get(name);
                    existedPhoneNumbers.add(number);
                    yellowPages.put(name, existedPhoneNumbers);
                }
            } else {
                PhoneNumbers phoneNumbers = new PhoneNumbers();
                phoneNumbers.addToPhoneNumbers(number);
                yellowPages.put(name, phoneNumbers.getPhoneNumbers());
            }
        } else {
            PhoneNumbers phoneNumbers = new PhoneNumbers();
            phoneNumbers.addToPhoneNumbers(number);
            yellowPages.put(name, phoneNumbers.getPhoneNumbers());
            //System.out.println(yellowPages);
        }
    }

    public void findPhoneNumbersByName(String name) {
        int count = 0;
        for (Map.Entry<String, Set> entry : yellowPages.entrySet()) {
            //System.out.println(entry.getKey());
            if (entry.getKey().contains(name)) {
                System.out.println("Абонент: " + entry.getKey() + ", номер(а): " + entry.getValue() + ".");
                count++;
            }
        }
        System.out.println("Общее количество найденых записей: " + count);
    }


    public void printPhoneBook() {
        System.out.println(yellowPages);
    }
}


//            for (Map.Entry<String, Set> entry : yellowPages.entrySet()) {
//                System.out.println(entry.getKey());
//                if (entry.getKey().equals(name)){
//                    Set<String> numbers = entry.getValue();
//                    if (numbers.contains(number)){
//                        System.out.println("Номер \"" + number + "\" ранее уже был добавлен абоненту " + name);
//                    } else {
//                        numbers.add(number);
//                        yellowPages.put(name,numbers);
//                    }
//                    Реализация через цикл
//                    for (String numberEntry : numbers){
//                        if (numberEntry.equals(number)){
//                            System.out.println("Номер \"" + number + "\" уже добавлен абоненту " + name);
//                        } else {
//                            numbers.add(number);
//                            yellowPages.put(name,numbers);
//                        }
//                    }
//                }
//            }
