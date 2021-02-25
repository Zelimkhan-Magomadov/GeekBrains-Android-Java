package homework5;

public class Employee {
    private String lastName;
    private String firstName;
    private String patronymic;
    private String post;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String lastName, String firstName, String patronymic,
                    String post, String email, String phoneNumber,
                    int salary, int age) {

        setLastName(lastName);
        setFirstName(firstName);
        setPatronymic(patronymic);
        setPost(post);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setSalary(salary);
        setAge(age);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getInfo() {
        System.out.println("Last name: " + this.lastName);
        System.out.println("First name: " + this.firstName);
        System.out.println("Patronymic: " + this.patronymic);
        System.out.println("Post: " + this.post);
        System.out.println("Email: " + this.email);
        System.out.println("Phone number: " + this.phoneNumber);
        System.out.println("Salary: " + this.salary);
        System.out.println("Age: " + this.age);
        System.out.println();
    }
}
