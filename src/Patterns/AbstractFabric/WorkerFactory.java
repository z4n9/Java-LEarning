package Patterns.AbstractFabric;

interface WorkerFactory{
    WorkingCar createWorkingCar();
    WorkingDevice createWorkingDevice();
}

class ProgrammerFactory implements WorkerFactory {
    @Override
    public WorkingCar createWorkingCar() {
        return new Lada("LADA Granta", 10000, 2020);
    }

    @Override
    public WorkingDevice createWorkingDevice() {
        return new Laptop("Asus TUF", "Intel I12", "RTX 4090", 16);
    }
}

// Фабрика директоров
class DirectorFactory implements WorkerFactory {
    @Override
    public WorkingCar createWorkingCar() {
        return new BMW("BMW X5", 50000, 2021);
    }

    @Override
    public WorkingDevice createWorkingDevice() {
        return new Computer("iMac Pro", "A18", "Mac GP", 16);
    }
}
