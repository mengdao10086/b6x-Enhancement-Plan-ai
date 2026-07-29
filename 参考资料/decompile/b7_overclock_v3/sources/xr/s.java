package xr;

/* JADX INFO: loaded from: classes6.dex */
public class s extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f56022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.z f56023b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q f56024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.z f56025b;

        public s a() {
            return new s(this.f56024a, this.f56025b);
        }

        public a b(q qVar) {
            this.f56024a = qVar;
            return this;
        }

        public a c(gm.z zVar) {
            this.f56025b = zVar;
            return this;
        }
    }

    public s(q qVar, gm.z zVar) {
        this.f56022a = qVar;
        this.f56023b = zVar;
    }

    public static a x() {
        return new a();
    }

    public static s y(Object obj) {
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new a().b(q.A(f0VarJ.K(0))).c(gm.z.I(f0VarJ.K(1))).a();
    }

    public gm.z A() {
        return this.f56023b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f56022a, this.f56023b);
    }

    public q z() {
        return this.f56022a;
    }
}
