package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class f0 implements org.bouncycastle.crypto.k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25282f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25277a = new int[1024];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f25278b = new int[1024];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25279c = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f25283g = new byte[4];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25284h = 0;

    public static int g(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.k kVarB;
        if (kVar instanceof np.v1) {
            np.v1 v1Var = (np.v1) kVar;
            this.f25281e = v1Var.a();
            kVarB = v1Var.b();
        } else {
            this.f25281e = new byte[0];
            kVarB = kVar;
        }
        if (kVarB instanceof np.n1) {
            this.f25280d = ((np.n1) kVarB).a();
            d();
            this.f25282f = true;
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to HC256 init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        return "HC-256";
    }

    public final byte c() {
        if (this.f25284h == 0) {
            int iH = h();
            byte[] bArr = this.f25283g;
            bArr[0] = (byte) (iH & 255);
            int i10 = iH >> 8;
            bArr[1] = (byte) (i10 & 255);
            int i11 = i10 >> 8;
            bArr[2] = (byte) (i11 & 255);
            bArr[3] = (byte) ((i11 >> 8) & 255);
        }
        byte[] bArr2 = this.f25283g;
        int i12 = this.f25284h;
        byte b10 = bArr2[i12];
        this.f25284h = 3 & (i12 + 1);
        return b10;
    }

    public final void d() {
        byte[] bArr = this.f25280d;
        if (bArr.length != 32 && bArr.length != 16) {
            throw new IllegalArgumentException("The key must be 128/256 bits long");
        }
        if (this.f25281e.length < 16) {
            throw new IllegalArgumentException("The IV must be at least 128 bits long");
        }
        if (bArr.length != 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            byte[] bArr3 = this.f25280d;
            System.arraycopy(bArr3, 0, bArr2, 16, bArr3.length);
            this.f25280d = bArr2;
        }
        byte[] bArr4 = this.f25281e;
        if (bArr4.length < 32) {
            byte[] bArr5 = new byte[32];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
            byte[] bArr6 = this.f25281e;
            System.arraycopy(bArr6, 0, bArr5, bArr6.length, 32 - bArr6.length);
            this.f25281e = bArr5;
        }
        this.f25284h = 0;
        this.f25279c = 0;
        int[] iArr = new int[2560];
        for (int i10 = 0; i10 < 32; i10++) {
            int i11 = i10 >> 2;
            iArr[i11] = iArr[i11] | ((this.f25280d[i10] & 255) << ((i10 & 3) * 8));
        }
        for (int i12 = 0; i12 < 32; i12++) {
            int i13 = (i12 >> 2) + 8;
            iArr[i13] = iArr[i13] | ((this.f25281e[i12] & 255) << ((i12 & 3) * 8));
        }
        for (int i14 = 16; i14 < 2560; i14++) {
            int i15 = iArr[i14 - 2];
            int i16 = iArr[i14 - 15];
            iArr[i14] = ((i15 >>> 10) ^ (g(i15, 17) ^ g(i15, 19))) + iArr[i14 - 7] + ((i16 >>> 3) ^ (g(i16, 7) ^ g(i16, 18))) + iArr[i14 - 16] + i14;
        }
        System.arraycopy(iArr, 512, this.f25277a, 0, 1024);
        System.arraycopy(iArr, 1536, this.f25278b, 0, 1024);
        for (int i17 = 0; i17 < 4096; i17++) {
            h();
        }
        this.f25279c = 0;
    }

    @Override // org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        if (!this.f25282f) {
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
        return (byte) (b10 ^ c());
    }

    public final int h() {
        int i10;
        int i11;
        int i12 = this.f25279c;
        int i13 = i12 & 1023;
        if (i12 < 1024) {
            int[] iArr = this.f25277a;
            int i14 = iArr[(i13 - 3) & 1023];
            int i15 = iArr[(i13 - 1023) & 1023];
            int i16 = iArr[i13];
            int iG = iArr[(i13 - 10) & 1023] + (g(i15, 23) ^ g(i14, 10));
            int[] iArr2 = this.f25278b;
            iArr[i13] = i16 + iG + iArr2[(i14 ^ i15) & 1023];
            int[] iArr3 = this.f25277a;
            int i17 = iArr3[(i13 - 12) & 1023];
            i10 = iArr2[i17 & 255] + iArr2[((i17 >> 8) & 255) + 256] + iArr2[((i17 >> 16) & 255) + 512] + iArr2[((i17 >> 24) & 255) + 768];
            i11 = iArr3[i13];
        } else {
            int[] iArr4 = this.f25278b;
            int i18 = iArr4[(i13 - 3) & 1023];
            int i19 = iArr4[(i13 - 1023) & 1023];
            int i20 = iArr4[i13];
            int iG2 = iArr4[(i13 - 10) & 1023] + (g(i19, 23) ^ g(i18, 10));
            int[] iArr5 = this.f25277a;
            iArr4[i13] = i20 + iG2 + iArr5[(i18 ^ i19) & 1023];
            int[] iArr6 = this.f25278b;
            int i21 = iArr6[(i13 - 12) & 1023];
            i10 = iArr5[i21 & 255] + iArr5[((i21 >> 8) & 255) + 256] + iArr5[((i21 >> 16) & 255) + 512] + iArr5[((i21 >> 24) & 255) + 768];
            i11 = iArr6[i13];
        }
        int i22 = i11 ^ i10;
        this.f25279c = (this.f25279c + 1) & 2047;
        return i22;
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        d();
    }
}
