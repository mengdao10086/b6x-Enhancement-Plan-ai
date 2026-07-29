package xr;

/* JADX INFO: loaded from: classes6.dex */
public class j2 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.t f55941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f55942b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gm.t f55943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o f55944b;

        public j2 a() {
            return new j2(this.f55943a, this.f55944b);
        }

        public a b(o oVar) {
            this.f55944b = oVar;
            return this;
        }

        public a c(gm.t tVar) {
            this.f55943a = tVar;
            return this;
        }
    }

    public j2(gm.t tVar, o oVar) {
        this.f55941a = tVar;
        this.f55942b = oVar;
    }

    public static a x() {
        return new a();
    }

    public static j2 z(Object obj) {
        if (obj instanceof j2) {
            return (j2) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new a().c(gm.t.I(f0VarJ.K(0))).b(o.x(f0VarJ.K(1))).a();
    }

    public gm.t A() {
        return this.f55941a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2(new gm.h[]{this.f55941a, this.f55942b});
    }

    public o y() {
        return this.f55942b;
    }
}
