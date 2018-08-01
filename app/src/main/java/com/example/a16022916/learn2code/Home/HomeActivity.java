package com.example.a16022916.learn2code.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a16022916.learn2code.Custom.CustomListActivity;
import com.example.a16022916.learn2code.Email.EmailActivity;
import com.example.a16022916.learn2code.FrameLayouts.FragmentMainActivity;
import com.example.a16022916.learn2code.Image.ImageActivity;
import com.example.a16022916.learn2code.LoginApp.LoginActivity;
import com.example.a16022916.learn2code.MessageMainActivity;
import com.example.a16022916.learn2code.ScheduledNotification.NotificationActivity;
import com.example.a16022916.learn2code.Serializing.ObjectSerializableActivity;
import com.example.a16022916.learn2code.R;
import com.example.a16022916.learn2code.Result.ResultActivity;
import com.example.a16022916.learn2code.Simple.SimpleListActivity;
import com.example.a16022916.learn2code.Website.WebsiteActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView lvItem;
    ArrayList<HomeItem> itemList;
    HomeCustomAdapter ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvItem = findViewById(R.id.homeLvMain);

        itemList = new ArrayList<>();
        itemList.add(new HomeItem("Simple ListView", "Make one string only listView", 1));
        itemList.add(new HomeItem("Advanced ListView", "Customise your own listView and Add Toast when Clicked", 1));
        itemList.add(new HomeItem("Adding Images", "Add your own image",2));
        itemList.add(new HomeItem("Returning Results", "Return results; Radio Group selection",3));
        itemList.add(new HomeItem("Serializing Objects", "Intents with objects",3));
        itemList.add(new HomeItem("Sending Email","Send an email",3));
        itemList.add(new HomeItem("Opening webpage","Use websites",3));
        itemList.add(new HomeItem("Login Page","User DATABASE to login; CRUD (P05 Lesson Also)",4));
        itemList.add(new HomeItem("Scheduled Notification", "Sending Notification",6));
        itemList.add(new HomeItem("Layouts!","Fragment; Landscape; ScrollView", 7));
        itemList.add(new HomeItem("Message Retriever", "Retrieving messages", 7));

        ca = new HomeCustomAdapter(this, R.layout.home_row, itemList);
        lvItem.setAdapter(ca);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // 1st starts from 0
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(getBaseContext(), SimpleListActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), CustomListActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(), ImageActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getBaseContext(), ResultActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getBaseContext(), ObjectSerializableActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getBaseContext(), EmailActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getBaseContext(), WebsiteActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getBaseContext(), NotificationActivity.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(getBaseContext(), FragmentMainActivity.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(getBaseContext(), MessageMainActivity.class);
                        startActivity(intent);
                        default:
                            Log.d("HomeActivity","intent for position " + position + " not added yet");
                }
            }
        });
    }
}
