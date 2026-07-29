package xr;

import gm.n2;

/* JADX INFO: loaded from: classes6.dex */
public class d0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f55843c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f55844d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f55845e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55846f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f55848b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.h f55850b;

        public d0 a() {
            return new d0(this.f55849a, this.f55850b);
        }

        public a b(byte[] bArr) {
            this.f55850b = new gm.f2(bArr);
            return this;
        }

        public a c(gm.z zVar) {
            this.f55850b = zVar;
            return this;
        }

        public a d(int i10) {
            this.f55849a = i10;
            return this;
        }

        public a e(gm.h hVar) {
            this.f55850b = hVar;
            return this;
        }

        public a f(gm.z zVar) {
            this.f55850b = zVar;
            return this;
        }
    }

    public d0(int i10, gm.h hVar) {
        this.f55847a = i10;
        this.f55848b = hVar;
    }

    public static d0 y(Object obj) {
        if (obj instanceof d0) {
            return (d0) obj;
        }
        gm.n0 n0VarT = gm.n0.T(obj);
        int iQ = n0VarT.q();
        if (iQ == 0 || iQ == 1 || iQ == 2 || iQ == 3) {
            return new d0(n0VarT.q(), gm.z.I(n0VarT.U()));
        }
        throw new IllegalStateException("unknown choice value " + n0VarT.q());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(this.f55847a, this.f55848b);
    }

    public int x() {
        return this.f55847a;
    }

    public gm.h z() {
        return this.f55848b;
    }
}
