package com.example.alex.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button lvl1But = (Button)findViewById(R.id.lvl1);
        Button lvl2But = (Button)findViewById(R.id.lvl2);
        Button lvl3But = (Button)findViewById(R.id.lvl3);
        lvl1But.setOnClickListener(this);
        lvl2But.setOnClickListener(this);
        lvl3But.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intention = new Intent(this, LevelActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("lvl", v.getId());
        intention.putExtras(bundle);
        startActivity(intention);
    }
}
