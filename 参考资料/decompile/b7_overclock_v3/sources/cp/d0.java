package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class d0 implements org.bouncycastle.crypto.k0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25247i = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f25249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f25250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f25251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f25252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25254g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25255h = false;

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof np.v1)) {
            throw new IllegalArgumentException("Grain v1 Init parameters must include an IV");
        }
        np.v1 v1Var = (np.v1) kVar;
        byte[] bArrA = v1Var.a();
        if (bArrA == null || bArrA.length != 8) {
            throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
        }
        if (!(v1Var.b() instanceof np.n1)) {
            throw new IllegalArgumentException("Grain v1 Init parameters must include a key");
        }
        np.n1 n1Var = (np.n1) v1Var.b();
        this.f25249b = new byte[n1Var.a().length];
        this.f25248a = new byte[n1Var.a().length];
        this.f25251d = new int[5];
        this.f25252e = new int[5];
        this.f25250c = new byte[2];
        System.arraycopy(bArrA, 0, this.f25249b, 0, bArrA.length);
        System.arraycopy(n1Var.a(), 0, this.f25248a, 0, n1Var.a().length);
        reset();
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        return "Grain v1";
    }

    public final byte c() {
        if (this.f25254g > 1) {
            j();
            this.f25254g = 0;
        }
        byte[] bArr = this.f25250c;
        int i10 = this.f25254g;
        this.f25254g = i10 + 1;
        return bArr[i10];
    }

    public final int d() {
        int[] iArr = this.f25252e;
        int i10 = (iArr[0] >>> 1) | (iArr[1] << 15);
        int i11 = (iArr[0] >>> 2) | (iArr[1] << 14);
        int i12 = (iArr[0] >>> 4) | (iArr[1] << 12);
        int i13 = (iArr[0] >>> 10) | (iArr[1] << 6);
        int i14 = (iArr[1] >>> 15) | (iArr[2] << 1);
        int i15 = (iArr[2] >>> 11) | (iArr[3] << 5);
        int i16 = (iArr[3] >>> 8) | (iArr[4] << 8);
        int i17 = (iArr[4] << 1) | (iArr[3] >>> 15);
        int[] iArr2 = this.f25251d;
        int i18 = (iArr2[0] >>> 3) | (iArr2[1] << 13);
        int i19 = (iArr2[1] >>> 9) | (iArr2[2] << 7);
        int i20 = (iArr2[3] << 2) | (iArr2[2] >>> 14);
        int i21 = iArr2[4];
        int i22 = i20 & i21;
        int i23 = ((((i19 ^ i17) ^ (i18 & i21)) ^ i22) ^ (i21 & i17)) ^ ((i18 & i19) & i20);
        int i24 = i18 & i20;
        return (((((((((i17 & i22) ^ (((i24 & i17) ^ ((i21 & i24) ^ i23)) ^ ((i19 & i20) & i17))) ^ i10) ^ i11) ^ i12) ^ i13) ^ i14) ^ i15) ^ i16) & 65535;
    }

    @Override // org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        if (!this.f25255h) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i13 = 0; i13 < i11; i13++) {
            bArr2[i12 + i13] = (byte) (bArr[i10 + i13] ^ c());
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public byte f(byte b10) {
        if (this.f25255h) {
            return (byte) (b10 ^ c());
        }
        throw new IllegalStateException(b() + " not initialised");
    }

    public final int g() {
        int[] iArr = this.f25251d;
        int i10 = iArr[0];
        int i11 = (iArr[0] >>> 13) | (iArr[1] << 3);
        int i12 = (iArr[1] >>> 7) | (iArr[2] << 9);
        int i13 = (iArr[2] >>> 6) | (iArr[3] << 10);
        int i14 = (iArr[3] >>> 3) | (iArr[4] << 13);
        return (((iArr[4] << 2) | (iArr[3] >>> 14)) ^ ((((i11 ^ i10) ^ i12) ^ i13) ^ i14)) & 65535;
    }

    public final int h() {
        int[] iArr = this.f25252e;
        int i10 = iArr[0];
        int i11 = (iArr[0] >>> 9) | (iArr[1] << 7);
        int i12 = (iArr[0] >>> 14) | (iArr[1] << 2);
        int i13 = (iArr[0] >>> 15) | (iArr[1] << 1);
        int i14 = (iArr[1] >>> 5) | (iArr[2] << 11);
        int i15 = (iArr[1] >>> 12) | (iArr[2] << 4);
        int i16 = (iArr[2] >>> 1) | (iArr[3] << 15);
        int i17 = (iArr[2] >>> 5) | (iArr[3] << 11);
        int i18 = (iArr[2] >>> 13) | (iArr[3] << 3);
        int i19 = (iArr[3] >>> 4) | (iArr[4] << 12);
        int i20 = (iArr[3] >>> 12) | (iArr[4] << 4);
        int i21 = (iArr[3] >>> 14) | (iArr[4] << 2);
        int i22 = (iArr[4] << 1) | (iArr[3] >>> 15);
        int i23 = i22 & i20;
        int i24 = (((i10 ^ (((((((((i21 ^ i20) ^ i19) ^ i18) ^ i17) ^ i16) ^ i15) ^ i14) ^ i12) ^ i11)) ^ i23) ^ (i17 & i16)) ^ (i13 & i11);
        int i25 = i20 & i19;
        int i26 = i16 & i15 & i14;
        return (((((((((i22 & i18) & i15) & i11) ^ ((i24 ^ (i25 & i18)) ^ i26)) ^ ((i25 & i17) & i16)) ^ ((i23 & i14) & i13)) ^ (((i23 & i19) & i18) & i17)) ^ ((i13 & i26) & i11)) ^ (((((i19 & i18) & i17) & i16) & i15) & i14)) & 65535;
    }

    public final void i() {
        for (int i10 = 0; i10 < 10; i10++) {
            this.f25253f = d();
            this.f25252e = l(this.f25252e, (h() ^ this.f25251d[0]) ^ this.f25253f);
            this.f25251d = l(this.f25251d, g() ^ this.f25253f);
        }
        this.f25255h = true;
    }

    public final void j() {
        int iD = d();
        this.f25253f = iD;
        byte[] bArr = this.f25250c;
        bArr[0] = (byte) iD;
        bArr[1] = (byte) (iD >> 8);
        this.f25252e = l(this.f25252e, h() ^ this.f25251d[0]);
        this.f25251d = l(this.f25251d, g());
    }

    public final void k(byte[] bArr, byte[] bArr2) {
        bArr2[8] = -1;
        bArr2[9] = -1;
        this.f25248a = bArr;
        this.f25249b = bArr2;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f25252e;
            if (i10 >= iArr.length) {
                return;
            }
            byte[] bArr3 = this.f25248a;
            int i12 = i11 + 1;
            iArr[i10] = ((bArr3[i11] & 255) | (bArr3[i12] << 8)) & 65535;
            int[] iArr2 = this.f25251d;
            byte[] bArr4 = this.f25249b;
            iArr2[i10] = ((bArr4[i11] & 255) | (bArr4[i12] << 8)) & 65535;
            i11 += 2;
            i10++;
        }
    }

    public final int[] l(int[] iArr, int i10) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = iArr[4];
        iArr[4] = i10;
        return iArr;
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        this.f25254g = 2;
        k(this.f25248a, this.f25249b);
        i();
    }
}
