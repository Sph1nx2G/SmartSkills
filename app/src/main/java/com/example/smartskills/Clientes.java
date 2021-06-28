package com.example.smartskills;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Clientes extends AppCompatActivity implements View.OnClickListener {

    public Button btnNovoCliente;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        listView = (ListView)findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("André");
        arrayList.add("António");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                    if (position >= 0){
                        Intent intent = new Intent(view.getContext(), Cliente.class);
                        startActivity(intent);
                    }
            }
         });




        btnNovoCliente = (Button)findViewById(R.id.NovoCliente);

        btnNovoCliente.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.NovoCliente:
                i = new Intent(this, NewCliente.class);
                startActivity(i);
                break;

        }
    }

}