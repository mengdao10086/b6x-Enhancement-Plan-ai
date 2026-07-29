package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class c0 implements org.bouncycastle.crypto.k0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25230i = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f25232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f25233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f25234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f25235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25237g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f25238h = false;

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof np.v1)) {
            throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
        }
        np.v1 v1Var = (np.v1) kVar;
        byte[] bArrA = v1Var.a();
        if (bArrA == null || bArrA.length != 12) {
            throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
        }
        if (!(v1Var.b() instanceof np.n1)) {
            throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
        }
        np.n1 n1Var = (np.n1) v1Var.b();
        this.f25232b = new byte[n1Var.a().length];
        this.f25231a = new byte[n1Var.a().length];
        this.f25234d = new int[4];
        this.f25235e = new int[4];
        this.f25233c = new byte[4];
        System.arraycopy(bArrA, 0, this.f25232b, 0, bArrA.length);
        System.arraycopy(n1Var.a(), 0, this.f25231a, 0, n1Var.a().length);
        reset();
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        return "Grain-128";
    }

    public final byte c() {
        if (this.f25237g > 3) {
            j();
            this.f25237g = 0;
        }
        byte[] bArr = this.f25233c;
        int i10 = this.f25237g;
        this.f25237g = i10 + 1;
        return bArr[i10];
    }

    public final int d() {
        int[] iArr = this.f25235e;
        int i10 = (iArr[0] >>> 2) | (iArr[1] << 30);
        int i11 = (iArr[0] >>> 12) | (iArr[1] << 20);
        int i12 = (iArr[0] >>> 15) | (iArr[1] << 17);
        int i13 = (iArr[1] >>> 4) | (iArr[2] << 28);
        int i14 = (iArr[1] >>> 13) | (iArr[2] << 19);
        int i15 = iArr[2];
        int i16 = (iArr[2] >>> 9) | (iArr[3] << 23);
        int i17 = (iArr[2] >>> 25) | (iArr[3] << 7);
        int i18 = (iArr[3] << 1) | (iArr[2] >>> 31);
        int[] iArr2 = this.f25234d;
        int i19 = (iArr2[0] >>> 8) | (iArr2[1] << 24);
        int i20 = (iArr2[0] >>> 13) | (iArr2[1] << 19);
        int i21 = (iArr2[0] >>> 20) | (iArr2[1] << 12);
        int i22 = (iArr2[1] >>> 10) | (iArr2[2] << 22);
        int i23 = (iArr2[1] >>> 28) | (iArr2[2] << 4);
        int i24 = (iArr2[2] >>> 15) | (iArr2[3] << 17);
        return ((((((((((i18 & i11) & ((iArr2[2] >>> 31) | (iArr2[3] << 1))) ^ ((((i20 & i21) ^ (i11 & i19)) ^ (i18 & i22)) ^ (i23 & i24))) ^ ((iArr2[2] >>> 29) | (iArr2[3] << 3))) ^ i10) ^ i12) ^ i13) ^ i14) ^ i15) ^ i16) ^ i17;
    }

    @Override // org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        if (!this.f25238h) {
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
        if (this.f25238h) {
            return (byte) (b10 ^ c());
        }
        throw new IllegalStateException(b() + " not initialised");
    }

    public final int g() {
        int[] iArr = this.f25234d;
        int i10 = iArr[0];
        int i11 = (iArr[0] >>> 7) | (iArr[1] << 25);
        int i12 = (iArr[1] >>> 6) | (iArr[2] << 26);
        int i13 = (iArr[2] >>> 6) | (iArr[3] << 26);
        return iArr[3] ^ ((((i11 ^ i10) ^ i12) ^ i13) ^ ((iArr[2] >>> 17) | (iArr[3] << 15)));
    }

    public final int h() {
        int[] iArr = this.f25235e;
        int i10 = iArr[0];
        int i11 = (iArr[0] >>> 3) | (iArr[1] << 29);
        int i12 = (iArr[0] >>> 11) | (iArr[1] << 21);
        int i13 = (iArr[0] >>> 13) | (iArr[1] << 19);
        int i14 = (iArr[0] >>> 17) | (iArr[1] << 15);
        int i15 = (iArr[0] >>> 18) | (iArr[1] << 14);
        int i16 = (iArr[0] >>> 26) | (iArr[1] << 6);
        int i17 = (iArr[0] >>> 27) | (iArr[1] << 5);
        int i18 = (iArr[1] >>> 8) | (iArr[2] << 24);
        int i19 = (iArr[1] >>> 16) | (iArr[2] << 16);
        int i20 = (iArr[1] >>> 24) | (iArr[2] << 8);
        int i21 = (iArr[1] >>> 27) | (iArr[2] << 5);
        int i22 = (iArr[1] >>> 29) | (iArr[2] << 3);
        int i23 = (iArr[2] >>> 1) | (iArr[3] << 31);
        int i24 = (iArr[2] >>> 3) | (iArr[3] << 29);
        int i25 = (iArr[2] >>> 4) | (iArr[3] << 28);
        int i26 = (iArr[2] >>> 20) | (iArr[3] << 12);
        return (((((((iArr[3] ^ (((i10 ^ i16) ^ i20) ^ ((iArr[2] >>> 27) | (iArr[3] << 5)))) ^ (i11 & i24)) ^ (i12 & i13)) ^ (i14 & i15)) ^ (i17 & i21)) ^ (i18 & i19)) ^ (i22 & i23)) ^ (i25 & i26);
    }

    public final void i() {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f25236f = d();
            this.f25235e = l(this.f25235e, (h() ^ this.f25234d[0]) ^ this.f25236f);
            this.f25234d = l(this.f25234d, g() ^ this.f25236f);
        }
        this.f25238h = true;
    }

    public final void j() {
        int iD = d();
        this.f25236f = iD;
        byte[] bArr = this.f25233c;
        bArr[0] = (byte) iD;
        bArr[1] = (byte) (iD >> 8);
        bArr[2] = (byte) (iD >> 16);
        bArr[3] = (byte) (iD >> 24);
        this.f25235e = l(this.f25235e, h() ^ this.f25234d[0]);
        this.f25234d = l(this.f25234d, g());
    }

    public final void k(byte[] bArr, byte[] bArr2) {
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[14] = -1;
        bArr2[15] = -1;
        this.f25231a = bArr;
        this.f25232b = bArr2;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f25235e;
            if (i10 >= iArr.length) {
                return;
            }
            byte[] bArr3 = this.f25231a;
            int i12 = i11 + 3;
            int i13 = i11 + 2;
            int i14 = i11 + 1;
            iArr[i10] = (bArr3[i11] & 255) | (bArr3[i12] << 24) | ((bArr3[i13] << 16) & 16711680) | ((bArr3[i14] << 8) & 65280);
            int[] iArr2 = this.f25234d;
            byte[] bArr4 = this.f25232b;
            iArr2[i10] = (bArr4[i11] & 255) | (bArr4[i12] << 24) | ((bArr4[i13] << 16) & 16711680) | ((bArr4[i14] << 8) & 65280);
            i11 += 4;
            i10++;
        }
    }

    public final int[] l(int[] iArr, int i10) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = i10;
        return iArr;
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        this.f25237g = 4;
        k(this.f25231a, this.f25232b);
        i();
    }
}
