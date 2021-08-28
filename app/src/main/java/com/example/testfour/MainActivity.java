package com.example.testfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import core.ApiConnector;
import core.Joke;

public class MainActivity extends AppCompatActivity {



    private ApiConnector connector = new ApiConnector();
    public static final String EXTRA_MESSAGE = "com.example.testfour.MESSAGE";
    public static final String CLUE  = "com.example.testfour.CLUE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connector.setURl("https://official-joke-api.appspot.com/random_joke");
        connector.getApiText();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        Joke joke = new Joke(connector.getResult());
        intent.putExtra(EXTRA_MESSAGE, joke.getSetup());
        intent.putExtra(CLUE, joke.getPunchline());
        startActivity(intent);
    }
}