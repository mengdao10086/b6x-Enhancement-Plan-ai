package gm;

import java.io.IOException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l0 extends c0 implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29735b = new a(l0.class, 20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29736a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return l0.G(f2Var.J());
        }
    }

    public l0(String str) {
        this.f29736a = Strings.i(str);
    }

    public l0(byte[] bArr, boolean z10) {
        this.f29736a = z10 ? org.bouncycastle.util.a.p(bArr) : bArr;
    }

    public static l0 G(byte[] bArr) {
        return new m2(bArr, false);
    }

    public static l0 H(n0 n0Var, boolean z10) {
        return (l0) f29735b.f(n0Var, z10);
    }

    public static l0 I(Object obj) {
        if (obj == null || (obj instanceof l0)) {
            return (l0) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof l0) {
                return (l0) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (l0) f29735b.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    @Override // gm.c0
    public final int A(boolean z10) {
        return b0.i(z10, this.f29736a.length);
    }

    public final byte[] J() {
        return org.bouncycastle.util.a.p(this.f29736a);
    }

    @Override // gm.k0
    public final String d() {
        return Strings.c(this.f29736a);
    }

    @Override // gm.c0, gm.w
    public final int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29736a);
    }

    public String toString() {
        return d();
    }

    @Override // gm.c0
    public final boolean x(c0 c0Var) {
        if (c0Var instanceof l0) {
            return org.bouncycastle.util.a.g(this.f29736a, ((l0) c0Var).f29736a);
        }
        return false;
    }

    @Override // gm.c0
    public final void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 20, this.f29736a);
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
