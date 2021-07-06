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
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Listas extends AppCompatActivity {

    private TextView textView;

    private static String ip = "mysql742.umbler.com";
    private static String port = "41890";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "smartskills";
    private static String username = "smartskillsfct";
    private static String password = "smartskills";
    private static String url = "mysql742.umbler.com:41890"+"/"+database;

    private Connection connection = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);

        textView = findViewById(R.id.textView17);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username, password);
            textView.setText("success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            textView.setText("Error");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            textView.setText("failure");
        }
    }

    public void sqlbutton(View view){

        if (connection!=null){
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from items");
                while(resultSet.next()){
                    textView.setText(resultSet.getString(1));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        else{
            textView.setText("connection is null");
        }

    }
}