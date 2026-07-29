package zn;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f58970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.z f58971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gm.y f58946c = new gm.y("2.5.29.9");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gm.y f58947d = new gm.y("2.5.29.14");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gm.y f58948e = new gm.y("2.5.29.15");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final gm.y f58949f = new gm.y("2.5.29.16");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gm.y f58950g = new gm.y("2.5.29.17");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gm.y f58951h = new gm.y("2.5.29.18");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final gm.y f58952i = new gm.y("2.5.29.19");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final gm.y f58953j = new gm.y("2.5.29.20");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final gm.y f58954k = new gm.y("2.5.29.21");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final gm.y f58955l = new gm.y("2.5.29.23");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final gm.y f58956m = new gm.y("2.5.29.24");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final gm.y f58957n = new gm.y("2.5.29.27");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final gm.y f58958o = new gm.y("2.5.29.28");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final gm.y f58959p = new gm.y("2.5.29.29");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final gm.y f58960q = new gm.y("2.5.29.30");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final gm.y f58961r = new gm.y("2.5.29.31");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final gm.y f58962s = new gm.y("2.5.29.32");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final gm.y f58963t = new gm.y("2.5.29.33");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final gm.y f58964u = new gm.y("2.5.29.35");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final gm.y f58965v = new gm.y("2.5.29.36");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final gm.y f58966w = new gm.y("2.5.29.37");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final gm.y f58967x = new gm.y("2.5.29.46");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final gm.y f58968y = new gm.y("2.5.29.54");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final gm.y f58969z = new gm.y("1.3.6.1.5.5.7.1.1");
    public static final gm.y A = new gm.y("1.3.6.1.5.5.7.1.11");
    public static final gm.y B = new gm.y("1.3.6.1.5.5.7.1.12");
    public static final gm.y C = new gm.y("1.3.6.1.5.5.7.1.2");
    public static final gm.y D = new gm.y("1.3.6.1.5.5.7.1.3");
    public static final gm.y E = new gm.y("1.3.6.1.5.5.7.1.4");
    public static final gm.y F = new gm.y("2.5.29.56");
    public static final gm.y G = new gm.y("2.5.29.55");

    public t1(gm.f fVar, gm.z zVar) {
        this.f58970a = fVar.L();
        this.f58971b = zVar;
    }

    public t1(boolean z10, gm.z zVar) {
        this.f58970a = z10;
        this.f58971b = zVar;
    }

    public static gm.c0 a(t1 t1Var) throws IllegalArgumentException {
        try {
            return gm.c0.D(t1Var.c().J());
        } catch (IOException e10) {
            throw new IllegalArgumentException("can't convert extension: " + e10);
        }
    }

    public gm.h b() {
        return a(this);
    }

    public gm.z c() {
        return this.f58971b;
    }

    public boolean d() {
        return this.f58970a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return t1Var.c().C(c()) && t1Var.d() == d();
    }

    public int hashCode() {
        return d() ? c().hashCode() : ~c().hashCode();
    }
}
