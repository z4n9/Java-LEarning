package Patterns.AbstractFabric;

public class Main {
    public static void main(String[] args) {

        WorkerFactory programmerFactory = new ProgrammerFactory();
        Employee programmer = new Employee(programmerFactory);
        programmer.showDetails();

        System.out.println();


        WorkerFactory directorFactory = new DirectorFactory();
        Employee director = new Employee(directorFactory);
        director.showDetails();
    }
}
