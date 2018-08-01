package com.example.a16022916.learn2code.Result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.a16022916.learn2code.R;

public class ResultSecondActivity extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rgRating;
    RadioButton rbSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_second);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnSubmit = findViewById(R.id.resultBtnSubmit);
        rgRating = findViewById(R.id.resultRgRating);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                RadioButton rbLol;
                // SelectedButtonId gives many unknown numbers
                int selectedButtonId = rgRating.getCheckedRadioButtonId();
                rbSelected = findViewById(selectedButtonId);
                int intRbTag = Integer.valueOf(rbSelected.getTag().toString());
                i.putExtra("rating",intRbTag);
                setResult(RESULT_OK,i);

                finish();
            }
        });



    }
}
