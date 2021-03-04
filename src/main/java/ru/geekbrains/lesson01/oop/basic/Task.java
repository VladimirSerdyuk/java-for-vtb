package ru.geekbrains.lesson01.oop.basic;

public class Task {
    private String id;
    private String name;
    private String owner;
    private String executor;
    private String description;
    private String status;

    public Task() {
        this.id = "Unknown";
        this.name = "Unknown";
        this.owner = "Unknown";
        this.executor = "Unknown";
        this.description = "Unknown";
        this.status = "Unknown";
    }

    public Task(String id, String name, String owner, String executor, String description, String status) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.executor = executor;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setStatus(String status) {
        if (status != "") {
            this.status = status;
        } else {
            this.status = "NULL";
        }
    }

    public void taskInfo() {
        System.out.println("Task ID: " + id + ", Task name: " + name + ", Task owner: " + owner + ", Task executor: " + executor + ", Task description: " + description + ", Task status: " + status + ";");
    }
}
