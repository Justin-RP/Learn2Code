package com.example.a16022916.learn2code.FrameLayouts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a16022916.learn2code.R;

public class FragmentMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment f1 = new FirstFragmentActivity();
        ft.replace(R.id.fragFlFrame1, f1);

        Fragment f2 = new SecondFragmentActivity();
        ft.replace(R.id.fragFlFrame2, f2);

        ft.commit();


    }

}
