package com.example.alex.sudoku;

import android.app.AlertDialog;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Alex on 03/02/2017.
 */

public class Case {

    Rect rectangle;
    CaseNumber i ;


    Case(CaseNumber cs, int top, int left, int bottom, int right){
        this.rectangle = new Rect(top, left, bottom, right);
        this.i = cs;
    }

    public void draw(Canvas canvas){
        Paint paintrect = new Paint();
        paintrect.setStyle(Paint.Style.FILL);
        paintrect.setColor(Color.LTGRAY);
        canvas.drawRect(rectangle, paintrect);

        paintrect.setStrokeWidth(1);
        paintrect.setStyle(Paint.Style.STROKE);
        paintrect.setColor(Color.BLACK);
        canvas.drawRect(rectangle, paintrect);

       i.draw(rectangle, canvas);

    }


    public boolean isSelected(int x, int y){
        return x > rectangle.left && x < rectangle.right && y > rectangle.top && y < rectangle.bottom;
    }



}
