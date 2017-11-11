package com.yphoto.zhzhi.yphoto;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.itsronald.widget.ViewPagerIndicator;
import com.yphoto.zhzhi.yphoto.tools.PhotoDetailViewPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhzhi on 10/24/2017.
 */

public class StatusDetailView extends RelativeLayout implements View.OnClickListener {
    public StatusDetailView(Context context) {
        super(context);
        initView(context);
    }

    public StatusDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public StatusDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context) {
        final View root = LayoutInflater.from(context).inflate(R.layout.view_status_detail, this, true);

        ViewPager pager = (ViewPager) root.findViewById(R.id.photo_collection);
        PhotoDetailViewPagerAdapter adapter = new PhotoDetailViewPagerAdapter(getContext(), getPhotos());
        pager.setAdapter(adapter);

        adapter.setItemClickListener(this);

        ViewPagerIndicator indicator = (ViewPagerIndicator) findViewById(R.id.view_pager_indicator);
        indicator.setGravity(3);

        ImageView more_btn = (ImageView) findViewById(R.id.for_detail_btn);

        RelativeLayout detail_container = (RelativeLayout) findViewById(R.id.detail_container);
        detail_container.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private List<Map<String, Object>> getPhotos() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("photo", R.drawable.profile_background);
        list.add(map);

        return list;
    }


    Boolean mShowDetail = true;
    @Override
    public void onClick(View v) {
        RelativeLayout detail_container = (RelativeLayout) findViewById(R.id.detail_container);
        final ImageView more_btn = (ImageView) findViewById(R.id.for_detail_btn);

        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(metrics);

        if (mShowDetail) {
            detail_container.animate().translationY(metrics.heightPixels).setDuration(200).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    more_btn.setVisibility(VISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            detail_container.animate().translationY(0).setDuration(200).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    more_btn.setVisibility(INVISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        mShowDetail = !mShowDetail;
    }
}
