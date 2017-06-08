package com.kelinlang.viewapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.kelinlang.viewapp.R;


public class TasksCompletedView extends View {

    // 画实心圆的画笔
    private Paint mCirclePaint;
    // 画圆环的画笔
    private Paint mRingPaint;
    //画圆环2的画笔
    private Paint mRingPaint2;
    // 画字体的画笔
    private Paint mTextPaint;
    // 圆形颜色
    private int mCircleColor;
    // 圆环颜色
    private int mRingColor;
    // 圆环2颜色
    private int mRingColor2;
    // 半径
    private float mRadius;
    // 圆环半径
    private float mRingRadius;
    // 圆环宽度
    private float mStrokeWidth;
    // 圆心x坐标
    private int mXCenter;
    // 圆心y坐标
    private int mYCenter;
    // 字的长度
    private float mTxtWidth;
    // 字的高度
    private float mTxtHeight;
    // 总进度
    private int mTotalProgress = 100;
    // 当前进度
    private int mProgress;

    public TasksCompletedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 获取自定义的属性
        initAttrs(context, attrs);
        initVariable();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TasksCompletedView, 0, 0);
        mRadius = typeArray.getDimension(R.styleable.TasksCompletedView_radius, 80);
        mStrokeWidth = typeArray.getDimension(R.styleable.TasksCompletedView_strokeWidth, 30);
        mCircleColor = typeArray.getColor(R.styleable.TasksCompletedView_circleColor, 0x00000000);
        mRingColor = typeArray.getColor(R.styleable.TasksCompletedView_ringColor, context.getResources().getColor(R.color.color_ed6512));
        mRingColor2 = typeArray.getColor(R.styleable.TasksCompletedView_ringColor, context.getResources().getColor(R.color.three_color));

        mRingRadius = mRadius + mStrokeWidth / 2;
    }

    private void initVariable() {
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(mCircleColor);
        mCirclePaint.setStyle(Paint.Style.FILL);

        mRingPaint = new Paint();
        mRingPaint.setAntiAlias(true);
        mRingPaint.setColor(mRingColor);
        mRingPaint.setStyle(Paint.Style.STROKE);
        mRingPaint.setStrokeWidth(mStrokeWidth);

        mRingPaint2 = new Paint();
        mRingPaint2.setAntiAlias(true);
        mRingPaint2.setColor(mRingColor2);
        mRingPaint2.setStyle(Paint.Style.STROKE);
        mRingPaint2.setStrokeWidth(mStrokeWidth);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setARGB(255, 255, 255, 255);
        mTextPaint.setTextSize(mRadius / 2);

        FontMetrics fm = mTextPaint.getFontMetrics();
        mTxtHeight = (int) Math.ceil(fm.descent - fm.ascent);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        mXCenter = getWidth() / 2;
        mYCenter = getHeight() / 2;

        //阴影的圆
        canvas.drawCircle(mXCenter, mYCenter, mRadius, mCirclePaint);
        RectF oval = new RectF();
        oval.left = (mXCenter - mRingRadius);
        oval.top = (mYCenter - mRingRadius);
        oval.right = mRingRadius * 2 + (mXCenter - mRingRadius);
        oval.bottom = mRingRadius * 2 + (mYCenter - mRingRadius);
        canvas.drawArc(oval, -90, 1 * 360, false, mRingPaint2);

        //根据进度形成的圆
        if (mProgress >= 0) {
            RectF oval2 = new RectF();
            oval2.left = (mXCenter - mRingRadius);
            oval2.top = (mYCenter - mRingRadius);
            oval2.right = mRingRadius * 2 + (mXCenter - mRingRadius);
            oval2.bottom = mRingRadius * 2 + (mYCenter - mRingRadius);
            canvas.drawArc(oval2, -90, ((float) mProgress / mTotalProgress) * 360, false, mRingPaint);
            String txt = mProgress + "%";
            mTxtWidth = mTextPaint.measureText(txt, 0, txt.length());
            canvas.drawText(txt, mXCenter - mTxtWidth / 2, mYCenter + mTxtHeight / 4, mTextPaint);
        }


    }

    public void setProgress(int progress) {
        mProgress = progress;
        postInvalidate();
    }

}  