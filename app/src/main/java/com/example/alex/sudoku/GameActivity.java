package com.example.alex.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GameActivity extends AppCompatActivity {

    vGrille grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle objetbunble = this.getIntent().getExtras(); // récupération de la valeur
        grid = (vGrille) objetbunble.getSerializable("grid");

        setContentView(R.layout.activity_game);
    }

    public vGrille getGrid(){
        return grid;
    }
}
