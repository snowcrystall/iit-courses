/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/18
 * 
 * Part II: PhoneNumber Class
 */
package labs.lab4;

public class PhoneNumber {
    
    private String countryCode;
    private String areaCode;
    private String number;

    public PhoneNumber() {
        countryCode = "+1";
        areaCode = "000";
        number = "0000000";
    }

    public PhoneNumber(String cCode, String aCode, String number) {
        this.countryCode = cCode;
        if (this.validAreaCode(aCode)){
            this.areaCode = aCode;
        }else{
            this.areaCode = "000";
        }
        if (this.validNumber(number)){
            this.number = number;
        }else{
            this.number = "0000000";
        }
    }

    public String getCountryCode() {
        return this.countryCode;
    }
    public String getAreaCode() {
        return this.areaCode;
    }
    public String getNumber() {
        return this.number;
    }

    public void setCountryCode(String cCode) {
        this.countryCode = cCode;
    }
    public void setAreaCOde(String aCode) {
        if (this.validAreaCode(aCode)){
            this.areaCode = aCode;
        }
    }
    public void setNumber(String number) {
        if (this.validNumber(number)){
        this.number = number;
        }
    }

    public String toString() {
        return this.countryCode + this.areaCode + this.number;
    }
    public boolean validAreaCode(String aCode) {
        if (aCode.length() == 3) {
            return true;
        }
        return false;
    }
    public boolean validNumber(String number) {
        if (number.length() == 7) {
            return true;
        }
        return false;
    }
    public boolean equals(PhoneNumber pn) {
        if (this.countryCode.equals(pn.getCountryCode())
            && this.areaCode.equals(pn.getAreaCode()) 
            && this.number.equals(pn.getNumber()) ){
                return true;
            }
        return false;
    }
}
