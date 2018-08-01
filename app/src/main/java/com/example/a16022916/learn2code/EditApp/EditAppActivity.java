package com.example.a16022916.learn2code.EditApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a16022916.learn2code.DatabaseHelper;
import com.example.a16022916.learn2code.LoginApp.User;
import com.example.a16022916.learn2code.R;

public class EditAppActivity extends AppCompatActivity {

    private DatabaseHelper db = new DatabaseHelper(this);

    private EditText etPassword, etPhoneNumber;
    private TextView tvName;
    private Button btnSave, btnDelete;
    private User editUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_app);

        etPassword = findViewById(R.id.editEtPassword);
        etPhoneNumber = findViewById(R.id.editEtPhoneNumber);
        tvName = findViewById(R.id.editTvName);
        btnDelete = findViewById(R.id.editBtnDelete);
        btnSave = findViewById(R.id.editBtnSave);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent i = getIntent();
        String strUserName = i.getStringExtra("userName");
        editUser = db.getUser(strUserName);
        tvName.setText(editUser.getName());
        etPassword.setText(editUser.getPassword());
        etPhoneNumber.setText(String.valueOf(editUser.getPhoneNumber()));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String strPassword = etPassword.getText().toString();
                String strPhoneNumber = etPhoneNumber.getText().toString();
                int intPhoneNumber = Integer.valueOf(strPhoneNumber);
                editUser.setPassword(strPassword);
                editUser.setPhoneNumber(intPhoneNumber);
                db.updateUser(editUser);
                intent.putExtra("isUserDeleted",false);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                db.deleteUser(editUser);
                intent.putExtra("isUserDeleted",true);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

}
