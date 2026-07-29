package lm;

import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class s extends gm.w implements gm.g {
    public static final int A = 24;
    public static final int B = 25;
    public static final int C = 26;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39944c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39945d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f39946e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f39947f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f39948g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f39949h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f39950i = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f39951j = 7;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f39952k = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f39953l = 9;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f39954m = 10;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f39955n = 11;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f39956o = 12;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f39957p = 13;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f39958q = 14;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f39959r = 15;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f39960s = 16;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f39961t = 17;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f39962u = 18;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f39963v = 19;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f39964w = 20;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f39965x = 21;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f39966y = 22;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f39967z = 23;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f39969b;

    public s(int i10, gm.h hVar) {
        this.f39968a = i10;
        this.f39969b = x(i10, hVar);
    }

    public s(n0 n0Var) {
        int iQ = n0Var.q();
        this.f39968a = iQ;
        this.f39969b = x(iQ, n0Var.U());
    }

    public static gm.h x(int i10, gm.h hVar) {
        switch (i10) {
            case 0:
                return om.d.x(hVar);
            case 1:
                return g.y(hVar);
            case 2:
                return om.d.x(hVar);
            case 3:
                return g.y(hVar);
            case 4:
                return pn.e.y(hVar);
            case 5:
                return c0.x(hVar);
            case 6:
                return d0.x(hVar);
            case 7:
                return om.d.x(hVar);
            case 8:
                return g.y(hVar);
            case 9:
                return om.d.x(hVar);
            case 10:
                return p.z(hVar);
            case 11:
                return l0.x(hVar);
            case 12:
                return j0.z(hVar);
            case 13:
                return om.d.x(hVar);
            case 14:
                return g.y(hVar);
            case 15:
                return a.x(hVar);
            case 16:
                return b.x(hVar);
            case 17:
                return h0.A(hVar);
            case 18:
                return d.y(hVar);
            case 19:
                return t.x(hVar);
            case 20:
                return z.x(hVar);
            case 21:
                return m.x(hVar);
            case 22:
                return n.x(hVar);
            case 23:
                return l.A(hVar);
            case 24:
                return e.x(hVar);
            case 25:
                return f0.z(hVar);
            case 26:
                return e0.z(hVar);
            default:
                throw new IllegalArgumentException("unknown tag number: " + i10);
        }
    }

    public static s z(Object obj) {
        if (obj == null || (obj instanceof s)) {
            return (s) obj;
        }
        if (obj instanceof n0) {
            return new s((n0) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public int A() {
        return this.f39968a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(true, this.f39968a, this.f39969b);
    }

    public gm.h y() {
        return this.f39969b;
    }
}
