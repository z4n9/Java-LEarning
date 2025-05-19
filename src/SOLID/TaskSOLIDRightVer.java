package SOLID;

import java.util.ArrayList;

public class TaskSOLIDRightVer {
    public static void main(String[] args) {

        ArrayList<Contestants1> contestants1s = new ArrayList<>();

        contestants1s.add(new Human1(16, 3));
        contestants1s.add(new Cat1(2, 4));
        contestants1s.add(new Robot1(100, 1));

        ArrayList<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Treadmill1(15));
        obstacles.add(new Wall(2));

        for (Obstacle obstacle : obstacles) {
            for (Contestants1 c : contestants1s) {
                if(!obstacle.consist(c)) break;
            }
        }
    }
}

//1. Single Responsibility Principle (SRP)
//Каждый класс выполняет строго свою функцию:
//Human1, Cat1, Robot1 реализуют поведение участника.
//Treadmill1, Wall представляют препятствия.
//TaskSOLIDRightVer.main управляет логикой соревнования.
//        ✅ Соблюдено.

//2. Open/Closed Principle (OCP)
//Добавление нового участника или
// нового препятствия не требует изменения существующего кода —
// только добавления новых классов, реализующих нужный интерфейс.
//        ✅ Соблюдено.

//3. Liskov Substitution Principle (LSP)
//Объекты Human1, Cat1, Robot1 можно использовать там,
//где требуется Contestants1, без изменения логики программы.
//        ✅ Соблюдено.

//4. Interface Segregation Principle (ISP)
//Интерфейс Contestants1 содержит только необходимые методы —
// run() и jump(). Но можно еще сильнее его улучшить, об этом ниже.
//        ⚠️ Частично соблюден — можно разделить Contestants1 на RunnableEntity и JumpableEntity
//        (если когда-нибудь появится, например, существо, которое только бегает).

//5. Dependency Inversion Principle (DIP)
//Obstacle зависит от абстракции Contestants1,
// а не от конкретной реализации участника. Всё корректно.
//        ✅ Соблюдено.

interface Contestants1{
    boolean run(int distance);
    boolean jump(int height);
}

class Human1 implements Contestants1{
    private int runDistance;
    private int jumpHeight;

    public Human1(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean run(int distance) {
        if(distance <= 0){
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (distance >= runDistance){
            System.out.println(getName() + " не справился с дистанцией");
            return false;
        }else {
            System.out.println(getName() + " справился с дистанцией");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if(height <= 0){
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (height >= jumpHeight){
            System.out.println(getName() + " не справился с препядствием");
            return false;
        }else {
            System.out.println(getName() + " справился с препядствием");
            return true;
        }
    }

    String getName(){
        return "Human1";
    }

    @Override
    public String toString() {
        return "Human1{" +
                "runDistance=" + runDistance +
                ", jumpHeight=" + jumpHeight +
                '}';
    }
}


//robot
class Robot1 implements Contestants1{
    private int runDistance;
    private int jumpHeight;

    public Robot1(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean run(int distance) {
        if(distance <= 0){
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (distance >= runDistance){
            System.out.println(getName() + " не справился с дистанцией");
            return false;
        }else {
            System.out.println(getName() + " справился с дистанцией");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if(height <= 0){
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (height >= jumpHeight){
            System.out.println(getName() + " не справился с препядствием");
            return false;
        }else {
            System.out.println(getName() + " справился с препядствием");
            return true;
        }
    }

    String getName(){
        return "Robot1";
    }

    @Override
    public String toString() {
        return "Robot1{" +
                "runDistance=" + runDistance +
                ", jumpHeight=" + jumpHeight +
                '}';
    }
}

class Cat1 implements Contestants1{
    private int runDistance;
    private int jumpHeight;

    public Cat1(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean run(int distance) {
        if(distance <= 0){
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (distance >= runDistance){
            System.out.println(getName() + " не справился с дистанцией");
            return false;
        }else {
            System.out.println(getName() + " справился с дистанцией");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if(height <= 0){
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (height >= jumpHeight){
            System.out.println(getName() + " не справился с препядствием");
            return false;
        }else {
            System.out.println(getName() + " справился с препядствием");
            return true;
        }
    }

    String getName(){
        return "Cat1";
    }

    @Override
    public String toString() {
        return "Cat1{" +
                "runDistance=" + runDistance +
                ", jumpHeight=" + jumpHeight +
                '}';
    }
}

interface Obstacle{
    boolean consist(Contestants1 contestants1);
}

class Treadmill1 implements Obstacle{
    private int distance;

    public Treadmill1(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean consist(Contestants1 contestants1) {
        if(contestants1.run(distance)){
            return true;
        }else
            return false;
    }
}

class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean consist(Contestants1 contestants1) {
        if(contestants1.jump(height)){
            return true;
        }else
            return false;
    }
}