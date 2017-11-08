package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.itsronald.widget.ViewPagerIndicator;
import com.yphoto.zhzhi.yphoto.tools.PhotoDetailViewPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/24/2017.
 */

public class StatusDetailView extends RelativeLayout {
    public StatusDetailView(Context context) {
        super(context);
        initView(context);
    }

    public StatusDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public StatusDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context) {
        final View root = LayoutInflater.from(context).inflate(R.layout.view_status_detail, this, true);

        ViewPager pager = (ViewPager) root.findViewById(R.id.photo_collection);
        PhotoDetailViewPagerAdapter adapter = new PhotoDetailViewPagerAdapter(getContext(), getPhotos());
        pager.setAdapter(adapter);

        ViewPagerIndicator indicator = (ViewPagerIndicator) findViewById(R.id.view_pager_indicator);
        indicator.setGravity(3);
    }

    private List<Map<String, Object>> getPhotos() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        return list;
    }
}
