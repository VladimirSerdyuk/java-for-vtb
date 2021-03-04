package ru.geekbrains.lesson02.oop.advanced.obstacle_course;

public class Wall implements Obstacle {
    private int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override
    public boolean start(Competitor competitor) {
        return competitor.startJump(wallHeight);
    }
}