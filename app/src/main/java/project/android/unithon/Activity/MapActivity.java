package project.android.unithon.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import project.android.unithon.Fragment.MapFragment;
import project.android.unithon.R;

public class MapActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        container = (FrameLayout)findViewById(R.id.container);

        fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MapFragment()).commit();

    }

    public void replaceFragment(Fragment fragment){

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }
}
