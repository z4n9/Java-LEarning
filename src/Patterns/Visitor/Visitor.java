package Patterns.Visitor;

interface Shape {
    void accept(VisitorInterface visitor);
}


class Circle implements Shape {
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
    public void draw() {
        System.out.println("Рисуем круг");
    }
}

class Rectangle implements Shape {
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
    public void draw() {
        System.out.println("Рисуем прямоугольник");
    }
}

interface VisitorInterface {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

// Конкретный посетитель
class DrawVisitor implements VisitorInterface {
    public void visit(Circle circle) {
        circle.draw();
    }

    public void visit(Rectangle rectangle) {
        rectangle.draw();
    }
}

// Пример использования
public class Visitor {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(), new Rectangle() };
        VisitorInterface drawVisitor = new DrawVisitor();

        for (Shape shape : shapes) {
            shape.accept(drawVisitor); // вызывается соответствующий visit
        }
    }
}

