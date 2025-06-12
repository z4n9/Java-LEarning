package AdditionalTopics.StreamAPI;

import java.util.List;

public class StreamApiLearn {
    public static void main(String[] args) {


        List<Person> personList = getPerson();
        //List<Person> juniors = new ArrayList<>();

        //Imperative approach - императивный подход
        //for (Person person : person3List) {
          //  if (person.getPosition().equals(Position.JUNIOR)){
            //    juniors.add(person);
            //}
        //}
        //for (Person junior : juniors) {
          //  System.out.println(junior);
        //}


        //Declarative approach - декларативный подход
        //filter
//        List<Person> juniors = personList.stream()
//                .filter(person -> person.getPosition().equals(Position.JUNIOR))
//                .collect(Collectors.toList());
//                .forEach(System.out::println);

        //sort
//        personList.stream()
//                .sorted(Comparator.comparing(Person::getPosition))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        //max min
//        Person person = personList.stream()
//                .max(Comparator.comparing(Person::getPosition))
//                .get();
//        System.out.println(person);
//
//        Person person1 = personList.stream()
//                .min(Comparator.comparing(Person::getPosition))
//                .get();
//        System.out.println(person1);

        //allmatch
//        boolean b = personList.stream()
//                .allMatch(person -> person.getAge() > 17);
//        System.out.println(b);

        //anymatch
//        boolean b = personList.stream()
//                .anyMatch(person -> person.getAge() > 17);
//        System.out.println(b);

        //group
//        Map<Position, List<Person>> collect = personList.stream()
//                .collect(Collectors.groupingBy(Person::getPosition));
//
//        collect.forEach((position, people) -> {
//            System.out.println(position);
//            people.forEach(System.out::println);
//            System.out.println();
//        });
    }



    private static List<Person> getPerson(){
        return List.of(new Person("Arthur", 18, Position.JUNIOR),
                new Person("Bob", 25, Position.SENIOR),
                new Person("Bill", 23, Position.MIDDLE));

    }
}

enum Position{
    JUNIOR, MIDDLE, SENIOR
}

class Person {
    private String name;
    private int age;
    private Position position;

    public Person(String name, int age, Position position) {
        this.name = name;
        this.age = age;
        this.position = position;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
}