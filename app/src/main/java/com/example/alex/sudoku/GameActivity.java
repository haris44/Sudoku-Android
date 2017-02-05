package com.example.alex.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    vGrille grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle objetbunble = this.getIntent().getExtras(); // récupération de la valeur
        grid = (vGrille) objetbunble.getSerializable("grid");

        setContentView(R.layout.activity_game);
        Timer _t = new Timer();
        final TextView timer = (TextView)this.findViewById(R.id.timer);

        _t.scheduleAtFixedRate( new TimerTask() {
            Integer time = 0;
            @Override
            public void run() {
                runOnUiThread(new Runnable() {//run on ui thread

                public void run()
                {
                    timer.setText(time.toString());
                    time += 1;
                }
              });
            }
        }, 1000 ,1000);
    }

    public vGrille getGrid(){
        return grid;
    }
}
