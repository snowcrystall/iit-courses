/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * 
 */
package exams.second;

public class Rectangle  extends Polygon{

    private double width;
    private double height;

    public Rectangle() {
        super();
        this.width = 1;
        this.height = 1;
    }

    public void setWidth(double width) {
        this.width = width > 0 ? width : 1;
    }

    public void setHeight(double height) {
        this.height = height > 0 ? height : 1;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return super.toString() + " Width: " + this.width + " Height: " + this.height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }
    @Override
    public double perimeter() {
        return 2 * (this.height + this.height);
    }
}
