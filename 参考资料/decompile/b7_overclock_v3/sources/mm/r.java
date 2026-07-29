package mm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f41380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f41381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.o0 f41382c;

    public r(gm.g0 g0Var) throws IOException {
        this.f41380a = (gm.y) g0Var.readObject();
        this.f41381b = zn.b.z(g0Var.readObject().b());
        this.f41382c = (gm.o0) g0Var.readObject();
    }

    public zn.b a() {
        return this.f41381b;
    }

    public gm.y b() {
        return this.f41380a;
    }

    public gm.h c(int i10) throws IOException {
        return gm.v0.p(this.f41382c, 0, false, i10);
    }
}
