/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/18
 * 
 */
package labs.lab4;

public class PhoneNumberClient {
    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber();
        PhoneNumber pn2 = new PhoneNumber("+1","234","23457624");

        System.out.println(pn1);
        System.out.println(pn2);

        System.out.println(pn2.toString());

        pn1.setAreaCOde("456");
        pn1.setAreaCOde("2345");
        pn1.setNumber("2345678");
        System.out.println(pn1.toString());
    }
}
