package ip;

import np.n1;
import np.v1;
import np.x1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class j implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f35511a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35512b = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f35516f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f35517g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f35518h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f35519i = {9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, 13, 4};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f35515e = new byte[8];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f35514d = new byte[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35513c = 0;

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        reset();
        this.f35514d = new byte[this.f35511a];
        this.f35518h = null;
        k(kVar);
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "GOST28147Mac";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        while (true) {
            int i11 = this.f35513c;
            if (i11 >= this.f35511a) {
                break;
            }
            this.f35514d[i11] = 0;
            this.f35513c = i11 + 1;
        }
        byte[] bArr2 = this.f35514d;
        byte[] bArrE = new byte[bArr2.length];
        System.arraycopy(bArr2, 0, bArrE, 0, this.f35515e.length);
        if (this.f35516f) {
            this.f35516f = false;
        } else {
            bArrE = e(this.f35514d, 0, this.f35515e);
        }
        h(this.f35517g, bArrE, 0, this.f35515e, 0);
        byte[] bArr3 = this.f35515e;
        int length = bArr3.length / 2;
        int i12 = this.f35512b;
        System.arraycopy(bArr3, length - i12, bArr, i10, i12);
        reset();
        return this.f35512b;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35512b;
    }

    public final byte[] e(byte[] bArr, int i10, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length - i10];
        System.arraycopy(bArr, i10, bArr3, 0, bArr2.length);
        for (int i11 = 0; i11 != bArr2.length; i11++) {
            bArr3[i11] = (byte) (bArr3[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }

    public final int f(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] << 24) & (-16777216)) + ((bArr[i10 + 2] << 16) & 16711680) + ((bArr[i10 + 1] << 8) & 65280) + (bArr[i10] & 255);
    }

    public final int[] g(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
        }
        int[] iArr = new int[8];
        for (int i10 = 0; i10 != 8; i10++) {
            iArr[i10] = f(bArr, i10 * 4);
        }
        return iArr;
    }

    public final void h(int[] iArr, byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iF = f(bArr, i10);
        int iF2 = f(bArr, i10 + 4);
        for (int i12 = 0; i12 < 2; i12++) {
            int i13 = 0;
            while (i13 < 8) {
                int i14 = iF2 ^ i(iF, iArr[i13]);
                i13++;
                int i15 = iF;
                iF = i14;
                iF2 = i15;
            }
        }
        j(iF, bArr2, i11);
        j(iF2, bArr2, i11 + 4);
    }

    public final int i(int i10, int i11) {
        int i12 = i11 + i10;
        byte[] bArr = this.f35519i;
        int i13 = (bArr[((i12 >> 0) & 15) + 0] << 0) + (bArr[((i12 >> 4) & 15) + 16] << 4) + (bArr[((i12 >> 8) & 15) + 32] << 8) + (bArr[((i12 >> 12) & 15) + 48] << 12) + (bArr[((i12 >> 16) & 15) + 64] << 16) + (bArr[((i12 >> 20) & 15) + 80] << 20) + (bArr[((i12 >> 24) & 15) + 96] << 24) + (bArr[((i12 >> 28) & 15) + 112] << 28);
        return (i13 << 11) | (i13 >>> 21);
    }

    public final void j(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >>> 24);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11] = (byte) i10;
    }

    public final void k(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (kVar == null) {
            return;
        }
        org.bouncycastle.crypto.k kVarB = null;
        if (kVar instanceof x1) {
            x1 x1Var = (x1) kVar;
            System.arraycopy(x1Var.b(), 0, this.f35519i, 0, x1Var.b().length);
            kVarB = x1Var.a();
        } else if (kVar instanceof n1) {
            this.f35517g = g(((n1) kVar).a());
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + kVar.getClass().getName());
            }
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            byte[] bArr = this.f35515e;
            System.arraycopy(bArrA, 0, bArr, 0, bArr.length);
            this.f35518h = v1Var.a();
            kVarB = v1Var.b();
        }
        k(kVarB);
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f35514d;
            if (i10 >= bArr.length) {
                this.f35513c = 0;
                this.f35516f = true;
                return;
            } else {
                bArr[i10] = 0;
                i10++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) throws IllegalStateException {
        int i10 = this.f35513c;
        byte[] bArr = this.f35514d;
        if (i10 == bArr.length) {
            byte[] bArrE = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArrE, 0, this.f35515e.length);
            if (this.f35516f) {
                this.f35516f = false;
                byte[] bArr2 = this.f35518h;
                if (bArr2 != null) {
                    bArrE = e(this.f35514d, 0, bArr2);
                }
            } else {
                bArrE = e(this.f35514d, 0, this.f35515e);
            }
            h(this.f35517g, bArrE, 0, this.f35515e, 0);
            this.f35513c = 0;
        }
        byte[] bArr3 = this.f35514d;
        int i11 = this.f35513c;
        this.f35513c = i11 + 1;
        bArr3[i11] = b10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i12 = this.f35511a;
        int i13 = this.f35513c;
        int i14 = i12 - i13;
        if (i11 > i14) {
            System.arraycopy(bArr, i10, this.f35514d, i13, i14);
            byte[] bArr2 = this.f35514d;
            byte[] bArrE = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, bArrE, 0, this.f35515e.length);
            if (this.f35516f) {
                this.f35516f = false;
                byte[] bArr3 = this.f35518h;
                if (bArr3 != null) {
                    bArrE = e(this.f35514d, 0, bArr3);
                }
            } else {
                bArrE = e(this.f35514d, 0, this.f35515e);
            }
            h(this.f35517g, bArrE, 0, this.f35515e, 0);
            this.f35513c = 0;
            while (true) {
                i11 -= i14;
                i10 += i14;
                if (i11 <= this.f35511a) {
                    break;
                }
                h(this.f35517g, e(bArr, i10, this.f35515e), 0, this.f35515e, 0);
                i14 = this.f35511a;
            }
        }
        System.arraycopy(bArr, i10, this.f35514d, this.f35513c, i11);
        this.f35513c += i11;
    }
}
