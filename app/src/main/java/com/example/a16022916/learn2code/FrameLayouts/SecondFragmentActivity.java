package com.example.a16022916.learn2code.FrameLayouts;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a16022916.learn2code.R;

public class SecondFragmentActivity extends Fragment {

    TextView tvText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_second_fragment, container, false);

        // TODO Note that need view
        tvText = view.findViewById(R.id.fragmentTvText);

        return view;
    }
}
