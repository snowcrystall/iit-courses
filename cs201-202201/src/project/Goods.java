/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/07
 * class Goods is for Shelved Item
 * a instance of Goods is not a item, it means all same goods items, with same ‘name’,‘price’,
 * the field ‘number’  means the stock number of this Goods.
 */
package project;


public class Goods implements Comparable<Goods>,Cloneable {

    private String name;// the name of goods
    private double price;// the price of goods
    private int number;// the number of this goods in stock

    //Constructor
    public Goods(String name, double price, int number){
        this.name = name;
        this.price = (price>0) ? price : 0 ;
        this.number = (number>0) ? number : 0 ;
    }
  
    //getters
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public int getNumber(){
        return this.number;
    }

    //setters 
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = (price>0) ? price : 0 ;
    }
    public void setNumber(int number){
        this.number = (number>0) ? number : 0 ;
    }

    // update from a oject
    public void update(Object obj){
        if (! (obj instanceof Goods)){
            return ;
        }
        Goods goods = (Goods) obj;
        this.name = goods.getName();
        this.price = goods.getPrice();
        this.number = goods.getNumber();
    }

    @Override
    public String toString(){
        return "Name: " + String.format("%-20s",this.name) + " Price: " + String.format("%-10s",this.price) + "Stock Number: " + String.format("%-10s",this.number);
    }

    //only compare name, used by sort and search
    @Override
    public int compareTo(Goods goods){ 
        return this.name.compareTo(goods.name);
    }

    // clone a object
    @Override
    public Object clone() {
        Goods goods = null;
        try {
            goods = (Goods)super.clone();       
        } catch (Exception e) {
            //do nothing
        }
        return goods;   
    }

    /*
     * used to check if two object is the same Goods, 
     * The same Goods are these with same 'name','price', 
     * the field 'numer' means the stock number of this goods, so equals dont check it 
     */
    @Override
    public boolean equals(Object obj){
        if (! (obj instanceof Goods)){
            return false;
        }
        Goods goods = (Goods) obj;
        if (!goods.name.equals(this.name)){
            return false;
        }else if (goods.price != this.price){
            return false;
        }
        return true;
    }
  
    // return the type Shelved
    public String getType(){
        return "Shelved";
    }

    //used for string the data when save to file
    public String serialize() {
        return this.getType()+","+this.name+","+this.price+","+this.number;
    }

    // check if a gavin name is equals to this goods
    public boolean equalsName(String name) {
        return this.name.equals(name);
    }
    
}
