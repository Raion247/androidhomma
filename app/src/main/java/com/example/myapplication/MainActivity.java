package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText textInput;
    private TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textInput = findViewById(R.id.EuroInput);
        textOutput = findViewById(R.id.ResultText);
    }

    public void transformCurrencyUSD(View view) {
        int eur = Integer.parseInt(textInput.getText().toString());
        String number = String.format("$%.2f", eur * 1.05);
        textOutput.setText(number);
    }

    public void transformCurrencyGDP(View view) {
        int eur = Integer.parseInt(textInput.getText().toString());
        String number = String.format("£%.2f", eur * 0.83);
        textOutput.setText(number);
    }
}