package ru.evgeny.cool_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView viewById = findViewById(R.id.counter);

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {

            int counter = 0;
            @Override
            public void run() {

                viewById.setText(counter + "");
                handler.postDelayed(this, 1000);
                counter++;

            }
        };

        handler.post(runnable);
    }
}
