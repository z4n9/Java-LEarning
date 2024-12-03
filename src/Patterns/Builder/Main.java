package Patterns.Builder;

public class Main {
    public static void main(String[] args) {
        IComputerDeveloper hpDeveloper = new HPComputerDeveloper();
        Director director = new Director(hpDeveloper);

        Computer hpComputer = director.buildCompleteComputer();
        System.out.println("HP Computer: " + hpComputer);

        Computer hpComputerWithoutOS = director.buildComputerWithoutOS();
        System.out.println("HP Computer (без ОС): " + hpComputerWithoutOS);

        IComputerDeveloper dellDeveloper = new DELLComputerDeveloper();
        director = new Director(dellDeveloper);

        Computer dellComputer = director.buildCompleteComputer();
        System.out.println("DELL Computer: " + dellComputer);

        Computer dellComputerWithoutOS = director.buildComputerWithoutOS();
        System.out.println("DELL Computer (без ОС): " + dellComputerWithoutOS);
    }
}




class Computer {
    private String processor;
    private String ram;
    private String os;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computer [Processor: " + processor + ", RAM: " + ram + ", OS: " + os + "]";
    }
}

interface IComputerDeveloper {
    void setProcessor();
    void setRam();
    void setOs();
    Computer getComputer();
}


class HPComputerDeveloper implements IComputerDeveloper {
    private Computer computer;

    public HPComputerDeveloper() {
        this.computer = new Computer();
    }

    @Override
    public void setProcessor() {
        computer.setProcessor("Intel i5");
    }

    @Override
    public void setRam() {
        computer.setRam("16GB");
    }

    @Override
    public void setOs() {
        computer.setOs("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}

class DELLComputerDeveloper implements IComputerDeveloper {
    private Computer computer;

    public DELLComputerDeveloper() {
        this.computer = new Computer();
    }

    @Override
    public void setProcessor() {
        computer.setProcessor("Intel i7");
    }

    @Override
    public void setRam() {
        computer.setRam("32GB");
    }

    @Override
    public void setOs() {
        computer.setOs("Ubuntu 20.04");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}

class Director {
    private IComputerDeveloper developer;

    public Director(IComputerDeveloper developer) {
        this.developer = developer;
    }

    public Computer buildCompleteComputer() {
        developer.setProcessor();
        developer.setRam();
        developer.setOs();
        return developer.getComputer();
    }

    public Computer buildComputerWithoutOS() {
        developer.setProcessor();
        developer.setRam();
        return developer.getComputer();
    }
}

