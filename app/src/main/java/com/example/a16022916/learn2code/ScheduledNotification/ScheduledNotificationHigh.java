package com.example.a16022916.learn2code.ScheduledNotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.a16022916.learn2code.Home.HomeActivity;

public class ScheduledNotificationHigh extends BroadcastReceiver {

    // TODO CREATE RECEIVER IN MANIFEST
    int reqCode = 123456;

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // TODO (HIGH) Set importance as High to show on top
            NotificationChannel channel = new NotificationChannel("default", "Default Channel", NotificationManager.IMPORTANCE_HIGH);

            channel.setDescription("This is for default notificaiton");
            notificationManager.createNotificationChannel(channel);
        }

        // TODO change context class to direct on clicking
        Intent i = new Intent(context,HomeActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context,reqCode,i,PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"default");

        // TODO build notification
        String strName = intent.getStringExtra("name");
        String strDesc = intent.getStringExtra("desc");
        builder.setContentTitle(strName);
        builder.setContentText(strDesc);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);

        // TODO (HIGH) Set Sound and Priority
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);
        builder.setPriority(Notification.PRIORITY_HIGH);

        Notification n = builder.build();
        notificationManager.notify(123, n);
    }
}
