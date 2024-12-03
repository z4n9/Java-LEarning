package Patterns.Adapter;

public class Main {
    public static class Office {
        private String name;
        private String address;

        public Office(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }

    public interface IMovable {
        void move(String newAddress);
    }

    public static class MovableOffice extends Office implements IMovable {

        public MovableOffice(String name, String address) {
            super(name, address);
        }

        @Override
        public void move(String newAddress) {
            try {
                java.lang.reflect.Field addressField = Office.class.getDeclaredField("address");
                addressField.setAccessible(true);
                addressField.set(this, newAddress);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MovableOffice norbitOffice = new MovableOffice("Norbit", "Old Address, City");

        System.out.println("Before move:");
        System.out.println("Office name: " + norbitOffice.getName());
        System.out.println("Office address: " + norbitOffice.getAddress());

        norbitOffice.move("New Address, City");

        System.out.println("\nAfter move:");
        System.out.println("Office name: " + norbitOffice.getName());
        System.out.println("Office address: " + norbitOffice.getAddress());
    }
}
