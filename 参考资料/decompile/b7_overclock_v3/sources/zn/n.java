package zn;

/* JADX INFO: loaded from: classes5.dex */
public class n extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f58860a;

    public n(gm.y yVar) {
        this.f58860a = yVar;
    }

    public static n y(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(gm.y.N(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58860a;
    }

    public String x() {
        return this.f58860a.L();
    }
}
