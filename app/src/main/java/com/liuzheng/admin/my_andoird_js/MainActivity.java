package com.liuzheng.admin.my_andoird_js;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button button1;
    private WebView mWevView;
    private JsInterface jsInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button_view);
        mWevView = (WebView) findViewById(R.id.webview_view);

        jsInterface = new JsInterface(mWevView);
        mWevView.getSettings().setJavaScriptEnabled(true);
        mWevView.addJavascriptInterface(jsInterface, "JSInterface");
        mWevView.setWebViewClient(new webviewClient());
        mWevView.loadUrl("file:///android_asset/index.html");
    }


    class webviewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    jsInterface.javaCallJsFunction(1);
                }
            });
        }
    }
}
