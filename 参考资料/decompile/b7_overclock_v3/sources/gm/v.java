package gm;

import java.io.IOException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class v extends c0 implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29812b = new a(v.class, 18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29813a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return v.G(f2Var.J());
        }
    }

    public v(String str, boolean z10) {
        if (z10 && !K(str)) {
            throw new IllegalArgumentException("string contains illegal characters");
        }
        this.f29813a = Strings.i(str);
    }

    public v(byte[] bArr, boolean z10) {
        this.f29813a = z10 ? org.bouncycastle.util.a.p(bArr) : bArr;
    }

    public static v G(byte[] bArr) {
        return new e2(bArr, false);
    }

    public static v H(n0 n0Var, boolean z10) {
        return (v) f29812b.f(n0Var, z10);
    }

    public static v I(Object obj) {
        if (obj == null || (obj instanceof v)) {
            return (v) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof v) {
                return (v) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (v) f29812b.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    public static boolean K(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            if (cCharAt > 127) {
                return false;
            }
            if (('0' > cCharAt || cCharAt > '9') && cCharAt != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean L(byte[] bArr) {
        for (byte b10 : bArr) {
            if (b10 != 32) {
                switch (b10) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }

    @Override // gm.c0
    public final int A(boolean z10) {
        return b0.i(z10, this.f29813a.length);
    }

    public final byte[] J() {
        return org.bouncycastle.util.a.p(this.f29813a);
    }

    @Override // gm.k0
    public final String d() {
        return Strings.c(this.f29813a);
    }

    @Override // gm.c0, gm.w
    public final int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29813a);
    }

    public String toString() {
        return d();
    }

    @Override // gm.c0
    public final boolean x(c0 c0Var) {
        if (c0Var instanceof v) {
            return org.bouncycastle.util.a.g(this.f29813a, ((v) c0Var).f29813a);
        }
        return false;
    }

    @Override // gm.c0
    public final void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 18, this.f29813a);
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
