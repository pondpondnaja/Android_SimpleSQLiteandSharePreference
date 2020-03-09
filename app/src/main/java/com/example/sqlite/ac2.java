package com.example.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ac2 extends AppCompatActivity {

    Button next;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac2);

        dataHelper helper = new dataHelper(ac2.this);

        next = findViewById(R.id.go_to_next);
        text = findViewById(R.id.text_from_SP);

        text.setText(helper.getUserName());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ac2.this, ac3.class));
            }
        });
    }
}
