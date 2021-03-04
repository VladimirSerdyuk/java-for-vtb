package ru.geekbrains.lesson02.oop.advanced.obstacle_course;

public class Human implements Competitor {
    private String name;
    private int maxHeightToJump;
    private int maxDistanceToRun;

    public Human(String name, int maxHeightToJump, int maxDistanceToRun) {
        this.name = name;
        this.maxHeightToJump = maxHeightToJump;
        this.maxDistanceToRun = maxDistanceToRun;
    }

    @Override
    public boolean startJump(int height) {
        System.out.println("Человек " + name + " пытается прыгнуть на стену высотой " + height + " метров.");
        if (height > maxHeightToJump) {
            System.out.println("Человек " + name + " не допрыгнул(а) до верха стены.");
            return false;
        } else {
            System.out.println("Человек " + name + " успешно приодолел(а) стену высотой в " + height + " метров.");
            return true;
        }
    }

//    @Override
//    public int getMaxDistanceToJump() {
//        return maxHeightToJump;
//    }

    @Override
    public boolean startRun(int distance) {
        System.out.println("Человек " + name + " начал(а) бежать дистанцию " + distance + " километров.");
        if (distance > maxDistanceToRun) {
            System.out.println("Человек " + name + " не добежал(а) дистанцию.");
            return false;
        } else {
            System.out.println("Человек " + name + " успешно приодолел(а) дистанцию длинной " + distance + " километров.");
            return true;
        }
    }

//    @Override
//    public int getMaxDistanceToRun() {
//        return maxDistanceToRun;
//    }
}
