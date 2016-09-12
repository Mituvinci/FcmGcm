package com.fcmgcm.hi.fcmgcm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button subscribeButton = (Button) findViewById(R.id.subscribeButton);
        Button logTokenButton = (Button) findViewById(R.id.logTokenButton);
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
            }
        }
        assert subscribeButton != null;
        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // [START subscribe_topics]
                /*FirebaseMessaging.getInstance().subscribeToTopic("news");
                Log.d(TAG, "Subscribed to news topic");
                // [END subscribe_topics]*/

                FirebaseMessaging.getInstance().subscribeToTopic("news");
                // [END subscribe_topics]

            }
        });


        assert logTokenButton != null;
        logTokenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "InstanceID token: " + FirebaseInstanceId.getInstance().getToken());

                // Get token
                String token = FirebaseInstanceId.getInstance().getToken();

                // Log and toast
                /*String msg = getString(R.string.msg_token_fmt, token);
                Log.d(TAG, msg);*/
                Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();


            }
        });
    }
}
