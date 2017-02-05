package com.example.alex.sudoku;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Alex on 03/02/2017.
 */

public class SelectableNumber {
    Rect rectangle;
    Integer i;

    SelectableNumber(int i, int top, int left, int bottom, int right){
        this.i = i;
        this.rectangle = new Rect(top, left, bottom, right);
    }

    public void draw(Canvas canvas){
        Paint paintrect = new Paint();
        paintrect.setStyle(Paint.Style.FILL);
        paintrect.setColor(Color.GREEN);
        canvas.drawRect(rectangle, paintrect);

        Paint paint = new Paint();
        paint.setTextSize(30);
        canvas.drawText(i.toString(), this.rectangle.left + 40, this.rectangle.top + 60, paint);

    }
    public boolean isSelected(int x, int y){
        return x > rectangle.left && x < rectangle.right && y > rectangle.top && y < rectangle.bottom;
    }


}
