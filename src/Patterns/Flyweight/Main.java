package Patterns.Flyweight;

import java.util.HashMap;
import java.util.Map;

abstract class House {
    protected int stages;

    public abstract void build(double latitude, double longitude);
}

class PanelHouse extends House {
    public PanelHouse() {
        this.stages = 16;
    }

    @Override
    public void build(double latitude, double longitude) {
        System.out.println("Построен панельный дом с " + stages +
                " этажами на широте " + latitude +
                " и долготе " + longitude);
    }
}

class BrickHouse extends House {
    public BrickHouse() {
        this.stages = 5;
    }

    @Override
    public void build(double latitude, double longitude) {
        System.out.println("Построен кирпичный дом с " + stages +
                " этажами на широте " + latitude +
                " и долготе " + longitude);
    }
}

class HouseFactory {
    private static final Map<String, House> houseMap = new HashMap<>();

    public static House getHouse(String type) {
        House house = houseMap.get(type);

        if (house == null) {
            switch (type) {
                case "Panel":
                    house = new PanelHouse();
                    break;
                case "Brick":
                    house = new BrickHouse();
                    break;
                default:
                    System.out.println("Неизвестный тип дома: " + type);
                    return null;
            }
            houseMap.put(type, house);
        }

        return house;
    }
}

public class Main {
    public static void main(String[] args) {
        House panelHouse = HouseFactory.getHouse("Panel");
        House brickHouse = HouseFactory.getHouse("Brick");

        if (panelHouse != null) {
            panelHouse.build(55.7522, 37.6156);
        }
        if (brickHouse != null) {
            brickHouse.build(59.9343, 30.3351);
        }

        if (panelHouse != null) {
            panelHouse.build(56.8389, 60.6057);
        }
        if (brickHouse != null) {
            brickHouse.build(48.7071, 44.5169);
        }
    }
}
