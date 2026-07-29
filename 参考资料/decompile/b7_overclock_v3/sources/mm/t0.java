package mm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.g0 f41405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f41406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f41407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f41408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f41409e;

    public t0(gm.g0 g0Var) throws IOException {
        this.f41405a = g0Var;
        this.f41406b = (gm.t) g0Var.readObject();
    }

    public static t0 e(Object obj) throws IOException {
        if (obj instanceof gm.f0) {
            return new t0(((gm.f0) obj).M());
        }
        if (obj instanceof gm.g0) {
            return new t0((gm.g0) obj);
        }
        throw new IOException("unknown object encountered: " + obj.getClass().getName());
    }

    public gm.i0 a() throws IOException {
        this.f41408d = true;
        gm.h object = this.f41405a.readObject();
        this.f41407c = object;
        if (object instanceof gm.o0) {
            gm.o0 o0Var = (gm.o0) object;
            if (o0Var.s(0)) {
                gm.i0 i0Var = (gm.i0) o0Var.p(false, 17);
                this.f41407c = null;
                return i0Var;
            }
        }
        return null;
    }

    public gm.i0 b() throws IOException {
        if (!this.f41408d) {
            throw new IOException("getCerts() has not been called.");
        }
        this.f41409e = true;
        if (this.f41407c == null) {
            this.f41407c = this.f41405a.readObject();
        }
        Object obj = this.f41407c;
        if (obj instanceof gm.o0) {
            gm.o0 o0Var = (gm.o0) obj;
            if (o0Var.s(1)) {
                gm.i0 i0Var = (gm.i0) o0Var.p(false, 17);
                this.f41407c = null;
                return i0Var;
            }
        }
        return null;
    }

    public gm.i0 c() throws IOException {
        gm.h object = this.f41405a.readObject();
        return object instanceof gm.h0 ? ((gm.h0) object).M() : (gm.i0) object;
    }

    public o d() throws IOException {
        return new o((gm.g0) this.f41405a.readObject());
    }

    public gm.i0 f() throws IOException {
        if (!this.f41408d || !this.f41409e) {
            throw new IOException("getCerts() and/or getCrls() has not been called.");
        }
        if (this.f41407c == null) {
            this.f41407c = this.f41405a.readObject();
        }
        return (gm.i0) this.f41407c;
    }

    public gm.t g() {
        return this.f41406b;
    }
}
