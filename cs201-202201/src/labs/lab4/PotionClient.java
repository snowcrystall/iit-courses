/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/20
 * 
 */
package labs.lab4;

public class PotionClient {
    public static void main(String[] args) {
        Potion p1 = new Potion();
        Potion p2 = new Potion("erte", 233);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        p2.setStrength(2.5);
        System.out.println(p2.getStrength());
        System.out.println(p1.equals(p2));

        p1.setName(p2.getName());
        p1.setStrength(p2.getStrength());
        System.out.println(p1.equals(p2));
    }
}
