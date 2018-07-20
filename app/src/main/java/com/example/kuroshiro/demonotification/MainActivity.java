package com.example.kuroshiro.demonotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btStart, btCancel, btStart2;
    NotificationCompat.Builder mBuilder;
    NotificationManager mNotifyMgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btStart = findViewById(R.id.btStart);
        btCancel = findViewById(R.id.btCancel);
        btStart2 = findViewById(R.id.btStart2);

        btStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                mBuilder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_attach_money_black_24dp)
                        .setContentTitle("My notification")
                        .setContentText("notification");

                mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Intent resultIntent = new Intent(MainActivity.this, Notification_Activity.class);
                resultIntent.putExtra("content", "Viet Nam 1");

                PendingIntent resultPendingIntent = PendingIntent.getActivity(MainActivity.this, 1, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                // Set content intent;
                mBuilder.setContentIntent(resultPendingIntent);

                mNotifyMgr.notify(1, mBuilder.build());
            }
        });

        btStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBuilder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                        .setContentTitle("My notification 2")
                        .setContentText("notification 2");

                mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Intent resultIntent = new Intent(MainActivity.this, Notification_Activity.class);
                resultIntent.putExtra("content", "Viet Nam 2");

                PendingIntent resultPendingIntent = PendingIntent.getActivity(MainActivity.this, 2, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                // Set content intent;
                mBuilder.setContentIntent(resultPendingIntent);

                mNotifyMgr.notify(1, mBuilder.build());
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNotifyMgr.cancel(1);
            }
        });
    }

}
