package project.android.unithon.Service;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by qkrqh on 2017-07-29.
 */

public class GeoCodingService {

    Geocoder geoCoder;

    public Geocoder get(Context context){
        geoCoder = new Geocoder(context);
        return geoCoder; //todo 생성해서써야할듯
    }

    public LatLng getLatLng(String address){
        List<Address> list = null;
        try {
            list = geoCoder.getFromLocationName(address, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new LatLng(list.get(0).getLatitude(), list.get(0).getLongitude());
    }

    public String getAddress(LatLng latLng){
        List<Address> list = null;
        try {
            list = geoCoder.getFromLocation(latLng.latitude, latLng.longitude, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.get(0).getAddressLine(0).toString();
    }
}
