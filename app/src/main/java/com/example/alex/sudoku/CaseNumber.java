package com.example.alex.sudoku;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Alex on 03/02/2017.
 */

public class CaseNumber {

    Integer content;
    boolean editable;

    public CaseNumber(int content){
        this.content = content;
        if(content == 0){
            this.editable = true;
        } else {
            this.editable = false;
        }


    }

    public void draw(Rect rectangle, Canvas canvas) {
        if (!(content == 0)) {
            Paint paint = new Paint();
            paint.setTextSize(30);
            if(!editable){
                paint.setFakeBoldText(true);
            }
            canvas.drawText(content.toString(), rectangle.left + 40, rectangle.top + 60, paint);
        }
    }

    public void setNumber(int content){
        if(editable){
            this.content = content;
        }
    }
}
