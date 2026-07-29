package xf;

import android.webkit.WebChromeClient;

/* JADX INFO: loaded from: classes7.dex */
public class d0 extends l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f55215b;

    public d0(WebChromeClient webChromeClient) {
        super(webChromeClient);
    }

    @Override // xf.l0
    public final void g(WebChromeClient webChromeClient) {
        super.g(webChromeClient);
    }

    public final d0 h(d0 d0Var) {
        g(d0Var);
        this.f55215b = d0Var;
        return d0Var;
    }

    public final d0 i() {
        return this.f55215b;
    }

    public d0() {
        super(null);
    }
}
