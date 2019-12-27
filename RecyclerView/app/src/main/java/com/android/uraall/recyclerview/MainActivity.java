package com.android.uraall.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<RecyclerViewItem> recyclerViewItems = new ArrayList<>();

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_1,
                Utils.PIZZA_1_NAME, Utils.PIZZA_1_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_2,
                Utils.PIZZA_2_NAME, Utils.PIZZA_2_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_3,
                Utils.PIZZA_3_NAME, Utils.PIZZA_3_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_4,
                Utils.PIZZA_4_NAME, Utils.PIZZA_4_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_5,
                Utils.PIZZA_5_NAME, Utils.PIZZA_5_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_6,
                Utils.PIZZA_6_NAME, Utils.PIZZA_6_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_7,
                Utils.PIZZA_7_NAME, Utils.PIZZA_7_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_8,
                Utils.PIZZA_8_NAME, Utils.PIZZA_8_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_9,
                Utils.PIZZA_9_NAME, Utils.PIZZA_9_DESCRIPTION));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.pizza_10,
                Utils.PIZZA_10_NAME, Utils.PIZZA_10_DESCRIPTION));


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(recyclerViewItems);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


    }
}
