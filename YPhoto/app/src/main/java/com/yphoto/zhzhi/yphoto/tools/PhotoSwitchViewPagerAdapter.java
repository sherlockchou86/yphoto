package com.yphoto.zhzhi.yphoto.tools;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yphoto.zhzhi.yphoto.R;

import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/29/2017.
 */

public class PhotoSwitchViewPagerAdapter extends PagerAdapter {
    List<Map<String, Object>> mData;
    Context mContext;

    private OnPhotoSwitchViewPagerItemClickListener itemClickListener;

    public PhotoSwitchViewPagerAdapter(Context context, List<Map<String, Object>> data) {
        mData = data;
        mContext = context;
    }
    // viewpager中的要显示的View的总数量
    @Override
    public int getCount() {
        return mData.size();
    }

    // 滑动切换的时候销毁当前的View
    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        container.removeView((View) object);
    }

    // 每次滑动的时候生成的View
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_photo_switch, null);
        Map<String, Object> record = mData.get(position);

        ImageView image_view = (ImageView) view.findViewById(R.id.first_photo);
        image_view.setImageResource((Integer) record.get("photo"));
        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener != null) {
                    itemClickListener.onPhotoSwitchViewPagerItemClick(position);
                }
            }
        });
        return view;
    }

    // 官方建议这样写
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    //
    public void addOnPhotoSwitchViewPagerClickListener(OnPhotoSwitchViewPagerItemClickListener listener) {
        itemClickListener = listener;
    }

    // item clicked interface
    public interface OnPhotoSwitchViewPagerItemClickListener {
        void onPhotoSwitchViewPagerItemClick(int position);
    }
}
