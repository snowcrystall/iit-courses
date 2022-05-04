/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/18
 * 
 */
package labs.lab4;

public class PhoneNumberApplication {
    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber();
        PhoneNumber pn2 = new PhoneNumber("+1","234","2357624");

        System.out.println(pn1.toString());
        System.out.println(pn2.toString());
    }
}
