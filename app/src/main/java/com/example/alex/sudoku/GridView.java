package com.example.alex.sudoku;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Alex on 03/02/2017.
 */

public class GridView extends View implements View.OnTouchListener {

    SelectableNumber selectedNumber = null;

    Case[][] arrCase = new Case[9][9];
    SelectableNumber[] arrNumber = new SelectableNumber[9];

    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);

       vGrille act = ((GameActivity) context).getGrid();
        Log.d("activity", act.grid);
        for(int column = 0; column < 9; column++){
            for (int row = 0 ; row < 9; row++){
                // load grid here
                int num = 0;
                if(column % 2 == 1){
                    num = 10;
                }

                Case c = new Case(new CaseNumber(num), 100 * column, 100 * row, (100 * column + 100), (100 * row + 100));
                arrCase[row][column] = c;
            }
        }

        for(int place = 0; place < 9; place++){
            arrNumber[place] = new SelectableNumber(place + 1, 1000, 100 * place + 20, 1100, 100 * place + 100);
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setOnTouchListener(this);

        for(Case[] carr : arrCase){
            for(Case c : carr){
                c.draw(canvas);
            }
        }

        Paint paint = new Paint();
        paint.setStrokeWidth(3);
        for (int row = 0 ; row < 9; row++) {
            if(row % 3 == 0){
                canvas.drawLine(0, row * 100, 900, row * 100, paint);
            }
        }
        for (int column = 0 ; column < 9; column++) {
            if(column % 3 == 0){
                canvas.drawLine(column * 100, 0, column * 100, 900, paint);
            }
        }


        for(SelectableNumber se : arrNumber){
            se.draw(canvas);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int x = (int) event.getX();
        int y =(int) event.getY();
        Case selectedcase = null;


        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                for(SelectableNumber c : arrNumber){
                    if(c.isSelected(x, y)){
                        selectedNumber = c;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                for(Case[] carr : arrCase){
                    for(Case c : carr){
                        if(selectedNumber != null && c.isSelected(x, y)){
                            selectedcase = c;
                        }
                    }
                }
                if(selectedcase != null){
                    selectedcase.i.setNumber(selectedNumber.i);
                }
                selectedNumber = null;
                break;
        }

        this.invalidate();
        return true;
    }


}
