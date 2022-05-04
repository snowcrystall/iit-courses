/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/07
 * 
 * class AgeRestrictedGoods for Age Restricted Items, 
 * a instance of AgeRestrictedGoods is not a Age Restricted item, it means all same Age Restricted items, with same ‘name’,‘price’,‘ageRestricted’
 * the field ‘number’ inherit from Goods class means the stock number of this AgeRestrictedGoods.
 */
package project;

public class AgeRestrictedGoods extends Goods {

    // the age restriction
    private int ageRestricted; 

    //Constructor
    public AgeRestrictedGoods(String name, double price, int number, int age) {
        super(name, price,number);
        this.ageRestricted = age > 0 ? age :0 ;
    }

    //getter
    public int getAgeRestricted(){
        return this.ageRestricted;
    }

    //setter
    public void setRestrictedAge(int age){
        this.ageRestricted = age > 0 ? age :0 ;
    }

    //update from a AgeRestrictedGoods object
    @Override
    public void update(Object obj){
        super.update(obj);
        if (!(obj instanceof AgeRestrictedGoods)) {
			return ;
		}
        AgeRestrictedGoods goods = (AgeRestrictedGoods) obj;
        this.ageRestricted = goods.getAgeRestricted();
    }

    //used for print to Console
    @Override
    public String toString(){
        return  super.toString() +  " AgeRestricted: " + this.ageRestricted ;
    }

    //used to check if two object is the same AgeRestrictedGoods
    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj)) {
			return false;
		} else if (!(obj instanceof AgeRestrictedGoods)) {
			return false;
		}
        AgeRestrictedGoods ageGoods = (AgeRestrictedGoods) obj;
        if (ageGoods.ageRestricted != this.ageRestricted){
            return false;
        }
        return true;
    }

    // clone a object
    @Override
    public Object clone() {
        
        AgeRestrictedGoods goods = null;
        try {
            goods = (AgeRestrictedGoods)super.clone();
        } catch (Exception e) {
            // do nothing 
        }
        return goods;
    }

    // return the type AgeRestricted
    @Override
    public String getType(){
        return "AgeRestricted";
    }

    // use this string to write to file 
    @Override
    public String serialize(){
        return super.serialize() + "," + this.ageRestricted;
    }
}
