package mm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f41365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.o0 f41366b;

    public o(gm.g0 g0Var) throws IOException {
        this.f41365a = (gm.y) g0Var.readObject();
        this.f41366b = (gm.o0) g0Var.readObject();
    }

    public gm.h a(int i10) throws IOException {
        gm.o0 o0Var = this.f41366b;
        if (o0Var != null) {
            return gm.v0.s(o0Var, 0);
        }
        return null;
    }

    public gm.y b() {
        return this.f41365a;
    }
}
