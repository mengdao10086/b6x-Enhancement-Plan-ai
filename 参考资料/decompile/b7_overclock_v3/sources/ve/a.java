package ve;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f53122a;

    public a(e eVar) {
        this.f53122a = eVar;
    }

    public abstract a a(e eVar);

    public abstract af.b b() throws NotFoundException;

    public abstract af.a c(int i10, af.a aVar) throws NotFoundException;

    public final int d() {
        return this.f53122a.b();
    }

    public final e e() {
        return this.f53122a;
    }

    public final int f() {
        return this.f53122a.e();
    }
}
