package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Receiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView2);

        receiver = new Receiver();
        registerReceiver(receiver,new IntentFilter("CUSTOM_ACTION"));
        registerReceiver(receiver,new IntentFilter(
                "android.intent.action.ACTION_POWER_CONNECTED"
        ));
        registerReceiver(receiver,new IntentFilter(
                "android.intent.action.ACTION_POWER_DISCONNECTED"
        ));


//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        if(bundle != null){
//            String data = bundle.getString("data");
//            textView.setText(data);
//        }
    }

    final static int REQUEST_CODE = 1686;

    public void onClick(View view){
        //Explicit
//        Intent intent = new Intent(this,Main2Activity.class);
//
//        String data = editText.getText().toString();
//        intent.putExtra("data",data);
//        startActivityForResult(intent,REQUEST_CODE);

        //Implicit
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
//        startActivity(intent);

        //BroadCast
        Intent broadcastIntent = new Intent("CUSTOM_ACTION");
        broadcastIntent.putExtra("key","test data");
        sendBroadcast(broadcastIntent);
    }

    public class Receiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action == "CUSTOM_ACTION"){
                String data = intent.getStringExtra("key");
                textView.setText(data);
            }

            if(action == "android.intent.action.ACTION_POWER_CONNECTED"){
                textView.setText("POWER_CONNECTED");
            }
            if(action == "android.intent.action.ACTION_POWER_DISCONNECTED"){
                textView.setText("POWER_DISCONNECTED");
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE){
                String result = data.getStringExtra("result");
                textView.setText(result);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
