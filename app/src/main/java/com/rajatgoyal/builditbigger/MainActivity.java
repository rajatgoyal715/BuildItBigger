package com.rajatgoyal.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import builditbigger.JokeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.container, new JokeFragment()).commit();
    }
}
