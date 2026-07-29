package gm;

import java.io.IOException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d0 extends c0 implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29652b = new a(d0.class, 19);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29653a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return d0.G(f2Var.J());
        }
    }

    public d0(String str, boolean z10) {
        if (z10 && !K(str)) {
            throw new IllegalArgumentException("string contains illegal characters");
        }
        this.f29653a = Strings.i(str);
    }

    public d0(byte[] bArr, boolean z10) {
        this.f29653a = z10 ? org.bouncycastle.util.a.p(bArr) : bArr;
    }

    public static d0 G(byte[] bArr) {
        return new i2(bArr, false);
    }

    public static d0 H(n0 n0Var, boolean z10) {
        return (d0) f29652b.f(n0Var, z10);
    }

    public static d0 I(Object obj) {
        if (obj == null || (obj instanceof d0)) {
            return (d0) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof d0) {
                return (d0) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (d0) f29652b.c((byte[]) obj);
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
            if (('a' > cCharAt || cCharAt > 'z') && (('A' > cCharAt || cCharAt > 'Z') && (('0' > cCharAt || cCharAt > '9') && cCharAt != ' ' && cCharAt != ':' && cCharAt != '=' && cCharAt != '?'))) {
                switch (cCharAt) {
                    case '\'':
                    case '(':
                    case ')':
                        continue;
                    default:
                        switch (cCharAt) {
                            case '+':
                            case ',':
                            case '-':
                            case '.':
                            case '/':
                                break;
                            default:
                                return false;
                        }
                        break;
                }
            }
        }
        return true;
    }

    @Override // gm.c0
    public final int A(boolean z10) {
        return b0.i(z10, this.f29653a.length);
    }

    public final byte[] J() {
        return org.bouncycastle.util.a.p(this.f29653a);
    }

    @Override // gm.k0
    public final String d() {
        return Strings.c(this.f29653a);
    }

    @Override // gm.c0, gm.w
    public final int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29653a);
    }

    public String toString() {
        return d();
    }

    @Override // gm.c0
    public final boolean x(c0 c0Var) {
        if (c0Var instanceof d0) {
            return org.bouncycastle.util.a.g(this.f29653a, ((d0) c0Var).f29653a);
        }
        return false;
    }

    @Override // gm.c0
    public final void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 19, this.f29653a);
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
