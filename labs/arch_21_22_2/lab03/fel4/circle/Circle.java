package circle;

import circle.utils.Point;

public class Circle {
    private double x, y, radius;

    public Circle(double x, double y, double radius) {
        setX(x);
        setY(y);
        setRadius(radius);
    }

    public double getArea() {
        return this.radius * this.radius * 3.14159265;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        if(radius > 0) {
            this.radius = radius;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public Point getCenter() {
        return new Point(x, y);
    }
}

