package com.example.a16022916.learn2code.Simple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a16022916.learn2code.R;

public class SimpleListActivity extends AppCompatActivity {

    private ListView lvSimple;
    private ArrayAdapter aaSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
    }

    protected void onResume() {
        super.onResume();

        lvSimple = findViewById(R.id.simpleLvMain);
        String[] strArray = {"string1","string2"};
        aaSimple = new ArrayAdapter(this,android.R.layout.simple_list_item_1,strArray);
        lvSimple.setAdapter(aaSimple);

    }
}
