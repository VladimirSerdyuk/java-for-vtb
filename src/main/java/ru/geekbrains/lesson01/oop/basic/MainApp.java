package ru.geekbrains.lesson01.oop.basic;

public class MainApp {
    public static void main(String[] args) {

        TaskTracker taskTracker = new TaskTracker();
/*
        taskTracker.createSetOfTasks(10);
        System.out.println();
        taskTracker.printSetOfTasks(10);
        System.out.println();
        taskTracker.deleteTaskById("0001");
        taskTracker.printSetOfTasks(10);
    }
}
*/
        taskTracker.createTaskTracker(2);
        taskTracker.addTaskToTaskTracker("0001", "Form Csd Request", "CMO", "Vladimir Serdyuk", "Form Csd Request", "In Work");
        taskTracker.addTaskToTaskTracker("0002", "Form Csd Request", "CMO", "Vladimir Serdyuk", "Form Csd Request", "In Progress");
        taskTracker.addTaskToTaskTracker("0003", "Form Csd Request", "CMO", "Vladimir Serdyuk", "Form Csd Request", "Resolved-Completed");
        taskTracker.printSetOfTasks(2);
    }
}