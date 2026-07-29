package org.bouncycastle.jce.provider;

import np.n1;
import np.v1;

/* JADX INFO: loaded from: classes5.dex */
public class m extends org.bouncycastle.crypto.c0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f45483g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f45484h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f45485i = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.s f45486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f45487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f45488f;

    public m(org.bouncycastle.crypto.s sVar) {
        this.f45486d = sVar;
        if (sVar instanceof zo.u) {
            this.f45487e = 16;
        } else {
            if (!(sVar instanceof zo.c0) && !(sVar instanceof zo.z)) {
                throw new IllegalArgumentException("Digest " + sVar.b() + " unsupported");
            }
            this.f45487e = 20;
        }
        this.f45488f = 64;
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k d(int i10) {
        int i11 = i10 / 8;
        return new n1(l(3, i11), 0, i11);
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k e(int i10) {
        int i11 = i10 / 8;
        return new n1(l(1, i11), 0, i11);
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k f(int i10, int i11) {
        int i12 = i10 / 8;
        int i13 = i11 / 8;
        byte[] bArrL = l(1, i12);
        return new v1(new n1(bArrL, 0, i12), l(2, i13), 0, i13);
    }

    public final void k(byte[] bArr, int i10, byte[] bArr2) {
        int i11 = (bArr2[bArr2.length - 1] & 255) + (bArr[(bArr2.length + i10) - 1] & 255) + 1;
        bArr[(bArr2.length + i10) - 1] = (byte) i11;
        int i12 = i11 >>> 8;
        for (int length = bArr2.length - 2; length >= 0; length--) {
            int i13 = i10 + length;
            int i14 = i12 + (bArr2[length] & 255) + (bArr[i13] & 255);
            bArr[i13] = (byte) i14;
            i12 = i14 >>> 8;
        }
    }

    public final byte[] l(int i10, int i11) {
        byte[] bArr;
        byte[] bArr2;
        int i12 = this.f45488f;
        byte[] bArr3 = new byte[i12];
        byte[] bArr4 = new byte[i11];
        int i13 = 0;
        for (int i14 = 0; i14 != i12; i14++) {
            bArr3[i14] = (byte) i10;
        }
        byte[] bArr5 = this.f44663b;
        if (bArr5 == null || bArr5.length == 0) {
            bArr = new byte[0];
        } else {
            int i15 = this.f45488f;
            int length = i15 * (((bArr5.length + i15) - 1) / i15);
            bArr = new byte[length];
            for (int i16 = 0; i16 != length; i16++) {
                byte[] bArr6 = this.f44663b;
                bArr[i16] = bArr6[i16 % bArr6.length];
            }
        }
        byte[] bArr7 = this.f44662a;
        if (bArr7 == null || bArr7.length == 0) {
            bArr2 = new byte[0];
        } else {
            int i17 = this.f45488f;
            int length2 = i17 * (((bArr7.length + i17) - 1) / i17);
            bArr2 = new byte[length2];
            for (int i18 = 0; i18 != length2; i18++) {
                byte[] bArr8 = this.f44662a;
                bArr2[i18] = bArr8[i18 % bArr8.length];
            }
        }
        int length3 = bArr.length + bArr2.length;
        byte[] bArr9 = new byte[length3];
        System.arraycopy(bArr, 0, bArr9, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr9, bArr.length, bArr2.length);
        int i19 = this.f45488f;
        byte[] bArr10 = new byte[i19];
        int i20 = this.f45487e;
        int i21 = ((i11 + i20) - 1) / i20;
        int i22 = 1;
        while (i22 <= i21) {
            int i23 = this.f45487e;
            byte[] bArr11 = new byte[i23];
            this.f45486d.update(bArr3, i13, i12);
            this.f45486d.update(bArr9, i13, length3);
            this.f45486d.c(bArr11, i13);
            for (int i24 = 1; i24 != this.f44664c; i24++) {
                this.f45486d.update(bArr11, i13, i23);
                this.f45486d.c(bArr11, i13);
            }
            for (int i25 = 0; i25 != i19; i25++) {
                bArr10[i22] = bArr11[i25 % i23];
            }
            int i26 = 0;
            while (true) {
                int i27 = this.f45488f;
                if (i26 == length3 / i27) {
                    break;
                }
                k(bArr9, i27 * i26, bArr10);
                i26++;
            }
            if (i22 == i21) {
                int i28 = i22 - 1;
                int i29 = this.f45487e;
                System.arraycopy(bArr11, 0, bArr4, i28 * i29, i11 - (i28 * i29));
            } else {
                System.arraycopy(bArr11, 0, bArr4, (i22 - 1) * this.f45487e, i23);
            }
            i22++;
            i13 = 0;
        }
        return bArr4;
    }
}
