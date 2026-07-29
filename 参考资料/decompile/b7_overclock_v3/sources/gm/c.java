package gm;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends c0 implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29644b = new a(c.class, 30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f29645a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return c.G(f2Var.J());
        }
    }

    public c(String str) {
        Objects.requireNonNull(str, "'string' cannot be null");
        this.f29645a = str.toCharArray();
    }

    public c(byte[] bArr) {
        Objects.requireNonNull(bArr, "'string' cannot be null");
        int length = bArr.length;
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("malformed BMPString encoding encountered");
        }
        int i10 = length / 2;
        char[] cArr = new char[i10];
        for (int i11 = 0; i11 != i10; i11++) {
            int i12 = i11 * 2;
            cArr[i11] = (char) ((bArr[i12 + 1] & 255) | (bArr[i12] << 8));
        }
        this.f29645a = cArr;
    }

    public c(char[] cArr) {
        Objects.requireNonNull(cArr, "'string' cannot be null");
        this.f29645a = cArr;
    }

    public static c G(byte[] bArr) {
        return new t1(bArr);
    }

    public static c H(char[] cArr) {
        return new t1(cArr);
    }

    public static c I(n0 n0Var, boolean z10) {
        return (c) f29644b.f(n0Var, z10);
    }

    public static c J(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof c) {
                return (c) c0VarB;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (c) f29644b.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    @Override // gm.c0
    public final int A(boolean z10) {
        return b0.i(z10, this.f29645a.length * 2);
    }

    @Override // gm.k0
    public final String d() {
        return new String(this.f29645a);
    }

    @Override // gm.c0, gm.w
    public final int hashCode() {
        return org.bouncycastle.util.a.u0(this.f29645a);
    }

    public String toString() {
        return d();
    }

    @Override // gm.c0
    public final boolean x(c0 c0Var) {
        if (c0Var instanceof c) {
            return org.bouncycastle.util.a.h(this.f29645a, ((c) c0Var).f29645a);
        }
        return false;
    }

    @Override // gm.c0
    public final void y(b0 b0Var, boolean z10) throws IOException {
        int length = this.f29645a.length;
        b0Var.v(z10, 30);
        b0Var.m(length * 2);
        byte[] bArr = new byte[8];
        int i10 = length & (-4);
        int i11 = 0;
        while (i11 < i10) {
            char[] cArr = this.f29645a;
            char c10 = cArr[i11];
            char c11 = cArr[i11 + 1];
            char c12 = cArr[i11 + 2];
            char c13 = cArr[i11 + 3];
            i11 += 4;
            bArr[0] = (byte) (c10 >> '\b');
            bArr[1] = (byte) c10;
            bArr[2] = (byte) (c11 >> '\b');
            bArr[3] = (byte) c11;
            bArr[4] = (byte) (c12 >> '\b');
            bArr[5] = (byte) c12;
            bArr[6] = (byte) (c13 >> '\b');
            bArr[7] = (byte) c13;
            b0Var.l(bArr, 0, 8);
        }
        if (i11 < length) {
            int i12 = 0;
            do {
                char c14 = this.f29645a[i11];
                i11++;
                int i13 = i12 + 1;
                bArr[i12] = (byte) (c14 >> '\b');
                i12 = i13 + 1;
                bArr[i13] = (byte) c14;
            } while (i11 < length);
            b0Var.l(bArr, 0, i12);
        }
    }

    @Override // gm.c0
    public final boolean z() {
        return false;
    }
}
