package mm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.g0 f41321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f41322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.h f41323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41324d;

    public g(gm.g0 g0Var) throws IOException {
        this.f41321a = g0Var;
        this.f41322b = gm.t.I(g0Var.readObject());
    }

    public gm.i0 a() throws IOException {
        if (this.f41323c == null) {
            this.f41323c = this.f41321a.readObject();
        }
        gm.h hVar = this.f41323c;
        if (!(hVar instanceof gm.o0)) {
            return null;
        }
        this.f41323c = null;
        return (gm.i0) gm.v0.p((gm.o0) hVar, 2, false, 17);
    }

    public zn.b b() throws IOException {
        if (this.f41323c == null) {
            this.f41323c = this.f41321a.readObject();
        }
        gm.h hVar = this.f41323c;
        if (!(hVar instanceof gm.o0)) {
            return null;
        }
        zn.b bVarY = zn.b.y((gm.n0) hVar.b(), false);
        this.f41323c = null;
        return bVarY;
    }

    public o c() throws IOException {
        if (this.f41323c == null) {
            this.f41323c = this.f41321a.readObject();
        }
        gm.h hVar = this.f41323c;
        if (hVar == null) {
            return null;
        }
        this.f41323c = null;
        return new o((gm.g0) hVar);
    }

    public gm.z d() throws IOException {
        if (this.f41323c == null) {
            this.f41323c = this.f41321a.readObject();
        }
        gm.h hVar = this.f41323c;
        this.f41323c = null;
        return gm.z.I(hVar.b());
    }

    public zn.b e() throws IOException {
        if (this.f41323c == null) {
            this.f41323c = this.f41321a.readObject();
        }
        gm.h hVar = this.f41323c;
        if (hVar == null) {
            return null;
        }
        this.f41323c = null;
        return zn.b.z(((gm.g0) hVar).b());
    }

    public g0 f() throws IOException {
        this.f41324d = true;
        if (this.f41323c == null) {
            this.f41323c = this.f41321a.readObject();
        }
        gm.h hVar = this.f41323c;
        if (hVar instanceof gm.o0) {
            gm.o0 o0Var = (gm.o0) hVar;
            if (o0Var.s(0)) {
                gm.g0 g0Var = (gm.g0) o0Var.p(false, 16);
                this.f41323c = null;
                return g0.A(g0Var.o());
            }
        }
        return null;
    }

    public gm.i0 g() throws IOException {
        if (!this.f41324d) {
            f();
        }
        if (this.f41323c == null) {
            this.f41323c = this.f41321a.readObject();
        }
        gm.i0 i0Var = (gm.i0) this.f41323c;
        this.f41323c = null;
        return i0Var;
    }

    public gm.i0 h() throws IOException {
        if (this.f41323c == null) {
            this.f41323c = this.f41321a.readObject();
        }
        gm.h hVar = this.f41323c;
        if (hVar == null) {
            return null;
        }
        this.f41323c = null;
        return (gm.i0) gm.v0.p((gm.n0) hVar, 3, false, 17);
    }

    public gm.t i() {
        return this.f41322b;
    }
}
