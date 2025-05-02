package SOLID;

public class SingleRespons {
    public static void main(String[] args) {
        //Single responsibility - принцип единственной ответственности
        //Означает что у класса должна быть всего одна причина для изменения
        Developer employee = new Developer();
        employee.getSalary();
        employee.develop();

    }
}

interface Employee{
    int getSalary();

//    void drive(){}
//
//    void countingMoney(){}
//
//    void develop(){}
//
//    void clean(){}
}

class Developer implements Employee{
    @Override
    public int getSalary() {
        return 100;
    }
    void develop(){
        System.out.println("I develop things");
    }
}

class Cleaner implements Employee{
    @Override
    public int getSalary() {
        return 50;
    }

    void clean(){
        System.out.println("I clean");
    }
}

