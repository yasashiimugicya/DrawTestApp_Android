package com.example.drawtestapp02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
    private float x = 100.0F;
    private float y = 100.0F;

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(); //Paintクラスのオブジェクトを生成する
        paint.setAntiAlias(true); //アンチエイリアスを設定する
        paint.setStrokeWidth(4.0F); //線の太さを設定
        paint.setStyle(Paint.Style.FILL); //図形の内部を塗りつぶす
        paint.setColor(Color.RED); //色を赤に設定

        /***** 円の描画 *****/
        canvas.drawCircle(x, y, 50.0F, paint); //円の描画
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            x = event.getX(); //タッチした位置のx座標を取得する
            y = event.getY(); //タッチした位置のy座標を取得する
        }

        invalidate(); //再描画

        return super.onTouchEvent(event);
    }

}
