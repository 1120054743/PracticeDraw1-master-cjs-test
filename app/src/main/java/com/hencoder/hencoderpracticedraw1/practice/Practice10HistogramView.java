package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        Path path=new Path();
        paint.setStrokeWidth(2);
        canvas.drawLine(100,50,100,500,paint);
        canvas.drawLine(100,500,1000,500,paint);
        RectF rectF=new RectF(120,490,220,500);
        RectF rectF1=new RectF(240,480,340,500);
        RectF rectF2=new RectF(360,480,460,500);
        RectF rectF4=new RectF(480,320,580,500);
        RectF rectF5=new RectF(600,220,700,500);
        RectF rectF6=new RectF(720,200,820,500);
        RectF rectF7=new RectF(840,440,940,500);
        paint.setTextSize(32);
        Rect textRect=new Rect();
        paint.getTextBounds("Froyo",0,"Froyo".length(),textRect);
        canvas.drawText("Froyo",120+50-(textRect.width()/2),530,paint);
        paint.getTextBounds("GB",0,"GB".length(),textRect);
        canvas.drawText("GB",170+120-(textRect.width()/2),530,paint);
        paint.getTextBounds("ICS",0,"ICS".length(),textRect);
        canvas.drawText("ICS",170+120*2-(textRect.width()/2),530,paint);
        paint.getTextBounds("JB",0,"JB".length(),textRect);
        canvas.drawText("JB",170+120*3-(textRect.width()/2),530,paint);
        paint.getTextBounds("KitKat",0,"KitKat".length(),textRect);
        canvas.drawText("KitKat",170+120*4-(textRect.width()/2),530,paint);
        paint.getTextBounds("L",0,"L".length(),textRect);
        canvas.drawText("L",170+120*5-(textRect.width()/2),530,paint);
        paint.getTextBounds("M",0,"M".length(),textRect);
        canvas.drawText("M",170+120*6-(textRect.width()/2),530,paint);

        paint.setTextSize(58);
        canvas.drawText("直方图",170+120*2,600,paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(rectF,paint);
        canvas.drawRect(rectF1,paint);
        canvas.drawRect(rectF2,paint);
        canvas.drawRect(rectF4,paint);
        canvas.drawRect(rectF5,paint);
        canvas.drawRect(rectF6,paint);
        canvas.drawRect(rectF7,paint);

    }
}
