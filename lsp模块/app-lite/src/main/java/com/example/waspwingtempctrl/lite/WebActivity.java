package com.example.waspwingtempctrl.lite;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * 极简版唯一界面：单 WebView 加载包内占位页，桥见 {@link WebBridge}。
 * 真前端由 L2b 写，这里只保证「页面能起、桥能通」。
 */
public final class WebActivity extends Activity {

    private static final String START_URL = "file:///android_asset/webui/index.html";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        // 只读包内资产：禁止 file 访问任意文件、禁止 file 跨域与 content 访问
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);

        webView.addJavascriptInterface(new WebBridge(this), WebBridge.JS_NAME);
        setContentView(webView);
        webView.loadUrl(START_URL);
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}
