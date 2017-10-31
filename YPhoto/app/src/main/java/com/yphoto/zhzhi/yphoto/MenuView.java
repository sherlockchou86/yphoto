package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import com.amap.api.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/21/2017.
 */

public class MenuView extends RelativeLayout {
    public MenuView(Context context) {
        super(context);
        initView(context);
    }

    public MenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_menu, this, true);

        // 加载收藏位置
        loadLocations();
    }

    private void loadLocations() {
        ListView location_list = (ListView) findViewById(R.id.location_favorites_list);

        SimpleAdapter adapter = new SimpleAdapter(getContext(),
                getLocationList(),
                R.layout.item_location_favorites,
                new String[]{"name", "detail", "icon"},
                new int[]{R.id.location_name, R.id.location_detail, R.id.location_icon});
        location_list.setAdapter(adapter);
    }

    private List<Map<String, Object>> getLocationList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        // 加入每条记录
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.viewpoint_icon);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "北京东方君悦大酒店");
        map.put("detail", "北京市-东城区-东长安街1号东方广场");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.viewpoint_icon);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "百老汇影城");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.location_icon);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "奥林匹克公园");
        map.put("detail", "北京市-朝阳区-科荟路32号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.viewpoint_icon);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.location_icon);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.location_icon);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.viewpoint_icon);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.location_icon);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.location_icon);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.viewpoint_icon);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.viewpoint_icon);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.location_icon);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("icon", R.drawable.location_icon);
        list.add(map);

        return list;
    }
}
