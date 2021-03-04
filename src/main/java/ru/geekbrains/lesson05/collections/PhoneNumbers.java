package ru.geekbrains.lesson05.collections;

import java.util.HashSet;
import java.util.Set;

public class PhoneNumbers {
    private Set<String> phoneNumbers = new HashSet<>();

    public void addToPhoneNumbers(String number) {
        this.phoneNumbers.add(number);
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }
}
