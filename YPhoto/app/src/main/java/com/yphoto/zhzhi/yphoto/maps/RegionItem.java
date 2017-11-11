package com.yphoto.zhzhi.yphoto.maps;

import com.amap.api.maps.model.LatLng;

/**
 * Created by yiyi.qi on 16/10/10.
 */

public class RegionItem implements ClusterItem {
    private int mGUID;
    private LatLng mLatLng;
    private String mTitle;
    private int mImage;  //每个用户的第一张image（每个用户最多9张）

    public RegionItem(LatLng latLng, String title, int image, int guid) {
        mLatLng=latLng;
        mTitle=title;
        mImage = image;
        mGUID = guid;
    }

    @Override
    public LatLng getPosition() {
        // TODO Auto-generated method stub
        return mLatLng;
    }
    public String getTitle() {
        return mTitle;
    }

    public int getImage() {
        return mImage;
    }

    public int getGUID() {
        return mGUID;
    }
}