package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class a1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z1 f55804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.t f55805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.t f55806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f55807d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z1 f55808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.t f55809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public gm.t f55810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public w f55811d;

        public a1 a() {
            return new a1(this.f55808a, this.f55809b, this.f55810c, this.f55811d);
        }

        public a b(long j10) {
            this.f55810c = new gm.t(j10);
            return this;
        }

        public a c(gm.t tVar) {
            this.f55810c = tVar;
            return this;
        }

        public a d(BigInteger bigInteger) {
            this.f55810c = new gm.t(bigInteger);
            return this;
        }

        public a e(w wVar) {
            this.f55811d = wVar;
            return this;
        }

        public a f(long j10) {
            this.f55809b = new gm.t(j10);
            return this;
        }

        public a g(gm.t tVar) {
            this.f55809b = tVar;
            return this;
        }

        public a h(BigInteger bigInteger) {
            this.f55809b = new gm.t(bigInteger);
            return this;
        }

        public a i(z1 z1Var) {
            this.f55808a = z1Var;
            return this;
        }
    }

    public a1(gm.f0 f0Var) {
        this.f55804a = z1.y(f0Var.K(0));
        this.f55805b = (gm.t) org.bouncycastle.oer.d.z(f0Var.K(1)).A(gm.t.class);
        this.f55806c = (gm.t) org.bouncycastle.oer.d.z(f0Var.K(2)).A(gm.t.class);
        this.f55807d = (w) org.bouncycastle.oer.d.z(f0Var.K(3)).A(w.class);
    }

    public a1(z1 z1Var, gm.t tVar, gm.t tVar2, w wVar) {
        this.f55804a = z1Var;
        this.f55805b = tVar;
        this.f55806c = tVar2;
        this.f55807d = wVar;
    }

    public static a1 A(Object obj) {
        if (obj instanceof a1) {
            return (a1) obj;
        }
        if (obj != null) {
            return new a1(gm.f0.J(obj));
        }
        return null;
    }

    public static a x() {
        return new a();
    }

    public gm.t B() {
        return this.f55805b;
    }

    public z1 C() {
        return this.f55804a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2(new gm.h[]{this.f55804a, org.bouncycastle.oer.d.z(this.f55805b), org.bouncycastle.oer.d.z(this.f55806c), org.bouncycastle.oer.d.z(this.f55807d)});
    }

    public gm.t y() {
        return this.f55806c;
    }

    public w z() {
        return this.f55807d;
    }
}
