/*
 * CS 193A - Homework 2, Andrea Rodriguez
 * This program allows a user to create a to-do list by allowing him toenter items in a list,
 * and remove them when clicked.
 */

package com.example.andrea.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Array and array adapter used to keep track of tasks
    private ArrayList<String> taskArray;
    private ArrayAdapter<String> adapter;

    /*
     * This method is called when the app first loads. Sets up the task array list, its
     * adapter, and a click listener for the list view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskArray = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                taskArray
        );
        ListView viewTasks = (ListView) findViewById(R.id.taskList);
        viewTasks.setAdapter(adapter);
        viewTasks.setOnItemClickListener(this);
    }

    /*
     * This method is called when the add button is clicked. It adds string of text to the
     * task array and updates the list view.
     */
    public void addTask(View view) {
        EditText entered_task = (EditText) findViewById(R.id.enteredTask);
        String taskInput = entered_task.getText().toString();
        taskArray.add(taskInput);
        adapter.notifyDataSetChanged();
    }


    /*
     * This method is called when an item in the list is click. It removes string of text in
     * the item from the task array and updates the list view.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
        taskArray.remove(index);
        adapter.notifyDataSetChanged();
    }
}
