package com.kelinlang.viewapp.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.kelinlang.commonlib.utils.dimen.DensityUtil;

import com.kelinlang.viewapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/12 0012.
 */

public class NinePhotoView extends ViewGroup {

    private static final  int MAX_PHOTO_NUMBER = 9;
    private int[] constImageIds = {
            R.mipmap.weather_cloudy,
            R.mipmap.weather_dust,
            R.mipmap.weather_haze,
            R.mipmap.weather_snow,
            R.mipmap.weather_storm,
            R.mipmap.weather_wind,
            R.mipmap.weather_typhoon,
            R.mipmap.weather_sunny,
            R.mipmap.weather_sunny
    };

    int hSpace = DensityUtil.dip2px(getContext(),10);
    int vSpace = DensityUtil.dip2px(getContext(),10);

    int childWidth;
    int childHeight;

    private List<Integer> mImageResList = new ArrayList<Integer>(9);
    private View addPhotoView;

    public NinePhotoView(Context context) {
        super(context);
    }

    public NinePhotoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NinePhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.NinePhotoView,0,0);
        hSpace = t.getDimensionPixelSize(R.styleable.NinePhotoView_ninephoto_hspace,hSpace);
        vSpace= t.getDimensionPixelSize(R.styleable.NinePhotoView_ninephoto_vspace,vSpace);
        t.recycle();

        addPhotoView = new View(context);
        addPhotoView.setBackgroundResource(R.mipmap.weather_sunny);
        addView(addPhotoView);
        mImageResList.add(new Integer(0));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int rw= MeasureSpec.getSize(widthMeasureSpec);
        int rh = MeasureSpec.getSize(heightMeasureSpec);

        childWidth = (rw - 2*hSpace)/3;
        childHeight = childWidth;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++){
            View child = getChildAt(i);

            NinePhotoView.LayoutParams layoutParams= (NinePhotoView.LayoutParams)child.getLayoutParams();
            layoutParams.left = (i%3)*(childWidth + hSpace);
            layoutParams.top = (i/3)*(childWidth + vSpace);
        }

        int vw = rw;
        int vh = rh;
        if (childCount < 3){
            vw = childCount*(childWidth + hSpace);
        }
        vh = ((childCount + 3) /3)*(childWidth + vSpace);
        setMeasuredDimension(vw,vh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int childCount = getChildCount();
        for(int j = 0; j < childCount; j++){
            View child = getChildAt(j);
            NinePhotoView.LayoutParams layoutParams = (NinePhotoView.LayoutParams)child.getLayoutParams();
            child.layout(layoutParams.left,layoutParams.top,
                    layoutParams.left + childWidth,layoutParams.top+childHeight);
            if (j == mImageResList.size() - 1 && mImageResList.size() != MAX_PHOTO_NUMBER){
                child.setBackgroundResource(R.mipmap.weather_sunny);
                child.setOnClickListener((view -> {
                    addPhotoBtnClick();
                }));
            }else {
                child.setBackgroundResource(constImageIds[j]);
                child.setOnClickListener(null);
            }
        }
    }


    public void addPhoto(){
        if (mImageResList.size() < MAX_PHOTO_NUMBER){
            View newChildView = new View(getContext());
            addView(newChildView);
            mImageResList.add(mImageResList.size()-1);
            requestLayout();
            invalidate();
        }
    }

    public void addPhotoBtnClick(){
        final CharSequence[] items = {
                "添加图片",

        };
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addPhoto();
            }
        });
        builder.show();
    }


    private static class LayoutParams extends ViewGroup.LayoutParams{

        public int left = 0;
        public int top = 0;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new NinePhotoView.LayoutParams(p);
    }

    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new NinePhotoView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new NinePhotoView.LayoutParams(getContext(),attrs);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof  NinePhotoView.LayoutParams;
    }
}
