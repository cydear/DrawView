package com.draw.code.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.draw.code.R;

/**
 * 组合控件
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/17 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class TitleView extends FrameLayout {
    private Button mBtnBack;
    private TextView mTitle;

    public TitleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        mBtnBack = (Button) findViewById(R.id.btn_back);
        mTitle = (TextView) findViewById(R.id.title);
        mBtnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) getContext()).finish();
            }
        });
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    public void setButtonText(String text) {
        this.mBtnBack.setText(text);
    }
}
