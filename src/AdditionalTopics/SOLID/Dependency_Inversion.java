package AdditionalTopics.SOLID;

public class Dependency_Inversion {
    public static void main(String[] args) {

        SportClub sportClub = new SportClub();
        sportClub.consist();

    }
}

interface Sportsmen{
    void run();
}

class Basketballer implements Sportsmen{
    @Override
    public void run() {
        System.out.println(getClass() + " is running");
    }
}

class Footballer implements Sportsmen{
    @Override
     public void run(){
        System.out.println(getClass() + " is running");
    }
}

class SportClub{
    Sportsmen sportsmen1;
    Sportsmen sportsmen2;

    void consist(){
        sportsmen1 = new Footballer();
        sportsmen1.run();

        sportsmen2 = new Basketballer();
        sportsmen2.run();
    }
}