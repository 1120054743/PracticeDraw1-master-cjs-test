package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice11PieChartView extends View {

    private String[] versions = {"Froyo", "GB", "IC S", "JB", "KitKat", "L", "M"};
    private int[] colors = {Color.BLACK, Color.MAGENTA, Color.GRAY, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW};
    private int[] degrees = {3, 8, 9, 60, 90, 135, 55};

    Paint mPiePaint;
    Paint mTextPaint;
    Paint mLinePaint;

    RectF rectFMove;
    RectF rectFCommon;

    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPiePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStrokeWidth(5);
        mLinePaint.setColor(Color.LTGRAY);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(30);
        mTextPaint.setColor(Color.LTGRAY);

        rectFCommon = new RectF(-300, -300, 300, 300);
        rectFMove = new RectF(-320, -320, 280, 280);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        canvas.translate(getWidth()/2,getHeight()/2);

        float startAngle = 0;
        float sweepAngle = 0;

        for (int i=0;i<versions.length;i++){
            mPiePaint.setColor(colors[i]);
            sweepAngle=degrees[i];
            int offsetAngle=2;
            float lineAngle = startAngle+offsetAngle/2+degrees[i]/2;

            float pointX= (float) (Math.cos(lineAngle*Math.PI/180)*300.0);
            float pointY= (float) (Math.sin(lineAngle*Math.PI/180)*300.0);
            float lineX= (float) (Math.cos(lineAngle*Math.PI/180)*350.0);
            float lineY= (float) (Math.sin(lineAngle*Math.PI/180)*350.0);

            canvas.drawArc(i==5?rectFMove:rectFCommon,startAngle+offsetAngle,sweepAngle-offsetAngle,true,mPiePaint);

            if (i==5){
                canvas.translate(-20,-20);
                canvas.drawLine(pointX,pointY,lineX,lineY,mLinePaint);
                canvas.translate(20,20);
            }else{
                canvas.drawLine(pointX,pointY,lineX,lineY,mLinePaint);
            }
            Rect textRect=getTextRect(versions[i],mTextPaint);
            if (lineX<0){
                if (i == 5) {
                    canvas.translate(-20,-20);
                    canvas.drawLine(lineX,lineY,-400,lineY,mLinePaint);
                    canvas.drawText(versions[i],-420-textRect.width(),lineY,mTextPaint);
                    canvas.translate(20,20);
                }else{
                    canvas.drawLine(lineX,lineY,-400,lineY,mLinePaint);
                    canvas.drawText(versions[i],-420-textRect.width(),lineY,mTextPaint);
                }

            }else{
                canvas.drawLine(lineX,lineY,400,lineY,mLinePaint);
                canvas.drawText(versions[i],420,lineY,mTextPaint);
            }

            startAngle+=sweepAngle;
        }

    }



    public Rect getTextRect(String deviceName, Paint paint) {

        Rect mBound = new Rect();
        paint.getTextBounds(deviceName, 0, deviceName.length(), mBound);

        return mBound;
    }
}
