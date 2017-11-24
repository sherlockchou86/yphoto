package com.yphoto.zhzhi.yphoto;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yphoto.zhzhi.yphoto.tools.CircleImageView;
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
        View normal_ = findViewById(R.id.map_normal_container);
        View night_ = findViewById(R.id.map_night_container);
        View satellite_ = findViewById(R.id.map_satellite_container);
        View d3_ = findViewById(R.id.map_3d_container);

        normal_.setOnClickListener(this);
        night_.setOnClickListener(this);
        satellite_.setOnClickListener(this);
        d3_.setOnClickListener(this);

        ViewPager tab_content = (ViewPager) findViewById(R.id.tab_content);
        TabLayout tab_header = (TabLayout) findViewById(R.id.tab_header);

        tab_content.setAdapter(new FriendsPageAdapter(this));
        tab_header.setupWithViewPager(tab_content);

        tab_header.getTabAt(0).setText("我关注的");
        tab_header.getTabAt(1).setText("关注我的");
    }


    @Override
    public void onClick(View v) {
        View normal_image = findViewById(R.id.map_normal_image);
        View normal_text = findViewById(R.id.map_normal_text);

        View night_image = findViewById(R.id.map_night_image);
        View night_text = findViewById(R.id.map_night_text);

        View satellite_image = findViewById(R.id.map_satellite_image);
        View satellite_text = findViewById(R.id.map_satellite_text);

        View d3_image = findViewById(R.id.map_3d_image);
        View d3_text = findViewById(R.id.map_3d_text);

        View profile_container = findViewById(R.id.profile_container);

        if (v.getId() == R.id.map_normal_container) {
            ((CircleImageView)normal_image).setBorderColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((TextView)normal_text).setTextColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((CircleImageView)night_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)night_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)satellite_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)satellite_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)d3_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)d3_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));

        } else if(v.getId() == R.id.map_night_container) {
            ((CircleImageView)normal_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)normal_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)night_image).setBorderColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((TextView)night_text).setTextColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((CircleImageView)satellite_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)satellite_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)d3_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)d3_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));

        } else if(v.getId() == R.id.map_satellite_container) {
            ((CircleImageView)normal_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)normal_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)night_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)night_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)satellite_image).setBorderColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((TextView)satellite_text).setTextColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((CircleImageView)d3_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)d3_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));

        } else if(v.getId() == R.id.map_3d_container) {
            ((CircleImageView)normal_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)normal_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)night_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)night_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)satellite_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)satellite_text).setTextColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((CircleImageView)d3_image).setBorderColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((TextView)d3_text).setTextColor(getResources().getColor(R.color.colorSelectedBorderColor));

        }
    }
}
