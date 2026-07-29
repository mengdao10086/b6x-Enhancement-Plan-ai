package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class b extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55813c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55814d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55815e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f55817b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f55819b;

        public b a() {
            return new b(this.f55818a, this.f55819b);
        }

        public a b(int i10) {
            this.f55818a = i10;
            return this;
        }

        public a c(p pVar) {
            this.f55819b = pVar;
            return this;
        }
    }

    public b(int i10, gm.h hVar) {
        this.f55816a = i10;
        this.f55817b = hVar;
    }

    public static b y(Object obj) {
        gm.h hVarA;
        if (obj instanceof b) {
            return (b) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0 || iQ == 1) {
            hVarA = q.A(n0VarT.U());
        } else {
            if (iQ != 2) {
                throw new IllegalStateException("unknown choice " + n0VarT.q());
            }
            hVarA = gm.z.I(n0VarT.U());
        }
        return new b(n0VarT.q(), hVarA);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55816a, this.f55817b);
    }

    public int x() {
        return this.f55816a;
    }

    public gm.h z() {
        return this.f55817b;
    }
}
