package xr;

/* JADX INFO: loaded from: classes6.dex */
public class c1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.t f55832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.bouncycastle.oer.d f55833b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gm.t f55834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public org.bouncycastle.oer.d f55835b = org.bouncycastle.oer.d.f45570c;

        public c1 a() {
            return new c1(this.f55834a, this.f55835b);
        }

        public a b(long j10) {
            this.f55834a = new gm.t(j10);
            return this;
        }

        public a c(gm.t tVar) {
            this.f55834a = tVar;
            return this;
        }

        public a d(x1 x1Var) {
            this.f55835b = org.bouncycastle.oer.d.z(x1Var);
            return this;
        }
    }

    public c1(gm.t tVar, org.bouncycastle.oer.d dVar) {
        this.f55832a = tVar;
        this.f55833b = dVar;
    }

    public c1(gm.t tVar, x1 x1Var) {
        this.f55832a = tVar;
        this.f55833b = org.bouncycastle.oer.d.z(x1Var);
    }

    public static a x() {
        return new a();
    }

    public static c1 y(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof c1) {
            return (c1) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new c1(gm.t.I(f0VarJ.K(0)), org.bouncycastle.oer.d.z(f0VarJ.K(1)));
    }

    public org.bouncycastle.oer.d A() {
        return this.f55833b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(this.f55832a);
        org.bouncycastle.oer.d dVar = this.f55833b;
        if (dVar != null) {
            iVar.a(dVar);
        }
        return new gm.j2(iVar);
    }

    public gm.t z() {
        return this.f55832a;
    }
}
