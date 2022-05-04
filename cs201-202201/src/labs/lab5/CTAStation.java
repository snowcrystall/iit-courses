/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/03/07
 * 
 * CTAStation
 */
package labs.lab5;

import labs.lab4.GeoLocation;

public class CTAStation  extends GeoLocation{
    
    private String name;
    private String location;
    private boolean wheelchair;
    private boolean open;

    public CTAStation(){
        super();
        name = "";
        location = "";
        wheelchair = false;
        open = false;
    }

    public CTAStation(String name,double lat, double lng, String location, boolean wheelchair, boolean open){
        super(lat,lng);
        this.name = name;
        this.location = location;
        this.wheelchair = wheelchair;
        this.open = open; 
    }
    public String getName(){
        return this.name;
    }
    public String getLocation() {
        return this.location;
    }
    public boolean hasWheelchair(){
        return this.wheelchair;
    }
    public boolean isOpen(){
        return this.open;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setWheelchair(boolean wheelchair){
        this.wheelchair = wheelchair;
    }
    public void setOpen(boolean open){
        this.open = open;
    }
    public String  toString(){
        return "name:" + this.name + " geolocation:" + super.toString() + " location:" + this.location + " has wheelchair:" + this.wheelchair + " isopen:" + this.isOpen();
    }
    public boolean equals(Object obj){
        if (!super.equals(obj)) {
			return false;
		} else if (!(obj instanceof CTAStation)) {
			return false;
		}
        CTAStation c = (CTAStation)obj;
        if (this.name.equals(c.getName()) && this.location.equals(c.getLocation()) && this.wheelchair == c.hasWheelchair() && this.open == c.isOpen()){
            return true;
        }
        return false;
    }
}
