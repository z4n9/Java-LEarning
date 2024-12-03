package Patterns.Prototype;

/// Абстрактный класс пользователя биржи фриланса.
public abstract class User implements Cloneable {
    private int id;
    private String fullName;

    /// Конструктор
    public User(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    /// Метод клонирования (может быть вызван в подклассах через super).
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Full Name: " + fullName;
    }
}

