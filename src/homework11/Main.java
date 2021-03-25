package homework11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        testTask1();
        testTask2();
        testTask3();
    }

    private static void testTask1() {
        System.out.println("Task_1");
        System.out.println("=============");

        String[] strArray = {"hello", "world"};
        Integer[] intArray = {1, 2};
        System.out.println(Arrays.toString(strArray));
        System.out.println(Arrays.toString(intArray));

        System.out.println("=== swap ===");

        swap(strArray, 0, 1);
        swap(intArray, 0, 1);
        System.out.println(Arrays.toString(strArray));
        System.out.println(Arrays.toString(intArray));

        System.out.println("==============");
        System.out.println();
    }

    public static <T> void swap(T[] a, int firstIndex, int secondIndex) {
        T temp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = temp;
    }

    private static void testTask2() {
        System.out.println("Task_2");
        System.out.println("=======================");

        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(intArray));

        System.out.println("=== convert to list ===");

        List<Integer> integerList = convertArrayToArrayList(intArray);
        System.out.println(integerList);

        System.out.println("=======================");
        System.out.println();
    }

    public static <T> ArrayList<T> convertArrayToArrayList(T[] array) {
        return new ArrayList<T>(Arrays.asList(array));
    }

    private static void testTask3() {
        System.out.println("Task_3");
        System.out.println("===========================================");

        Apple[] apples = {new Apple(), new Apple(), new Apple()};
        Orange[] oranges = {new Orange(), new Orange(), new Orange()};

        System.out.println("apples  - " + Arrays.toString(apples));
        System.out.println("oranges - " + Arrays.toString(oranges));
        System.out.println();

        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);

        System.out.println("appleBox  - " + appleBox.getFruits());
        System.out.println("orangeBox - " + orangeBox.getFruits());
        System.out.println();

        System.out.println("appleBox  weight - " + appleBox.getWeight());
        System.out.println("orangeBox weight - " + orangeBox.getWeight());

        System.out.println("(appleBox weight == orangeBox weight) == " + appleBox.compare(orangeBox));
        System.out.println();

        // won't compile
        // appleBox.pourFruitInto(orangeBox);

        Apple[] apples2 = {new Apple()};
        System.out.println("apples2   - " + Arrays.toString(apples2));

        Box<Apple> appleBox2 = new Box<>(apples2);
        System.out.println("appleBox2 - " + appleBox2.getFruits());
        System.out.println();

        System.out.println("Pour fruit from appleBox into appleBox2");
        appleBox.pourFruitInto(appleBox2);

        System.out.println("appleBox  - " + appleBox.getFruits());
        System.out.println("appleBox2 - " + appleBox2.getFruits());

        System.out.println("===========================================");
    }
}
