package com.example.sqlite;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ac3 extends AppCompatActivity {

    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac3);

        dataHelper helper = new dataHelper(ac3.this);

        text2 = findViewById(R.id.text_from_SP_2);
        text2.setText(helper.getUserName());
    }
}
