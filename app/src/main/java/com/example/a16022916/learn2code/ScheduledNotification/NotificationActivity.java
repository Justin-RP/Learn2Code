package com.example.a16022916.learn2code.ScheduledNotification;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a16022916.learn2code.R;

import java.util.Calendar;

public class NotificationActivity extends AppCompatActivity {

    private int reqCode = 123456;
    private EditText etName, etDesc;
    private Button btnStartDefault, btnStartHigh, btnStartBig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        etName = findViewById(R.id.notiEtName);
        etDesc = findViewById(R.id.notiEtDesc);
        btnStartDefault = findViewById(R.id.notiBtnStartDefault);
        btnStartHigh = findViewById(R.id.notiBtnStartHigh);
        btnStartBig = findViewById(R.id.notiBtnStartBigText);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnStartDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = etName.getText().toString();
                String strDesc = etDesc.getText().toString();

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,5);

                Intent intent = new Intent(getApplicationContext(),ScheduledNotification.class);
                intent.putExtra("name", strName);
                intent.putExtra("desc", strDesc);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), reqCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent);
            }
        });

        btnStartHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = etName.getText().toString();
                String strDesc = etDesc.getText().toString();

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,5);

                Intent intent = new Intent(getApplicationContext(),ScheduledNotificationHigh.class);
                intent.putExtra("name", strName);
                intent.putExtra("desc", strDesc);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), reqCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent);

            }
        });

        btnStartBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = etName.getText().toString();
                String strDesc = etDesc.getText().toString();

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,5);

                Intent intent = new Intent(getApplicationContext(),ScheduledNotificationBig.class);
                intent.putExtra("name", strName);
                intent.putExtra("desc", strDesc);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), reqCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent);
            }
        });

    }
}
