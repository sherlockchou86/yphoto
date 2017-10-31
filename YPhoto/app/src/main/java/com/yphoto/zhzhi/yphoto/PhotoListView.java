package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.yphoto.zhzhi.yphoto.tools.PhotoRecycleListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/17/2017.
 */

public class PhotoListView extends RelativeLayout implements PhotoRecycleListViewAdapter.OnPhotoItemClickListener {

    PhotoSwitchView switch_view;
    PopupWindow popup;

    public PhotoListView(Context context) {
        super(context);
        initView(context);
    }

    public PhotoListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PhotoListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_photolist, this, true);

        loadPhotos();
    }


    @Override
    public void onItemClick(View view, int position) {
        if (popup == null && switch_view == null) {
            switch_view = new PhotoSwitchView(getContext());
            popup = new PopupWindow(switch_view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, true);
            popup.setAnimationStyle(R.style.PopupAnimation);
        }
        popup.showAtLocation(this, Gravity.NO_GRAVITY, 0, 0);
    }

    private void loadPhotos() {
        RecyclerView view = (RecyclerView) findViewById(R.id.photo_list);

        PhotoRecycleListViewAdapter adapter = new PhotoRecycleListViewAdapter(getContext(), getPhotoList());
        adapter.setItemClickListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        view.setLayoutManager(manager);
        view.setAdapter(adapter);
    }

    private List<Map<String, Object>> getPhotoList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/624159/20150505133758.png");
        map.put("image_count", 3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/797011/20170708170235.png");
        map.put("image_count", 5);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/502305/20130315154011.png");
        map.put("image_count", 5);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/avatar/104032/20150821151916.png");
        map.put("image_count", 1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/avatar/104032/20150821151916.png");
        map.put("image_count", 2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/502305/20130315154011.png");
        map.put("image_count", 3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/797011/20170708170235.png");
        map.put("image_count", 2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/797011/20170708170235.png");
        map.put("image_count", 9);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/624159/20150505133758.png");
        map.put("image_count", 2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/624159/20150505133758.png");
        map.put("image_count", 6);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/797011/20170708170235.png");
        map.put("image_count", 7);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("first_image", "https://pic.cnblogs.com/face/797011/20170708170235.png");
        map.put("image_count", 8);
        list.add(map);

        return list;
    }
}
