package project.android.unithon.Fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import project.android.unithon.Model.LatXLngY;
import project.android.unithon.Model.MarkerItem;
import project.android.unithon.R;
import project.android.unithon.Service.LatticeChangeService;
import project.android.unithon.Service.LocationListener;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapFragment extends Fragment implements GoogleMap.InfoWindowAdapter{

    GoogleMap googleMap;
    static View view;
    static int zoomLevel = 1;

    public static int MIN = 1;
    public static int CENTER = 2;
    public static int MAX = 3;

    LocationListener locationListener;
    MarkerOptions markerOptions;
    View markerWindowView;

    ArrayList<MarkerItem> items;

    Marker marker;
    MarkerOptions options;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            view = inflater.inflate(R.layout.fragment_map, container, false);}
        catch (InflateException e){}

        locationListener = new LocationListener(getActivity());
        items = new ArrayList<MarkerItem>();

        getData();

        com.google.android.gms.maps.MapFragment mapFragment = (com.google.android.gms.maps.MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(mapReadyCallback);

        return view;
    }

    OnMapReadyCallback mapReadyCallback  = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap map) {

            googleMap = map;

            LatLng baseLatlng = new LatLng(locationListener.getLocation().latitude, locationListener.getLocation().longitude);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(baseLatlng, 8));

            markerOptions = new MarkerOptions(); //todo 삭제해도 ㅇ 현재위치 파악
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
            markerOptions.position(baseLatlng);
            googleMap.addMarker(markerOptions);

            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng){ //todo 삭제
                    change(latLng);
                }
            });

            googleMap.setMinZoomPreference(6.8f); // 최소 축소는 여기까지

            googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
                @Override
                public void onCameraMove() {
                    float zoom = googleMap.getCameraPosition().zoom;
                    if(zoom < 7.0 && zoomLevel != 1){
                        zoomLevel = 1; //todo 서버에 정보 요청
                        Log.d("check", "1111111111");
                    }
                    else if(zoom < 11.3 && zoom > 7.95 && zoomLevel != 2){
                        zoomLevel = 2;
                        Log.d("check", "222222222222222");
                    }
                    else if(zoom > 11.3 && zoomLevel != 3){
                        zoomLevel = 3;
                        Log.d("check", "3333333333333333333");
                    }
                }
            });

        }

    };

    public void change(LatLng latLng){

        LatXLngY lat = LatticeChangeService.get().convertGRID_GPS(0, latLng.latitude, latLng.longitude);
    }

    public void getData(){

        items.add(new MarkerItem("서울시 중랑구",1,2, 37.538523, 126.96568));
        items.add(new MarkerItem("서울시 중랑구2",1,2, 37.527523, 126.96568));
        items.add(new MarkerItem("서울시 중랑구3",1,2, 37.549523, 126.96568));
        items.add(new MarkerItem("서울시 중랑구4",1,2, 37.538523, 126.95768));

        options = new MarkerOptions();

        for (MarkerItem item : items) {
            options.title(item.getAddress());
            options.position(new LatLng(item.getLat(), item.getLon()));
            switch (item.getReal()){
                case 0 : marker = googleMap.addMarker(markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.stroke_3)));
                    break;
            }
        }
    }

    public void setMarker(){

        markerWindowView = getActivity().getLayoutInflater().inflate(R.layout.marker_window, null); // 마커윈도우
        //todo 객체들 찾아
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(view != null){
            ViewGroup parent = (ViewGroup)view.getParent();
            if(parent!=null){
                parent.removeView(view);
            }
        }
    }


    @Override
    public View getInfoWindow(Marker marker) { // 먼저 호출 null 이 반환되면 getInfoContent메소드 호출
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) { // 여기서도 null이 반환되면 기본 정보창 반환
        return null;
    }
}
