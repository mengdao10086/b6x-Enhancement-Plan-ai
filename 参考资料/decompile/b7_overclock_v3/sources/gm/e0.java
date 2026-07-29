package gm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class e0 extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t0 f29659c = new a(e0.class, 13);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f29660d = 72057594037927808L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f29662b;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return e0.H(f2Var.J(), false);
        }
    }

    public e0(e0 e0Var, String str) {
        if (!O(str, 0)) {
            throw new IllegalArgumentException("string " + str + " not a valid OID branch");
        }
        this.f29661a = e0Var.L() + j3.b.f36044h + str;
    }

    public e0(String str) {
        Objects.requireNonNull(str, "'identifier' cannot be null");
        if (O(str, 0)) {
            this.f29661a = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a relative OID");
    }

    public e0(byte[] bArr, boolean z10) {
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z11 = true;
        long j10 = 0;
        BigInteger bigIntegerShiftLeft = null;
        for (int i10 = 0; i10 != bArr2.length; i10++) {
            int i11 = bArr2[i10] & 255;
            if (j10 <= 72057594037927808L) {
                long j11 = j10 + ((long) (i11 & 127));
                if ((i11 & 128) == 0) {
                    if (z11) {
                        z11 = false;
                    } else {
                        stringBuffer.append('.');
                    }
                    stringBuffer.append(j11);
                    j10 = 0;
                } else {
                    j10 = j11 << 7;
                }
            } else {
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j10) : bigIntegerShiftLeft).or(BigInteger.valueOf(i11 & 127));
                if ((i11 & 128) == 0) {
                    if (z11) {
                        z11 = false;
                    } else {
                        stringBuffer.append('.');
                    }
                    stringBuffer.append(bigIntegerOr);
                    j10 = 0;
                    bigIntegerShiftLeft = null;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        this.f29661a = stringBuffer.toString();
        this.f29662b = z10 ? org.bouncycastle.util.a.p(bArr) : bArr2;
    }

    public static e0 H(byte[] bArr, boolean z10) {
        return new e0(bArr, z10);
    }

    public static e0 J(byte[] bArr) {
        return H(bArr, true);
    }

    public static e0 M(n0 n0Var, boolean z10) {
        return (e0) f29659c.f(n0Var, z10);
    }

    public static e0 N(Object obj) {
        if (obj == null || (obj instanceof e0)) {
            return (e0) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof e0) {
                return (e0) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (e0) f29659c.c((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct relative OID from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (r7.charAt(r0 + 1) != '0') goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r2 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r2 <= 1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean O(java.lang.String r7, int r8) {
        /*
            int r0 = r7.length()
            r1 = 0
        L5:
            r2 = 0
        L6:
            int r0 = r0 + (-1)
            r3 = 48
            r4 = 1
            if (r0 < r8) goto L2c
            char r5 = r7.charAt(r0)
            r6 = 46
            if (r5 != r6) goto L22
            if (r2 == 0) goto L21
            if (r2 <= r4) goto L5
            int r2 = r0 + 1
            char r2 = r7.charAt(r2)
            if (r2 != r3) goto L5
        L21:
            return r1
        L22:
            if (r3 > r5) goto L2b
            r3 = 57
            if (r5 > r3) goto L2b
            int r2 = r2 + 1
            goto L6
        L2b:
            return r1
        L2c:
            if (r2 == 0) goto L39
            if (r2 <= r4) goto L38
            int r0 = r0 + r4
            char r7 = r7.charAt(r0)
            if (r7 != r3) goto L38
            goto L39
        L38:
            return r4
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gm.e0.O(java.lang.String, int):boolean");
    }

    public static void P(ByteArrayOutputStream byteArrayOutputStream, long j10) {
        byte[] bArr = new byte[9];
        int i10 = 8;
        bArr[8] = (byte) (((int) j10) & 127);
        while (j10 >= 128) {
            j10 >>= 7;
            i10--;
            bArr[i10] = (byte) (((int) j10) | 128);
        }
        byteArrayOutputStream.write(bArr, i10, 9 - i10);
    }

    public static void Q(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i10 = iBitLength - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            bArr[i11] = (byte) (bigInteger.intValue() | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i10] = (byte) (bArr[i10] & 127);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, K().length);
    }

    public e0 G(String str) {
        return new e0(this, str);
    }

    public final void I(ByteArrayOutputStream byteArrayOutputStream) {
        m3 m3Var = new m3(this.f29661a);
        while (m3Var.a()) {
            String strB = m3Var.b();
            if (strB.length() <= 18) {
                P(byteArrayOutputStream, Long.parseLong(strB));
            } else {
                Q(byteArrayOutputStream, new BigInteger(strB));
            }
        }
    }

    public final synchronized byte[] K() {
        if (this.f29662b == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            I(byteArrayOutputStream);
            this.f29662b = byteArrayOutputStream.toByteArray();
        }
        return this.f29662b;
    }

    public String L() {
        return this.f29661a;
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return this.f29661a.hashCode();
    }

    public String toString() {
        return L();
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (this == c0Var) {
            return true;
        }
        if (c0Var instanceof e0) {
            return this.f29661a.equals(((e0) c0Var).f29661a);
        }
        return false;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 13, K());
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
