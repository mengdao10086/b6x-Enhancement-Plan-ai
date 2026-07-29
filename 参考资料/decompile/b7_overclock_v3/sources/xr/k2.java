package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class k2 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55958c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55959d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55960e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f55962b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f55964b;

        public k2 a() {
            return new k2(this.f55963a, this.f55964b);
        }

        public a b(byte[] bArr) {
            this.f55964b = new gm.f2(bArr);
            this.f55963a = 2;
            return this;
        }

        public a c(e1 e1Var) {
            this.f55964b = e1Var;
            this.f55963a = 0;
            return this;
        }

        public a d(q qVar) {
            this.f55964b = qVar;
            this.f55963a = 1;
            return this;
        }

        public a e(int i10) {
            this.f55963a = i10;
            return this;
        }

        public a f(gm.h hVar) {
            this.f55964b = hVar;
            return this;
        }
    }

    public k2(int i10, gm.h hVar) {
        this.f55961a = i10;
        this.f55962b = hVar;
    }

    public static a x() {
        return new a();
    }

    public static k2 z(Object obj) {
        a aVarE;
        gm.h hVarA;
        if (obj instanceof k2) {
            return (k2) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0) {
            aVarE = new a().e(0);
            hVarA = e1.A(n0VarT.U());
        } else {
            if (iQ != 1) {
                if (iQ == 2) {
                    return new k2(2, gm.z.I(n0VarT.o()));
                }
                throw new IllegalArgumentException("unhandled tag " + n0VarT.q());
            }
            aVarE = new a().e(1);
            hVarA = q.A(n0VarT.U());
        }
        return aVarE.f(hVarA).a();
    }

    public gm.h A() {
        return this.f55962b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55961a, this.f55962b);
    }

    public int y() {
        return this.f55961a;
    }
}
