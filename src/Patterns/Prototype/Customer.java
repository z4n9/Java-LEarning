package Patterns.Prototype;

/// Заказчик (класс-наследник).
public class Customer extends User {
    private Passport passport;

    /// Конструктор
    public Customer(int id, String fullName, Passport passport) {
        super(id, fullName);
        this.passport = passport;
    }



    /// Клонирование пользователя (глубокое).
    @Override
    public Customer clone() {
        try {
            Customer cloned = (Customer) super.clone();
            // Создание нового объекта паспорта
            cloned.passport = new Passport(this.passport.getPassportNumber(), this.passport.getIssueDate());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Customer: " + super.toString() + ", " + passport;
    }
}
