package project.android.unithon.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import project.android.unithon.R;

public class LoadingActivity extends AppCompatActivity {
    private static String TAG = "LoadingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }
}
