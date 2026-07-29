package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class a0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55797c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55798d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55799e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55800f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55801g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f55802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f55803b;

    public a0(int i10, gm.h hVar) {
        this.f55802a = i10;
        this.f55803b = hVar;
    }

    public static a0 y(Object obj) {
        if (obj instanceof a0) {
            return (a0) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0) {
            return new a0(iQ, i.y(n0VarT.U()));
        }
        if (iQ == 1) {
            return new a0(iQ, r1.x(n0VarT.U()));
        }
        if (iQ == 2) {
            return new a0(iQ, x0.x(n0VarT.U()));
        }
        if (iQ == 3) {
            return new a0(iQ, l1.y(n0VarT.U()));
        }
        if (iQ == 4) {
            return new a0(iQ, gm.z.I(n0VarT.U()));
        }
        throw new IllegalStateException("unknown region choice " + iQ);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55802a, this.f55803b);
    }

    public int x() {
        return this.f55802a;
    }

    public gm.h z() {
        return this.f55803b;
    }
}
