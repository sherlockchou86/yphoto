package com.yphoto.zhzhi.yphoto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.amap.api.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_location_search);

        init();
    }

    private void init() {
        ListView search_list = (ListView) findViewById(R.id.search_list);

        SimpleAdapter adapter = new SimpleAdapter(this,
                getLocationList(),
                R.layout.item_location_favorites,
                new String[]{"name", "detail", "item_type"},
                new int[]{R.id.location_name, R.id.location_detail, R.id.item_type_icon});
        search_list.setAdapter(adapter);
    }

    private List<Map<String, Object>> getLocationList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        // 加入每条记录
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度\
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "北京东方君悦大酒店");
        map.put("detail", "北京市-东城区-东长安街1号东方广场");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "百老汇影城");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "奥林匹克公园");
        map.put("detail", "北京市-朝阳区-科荟路32号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        return list;
    }
}
