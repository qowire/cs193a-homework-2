package com.example.thenoodler.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> taskList;
    ArrayAdapter<String> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskList = new ArrayList<>();
        taskAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskList);
        ListView list = (ListView) findViewById(R.id.taskList);
        list.setAdapter(taskAdapter);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> list, View row, int index, long rowID) {
                        taskList.remove(index);
                        taskAdapter.notifyDataSetChanged();
                    }
                });
    }

    public void onResume(){
        super.onResume();
        taskAdapter.notifyDataSetChanged();
    }

    public void onStart() {
        super.onStart();
        taskAdapter.notifyDataSetChanged();
    }

    public void buttonClicked(View view) {
        EditText itemText = (EditText) findViewById(R.id.itemText);
        taskList.add(itemText.getText().toString());
        taskAdapter.notifyDataSetChanged();
        itemText.setText("");
    }
}
