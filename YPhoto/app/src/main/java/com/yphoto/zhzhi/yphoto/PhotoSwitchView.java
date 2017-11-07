package com.yphoto.zhzhi.yphoto;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.yphoto.zhzhi.yphoto.tools.CustPagerTransformer;
import com.yphoto.zhzhi.yphoto.tools.PhotoSwitchViewPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/29/2017.
 */

public class PhotoSwitchView extends RelativeLayout implements ViewPager.OnPageChangeListener, PhotoSwitchViewPagerAdapter.OnPhotoSwitchViewPagerItemClickListener {

    Context mContext;
    List<Map<String, Object>> mPhotos;

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
        mContext = context;
        final View root = LayoutInflater.from(context).inflate(R.layout.view_photos_switch, this, true);

        ViewPager pager = (ViewPager) root.findViewById(R.id.photo_switch_collection);
        PhotoSwitchViewPagerAdapter adapter = new PhotoSwitchViewPagerAdapter(getContext(), mPhotos = getPhotos());
        pager.setAdapter(adapter);
        pager.setPageTransformer(false, new CustPagerTransformer(context));
        pager.addOnPageChangeListener(this);
        adapter.addOnPhotoSwitchViewPagerClickListener(this);

        initMap();
    }

    private List<Map<String, Object>> getPhotos() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.weibo_logo);
        map.put("nickname", "再见红烧肉");
        map.put("photo", R.drawable.map_3d);
        map.put("count", 8);
        map.put("loc", new LatLng(39.979376, 116.310280));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.favorite);
        map.put("nickname", "微软Windows10输入法");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 7);
        map.put("loc", new LatLng(39.929126, 116.340220));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.close_btn);
        map.put("nickname", "微软小娜");
        map.put("photo", R.drawable.map_satellite);
        map.put("count", 2);
        map.put("loc", new LatLng(39.955126, 116.350220));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.compass);
        map.put("nickname", "微软研究院");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 3);
        map.put("loc", new LatLng(39.955109, 116.342280));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.weibo_logo);
        map.put("nickname", "白云黑土");
        map.put("photo", R.drawable.default_avatar);
        map.put("count", 6);
        map.put("loc", new LatLng(39.969166, 116.35432));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.close_btn);
        map.put("nickname", "一块腊肉");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 1);
        map.put("loc", new LatLng(39.959311, 116.4010250));
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.weibo_logo);
        map.put("nickname", "再见红烧肉");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 6);
        map.put("loc", new LatLng(39.919346, 116.373280));
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.weibo_logo);
        map.put("nickname", "Beyond转世");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 4);
        map.put("loc", new LatLng(39.909381, 116.312220));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.weibo_logo);
        map.put("nickname", "IT程序猿");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 5);
        map.put("loc", new LatLng(39.949112, 116.3350380));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.compass);
        map.put("nickname", "happyQQ");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 1);
        map.put("loc", new LatLng(39.943016, 116.310320));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.favorite);
        map.put("nickname", "假装在纽约");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 2);
        map.put("loc", new LatLng(39.979366, 116.353280));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.default_avatar);
        map.put("nickname", "十年砍柴");
        map.put("photo", R.drawable.profile_background);
        map.put("count", 3);
        map.put("loc", new LatLng(39.949336, 116.370280));
        list.add(map);

        return list;
    }


    private void initMap() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        final Map<String, Object> record = mPhotos.get(position);
        if(record != null) {
            TextView counter = (TextView) findViewById(R.id.counter);
            counter.setText((position + 1)  + "/" + mPhotos.size());

            MapFragmentSimple map = (MapFragmentSimple) ((Activity)mContext).getFragmentManager().findFragmentById(R.id.map_simple_fragment);
            map.updateLoc((LatLng) record.get("loc"));  // update the map center

            final ImageView avatar = (ImageView) findViewById(R.id.author_avatar);
            final TextView nickname = (TextView) findViewById(R.id.author_nickname);

            avatar.setImageResource((int) record.get("avatar"));
            nickname.setText(record.get("nickname").toString());
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPhotoSwitchViewPagerItemClick(int position) {
        StatusDetailView detailView = new StatusDetailView(getContext());
        PopupWindow popup = new PopupWindow(detailView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, true);
        popup.setAnimationStyle(R.style.PopupAnimation);
        popup.showAtLocation(this, Gravity.NO_GRAVITY, 0, 0);
    }
}