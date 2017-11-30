package com.yphoto.zhzhi.yphoto;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yphoto.zhzhi.yphoto.tools.CircleImageView;

/**
 * Created by zhzhi on 10/21/2017.
 */

public class MapToolsView extends RelativeLayout implements View.OnClickListener {

    // normal->satellite->3D->night->normal
    private MapType mCurrentMapType = MapType.NORMAL;
    private MapDataType mCurrentMapDataType = MapDataType.JUST_PHOTO;
    private int[] mResDrawables = new int[]{R.drawable.map_normal, R.drawable.map_satellite, R.drawable.map_night};
    private boolean mLoading = false;

    private MapToolClickListener mMapToolClickListener;

    public MapToolsView(Context context) {
        super(context);
        initView(context);
    }

    public MapToolsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MapToolsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_map_tools, this, true);

        RelativeLayout map_type = (RelativeLayout) findViewById(R.id.map_type_container);
        RelativeLayout all_status = (RelativeLayout) findViewById(R.id.all_status_container);
        RelativeLayout just_photo = (RelativeLayout) findViewById(R.id.just_photo_container);
        RelativeLayout load_more = (RelativeLayout) findViewById(R.id.load_more_container);

        map_type.setOnClickListener(this);
        all_status.setOnClickListener(this);
        just_photo.setOnClickListener(this);
        load_more.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CircleImageView map_type = (CircleImageView) findViewById(R.id.map_type);
        ImageView all_status = (ImageView) findViewById(R.id.all_status);
        ImageView just_photo = (ImageView) findViewById(R.id.just_photo);
        ImageView load_more = (ImageView) findViewById(R.id.load_more);

        if(v.getId() == R.id.map_type_container) {
            mCurrentMapType = MapType.fromInt((mCurrentMapType.getValue() + 1) % 3);
            map_type.setImageResource(mResDrawables[mCurrentMapType.getValue()]);
        } else if(v.getId() == R.id.all_status_container) {
            all_status.setImageResource(R.drawable.all_status_selected);
            just_photo.setImageResource(R.drawable.just_photo);
        } else if(v.getId() == R.id.just_photo_container) {
            all_status.setImageResource(R.drawable.all_status);
            just_photo.setImageResource(R.drawable.just_photo_selected);
        } else if(v.getId() == R.id.load_more_container) {
            if (mLoading) {
                mLoading = false;
                load_more.setImageResource(R.drawable.load_more);
            } else {
                mLoading = true;
                load_more.setImageResource(R.drawable.loading);
            }
        }

        if(mMapToolClickListener != null) {
            mMapToolClickListener.onMapToolClick(mCurrentMapType, mCurrentMapDataType, mLoading);
        }
    }

    public void setOnMapToolClickListener(MapToolClickListener listener) {
        mMapToolClickListener = listener;
    }

    public interface MapToolClickListener {
        void onMapToolClick(MapType map_type, MapDataType data_type, boolean load_more);
    }

    public enum MapType {
        NORMAL(0),SATELLITE(1),NIGHT(2);

        private final int value;
        private MapType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static MapType fromInt(int value) {
            return MapType.values()[value];
        }
    }
    public enum MapDataType {
        ALL_STATUS(0),JUST_PHOTO(1);

        private final int value;
        private MapDataType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static MapDataType fromInt(int value) {
            return MapDataType.values()[value];
        }
    }
}
