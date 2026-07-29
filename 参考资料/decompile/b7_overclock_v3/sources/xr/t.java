package xr;

/* JADX INFO: loaded from: classes6.dex */
public class t extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f56035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.z f56036b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r f56037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gm.z f56038b;

        public t a() {
            return new t(this.f56037a, this.f56038b);
        }

        public a b(r rVar) {
            this.f56037a = rVar;
            return this;
        }

        public a c(gm.z zVar) {
            this.f56038b = zVar;
            return this;
        }
    }

    public t(r rVar, gm.z zVar) {
        this.f56035a = rVar;
        this.f56036b = zVar;
    }

    public static t x(Object obj) {
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new a().b(r.A(f0VarJ.K(0))).c(gm.z.I(f0VarJ.K(1))).a();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f56035a, this.f56036b);
    }

    public r y() {
        return this.f56035a;
    }

    public gm.z z() {
        return this.f56036b;
    }
}
