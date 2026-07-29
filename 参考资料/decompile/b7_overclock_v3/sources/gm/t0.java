package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class t0 extends p0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f29810b;

    public t0(Class cls, int i10) {
        super(cls);
        this.f29810b = m0.a(0, i10);
    }

    public final c0 b(c0 c0Var) {
        if (this.f29762a.isInstance(c0Var)) {
            return c0Var;
        }
        throw new IllegalStateException("unexpected object: " + c0Var.getClass().getName());
    }

    public final c0 c(byte[] bArr) throws IOException {
        return b(c0.D(bArr));
    }

    public c0 d(f0 f0Var) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    public c0 e(f2 f2Var) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    public final c0 f(n0 n0Var, boolean z10) {
        if (128 == n0Var.r()) {
            return b(n0Var.N(z10, this));
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public final m0 g() {
        return this.f29810b;
    }
}
