/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * 
 */
package exams.second;

public abstract class Polygon   {

    protected String name;

    public Polygon(){
        this.name  = "";
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: " + this.name;
    }

    public abstract double area();
    public abstract double perimeter();
}
