package zo;

/* JADX INFO: loaded from: classes5.dex */
public class g0 extends q {
    public g0() {
        this(256);
    }

    public g0(int i10) {
        super(r(i10));
    }

    public g0(g0 g0Var) {
        super(g0Var);
    }

    public static int r(int i10) {
        if (i10 == 224 || i10 == 256 || i10 == 384 || i10 == 512) {
            return i10;
        }
        throw new IllegalArgumentException("'bitLength' " + i10 + " not supported for SHA-3");
    }

    @Override // zo.q, org.bouncycastle.crypto.s
    public String b() {
        return "SHA3-" + this.f59435e;
    }

    @Override // zo.q, org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        l(2, 2);
        return super.c(bArr, i10);
    }

    @Override // zo.q
    public int m(byte[] bArr, int i10, byte b10, int i11) {
        if (i11 < 0 || i11 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i12 = (b10 & ((1 << i11) - 1)) | (2 << i11);
        int i13 = i11 + 2;
        if (i13 >= 8) {
            j((byte) i12);
            i13 -= 8;
            i12 >>>= 8;
        }
        return super.m(bArr, i10, (byte) i12, i13);
    }
}
