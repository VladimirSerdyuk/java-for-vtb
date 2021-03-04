package ru.geekbrains.lesson02.oop.advanced.in_out_classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() throws HeadlessException {
        setBounds(500, 300, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setTitle("ABC");

//        JButton button1 = new JButton("1");
//        JButton button2 = new JButton("2");
//        JButton button3 = new JButton("3");
//        JButton button4 = new JButton("4");
//        add(button1);
//        add(button2);
//        add(button3);
//        add(button4);
//
//        button1.addActionListener(new Button1ActionListener());
//        button2.addActionListener(new Button2ActionListener());
//        button3.addActionListener(new Button3ActionListener());
//        button4.addActionListener(new Button4ActionListener());

        for (int i = 0; i < 100; i++) {
            int w = i + 1;
            JButton btn = new JButton(String.valueOf(i + 1));
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println(w);
                }
            });

            // public class MyWindow$1 implements ActionListener {
            //   @Override
            //   public void actionPerformed(ActionEvent actionEvent) {
            //      System.out.println(w);
            //   }
            // }
            // MyWindow$1 obj = new MyWindow$1();
            // btn.addActionListener(obj);

            Animal animal = new Animal() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            };
            // public class MyWindow$2 extends Animal {
            // }
            // MyWindow$2 obj = new MyWindow$2();

            add(btn);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}
