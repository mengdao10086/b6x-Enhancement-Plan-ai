package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class t1 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56042c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56043d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56044e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f56045f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f56047b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f56048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f56049b;

        public t1 a() {
            return new t1(this.f56048a, this.f56049b);
        }

        public a b(s sVar) {
            this.f56048a = 1;
            this.f56049b = sVar;
            return this;
        }

        public a c(t tVar) {
            this.f56048a = 3;
            this.f56049b = tVar;
            return this;
        }

        public a d(s sVar) {
            this.f56048a = 0;
            this.f56049b = sVar;
            return this;
        }
    }

    public t1(int i10, gm.h hVar) {
        this.f56046a = i10;
        this.f56047b = hVar;
    }

    public static a x() {
        return new a();
    }

    public static t1 z(Object obj) {
        gm.h hVarY;
        if (obj instanceof t1) {
            return (t1) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0 || iQ == 1) {
            hVarY = s.y(n0VarT.U());
        } else if (iQ == 2) {
            hVarY = gm.z.I(n0VarT.U());
        } else {
            if (iQ != 3) {
                throw new IllegalStateException("unknown choice " + n0VarT.q());
            }
            hVarY = t.x(n0VarT.U());
        }
        return new t1(n0VarT.q(), hVarY);
    }

    public gm.h A() {
        return this.f56047b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f56046a, this.f56047b);
    }

    public int y() {
        return this.f56046a;
    }
}
