package com.example.alex.sudoku;

import java.io.Serializable;

/**
 * Created by Alex on 02/02/2017.
 */

public class vGrille implements Serializable {

    public Integer lvl;
    public Integer num;
    public Integer done;
    public String grid;

    public vGrille(int lvl, int num, int done, String grid) {
        this.lvl = lvl;
        this.num = num;
        this.done = done;
        this.grid = grid;
    }

    public Integer getLvl() {
        return lvl;
    }

    public Integer getNum() {
        return num;
    }

    public Integer getDone() {
        return done;
    }
}
