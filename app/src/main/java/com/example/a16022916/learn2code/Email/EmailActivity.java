package com.example.a16022916.learn2code.Email;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a16022916.learn2code.R;

public class EmailActivity extends AppCompatActivity {

    EditText etMsg;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        etMsg = findViewById(R.id.emailEtMsg);
        btnSend = findViewById(R.id.emailBtnSend);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ysjustinlim@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "My remarks");
                String strMsg = etMsg.getText().toString();
                email.putExtra(Intent.EXTRA_TEXT, strMsg);

                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}
