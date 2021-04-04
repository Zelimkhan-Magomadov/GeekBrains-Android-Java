package homework12;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        method_1();
        method_2();
    }

    private static void method_1() {
        System.out.println("Метод_1");

        final int SIZE = 10_000_000;
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f);
        Instant start = Instant.now();

        computation(arr, 0);

        Instant finish = Instant.now();
        long ms = Duration.between(start, finish).toMillis();
        System.out.println("Время выполнения: " + ms);
    }

    private static void method_2() {
        System.out.println("Метод_2");

        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];

        float[] tempArray1 = new float[HALF];
        float[] tempArray2 = new float[HALF];

        Arrays.fill(arr, 1.0f);
        Instant start = Instant.now();

        System.arraycopy(arr, 0, tempArray1, 0, HALF);
        System.arraycopy(arr, HALF, tempArray2, 0, HALF);

        Thread t1 = new Thread(() -> computation(tempArray1, 0));
        Thread t2 = new Thread(() -> computation(tempArray2, HALF));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            System.arraycopy(tempArray1, 0, arr, 0, HALF);
            System.arraycopy(tempArray2, 0, arr, HALF, HALF);

            Instant finish = Instant.now();
            long ms = Duration.between(start, finish).toMillis();
            System.out.println("Время выполнения: " + ms);

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void computation(float[] arr, int coefficient) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= Math.sin(0.2f + (float) coefficient / 5) *
                    Math.cos(0.2f + (float) coefficient / 5) *
                    Math.cos(0.4f + (float) coefficient / 2);

            coefficient++;
        }
    }
}