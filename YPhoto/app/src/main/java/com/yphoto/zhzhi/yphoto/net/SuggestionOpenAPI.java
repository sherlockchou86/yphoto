package com.yphoto.zhzhi.yphoto.net;

import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

/**
 * Created by zhzhi on 12/6/2017.
 */

public class SuggestionOpenAPI extends BaseOpenAPI {
    private static final String SERVER_URL_PRIX = API_SERVER + "/suggestions";


    public SuggestionOpenAPI(Context context, String appKey, Oauth2AccessToken accessToken) {
        super(context, appKey, accessToken);
    }

    public void findUsers(String q, RequestListener listener) {
        WeiboParameters params = new WeiboParameters(mAppKey);
        params.put("q", q);
        requestAsync(SERVER_URL_PRIX + "/users.json", params, HTTPMETHOD_GET, listener);
    }
}
