package com.egaranhani.batalhanaval.exceptions;

/**
 * Created by egaranhani on 25/05/2015.
 */
public class OutOfBoundsException extends RuntimeException {

    int line;
    int column;

    public OutOfBoundsException(int line, int column){
        this.line = line;
        this.column = column;
    }

    @Override
    public String getMessage() {
        return "Position on board [10][10] is out of bounds: [" + line + "][" + column + "]";
    }
}
