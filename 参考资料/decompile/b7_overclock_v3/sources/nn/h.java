package nn;

import gm.c0;
import gm.w;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class h extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42270b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42271c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42272d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42273e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f42274f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f42275g = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.k f42276a;

    public h(int i10) {
        this(new gm.k(i10));
    }

    public h(gm.k kVar) {
        this.f42276a = kVar;
    }

    public static h x(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(gm.k.I(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f42276a;
    }

    public int y() {
        return this.f42276a.M();
    }

    public BigInteger z() {
        return this.f42276a.J();
    }
}
