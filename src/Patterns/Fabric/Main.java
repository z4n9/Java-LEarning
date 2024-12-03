package Patterns.Fabric;

public class Main {
    public static void main(String[] args) {

        PhoneDev googlepixel = new GooglePixelDev();
        Phone googlePhone = googlepixel.createPhone();
        System.out.println(googlePhone);

        PhoneDev samsungDev = new SamsungDev();
        Phone samsungPhone = samsungDev.createPhone();
        System.out.println(samsungPhone);

    }
}
class Phone{
    protected int price;
    protected String model;
    protected String processor;
    protected int ram;

    public Phone(int price, String model, String processor, int ram) {
        this.price = price;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                '}';
    }
}
class GooglePixel extends Phone{

    private boolean cameraIsOn;

    public GooglePixel(int price, String model, String processor, int ram, boolean cameraIsOn) {
        super(price, model, processor, ram);
        this.cameraIsOn = cameraIsOn;
    }

    @Override
    public String toString() {
        return "GooglePixel{" +
                "cameraIsOn=" + cameraIsOn +
                '}';
    }
}
class Samsung extends Phone{

    private boolean batteryIsOn;

    public Samsung(int price, String model, String processor, int ram, boolean batteryIsOn) {
        super(price, model, processor, ram);
        this.batteryIsOn = batteryIsOn;
    }


    @Override
    public String toString() {
        return "Samsung{" +
                "batteryIsOn=" + batteryIsOn +
                '}';
    }
}

interface PhoneDev{
    Phone createPhone();
}

class GooglePixelDev implements PhoneDev {
    @Override
    public Phone createPhone() {
        return new GooglePixel(1000, "Google Pixel 9 Pro", "Tensor 3310", 16,  true);
    }
}

// Разработчик телефонов Samsung
class SamsungDev implements PhoneDev {
    @Override
    public Phone createPhone() {
        return new Samsung(1100, "Samsung Galaxy S24","Exynos 2200", 16,  false);
    }
}


