package AdditionalTopics.SOLID;

public class Open_closed {
    public static void main(String[] args) {
        MercedesCoupe mercedes = new MercedesCoupe();
        drive(mercedes);
    }
    public static void drive(Car car){
        car.countPassengers();

//        if (mercedes instanceof MercedesCoupe){
//            ((MercedesCoupe) mercedes).getPassengers2Pass();
//        }
//        else{
//            mercedes.getPassengers();
//        }
    }
}

interface Car{
    void countPassengers();
}

class Mercedes implements Car{
    @Override
    public void countPassengers() {
        getPassengers();
    }

    //4 passengers
    void getPassengers(){
        System.out.println("i have 4 passengers");
    }
}

class MercedesCoupe extends Mercedes implements Car{
    @Override
    public void countPassengers(){
        getPassengers();
    }

    void getPassengers(){
        System.out.println("I have 2 passengers");
    }
}