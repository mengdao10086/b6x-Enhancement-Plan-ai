package ls;

import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f40435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f40436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f40437c;

    public c(s sVar, int i10) {
        this.f40437c = i10;
        this.f40435a = sVar;
        this.f40436b = sVar.h();
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        int i10;
        int i11;
        c cVar = this;
        int i12 = cVar.f40436b;
        byte[] bArr3 = new byte[i12];
        cVar.f40435a.update(bArr, 0, bArr.length);
        cVar.f40435a.c(bArr3, 0);
        int i13 = cVar.f40436b << 3;
        int i14 = cVar.f40437c;
        int i15 = (i13 + (i14 - 1)) / i14;
        int iB = cVar.b((i15 << i14) + 1);
        int i16 = cVar.f40437c;
        int i17 = cVar.f40436b;
        int i18 = i17 * ((((iB + i16) - 1) / i16) + i15);
        if (i18 != bArr2.length) {
            return null;
        }
        byte[] bArr4 = new byte[i18];
        int i19 = 8;
        if (8 % i16 == 0) {
            int i20 = 8 / i16;
            int i21 = (1 << i16) - 1;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i24 < i12) {
                int i25 = i23;
                int i26 = 0;
                while (i26 < i20) {
                    int i27 = bArr3[i24] & i21;
                    int i28 = i22 + i27;
                    int i29 = cVar.f40436b;
                    int i30 = i24;
                    d(bArr2, i25 * i29, i21 - i27, bArr4, i25 * i29);
                    bArr3[i30] = (byte) (bArr3[i30] >>> cVar.f40437c);
                    i25++;
                    i26++;
                    i22 = i28;
                    i24 = i30;
                    i20 = i20;
                }
                i24++;
                i23 = i25;
            }
            int i31 = i23;
            int i32 = (i15 << cVar.f40437c) - i22;
            int i33 = 0;
            while (i33 < iB) {
                int i34 = cVar.f40436b;
                d(bArr2, i31 * i34, i21 - (i32 & i21), bArr4, i31 * i34);
                int i35 = cVar.f40437c;
                i32 >>>= i35;
                i31++;
                i33 += i35;
            }
        } else {
            long j10 = 0;
            if (i16 >= 8) {
                if (i16 < 57) {
                    int i36 = (i17 << 3) - i16;
                    int i37 = (1 << i16) - 1;
                    byte[] bArr5 = new byte[i17];
                    int i38 = 0;
                    int i39 = 0;
                    int i40 = 0;
                    while (i38 <= i36) {
                        int i41 = i38 >>> 3;
                        int i42 = i38 % 8;
                        int i43 = i36;
                        int i44 = i38 + cVar.f40437c;
                        int i45 = (i44 + 7) >>> 3;
                        long j11 = 0;
                        int i46 = 0;
                        while (i41 < i45) {
                            j11 ^= (long) ((bArr3[i41] & 255) << (i46 << 3));
                            i46++;
                            i41++;
                            i45 = i45;
                            i44 = i44;
                        }
                        int i47 = i44;
                        long j12 = j11 >>> i42;
                        int i48 = i18;
                        long j13 = i37;
                        long j14 = j12 & j13;
                        int i49 = i15;
                        i39 = (int) (((long) i39) + j14);
                        int i50 = cVar.f40436b;
                        System.arraycopy(bArr2, i40 * i50, bArr5, 0, i50);
                        for (long j15 = j14; j15 < j13; j15++) {
                            cVar.f40435a.update(bArr5, 0, i17);
                            cVar.f40435a.c(bArr5, 0);
                        }
                        int i51 = cVar.f40436b;
                        System.arraycopy(bArr5, 0, bArr4, i40 * i51, i51);
                        i40++;
                        i36 = i43;
                        i15 = i49;
                        i18 = i48;
                        i38 = i47;
                    }
                    int i52 = i15;
                    i10 = i18;
                    int i53 = i38 >>> 3;
                    if (i53 < cVar.f40436b) {
                        int i54 = i38 % 8;
                        int i55 = 0;
                        while (true) {
                            i11 = cVar.f40436b;
                            if (i53 >= i11) {
                                break;
                            }
                            j10 ^= (long) ((bArr3[i53] & 255) << (i55 << 3));
                            i55++;
                            i53++;
                        }
                        long j16 = i37;
                        long j17 = (j10 >>> i54) & j16;
                        i39 = (int) (((long) i39) + j17);
                        System.arraycopy(bArr2, i40 * i11, bArr5, 0, i11);
                        while (j17 < j16) {
                            cVar.f40435a.update(bArr5, 0, i17);
                            cVar.f40435a.c(bArr5, 0);
                            j17++;
                        }
                        int i56 = cVar.f40436b;
                        System.arraycopy(bArr5, 0, bArr4, i40 * i56, i56);
                        i40++;
                    }
                    int i57 = (i52 << cVar.f40437c) - i39;
                    int i58 = 0;
                    while (i58 < iB) {
                        int i59 = cVar.f40436b;
                        System.arraycopy(bArr2, i40 * i59, bArr5, 0, i59);
                        for (long j18 = i57 & i37; j18 < i37; j18++) {
                            cVar.f40435a.update(bArr5, 0, i17);
                            cVar.f40435a.c(bArr5, 0);
                        }
                        int i60 = cVar.f40436b;
                        System.arraycopy(bArr5, 0, bArr4, i40 * i60, i60);
                        int i61 = cVar.f40437c;
                        i57 >>>= i61;
                        i40++;
                        i58 += i61;
                    }
                }
                cVar.f40435a.update(bArr4, 0, i10);
                byte[] bArr6 = new byte[cVar.f40436b];
                cVar.f40435a.c(bArr6, 0);
                return bArr6;
            }
            int i62 = i17 / i16;
            int i63 = (1 << i16) - 1;
            int i64 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            while (i67 < i62) {
                int i68 = i64;
                long j19 = 0;
                int i69 = 0;
                while (i69 < cVar.f40437c) {
                    j19 ^= (long) ((bArr3[i68] & 255) << (i69 << 3));
                    i68++;
                    i69++;
                    iB = iB;
                }
                int i70 = iB;
                int i71 = i66;
                int i72 = 0;
                while (i72 < i19) {
                    int i73 = (int) (j19 & ((long) i63));
                    int i74 = i65 + i73;
                    int i75 = this.f40436b;
                    cVar = this;
                    d(bArr2, i71 * i75, i63 - i73, bArr4, i71 * i75);
                    j19 >>>= cVar.f40437c;
                    i71++;
                    i72++;
                    i63 = i63;
                    i67 = i67;
                    i65 = i74;
                    i19 = 8;
                }
                i67++;
                i66 = i71;
                i64 = i68;
                iB = i70;
                i19 = 8;
            }
            int i76 = iB;
            int i77 = i63;
            int i78 = cVar.f40436b % cVar.f40437c;
            int i79 = 0;
            while (i79 < i78) {
                j10 ^= (long) ((bArr3[i64] & 255) << (i79 << 3));
                i64++;
                i79++;
                i65 = i65;
                i66 = i66;
            }
            int i80 = i66;
            int i81 = i78 << 3;
            int i82 = 0;
            while (i82 < i81) {
                int i83 = (int) (j10 & ((long) i77));
                int i84 = i65 + i83;
                int i85 = cVar.f40436b;
                d(bArr2, i80 * i85, i77 - i83, bArr4, i80 * i85);
                int i86 = cVar.f40437c;
                j10 >>>= i86;
                i80++;
                i82 += i86;
                i65 = i84;
            }
            int i87 = (i15 << cVar.f40437c) - i65;
            int i88 = 0;
            while (i88 < i76) {
                int i89 = cVar.f40436b;
                d(bArr2, i80 * i89, i77 - (i87 & i77), bArr4, i80 * i89);
                int i90 = cVar.f40437c;
                i87 >>>= i90;
                i80++;
                i88 += i90;
            }
        }
        i10 = i18;
        cVar.f40435a.update(bArr4, 0, i10);
        byte[] bArr62 = new byte[cVar.f40436b];
        cVar.f40435a.c(bArr62, 0);
        return bArr62;
    }

    public int b(int i10) {
        int i11 = 1;
        int i12 = 2;
        while (i12 < i10) {
            i12 <<= 1;
            i11++;
        }
        return i11;
    }

    public int c() {
        int iH = this.f40435a.h();
        int i10 = this.f40437c;
        int i11 = ((iH << 3) + (i10 - 1)) / i10;
        int iB = b((i11 << i10) + 1);
        return iH * (i11 + (((iB + r3) - 1) / this.f40437c));
    }

    public final void d(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (i11 < 1) {
            System.arraycopy(bArr, i10, bArr2, i12, this.f40436b);
            return;
        }
        this.f40435a.update(bArr, i10, this.f40436b);
        while (true) {
            this.f40435a.c(bArr2, i12);
            i11--;
            if (i11 <= 0) {
                return;
            } else {
                this.f40435a.update(bArr2, i12, this.f40436b);
            }
        }
    }
}
