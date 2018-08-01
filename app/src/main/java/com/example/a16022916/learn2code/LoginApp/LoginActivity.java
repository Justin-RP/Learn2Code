package com.example.a16022916.learn2code.LoginApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a16022916.learn2code.DatabaseHelper;
import com.example.a16022916.learn2code.R;

public class LoginActivity extends AppCompatActivity {

    private DatabaseHelper db = new DatabaseHelper(this);
    private EditText etUserName, etPassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPassword = findViewById(R.id.loginEtPassword);
        etUserName = findViewById(R.id.loginEtUserName);
        btnLogin = findViewById(R.id.loginBtnLogin);
        btnRegister = findViewById(R.id.loginBtnRegister);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = etUserName.getText().toString();
                if(db.checkUser(strUserName)) {
                    User logUser = db.getUser(strUserName);
                    if (logUser.getPassword().equalsIgnoreCase(etPassword.getText().toString())) {
                        Intent intent = new Intent(getBaseContext(), MainPageActivity.class);
                        intent.putExtra("userName", logUser.getName());
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "User Does not Exist", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
