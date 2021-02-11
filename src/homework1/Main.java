package homework1;

public class Main {

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

        // 2. Создать переменные всех пройденных типов данных
        byte byteVariable = 21;
        short shortVariable = 2021;
        int integerVariable = 2000021;
        long longVariable = 12_345_678_910L;
        float floatVariable = 2.1F;
        double doubleVariable = 20.21;
        boolean booleanVariable = false;
        String stringVariable = "Hello, World!";

        // 3. Метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат
        doubleVariable = calculate(1, 2, 3, 4);

        // 4. Метод, принимающий на вход два числа, и проверяющий что их сумма
        // лежит в пределах от 10 до 20(включительно),
        // если да – вернуть true, в противном случае – false;
        booleanVariable = isRange(7, 5);

        // 5. Метод, которому передается целое число.
        // Должен напечатать в консоль положительное ли число передали, или отрицательное;
        isPositiveOrNegative(755);

        // 6. Метод, которому передается целое число,
        // метод должен вернуть true, если число отрицательное;
        booleanVariable = isNegative(-16);

        // 7. Метод, которому передается строка, обозначающая имя,
        // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        sayHello("Тимофей");

        // 8. * Написать метод, который определяет является ли год високосным,
        // и выводит сообщение в консоль.
        isLeapYear(2021);
    }

    public static double calculate(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    private static boolean isRange(int x, int y) {
        return (x + y) >= 10 && (x + y) <= 20;
    }

    private static void isPositiveOrNegative(int number) {
        if (number >= 0)
            System.out.println("This is a positive number");
        else
            System.out.println("This is a negative number");
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }

    private static void sayHello(String name) {
        System.out.println("Привет, " + name);
    }

    private static void isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.println("This is a leap year");
        else
            System.out.println("This is not a leap year");
    }
}