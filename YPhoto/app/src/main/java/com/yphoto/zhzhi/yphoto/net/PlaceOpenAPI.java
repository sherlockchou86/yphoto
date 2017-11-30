package com.yphoto.zhzhi.yphoto.net;


import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

public class PlaceOpenAPI extends BaseOpenAPI {

    private static final String SERVER_URL_PRIX = API_SERVER + "/place";

    public PlaceOpenAPI(Context context, String appKey, Oauth2AccessToken accessToken) {
        super(context, appKey, accessToken);
    }

    /**
     * 获取附近照片。
     *
     * @param lat       纬度，有效范围：-90.0到+90.0，+表示北纬
     * @param lon       经度，有效范围：-180.0到+180.0，+表示东经
     * @param range     查询范围半径，默认为2000，最大为11132，单位米
     * @param starttime 开始时间，Unix时间戳
     * @param endtime   结束时间，Unix时间戳
     * @param sortType  排序方式，0：按时间、1：按距离，默认为0
     *                  <li>{@link #SORT_BY_TIME}
     *                  <li>{@link #SORT_BY_DISTENCE}
     * @param count     单页返回的记录条数，默认为20，最大为50
     * @param page      返回结果的页码，默认为1
     * @param offset    传入的经纬度是否是纠偏过，false：没纠偏、true：纠偏过，默认为false
     * @param listener  异步请求回调接口
     */
    public void nearbyPhotos(String lat, String lon, int range, long starttime, long endtime, int sortType, int count,
                             int page, boolean offset, RequestListener listener) {
        WeiboParameters params = buildNearbyParams(lat, lon, range, count, page, sortType, offset);
        params.put("starttime", starttime);
        params.put("endtime", endtime);
        requestAsync(SERVER_URL_PRIX + "/nearby/photos.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 获取某个位置周边的动态。
     *
     * @param lat       纬度。有效范围：-90.0到+90.0，+表示北纬
     * @param lon       经度。有效范围：-180.0到+180.0，+表示东经
     * @param range     搜索范围，单位米，默认2000米，最大11132米
     * @param starttime 开始时间，Unix时间戳
     * @param endtime   结束时间，Unix时间戳
     * @param sortType  排序方式。0：按时间排序， 1：按与中心点距离进行排序
     *                  <li>{@link #SORT_BY_TIME}
     *                  <li>{@link #SORT_BY_DISTENCE}
     * @param count     单页返回的记录条数，最大为50，默认为20
     * @param page      返回结果的页码，默认为1
     * @param base_app  是否只获取当前应用的数据。false为否（所有数据），true为是（仅当前应用），默认为false
     * @param offset    传入的经纬度是否是纠偏过，false：没纠偏、true：纠偏过，默认为false
     * @param listener  异步请求回调接口
     */
    public void nearbyTimeline(String lat, String lon, int range, long starttime, long endtime, int sortType,
                               int count, int page, boolean base_app, boolean offset, RequestListener listener) {
        WeiboParameters params = buildNearbyParams(lat, lon, range, count, page, sortType, offset);
        params.put("starttime", starttime);
        params.put("endtime", endtime);
        params.put("base_app", base_app ? 1 : 0);
        requestAsync(SERVER_URL_PRIX + "/nearby_timeline.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 获取某个用户的位置动态。
     *
     * @param uid       需要查询的用户ID
     * @param since_id  若指定此参数，则返回ID比since_id大的微博（即比since_id时间晚的微博），默认为0
     * @param max_id    若指定此参数，则返回ID小于或等于max_id的微博，默认为0
     * @param count     单页返回的记录条数，最大为50，默认为20
     * @param page      返回结果的页码，默认为1
     * @param base_app  是否只获取当前应用的数据。false为否（所有数据），true为是（仅当前应用），默认为false
     * @param listener  异步请求回调接口
     */
    public void userTimeline(long uid, long since_id, long max_id, int count, int page, boolean base_app,
                             RequestListener listener) {
        WeiboParameters params = buildTimeLineParamsBase(since_id, max_id, count, page);
        params.put("uid", uid);
        params.put("base_app", base_app ? 1 : 0);
        requestAsync(SERVER_URL_PRIX + "/user_timeline.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 按省市查询地点。
     *
     * @param keyword   查询的关键词
     * @param city      城市代码，默认为全国搜索
     * @param category  查询的分类代码，取值范围见：分类代码对应表
     * @param count     单页返回的记录条数，默认为20，最大为50
     * @param page      返回结果的页码，默认为1。
     * @param listener  异步请求回调接口
     */
    public void poisSearch(String keyword, String city, String category, int count, int page, RequestListener listener) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("keyword", keyword);
        if (city != null) {
            params.put("city", city);
        }
        if (category != null) {
            params.put("category", category);
        }
        params.put("count", count);
        params.put("page", page);
        requestAsync(SERVER_URL_PRIX + "/pois/search.json", params, HTTPMETHOD_GET, listener);
    }

    // 组装NearBy的参数
    private WeiboParameters buildNearbyParams(String lat, String lon, int range, int count, int page,
                                              int sortType, boolean offset) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("lat", lat);
        params.put("long", lon);
        params.put("range", range);
        params.put("count", count);
        params.put("page", page);
        params.put("sort", sortType);
        params.put("offset", offset ? 1 : 0);
        return params;
    }

    // 组装TimeLines的参数
    private WeiboParameters buildTimeLineParamsBase(long since_id, long max_id, int count, int page) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("since_id", since_id);
        params.put("max_id", max_id);
        params.put("count", count);
        params.put("page", page);
        return params;
    }
}
