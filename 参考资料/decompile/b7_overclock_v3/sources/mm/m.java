package mm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f41358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f41359c;

    public m(gm.g0 g0Var) throws IOException {
        this.f41357a = (gm.t) g0Var.readObject();
        this.f41358b = zn.b.z(g0Var.readObject().b());
        this.f41359c = new o((gm.g0) g0Var.readObject());
    }

    public zn.b a() {
        return this.f41358b;
    }

    public o b() {
        return this.f41359c;
    }

    public gm.t c() {
        return this.f41357a;
    }
}
