/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/25
 * 
 * Question Five: Objects
 */
package exams.first;

public class Pet {

    private String name;
    private int age;

    public Pet(){
        name  = "";
        age = 0;
    }

    public Pet(String name, int age){
        this.name = name;
        this.age = 0;
        if (validAge(age)){
            this.age = age;
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if (validAge(age)){
            this.age = age;
        }
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public boolean equals(Pet p){
        if (this.name.equals(p.getName()) && this.age == p.getAge()){
            return true;
        }
        return false;
    }
    public String toString(){
        return "Name: " + this.name + " Age: " + this.age;
    }
    private boolean validAge(int age){
        if(age > 0){
            return true;
        }
        return false;
    }
}
