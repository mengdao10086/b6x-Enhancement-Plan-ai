package xf;

import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes7.dex */
public class e0 extends r0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e0 f55222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f55223d;

    public e0(e0 e0Var) {
        super(e0Var);
        this.f55223d = getClass().getSimpleName();
        this.f55222c = e0Var;
    }

    @Override // xf.r0
    public final void b(WebViewClient webViewClient) {
        super.b(webViewClient);
    }

    public final e0 c(e0 e0Var) {
        b(e0Var);
        this.f55222c = e0Var;
        return e0Var;
    }

    public final e0 d() {
        return this.f55222c;
    }

    public e0(WebViewClient webViewClient) {
        super(webViewClient);
        this.f55223d = getClass().getSimpleName();
    }

    public e0() {
        super(null);
        this.f55223d = getClass().getSimpleName();
    }
}
