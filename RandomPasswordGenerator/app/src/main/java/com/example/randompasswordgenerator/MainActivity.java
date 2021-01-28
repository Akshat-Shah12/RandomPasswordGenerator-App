package com.example.randompasswordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView counter;
    public TextView textToChange;
    public SeekBar seek_Bar;
    public int length=10;
    public Switch sw1;
    public Switch sw2;
    public Switch sw3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw1 = (Switch)findViewById(R.id.switch1);
        sw2 = (Switch)findViewById(R.id.switch2);
        sw3 = (Switch)findViewById(R.id.switch3);
        counter = (TextView)findViewById(R.id.textView2);
        textToChange = (TextView)findViewById(R.id.myText);
        seek_Bar =  findViewById(R.id.seekBar);
        seek_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int x = progress+5;
                length=x;
                counter.setText("Length = "+x);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void NewPassword(View view){
        int num=length;
        String passw = createPassword(num);
        textToChange.setText(passw);

    }
    public String createPassword(int num){

        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars=lowerCaseLetters;
        if(sw1.isChecked())
            Log.i("check",String.valueOf(sw1.isChecked()));
            combinedChars += capitalCaseLetters ;
            Log.i("check",combinedChars);
        if(sw2.isChecked())
            Log.i("check",String.valueOf(sw1.isChecked()));
            combinedChars += numbers ;
            Log.i("check",combinedChars);
        if(sw3.isChecked())
            Log.i("check",String.valueOf(sw1.isChecked()));
            combinedChars += specialCharacters ;
            Log.i("check",combinedChars);
        Random random = new Random();
        char[] password = new char[num];
//        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        for(int i = 0; i< num ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
            Log.i("check", String.valueOf(password[i]));
        }
        String passw ="";
        for(int j=0;j<num;j++){
            passw+=password[j];
        }
        Log.i("check",passw);
        return passw;

    }
}