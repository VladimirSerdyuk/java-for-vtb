package ru.geekbrains.lesson02.oop.advanced.in_out_classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1ActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(1);
    }
}
