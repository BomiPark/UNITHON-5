package project.android.unithon.Activity;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import project.android.unithon.Adapter.ItemAdapter;
import project.android.unithon.Model.Item;
import project.android.unithon.Model.LatXLngY;
import project.android.unithon.R;
import project.android.unithon.Service.LatticeChangeService;

import static project.android.unithon.R.id.toSearch;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    StaggeredGridLayoutManager st;
    ArrayList<Item> items;

    EditText editSearch;
    Geocoder geoCoder;

    LatLng latLng;
    LatXLngY latXLngY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();
        setToolbar();
    }

    void init(){

        items = new ArrayList<Item>();
        setData();

        recyclerView = (RecyclerView)findViewById(R.id.recycler1);
        st = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(st);
        adapter = new ItemAdapter(items, getApplicationContext(), R.layout.item_layout);
        recyclerView.setAdapter(adapter);

        geoCoder = new Geocoder(this);

    }

    void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        View viewToolbar = getLayoutInflater().inflate(R.layout.tool_bar, null);
        editSearch = (EditText)viewToolbar.findViewById(R.id.search);
        ImageView toSearch = (ImageView) viewToolbar.findViewById(R.id.toSearch);
        toSearch.setOnClickListener(clickListener);

        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
    }

    ImageView.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case toSearch: //todo 서버에 전송

                    String search = editSearch.getText().toString();
                    latLng =  getLatLng(search);
                    latXLngY = LatticeChangeService.get().convertGRID_GPS(0, latLng.latitude, latLng.longitude);
                    break;
            }
        }
    };

    void setData(){
        items.add(new Item("가라", "1111111sdfsdgWgGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG111111111111", "30분전", "40k", "DDD"));
        items.add(new Item("가라", "222222222222222222", "30분전", "40k", "DDD"));
        items.add(new Item("가라", "233333333E33333333333", "30분전", "40k", "DDD"));
        items.add(new Item("가라", "44444444FEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE44444444", "30분전", "40k", "DDD"));
        items.add(new Item("가라", "5555555555555", "30분전", "40k", "DDD"));

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

}
