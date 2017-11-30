package com.yphoto.zhzhi.yphoto;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.yphoto.zhzhi.yphoto.net.WeiboData;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener, WeiboAuthListener {

    // auth object
    SsoHandler ssoHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isSignedIn()) {
            // sign in already, show main activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_sign_in);

        RelativeLayout signin_btn = (RelativeLayout) findViewById(R.id.signin_btn);
        signin_btn.setOnClickListener(this);

        TextView github_btn = (TextView) findViewById(R.id.github_btn);
        github_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signin_btn) {  // sign in
            AuthInfo authInfo = new AuthInfo(this, WeiboData.APP_KEY, WeiboData.REDIRECT_URL, WeiboData.SCOPE);
            ssoHandler = new SsoHandler(this, authInfo);
            ssoHandler.authorize(this);

        } else if (v.getId() == R.id.github_btn) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sherlockchou86"));
            startActivity(browserIntent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (ssoHandler != null) {
            ssoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    @Override
    public void onComplete(Bundle bundle) {
        // 从 Bundle 中解析 Token
        Oauth2AccessToken accessToken = Oauth2AccessToken.parseAccessToken(bundle);
        if (accessToken.isSessionValid()) {
            // save accessToken
            WeiboData.writeAccessToken(this, accessToken);

            // sign in succeed, show main activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {

        }
    }

    @Override
    public void onWeiboException(WeiboException e) {
        Toast.makeText(this,
                "Auth exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCancel() {
        Toast.makeText(this,
                "用户取消授权", Toast.LENGTH_LONG).show();
    }

    private boolean isSignedIn() {
        Oauth2AccessToken token = WeiboData.readAccessToken(this);
        if (token != null && token.isSessionValid()) {
            return true;
        }
        return false;
    }
}
