package com.example.testfour;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DisplayMessageActivity extends AppCompatActivity {

    String clue;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        //
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        clue = intent.getStringExtra(MainActivity.CLUE);
        TextView view = findViewById(R.id.textView);
        view.setText(message);
    }

    public void goBack(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TextView view = (TextView) findViewById(R.id.textView);
        view.invalidate();
        ((TextView) view).setText(clue);
        return super.onTouchEvent(event);
    }

}
