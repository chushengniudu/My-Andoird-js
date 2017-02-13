package com.liuzheng.admin.my_andoird_js;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * 作者：刘正
 * 时间：2017/2/13 0013
 * 作用：
 */

public class JsInterface {
    private WebView mWebView;

    public JsInterface(WebView webView) {
        this.mWebView = webView;
    }

    /**
     * java调用js方法
     */
    @JavascriptInterface
    public void javaFunction() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                //更新主循环中的UI，否则它将崩溃
                Toast.makeText(mWebView.getContext(), "javaFunction已被调用", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * js调用java方法
     */
    public void javaCallJsFunction(int code) {
        mWebView.loadUrl(String.format("javascript:javaCallJsFunction(" + code + ")"));
    }
}
