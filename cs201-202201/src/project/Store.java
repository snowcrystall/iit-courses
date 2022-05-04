/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/07
 * Stroe is an abstraction of the simple store
 */
package project;

import java.util.ArrayList;
import java.util.Collections;

public class Store {

    // the data of stroe
    private ArrayList<Goods> goodsData;// the stock of store
    private ArrayList<CartItem> cart;// the cart

    /* 
     * the init data is sorted.
     */
    public Store(ArrayList<Goods> goods) {
        Collections.sort(goods);
        this.goodsData = goods;
        this.cart = new ArrayList<CartItem>();
    }

    /*
     * delete goods ,this delete all same items
     */
    public void deleteGoods(int pos) {
        try {
            // if cart is not empty, delete the goods from cart
            Goods goods = this.goodsData.remove(pos);
            if (!this.cart.isEmpty()){
                for (CartItem cartItem : cart) {
                    if (cartItem.getGoods().equals(goods)){
                        cart.remove(cartItem);
                    }
                }
            }
            this.goodsData.remove(pos);
        } catch (Exception e) {
            return ;
        }
    }

    /*
     * update goods, keep the data sorted.
     */
    public boolean updateGoods(int pos, Goods goods) {
        
        Goods orginGoods = this.goodsData.get(pos);
        if (orginGoods != null) {
            if (orginGoods.compareTo(goods) == 0) {
                // the name has not changed 
                orginGoods.update(goods);
            } else {
                // the name has changed, add again to keep ordered by name
                orginGoods.update(goods);
                this.goodsData.remove(pos);
                addGoods(orginGoods);
            }
            return true;
        }
        return false;
    }

    /*
     * add goods,if there alreay has this goods, add the stock number of goods.
     */
    public boolean addGoods(Goods goods) {
       
        int insertPos;
        int compare;
        Goods ptrGoods ;
        for (insertPos = 0; insertPos < this.goodsData.size(); insertPos++) {
            ptrGoods = this.goodsData.get(insertPos);
            compare = ptrGoods.compareTo(goods);
            if (compare > 0) {
                break;
            }else if (compare == 0){
                if (goods.equals(ptrGoods)){
                    // find same goods, add the number
                    ptrGoods.setNumber(ptrGoods.getNumber()+goods.getNumber());
                    return true;
                }
            }
        }
        // There are no same goods in stock
        this.goodsData.add(insertPos, goods);
        return true;
    }

    /*
     * search by name witch user input,retrun a list that has same name.
     */
    public ArrayList<Goods> getGoodsByName(String name) {  
        int pos = Collections.binarySearch(this.goodsData, new Goods(name, 0.0, 0));
        if (pos < 0 ) {
            return null;
        }
        // There may be multiple same goods，
        // Because the list is ordered, the  goods that has same name are near it
        ArrayList<Goods> goodsList = new ArrayList<Goods>();
        goodsList.add(getGoods(pos));
        Goods  goods = getGoods(pos - 1);
        for (int i = 2 ;goods != null && goods.equalsName(name);i++){
            goodsList.add(goods);
            goods = getGoods(pos - i);
        }
        goods = getGoods(pos + 1);
        for (int i = 2 ;goods != null && goods.equalsName(name);i++){
            goodsList.add(goods);
            goods = getGoods(pos + i);
        }
        return goodsList;
    }

    /*
     * add a goods to cart, if there already has this goods in cart ,add the number in cart.
     */
    public boolean addToCart(int pos) throws Exception{
        if (!validPos(pos)) {
            throw new Exception("This index does not exist.");
        }
        Goods goods = this.goodsData.get(pos);
        if (goods.getNumber()<=0){
            throw new Exception("Insufficient inventory.");
        }
        // check if the goods is Expire
        if (goods instanceof ProduceGoods){
            ProduceGoods tmpProduceGoods = (ProduceGoods)goods;
            if(tmpProduceGoods.isExpire()){
                throw new Exception("The goods is expired .");
            }
        }
        for (CartItem cartItem : cart) {
            if (cartItem.getGoods().equals(goods)){
                //there already has this goods in cart ,add the number in cart.
                if (goods.getNumber()-cartItem.getCartNumber()>0){
                    cartItem.setCartNumber(cartItem.getCartNumber()+1);
                    return true;
                }else{
                    throw new Exception("Insufficient inventory.");
                }
                
            }
        }
        // add new goods
        CartItem cartItem = new CartItem(goods , 1);
        this.cart.add(cartItem);
        return true;
    }

    /*
     * delete a goods from cart
     */
    public boolean deleteFromCart(int pos) throws Exception{
        if ((pos < 0) || (pos > this.cart.size() - 1)) {
            throw new Exception("This index does not exist.");
        }
        CartItem cartItem = this.cart.get(pos);
        if (cartItem.getCartNumber()>1){
            cartItem.setCartNumber(cartItem.getCartNumber() - 1);
        }else{
            this.cart.remove(pos);
        }
        return true;
    }

    /*
     * check out 
     */
    public void checkoutCart() throws Exception {
        for (CartItem cartItem : cart) {
            Goods goods  = cartItem.getGoods();
            if (goods.getNumber()-cartItem.getCartNumber() < 0){
                throw new Exception("---- Goods " + goods.getName() + " Insufficient inventory only check out " + goods.getNumber() + "" );
            }
            goods.setNumber(goods.getNumber()-cartItem.getCartNumber());
            
        }
        clearCart();
    }

    /*
     * clear cart
     */
    public void clearCart(){
        this.cart.clear();
    }

    public String cartString() {
        String str = "";
        int i = 0;
        for (CartItem cartItem : cart) {
            str +=  String.format("CartIndex: %-10s",i++) + cartItem.toString() + "\n";
        }
        return str;
    }

    /*
     * get a clone of goods at index pos
     */
    public Goods getGoods(int pos) {
        if (!validPos(pos)) {
            return null;
        }
        return (Goods)this.goodsData.get(pos).clone();
    }

    @Override
    public String toString() {
        String str = "";
        int i = 0;
        for (Goods goods : goodsData) {
            str += String.format("Index: %-10s",i++) + goods.toString() + "\n";
        }
        return str;
    }

    public String serialize(){
        String str = "";
        for (Goods goods : goodsData) {
            str += goods.serialize() + "\n";
        }
        return str;
    }
    public boolean validPos(int pos){
        if ((pos < 0) || (pos > this.goodsData.size() - 1)) {
            return false;
        }
        return true;
    }
}
