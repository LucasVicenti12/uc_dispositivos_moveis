package com.ifsc.paint;

import android.graphics.Rect;
import android.graphics.RectF;

public class Square {
    public float startX, startY, endX, endY;

    public void setStart(float startX, float startY) {
        this.startX = startX;
        this.startY = startY;
    }

    public void setEnd(float endX, float endY) {
        this.endX = endX;
        this.endY = endY;
    }

    public Rect getSquareRect() {
        return new Rect(
                (int) this.startX,
                (int) this.startY,
                (int) this.endX,
                (int) this.endY
        );
    }
}
