package Patterns.Decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Worker {
    private String name;
    private String organization;
    private int age;
    private String position;

    public Worker(String name, String organization, int age, String position) {
        this.name = name;
        this.organization = organization;
        this.age = age;
        this.position = position;
    }

    public String getOrganization() {
        return organization;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", organization='" + organization + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}

abstract class WorkersFilter {
    public abstract List<Worker> getFilteredList(List<Worker> workers);
}

class NorbitWorkersFilter extends WorkersFilter {
    @Override
    public List<Worker> getFilteredList(List<Worker> workers) {
        return workers.stream()
                .filter(worker -> "Norbit".equals(worker.getOrganization()))
                .collect(Collectors.toList());
    }
}

abstract class AdditionalFilter extends WorkersFilter {
    protected WorkersFilter baseFilter;

    public AdditionalFilter(WorkersFilter baseFilter) {
        this.baseFilter = baseFilter;
    }
}

class AgeWorkersFilter extends AdditionalFilter {
    private int minAge;
    private int maxAge;

    public AgeWorkersFilter(WorkersFilter baseFilter, int minAge, int maxAge) {
        super(baseFilter);
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public List<Worker> getFilteredList(List<Worker> workers) {
        List<Worker> baseFiltered = baseFilter.getFilteredList(workers);
        return baseFiltered.stream()
                .filter(worker -> worker.getAge() >= minAge && worker.getAge() <= maxAge)
                .collect(Collectors.toList());
    }
}

class PostWorkersFilter extends AdditionalFilter {
    private String position;

    public PostWorkersFilter(WorkersFilter baseFilter, String position) {
        super(baseFilter);
        this.position = position;
    }

    @Override
    public List<Worker> getFilteredList(List<Worker> workers) {
        List<Worker> baseFiltered = baseFilter.getFilteredList(workers);
        return baseFiltered.stream()
                .filter(worker -> position.equals(worker.getPosition()))
                .collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Alice", "Norbit", 25, "Developer"));
        workers.add(new Worker("Bob", "Norbit", 35, "Manager"));
        workers.add(new Worker("Charlie", "TechCorp", 30, "Developer"));
        workers.add(new Worker("Diana", "Norbit", 40, "Developer"));

        WorkersFilter filter = new NorbitWorkersFilter();

        filter = new AgeWorkersFilter(filter, 30, 40);
        filter = new PostWorkersFilter(filter, "Developer");

        List<Worker> filteredWorkers = filter.getFilteredList(workers);

        System.out.println("Отфильтрованные сотрудники:");
        filteredWorkers.forEach(System.out::println);
    }
}
