package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 11/24/2017.
 */

public class FriendsListView extends RelativeLayout {
    public FriendsListView(Context context) {
        super(context);
        initView(context);
    }

    public FriendsListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public FriendsListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_firends_list, this, true);
        loadFirends();
    }

    private void loadFirends() {
        ListView firends_list = (ListView) findViewById(R.id.friends_list);

        SimpleAdapter adapter = new SimpleAdapter(getContext(),
                getFriendsList(),
                R.layout.item_user_info,
                new String[]{"avatar", "screen_name", "desc", "item_type"},
                new int[] {R.id.user_avatar, R.id.screen_name, R.id.user_detail, R.id.item_type_icon});

        firends_list.setAdapter(adapter);
    }

    private List<Map<String, Object>> getFriendsList() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("avatar", R.drawable.avatar5);
        map.put("screen_name", "IT周间之");
        map.put("desc", "用户很懒，没有设置");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<>();
        map.put("avatar", R.drawable.avatar3);
        map.put("screen_name", "十年砍柴");
        map.put("desc", "互联网博主");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<>();
        map.put("avatar", R.drawable.avatar6);
        map.put("screen_name", "假装在荷兰");
        map.put("desc", "著名演员，代表作《北京北京》");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<>();
        map.put("avatar", R.drawable.avatar3);
        map.put("screen_name", "假装在新加坡");
        map.put("desc", "新加坡不能随地吐痰");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<>();
        map.put("avatar", R.drawable.avatar2);
        map.put("screen_name", "稀土部队");
        map.put("desc", "著名影视演员");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<>();
        map.put("avatar", R.drawable.avatar6);
        map.put("screen_name", "稀土部队");
        map.put("desc", "著名影视演员");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<>();
        map.put("avatar", R.drawable.avatar6);
        map.put("screen_name", "稀土部队");
        map.put("desc", "著名影视演员");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<>();
        map.put("avatar", R.drawable.avatar1);
        map.put("screen_name", "稀土部队");
        map.put("desc", "著名影视演员");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        map = new HashMap<>();
        map.put("avatar", R.drawable.avatar1);
        map.put("screen_name", "人民日报");
        map.put("desc", "人民日报社官方微博");
        map.put("item_type", R.drawable.up_left);
        list.add(map);

        return list;
    }
}
