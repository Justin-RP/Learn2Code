package com.example.a16022916.learn2code;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a16022916.learn2code.Result.ResultActivity;
import com.example.a16022916.learn2code.Result.ResultSecondActivity;

public class MessageMainActivity extends AppCompatActivity {

    // TODO Add uses-permissions READ_SMS in manifest
    TextView tvResult;
    Button btnSearchByMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_main);

        tvResult = findViewById(R.id.messageMainTvResult);
        btnSearchByMsg = findViewById(R.id.messageMainBtnSearchByMsg);

    }
    @Override
    protected void onStart() {
        super.onStart();

        loadSMS();
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnSearchByMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageMainActivity.this,MessageActivityMsg.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the read SMS
                    //  as if the btnRetrieve is clicked
                    Toast.makeText(MessageMainActivity.this, "Permission is grant-ed",
                            Toast.LENGTH_SHORT).show();
                    loadSMS();

                    // btnSend.performClick(); to perform a button

                } else {
                    // permission denied... notify user
                    Toast.makeText(MessageMainActivity.this, "Permission not grant-ed, Grant permission first!",
                            Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    public void loadSMS() {

        // TODO If it is in fragment MessageActivity.this changes to getActivity()
        int permissionCheck = PermissionChecker.checkSelfPermission(MessageMainActivity.this, Manifest.permission.READ_SMS);

        if (permissionCheck != PermissionChecker.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MessageMainActivity.this, new String[]{Manifest.permission.READ_SMS}, 0);
            return;
        }

        Uri uri = Uri.parse("content://sms");

        String[] reqCols = new String[]{"date", "address", "body", "type"};

        ContentResolver cr = MessageMainActivity.this.getContentResolver();

        Cursor cursor = cr.query(uri,reqCols,null,null,null);
        String smsBody = "";
        if (cursor.moveToFirst()) {
            do {
                long dateInMillis = cursor.getLong(0);
                String date = (String) DateFormat
                        .format("dd MMM yyyy h:mm:ss aa", dateInMillis);
                String address = cursor.getString(1);
                String body = cursor.getString(2);
                String type = cursor.getString(3);
                if (type.equalsIgnoreCase("1")) {
                    type = "Inbox:";
                } else {
                    type = "Sent:";
                }
                smsBody += type + " " + address + "\n at " + date
                        + "\n\"" + body + "\"\n\n";
            } while (cursor.moveToNext());
        }
        tvResult.setText(smsBody);

    }
}
