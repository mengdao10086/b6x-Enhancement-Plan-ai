package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class r1 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f25619f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25620g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25621h = -1640531527;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25622a = new int[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f25623b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f25624c = new int[32];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25625d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25626e;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            this.f25626e = z10;
            this.f25625d = true;
            h(((np.n1) kVar).a());
        } else {
            throw new IllegalArgumentException("invalid parameter passed to TEA init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "XTEA";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (!this.f25625d) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 8 <= bArr2.length) {
            return this.f25626e ? g(bArr, i10, bArr2, i11) : f(bArr, i10, bArr2, i11);
        }
        throw new OutputLengthException("output buffer too short");
    }

    public final int e(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i10] << 24) | ((bArr[i11] & 255) << 16);
        int i14 = i12 + 1;
        return (bArr[i14] & 255) | i13 | ((bArr[i12] & 255) << 8);
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iE = e(bArr, i10);
        int iE2 = e(bArr, i10 + 4);
        for (int i12 = 31; i12 >= 0; i12--) {
            iE2 -= (((iE << 4) ^ (iE >>> 5)) + iE) ^ this.f25624c[i12];
            iE -= (((iE2 << 4) ^ (iE2 >>> 5)) + iE2) ^ this.f25623b[i12];
        }
        i(iE, bArr2, i11);
        i(iE2, bArr2, i11 + 4);
        return 8;
    }

    public final int g(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iE = e(bArr, i10);
        int iE2 = e(bArr, i10 + 4);
        for (int i12 = 0; i12 < 32; i12++) {
            iE += (((iE2 << 4) ^ (iE2 >>> 5)) + iE2) ^ this.f25623b[i12];
            iE2 += (((iE << 4) ^ (iE >>> 5)) + iE) ^ this.f25624c[i12];
        }
        i(iE, bArr2, i11);
        i(iE2, bArr2, i11 + 4);
        return 8;
    }

    public final void h(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < 4) {
            this.f25622a[i10] = e(bArr, i11);
            i10++;
            i11 += 4;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < 32; i13++) {
            int[] iArr = this.f25623b;
            int[] iArr2 = this.f25622a;
            iArr[i13] = iArr2[i12 & 3] + i12;
            i12 -= 1640531527;
            this.f25624c[i13] = iArr2[(i12 >>> 11) & 3] + i12;
        }
    }

    public final void i(int i10, byte[] bArr, int i11) {
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i10 >>> 24);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i10 >>> 16);
        bArr[i13] = (byte) (i10 >>> 8);
        bArr[i13 + 1] = (byte) i10;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
