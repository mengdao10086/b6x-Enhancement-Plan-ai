package xf;

import android.app.Activity;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import com.just.agentweb.AgentWeb;

/* JADX INFO: loaded from: classes7.dex */
public class f extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AgentWeb f55224g;

    @Override // xf.a, xf.p0
    public p0 b(WebView webView, DownloadListener downloadListener) {
        Object objInvoke = null;
        try {
            objInvoke = Class.forName("com.just.agentweb.download.DefaultDownloadImpl").getDeclaredMethod("create", Activity.class, WebView.class, com.just.agentweb.download.d.class, com.just.agentweb.download.h.class, g0.class).invoke(null, (Activity) webView.getContext(), webView, null, null, this.f55224g.q());
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
        if (objInvoke != null) {
            downloadListener = (DownloadListener) objInvoke;
        }
        return super.b(webView, downloadListener);
    }

    @Override // xf.a
    public void g(AgentWeb agentWeb) {
        this.f55224g = agentWeb;
    }
}
