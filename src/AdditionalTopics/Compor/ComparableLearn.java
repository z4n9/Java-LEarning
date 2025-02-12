package AdditionalTopics.Compor;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableLearn {
    public static void main(String[] args) {

        ArrayList<Person1> personArrayList = new ArrayList<>();
        personArrayList.add(new Person1("Bob", 23, 220000));
        personArrayList.add(new Person1("John", 30, 550000));
        personArrayList.add(new Person1("Bill", 35, 300000));

        Collections.sort(personArrayList);

        for (Person1 person : personArrayList) {
            System.out.println(person);
        }

    }
}


class Person1 implements Comparable<Person1>{
    private String name;
    private int age;
    private int salary;

    public Person1(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Person1 o) {
        if (this.age == o.age)
            return 0;

        else if (this.age > o.age)
            return 1;

        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}