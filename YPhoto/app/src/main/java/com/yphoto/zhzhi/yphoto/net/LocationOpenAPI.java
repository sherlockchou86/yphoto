package com.yphoto.zhzhi.yphoto.net;

import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

/**
 * Created by zhzhi on 11/29/2017.
 */

public class LocationOpenAPI extends BaseOpenAPI {

    private static final String SERVER_URL_PRIX = API_SERVER + "/location";

    public LocationOpenAPI(Context context, String appKey, Oauth2AccessToken accessToken) {
        super(context, appKey, accessToken);
    }

    /**
     * 根据地理信息坐标返回实际地址。
     *
     * @param longtitude 经度，有效范围：-180.0到+180.0，+表示东经，默认为0.0。
     * @param latitude   纬度，有效范围：-90.0到+90.0，+表示北纬，默认为0.0。
     * @param listener   异步请求回调接口
     */
    public void geo2Address(Double longtitude, Double latitude, RequestListener listener) {
        WeiboParameters params = buildGeo2AddressParam(longtitude, latitude);
        requestAsync(SERVER_URL_PRIX + "/geo/geo_to_address.json", params, HTTPMETHOD_GET, listener);
    }

    private WeiboParameters buildGeo2AddressParam(Double longtitude, Double latitude) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        String coordinate = longtitude + "," + latitude;
        params.put("coordinate", coordinate);
        return params;
    }
}
