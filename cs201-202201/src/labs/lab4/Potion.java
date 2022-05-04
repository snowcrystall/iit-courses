/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/20
 * 
 * Part III:  Potion Class
 */
package labs.lab4;

public class Potion {
    private String name;
    private double strength;

    public Potion() {
        name = "";
        strength = 0;
    }
    public Potion(String name, double strength) {
        this.name = name;
        if (validStrength(strength)){
            this.strength  = strength;
        }
    }

    public String getName() {
        return this.name;
    }
    public double getStrength() {
        return this.strength;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStrength(double strength) {
        if (validStrength(strength)) {
            this.strength = strength;
        }
    }
    public String toString() {
        return "name: " + this.name + " , strength: " + this.strength;
    }
    public boolean validStrength(double strength) {
        if (strength >= 0 && strength <= 10){
            return true;
        }
        return false;
    }
    public boolean equals(Potion p) {
        if (this.name.equals(p.getName()) && this.strength == p.getStrength()){
            return true;
        }
        return false;
    }
}
