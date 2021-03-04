package ru.geekbrains.lesson07.reflection_api;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Class demoClass = DemoClass.class;
        TestStarter testStarter = new TestStarter(demoClass);
        testStarter.start();
    }
}
