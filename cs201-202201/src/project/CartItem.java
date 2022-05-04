/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * 
 * class CartItem 
 * The instance of CartItem is one item in cart
 */

package project;

public class CartItem {

    public Goods goods;// which goods is added to cart
    public int cartNumber; // the number of goods in cart

    //Constructor
    public CartItem(Goods goods,  int number) {
        this.goods = goods;
        this.cartNumber = number;
    }

    //getter
    public Goods getGoods(){
        return this.goods;
    }

    public int getCartNumber(){
        return this.cartNumber;
    }

    //setter
    public void setGoods(Goods goods){
        this.goods = goods;
    }

    public void setCartNumber(int number){
        this.cartNumber = number;
    }

    @Override 
    public String toString(){
        return this.goods.toString() + " Cart Number: " + String.format("%-15s",this.cartNumber);
    }

    @Override
    // not use
    public boolean equals(Object obj){
        return true;
    }
}