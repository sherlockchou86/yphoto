package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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

        final View view_profile = findViewById(R.id.profile_btn);
        view_profile.setOnClickListener(this);

        final View search_box = findViewById(R.id.search_box);
        search_box.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.profile_btn) {
            Intent intent = new Intent(getContext(), ProfileActivity.class);
            getContext().startActivity(intent);
        } else if (v.getId() == R.id.search_box) {
            Intent intent = new Intent(getContext(), LocationSearchActivity.class);
            getContext().startActivity(intent);
        }
    }
}
