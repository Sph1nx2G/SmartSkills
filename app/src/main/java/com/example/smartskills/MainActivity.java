package com.example.smartskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView  cardreuniao , cardlistas, cardnewcheck, cardclientes, cardwebsite, cardaptidao;

    private TextView textView;

    private static String ip = "mysql742.umbler.com";
    private static String port = "1433";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "smartskills";
    private static String username = "smartskillsfct";
    private static String password = "smartskills";
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;

    private Connection connection = null;

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