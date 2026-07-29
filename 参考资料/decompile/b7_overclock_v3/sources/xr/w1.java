package xr;

import gm.n2;
import xr.e0;

/* JADX INFO: loaded from: classes6.dex */
public class w1 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f56086c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f56087d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f56088e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f56089f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f56091b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gm.h f56092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f56093b;

        public w1 a() {
            return new w1(this.f56093b, this.f56092a);
        }

        public a b(k1 k1Var) {
            this.f56093b = 1;
            this.f56092a = k1Var;
            return this;
        }

        public a c(e0.d dVar) {
            this.f56093b = 0;
            this.f56092a = dVar;
            return this;
        }

        public a d(byte[] bArr) {
            this.f56093b = 3;
            this.f56092a = new gm.f2(bArr);
            return this;
        }

        public a e() {
            this.f56093b = 2;
            this.f56092a = gm.d2.f29657b;
            return this;
        }

        public a f(int i10) {
            this.f56093b = i10;
            return this;
        }

        public a g(gm.h hVar) {
            this.f56092a = hVar;
            return this;
        }
    }

    public w1(int i10, gm.h hVar) {
        this.f56090a = i10;
        this.f56091b = hVar;
    }

    public static a x() {
        return new a();
    }

    public static final w1 z(Object obj) {
        if (obj instanceof w1) {
            return (w1) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0) {
            return new w1(n0VarT.q(), e0.x(n0VarT.U()));
        }
        if (iQ == 1) {
            return new w1(n0VarT.q(), k1.z(n0VarT.U()));
        }
        throw new IllegalArgumentException("unknown choice " + n0VarT.q());
    }

    public gm.h A() {
        return this.f56091b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f56090a, this.f56091b);
    }

    public int y() {
        return this.f56090a;
    }
}
