package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class s1 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56028c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56029d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56030e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f56032b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f56033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f56034b;

        public a a(gm.z zVar) {
            return e(2).f(zVar);
        }

        public s1 b() {
            return new s1(this.f56033a, this.f56034b);
        }

        public a c(byte[] bArr) {
            return e(2).f(new gm.f2(bArr));
        }

        public a d() {
            return e(0);
        }

        public a e(int i10) {
            this.f56033a = i10;
            return this;
        }

        public a f(gm.h hVar) {
            this.f56034b = hVar;
            return this;
        }
    }

    public s1(int i10, gm.h hVar) {
        this.f56031a = i10;
        this.f56032b = hVar;
    }

    public static a x() {
        return new a();
    }

    public static s1 z(Object obj) {
        if (obj instanceof s1) {
            return (s1) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0 || iQ == 1) {
            return new s1(n0VarT.q(), gm.z.I(n0VarT.U()));
        }
        if (iQ == 2) {
            return new s1(n0VarT.q(), gm.z.I(n0VarT.U()));
        }
        throw new IllegalArgumentException("unknown choice " + n0VarT.q());
    }

    public gm.h A() {
        return this.f56032b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f56031a, this.f56032b);
    }

    public int y() {
        return this.f56031a;
    }
}
