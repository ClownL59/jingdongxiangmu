package com.bwei.jingd.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwei.jingd.R;


public class AddSubView extends LinearLayout {

    private TextView sub;
    private TextView num;
    private TextView add;

    public AddSubView(Context context) {
        this(context, null);
    }

    public AddSubView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.add_sub_view, this);
        sub = findViewById(R.id.child_text_jian);
        num = findViewById(R.id.child_text_num);
        add = findViewById(R.id.child_text_add);
    }

    //设置数量
    public void setNum(String str) {
        num.setText(str);
    }

    //获取数量
    public String getNum() {
        return num.getText().toString();
    }

    // 给加号设置点击事件
    public void setAddOnclickListener(OnClickListener onclickListener) {
        add.setOnClickListener(onclickListener);
    }

    // 给减号设置点击事件
    public void setSubOnclickListener(OnClickListener onclickListener) {
        sub.setOnClickListener(onclickListener);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
