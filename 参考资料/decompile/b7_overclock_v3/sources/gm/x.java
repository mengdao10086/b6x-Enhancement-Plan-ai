package gm;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class x extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29819b = new a(x.class, 7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f29820a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 d(f0 f0Var) {
            return new x((q) q.f29782b.d(f0Var));
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return new x((q) q.f29782b.e(f2Var));
        }
    }

    public x(q qVar) {
        Objects.requireNonNull(qVar, "'baseGraphicString' cannot be null");
        this.f29820a = qVar;
    }

    public static x G(byte[] bArr) {
        return new x(q.G(bArr));
    }

    public static x I(n0 n0Var, boolean z10) {
        return (x) f29819b.f(n0Var, z10);
    }

    public static x J(Object obj) {
        if (obj == null || (obj instanceof x)) {
            return (x) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof x) {
                return (x) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (x) f29819b.c((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct object descriptor from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return this.f29820a.A(z10);
    }

    @Override // gm.c0
    public c0 E() {
        q qVar = (q) this.f29820a.E();
        return qVar == this.f29820a ? this : new x(qVar);
    }

    @Override // gm.c0
    public c0 F() {
        q qVar = (q) this.f29820a.F();
        return qVar == this.f29820a ? this : new x(qVar);
    }

    public q H() {
        return this.f29820a;
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return ~this.f29820a.hashCode();
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (c0Var instanceof x) {
            return this.f29820a.x(((x) c0Var).f29820a);
        }
        return false;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.v(z10, 7);
        this.f29820a.y(b0Var, false);
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
