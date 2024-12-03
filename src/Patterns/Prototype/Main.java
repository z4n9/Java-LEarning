package Patterns.Prototype;

public class Main {
    public static void main(String[] args) {
        // Создаем исполнителя
        Executor executor = new Executor(1, "John Doe");
        Executor clonedExecutor = executor.clone();
        System.out.println("Original Executor: " + executor);
        System.out.println("Cloned Executor: " + clonedExecutor);

        // Создаем заказчика
        Passport passport = new Passport("123456789", "2024-11-28");
        Customer customer = new Customer(2, "Jane Smith", passport);
        Customer clonedCustomer = customer.clone();

        System.out.println("Original Customer: " + customer);
        System.out.println("Cloned Customer: " + clonedCustomer);

        // Изменяем данные в оригинальном объекте паспорта
        passport.setPassportNumber("987654321");
        System.out.println("After modification:");
        System.out.println("Original Customer: " + customer);
        System.out.println("Cloned Customer: " + clonedCustomer);
    }
}
