package com.draw.code.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.draw.code.R;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2017/7/17 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class SimpleLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_layout);
    }
}
