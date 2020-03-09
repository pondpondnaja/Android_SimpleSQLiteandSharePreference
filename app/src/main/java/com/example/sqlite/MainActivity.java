package com.example.sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button insert, select, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.insert_btn);
        select = findViewById(R.id.select_btn);
        next = findViewById(R.id.go_next);

        final myDB myDb = new myDB(MainActivity.this);
        myDb.getWritableDatabase(); // First method

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Statement 1
                long flg1 = myDb.InsertData("1", "Weerachai", "0819876107");
                if (flg1 > 0) {
                    Toast.makeText(MainActivity.this, "Insert(1) Data Successfully",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert(1) Data Failed.",
                            Toast.LENGTH_LONG).show();
                }

                // Statement 2
                long flg2 = myDb.InsertData("2", "Win", "021978032");
                if (flg2 > 0) {
                    Toast.makeText(MainActivity.this, "Insert(2) Data Successfully",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert(2) Data Failed.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arrData = myDb.SelectData("1");
                if (arrData == null) {
                    Toast.makeText(MainActivity.this, "Not found Data!", Toast.LENGTH_LONG).show();
                } else {
                    // arrData[0] MemberID
                    // arrData[0] Name
                    // arrData[0] Tel
                    Toast.makeText(MainActivity.this, "MemberID = " + arrData[0]
                                    + "," + arrData[1] + "," + arrData[2],
                            Toast.LENGTH_LONG).show();

                    dataHelper helper = new dataHelper(MainActivity.this);
                    helper.createSession(arrData[1], arrData[2]);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ac2.class));
            }
        });
    }

}
