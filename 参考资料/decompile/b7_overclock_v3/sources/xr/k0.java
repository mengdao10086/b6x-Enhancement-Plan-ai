package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class k0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55947c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55948d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55949e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55950f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f55951g = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f55953b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f55955b;

        public k0 a() {
            return new k0(this.f55954a, this.f55955b);
        }

        public a b(u uVar) {
            this.f55955b = uVar;
            this.f55954a = 2;
            return this;
        }

        public a c(byte[] bArr) {
            this.f55955b = new gm.f2(bArr);
            this.f55954a = 4;
            return this;
        }

        public a d(int i10) {
            this.f55954a = i10;
            return this;
        }

        public a e(gm.h hVar) {
            this.f55955b = hVar;
            return this;
        }

        public a f(gm.z zVar) {
            this.f55955b = zVar;
            this.f55954a = 3;
            return this;
        }

        public a g(u1 u1Var) {
            this.f55955b = u1Var;
            this.f55954a = 1;
            return this;
        }

        public a h(gm.z zVar) {
            this.f55955b = zVar;
            this.f55954a = 0;
            return this;
        }
    }

    public k0(int i10, gm.h hVar) {
        this.f55952a = i10;
        this.f55953b = hVar;
    }

    public static a x() {
        return new a();
    }

    public static k0 z(Object obj) {
        if (obj instanceof k0) {
            return (k0) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ != 0) {
            if (iQ == 1) {
                return new k0(n0VarT.q(), u1.z(n0VarT.U()));
            }
            if (iQ == 2) {
                return new k0(n0VarT.q(), u.y(n0VarT.U()));
            }
            if (iQ != 3 && iQ != 4) {
                throw new IllegalArgumentException("unknown tag value " + n0VarT.q());
            }
        }
        return new k0(n0VarT.q(), gm.z.I(n0VarT.U()));
    }

    public gm.h A() {
        return this.f55953b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55952a, this.f55953b);
    }

    public int y() {
        return this.f55952a;
    }
}
