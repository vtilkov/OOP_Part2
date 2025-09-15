package ru;

public class Square {

    private int x; //приватные поля (Координата левого верхнего угла по Х)
    private int y; //приватные поля (Координата левого верхнего угла по Y)
    private int sideLength; //приватные поля (Длина стороны)

    //Конструктор
    public Square(int x, int y, int sideLength) {
        setX(x);
        setY(y);
        setSideLength(sideLength); // Длина стороны обязана быть всегда положительной
    }

    //геттеры и сеттеры
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0) throw new IllegalArgumentException("Длина стороны должна быть положительной"); // Длина стороны обязана быть всегда положительной
        this.sideLength = sideLength;
    }

    // Метод для получения строкового представления точки
    private String getPointString() {
        return "(" + x + ", " + y + ")";
    }

    // Строковое представление квадрата
    @Override
    public String toString() {
        return "Квадрат в точке " + getPointString() + " со стороной " + sideLength;
    }
}