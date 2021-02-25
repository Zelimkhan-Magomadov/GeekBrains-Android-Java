package homework5;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Мамонтов", "Богдан", "Наумович",
                "Актер", "russotto@icloud.com", "+7(619)354-68-56",
                141494, 25);

        employees[1] = new Employee("Цицианов", "Моисей", "Назарович",
                "Кассир", "phyruxus@verizon.net", "+7(881)014-20-51", 34161, 33);

        employees[2] = new Employee("Дятлов", "Авдей", "Никифорович",
                "Мастер", "sartak@sbcglobal.net", "+7(955)430-81-91", 190930, 49);

        employees[3] = new Employee("Шостенко", "Кирилл", "Маркович",
                "Переплетчик", "wayward@icloud.com", "+7(461)916-89-74", 86559, 27);

        employees[4] = new Employee("Чечёткин", "Павел", "Никифорович",
                "Диетолог", "yenya@live.com", "+7(999)224-73-49", 178313, 43);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.println("\nСотрудник №" + i);
                employees[i].getInfo();
            }
        }
    }
}