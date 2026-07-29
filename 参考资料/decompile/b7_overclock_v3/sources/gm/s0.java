package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class s0 extends c0 implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29802b = new a(s0.class, 28);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f29803c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29804a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return s0.G(f2Var.J());
        }
    }

    public s0(byte[] bArr, boolean z10) {
        this.f29804a = z10 ? org.bouncycastle.util.a.p(bArr) : bArr;
    }

    public static s0 G(byte[] bArr) {
        return new q2(bArr, false);
    }

    public static void H(StringBuffer stringBuffer, int i10) {
        char[] cArr = f29803c;
        stringBuffer.append(cArr[(i10 >>> 4) & 15]);
        stringBuffer.append(cArr[i10 & 15]);
    }

    public static void I(StringBuffer stringBuffer, int i10) {
        if (i10 < 128) {
            H(stringBuffer, i10);
            return;
        }
        byte[] bArr = new byte[5];
        int i11 = 5;
        do {
            i11--;
            bArr[i11] = (byte) i10;
            i10 >>>= 8;
        } while (i10 != 0);
        int i12 = 5 - i11;
        int i13 = i11 - 1;
        bArr[i13] = (byte) (i12 | 128);
        while (true) {
            int i14 = i13 + 1;
            H(stringBuffer, bArr[i13]);
            if (i14 >= 5) {
                return;
            } else {
                i13 = i14;
            }
        }
    }

    public static s0 J(n0 n0Var, boolean z10) {
        return (s0) f29802b.f(n0Var, z10);
    }

    public static s0 K(Object obj) {
        if (obj == null || (obj instanceof s0)) {
            return (s0) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof s0) {
                return (s0) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (s0) f29802b.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error getInstance: " + e10.toString());
        }
    }

    @Override // gm.c0
    public final int A(boolean z10) {
        return b0.i(z10, this.f29804a.length);
    }

    public final byte[] L() {
        return org.bouncycastle.util.a.p(this.f29804a);
    }

    @Override // gm.k0
    public final String d() {
        int length = this.f29804a.length;
        StringBuffer stringBuffer = new StringBuffer(((b0.h(length) + length) * 2) + 3);
        stringBuffer.append("#1C");
        I(stringBuffer, length);
        for (int i10 = 0; i10 < length; i10++) {
            H(stringBuffer, this.f29804a[i10]);
        }
        return stringBuffer.toString();
    }

    @Override // gm.c0, gm.w
    public final int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29804a);
    }

    public String toString() {
        return d();
    }

    @Override // gm.c0
    public final boolean x(c0 c0Var) {
        if (c0Var instanceof s0) {
            return org.bouncycastle.util.a.g(this.f29804a, ((s0) c0Var).f29804a);
        }
        return false;
    }

    @Override // gm.c0
    public final void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 28, this.f29804a);
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
