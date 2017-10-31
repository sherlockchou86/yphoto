package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.yphoto.zhzhi.yphoto.tools.CustPagerTransformer;
import com.yphoto.zhzhi.yphoto.tools.PhotoSwitchViewPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/29/2017.
 */

public class PhotoSwitchView extends RelativeLayout {

    public PhotoSwitchView(Context context) {
        super(context);
        initView(context);
    }

    public PhotoSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PhotoSwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context) {
        final View root = LayoutInflater.from(context).inflate(R.layout.view_photos_switch, this, true);

        ViewPager pager = (ViewPager) root.findViewById(R.id.photo_switch_collection);
        PhotoSwitchViewPagerAdapter adapter = new PhotoSwitchViewPagerAdapter(getContext(), getPhotos());
        pager.setAdapter(adapter);
        pager.setPageTransformer(false, new CustPagerTransformer(context));


        initMap();
    }

    private List<Map<String, Object>> getPhotos() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("photo", R.drawable.map_3d);
        map.put("count", 8);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        map.put("count", 7);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.map_satellite);
        map.put("count", 2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        map.put("count", 3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.default_avatar);
        map.put("count", 6);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        map.put("count", 1);
        list.add(map);

        return list;
    }


    private void initMap() {

    }
}
