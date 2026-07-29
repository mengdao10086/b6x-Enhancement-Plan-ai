package ls;

import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f40438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f40439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f40440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[][] f40441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f40442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f40443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f40444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f40445h;

    public d(byte[] bArr, s sVar, int i10) {
        this.f40442e = i10;
        this.f40438a = sVar;
        this.f40443f = new a(sVar);
        this.f40439b = this.f40438a.h();
        int i11 = (((r3 << 3) + i10) - 1) / i10;
        this.f40444g = i11;
        this.f40445h = a((i11 << i10) + 1);
        int i12 = this.f40444g + (((r3 + i10) - 1) / i10);
        this.f40440c = i12;
        this.f40441d = new byte[i12][];
        int i13 = this.f40439b;
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, 0, bArr2, 0, i13);
        for (int i14 = 0; i14 < this.f40440c; i14++) {
            this.f40441d[i14] = this.f40443f.c(bArr2);
        }
    }

    public int a(int i10) {
        int i11 = 1;
        int i12 = 2;
        while (i12 < i10) {
            i12 <<= 1;
            i11++;
        }
        return i11;
    }

    public byte[][] b() {
        return this.f40441d;
    }

    public byte[] c() {
        int i10 = this.f40440c * this.f40439b;
        byte[] bArr = new byte[i10];
        int i11 = (1 << this.f40442e) - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f40440c; i13++) {
            e(i13, i11, bArr, i12);
            i12 += this.f40439b;
        }
        this.f40438a.update(bArr, 0, i10);
        byte[] bArr2 = new byte[this.f40439b];
        this.f40438a.c(bArr2, 0);
        return bArr2;
    }

    public byte[] d(byte[] bArr) {
        int i10;
        int i11 = this.f40440c;
        int i12 = this.f40439b;
        byte[] bArr2 = new byte[i11 * i12];
        byte[] bArr3 = new byte[i12];
        int i13 = 0;
        this.f40438a.update(bArr, 0, bArr.length);
        this.f40438a.c(bArr3, 0);
        int i14 = this.f40442e;
        int i15 = 8;
        if (8 % i14 == 0) {
            int i16 = 8 / i14;
            int i17 = (1 << i14) - 1;
            int i18 = 0;
            int i19 = 0;
            for (int i20 = 0; i20 < i12; i20++) {
                for (int i21 = 0; i21 < i16; i21++) {
                    int i22 = bArr3[i20] & i17;
                    i18 += i22;
                    e(i19, i22, bArr2, this.f40439b * i19);
                    bArr3[i20] = (byte) (bArr3[i20] >>> this.f40442e);
                    i19++;
                }
            }
            int i23 = (this.f40444g << this.f40442e) - i18;
            while (i13 < this.f40445h) {
                e(i19, i23 & i17, bArr2, this.f40439b * i19);
                int i24 = this.f40442e;
                i23 >>>= i24;
                i19++;
                i13 += i24;
            }
        } else if (i14 < 8) {
            int i25 = this.f40439b / i14;
            int i26 = (1 << i14) - 1;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            while (i27 < i25) {
                long j10 = 0;
                for (int i31 = 0; i31 < this.f40442e; i31++) {
                    j10 ^= (long) ((bArr3[i28] & 255) << (i31 << 3));
                    i28++;
                }
                long j11 = j10;
                int i32 = 0;
                while (i32 < i15) {
                    int i33 = ((int) j11) & i26;
                    i30 += i33;
                    e(i29, i33, bArr2, this.f40439b * i29);
                    j11 >>>= this.f40442e;
                    i29++;
                    i32++;
                    i15 = 8;
                }
                i27++;
                i15 = 8;
            }
            int i34 = this.f40439b % this.f40442e;
            long j12 = 0;
            for (int i35 = 0; i35 < i34; i35++) {
                j12 ^= (long) ((bArr3[i28] & 255) << (i35 << 3));
                i28++;
            }
            int i36 = i34 << 3;
            int i37 = 0;
            while (i37 < i36) {
                int i38 = ((int) j12) & i26;
                i30 += i38;
                e(i29, i38, bArr2, this.f40439b * i29);
                int i39 = this.f40442e;
                j12 >>>= i39;
                i29++;
                i37 += i39;
            }
            int i40 = (this.f40444g << this.f40442e) - i30;
            while (i13 < this.f40445h) {
                e(i29, i40 & i26, bArr2, this.f40439b * i29);
                int i41 = this.f40442e;
                i40 >>>= i41;
                i29++;
                i13 += i41;
            }
        } else if (i14 < 57) {
            int i42 = this.f40439b;
            int i43 = (i42 << 3) - i14;
            int i44 = (1 << i14) - 1;
            byte[] bArr4 = new byte[i42];
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            while (i45 <= i43) {
                int i48 = i45 >>> 3;
                int i49 = i45 % 8;
                i45 += this.f40442e;
                int i50 = (i45 + 7) >>> 3;
                int i51 = 0;
                long j13 = 0;
                while (i48 < i50) {
                    j13 ^= (long) ((bArr3[i48] & 255) << (i51 << 3));
                    i51++;
                    i48++;
                    bArr3 = bArr3;
                    i43 = i43;
                }
                byte[] bArr5 = bArr3;
                int i52 = i43;
                long j14 = (j13 >>> i49) & ((long) i44);
                i47 = (int) (((long) i47) + j14);
                System.arraycopy(this.f40441d[i46], 0, bArr4, 0, this.f40439b);
                while (j14 > 0) {
                    this.f40438a.update(bArr4, 0, i42);
                    this.f40438a.c(bArr4, 0);
                    j14--;
                }
                int i53 = this.f40439b;
                System.arraycopy(bArr4, 0, bArr2, i46 * i53, i53);
                i46++;
                bArr3 = bArr5;
                i43 = i52;
            }
            byte[] bArr6 = bArr3;
            int i54 = i45 >>> 3;
            if (i54 < this.f40439b) {
                int i55 = i45 % 8;
                int i56 = 0;
                long j15 = 0;
                while (true) {
                    i10 = this.f40439b;
                    if (i54 >= i10) {
                        break;
                    }
                    j15 ^= (long) ((bArr6[i54] & 255) << (i56 << 3));
                    i56++;
                    i54++;
                }
                long j16 = (j15 >>> i55) & ((long) i44);
                i47 = (int) (((long) i47) + j16);
                System.arraycopy(this.f40441d[i46], 0, bArr4, 0, i10);
                while (j16 > 0) {
                    this.f40438a.update(bArr4, 0, i42);
                    this.f40438a.c(bArr4, 0);
                    j16--;
                }
                int i57 = this.f40439b;
                System.arraycopy(bArr4, 0, bArr2, i46 * i57, i57);
                i46++;
            }
            int i58 = (this.f40444g << this.f40442e) - i47;
            int i59 = 0;
            while (i59 < this.f40445h) {
                System.arraycopy(this.f40441d[i46], 0, bArr4, 0, this.f40439b);
                for (long j17 = i58 & i44; j17 > 0; j17--) {
                    this.f40438a.update(bArr4, 0, i42);
                    this.f40438a.c(bArr4, 0);
                }
                int i60 = this.f40439b;
                System.arraycopy(bArr4, 0, bArr2, i46 * i60, i60);
                int i61 = this.f40442e;
                i58 >>>= i61;
                i46++;
                i59 += i61;
            }
        }
        return bArr2;
    }

    public final void e(int i10, int i11, byte[] bArr, int i12) {
        if (i11 < 1) {
            System.arraycopy(this.f40441d[i10], 0, bArr, i12, this.f40439b);
            return;
        }
        this.f40438a.update(this.f40441d[i10], 0, this.f40439b);
        while (true) {
            this.f40438a.c(bArr, i12);
            i11--;
            if (i11 <= 0) {
                return;
            } else {
                this.f40438a.update(bArr, i12, this.f40439b);
            }
        }
    }
}
