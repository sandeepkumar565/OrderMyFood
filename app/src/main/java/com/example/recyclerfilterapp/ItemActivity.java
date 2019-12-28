package com.example.recyclerfilterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private int[] images = {
            R.drawable.p1 ,R.drawable.p2 ,R.drawable.p3 ,R.drawable.p4 ,R.drawable.p5 ,R.drawable.p6 ,
            R.drawable.p7 ,R.drawable.p8 ,R.drawable.p9 ,R.drawable.p10 ,R.drawable.p11 ,R.drawable.p12 };
    private List<String>list;

    private ImageView imageView;
    private TextView itemName;
    private TextView textView1;
    private TextView textView2;

    private EditText order;
    private Button btn;
    private Button btn1;
    private Button btn2;

    private int position;
    private String msg_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        imageView = findViewById(R.id.big_image);
        itemName = findViewById(R.id.item_name);
        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);

        order = findViewById(R.id.no_item);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        position = getIntent().getIntExtra("id",0);
        list = Arrays.asList(getResources().getStringArray(R.array.food));

        imageView.setImageResource(images[position]);
        itemName.setText(getIntent().getStringExtra("itemName"));
        textView1.setText("Want to order "+itemName.getText().toString()+"?");
    }

    public void mainActivity(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void showOrders(View view) {
        msg_order = "Order Details :\n";
        msg_order += "(No. of orders/Price per item)\n\n";
        int amount =0;
        for(int i=0;i<12;i++)
        {
            if(MainActivity.orders[i] != 0) {
                msg_order += list.get(i)+" : "+MainActivity.orders[i]+"/"+(140-(10*i))+"\n";
                amount += MainActivity.orders[i] * (140-(10*i));
            }
        }
        msg_order += "***\n";
        msg_order+="total payable amount : "+amount+"\n***";

        Intent intent = new Intent(this,OrderActivity.class);
        intent.putExtra("order",msg_order);
        startActivity(intent);

    }

    public void orderItem(View view) {
        if(!order.getText().toString().isEmpty()){
            int n = Integer.parseInt(order.getText().toString());

            MainActivity.orders[position] += n;
            order.setText("");
            Toast.makeText(this,"You have ordered the item !",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Please provide input for the order !",Toast.LENGTH_SHORT).show();
        }
    }
}
