package Patterns.Facade;

class Plane {
    private String model;
    private int capacity;

    public Plane(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }
}

interface Export {
    void exportToPdf();
    void exportToExcel();
}

interface GetPlane {
    void printPlaneInfo();
    void calculateRange();
}

class ExportImpl implements Export {
    @Override
    public void exportToPdf() {
        System.out.println("Exporting plane data to PDF...");
    }

    @Override
    public void exportToExcel() {
        System.out.println("Exporting plane data to Excel...");
    }
}

class GetPlaneImpl implements GetPlane {
    private Plane plane;

    public GetPlaneImpl(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void printPlaneInfo() {
        System.out.println("Plane Model: " + plane.getModel());
        System.out.println("Capacity: " + plane.getCapacity());
    }

    @Override
    public void calculateRange() {
        System.out.println("Calculating range for the plane...");
    }
}

class Facade {
    private Plane plane;
    private ExportImpl exportImpl;
    private GetPlaneImpl getPlaneImpl;

    public Facade(Plane plane) {
        this.plane = plane;
        this.exportImpl = new ExportImpl();
        this.getPlaneImpl = new GetPlaneImpl(plane);
    }

    public void run() {
        getPlaneImpl.printPlaneInfo();
        getPlaneImpl.calculateRange();
        exportImpl.exportToPdf();
        exportImpl.exportToExcel();
    }
}

public class Main {
    public static void main(String[] args) {
        Plane plane = new Plane("Boeing 747", 660);
        Facade facade = new Facade(plane);
        facade.run();
    }
}
