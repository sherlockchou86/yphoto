package com.yphoto.zhzhi.yphoto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.yphoto.zhzhi.yphoto.tools.CircleImageView;
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
        //pager.setPageTransformer(false, new CustPagerTransformer(context));
        pager.addOnPageChangeListener(this);
        adapter.addOnPhotoSwitchViewPagerClickListener(this);

        initMap();
    }

    private List<Map<String, Object>> getPhotos() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.default_avatar);
        map.put("nickname", "再见红烧肉");
        map.put("photo", R.drawable.sign_in_background2);
        map.put("count", 8);
        map.put("loc", new LatLng(39.979376, 116.310280));
        map.put("loc_str", "中东路郑城小区");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar2);
        map.put("nickname", "微软Windows10输入法");
        map.put("photo", R.drawable.sign_in_background);
        map.put("count", 7);
        map.put("loc", new LatLng(39.929126, 116.340220));
        map.put("loc_str", "中东路汉庭酒店");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.default_avatar);
        map.put("nickname", "微软小娜");
        map.put("photo", R.drawable.background3);
        map.put("count", 2);
        map.put("loc", new LatLng(39.955126, 116.350220));
        map.put("loc_str", "东小口派出所");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar6);
        map.put("nickname", "微软研究院");
        map.put("photo", R.drawable.sign_in_background);
        map.put("count", 3);
        map.put("loc", new LatLng(39.955109, 116.342280));
        map.put("loc_str", "乔家大院");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.default_avatar);
        map.put("nickname", "白云黑土");
        map.put("photo", R.drawable.default_avatar);
        map.put("count", 6);
        map.put("loc", new LatLng(39.969166, 116.35432));
        map.put("loc_str", "黄河大道11号");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar4);
        map.put("nickname", "一块腊肉");
        map.put("photo", R.drawable.sign_in_background2);
        map.put("count", 1);
        map.put("loc", new LatLng(39.959311, 116.4010250));
        map.put("loc_str", "湖北路与善缘街交口");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar6);
        map.put("nickname", "再见红烧肉");
        map.put("photo", R.drawable.sign_in_background);
        map.put("count", 6);
        map.put("loc", new LatLng(39.919346, 116.373280));
        map.put("loc_str", "海淀区知春路");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar5);
        map.put("nickname", "Beyond转世");
        map.put("photo", R.drawable.sign_in_background2);
        map.put("count", 4);
        map.put("loc", new LatLng(39.909381, 116.312220));
        map.put("loc_str", "苏州街与丹棱街交口");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar4);
        map.put("nickname", "IT程序猿");
        map.put("photo", R.drawable.sign_in_background);
        map.put("count", 5);
        map.put("loc", new LatLng(39.949112, 116.3350380));
        map.put("loc_str", "海淀区丹棱街5号");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar3);
        map.put("nickname", "happyQQ");
        map.put("photo", R.drawable.sign_in_background2);
        map.put("count", 1);
        map.put("loc", new LatLng(39.943016, 116.310320));
        map.put("loc_str", "海淀区海淀黄庄3号");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar2);
        map.put("nickname", "假装在纽约");
        map.put("photo", R.drawable.sign_in_background);
        map.put("count", 2);
        map.put("loc", new LatLng(39.979366, 116.353280));
        map.put("loc_str", "中关村大厦");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar1);
        map.put("nickname", "十年砍柴");
        map.put("photo", R.drawable.sign_in_background2);
        map.put("count", 3);
        map.put("loc", new LatLng(39.949336, 116.370280));
        map.put("loc_str", "北四环辅路");
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

            final TextView loc_str = (TextView) findViewById(R.id.loc_str);
            loc_str.setText(record.get("loc_str").toString());

            final CircleImageView avatar = (CircleImageView) findViewById(R.id.author_avatar);
            avatar.setImageResource((int)record.get("avatar"));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPhotoSwitchViewPagerItemClick(int position) {
        /*
        StatusDetailView detailView = new StatusDetailView(getContext());
        PopupWindow popup = new PopupWindow(detailView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, true);
        popup.setAnimationStyle(R.style.PopupAnimation);
        popup.showAtLocation(this, Gravity.NO_GRAVITY, 0, 0);
        */

        Intent intent = new Intent(getContext(), StatusDetailActivity.class);
        getContext().startActivity(intent);
    }
}
