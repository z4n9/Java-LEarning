package LessonOOP.polymorfizm_nasledovanie;

import java.util.Arrays;

public class User
{

    protected int ID;
    protected String login;
    protected String password;
    protected String name;
    protected String surname;

    public User()
    {
    }

    public User(int ID, String login, String password, String name, String surname)
    {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getData() {
        return "User{" +
                "ID=" + ID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}



class Staff extends User{
    private double salary;
    private String subjects[];

    public Staff(double salary, String[] subjects) {
        this.salary = salary;
        this.subjects = subjects;
    }

    public Staff(int ID, String login, String password, String name, String surname, double salary, String[] subjects) {
        super(ID, login, password, name, surname);
        this.salary = salary;
        this.subjects = subjects;
    }

    @Override
    public String getData() {
        return super.getData() + " " + salary + " " + Arrays.toString(subjects);
    }
}



class Student extends User{
    private double GPA;
    private String courses[];

    public Student(double GPA, String[] courses) {
        this.GPA = GPA;
        this.courses = courses;
    }

    public Student(int ID, String login, String password, String name, String surname, double GPA, String[] courses) {
        super(ID, login, password, name, surname);
        this.GPA = GPA;
        this.courses = courses;
    }

    @Override
    public String getData() {
        return super.getData() + " " + GPA + " " + Arrays.toString(courses);
    }
}
