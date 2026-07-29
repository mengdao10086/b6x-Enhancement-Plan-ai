package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class n0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55975c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55976d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55977e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55978f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f55980b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f55982b;

        public n0 a() {
            return new n0(this.f55981a, this.f55982b);
        }

        public a b(byte[] bArr) {
            this.f55981a = 2;
            this.f55982b = new gm.f2(bArr);
            return this;
        }

        public a c(c0 c0Var) {
            this.f55981a = 1;
            this.f55982b = c0Var;
            return this;
        }

        public a d(int i10) {
            this.f55981a = i10;
            return this;
        }

        public a e(gm.h hVar) {
            this.f55982b = hVar;
            return this;
        }

        public a f(e0 e0Var) {
            this.f55981a = 0;
            this.f55982b = e0Var;
            return this;
        }

        public a g(e0 e0Var) {
            this.f55981a = 3;
            this.f55982b = e0Var;
            return this;
        }
    }

    public n0(int i10, gm.h hVar) {
        this.f55979a = i10;
        this.f55980b = hVar;
    }

    public static a x() {
        return new a();
    }

    public static n0 z(Object obj) {
        if (obj instanceof n0) {
            return (n0) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0) {
            return new n0(0, e0.x(n0VarT.U()));
        }
        if (iQ == 1) {
            return new n0(1, c0.x(n0VarT.U()));
        }
        if (iQ == 2) {
            return new n0(2, gm.z.I(n0VarT.U()));
        }
        if (iQ == 3) {
            return new n0(3, e0.x(n0VarT.U()));
        }
        throw new IllegalArgumentException("unable to decode into known choice" + iQ);
    }

    public gm.h A() {
        return this.f55980b;
    }

    public boolean B() {
        return this.f55979a == 1;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55979a, this.f55980b);
    }

    public int y() {
        return this.f55979a;
    }
}
