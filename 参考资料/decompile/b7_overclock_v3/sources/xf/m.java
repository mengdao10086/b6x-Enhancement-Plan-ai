package xf;

import android.view.KeyEvent;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes7.dex */
public class m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f55271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f55272b;

    public m(WebView webView, n nVar) {
        this.f55271a = webView;
        this.f55272b = nVar;
    }

    public static final m b(WebView webView, n nVar) {
        return new m(webView, nVar);
    }

    @Override // xf.q
    public boolean a() {
        n nVar = this.f55272b;
        if (nVar != null && nVar.c()) {
            return true;
        }
        WebView webView = this.f55271a;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.f55271a.goBack();
        return true;
    }

    @Override // xf.q
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            return a();
        }
        return false;
    }
}
