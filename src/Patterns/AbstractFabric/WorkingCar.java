package Patterns.AbstractFabric;

public abstract class WorkingCar {
    private String model;
    private int price;
    private int year;

    public abstract double getTax();

    public WorkingCar(String model, int price, int year) {
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "WorkingDevice{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", year='" + year + '\'' +
                '}';
    }
}


class Lada extends WorkingCar {
    public Lada(String model, int price, int year) {
        super(model, price, year);
    }

    @Override
    public double getTax() {
        return getPrice() * 0.05;
    }
}

class BMW extends WorkingCar {
    public BMW(String model, int price, int year) {
        super(model, price, year);
    }

    @Override
    public double getTax() {
        return getPrice() * 0.1;
    }
}


