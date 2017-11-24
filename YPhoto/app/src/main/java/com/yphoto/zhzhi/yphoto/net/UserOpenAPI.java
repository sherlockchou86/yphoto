package com.yphoto.zhzhi.yphoto.net;

import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

/**
 * Created by zhzhi on 11/24/2017.
 */

public class UserOpenAPI extends BaseOpenAPI {
    private static final String SERVER_URL_PRIX = API_SERVER + "/users";


    public UserOpenAPI(Context context, String appKey, Oauth2AccessToken accessToken) {
        super(context, appKey, accessToken);
    }

    /**
     * 根据用户ID获取用户信息。
     *
     * @param uid      需要查询的用户ID
     * @param listener 异步请求回调接口
     */
    public void show(long uid, RequestListener listener) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("uid", uid);
        requestAsync(SERVER_URL_PRIX + "/show.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 根据用户昵称获取用户信息。
     *
     * @param screen_name 需要查询的用户昵称
     * @param listener    异步请求回调接口
     */
    public void show(String screen_name, RequestListener listener) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("screen_name", screen_name);
        requestAsync(SERVER_URL_PRIX + "/show.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 通过个性化域名获取用户资料以及用户最新的一条微博。
     *
     * @param domain   需要查询的个性化域名（请注意：是http://weibo.com/xxx后面的xxx部分）
     * @param listener 异步请求回调接口
     */
    public void domainShow(String domain, RequestListener listener) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("domain", domain);
        requestAsync(SERVER_URL_PRIX  + "/domain_show.json", params, HTTPMETHOD_GET, listener);
    }

    /**
     * 批量获取用户的粉丝数、关注数、微博数。
     *
     * @param uids     需要获取数据的用户UID，多个之间用逗号分隔，最多不超过100个
     * @param listener 异步请求回调接口
     */
    public void counts(long[] uids, RequestListener listener) {
        WeiboParameters params = buildCountsParams(uids);
        requestAsync(SERVER_URL_PRIX + "/counts.json", params, HTTPMETHOD_GET, listener);
    }


    private WeiboParameters buildCountsParams(long[] uids) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        StringBuilder strb = new StringBuilder();
        for (long cid : uids) {
            strb.append(cid).append(",");
        }
        strb.deleteCharAt(strb.length() - 1);
        params.put("uids", strb.toString());
        return params;
    }
}
