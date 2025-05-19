package SOLID;

public class TaskSOLIDMyVer {
    public static void main(String[] args) {

        Barrier barrier = new Barrier(2);
        Treadmill treadmill = new Treadmill(15);

        Human human = new Human();
        human.setRunDistance(16);
        human.setJumpHeight(3);

        human.run(treadmill);
        human.jump(barrier);

        Cat cat = new Cat();
        cat.setRunDistance(12);
        cat.setJumpHeight(4);

        cat.run(treadmill);
        cat.jump(barrier);

        Robot robot = new Robot();
        robot.setRunDistance(100);
        robot.setJumpHeight(1);

        robot.run(treadmill);
        robot.jump(barrier);
    }
}

//✅ S — Single Responsibility Principle (Принцип единственной ответственности)
//Нарушается частично.
//У тебя классы Human, Cat, Robot отвечают и за данные участника, и за логику прохождения препятствий.
// Лучше было бы вынести выполнение действий в отдельный обработчик или через интерфейсы препятствий,
// чтобы участник просто "умел" бегать и прыгать, а не решал сам, прошёл он или нет.

// ⚠O — Open/Closed Principle (Принцип открытости/закрытости)
//Нарушается.
//Если ты захочешь добавить новый тип препятствия (например, бассейн),
// тебе придётся менять логику в каждом run()/jump().
// Это говорит о жёсткой связности между участником и типом препятствия.

// ✅ L — Liskov Substitution Principle (Принцип подстановки Барбары Лисков)
//Соблюдается.
//Ты используешь интерфейсы Runnable и Jumpable. Любой класс, реализующий их, может быть участником. Отлично.

//❌ I — Interface Segregation Principle (Принцип разделения интерфейсов)
//Не соблюдается.
//Участники, которые не умеют прыгать или бегать (например, теоретически может появиться такой),
// вынуждены реализовывать оба интерфейса Runnable и Jumpable.
// Лучше объединить всё в один интерфейс Competitor, где реализуются необходимые методы.
//
//⚠D — Dependency Inversion Principle (Принцип инверсии зависимостей)
//Нарушается.
//Сейчас run() и jump() привязаны конкретно к Treadmill и Barrier.
// Это мешает расширению (например, при добавлении новых препятствий).


interface Runnable{
    boolean run(Treadmill treadmill);
}

interface Jumpable{
    boolean jump(Barrier barrier);
}

//Human
class Human implements Runnable, Jumpable{
    private int runDistance;
    private int jumpHeight;

    public Human(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Human() {}

    public int getRunDistance(){return runDistance;}

    public void setRunDistance(int runDistance){this.runDistance = runDistance;}

    public int getJumpHeight(){return jumpHeight;}

    public void setJumpHeight(int jumpHeight){this.jumpHeight = jumpHeight;}

    String getName(){return "Human";}

    @Override
    public boolean jump(Barrier barrier) {
        if(jumpHeight < 0) {
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (jumpHeight <= barrier.getHeight()) {
            System.out.println(getName() + " не справился");
            return false;
        }else {
            System.out.println(getName() + " справился");
            return true;
        }
    }

    @Override
    public boolean run(Treadmill treadmill) {
        if(runDistance < 0) {
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (runDistance <= treadmill.getDistance()) {
            System.out.println(getName() + " не справился");
            return false;
        }else {
            System.out.println(getName() + " справился");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "runDistance=" + runDistance +
                ", jumpHeight=" + jumpHeight +
                '}';
    }
}
//Cat
class Cat implements Runnable, Jumpable{
    private int runDistance;
    private int jumpHeight;

    public Cat(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Cat(){}

    public int getRunDistance() {return runDistance;}

    public void setRunDistance(int runDistance) {this.runDistance = runDistance;}

    public int getJumpHeight() {return jumpHeight;}

    public void setJumpHeight(int jumpHeight) {this.jumpHeight = jumpHeight;}

    String getName(){return "Cat";}

    @Override
    public boolean jump(Barrier barrier) {
        if(jumpHeight < 0) {
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (jumpHeight <= barrier.getHeight()) {
            System.out.println(getName() + " не справился");
            return false;
        }else {
            System.out.println(getName() + " справился");
            return true;
        }
    }

    @Override
    public boolean run(Treadmill treadmill) {
        if(runDistance < 0) {
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (runDistance <= treadmill.getDistance()) {
            System.out.println(getName() + " не справился");
            return false;
        }else {
            System.out.println(getName() + " справился");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "runDistance=" + runDistance +
                ", jumpHeight=" + jumpHeight +
                '}';
    }
}
//Robot
class Robot implements Runnable, Jumpable{
    private int runDistance;
    private int jumpHeight;

    public Robot(int runDistance, int jumpHeight) {
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public Robot() {}

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    String getName(){return "Robot";}

    @Override
    public boolean jump(Barrier barrier) {
        if(jumpHeight < 0) {
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (jumpHeight <= barrier.getHeight()) {
            System.out.println(getName() + " не справился");
            return false;
        }else {
            System.out.println(getName() + " справился");
            return true;
        }
    }

    @Override
    public boolean run(Treadmill treadmill) {
        if(runDistance < 0) {
            System.out.println(getName() + " стоит на месте");
            return false;
        } else if (runDistance <= treadmill.getDistance()) {
            System.out.println(getName() + " не справился");
            return false;
        }else {
            System.out.println(getName() + " справился");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "runDistance=" + runDistance +
                ", jumpHeight=" + jumpHeight +
                '}';
    }
}

class Treadmill{
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

class Barrier{
    private int height;

    public Barrier(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}