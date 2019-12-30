package ru.evgeny.cooktimerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static androidx.preference.PreferenceManager.getDefaultSharedPreferences;

public class MainActivity extends AppCompatActivity {


    private SeekBar seekBar;
    private TextView textView;
    private Button button;
    boolean isTimerStart;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
        resetTimer();
    }

    private void updateTimeView(long progress) {
        long min = progress / 60;
        long sec = progress - (min * 60);
        textView.setText(String.format("%02d:%02d", min, sec));
    }

    private void initActivity() {
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateTimeView(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setText("Start");
        isTimerStart = false;

    }

    private CountDownTimer getTimer(long total, long interval) {
        return new CountDownTimer(total, interval) {

            @Override
            public void onTick(long l) {
                updateTimeView(l / 1000);
            }

            @Override
            public void onFinish() {
                SharedPreferences pref = getDefaultSharedPreferences(getApplicationContext());

                if(pref.getBoolean("enable_sound", true)) {

                    String bell = pref.getString("bell", "bell");

                    switch (bell) {
                        case "bell_sound" :
                            MediaPlayer.create(getApplicationContext(), R.raw.bell_sound).start();
                            break;
                        case "bip_sound" :
                            MediaPlayer.create(getApplicationContext(), R.raw.bip_sound).start();
                            break;
                        case "alarm_siren_sound":
                            MediaPlayer.create(getApplicationContext(), R.raw.alarm_siren_sound).start();
                            break;
                    }
                }

                isTimerStart = false;
                resetTimer();
                seekBar.setEnabled(true);
                button.setText("Start");
            }
        };
    }

    public void startTimer(View view) {

        if(isTimerStart) {
            seekBar.setEnabled(true);
            button.setText("Start");
            countDownTimer.cancel();
            isTimerStart = false;
            resetTimer();
        } else {
            seekBar.setEnabled(false);
            button.setText("Stop");
            countDownTimer = getTimer(seekBar.getProgress() * 1000, 1000);
            countDownTimer.start();
            isTimerStart = true;

        }
    }

    private void resetTimer() {
        seekBar.setMax(600);
        seekBar.setProgress(30);
        textView.setText(String.format("%02d:%02d", 0, 30));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.timer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about: {
                Intent openAbout = new Intent(this, AboutActivity.class);
            }
            case R.id.action_settings: {
                Intent openSettings = new Intent(this, SettingsActivity.class);
                startActivity(openSettings);
                return true;
            }

        }




        return super.onOptionsItemSelected(item);
    }
}
