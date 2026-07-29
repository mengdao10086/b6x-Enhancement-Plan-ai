package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class k1 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25419g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25420h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25421i = -1640531527;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25422j = -957401312;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25427e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25428f;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            this.f25428f = z10;
            this.f25427e = true;
            h(((np.n1) kVar).a());
        } else {
            throw new IllegalArgumentException("invalid parameter passed to TEA init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "TEA";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (!this.f25427e) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 8 <= bArr2.length) {
            return this.f25428f ? g(bArr, i10, bArr2, i11) : f(bArr, i10, bArr2, i11);
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
        int i12 = f25422j;
        for (int i13 = 0; i13 != 32; i13++) {
            iE2 -= (((iE << 4) + this.f25425c) ^ (iE + i12)) ^ ((iE >>> 5) + this.f25426d);
            iE -= (((iE2 << 4) + this.f25423a) ^ (iE2 + i12)) ^ ((iE2 >>> 5) + this.f25424b);
            i12 += 1640531527;
        }
        i(iE, bArr2, i11);
        i(iE2, bArr2, i11 + 4);
        return 8;
    }

    public final int g(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iE = e(bArr, i10);
        int iE2 = e(bArr, i10 + 4);
        int i12 = iE;
        int i13 = 0;
        for (int i14 = 0; i14 != 32; i14++) {
            i13 -= 1640531527;
            i12 += (((iE2 << 4) + this.f25423a) ^ (iE2 + i13)) ^ ((iE2 >>> 5) + this.f25424b);
            iE2 += (((i12 << 4) + this.f25425c) ^ (i12 + i13)) ^ ((i12 >>> 5) + this.f25426d);
        }
        i(i12, bArr2, i11);
        i(iE2, bArr2, i11 + 4);
        return 8;
    }

    public final void h(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        this.f25423a = e(bArr, 0);
        this.f25424b = e(bArr, 4);
        this.f25425c = e(bArr, 8);
        this.f25426d = e(bArr, 12);
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
