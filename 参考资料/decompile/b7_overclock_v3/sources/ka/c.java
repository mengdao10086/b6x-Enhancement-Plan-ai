package ka;

import android.graphics.Paint;
import xa.g;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class c extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f37114h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f37113g = "Description Label";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint.Align f37115i = Paint.Align.RIGHT;

    public c() {
        this.f37111e = k.e(8.0f);
    }

    public g m() {
        return this.f37114h;
    }

    public String n() {
        return this.f37113g;
    }

    public Paint.Align o() {
        return this.f37115i;
    }

    public void p(float f10, float f11) {
        g gVar = this.f37114h;
        if (gVar == null) {
            this.f37114h = g.c(f10, f11);
        } else {
            gVar.f54987c = f10;
            gVar.f54988d = f11;
        }
    }

    public void q(String str) {
        this.f37113g = str;
    }

    public void r(Paint.Align align) {
        this.f37115i = align;
    }
}
