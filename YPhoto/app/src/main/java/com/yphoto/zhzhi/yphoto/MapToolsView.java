package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

/**
 * Created by zhzhi on 10/21/2017.
 */

public class MapToolsView extends RelativeLayout {
    public MapToolsView(Context context) {
        super(context);
        initView(context);
    }

    public MapToolsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MapToolsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_map_tools, this, true);
    }
}
