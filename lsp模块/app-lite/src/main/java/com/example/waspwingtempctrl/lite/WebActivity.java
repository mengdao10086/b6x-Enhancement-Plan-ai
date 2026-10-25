package com.example.waspwingtempctrl.lite;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * 极简版唯一界面：单 WebView 加载包内页面，桥见 {@link WebBridge}。
 *
 * <p>兜底：WebView 提供器缺失/被 ROM 禁用时创建会抛异常，这里改为显示可读提示，
 * 不让 Activity 直接崩或白屏；页面加载失败与 JS 运行时错误都写进页面内的 {@code #banner}。
 */
public final class WebActivity extends Activity {

    private static final String TAG = "WaspWingLite";
    private static final String START_URL = "file:///android_asset/webui/index.html";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            webView = new WebView(this);
        } catch (Throwable t) {
            Log.e(TAG, "WebView 创建失败", t);
            showFallback(t);
            return;
        }
        try {
            setupWebView();
        } catch (Throwable t) {
            Log.e(TAG, "WebView 初始化失败", t);
            showFallback(t);
        }
    }

    private void setupWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        // 只读包内资产：禁止 file 访问任意文件、禁止 file 跨域与 content 访问
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request,
                                        WebResourceError error) {
                if (request != null && request.isForMainFrame()) {
                    int code = error != null ? error.getErrorCode() : -1;
                    CharSequence desc = error != null ? error.getDescription() : "";
                    reportToBanner("页面加载失败（" + code + "）：" + desc);
                }
            }
        });

        webView.addJavascriptInterface(new WebBridge(this), WebBridge.JS_NAME);
        setContentView(webView);
        webView.loadUrl(START_URL);
    }

    /** 把错误写进页面里的 {@code #banner}；页面没起来时尽力建一个。 */
    private void reportToBanner(final String message) {
        Log.e(TAG, message);
        final WebView view = webView;
        if (view == null) {
            return;
        }
        view.post(new Runnable() {
            @Override
            public void run() {
                String js = "(function(){var b=document.getElementById('banner');"
                        + "if(!b&&document.body){b=document.createElement('div');b.id='banner';"
                        + "document.body.appendChild(b);}if(!b){return;}"
                        + "b.className='banner';b.textContent="
                        + JSONObject.quote(message) + ";})()";
                view.evaluateJavascript(js, null);
            }
        });
    }

    /** WebView 不可用时的可读兜底，避免白屏/崩溃。 */
    private void showFallback(Throwable t) {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        TextView tv = new TextView(this);
        tv.setText("无法启动内嵌页面：系统 WebView 不可用。\n\n"
                + "请在系统设置中启用「Android System WebView」"
                + "（设置 → 应用 → 显示系统应用 → Android System WebView），"
                + "然后重新打开本应用。\n\n错误：" + t);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        tv.setPadding(dp(20), dp(40), dp(20), dp(20));
        tv.setGravity(Gravity.START);
        setContentView(tv);
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
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
