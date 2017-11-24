package com.yphoto.zhzhi.yphoto.tools;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.yphoto.zhzhi.yphoto.FriendsListView;

/**
 * Created by zhzhi on 11/23/2017.
 */

public class FriendsPageAdapter extends PagerAdapter {
    int PAGE_SIZE = 2;
    Context mContext;

    public FriendsPageAdapter(Context context) {
        mContext = context;
    }
    @Override
    public int getCount() {
        return PAGE_SIZE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View item = new FriendsListView(mContext);

        container.addView(item);

        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
