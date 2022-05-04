/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * 
 */
package exams.second;

public class Circle  extends Polygon{
    private double radius;

    public Circle() {
        super();
        this.radius = 1;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius > 0 ? radius : 1;
    }

    @Override
    public String toString() {
        return super.toString() + " Radius: " + this.radius;
    }
    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
    @Override
    public double perimeter() {
        return 2.0 * Math.PI * this.radius;
    }
}
