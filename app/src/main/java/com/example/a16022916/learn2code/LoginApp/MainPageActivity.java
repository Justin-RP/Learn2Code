package com.example.a16022916.learn2code.LoginApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a16022916.learn2code.DatabaseHelper;
import com.example.a16022916.learn2code.EditApp.EditAppActivity;
import com.example.a16022916.learn2code.R;

public class MainPageActivity extends AppCompatActivity {

    private int requestCodeForButton = 1;
    private DatabaseHelper db = new DatabaseHelper(this);
    private TextView tvWelcome, tvNumber;
    private Button btnLogout, btnEdit;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        tvWelcome = findViewById(R.id.mainPageTvWelcome);
        tvNumber = findViewById(R.id.mainPageTvPhone);
        btnLogout = findViewById(R.id.mainPageBtnLogout);
        btnEdit = findViewById(R.id.mainPageBtnEdit);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent i = getIntent();
        String strUserName = i.getStringExtra("userName");
        currentUser = db.getUser(strUserName);
        tvWelcome.setText("Welcome " + currentUser.getName());
        tvNumber.setText(String.valueOf(currentUser.getPhoneNumber()));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), EditAppActivity.class);
                intent.putExtra("userName", currentUser.getName());
                startActivityForResult(intent,requestCodeForButton);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Checks that the return is for this activity
                if(requestCode == requestCodeForButton){
                    // Get data passed back from 2nd activity
                    boolean isDeleted = data.getBooleanExtra("isUserDeleted",false);
                    if (isDeleted) {
                        finish();
                    }
                }
            } else {
                Toast.makeText(this, "Data returned is null", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
