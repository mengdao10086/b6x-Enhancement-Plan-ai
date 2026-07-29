package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class j0 extends gm.w implements gm.g, j1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55935c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55936d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55937e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55938f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f55939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f55940b;

    public j0(int i10, gm.h hVar) {
        this.f55939a = i10;
        this.f55940b = hVar;
    }

    public static j0 x(Object obj) {
        if (obj instanceof j0) {
            return (j0) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        gm.c0 c0VarU = n0VarT.U();
        if (iQ == 0) {
            return new j0(iQ, m.z(c0VarU));
        }
        if (iQ == 1) {
            return new j0(iQ, l.z(c0VarU));
        }
        if (iQ == 2) {
            return new j0(iQ, i1.x(c0VarU));
        }
        if (iQ == 3) {
            return new j0(iQ, gm.z.I(c0VarU));
        }
        throw new IllegalArgumentException("unknown choice " + iQ);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55939a, (gm.w) this.f55940b).b();
    }
}
