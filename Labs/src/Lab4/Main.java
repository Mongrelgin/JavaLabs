package Lab4;

/*
    Реализовать класс треугольник.
    Методы для создания объектов. Вычисления площади, вычисления периметра, вычесления точки персечения меридиан.
    Описать свойства для получения состояния объекта
 */

public class Main {
    public static void main(String[] args) {
        Point a = new Point(-4,-1);
        Point b = new Point(0,-3);
        Point c = new Point(2,1);
        Triangle tr = new Triangle(a,b,c);
        tr.TriangleState();
    }
}
