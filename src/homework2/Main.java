package homework2;

public class Main {

    public static void main(String[] args) {

        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < binaryArray.length; i++) {
            binaryArray[i] = binaryArray[i] == 1 ? 0 : 1;
        }

        // 2. Задать пустой целочисленный массив размером 8.
        // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        final int INTEGER_ARRAY_SIZE = 8;
        int[] integerArray = new int[INTEGER_ARRAY_SIZE];

        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = i * 3;
        }

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] integerArray2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < integerArray2.length; i++) {
            if (integerArray2[i] < 6)
                integerArray2[i] *= 2;
        }

        // 4. Создать квадратный двумерный целочисленный массив
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        final int DEEP_ARRAY_SIZE = 5;
        int[][] deepArray = new int[DEEP_ARRAY_SIZE][DEEP_ARRAY_SIZE];
        int lastIndex = deepArray.length - 1;

        for (int i = 0; i < deepArray.length; i++) {
            deepArray[i][i] = deepArray[i][lastIndex - i] = 1;
        }

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы
        int[] integerArray3 = {1, 4, 65, 12, 78, 21, 36, 87, 10, 45};
        int min = getMinimumElement(integerArray3);
        int max = getMaximumElement(integerArray3);

        // 6. ** Метод, в который передается не пустой одномерный целочисленный массив.
        // Вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        int[] integerArray4 = {1, 2, 2, 5};
        boolean balance = checkBalance(integerArray4);

        // 7. **** Написать метод, которому на вход подается одномерный массив и число n
        // при этом метод должен сместить все элементымассива на n позиций.
        int[] integerArray5 = {1, 2, 3};
        shiftElements(integerArray5, 3);
    }

    private static int getMinimumElement(int[] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    private static int getMaximumElement(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    private static boolean checkBalance(int[] array) {
        boolean balance = false;

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int leftElementsSum = 0;
        for (int i = 0; i < array.length; i++) {
            leftElementsSum += array[i];
            sum -= array[i];

            if (leftElementsSum > sum) {
                break;
            }
            if (sum == leftElementsSum) {
                balance = true;
                break;
            }
        }

        return balance;
    }

    private static void shiftElements(int[] array, int number) {
        final int shiftNumber = Math.abs(number) % array.length;

        if (shiftNumber == 0)
            return;

        if (number > 0)
            rightShift(array, shiftNumber);
        else if (number < 0)
            leftShift(array, shiftNumber);
    }

    private static void rightShift(int[] array, int shiftNumber) {
        for (int i = 0; i < shiftNumber; i++) {
            int element = array[array.length - 1];

            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = element;
        }
    }

    private static void leftShift(int[] array, int shiftNumber) {
        for (int i = 0; i < shiftNumber; i++) {
            int element = array[0];

            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = element;
        }
    }
}