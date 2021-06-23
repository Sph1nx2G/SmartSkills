package com.example.smartskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView  cardreuniao , cardlistas, cardnewcheck, cardclientes, cardwebsite, cardaptidao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardreuniao= (CardView) findViewById(R.id.reuniaocard);
        cardlistas= (CardView) findViewById(R.id.listascard);
        cardnewcheck= (CardView) findViewById(R.id.newcheckcard);
        cardclientes= (CardView) findViewById(R.id.clientescard);
        cardwebsite= (CardView) findViewById(R.id.websitecard);
        cardaptidao= (CardView) findViewById(R.id.aptidaocard);


        cardreuniao.setOnClickListener(this);
        cardlistas.setOnClickListener(this);
        cardnewcheck.setOnClickListener(this);
        cardclientes.setOnClickListener(this);
        cardwebsite.setOnClickListener(this);
        cardaptidao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.reuniaocard:
                i = new Intent(this, Reuniao.class);
                startActivity(i);
                break;

            case R.id.listascard:
                i = new Intent(this, Listas.class);
                startActivity(i);
                break;

            case R.id.newcheckcard:
                i = new Intent(this, Newchecklist.class);
                startActivity(i);
                break;

            case R.id.clientescard:
                i = new Intent(this, Clientes.class);
                startActivity(i);
                break;

            case R.id.websitecard:

                break;

            case R.id.aptidaocard:
                i = new Intent(this, Aptidao.class);
                startActivity(i);
                break;
        }
    }
}