package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            String data = bundle.getString("data");
            textView.setText(data);
        }
    }

    public void onClick(View view){
        finish();
    }

    @Override
    public void finish() {
        String result = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("result",result);
        setResult(RESULT_OK,intent);
        super.finish();
    }
}
