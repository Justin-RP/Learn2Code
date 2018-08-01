package com.example.a16022916.learn2code.Serializing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.a16022916.learn2code.R;

public class ObjectSerializableSecondActivity extends AppCompatActivity {

    Button btnSubmit;
    RadioGroup rgRating;
    RadioButton rbSelected;
    ObjectMovie modObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_serializable_second);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnSubmit = findViewById(R.id.objectBtnSubmit);
        rgRating = findViewById(R.id.objectRgRating);

        Intent i = getIntent();

        modObject = (ObjectMovie) i.getSerializableExtra("movieObject");
        int intRating = modObject.getRating();
        Toast.makeText(this, String.valueOf(intRating) + " Selected", Toast.LENGTH_SHORT).show();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                // SelectedButtonId gives many unknown numbers
                int selectedButtonId = rgRating.getCheckedRadioButtonId();
                rbSelected = findViewById(selectedButtonId);
                int intRbTag = Integer.valueOf(rbSelected.getTag().toString());
                modObject.setRating(intRbTag);
                i.putExtra("retMovieObject",modObject);
                setResult(RESULT_OK,i);
                finish();
            }
        });

    }

}
