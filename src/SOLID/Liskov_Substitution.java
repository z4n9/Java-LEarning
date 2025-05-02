package SOLID;

public class Liskov_Substitution {
    public static void main(String[] args) {

        Rectangle rectangle = getRect();
        rectangle.setWidth(10);
        rectangle.setHeight(5);

        Square square = getSq();
        square.setWidth(6);

        System.out.println(rectangle.getSquare());
        System.out.println(square.getSquare());

    }
    public static Rectangle getRect() {
        return new Rectangle();
    }
    public static Square getSq() {
        return new Square();
    }
}

interface Shape{
    int getSquare();
}

class Rectangle implements Shape{
    int width;
    int height;

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getSquare() {
        return width * height;
    }
}

class Square implements Shape{
    int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public  int getSquare() {
        return width * width;
    }
}