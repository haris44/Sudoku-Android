package com.example.alex.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.StringBuilderPrinter;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Alex on 03/02/2017.
 */

public class GridView extends View implements View.OnTouchListener {

    SelectableNumber selectedNumber = null;

    Case[][] arrCase = new Case[9][9];
    SelectableNumber[] arrNumber = new SelectableNumber[9];
    Integer totalRemplissageGrid;
    Integer startRemplissageGrid;
    vGrille grid;
    public GridView(Context context, AttributeSet attrs) {
        super(context, attrs);

        grid = ((GameActivity) context).getGrid();
        int i = 0;
        for(int column = 0; column < 9; column++){
            for (int row = 0 ; row < 9; row++){
                Case c = new Case(new CaseNumber(Character.getNumericValue(grid.grid.toCharArray()[i])), new Pair(row, column), 100 * column, 100 * row, (100 * column + 100), (100 * row + 100));
                arrCase[row][column] = c;
                i += 1;
            }
        }
        startRemplissageGrid = getRemplissageGrid();
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
                    ArrayList<Case> arrC = getGroupe(selectedcase);
                    boolean ok = true;
                    for(Case c : arrC){
                        if(c.i.content == selectedNumber.i){
                            Log.d("Case", "case " + c.position.first + " " + c.position.second + " content : " + c.i.content);
                            ok = false;
                        }
                    }
                    if(ok){
                        selectedcase.i.setNumber(selectedNumber.i);
                        totalRemplissageGrid = getRemplissageGrid();
                        grid.done = (totalRemplissageGrid - startRemplissageGrid) / (81 - startRemplissageGrid) * 100;
                        grid.grid = getGrid();
                    }

                }
                selectedNumber = null;
                break;
        }

        this.invalidate();
        return true;
    }

    public int getRemplissageGrid(){
        int r = 0;
        for(Case[] arrC : this.arrCase){
            for(Case currentC : arrC){
                if(currentC.i.content != 0){
                    r+=1;
                }
            }
        }
        return r;
    }

    public String getGrid(){
        StringBuilder r = new StringBuilder();
        for(Case[] arrC : this.arrCase){
            for(Case currentC : arrC){
                if(currentC.i.content != 0){
                    r.append(currentC.i.content);
                }
            }
        }
        return r.toString();
    }

    public ArrayList<Case> getGroupe(Case c){
        ArrayList<Case> rt = new ArrayList<>();
        for(Case[] arrC : this.arrCase){
            for(Case currentC : arrC){
                if(c.isOnGroup(currentC)){
                    rt.add(currentC);
                }
            }
        }
        return rt;
    }

}
