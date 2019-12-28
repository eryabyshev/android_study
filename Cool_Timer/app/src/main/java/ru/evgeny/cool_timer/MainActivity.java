package ru.evgeny.cool_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView viewById1 = findViewById(R.id.counter1);
        final TextView viewById2 = findViewById(R.id.counter2);
        Handler handler = new Handler();
        handler.post(simpleTimer(viewById1, handler));

        getCountDownTimer(viewById2).start();
    }

    private Runnable simpleTimer(final TextView text, final Handler handler) {
        Runnable runnable = new Runnable() {
            int counter = 0;
            @Override
            public void run() {
                text.setText(counter + "");
                handler.postDelayed(this, 1000);
                counter++;
            }
        };

        return runnable;
    }

    private CountDownTimer getCountDownTimer(final TextView text) {
        CountDownTimer timer = new CountDownTimer(10000, 1000) {
            int counter = 10;

            @Override
            public void onTick(long l) {
                text.setText(counter + " seconds left");
                counter--;
            }

            @Override
            public void onFinish() {
                text.setText(counter + " seconds left - Finish");
            }
        };

        return timer;

    }
}
