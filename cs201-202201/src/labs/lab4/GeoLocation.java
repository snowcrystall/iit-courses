/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/02/17
 * 
 * Part I: GeoLocation Class
 */
package labs.lab4;

public class GeoLocation {
    
    private double lat;
    private double lng;

    public GeoLocation() {
        lat = 0;
        lng = 0;
    }

    public GeoLocation(double lat,double lng) {
        if (validLat(lat)) {
            this.lat = lat;
        }else{
            this.lat = 0;
        }
        if (validLng(lng)) { 
            this.lng = lng;
        }else{
            this.lng  = 0;
        }
    }

    public  double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLat(double lat) {
        if (validLat(lat)) {
            this.lat = lat;
        }
    }

    public void setLng(double lng) {
        if (validLng(lng)){
            this.lng = lng;
        }
    }
    @Override
    public String toString() {
        return "(" + lat + ", " + lng + ")";
    }

    public boolean validLat(double lat){
        if (lat >= -90 && lat <= 90) {
            return true;
        }
        return false;
    }

    public boolean validLng(double lng){
        if (lng >= -180 && lng <= 180){
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GeoLocation)){
            return false;
        }
        GeoLocation g = (GeoLocation)obj;
        if (this.lat != g.getLat() || this.lng != g.getLng()){
            return false;
        }
        return true;
    }
    public double calsDistance(GeoLocation g) {
        return Math.sqrt(Math.pow(this.lat - g.getLat(), 2) + Math.pow(this.lng - g.getLat(), 2));
    }
    public double calsDistance(double lat, double lng) throws Exception {
        if (!validLat(lat) || !validLng(lng)){
            throw new Exception("invalid param");
        }
        return Math.sqrt(Math.pow(this.lat - lat, 2) + Math.pow(this.lng - lng, 2));
    }
}
