class Point{
    double x, y;
    void move(double dx, double dy){
        x += dx;
        y += dy;
    }
    void mirror(double cx, double cy){
        x = 2 * cx - x;
        y = 2 * cy - y;
    }
}
