package project.android.unithon.Activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import project.android.unithon.Adapter.ItemAdapter;
import project.android.unithon.Model.Item;
import project.android.unithon.R;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    StaggeredGridLayoutManager st;
    ArrayList<Item> items;

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

    }

    void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        View viewToolbar = getLayoutInflater().inflate(R.layout.tool_bar, null);
        ImageView toSearch = (ImageView) viewToolbar.findViewById(R.id.toSearch);
        toSearch.setOnClickListener(clickListener);

        actionBar.setCustomView(viewToolbar, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
    }

    ImageView.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.toSearch : //todo 서버에 검색어로 위도경도 받고 격자로 변환해서 서버에 전송
                    Toast.makeText(getApplicationContext(), " 검색어 ", Toast.LENGTH_LONG).show();
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
}
