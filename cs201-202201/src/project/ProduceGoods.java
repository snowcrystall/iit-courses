/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/07
 * class ProduceGoods is for Produce Item
 * a instance of ProduceGoods is not a ProduceGoods item, it means all same ProduceGoods items, with same ‘name’,‘price’,expireDate
 * the field ‘number’ inherit from Goods class means the stock number of this ProduceGoods.
 */
package project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProduceGoods extends Goods {
    private  Date expireDate ;//expire Date

    //Constructor
    public ProduceGoods(String name, double price, int number, Date date) {
        super(name, price,number);
        this.expireDate = date;
    
    }
   
    //getter
    public Date getExpireDate(){
        return this.expireDate;
    }

    //setter
    public void setExpireDate(Date date){
        this.expireDate = date;
    }
    
    //check if the goods is Expired
    public boolean isExpire(){
        Date dateNow = new  Date();
        if (this.expireDate != null && dateNow.compareTo(this.expireDate) > 0) {
            return true;
        }
        return false;
    }

    //update from a ProduceGoods object
    @Override
    public void update(Object obj){
        super.update(obj);
        if (!(obj instanceof ProduceGoods)) {
			return ;
		}
        ProduceGoods produceGoods = (ProduceGoods) obj;
        this.expireDate = produceGoods.getExpireDate();
    }

    @Override
    public String toString(){
        return  super.toString() +  " ExpireDate: " +  this.formatDate();
    }

    //used to check if two object is the same ProduceGoods
    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj)) {
			return false;
		} else if (!(obj instanceof ProduceGoods)) {
			return false;
		}
        ProduceGoods produceGoods = (ProduceGoods) obj;
        if (!produceGoods.expireDate.equals(this.expireDate)){
            return false;
        }
        return true;
    }

    // clone a object
    @Override
    public Object clone() {
        ProduceGoods goods = null;
        try {
            goods = (ProduceGoods)super.clone();          
        } catch (Exception e) {
            //throws CloneNotSupportedException 
        }
        return goods;
    }

    // return the type Produce
    @Override
    public String getType(){
        return "Produce";
    }

    @Override
    public String serialize(){
        return super.serialize() + "," + this.formatDate();
    }

    private String formatDate(){
        return new SimpleDateFormat("MM/dd/yyyy",new Locale("en")).format(this.expireDate);
    }
}
