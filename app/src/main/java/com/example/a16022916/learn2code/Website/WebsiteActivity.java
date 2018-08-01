package com.example.a16022916.learn2code.Website;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a16022916.learn2code.R;

public class WebsiteActivity extends AppCompatActivity {

    Button btnRp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        btnRp = findViewById(R.id.websiteBtnRp);

        btnRp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);

            }
        });
    }
}
