package ru.geekbrains.lesson02.oop.advanced.with;

public class User {
    private String name;
    private Transport currentTransport;

    public User(String name) {
        this.name = name;
    }

    public void drive(Transport transport) {
        if (currentTransport == transport) {
            System.out.println(name + " уже на нем едет");
            return;
        }
        if (currentTransport != null && currentTransport != transport) {
            System.out.println(name + " не может перепрыгнуть на другой транспорт");
            return;
        }
        if (currentTransport == null) {
            transport.start(name);
            currentTransport = transport;
        }
    }

    public void stop() {
        if (currentTransport != null) {
            currentTransport.stop(name);
            currentTransport = null;
        } else {
            System.out.println(name + " не может остановить транспорт, так как его у него нету");
        }
    }
}
