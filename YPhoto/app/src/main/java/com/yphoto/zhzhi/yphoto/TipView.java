package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by zhzhi on 11/28/2017.
 */

public class TipView extends RelativeLayout implements View.OnClickListener {
    public TipView(Context context) {
        super(context);
        initView(context);
    }

    public TipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context) {
        final View root = LayoutInflater.from(context).inflate(R.layout.view_tip, this, true);

        ImageView tip_ok = (ImageView)findViewById(R.id.tip_ok);
        tip_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.setVisibility(INVISIBLE);
    }
}
