package com.example.applicationdepositiononthetelescope;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @SuppressWarnings("FieldCanBeLocal")
    int telescsopePrice = 14000; 
    int scholarship = 2500;  
    float accountBalance = 1000;  

    float p = 5;  
    int months = 0;


    public int countOfMonths() {
        for (int i = 0; i < 50; i++) {
            months++;
            accountBalance += scholarship;
            if (months % 12 == 0) {
                accountBalance *= (p + 100) / 100;
            }
            if (telescsopePrice - accountBalance <= 0) {
                break;
            }
        }
        return months;
    }

    private TextView textNumberOfMonths; 
    private TextView priceOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        priceOut = findViewById(R.id.priceOut);
        textNumberOfMonths = findViewById(R.id.textNumberOfMonths); 

        priceOut.setText("Стоимость покупки данного телескопа составит " + telescsopePrice + " кредитов");
        textNumberOfMonths.setText("Для покупки данного телескопа потребуется копить на протяжении " + countOfMonths() + " месяцев");
    }
}
