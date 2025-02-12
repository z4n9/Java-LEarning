package AdditionalTopics.Compor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorLearn {
    public static void main(String[] args) {

        ArrayList<Person2> person2ArrayList = new ArrayList<>();
        person2ArrayList.add(new Person2("Bob", 21, 150000));
        person2ArrayList.add(new Person2("Bill", 30, 720000));
        person2ArrayList.add(new Person2("Johny", 18, 350000));

        Collections.sort(person2ArrayList, new SortByAge());

        for (Person2 person2 : person2ArrayList) {
            System.out.println(person2);
        }
    }
}

class Person2{
    private String name;
    private int age;
    private int salary;

    public Person2(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
class SortByAge implements Comparator<Person2>{
    @Override
    public int compare(Person2 o1, Person2 o2) {
        if (o1.getAge() == o2.getAge()){
            return 0;
        } else if (o1.getAge() > o2.getAge()) {
            return 1;
        }
        return -1;
    }
}