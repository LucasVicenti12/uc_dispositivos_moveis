package com.ifsc.paint;

public class Circle {
    public float cX, cY, radius;

    public void setStart(float cX, float cY) {
        this.cX = cX;
        this.cY = cY;
    }

    public void setRadius(float x, float y){
        this.radius = (float) Math.sqrt(Math.pow(x - cX, 2) + Math.pow(y - cY, 2));
    }
}
