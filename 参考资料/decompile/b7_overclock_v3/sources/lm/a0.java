package lm;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class a0 extends gm.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f39838b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39839c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39840d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f39841e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f39842f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f39843g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f39844h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a0 f39845i = new a0(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a0 f39846j = new a0(1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a0 f39847k = new a0(2);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a0 f39848l = new a0(3);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a0 f39849m = new a0(4);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a0 f39850n = new a0(5);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a0 f39851o = new a0(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f39852a;

    public a0(int i10) {
        this(new gm.t(i10));
    }

    public a0(gm.t tVar) {
        this.f39852a = tVar;
    }

    public static a0 x(Object obj) {
        if (obj instanceof a0) {
            return (a0) obj;
        }
        if (obj != null) {
            return new a0(gm.t.I(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39852a;
    }

    public BigInteger y() {
        return this.f39852a.K();
    }
}
