package com.example.kuroshiro.demonotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Notification_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_);

        TextView txt2 = findViewById(R.id.txtTitle);
        Intent mIntent = getIntent();
        String Str = mIntent.getStringExtra("content");
        txt2.setText(Str);

    }
}
