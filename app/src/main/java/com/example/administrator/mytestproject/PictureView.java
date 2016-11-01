package com.example.administrator.mytestproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/9/28.
 */
public class PictureView extends View {


    //宽高
    private int mWidth;
    private int mHeight;
    private Path  mPath  = new Path();
    //创建画笔
    private Paint mPaint = new Paint();
    private float r;

    private RectF mRectF = new RectF();

    public PictureView(Context context) {
        super(context);
        init();
    }


    public PictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //初始化画笔
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2, mHeight / 2);
        //绘制坐标原点
        mPaint.setColor(Color.BLACK);//设置画笔颜色
        mPaint.setStrokeWidth(10);//为了看得清楚,设置了较大的画笔宽度
        canvas.drawPoint(0, 0, mPaint);
        //绘制坐标轴4个断点
        canvas.drawPoints(new float[]{
                mWidth / 2 * 0.8f, 0
                , 0, mHeight / 2 * 0.8f
                , -mWidth / 2 * 0.8f, 0
                , 0, -mHeight / 2 * 0.8f}, mPaint);

        mPaint.setStrokeWidth(1);//恢复画笔默认宽度
        //x轴
        mPath.moveTo(-mWidth / 2 * 0.8f, 0);//移动path起点到(-mWidth/2*0.8f,0)
        mPath.lineTo(mWidth / 2 * 0.8f, 0);//直线终点为(mWidth/2*0.8f,0)
        //y轴
        mPath.moveTo(0, -mHeight / 2 * 0.8f);//移动path起点到(0,-mHeight/2*0.8f)
        mPath.lineTo(0, mHeight / 2 * 0.8f);//直线终点为(0,mHeight/2*0.8f)
        //x箭头
        mPath.moveTo(mWidth / 2 * 0.8f * 0.95f, -mWidth / 2 * 0.8f * 0.05f);
        mPath.lineTo(mWidth / 2 * 0.8f, 0);
        mPath.lineTo(mWidth / 2 * 0.8f * 0.95f, mWidth / 2 * 0.8f * 0.05f);
        //y箭头
        mPath.moveTo(mWidth / 2 * 0.8f * 0.05f, mHeight / 2 * 0.8f - mWidth / 2 * 0.8f * 0.05f);
        mPath.lineTo(0, mHeight / 2 * 0.8f);
        mPath.lineTo(-mWidth / 2 * 0.8f * 0.05f, mHeight / 2 * 0.8f - mWidth / 2 * 0.8f * 0.05f);
        //绘制Path
        canvas.drawPath(mPath, mPaint);



    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;


    }
}
