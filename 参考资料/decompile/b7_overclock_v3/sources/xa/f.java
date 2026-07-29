package xa;

import java.util.List;
import xa.h;

/* JADX INFO: loaded from: classes3.dex */
public class f extends h.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static h<f> f54982e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f54983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f54984d;

    static {
        h<f> hVarA = h.a(64, new f(0.0d, 0.0d));
        f54982e = hVarA;
        hVarA.l(0.5f);
    }

    public f(double d10, double d11) {
        this.f54983c = d10;
        this.f54984d = d11;
    }

    public static f b(double d10, double d11) {
        f fVar = (f) f54982e.b();
        fVar.f54983c = d10;
        fVar.f54984d = d11;
        return fVar;
    }

    public static void c(f fVar) {
        f54982e.h(fVar);
    }

    public static void d(List<f> list) {
        f54982e.g(list);
    }

    @Override // xa.h.a
    public h.a a() {
        return new f(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.f54983c + ", y: " + this.f54984d;
    }
}
