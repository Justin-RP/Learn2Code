package com.example.a16022916.learn2code.Custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a16022916.learn2code.R;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    private ListView lvItem;
    private ArrayList<CustomItem> itemList;
    private CustomCustomAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
    }

    protected void onResume() {
        super.onResume();

        lvItem = findViewById(R.id.customLvMain);

        itemList = new ArrayList<>();
        CustomItem item1 = new CustomItem("Justin", "Cool Kid");
        CustomItem item2 = new CustomItem("Aiman", "Cry Baby");
        CustomItem item3 = new CustomItem("Darren", "Chess Master");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        ca = new CustomCustomAdapter(this, R.layout.custom_row, itemList);
        lvItem.setAdapter(ca);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomListActivity.this, itemList.get(i).getName() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
