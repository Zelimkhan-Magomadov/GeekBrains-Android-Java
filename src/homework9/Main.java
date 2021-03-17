package homework9;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[4][4];
        // Throws an exception
        // String[][] array = new String[4][5];

        fillArray(array);

        // Throws an exception
        array[0][0] = "a";
        try {
            long sum = testMethod(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        // Doesn't throw an exception
        array[0][0] = "21";
        try {
            long sum = testMethod(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    private static void fillArray(String[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.toString(random.nextInt(100));
            }
        }
    }

    private static long testMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
        return getSum(array);
    }

    private static long getSum(String[][] array) throws MyArrayDataException {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}