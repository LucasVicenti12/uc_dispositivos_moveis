package com.ifsc.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.DynamicLayout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimplePaint extends View {
    final Paint paint;
    final Square square;
    final Path path;
    final Circle circle;
    Shapes drawShape;

    public SimplePaint(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint();
        this.square = new Square();
        this.circle = new Circle();
        this.path = new Path();
        this.drawShape = Shapes.Path;

        initPaint();
    }

    private void initPaint() {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(6f);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        switch (this.drawShape) {
            case Square:
                canvas.drawRect(square.getSquareRect(), paint);
                break;
            case Path:
                canvas.drawPath(path, paint);
                break;
            case Circle:
                canvas.drawCircle(
                        circle.cX,
                        circle.cY,
                        circle.radius,
                        paint
                );
                break;
        }
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final float x = event.getX();
        final float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                switch (this.drawShape) {
                    case Square:
                        this.square.setStart(x, y);
                        this.square.setEnd(x, y);
                        break;
                    case Path:
                        this.path.moveTo(x, y);
                        break;
                    case Circle:
                        this.circle.setStart(x, y);
                        break;
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                switch (this.drawShape) {
                    case Square:
                        this.square.setEnd(x, y);
                        break;
                    case Path:
                        this.path.lineTo(x, y);
                        break;
                    case Circle:
                        this.circle.setRadius(x, y);
                        break;
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                if (this.drawShape.equals(Shapes.Path)) {
                    path.lineTo(x, y);
                }
                invalidate();
                return true;
        }
        return false;
    }

    public void setDrawType(Shapes drawShape) {
        this.drawShape = drawShape;
    }
}
