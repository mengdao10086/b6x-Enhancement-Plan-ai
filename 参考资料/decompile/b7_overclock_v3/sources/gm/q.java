package gm;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class q extends c0 implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29782b = new a(q.class, 25);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29783a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return q.G(f2Var.J());
        }
    }

    public q(byte[] bArr, boolean z10) {
        Objects.requireNonNull(bArr, "'contents' cannot be null");
        this.f29783a = z10 ? org.bouncycastle.util.a.p(bArr) : bArr;
    }

    public static q G(byte[] bArr) {
        return new b2(bArr, false);
    }

    public static q H(n0 n0Var, boolean z10) {
        return (q) f29782b.f(n0Var, z10);
    }

    public static q I(Object obj) {
        if (obj == null || (obj instanceof q)) {
            return (q) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof q) {
                return (q) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (q) f29782b.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    @Override // gm.c0
    public final int A(boolean z10) {
        return b0.i(z10, this.f29783a.length);
    }

    public final byte[] J() {
        return org.bouncycastle.util.a.p(this.f29783a);
    }

    @Override // gm.k0
    public final String d() {
        return Strings.c(this.f29783a);
    }

    @Override // gm.c0, gm.w
    public final int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29783a);
    }

    @Override // gm.c0
    public final boolean x(c0 c0Var) {
        if (c0Var instanceof q) {
            return org.bouncycastle.util.a.g(this.f29783a, ((q) c0Var).f29783a);
        }
        return false;
    }

    @Override // gm.c0
    public final void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 25, this.f29783a);
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
