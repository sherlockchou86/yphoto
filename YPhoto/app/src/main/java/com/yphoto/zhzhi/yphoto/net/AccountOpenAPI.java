package com.yphoto.zhzhi.yphoto.net;

import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

/**
 * Created by zhzhi on 11/24/2017.
 */

public class AccountOpenAPI extends BaseOpenAPI {
    private static final String SERVER_URL_PRIX = API_SERVER + "/account";


    public AccountOpenAPI(Context context, String appKey, Oauth2AccessToken accessToken) {
        super(context, appKey, accessToken);
    }

    /**
     * OAuth授权之后，获取授权用户的UID。
     *
     * @param listener 异步请求回调接口
     */
    public void getUid(RequestListener listener) {
        requestAsync(SERVER_URL_PRIX + "/get_uid.json", new WeiboParameters(mAppKey), HTTPMETHOD_GET, listener);
    }

    /**
     * 退出登录。
     *
     * @param listener 异步请求回调接口
     */
    public void endSession(RequestListener listener) {
        requestAsync(SERVER_URL_PRIX + "/end_session.json", new WeiboParameters(mAppKey), HTTPMETHOD_POST, listener);
    }
}
