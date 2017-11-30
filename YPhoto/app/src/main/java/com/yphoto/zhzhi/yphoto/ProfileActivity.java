package com.yphoto.zhzhi.yphoto;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yphoto.zhzhi.yphoto.tools.FriendsPageAdapter;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);


        init();
    }

    private void init() {
        ViewPager tab_content = (ViewPager) findViewById(R.id.tab_content);
        TabLayout tab_header = (TabLayout) findViewById(R.id.tab_header);

        tab_content.setAdapter(new FriendsPageAdapter(this));
        tab_header.setupWithViewPager(tab_content);

        tab_header.getTabAt(0).setText("我关注的");
        tab_header.getTabAt(1).setText("关注我的");
    }


    @Override
    public void onClick(View v) {
    }
}
