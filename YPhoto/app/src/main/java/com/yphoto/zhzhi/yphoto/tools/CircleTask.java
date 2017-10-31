package com.yphoto.zhzhi.yphoto.tools;

import android.graphics.Color;
import android.os.SystemClock;
import android.view.animation.CycleInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhzhi on 10/18/2017.
 */

public class CircleTask extends TimerTask {
    private Circle circle;  //中心点
    private Circle ac;  //外圈
    private Circle c;   //内圈
    private long duration = 1000;
    private long start;
    private final Interpolator interpolator = new CycleInterpolator(1);
    private final Interpolator interpolator1 = new LinearInterpolator();

    private double cr = 40;
    private double acr = 60;
    private double circle_r = 30;

    private Timer mTimer = new Timer();
    AMap aMap;

    public CircleTask(AMap aMap, LatLng loc) {
        this.aMap = aMap;
        ac = aMap.addCircle(new CircleOptions().center(loc)
                .fillColor(Color.argb(155, 255, 218, 185))
                .radius(acr * aMap.getScalePerPixel()).strokeColor(Color.argb(255, 255, 228, 185))
                .strokeWidth(5));

        c = aMap.addCircle(new CircleOptions().center(loc)
                .fillColor(Color.WHITE).radius(cr * aMap.getScalePerPixel())
                .strokeColor(Color.argb(255, 255, 228, 185)).strokeWidth(0));

        circle = aMap.addCircle(new CircleOptions().center(loc)
                .fillColor(Color.argb(155, 2, 155, 252))
                .radius(circle_r * aMap.getScalePerPixel()).strokeColor(Color.argb(255, 255, 228, 185))
                .strokeWidth(0));

        start = SystemClock.uptimeMillis();
        mTimer.schedule(this, 0, 30);
    }

    public void updateLocation(LatLng loc) {
        circle.setCenter(loc);
        ac.setCenter(loc);
        c.setCenter(loc);
    }

    @Override
    public void run() {
        try {
            long elapsed = SystemClock.uptimeMillis() - start;
            float input = (float)elapsed / duration;
//          外圈放大后消失
            float t = interpolator1.getInterpolation(input);
            double r1 = (t + 1) * acr * aMap.getScalePerPixel();
            ac.setRadius(r1);

            c.setRadius(cr * aMap.getScalePerPixel());
            circle.setRadius(circle_r * aMap.getScalePerPixel());
            if (input > 1.5){
                start = SystemClock.uptimeMillis();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
