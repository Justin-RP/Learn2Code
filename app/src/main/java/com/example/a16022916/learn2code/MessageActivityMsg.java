package com.example.a16022916.learn2code;

import android.Manifest;
import android.content.ContentResolver;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivityMsg extends AppCompatActivity {

    TextView tvResult;
    Button btnRetrieve;
    EditText etResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_msg);

        tvResult = findViewById(R.id.messageMsgTvResult);
        btnRetrieve = findViewById(R.id.messageMsgBtnRetrieve);
        etResult = findViewById(R.id.messageMsgEtWord);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO If it is in fragment MessageActivity.this changes to getActivity()
                int permissionCheck = PermissionChecker.checkSelfPermission(MessageActivityMsg.this, Manifest.permission.READ_SMS);

                if (permissionCheck != PermissionChecker.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MessageActivityMsg.this, new String[]{Manifest.permission.READ_SMS}, 0);
                    return;
                }

                String strQuery = etResult.getText().toString();

                // TODO Change body to other args to search these
                String filter = "body LIKE ?";
                String[] filterArgs = {"%" + strQuery + "%"};

                // TODO Returns these args on completion
                String[] reqCols = new String[]{"date", "address", "body", "type"};

                Uri uri = Uri.parse("content://sms");

                ContentResolver cr = MessageActivityMsg.this.getContentResolver();

                Cursor cursor = cr.query(uri,reqCols,filter,filterArgs,null);
                String smsBody = "";
                if (cursor.moveToFirst()) {
                    do {
                        long dateInMillis = cursor.getLong(0);
                        String date = (String) DateFormat.format("dd MMM yyyy h:mm:ss aa", dateInMillis);
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
        });
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        switch (requestCode) {
            case 0: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the read SMS
                    //  as if the btnRetrieve is clicked
                    btnRetrieve.performClick();

                } else {
                    // permission denied... notify user
                    Toast.makeText(MessageActivityMsg.this, "Permission not grant-ed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}
