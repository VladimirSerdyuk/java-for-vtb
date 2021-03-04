package ru.geekbrains.lesson09.jvm_gc_jdbc;

@DbTable(title = "student")
public class Student {
    @DbId
    private int id;

    @DbColumn
    private String firstName;

    @DbColumn
    private String lastName;

    @DbColumn
    private int age;

    @DbColumn
    private String sex;

    @DbColumn
    private int score;

    private String address;

    public Student(int id, String firstName, String lastName, int age, String sex, int score, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.score = score;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public int getScore() {
        return score;
    }

    public String getAddress() {
        return address;
    }
}
