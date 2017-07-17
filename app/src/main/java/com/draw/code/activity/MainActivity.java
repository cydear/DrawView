package com.draw.code.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewParent;
import android.widget.LinearLayout;

import com.draw.code.R;

public class MainActivity extends AppCompatActivity {
    LinearLayout mLlContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLlContent = (LinearLayout) findViewById(R.id.ll_content);
        ViewParent parent = mLlContent.getParent();
        Log.d("TAG", "the parent of mainLayout is " + parent);
    }
}
