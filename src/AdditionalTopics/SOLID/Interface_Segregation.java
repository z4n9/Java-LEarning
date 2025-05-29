package AdditionalTopics.SOLID;

public class Interface_Segregation {
    public static void main(String[] args) {
        Duck duck = new Duck();
		duck.fly();
		duck.swim();

		Fish fish = new Fish();
		fish.swim();
    }
}

interface Flyable{
	void fly();
}

interface Swimable{
	void swim();
}

interface Animal extends Flyable, Swimable{

}

class Duck implements Animal{
	@Override 
	public void fly(){
		System.out.println(getClass() + " Flying");		
	}

	@Override 
	public void swim(){
		System.out.println(getClass() + " Swimming");
	}
}

class Fish implements Swimable{
	@Override
	public void swim(){
		System.out.println(getClass() + " Swimming");		
	}
}
