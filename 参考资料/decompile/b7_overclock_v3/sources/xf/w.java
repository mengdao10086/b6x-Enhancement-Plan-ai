package xf;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes7.dex */
public class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f55296a;

    public static w d() {
        return new w();
    }

    @Override // xf.v
    public void U() {
        h hVar = this.f55296a;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // xf.v
    public void a() {
        h hVar = this.f55296a;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // xf.v
    public void b(WebView webView, int i10) {
        if (i10 == 0) {
            f();
            return;
        }
        if (i10 > 0 && i10 <= 10) {
            a();
        } else if (i10 > 10 && i10 < 95) {
            setProgress(i10);
        } else {
            setProgress(i10);
            U();
        }
    }

    @Override // xf.v
    public h c() {
        return this.f55296a;
    }

    public w e(h hVar) {
        this.f55296a = hVar;
        return this;
    }

    public void f() {
        h hVar = this.f55296a;
        if (hVar != null) {
            hVar.reset();
        }
    }

    @Override // xf.v
    public void setProgress(int i10) {
        h hVar = this.f55296a;
        if (hVar != null) {
            hVar.setProgress(i10);
        }
    }
}
