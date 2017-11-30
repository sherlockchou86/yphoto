package com.yphoto.zhzhi.yphoto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.amap.api.maps.model.LatLng;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.yphoto.zhzhi.yphoto.net.PlaceOpenAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationSearchActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    String mSearchTimeStamp = null;
    EditText search_box;
    ImageView clear_progress_btn;

    PlaceOpenAPI mPlaceAPI;


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

        /*
        search_box = (EditText) findViewById(R.id.search_box);
        search_box.addTextChangedListener(this);

        clear_progress_btn = (ImageView) findViewById(R.id.clear_progress_icon);
        clear_progress_btn.setOnClickListener(this);
        clear_progress_btn.setImageDrawable(null);

        mPlaceAPI = new PlaceOpenAPI(this, WeiboData.APP_KEY, WeiboData.readAccessToken(this));
        */
    }

    private List<Map<String, Object>> getLocationList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        // 加入每条记录
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "中国电子大厦");
        map.put("detail", "海淀区-丹棱街5号");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度\
        map.put("item_type", R.drawable.timer);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "北京东方君悦大酒店");
        map.put("detail", "北京市-东城区-东长安街1号东方广场");
        map.put("loc", new LatLng(1,1));  // 该位置的具体经纬度
        map.put("item_type", R.drawable.timer);
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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!search_box.getText().toString().equals("")) {
            clear_progress_btn.setImageResource(R.drawable.loading);
            final String time_stamp = mSearchTimeStamp = String.valueOf(System.currentTimeMillis());
            mPlaceAPI.poisSearch(search_box.getText().toString(), null, null, 50, 1, new RequestListener() {
                @Override
                public void onComplete(String s) {
                    clear_progress_btn.setImageResource(R.drawable.cancel_btn);
                }

                @Override
                public void onWeiboException(WeiboException e) {
                    clear_progress_btn.setImageResource(R.drawable.cancel_btn);
                }
            });

        } else {
            clear_progress_btn.setImageDrawable(null);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        if (mSearchTimeStamp == null) {
            search_box.setText("");
        }
    }
}
