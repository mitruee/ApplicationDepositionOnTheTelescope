package com.example.applicationdepositiononthetelescope;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    @SuppressWarnings("FieldCanBeLocal")
    int telescsopePrice = 14000; //стоимость телескопа
    int scholarship = 2500;   //стипендия (ежемесячная)
    float accountBalance = 1000;  // кол-во денег на счету

    float p = 5;  //годовые (в процентах)
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

    // создание дополнительных  полей для вывода на экран полученных значений
    private TextView textNumberOfMonths; // поле отображение числа месяцев
    private TextView priceOut; // поле отображения цены

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        priceOut = findViewById(R.id.priceOut);
        textNumberOfMonths = findViewById(R.id.textNumberOfMonths); // вывод информации по количеству месяцев

        // заполнение экрана
        // вывод стоимость покупки
        priceOut.setText("Стоимость покупки данного телескопа составит " + telescsopePrice + " кредитов");
        // вывод количества месяцев
        textNumberOfMonths.setText("Для покупки данного телескопа потребуется копить на протяжении " + countOfMonths() + " месяцев");
    }
}