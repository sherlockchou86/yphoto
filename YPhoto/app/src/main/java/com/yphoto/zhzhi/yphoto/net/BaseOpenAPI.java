package com.yphoto.zhzhi.yphoto.net;

import android.content.Context;
import android.text.TextUtils;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;

// copy from https://github.com/8tory/weibo-android-sdk/blob/master/weibo-android-sdk/src/main/java/com/sina/weibo/sdk/openapi/AbsOpenAPI.java

/**
 * 微博 OpenAPI 的基类，每个接口类都继承了此抽象类。
 *
 */
public abstract class BaseOpenAPI {
    private static final String TAG = BaseOpenAPI.class.getName();

    /** 访问微博服务接口的地址 */
    protected static final String API_SERVER       = "https://api.weibo.com/2";
    /** POST 请求方式 */
    protected static final String HTTPMETHOD_POST  = "POST";
    /** GET 请求方式 */
    protected static final String HTTPMETHOD_GET   = "GET";
    /** access token */
    protected static final String KEY_ACCESS_TOKEN = "access_token";

    /** 当前的 Token */
    protected Oauth2AccessToken mAccessToken;
    protected Context mContext;
    protected String mAppKey;

    /**
     * 构造函数，使用各个 API 接口提供的服务前必须先获取 Token。
     *
     * @param accessToken 访问令牌
     */
    public BaseOpenAPI(Context context, String appKey, Oauth2AccessToken accessToken) {
        mContext = context;
        mAppKey = appKey;
        mAccessToken = accessToken;
    }

    /**
     * HTTP 异步请求。
     *
     * @param url        请求的地址
     * @param params     请求的参数
     * @param httpMethod 请求方法
     * @param listener   请求后的回调接口
     */
    protected void requestAsync(String url, WeiboParameters params, String httpMethod, RequestListener listener) {
        if (null == mAccessToken
                || TextUtils.isEmpty(url)
                || null == params
                || TextUtils.isEmpty(httpMethod)
                || null == listener) {
            LogUtil.e(TAG, "Argument error!");
            return;
        }

        params.put(KEY_ACCESS_TOKEN, mAccessToken.getToken());
        new AsyncWeiboRunner(mContext).requestAsync(url, params, httpMethod, listener);
    }

    /**
     * HTTP 同步请求。
     *
     * @param url        请求的地址
     * @param params     请求的参数
     * @param httpMethod 请求方法
     *
     * @return 同步请求后，服务器返回的字符串。
     */
    protected String requestSync(String url, WeiboParameters params, String httpMethod) {
        if (null == mAccessToken
                || TextUtils.isEmpty(url)
                || null == params
                || TextUtils.isEmpty(httpMethod)) {
            LogUtil.e(TAG, "Argument error!");
            return "";
        }

        params.put(KEY_ACCESS_TOKEN, mAccessToken.getToken());
        return new AsyncWeiboRunner(mContext).request(url, params, httpMethod);
    }
}