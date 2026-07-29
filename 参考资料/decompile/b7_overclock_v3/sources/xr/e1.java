package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class e1 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55880c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55881d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55882e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55883f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f55885b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f55887b;

        public e1 a() {
            return new e1(this.f55886a, this.f55887b);
        }

        public a b(q qVar) {
            this.f55887b = qVar;
            return this;
        }

        public a c(r rVar) {
            this.f55887b = rVar;
            return this;
        }

        public a d(q qVar) {
            this.f55887b = qVar;
            return this;
        }

        public a e(byte[] bArr) {
            this.f55887b = new gm.f2(bArr);
            return this;
        }

        public a f(int i10) {
            this.f55886a = i10;
            return this;
        }

        public a g(p pVar) {
            this.f55887b = pVar;
            return this;
        }
    }

    public e1(int i10, gm.h hVar) {
        this.f55884a = i10;
        this.f55885b = hVar;
    }

    public static e1 A(Object obj) {
        gm.h hVarA;
        if (obj instanceof e1) {
            return (e1) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0 || iQ == 1) {
            hVarA = q.A(n0VarT.U());
        } else if (iQ == 2) {
            hVarA = gm.z.I(n0VarT.U());
        } else {
            if (iQ != 3) {
                throw new IllegalArgumentException("unknown tag value " + n0VarT.q());
            }
            hVarA = r.A(n0VarT.U());
        }
        return new e1(n0VarT.q(), hVarA);
    }

    public static a x() {
        return new a();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55884a, this.f55885b);
    }

    public int y() {
        return this.f55884a;
    }

    public gm.h z() {
        return this.f55885b;
    }
}
