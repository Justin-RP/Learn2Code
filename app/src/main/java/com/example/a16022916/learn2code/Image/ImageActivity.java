package com.example.a16022916.learn2code.Image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.a16022916.learn2code.R;

public class ImageActivity extends AppCompatActivity {

    private ImageView ivStar;
    private ImageView ivPic;
    private Boolean isStarred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ivPic = findViewById(R.id.imageIVPic);
        ivStar = findViewById(R.id.imageIVStar);
        isStarred = true;

        ivPic.setImageResource(R.drawable.day5);

        if (isStarred == true) {
            ivStar.setImageResource(R.drawable.star);
        } else {
            ivStar.setImageResource(R.drawable.nostar);
        }


    }
}
