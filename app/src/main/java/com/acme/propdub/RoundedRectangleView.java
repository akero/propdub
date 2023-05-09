package com.acme.propdub;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class RoundedRectangleView extends View {
    private Paint paint;
    private RectF rect;

    public RoundedRectangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.rectangle_background_color));
        rect = new RectF(0, 0, 0, 0); // Set initial size to 0, we will update it in onSizeChanged()
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rect.right = w;
        rect.bottom = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(rect, 25, 25, paint);
    }
}
