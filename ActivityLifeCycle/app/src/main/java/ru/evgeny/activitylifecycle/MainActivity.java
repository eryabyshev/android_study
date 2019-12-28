package ru.evgeny.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Log.d("LC", "onCreate");

        if(savedInstanceState != null) {
            textView.append(savedInstanceState.getString("textBundle"));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LC", "onStart");
        textView.append("onStart\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LC", "onResume");
        textView.append("onResume\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LC", "onPause");
        textView.append("onPause\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LC", "onStop");
        textView.append("onStop\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LC", "onDestroy");
        textView.append("onDestroy\n");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);
        Log.d("LC", "onSaveInstanceState");
        textView.append("onSaveInstanceState\n");
        outState.putString("textBundle", textView.getText().toString());

    }
}
