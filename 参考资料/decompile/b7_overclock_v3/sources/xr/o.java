package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class o extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55985c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55986d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55987e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55988f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55989g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f55990h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f55991i = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f55993b;

    public o(int i10, int i11) {
        this.f55992a = i10;
        this.f55993b = i11;
    }

    public static o x(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        switch (iQ) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                try {
                    return new o(iQ, gm.t.I(n0VarT.U()).K().intValue());
                } catch (Exception e10) {
                    throw new IllegalStateException(e10.getMessage(), e10);
                }
            default:
                throw new IllegalArgumentException("invalid choice value " + iQ);
        }
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55992a, new gm.t(this.f55993b));
    }

    public int y() {
        return this.f55992a;
    }

    public int z() {
        return this.f55993b;
    }
}
