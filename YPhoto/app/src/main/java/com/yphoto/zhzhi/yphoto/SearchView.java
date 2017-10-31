package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * Created by zhzhi on 10/17/2017.
 */

public class SearchView extends RelativeLayout implements View.OnClickListener {
    public SearchView(Context context) {
        super(context);
        initView(context);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context) {
        final View root = LayoutInflater.from(context).inflate(R.layout.view_search, this, true);

        final View view_avatar = findViewById(R.id.avatar);
        view_avatar.setOnClickListener(this);   //点击头像
    }

    @Override
    public void onClick(View v){
        MenuView menu = new MenuView(getContext());
        PopupWindow popup = new PopupWindow(menu, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, true);
        popup.setAnimationStyle(R.style.MenuAnimation);
        popup.showAtLocation(this, Gravity.NO_GRAVITY, 0, 0);
    }
}
