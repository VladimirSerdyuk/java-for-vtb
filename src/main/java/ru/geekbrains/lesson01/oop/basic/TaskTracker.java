package ru.geekbrains.lesson01.oop.basic;

public class TaskTracker {
    Task[] tasks = new Task[10];
    boolean isFull = true;
    int listIndex = 0;
    int arrayElementsCount;


    public void createTaskTracker(int capacity) {
        Task[] tasks = new Task[capacity];
        System.out.println(tasks.length);
    }

    public void addTaskToTaskTracker(String id, String name, String owner, String executor, String description, String status) {
        Task[] tasks = new Task[2];
        for (int listIndex = 0; listIndex < tasks.length; listIndex++) {
            if (tasks[listIndex] == null) {
                isFull = false;
                break;
            }
        }
        if (isFull) {
            System.out.println("Список задач заполнен");
        } else {
            tasks[listIndex] = new Task(id, name, owner, executor, description, status);
            System.out.println(isFull);
            System.out.println(listIndex);
            tasks[listIndex].taskInfo();
        }
    }

    public void printSetOfTasks(int countTasksForPrint) {
        for (int i = 0; i < tasks.length; i++) {
            if (i < countTasksForPrint) {
                tasks[i].taskInfo();
            } else {
                break;
            }
        }
    }

    public void deleteTaskById(String taskId) {
        arrayElementsCount = tasks.length;
        for (int i = 0; i < arrayElementsCount; i++) {
            if (taskId.equals(tasks[i].getId())) {
                listIndex = i;
                break;
            }
            for (int j = listIndex; j < arrayElementsCount - 1; j++) {
                tasks[j] = tasks[j + 1];
            }
            tasks[arrayElementsCount] = null;
        }
    }
}