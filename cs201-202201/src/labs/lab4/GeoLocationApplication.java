/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/17
 * 
 */
package labs.lab4;

public class GeoLocationApplication {
    public static void main(String[] args) {
        GeoLocation geo1 = new GeoLocation();
        GeoLocation geo2 = new GeoLocation(30.5,30.5); 

        System.out.println(geo1.getLat());
        System.out.println(geo1.getLng());

        System.out.println(geo2.getLat());
        System.out.println(geo2.getLng());

    }
}
