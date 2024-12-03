package Patterns.Prototype;

/// Исполнитель (класс-наследник).
public class Executor extends User {
    public Executor(int id, String fullName) {
        super(id, fullName);
    }

    /// Клонирование пользователя (поверхностное).
    @Override
    public Executor clone() {
        try {
            return (Executor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Executor: " + super.toString();
    }
}

