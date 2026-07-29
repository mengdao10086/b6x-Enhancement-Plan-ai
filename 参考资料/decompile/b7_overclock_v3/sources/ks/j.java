package ks;

import com.blankj.utilcode.util.i0;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.reflect.Array;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f39189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f39191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f39192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f39193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f39194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39195g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ls.a f39196h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f39197i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f39198j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f39199k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f39200l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f39201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f39202n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f39203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f39204p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f39205q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f39206r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f39207s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte[] f39208t;

    public j(s sVar, int i10, int i11) {
        this.f39189a = sVar;
        this.f39196h = new ls.a(sVar);
        int iH = this.f39189a.h();
        this.f39190b = iH;
        this.f39195g = i10;
        this.f39207s = i11;
        this.f39198j = (1 << i10) - 1;
        this.f39197i = (int) Math.ceil(((double) (iH << 3)) / ((double) i10));
    }

    public j(s sVar, byte[][] bArr, int[] iArr) {
        this.f39189a = sVar;
        this.f39196h = new ls.a(sVar);
        this.f39201m = iArr[0];
        this.f39200l = iArr[1];
        this.f39202n = iArr[2];
        this.f39199k = iArr[3];
        this.f39205q = iArr[4];
        this.f39191c = iArr[5];
        this.f39207s = iArr[6];
        this.f39195g = iArr[7];
        this.f39206r = iArr[8];
        int iH = this.f39189a.h();
        this.f39190b = iH;
        int i10 = this.f39195g;
        this.f39198j = (1 << i10) - 1;
        this.f39197i = (int) Math.ceil(((double) (iH << 3)) / ((double) i10));
        this.f39192d = bArr[0];
        this.f39208t = bArr[1];
        this.f39193e = bArr[2];
        this.f39194f = bArr[3];
        this.f39203o = (((long) (bArr[4][1] & 255)) << 8) | ((long) (bArr[4][0] & 255)) | (((long) (bArr[4][2] & 255)) << 16) | (((long) (bArr[4][3] & 255)) << 24) | (((long) (bArr[4][4] & 255)) << 32) | (((long) (bArr[4][5] & 255)) << 40) | (((long) (bArr[4][6] & 255)) << 48) | (((long) (bArr[4][7] & 255)) << 56);
        this.f39204p = ((long) (bArr[4][8] & 255)) | (((long) (bArr[4][9] & 255)) << 8) | (((long) (bArr[4][10] & 255)) << 16) | (((long) (bArr[4][11] & 255)) << 24) | (((long) (bArr[4][12] & 255)) << 32) | (((long) (bArr[4][13] & 255)) << 40) | (((long) (bArr[4][14] & 255)) << 48) | (((long) (bArr[4][15] & 255)) << 56);
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

    public byte[] b() {
        return this.f39194f;
    }

    public byte[][] c() {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, 5, this.f39190b);
        bArr[0] = this.f39192d;
        bArr[1] = this.f39208t;
        bArr[2] = this.f39193e;
        bArr[3] = this.f39194f;
        bArr[4] = e();
        return bArr;
    }

    public int[] d() {
        return new int[]{this.f39201m, this.f39200l, this.f39202n, this.f39199k, this.f39205q, this.f39191c, this.f39207s, this.f39195g, this.f39206r};
    }

    public byte[] e() {
        long j10 = this.f39203o;
        long j11 = this.f39204p;
        return new byte[]{(byte) (j10 & 255), (byte) ((j10 >> 8) & 255), (byte) ((j10 >> 16) & 255), (byte) ((j10 >> 24) & 255), (byte) ((j10 >> 32) & 255), (byte) ((j10 >> 40) & 255), (byte) ((j10 >> 48) & 255), (byte) ((j10 >> 56) & 255), (byte) (j11 & 255), (byte) ((j11 >> 8) & 255), (byte) ((j11 >> 16) & 255), (byte) ((j11 >> 24) & 255), (byte) ((j11 >> 32) & 255), (byte) ((j11 >> 40) & 255), (byte) ((j11 >> 48) & 255), (byte) ((j11 >> 56) & 255)};
    }

    public void f(byte[] bArr, byte[] bArr2) {
        int i10;
        int i11;
        this.f39193e = new byte[this.f39190b];
        this.f39189a.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[this.f39189a.h()];
        this.f39193e = bArr3;
        this.f39189a.c(bArr3, 0);
        int i12 = this.f39190b;
        byte[] bArr4 = new byte[i12];
        System.arraycopy(this.f39193e, 0, bArr4, 0, i12);
        int iA = a((this.f39197i << this.f39195g) + 1);
        int i13 = this.f39195g;
        int i14 = 8;
        if (8 % i13 == 0) {
            int i15 = 8 / i13;
            i10 = 0;
            for (int i16 = 0; i16 < this.f39190b; i16++) {
                for (int i17 = 0; i17 < i15; i17++) {
                    i10 += bArr4[i16] & this.f39198j;
                    bArr4[i16] = (byte) (bArr4[i16] >>> this.f39195g);
                }
            }
            int i18 = (this.f39197i << this.f39195g) - i10;
            this.f39206r = i18;
            int i19 = 0;
            while (i19 < iA) {
                i10 += this.f39198j & i18;
                int i20 = this.f39195g;
                i18 >>>= i20;
                i19 += i20;
            }
        } else if (i13 < 8) {
            int i21 = this.f39190b / i13;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i22 < i21) {
                long j10 = 0;
                for (int i25 = 0; i25 < this.f39195g; i25++) {
                    j10 ^= (long) ((bArr4[i23] & 255) << (i25 << 3));
                    i23++;
                }
                int i26 = 0;
                while (i26 < i14) {
                    i24 += (int) (((long) this.f39198j) & j10);
                    j10 >>>= this.f39195g;
                    i26++;
                    i21 = i21;
                    i14 = 8;
                }
                i22++;
                i14 = 8;
            }
            int i27 = this.f39190b % this.f39195g;
            long j11 = 0;
            for (int i28 = 0; i28 < i27; i28++) {
                j11 ^= (long) ((bArr4[i23] & 255) << (i28 << 3));
                i23++;
            }
            int i29 = i27 << 3;
            int i30 = 0;
            while (i30 < i29) {
                i24 += (int) (((long) this.f39198j) & j11);
                int i31 = this.f39195g;
                j11 >>>= i31;
                i30 += i31;
            }
            int i32 = (this.f39197i << this.f39195g) - i24;
            this.f39206r = i32;
            i10 = i24;
            int i33 = 0;
            while (i33 < iA) {
                i10 += this.f39198j & i32;
                int i34 = this.f39195g;
                i32 >>>= i34;
                i33 += i34;
            }
        } else if (i13 < 57) {
            int i35 = 0;
            int i36 = 0;
            while (true) {
                i11 = this.f39190b;
                int i37 = this.f39195g;
                if (i35 > (i11 << 3) - i37) {
                    break;
                }
                int i38 = i35 % 8;
                i35 += i37;
                int i39 = (i35 + 7) >>> 3;
                long j12 = 0;
                int i40 = 0;
                for (int i41 = i35 >>> 3; i41 < i39; i41++) {
                    j12 ^= (long) ((bArr4[i41] & 255) << (i40 << 3));
                    i40++;
                }
                i36 = (int) (((long) i36) + ((j12 >>> i38) & ((long) this.f39198j)));
            }
            int i42 = i35 >>> 3;
            if (i42 < i11) {
                int i43 = i35 % 8;
                int i44 = 0;
                long j13 = 0;
                while (i42 < this.f39190b) {
                    j13 ^= (long) ((bArr4[i42] & 255) << (i44 << 3));
                    i44++;
                    i42++;
                }
                i36 = (int) (((long) i36) + ((j13 >>> i43) & ((long) this.f39198j)));
            }
            int i45 = (this.f39197i << this.f39195g) - i36;
            this.f39206r = i45;
            i10 = i36;
            int i46 = 0;
            while (i46 < iA) {
                i10 += this.f39198j & i45;
                int i47 = this.f39195g;
                i45 >>>= i47;
                i46 += i47;
            }
        } else {
            i10 = 0;
        }
        int iCeil = this.f39197i + ((int) Math.ceil(((double) iA) / ((double) this.f39195g)));
        this.f39191c = iCeil;
        this.f39205q = (int) Math.ceil(((double) (iCeil + i10)) / ((double) (1 << this.f39207s)));
        int i48 = this.f39191c;
        int i49 = this.f39190b;
        this.f39194f = new byte[i48 * i49];
        this.f39201m = 0;
        this.f39200l = 0;
        this.f39202n = 0;
        this.f39203o = 0L;
        this.f39199k = 0;
        this.f39192d = new byte[i49];
        byte[] bArr5 = new byte[i49];
        this.f39208t = bArr5;
        System.arraycopy(bArr, 0, bArr5, 0, i49);
    }

    public final void g() {
        long j10;
        int i10 = this.f39195g;
        if (8 % i10 == 0) {
            int i11 = this.f39200l;
            if (i11 == 0) {
                this.f39192d = this.f39196h.c(this.f39208t);
                int i12 = this.f39202n;
                if (i12 < this.f39190b) {
                    byte[] bArr = this.f39193e;
                    this.f39200l = bArr[i12] & this.f39198j;
                    bArr[i12] = (byte) (bArr[i12] >>> this.f39195g);
                } else {
                    int i13 = this.f39206r;
                    this.f39200l = this.f39198j & i13;
                    this.f39206r = i13 >>> this.f39195g;
                }
            } else if (i11 > 0) {
                s sVar = this.f39189a;
                byte[] bArr2 = this.f39192d;
                sVar.update(bArr2, 0, bArr2.length);
                byte[] bArr3 = new byte[this.f39189a.h()];
                this.f39192d = bArr3;
                this.f39189a.c(bArr3, 0);
                this.f39200l--;
            }
            if (this.f39200l == 0) {
                byte[] bArr4 = this.f39192d;
                byte[] bArr5 = this.f39194f;
                int i14 = this.f39201m;
                int i15 = this.f39190b;
                System.arraycopy(bArr4, 0, bArr5, i14 * i15, i15);
                int i16 = this.f39201m + 1;
                this.f39201m = i16;
                if (i16 % (8 / this.f39195g) == 0) {
                    this.f39202n++;
                    return;
                }
                return;
            }
            return;
        }
        if (i10 < 8) {
            int i17 = this.f39200l;
            if (i17 == 0) {
                int i18 = this.f39201m;
                if (i18 % 8 == 0) {
                    int i19 = this.f39202n;
                    int i20 = this.f39190b;
                    if (i19 < i20) {
                        this.f39204p = 0L;
                        if (i18 < ((i20 / i10) << 3)) {
                            for (int i21 = 0; i21 < this.f39195g; i21++) {
                                long j11 = this.f39204p;
                                byte[] bArr6 = this.f39193e;
                                int i22 = this.f39202n;
                                this.f39204p = j11 ^ ((long) ((bArr6[i22] & 255) << (i21 << 3)));
                                this.f39202n = i22 + 1;
                            }
                        } else {
                            for (int i23 = 0; i23 < this.f39190b % this.f39195g; i23++) {
                                long j12 = this.f39204p;
                                byte[] bArr7 = this.f39193e;
                                int i24 = this.f39202n;
                                this.f39204p = j12 ^ ((long) ((bArr7[i24] & 255) << (i23 << 3)));
                                this.f39202n = i24 + 1;
                            }
                        }
                    }
                }
                if (this.f39201m == this.f39197i) {
                    this.f39204p = this.f39206r;
                }
                this.f39200l = (int) (this.f39204p & ((long) this.f39198j));
                this.f39192d = this.f39196h.c(this.f39208t);
            } else if (i17 > 0) {
                s sVar2 = this.f39189a;
                byte[] bArr8 = this.f39192d;
                sVar2.update(bArr8, 0, bArr8.length);
                byte[] bArr9 = new byte[this.f39189a.h()];
                this.f39192d = bArr9;
                this.f39189a.c(bArr9, 0);
                this.f39200l--;
            }
            if (this.f39200l != 0) {
                return;
            }
            byte[] bArr10 = this.f39192d;
            byte[] bArr11 = this.f39194f;
            int i25 = this.f39201m;
            int i26 = this.f39190b;
            System.arraycopy(bArr10, 0, bArr11, i25 * i26, i26);
            this.f39204p >>>= this.f39195g;
        } else {
            if (i10 >= 57) {
                return;
            }
            long j13 = this.f39203o;
            if (j13 == 0) {
                this.f39204p = 0L;
                this.f39202n = 0;
                int i27 = this.f39199k;
                int i28 = i27 % 8;
                int i29 = i27 >>> 3;
                int i30 = this.f39190b;
                if (i29 < i30) {
                    if (i27 <= (i30 << 3) - i10) {
                        int i31 = i27 + i10;
                        this.f39199k = i31;
                        i30 = (i31 + 7) >>> 3;
                    } else {
                        this.f39199k = i27 + i10;
                    }
                    while (true) {
                        j10 = this.f39204p;
                        if (i29 >= i30) {
                            break;
                        }
                        int i32 = this.f39193e[i29] & 255;
                        int i33 = this.f39202n;
                        this.f39204p = j10 ^ ((long) (i32 << (i33 << 3)));
                        this.f39202n = i33 + 1;
                        i29++;
                    }
                    long j14 = j10 >>> i28;
                    this.f39204p = j14;
                    this.f39203o = j14 & ((long) this.f39198j);
                } else {
                    int i34 = this.f39206r;
                    this.f39203o = this.f39198j & i34;
                    this.f39206r = i34 >>> i10;
                }
                this.f39192d = this.f39196h.c(this.f39208t);
            } else if (j13 > 0) {
                s sVar3 = this.f39189a;
                byte[] bArr12 = this.f39192d;
                sVar3.update(bArr12, 0, bArr12.length);
                byte[] bArr13 = new byte[this.f39189a.h()];
                this.f39192d = bArr13;
                this.f39189a.c(bArr13, 0);
                this.f39203o--;
            }
            if (this.f39203o != 0) {
                return;
            }
            byte[] bArr14 = this.f39192d;
            byte[] bArr15 = this.f39194f;
            int i35 = this.f39201m;
            int i36 = this.f39190b;
            System.arraycopy(bArr14, 0, bArr15, i35 * i36, i36);
        }
        this.f39201m++;
    }

    public boolean h() {
        for (int i10 = 0; i10 < this.f39205q; i10++) {
            if (this.f39201m < this.f39191c) {
                g();
            }
            if (this.f39201m == this.f39191c) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String str = "" + this.f39204p + GlideException.a.f12263d;
        int[] iArrD = d();
        byte[][] bArrC = c();
        for (int i10 = 0; i10 < 9; i10++) {
            str = str + iArrD[i10] + i0.f11861z;
        }
        for (int i11 = 0; i11 < 5; i11++) {
            str = str + new String(jt.h.h(bArrC[i11])) + i0.f11861z;
        }
        return str;
    }
}
