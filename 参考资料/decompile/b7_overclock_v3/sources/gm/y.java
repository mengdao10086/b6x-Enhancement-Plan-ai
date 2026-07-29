package gm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes5.dex */
public class y extends c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f29828d = 72057594037927808L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f29831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t0 f29827c = new a(y.class, 6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentMap<b, y> f29829e = new ConcurrentHashMap();

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return y.H(f2Var.J(), false);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f29832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f29833b;

        public b(byte[] bArr) {
            this.f29832a = org.bouncycastle.util.a.s0(bArr);
            this.f29833b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return org.bouncycastle.util.a.g(this.f29833b, ((b) obj).f29833b);
            }
            return false;
        }

        public int hashCode() {
            return this.f29832a;
        }
    }

    public y(y yVar, String str) {
        if (!e0.O(str, 0)) {
            throw new IllegalArgumentException("string " + str + " not a valid OID branch");
        }
        this.f29830a = yVar.L() + j3.b.f36044h + str;
    }

    public y(String str) {
        Objects.requireNonNull(str, "'identifier' cannot be null");
        if (P(str)) {
            this.f29830a = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    public y(byte[] bArr, boolean z10) {
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
                        if (j11 < 40) {
                            stringBuffer.append('0');
                        } else if (j11 < 80) {
                            stringBuffer.append('1');
                            j11 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j11 -= 80;
                        }
                        z11 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j11);
                    j10 = 0;
                } else {
                    j10 = j11 << 7;
                }
            } else {
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j10) : bigIntegerShiftLeft).or(BigInteger.valueOf(i11 & 127));
                if ((i11 & 128) == 0) {
                    if (z11) {
                        stringBuffer.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z11 = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(bigIntegerOr);
                    j10 = 0;
                    bigIntegerShiftLeft = null;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        this.f29830a = stringBuffer.toString();
        this.f29831b = z10 ? org.bouncycastle.util.a.p(bArr) : bArr2;
    }

    public static y H(byte[] bArr, boolean z10) {
        y yVar = f29829e.get(new b(bArr));
        return yVar == null ? new y(bArr, z10) : yVar;
    }

    public static y J(byte[] bArr) {
        return H(bArr, true);
    }

    public static y M(n0 n0Var, boolean z10) {
        if (!z10 && !n0Var.X()) {
            c0 c0VarU = n0Var.U();
            if (!(c0VarU instanceof y)) {
                return J(z.I(c0VarU).J());
            }
        }
        return (y) f29827c.f(n0Var, z10);
    }

    public static y N(Object obj) {
        if (obj == null || (obj instanceof y)) {
            return (y) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof y) {
                return (y) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (y) f29827c.c((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static boolean P(String str) {
        char cCharAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (cCharAt = str.charAt(0)) < '0' || cCharAt > '2') {
            return false;
        }
        return e0.O(str, 2);
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, K().length);
    }

    public y G(String str) {
        return new y(this, str);
    }

    public final void I(ByteArrayOutputStream byteArrayOutputStream) {
        m3 m3Var = new m3(this.f29830a);
        int i10 = Integer.parseInt(m3Var.b()) * 40;
        String strB = m3Var.b();
        if (strB.length() <= 18) {
            e0.P(byteArrayOutputStream, ((long) i10) + Long.parseLong(strB));
        } else {
            e0.Q(byteArrayOutputStream, new BigInteger(strB).add(BigInteger.valueOf(i10)));
        }
        while (m3Var.a()) {
            String strB2 = m3Var.b();
            if (strB2.length() <= 18) {
                e0.P(byteArrayOutputStream, Long.parseLong(strB2));
            } else {
                e0.Q(byteArrayOutputStream, new BigInteger(strB2));
            }
        }
    }

    public final synchronized byte[] K() {
        if (this.f29831b == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            I(byteArrayOutputStream);
            this.f29831b = byteArrayOutputStream.toByteArray();
        }
        return this.f29831b;
    }

    public String L() {
        return this.f29830a;
    }

    public y O() {
        b bVar = new b(K());
        ConcurrentMap<b, y> concurrentMap = f29829e;
        y yVar = concurrentMap.get(bVar);
        if (yVar != null) {
            return yVar;
        }
        y yVarPutIfAbsent = concurrentMap.putIfAbsent(bVar, this);
        return yVarPutIfAbsent == null ? this : yVarPutIfAbsent;
    }

    public boolean Q(y yVar) {
        String strL = L();
        String strL2 = yVar.L();
        return strL.length() > strL2.length() && strL.charAt(strL2.length()) == '.' && strL.startsWith(strL2);
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return this.f29830a.hashCode();
    }

    public String toString() {
        return L();
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (c0Var == this) {
            return true;
        }
        if (c0Var instanceof y) {
            return this.f29830a.equals(((y) c0Var).f29830a);
        }
        return false;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 6, K());
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
