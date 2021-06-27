package com.example.smartskills;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Newchecklist extends AppCompatActivity {

    ListView listView;
    List<String> toDo;
    ArrayAdapter<String> arrayAdapter;

    EditText editText;

    ArrayList<String> listItems=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newchecklist);

        toDo = new ArrayList<>();
        listView = (ListView)findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, toDo);

        listView.setAdapter(arrayAdapter);

        editText = findViewById(R.id.id_edit_text);
    }

    public void addItemToList(View view){
        toDo.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();

        editText.setText("");
    }
}