package ru.evgeny.musicshoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("Order Info");
        Intent intent = getIntent();
        Order order = (Order)intent.getSerializableExtra("CART");

        if(order == null) {
            finish();
        }


        ((TextView)findViewById(R.id.order_name_view)).setText(order.userName);
        ((TextView)findViewById(R.id.order_item_view)).setText(order.itemName);
        ((TextView)findViewById(R.id.order_item_price_view)).setText(order.price + "");
        ((TextView)findViewById(R.id.order_item_count_view)).setText(order.count + "");
        ((TextView)findViewById(R.id.order_item_total_price_view)).setText(order.priceTotal + "");

    }
}
