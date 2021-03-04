package ru.geekbrains.lesson02.oop.advanced.obstacle_course;

public class MainApp {
    public static void main(String[] args) {
        Competitor[] competitors = new Competitor[5];
        competitors[0] = new Human("Алеша", 5, 2);
        competitors[1] = new Cat("Барсик", 1, 2);
        competitors[2] = new Cat("Мурка", 2, 22);
        competitors[3] = new Human("Александр", 10, 10);
        competitors[4] = new Human("Михаил", 1, 3);

        Obstacle[] obstacles = new Obstacle[5];
        obstacles[0] = new Track(5);
        obstacles[1] = new Wall(10);
        obstacles[2] = new Track(6);
        obstacles[3] = new Wall(6);
        obstacles[4] = new Track(6);

        for (Competitor competitor : competitors) {
            for (Obstacle obstacle : obstacles) {
                boolean result = obstacle.start(competitor);
                if (!result) break;
            }

        }
    }
}
