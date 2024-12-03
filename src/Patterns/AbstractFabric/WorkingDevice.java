package Patterns.AbstractFabric;

public abstract class WorkingDevice {
    private String device;
    private String CPU;
    private String GPU;
    private int RAM;

    public abstract int getAccessoryCost();

    public WorkingDevice(String device, String CPU, String GPU, int RAM) {
        this.device = device;
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
    }
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    @Override
    public String toString() {
        return "WorkingDevice{" +
                "device='" + device + '\'' +
                ", CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", RAM=" + RAM +
                '}';
    }
}


class Laptop extends WorkingDevice{
    public Laptop(String device, String CPU, String GPU, int RAM){
        super(device, CPU, GPU, RAM);
    }

    @Override
    public int getAccessoryCost() {
        return 50;
    }
}


class Computer extends WorkingDevice {
    public Computer(String model, String CPU, String GPU, int RAM) {
        super(model, CPU, GPU, RAM);
    }

    @Override
    public int getAccessoryCost() {
        return 100;
    }
}