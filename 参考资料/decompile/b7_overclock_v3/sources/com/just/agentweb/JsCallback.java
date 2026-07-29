package com.just.agentweb;

import android.webkit.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public class JsCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f21844f = "javascript:%s.callback(%d, %d %s);";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21846b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<WebView> f21847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f21849e;

    public static class JsCallbackException extends Exception {
        public JsCallbackException(String str) {
            super(str);
        }
    }

    public JsCallback(WebView webView, String str, int i10) {
        this.f21847c = new WeakReference<>(webView);
        this.f21849e = str;
        this.f21845a = i10;
    }

    public void a(Object... objArr) throws JsCallbackException {
        if (this.f21847c.get() == null) {
            throw new JsCallbackException("the WebView related to the JsCallback has been recycled");
        }
        if (!this.f21846b) {
            throw new JsCallbackException("the JsCallback isn't permanent,cannot be called more than once");
        }
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            sb2.append(ag.c.f654g);
            boolean z10 = obj instanceof String;
            boolean zB = b(obj);
            if (z10 && !zB) {
                sb2.append("\"");
            }
            sb2.append(String.valueOf(obj));
            if (z10 && !zB) {
                sb2.append("\"");
            }
        }
        String str = String.format(f21844f, this.f21849e, Integer.valueOf(this.f21845a), Integer.valueOf(this.f21848d), sb2.toString());
        c0.d();
        this.f21847c.get().loadUrl(str);
        this.f21846b = this.f21848d > 0;
    }

    public final boolean b(Object obj) {
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return true;
        }
        String string = obj.toString();
        try {
            try {
                new JSONObject(string);
            } catch (JSONException unused) {
                new JSONArray(string);
            }
            return true;
        } catch (JSONException unused2) {
            return false;
        }
    }

    public void c(boolean z10) {
        this.f21848d = z10 ? 1 : 0;
    }
}
