package Patterns.AbstractFabric;

public class Employee {
    private WorkingCar car;
    private WorkingDevice device;

    public Employee(WorkerFactory factory) {
        this.car = factory.createWorkingCar();
        this.device = factory.createWorkingDevice();
    }

    public void showDetails() {
        System.out.println("Employee Details:");
        System.out.println("Car: " + car + ", Tax: " + car.getTax());
        System.out.println("Device: " + device + ", Accessory Cost: " + device.getAccessoryCost());
    }
}
