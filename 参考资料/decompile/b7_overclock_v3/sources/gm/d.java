package gm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends c0 implements k0, e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29649b = new a(d.class, 3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f29650c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29651a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 d(f0 f0Var) {
            return f0Var.N();
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return d.G(f2Var.J());
        }
    }

    public d(byte b10, int i10) {
        if (i10 > 7 || i10 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f29651a = new byte[]{(byte) i10, b10};
    }

    public d(byte[] bArr, int i10) {
        Objects.requireNonNull(bArr, "'data' cannot be null");
        if (bArr.length == 0 && i10 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i10 > 7 || i10 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f29651a = org.bouncycastle.util.a.I0(bArr, (byte) i10);
    }

    public d(byte[] bArr, boolean z10) {
        if (z10) {
            Objects.requireNonNull(bArr, "'contents' cannot be null");
            if (bArr.length < 1) {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
            int i10 = bArr[0] & 255;
            if (i10 > 0) {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
                if (i10 > 7) {
                    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                }
            }
        }
        this.f29651a = bArr;
    }

    public static d G(byte[] bArr) {
        int length = bArr.length;
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i10 = bArr[0] & 255;
        if (i10 > 0) {
            if (i10 > 7 || length < 2) {
                throw new IllegalArgumentException("invalid pad bits detected");
            }
            byte b10 = bArr[length - 1];
            if (b10 != ((byte) ((255 << i10) & b10))) {
                return new u2(bArr, false);
            }
        }
        return new u1(bArr, false);
    }

    public static byte[] I(int i10) {
        if (i10 == 0) {
            return new byte[0];
        }
        int i11 = 4;
        for (int i12 = 3; i12 >= 1 && ((255 << (i12 * 8)) & i10) == 0; i12--) {
            i11--;
        }
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) ((i10 >> (i13 * 8)) & 255);
        }
        return bArr;
    }

    public static d J(n0 n0Var, boolean z10) {
        return (d) f29649b.f(n0Var, z10);
    }

    public static d K(Object obj) {
        if (obj == null || (obj instanceof d)) {
            return (d) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof d) {
                return (d) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (d) f29649b.c((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static int M(int i10) {
        int i11;
        int i12 = 3;
        while (true) {
            if (i12 < 0) {
                i11 = 0;
                break;
            }
            if (i12 != 0) {
                int i13 = i10 >> (i12 * 8);
                if (i13 != 0) {
                    i11 = i13 & 255;
                    break;
                }
                i12--;
            } else {
                if (i10 != 0) {
                    i11 = i10 & 255;
                    break;
                }
                i12--;
            }
        }
        if (i11 == 0) {
            return 0;
        }
        int i14 = 1;
        while (true) {
            i11 <<= 1;
            if ((i11 & 255) == 0) {
                return 8 - i14;
            }
            i14++;
        }
    }

    @Override // gm.c0
    public c0 E() {
        return new u1(this.f29651a, false);
    }

    @Override // gm.c0
    public c0 F() {
        return new u2(this.f29651a, false);
    }

    public byte[] H() {
        byte[] bArr = this.f29651a;
        if (bArr.length == 1) {
            return z.f29835c;
        }
        int i10 = bArr[0] & 255;
        byte[] bArrW = org.bouncycastle.util.a.W(bArr, 1, bArr.length);
        int length = bArrW.length - 1;
        bArrW[length] = (byte) (((byte) (255 << i10)) & bArrW[length]);
        return bArrW;
    }

    public byte[] L() {
        byte[] bArr = this.f29651a;
        if (bArr[0] == 0) {
            return org.bouncycastle.util.a.W(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public int N() {
        int iMin = Math.min(5, this.f29651a.length - 1);
        int i10 = 0;
        for (int i11 = 1; i11 < iMin; i11++) {
            i10 |= (255 & this.f29651a[i11]) << ((i11 - 1) * 8);
        }
        if (1 > iMin || iMin >= 5) {
            return i10;
        }
        byte[] bArr = this.f29651a;
        return i10 | ((((byte) (bArr[iMin] & (255 << (bArr[0] & 255)))) & 255) << ((iMin - 1) * 8));
    }

    public e O() {
        return this;
    }

    @Override // gm.e
    public InputStream a() throws IOException {
        int i10 = this.f29651a[0] & 255;
        if (i10 == 0) {
            return i();
        }
        throw new IOException("expected octet-aligned bitstring, but found padBits: " + i10);
    }

    @Override // gm.k0
    public String d() {
        try {
            byte[] encoded = getEncoded();
            StringBuffer stringBuffer = new StringBuffer((encoded.length * 2) + 1);
            stringBuffer.append('#');
            for (int i10 = 0; i10 != encoded.length; i10++) {
                byte b10 = encoded[i10];
                char[] cArr = f29650c;
                stringBuffer.append(cArr[(b10 >>> 4) & 15]);
                stringBuffer.append(cArr[b10 & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e10) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e10.getMessage(), e10);
        }
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        byte[] bArr = this.f29651a;
        if (bArr.length < 2) {
            return 1;
        }
        int i10 = bArr[0] & 255;
        int length = bArr.length - 1;
        return (org.bouncycastle.util.a.t0(bArr, 0, length) * 257) ^ ((byte) (bArr[length] & (255 << i10)));
    }

    @Override // gm.e
    public InputStream i() throws IOException {
        byte[] bArr = this.f29651a;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    @Override // gm.e
    public int m() {
        return this.f29651a[0] & 255;
    }

    @Override // gm.h3
    public c0 o() {
        return b();
    }

    public String toString() {
        return d();
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (!(c0Var instanceof d)) {
            return false;
        }
        byte[] bArr = this.f29651a;
        byte[] bArr2 = ((d) c0Var).f29651a;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i10 = length - 1;
        for (int i11 = 0; i11 < i10; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        int i12 = 255 << (bArr[0] & 255);
        return ((byte) (bArr[i10] & i12)) == ((byte) (bArr2[i10] & i12));
    }
}
