/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/20
 * 
 */
package labs.lab4;

public class PotionApplication {
    public static void main(String[] args) {
        Potion p1 = new Potion();
        Potion p2 = new Potion("erte", 2.3);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }
}
