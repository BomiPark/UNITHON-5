package project.android.unithon.Model;

/**
 * Created by qkrqh on 2017-07-30.
 */

public class MarkerItem {

    String address;
    int real;
    int forecast;
    double lat;
    double lon;

    public MarkerItem(){

    }

    public MarkerItem(String address, int real, int forecast, double lat, double lon) {
        this.address = address;
        this.lat = lat;
        this.lon = lon;
        this.real = real;
        this.forecast = forecast;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getForecast() {
        return forecast;
    }

    public void setForecast(int forecast) {
        this.forecast = forecast;
    }
}
