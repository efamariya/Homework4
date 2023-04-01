package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    TextView outText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input);
        outText = findViewById(R.id.out);
        button = findViewById(R.id.button);

        // вместо сканера
        button.setOnClickListener(event -> {
            int num = Integer.parseInt(inputText.getText().toString());


            while (!isLuckyTicket(num)) {
                outText.setText("Билет " + num + " не счастливый");
                num--;
            }
            outText.setText("Счастливый билет " + num);


        });
    }

    private boolean isLuckyTicket(int num) {
        int[] mass = new int[6];
        for (int i = 5; i >= 0; i--) { // i-- это i = i-1
            mass[i] = num % 10;
            num = num / 10;
        }
        return mass[1] + mass[3] + mass[5] == mass[0] + mass[2] + mass[4];
    }
}

