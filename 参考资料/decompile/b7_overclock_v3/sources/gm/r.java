package gm;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class r extends c0 implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29792b = new a(r.class, 22);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29793a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return r.G(f2Var.J());
        }
    }

    public r(String str, boolean z10) {
        Objects.requireNonNull(str, "'string' cannot be null");
        if (z10 && !K(str)) {
            throw new IllegalArgumentException("'string' contains illegal characters");
        }
        this.f29793a = Strings.i(str);
    }

    public r(byte[] bArr, boolean z10) {
        this.f29793a = z10 ? org.bouncycastle.util.a.p(bArr) : bArr;
    }

    public static r G(byte[] bArr) {
        return new c2(bArr, false);
    }

    public static r H(n0 n0Var, boolean z10) {
        return (r) f29792b.f(n0Var, z10);
    }

    public static r I(Object obj) {
        if (obj == null || (obj instanceof r)) {
            return (r) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof r) {
                return (r) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (r) f29792b.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    public static boolean K(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) > 127) {
                return false;
            }
        }
        return true;
    }

    @Override // gm.c0
    public final int A(boolean z10) {
        return b0.i(z10, this.f29793a.length);
    }

    public final byte[] J() {
        return org.bouncycastle.util.a.p(this.f29793a);
    }

    @Override // gm.k0
    public final String d() {
        return Strings.c(this.f29793a);
    }

    @Override // gm.c0, gm.w
    public final int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29793a);
    }

    public String toString() {
        return d();
    }

    @Override // gm.c0
    public final boolean x(c0 c0Var) {
        if (c0Var instanceof r) {
            return org.bouncycastle.util.a.g(this.f29793a, ((r) c0Var).f29793a);
        }
        return false;
    }

    @Override // gm.c0
    public final void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 22, this.f29793a);
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
