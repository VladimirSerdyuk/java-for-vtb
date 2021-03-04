package ru.geekbrains.lesson02.oop.advanced.obstacle_course;

public class Track implements Obstacle {
    private int trackDistance;

    public Track(int trackDistance) {
        this.trackDistance = trackDistance;
    }

    @Override
    public boolean start(Competitor competitor) {
        return competitor.startRun(trackDistance);
    }
}
