package com.example.a16022916.learn2code.LoginApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a16022916.learn2code.DatabaseHelper;
import com.example.a16022916.learn2code.R;

public class RegisterActivity extends AppCompatActivity {

    private DatabaseHelper db = new DatabaseHelper(this);
    private EditText etUserName, etPassword, etPhoneNumber;
    private Button btnSubmit;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUserName = findViewById(R.id.registerEtUserName);
        etPassword = findViewById(R.id.registerEtPassword);
        etPhoneNumber = findViewById(R.id.registerEtPhoneNumber);
        btnSubmit = findViewById(R.id.registerBtnSubmit);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strUser = etUserName.getText().toString();
                String strPassword = etPassword.getText().toString();
                String strPhoneNumber = etPhoneNumber.getText().toString();
                int intPhoneNumber = Integer.valueOf(strPhoneNumber);

                if(!db.checkUser(strUser)) {
                    currentUser = new User(strUser,strPassword,intPhoneNumber);
                    db.insertUser(currentUser);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "User Name already Exists!", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
