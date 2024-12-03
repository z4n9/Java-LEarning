package Patterns.Bridge;

class ItemInCart {
    private String id;
    private int quantity;
    private double price;

    public ItemInCart(String id, int quantity, double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

interface DeliveryCalculator {
    double calculateDeliveryCost();
}

class PickupDeliveryCalculator implements DeliveryCalculator {
    @Override
    public double calculateDeliveryCost() {
        return 0.0;
    }
}

class CompanyADeliveryCalculator implements DeliveryCalculator {
    @Override
    public double calculateDeliveryCost() {
        return 100.0;
    }
}

class DeliveryCalculatorFactory {
    public static final String PICKUP = "PICKUP";
    public static final String COMPANY_A = "COMPANY_A";

    public static DeliveryCalculator getCalculator(String method) {
        switch (method) {
            case COMPANY_A:
                return new CompanyADeliveryCalculator();
            case PICKUP:
            default:
                return new PickupDeliveryCalculator();
        }
    }
}

class PriceCalculator {
    protected DeliveryCalculator deliveryCalculator;

    public PriceCalculator(String deliveryMethod) {
        this.deliveryCalculator = DeliveryCalculatorFactory.getCalculator(deliveryMethod);
    }

    public double calculateTotalPrice(ItemInCart[] items) {
        double totalPrice = 0;
        for (ItemInCart item : items) {
            totalPrice += item.getTotalPrice();
        }
        totalPrice += deliveryCalculator.calculateDeliveryCost();
        return totalPrice;
    }
}

class DiscountPriceCalculator extends PriceCalculator {
    private double discountRate;

    public DiscountPriceCalculator(String deliveryMethod, double discountRate) {
        super(deliveryMethod);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice(ItemInCart[] items) {
        double totalPrice = super.calculateTotalPrice(items);
        totalPrice *= (1 - discountRate);
        return totalPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        ItemInCart[] items = {
                new ItemInCart("Item1", 2, 500.0),
                new ItemInCart("Item2", 1, 300.0)
        };

        PriceCalculator calculator1 = new PriceCalculator(DeliveryCalculatorFactory.PICKUP);
        System.out.println("Total Price (Pickup): " + calculator1.calculateTotalPrice(items));

        PriceCalculator calculator2 = new DiscountPriceCalculator(DeliveryCalculatorFactory.COMPANY_A, 0.1);
        System.out.println("Total Price (Company A with Discount): " + calculator2.calculateTotalPrice(items));
    }
}
