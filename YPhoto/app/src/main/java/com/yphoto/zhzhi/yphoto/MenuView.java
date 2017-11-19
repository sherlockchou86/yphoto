package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.yphoto.zhzhi.yphoto.tools.CircleImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/21/2017.
 */

public class MenuView extends RelativeLayout implements View.OnClickListener {
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

        View normal_ = findViewById(R.id.map_normal_container);
        View night_ = findViewById(R.id.map_night_container);
        View satellite_ = findViewById(R.id.map_satellite_container);
        View d3_ = findViewById(R.id.map_3d_container);

        normal_.setOnClickListener(this);
        night_.setOnClickListener(this);
        satellite_.setOnClickListener(this);
        d3_.setOnClickListener(this);
    }

    private void loadLocations() {
        ListView location_list = (ListView) findViewById(R.id.location_favorites_list);

        SimpleAdapter adapter = new SimpleAdapter(getContext(),
                getLocationList(),
                R.layout.item_location_favorites,
                new String[]{"name", "detail", "item_type"},
                new int[]{R.id.location_name, R.id.location_detail, R.id.item_type_icon});
        location_list.setAdapter(adapter);
    }

    private List<Map<String, Object>> getLocationList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        // 加入每条记录
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度\
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "北京东方君悦大酒店");
        map.put("detail", "北京市-东城区-东长安街1号东方广场");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "百老汇影城");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "奥林匹克公园");
        map.put("detail", "北京市-朝阳区-科荟路32号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.star);
        list.add(map);

        return list;
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
            ((TextView)night_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)satellite_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)satellite_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)d3_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)d3_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));

            ((RelativeLayout)profile_container).setBackgroundResource(R.drawable.map_normal);
        } else if(v.getId() == R.id.map_night_container) {
            ((CircleImageView)normal_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)normal_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)night_image).setBorderColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((TextView)night_text).setTextColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((CircleImageView)satellite_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)satellite_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)d3_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)d3_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));

            ((RelativeLayout)profile_container).setBackgroundResource(R.drawable.map_night);
        } else if(v.getId() == R.id.map_satellite_container) {
            ((CircleImageView)normal_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)normal_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)night_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)night_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)satellite_image).setBorderColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((TextView)satellite_text).setTextColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((CircleImageView)d3_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)d3_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));

            ((RelativeLayout)profile_container).setBackgroundResource(R.drawable.map_satellite);
        } else if(v.getId() == R.id.map_3d_container) {
            ((CircleImageView)normal_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)normal_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)night_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)night_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)satellite_image).setBorderColor(getResources().getColor(R.color.colorUnSelectedBorderColor));
            ((TextView)satellite_text).setTextColor(getResources().getColor(R.color.colorUnSelectedTextColor));
            ((CircleImageView)d3_image).setBorderColor(getResources().getColor(R.color.colorSelectedBorderColor));
            ((TextView)d3_text).setTextColor(getResources().getColor(R.color.colorSelectedBorderColor));

            ((RelativeLayout)profile_container).setBackgroundResource(R.drawable.map_3d);
        }
    }
}
