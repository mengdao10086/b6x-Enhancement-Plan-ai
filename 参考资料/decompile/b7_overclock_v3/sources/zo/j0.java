package zo;

/* JADX INFO: loaded from: classes5.dex */
public class j0 extends q implements org.bouncycastle.crypto.m0 {
    public j0() {
        this(128);
    }

    public j0(int i10) {
        super(r(i10));
    }

    public j0(j0 j0Var) {
        super(j0Var);
    }

    public static int r(int i10) {
        if (i10 == 128 || i10 == 256) {
            return i10;
        }
        throw new IllegalArgumentException("'bitLength' " + i10 + " not supported for SHAKE");
    }

    @Override // zo.q, org.bouncycastle.crypto.s
    public String b() {
        return "SHAKE" + this.f59435e;
    }

    @Override // zo.q, org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        return f(bArr, i10, h());
    }

    public int e(byte[] bArr, int i10, int i11) {
        if (!this.f59436f) {
            l(15, 4);
        }
        q(bArr, i10, ((long) i11) * 8);
        return i11;
    }

    @Override // org.bouncycastle.crypto.m0
    public int f(byte[] bArr, int i10, int i11) {
        int iE = e(bArr, i10, i11);
        reset();
        return iE;
    }

    @Override // zo.q, org.bouncycastle.crypto.s
    public int h() {
        return this.f59435e / 4;
    }

    @Override // zo.q
    public int m(byte[] bArr, int i10, byte b10, int i11) {
        return s(bArr, i10, h(), b10, i11);
    }

    public int s(byte[] bArr, int i10, int i11, byte b10, int i12) {
        if (i12 < 0 || i12 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i13 = (b10 & ((1 << i12) - 1)) | (15 << i12);
        int i14 = i12 + 4;
        if (i14 >= 8) {
            j((byte) i13);
            i14 -= 8;
            i13 >>>= 8;
        }
        if (i14 > 0) {
            l(i13, i14);
        }
        q(bArr, i10, ((long) i11) * 8);
        reset();
        return i11;
    }
}
