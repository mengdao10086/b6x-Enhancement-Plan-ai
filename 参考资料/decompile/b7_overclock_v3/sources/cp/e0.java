package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class e0 implements org.bouncycastle.crypto.k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25261f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25256a = new int[512];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f25257b = new int[512];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25258c = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f25262g = new byte[4];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25263h = 0;

    public static int c(int i10, int i11) {
        return o(i10 - i11);
    }

    public static int d(int i10) {
        return (i10 >>> 3) ^ (q(i10, 7) ^ q(i10, 18));
    }

    public static int g(int i10) {
        return (i10 >>> 10) ^ (q(i10, 17) ^ q(i10, 19));
    }

    public static int n(int i10) {
        return i10 & 1023;
    }

    public static int o(int i10) {
        return i10 & 511;
    }

    public static int p(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    public static int q(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.k kVarB;
        if (kVar instanceof np.v1) {
            np.v1 v1Var = (np.v1) kVar;
            this.f25260e = v1Var.a();
            kVarB = v1Var.b();
        } else {
            this.f25260e = new byte[0];
            kVarB = kVar;
        }
        if (kVarB instanceof np.n1) {
            this.f25259d = ((np.n1) kVarB).a();
            m();
            this.f25261f = true;
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to HC128 init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        return "HC-128";
    }

    @Override // org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        if (!this.f25261f) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i13 = 0; i13 < i11; i13++) {
            bArr2[i12 + i13] = (byte) (bArr[i10 + i13] ^ j());
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public byte f(byte b10) {
        return (byte) (b10 ^ j());
    }

    public final int h(int i10, int i11, int i12) {
        return (q(i10, 10) ^ q(i12, 23)) + q(i11, 8);
    }

    public final int i(int i10, int i11, int i12) {
        return (p(i10, 10) ^ p(i12, 23)) + p(i11, 8);
    }

    public final byte j() {
        if (this.f25263h == 0) {
            int iR = r();
            byte[] bArr = this.f25262g;
            bArr[0] = (byte) (iR & 255);
            int i10 = iR >> 8;
            bArr[1] = (byte) (i10 & 255);
            int i11 = i10 >> 8;
            bArr[2] = (byte) (i11 & 255);
            bArr[3] = (byte) ((i11 >> 8) & 255);
        }
        byte[] bArr2 = this.f25262g;
        int i12 = this.f25263h;
        byte b10 = bArr2[i12];
        this.f25263h = 3 & (i12 + 1);
        return b10;
    }

    public final int k(int i10) {
        int[] iArr = this.f25257b;
        return iArr[i10 & 255] + iArr[((i10 >> 16) & 255) + 256];
    }

    public final int l(int i10) {
        int[] iArr = this.f25256a;
        return iArr[i10 & 255] + iArr[((i10 >> 16) & 255) + 256];
    }

    public final void m() {
        if (this.f25259d.length != 16) {
            throw new IllegalArgumentException("The key must be 128 bits long");
        }
        this.f25263h = 0;
        this.f25258c = 0;
        int[] iArr = new int[1280];
        for (int i10 = 0; i10 < 16; i10++) {
            int i11 = i10 >> 2;
            iArr[i11] = ((this.f25259d[i10] & 255) << ((i10 & 3) * 8)) | iArr[i11];
        }
        System.arraycopy(iArr, 0, iArr, 4, 4);
        int i12 = 0;
        while (true) {
            byte[] bArr = this.f25260e;
            if (i12 >= bArr.length || i12 >= 16) {
                break;
            }
            int i13 = (i12 >> 2) + 8;
            iArr[i13] = ((bArr[i12] & 255) << ((i12 & 3) * 8)) | iArr[i13];
            i12++;
        }
        System.arraycopy(iArr, 8, iArr, 12, 4);
        for (int i14 = 16; i14 < 1280; i14++) {
            iArr[i14] = g(iArr[i14 - 2]) + iArr[i14 - 7] + d(iArr[i14 - 15]) + iArr[i14 - 16] + i14;
        }
        System.arraycopy(iArr, 256, this.f25256a, 0, 512);
        System.arraycopy(iArr, 768, this.f25257b, 0, 512);
        for (int i15 = 0; i15 < 512; i15++) {
            this.f25256a[i15] = r();
        }
        for (int i16 = 0; i16 < 512; i16++) {
            this.f25257b[i16] = r();
        }
        this.f25258c = 0;
    }

    public final int r() {
        int iL;
        int i10;
        int iO = o(this.f25258c);
        if (this.f25258c < 512) {
            int[] iArr = this.f25256a;
            iArr[iO] = iArr[iO] + h(iArr[c(iO, 3)], this.f25256a[c(iO, 10)], this.f25256a[c(iO, 511)]);
            iL = k(this.f25256a[c(iO, 12)]);
            i10 = this.f25256a[iO];
        } else {
            int[] iArr2 = this.f25257b;
            iArr2[iO] = iArr2[iO] + i(iArr2[c(iO, 3)], this.f25257b[c(iO, 10)], this.f25257b[c(iO, 511)]);
            iL = l(this.f25257b[c(iO, 12)]);
            i10 = this.f25257b[iO];
        }
        int i11 = i10 ^ iL;
        this.f25258c = n(this.f25258c + 1);
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        m();
    }
}
