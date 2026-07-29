package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class i0 implements org.bouncycastle.crypto.k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f25341a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25342b = 256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f25343c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f25344d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25345e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25346f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25347g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25348h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f25349i = new byte[1024];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f25350j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f25351k = false;

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            g(((np.n1) kVar).a());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to ISAAC init - " + kVar.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        return "ISAAC";
    }

    public final void c() {
        int i10;
        int i11;
        int i12 = this.f25346f;
        int i13 = this.f25347g + 1;
        this.f25347g = i13;
        this.f25346f = i12 + i13;
        for (int i14 = 0; i14 < 256; i14++) {
            int[] iArr = this.f25343c;
            int i15 = iArr[i14];
            int i16 = i14 & 3;
            if (i16 == 0) {
                i10 = this.f25345e;
                i11 = i10 << 13;
            } else if (i16 == 1) {
                i10 = this.f25345e;
                i11 = i10 >>> 6;
            } else if (i16 == 2) {
                i10 = this.f25345e;
                i11 = i10 << 2;
            } else if (i16 != 3) {
                int i17 = this.f25345e + iArr[(i14 + 128) & 255];
                this.f25345e = i17;
                int i18 = iArr[(i15 >>> 2) & 255] + i17 + this.f25346f;
                iArr[i14] = i18;
                int[] iArr2 = this.f25344d;
                int i19 = iArr[(i18 >>> 10) & 255] + i15;
                this.f25346f = i19;
                iArr2[i14] = i19;
            } else {
                i10 = this.f25345e;
                i11 = i10 >>> 16;
            }
            this.f25345e = i10 ^ i11;
            int i172 = this.f25345e + iArr[(i14 + 128) & 255];
            this.f25345e = i172;
            int i182 = iArr[(i15 >>> 2) & 255] + i172 + this.f25346f;
            iArr[i14] = i182;
            int[] iArr22 = this.f25344d;
            int i192 = iArr[(i182 >>> 10) & 255] + i15;
            this.f25346f = i192;
            iArr22[i14] = i192;
        }
    }

    public final void d(int[] iArr) {
        iArr[0] = iArr[0] ^ (iArr[1] << 11);
        iArr[3] = iArr[3] + iArr[0];
        iArr[1] = iArr[1] + iArr[2];
        iArr[1] = iArr[1] ^ (iArr[2] >>> 2);
        iArr[4] = iArr[4] + iArr[1];
        iArr[2] = iArr[2] + iArr[3];
        iArr[2] = iArr[2] ^ (iArr[3] << 8);
        iArr[5] = iArr[5] + iArr[2];
        iArr[3] = iArr[3] + iArr[4];
        iArr[3] = iArr[3] ^ (iArr[4] >>> 16);
        iArr[6] = iArr[6] + iArr[3];
        iArr[4] = iArr[4] + iArr[5];
        iArr[4] = iArr[4] ^ (iArr[5] << 10);
        iArr[7] = iArr[7] + iArr[4];
        iArr[5] = iArr[5] + iArr[6];
        iArr[5] = (iArr[6] >>> 4) ^ iArr[5];
        iArr[0] = iArr[0] + iArr[5];
        iArr[6] = iArr[6] + iArr[7];
        iArr[6] = iArr[6] ^ (iArr[7] << 8);
        iArr[1] = iArr[1] + iArr[6];
        iArr[7] = iArr[7] + iArr[0];
        iArr[7] = iArr[7] ^ (iArr[0] >>> 9);
        iArr[2] = iArr[2] + iArr[7];
        iArr[0] = iArr[0] + iArr[1];
    }

    @Override // org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (!this.f25351k) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i13 = 0; i13 < i11; i13++) {
            if (this.f25348h == 0) {
                c();
                this.f25349i = org.bouncycastle.util.o.l(this.f25344d);
            }
            byte[] bArr3 = this.f25349i;
            int i14 = this.f25348h;
            bArr2[i13 + i12] = (byte) (bArr3[i14] ^ bArr[i13 + i10]);
            this.f25348h = (i14 + 1) & 1023;
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public byte f(byte b10) {
        if (this.f25348h == 0) {
            c();
            this.f25349i = org.bouncycastle.util.o.l(this.f25344d);
        }
        byte[] bArr = this.f25349i;
        int i10 = this.f25348h;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        this.f25348h = (i10 + 1) & 1023;
        return b11;
    }

    public final void g(byte[] bArr) {
        this.f25350j = bArr;
        if (this.f25343c == null) {
            this.f25343c = new int[256];
        }
        if (this.f25344d == null) {
            this.f25344d = new int[256];
        }
        for (int i10 = 0; i10 < 256; i10++) {
            int[] iArr = this.f25343c;
            this.f25344d[i10] = 0;
            iArr[i10] = 0;
        }
        this.f25347g = 0;
        this.f25346f = 0;
        this.f25345e = 0;
        this.f25348h = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i11 = 0; i11 < length; i11 += 4) {
            this.f25344d[i11 >>> 2] = org.bouncycastle.util.o.r(bArr2, i11);
        }
        int[] iArr2 = new int[8];
        for (int i12 = 0; i12 < 8; i12++) {
            iArr2[i12] = -1640531527;
        }
        for (int i13 = 0; i13 < 4; i13++) {
            d(iArr2);
        }
        int i14 = 0;
        while (i14 < 2) {
            for (int i15 = 0; i15 < 256; i15 += 8) {
                for (int i16 = 0; i16 < 8; i16++) {
                    iArr2[i16] = iArr2[i16] + (i14 < 1 ? this.f25344d[i15 + i16] : this.f25343c[i15 + i16]);
                }
                d(iArr2);
                for (int i17 = 0; i17 < 8; i17++) {
                    this.f25343c[i15 + i17] = iArr2[i17];
                }
            }
            i14++;
        }
        c();
        this.f25351k = true;
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        g(this.f25350j);
    }
}
