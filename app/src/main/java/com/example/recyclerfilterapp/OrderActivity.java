package com.example.recyclerfilterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    private TextView order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        order = findViewById(R.id.order);
        order.setText(getIntent().getStringExtra("order"));
    }
}
