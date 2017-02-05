package com.example.alex.sudoku;

import android.app.AlertDialog;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Alex on 03/02/2017.
 */

public class Case {

    Rect rectangle;
    CaseNumber i ;
    Pair<Integer, Integer> position;

    Case(CaseNumber cs, Pair<Integer, Integer> position, int top, int left, int bottom, int right){
        this.rectangle = new Rect(top, left, bottom, right);
        this.i = cs;
        this.position = position;
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

    public boolean isOnGroup(Case c){
        if(this.position.first == c.position.first || this.position.second == c.position.second){
            return true;
        }
        if(this.position.first / 3 == c.position.first / 3 && this.position.second / 3 == c.position.second / 3){
             return true;
        }
        return false;
    }

}
