package homework8;

import homework8.obstacles.*;
import homework8.participants.*;

import java.util.Random;

class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Participant[] participants = {
                new Cat("Муся", 21, 3, Sex.FEMALE),
                new Person("Леви", 10, 15, Sex.MALE),
                new Robot("Терминатор", 100, 3, Sex.MALE)
        };

        Obstacle[] obstacles = {
                new Track(getRandomNumber(10)),
                new Wall(getRandomNumber(5)),
                new Track(getRandomNumber(10)),
                new Wall(getRandomNumber(5))
        };

        printInfo(participants, obstacles);

        for (Participant participant : participants) {
            if (passAllObstacles(obstacles, participant)) {
                System.out.printf("%s - в числе финалистов!", participant.getName());
            }
            System.out.println("\n");
        }
    }

    private static int getRandomNumber(int max) {
        return random.nextInt(Math.abs(max)) + 1;
    }

    private static void printInfo(Participant[] participants, Obstacle[] obstacles) {
        System.out.println("Всего препятствий: " + obstacles.length);
        System.out.println("Участники: ");
        for (Participant participant : participants) {
            System.out.println(participant.getName());
        }
        System.out.println("\n");
    }

    private static boolean passAllObstacles(Obstacle[] obstacles, Participant participant) {
        for (Obstacle obstacle : obstacles) {
            if (!obstacle.passObstacle(participant)) {
                System.out.println(participant.getName() + " выбывает из соревнований");
                return false;
            }
        }
        return true;
    }
}
