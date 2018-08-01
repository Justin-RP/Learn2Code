package com.example.a16022916.learn2code.Serializing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a16022916.learn2code.R;

public class ObjectSerializableActivity extends AppCompatActivity {

    // These request identify who started the second activity
    int requestCodeForObjectButton = 1;
    Button btnRate;
    ImageView iv1Star, iv2Star, iv3Star;
    ObjectMovie myMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_serializable);

        btnRate = findViewById(R.id.objectBtnRate);
        iv1Star = findViewById(R.id.objectIv1star);
        iv2Star = findViewById(R.id.objectIv2star);
        iv3Star = findViewById(R.id.objectIv3star);

        myMovie = new ObjectMovie("Incredible",2);
        refreshMovie();
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ObjectSerializableActivity.this, ObjectSerializableSecondActivity.class);
                intent.putExtra("movieObject",myMovie);
                startActivityForResult(intent, requestCodeForObjectButton);
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
                if(requestCode == requestCodeForObjectButton){
                    // Get data passed back from 2nd activity
                    myMovie = (ObjectMovie) data.getSerializableExtra("retMovieObject");
                    refreshMovie();

                }
            } else {
                Toast.makeText(this, "Data returned is null", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void refreshMovie() {
        iv1Star.setImageResource(R.drawable.nostar);
        iv2Star.setImageResource(R.drawable.nostar);
        iv3Star.setImageResource(R.drawable.nostar);

        if (myMovie.getRating() >= 1) {
            iv1Star.setImageResource(R.drawable.star);
        }
        if (myMovie.getRating() >= 2) {
            iv2Star.setImageResource(R.drawable.star);
        }
        if (myMovie.getRating() >= 3) {
            iv3Star.setImageResource(R.drawable.star);
        }
    }
}
