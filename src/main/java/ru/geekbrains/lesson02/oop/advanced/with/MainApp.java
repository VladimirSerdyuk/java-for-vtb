package ru.geekbrains.lesson02.oop.advanced.with;

public class MainApp {
    public static void main(String[] args) {
        Transport car = new Car("X100", "Green");
        Transport bicycle = new Bicycle("Green");
        Transport moto = new Moto("Purple");

        User user = new User("Bob");
        user.drive(car);
        user.drive(bicycle);
        user.stop();
        user.drive(bicycle);
        user.stop();
        user.drive(moto);
        user.stop();

        Transport t = new Transport() {
            @Override
            public void start(String username) {

            }

            @Override
            public void stop(String username) {

            }
        };
        System.out.println(t.getClass().getName());
    }
}
