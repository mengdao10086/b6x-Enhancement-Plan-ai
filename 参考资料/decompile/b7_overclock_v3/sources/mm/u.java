package mm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.g0 f41410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f41411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.h f41412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41413d;

    public u(gm.g0 g0Var) throws IOException {
        this.f41410a = g0Var;
        this.f41411b = gm.t.I(g0Var.readObject());
    }

    public r a() throws IOException {
        if (this.f41412c == null) {
            this.f41412c = this.f41410a.readObject();
        }
        gm.h hVar = this.f41412c;
        if (hVar == null) {
            return null;
        }
        this.f41412c = null;
        return new r((gm.g0) hVar);
    }

    public g0 b() throws IOException {
        this.f41413d = true;
        if (this.f41412c == null) {
            this.f41412c = this.f41410a.readObject();
        }
        gm.h hVar = this.f41412c;
        if (hVar instanceof gm.o0) {
            gm.o0 o0Var = (gm.o0) hVar;
            if (o0Var.s(0)) {
                gm.g0 g0Var = (gm.g0) o0Var.p(false, 16);
                this.f41412c = null;
                return g0.A(g0Var.o());
            }
        }
        return null;
    }

    public gm.i0 c() throws IOException {
        if (!this.f41413d) {
            b();
        }
        if (this.f41412c == null) {
            this.f41412c = this.f41410a.readObject();
        }
        gm.i0 i0Var = (gm.i0) this.f41412c;
        this.f41412c = null;
        return i0Var;
    }

    public gm.i0 d() throws IOException {
        if (this.f41412c == null) {
            this.f41412c = this.f41410a.readObject();
        }
        gm.h hVar = this.f41412c;
        if (hVar == null) {
            return null;
        }
        this.f41412c = null;
        return (gm.i0) gm.v0.p((gm.o0) hVar, 1, false, 17);
    }

    public gm.t e() {
        return this.f41411b;
    }
}
