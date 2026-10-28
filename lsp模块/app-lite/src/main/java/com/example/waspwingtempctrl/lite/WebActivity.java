package com.example.waspwingtempctrl.lite;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
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
    /** 与 style.css 的 --bg 保持一致，底部导航栏跟随主题底色 */
    private static final int BG_LIGHT = 0xFFF3F4F6;
    private static final int BG_DARK = 0xFF101418;
    private static final String THEME_LOG_PREFIX = "lite-theme:";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 首帧固定黑底，避免 WebView 默认白底闪一下
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
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
        webView.setBackgroundColor(Color.BLACK);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        // 主题三态（跟随/浅色/深色）存 localStorage，需开启 DOM storage；数据落在本应用私有目录
        settings.setDomStorageEnabled(true);
        // 只读包内资产：禁止 file 访问任意文件、禁止 file 跨域与 content 访问
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectSystemDark();
                syncNavBarFromPage(view);
            }

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

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage msg) {
                String text = msg != null ? msg.message() : null;
                if (text != null && text.startsWith(THEME_LOG_PREFIX)) {
                    applyNavBar("dark".equals(text.substring(THEME_LOG_PREFIX.length())));
                    return true;
                }
                return false;
            }
        });

        webView.addJavascriptInterface(new WebBridge(this), WebBridge.JS_NAME);
        setContentView(webView);
        // 首帧主题也由系统夜间模式决定，避免黑底淡入后再切深色
        webView.loadUrl(START_URL + (isSystemDark() ? "#dark" : "#light"));
    }

    private boolean isSystemDark() {
        int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return mode == Configuration.UI_MODE_NIGHT_YES;
    }

    /**
     * 注入系统夜间模式：WebView 的 prefers-color-scheme 跟随 Activity 主题，
     * 而本 Activity 固定浅色主题，故由原生侧判定后交给页面。
     */
    private void injectSystemDark() {
        final WebView view = webView;
        if (view == null) {
            return;
        }
        final boolean dark = isSystemDark();
        view.post(new Runnable() {
            @Override
            public void run() {
                if (webView == null) {
                    return;
                }
                String js = "window.__sysDark=" + (dark ? "true" : "false")
                        + ";(function(){var a=window.LiteApp;"
                        + "if(a&&a.applySysTheme){a.applySysTheme();}})();";
                webView.evaluateJavascript(js, null);
            }
        });
    }

    /** 页面加载完成时补一次：控制台消息万一没收到，也能把导航栏对上主题。 */
    private void syncNavBarFromPage(WebView view) {
        view.evaluateJavascript("(function(){return document.documentElement"
                + ".getAttribute('data-theme')==='dark'?'1':'0';})()",
                new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        if (value != null) {
                            applyNavBar(value.indexOf('1') >= 0);
                        }
                    }
                });
    }

    /** 底部导航栏取主题背景色，浅色主题同时把图标切深色，避免手势条区域割裂。 */
    private void applyNavBar(boolean dark) {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setNavigationBarColor(dark ? BG_DARK : BG_LIGHT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            View decor = window.getDecorView();
            int flags = decor.getSystemUiVisibility();
            flags = dark
                    ? (flags & ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR)
                    : (flags | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
            decor.setSystemUiVisibility(flags);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        injectSystemDark();
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
                String js = "(function(){var r=document.documentElement;"
                        + "if(r){r.className='booted';}"
                        + "var b=document.getElementById('banner');"
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
        tv.setBackgroundColor(Color.BLACK);
        tv.setTextColor(Color.WHITE);
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
