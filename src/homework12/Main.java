package homework12;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();

       /* Thread t1 = new Thread(m::method_1);
        t1.start();
        t1.join();*/

        Thread t2 = new Thread(() -> {
            try {
                m.method_2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
    }

    private void method_1() {
        System.out.println("Метод 1");

        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f);
        Instant start = Instant.now();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        Instant finish = Instant.now();
        long ms = Duration.between(start, finish).toMillis();
        System.out.println("arr[0] + " + arr[0]);
        System.out.println("arr[21] + " + arr[21]);
        System.out.println("arr[arr.length-1] + " + arr[arr.length-1]);
        System.out.println("Время выполнения - " + ms + "мс");
    }

    private void method_2() throws InterruptedException {
        System.out.println("Метод 2");

        final int SIZE = 100;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f);
        Instant start = Instant.now();

        float[] tempArray1 = new float[HALF / 2];
        float[] tempArray2 = new float[HALF / 2];

        System.arraycopy(arr, 0, tempArray1, 0, HALF / 2);
        System.arraycopy(arr, HALF / 2, tempArray2, 0, HALF / 2);

        System.out.println("tempArray1 - " + Arrays.toString(tempArray1));
        System.out.println("tempArray2 - " + Arrays.toString(tempArray2));

        Thread t1 = new Thread(() -> calculate(tempArray1));
        Thread t2 = new Thread(() -> calculate(tempArray2));

        t1.join();
        t2.join();
        System.out.println();
        System.out.println("tempArray1 - " + Arrays.toString(tempArray1));
        System.out.println("tempArray2 - " + Arrays.toString(tempArray2));

        System.arraycopy(tempArray1, 0, arr, 0, HALF / 2);
        System.arraycopy(tempArray2, 0, arr, HALF / 2, HALF / 2);

        Instant finish = Instant.now();
        long ms = Duration.between(start, finish).toMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println("Время выполнения - " + ms + "мс");
    }

    private void calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
