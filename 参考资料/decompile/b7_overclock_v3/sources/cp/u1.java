package cp;

/* JADX INFO: loaded from: classes5.dex */
public class u1 extends s1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f25684l = {34, 47, rc.a.W, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, jt.l.f36949q};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f25685m = {34, 47, rc.a.X, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, jt.l.f36949q};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f25686n = {35, 47, rc.a.W, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, jt.l.f36949q};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f25687o = {35, 47, rc.a.X, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, jt.l.f36949q};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f25688k;

    public u1() {
        this.f25688k = f25684l;
    }

    public u1(int i10) {
        if (i10 == 32) {
            this.f25688k = f25685m;
            return;
        }
        if (i10 == 64) {
            this.f25688k = f25686n;
        } else {
            if (i10 == 128) {
                this.f25688k = f25687o;
                return;
            }
            throw new IllegalArgumentException("Unsupported length: " + i10);
        }
    }

    public u1(u1 u1Var) {
        super(u1Var);
    }

    public static int y(byte b10, byte b11, byte b12, byte b13) {
        return ((b10 & 255) << 23) | ((b11 & 255) << 16) | ((b12 & 255) << 8) | (b13 & 255);
    }

    @Override // cp.s1, org.bouncycastle.crypto.k0
    public String b() {
        return "Zuc-256";
    }

    @Override // cp.s1, org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new u1(this);
    }

    @Override // cp.s1, org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        super.i(mVar);
        this.f25688k = ((u1) mVar).f25688k;
    }

    @Override // cp.s1
    public int t() {
        return 625;
    }

    @Override // cp.s1
    public void x(int[] iArr, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 32) {
            throw new IllegalArgumentException("A key of 32 bytes is needed");
        }
        if (bArr2 == null || bArr2.length != 25) {
            throw new IllegalArgumentException("An IV of 25 bytes is needed");
        }
        iArr[0] = y(bArr[0], this.f25688k[0], bArr[21], bArr[16]);
        iArr[1] = y(bArr[1], this.f25688k[1], bArr[22], bArr[17]);
        iArr[2] = y(bArr[2], this.f25688k[2], bArr[23], bArr[18]);
        iArr[3] = y(bArr[3], this.f25688k[3], bArr[24], bArr[19]);
        iArr[4] = y(bArr[4], this.f25688k[4], bArr[25], bArr[20]);
        iArr[5] = y(bArr2[0], (byte) (this.f25688k[5] | (bArr2[17] & okio.w0.f44229a)), bArr[5], bArr[26]);
        iArr[6] = y(bArr2[1], (byte) (this.f25688k[6] | (bArr2[18] & okio.w0.f44229a)), bArr[6], bArr[27]);
        iArr[7] = y(bArr2[10], (byte) (this.f25688k[7] | (bArr2[19] & okio.w0.f44229a)), bArr[7], bArr2[2]);
        iArr[8] = y(bArr[8], (byte) (this.f25688k[8] | (bArr2[20] & okio.w0.f44229a)), bArr2[3], bArr2[11]);
        iArr[9] = y(bArr[9], (byte) ((bArr2[21] & okio.w0.f44229a) | this.f25688k[9]), bArr2[12], bArr2[4]);
        iArr[10] = y(bArr2[5], (byte) (this.f25688k[10] | (bArr2[22] & okio.w0.f44229a)), bArr[10], bArr[28]);
        iArr[11] = y(bArr[11], (byte) (this.f25688k[11] | (bArr2[23] & okio.w0.f44229a)), bArr2[6], bArr2[13]);
        iArr[12] = y(bArr[12], (byte) (this.f25688k[12] | (bArr2[24] & okio.w0.f44229a)), bArr2[7], bArr2[14]);
        iArr[13] = y(bArr[13], this.f25688k[13], bArr2[15], bArr2[8]);
        iArr[14] = y(bArr[14], (byte) (this.f25688k[14] | ((bArr[31] >>> 4) & 15)), bArr2[16], bArr2[9]);
        iArr[15] = y(bArr[15], (byte) (this.f25688k[15] | (bArr[31] & 15)), bArr[30], bArr[29]);
    }
}
