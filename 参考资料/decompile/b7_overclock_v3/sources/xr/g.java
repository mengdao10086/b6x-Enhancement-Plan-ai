package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class g extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55906c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55907d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55908e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55909f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55910g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f55912b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f55914b;

        public a a(gm.f2 f2Var) {
            this.f55913a = 1;
            this.f55914b = f2Var;
            return this;
        }

        public g b() {
            return new g(this.f55913a, this.f55914b);
        }

        public a c(byte[] bArr) {
            this.f55913a = 4;
            this.f55914b = new gm.f2(bArr);
            return this;
        }

        public a d(p0 p0Var) {
            this.f55913a = 0;
            this.f55914b = p0Var;
            return this;
        }

        public a e(h0 h0Var) {
            this.f55913a = 1;
            this.f55914b = h0Var;
            return this;
        }

        public a f() {
            this.f55913a = 1;
            this.f55914b = gm.d2.f29657b;
            return this;
        }

        public a g(int i10) {
            this.f55913a = i10;
            return this;
        }

        public a h(gm.h hVar) {
            this.f55914b = hVar;
            return this;
        }
    }

    public g(int i10, gm.h hVar) {
        this.f55911a = i10;
        this.f55912b = hVar;
    }

    public static a x() {
        return new a();
    }

    public static g z(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0) {
            return new g(iQ, p0.x(n0VarT.U()));
        }
        if (iQ == 1) {
            return new g(iQ, h0.x(n0VarT.U()));
        }
        if (iQ != 2) {
            if (iQ == 3) {
                return new g(iQ, n0VarT.U());
            }
            if (iQ != 4) {
                throw new IllegalArgumentException("unknown choice in CertificateId");
            }
        }
        return new g(iQ, gm.z.I(n0VarT.U()));
    }

    public gm.h A() {
        return this.f55912b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55911a, this.f55912b).b();
    }

    public int y() {
        return this.f55911a;
    }
}
