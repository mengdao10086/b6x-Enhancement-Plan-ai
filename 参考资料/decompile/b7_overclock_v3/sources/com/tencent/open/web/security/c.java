package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.a;
import com.tencent.open.log.SLog;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a.C0247a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f22841d;

    public c(WebView webView, long j10, String str, String str2) {
        super(webView, j10, str);
        this.f22841d = str2;
    }

    private void b(String str) {
        WebView webView = this.f22643a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f22841d);
            stringBuffer.append("){");
            stringBuffer.append(this.f22841d);
            stringBuffer.append(ee.a.f26978c);
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String string = stringBuffer.toString();
            SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + string);
            webView.loadUrl(string);
        }
    }

    @Override // com.tencent.open.a.C0247a
    public void a(Object obj) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.a.C0247a
    public void a() {
        SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.a.C0247a
    public void a(String str) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonNetImpl.RESULT, !com.tencent.open.c.c.f22730a ? -4 : 0);
            jSONObject.put("sn", this.f22644b);
            jSONObject.put("data", str);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
