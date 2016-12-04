// Test for gitHub
package com.example.chris.messengerapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Messenger extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;
    String starSign = "None";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        listView  = (ListView) findViewById(R.id.lvStarSigns);

        // Create an adapter between the list we have in this file (that we add items too) and the listView control on the interface
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        listView.setAdapter(adapter);

        // Add the star signs
        listItems.add("Aries");
        listItems.add("Taurus");
        listItems.add("Gemini");
        listItems.add("Cancer");
        listItems.add("Leo");
        listItems.add("Virgo");
        listItems.add("Libra");
        listItems.add("Scorpio");
        listItems.add("Sagittarius");
        listItems.add("Capricorn");
        listItems.add("Aquarius");
        listItems.add("Pisces");

        // Update the listView control with the added star signs using the adapter
        adapter.notifyDataSetChanged();

        // Update the behavior of the item click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Get the selected text and give it to starSign
                starSign = listView.getItemAtPosition(position).toString();
                SendSign();
            }
        });
    }

    // Send the star sign to the activity
    public void SendSign()
    {
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, starSign);
        startActivity(intent);
    }
}
