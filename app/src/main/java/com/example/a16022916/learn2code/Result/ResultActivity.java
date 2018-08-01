package com.example.a16022916.learn2code.Result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a16022916.learn2code.R;

public class ResultActivity extends AppCompatActivity {

    // These request identify who started the second activity
    int requestCodeForButton = 1;
    Button btnRate;
    ImageView iv1Star, iv2Star, iv3Star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRate = findViewById(R.id.resultBtnRate);
        iv1Star = findViewById(R.id.resultIv1star);
        iv2Star = findViewById(R.id.resultIv2star);
        iv3Star = findViewById(R.id.resultIv3star);

        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this,ResultSecondActivity.class);
                startActivityForResult(intent, requestCodeForButton);
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
                    int intRating = data.getIntExtra("rating",9);

                    if (intRating != 9){
                        iv1Star.setImageResource(R.drawable.nostar);
                        iv2Star.setImageResource(R.drawable.nostar);
                        iv3Star.setImageResource(R.drawable.nostar);

                        if (intRating >= 1) {
                            iv1Star.setImageResource(R.drawable.star);
                        }
                        if (intRating >= 2) {
                            iv2Star.setImageResource(R.drawable.star);
                        }
                        if (intRating >= 3) {
                            iv3Star.setImageResource(R.drawable.star);
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Data returned is null", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
