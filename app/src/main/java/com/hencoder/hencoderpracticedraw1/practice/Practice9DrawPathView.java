package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        Path path=new Path();
        RectF rectF=new RectF(200,200,400,400);
        RectF rectFLeft=new RectF(400,200,600,400);
        path.addArc(rectF,-225,225);
        path.arcTo(rectFLeft,-180,225);
        path.lineTo(400,550);
        canvas.drawPath(path,paint);
    }
}
