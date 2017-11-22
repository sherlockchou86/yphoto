package com.yphoto.zhzhi.yphoto.net;

import android.content.Context;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;

/**
 * Created by zhzhi on 11/22/2017.
 */

public class FriendShipOpenAPI extends BaseOpenAPI {
    private static final String SERVER_URL_PRIX = API_SERVER + "/friendships";

    public FriendShipOpenAPI(Context context, String appKey, Oauth2AccessToken accessToken) {
        super(context, appKey, accessToken);
    }


    /**
     * 获取用户的关注列表。
     *
     * @param uid           需要查询的用户UID
     * @param count         单页返回的记录条数，默认为50，最大不超过200
     * @param cursor        返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0
     * @param trim_status   返回值中user字段中的status字段开关，false：返回完整status字段、true：status字段仅返回status_id，默认为true
     * @param listener      异步请求回调接口
     */
    public void friends(long uid, int count, int cursor, boolean trim_status, RequestListener listener) {
        WeiboParameters params = new WeiboParameters(mAppKey); params = buildFriendsParam(count, cursor, trim_status);
        params.put("uid", uid);
        requestAsync(SERVER_URL_PRIX + "/friends.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 获取用户的关注列表。
     *
     * @param screen_name   需要查询的用户昵称
     * @param count         单页返回的记录条数，默认为50，最大不超过200
     * @param cursor        返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0
     * @param trim_status   返回值中user字段中的status字段开关，false：返回完整status字段、true：status字段仅返回status_id，默认为true
     * @param listener      异步请求回调接口
     */
    public void friends(String screen_name, int count, int cursor, boolean trim_status, RequestListener listener) {
        WeiboParameters params = buildFriendsParam(count, cursor, trim_status);
        params.put("screen_name", screen_name);
        requestAsync(SERVER_URL_PRIX + "/friends.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 获取用户的粉丝列表(最多返回5000条数据)。
     *
     * @param uid       需要查询的用户UID
     * @param count     单页返回的记录条数，默认为50，最大不超过200
     * @param cursor    返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0
     * @param trim_status 返回值中user字段中的status字段开关，false：返回完整status字段、true：status字段仅返回status_id，默认为false
     * @param listener  异步请求回调接口
     */
    public void followers(long uid, int count, int cursor, boolean trim_status, RequestListener listener) {
        WeiboParameters params = buildFriendIDParam(uid, count);
        params.put("cursor", cursor);
        params.put("trim_status", trim_status ? 1: 0);
        requestAsync(SERVER_URL_PRIX + "/followers.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 获取用户的粉丝列表(最多返回5000条数据)。
     *
     * @param screen_name   需要查询的用户昵称
     * @param count         单页返回的记录条数，默认为50，最大不超过200
     * @param cursor        返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0
     * @param trim_status   返回值中user字段中的status字段开关，false：返回完整status字段、true：status字段仅返回status_id，默认为false
     * @param listener      异步请求回调接口
     */
    public void followers(String screen_name, int count, int cursor, boolean trim_status, RequestListener listener) {
        WeiboParameters params = buildFriendsParam(count, cursor, trim_status);
        params.put("screen_name", screen_name);
        requestAsync(SERVER_URL_PRIX + "/followers.json", params, HTTPMETHOD_GET, listener);
    }


    /** 组装Friends的参数 */
    private WeiboParameters buildFriendsParam(int count, int cursor, boolean trim_status) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("count", count);
        params.put("cursor", cursor);
        params.put("trim_status", trim_status ? 1: 0);
        return params;
    }

    /** 组装FriendsID的参数 */
    private WeiboParameters buildFriendIDParam(long uid, int count) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("uid", uid);
        params.put("count", count);
        return params;
    }
}
