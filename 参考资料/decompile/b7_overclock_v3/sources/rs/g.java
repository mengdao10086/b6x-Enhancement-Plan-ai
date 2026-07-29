package rs;

import np.w1;
import org.bouncycastle.crypto.s;
import org.bouncycastle.util.o;
import rs.l;

/* JADX INFO: loaded from: classes6.dex */
public class g implements js.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f49166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f49167b;

    public g(s sVar, s sVar2) {
        if (sVar.h() != 32) {
            throw new IllegalArgumentException("n-digest needs to produce 32 bytes of output");
        }
        if (sVar2.h() != 64) {
            throw new IllegalArgumentException("2n-digest needs to produce 64 bytes of output");
        }
        this.f49166a = new a(sVar, sVar2);
    }

    public static void e(a aVar, byte[] bArr, byte[] bArr2, int i10, l.a aVar2, byte[] bArr3, byte[] bArr4, int i11) {
        l.a aVar3 = new l.a(aVar2);
        byte[] bArr5 = new byte[2048];
        byte[] bArr6 = new byte[1024];
        byte[] bArr7 = new byte[68608];
        aVar3.f49175c = 0L;
        while (true) {
            long j10 = aVar3.f49175c;
            if (j10 >= 32) {
                break;
            }
            k.a(aVar, bArr6, (int) (j10 * 32), bArr3, aVar3);
            aVar3.f49175c++;
        }
        m mVar = new m();
        aVar3.f49175c = 0L;
        while (true) {
            long j11 = aVar3.f49175c;
            if (j11 >= 32) {
                break;
            }
            mVar.d(aVar, bArr7, (int) (67 * j11 * 32), bArr6, (int) (j11 * 32), bArr4, 0);
            aVar3.f49175c++;
        }
        aVar3.f49175c = 0L;
        while (true) {
            long j12 = aVar3.f49175c;
            if (j12 >= 32) {
                break;
            }
            l.b(aVar, bArr5, (int) ((j12 * 32) + 1024), bArr7, (int) (j12 * 67 * 32), bArr4, 0);
            aVar3.f49175c++;
        }
        int i12 = 0;
        for (int i13 = 32; i13 > 0; i13 >>>= 1) {
            for (int i14 = 0; i14 < i13; i14 += 2) {
                aVar.c(bArr5, ((i13 >>> 1) * 32) + ((i14 >>> 1) * 32), bArr5, (i13 * 32) + (i14 * 32), bArr4, (i12 + 7) * 2 * 32);
            }
            i12++;
        }
        int i15 = (int) aVar2.f49175c;
        for (int i16 = 0; i16 < i11; i16++) {
            System.arraycopy(bArr5, ((32 >>> i16) * 32) + (((i15 >>> i16) ^ 1) * 32), bArr2, i10 + (i16 * 32), 32);
        }
        System.arraycopy(bArr5, 32, bArr, 0, 32);
    }

    public static void g(a aVar, byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, int i11, byte[] bArr4, int i12) {
        byte[] bArr5 = new byte[64];
        if ((i10 & 1) != 0) {
            for (int i13 = 0; i13 < 32; i13++) {
                bArr5[i13 + 32] = bArr2[i13];
            }
            for (int i14 = 0; i14 < 32; i14++) {
                bArr5[i14] = bArr3[i11 + i14];
            }
        } else {
            for (int i15 = 0; i15 < 32; i15++) {
                bArr5[i15] = bArr2[i15];
            }
            for (int i16 = 0; i16 < 32; i16++) {
                bArr5[i16 + 32] = bArr3[i11 + i16];
            }
        }
        int i17 = i11 + 32;
        int i18 = 0;
        int i19 = i10;
        while (i18 < i12 - 1) {
            int i20 = i19 >>> 1;
            if ((i20 & 1) != 0) {
                aVar.c(bArr5, 32, bArr5, 0, bArr4, (i18 + 7) * 2 * 32);
                for (int i21 = 0; i21 < 32; i21++) {
                    bArr5[i21] = bArr3[i17 + i21];
                }
            } else {
                aVar.c(bArr5, 0, bArr5, 0, bArr4, (i18 + 7) * 2 * 32);
                for (int i22 = 0; i22 < 32; i22++) {
                    bArr5[i22 + 32] = bArr3[i17 + i22];
                }
            }
            i17 += 32;
            i18++;
            i19 = i20;
        }
        aVar.c(bArr, 0, bArr5, 0, bArr4, ((i12 + 7) - 1) * 2 * 32);
    }

    @Override // js.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!z10) {
            this.f49167b = ((j) kVar).e();
        } else if (kVar instanceof w1) {
            this.f49167b = ((i) ((w1) kVar).a()).e();
        } else {
            this.f49167b = ((i) kVar).e();
        }
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        return f(this.f49166a, bArr, this.f49167b);
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        return h(this.f49166a, bArr, bArr2, this.f49167b);
    }

    public byte[] f(a aVar, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[d.f49162k];
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[64];
        long[] jArr = new long[8];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[1024];
        byte[] bArr9 = new byte[d.f49161j];
        for (int i10 = 0; i10 < 1088; i10++) {
            bArr9[i10] = bArr2[i10];
        }
        System.arraycopy(bArr9, d.f49160i, bArr3, 40968, 32);
        s sVarA = aVar.a();
        byte[] bArr10 = new byte[sVarA.h()];
        sVarA.update(bArr3, 40968, 32);
        sVarA.update(bArr, 0, bArr.length);
        sVarA.c(bArr10, 0);
        i(bArr3, 40968, 32);
        for (int i11 = 0; i11 != 8; i11++) {
            jArr[i11] = o.v(bArr10, i11 * 8);
        }
        long j10 = jArr[0] & 1152921504606846975L;
        System.arraycopy(bArr10, 16, bArr4, 0, 32);
        System.arraycopy(bArr4, 0, bArr3, 39912, 32);
        l.a aVar2 = new l.a();
        aVar2.f49173a = 11;
        aVar2.f49174b = 0L;
        aVar2.f49175c = 0L;
        System.arraycopy(bArr9, 32, bArr3, 39944, 1024);
        l.c(aVar, bArr3, 40968, 5, bArr9, aVar2, bArr3, 39944);
        s sVarA2 = aVar.a();
        sVarA2.update(bArr3, 39912, d.f49161j);
        sVarA2.update(bArr, 0, bArr.length);
        sVarA2.c(bArr5, 0);
        l.a aVar3 = new l.a();
        aVar3.f49173a = 12;
        aVar3.f49175c = (int) (j10 & 31);
        aVar3.f49174b = j10 >>> 5;
        for (int i12 = 0; i12 < 32; i12++) {
            bArr3[i12] = bArr4[i12];
        }
        byte[] bArr11 = bArr8;
        System.arraycopy(bArr9, 32, bArr11, 0, 1024);
        for (int i13 = 0; i13 < 8; i13++) {
            bArr3[32 + i13] = (byte) ((j10 >>> (i13 * 8)) & 255);
        }
        k.a(aVar, bArr7, 0, bArr9, aVar3);
        new b();
        byte[] bArr12 = bArr9;
        int iB = 40 + b.b(aVar, bArr3, 40, bArr6, bArr7, bArr11, bArr5);
        m mVar = new m();
        int i14 = iB;
        int i15 = 0;
        for (int i16 = 12; i15 < i16; i16 = 12) {
            aVar3.f49173a = i15;
            byte[] bArr13 = bArr12;
            k.a(aVar, bArr7, 0, bArr13, aVar3);
            int i17 = i14;
            int i18 = i14;
            byte[] bArr14 = bArr11;
            mVar.e(aVar, bArr3, i17, bArr6, bArr7, bArr14);
            int i19 = i18 + m.f49181f;
            e(aVar, bArr6, bArr3, i19, aVar3, bArr13, bArr14, 5);
            i14 = i19 + 160;
            long j11 = aVar3.f49174b;
            aVar3.f49175c = (int) (j11 & 31);
            aVar3.f49174b = j11 >>> 5;
            i15++;
            bArr12 = bArr13;
            bArr11 = bArr11;
        }
        i(bArr12, 0, d.f49161j);
        return bArr3;
    }

    public boolean h(a aVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length = bArr2.length;
        byte[] bArr4 = new byte[m.f49181f];
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = new byte[32];
        byte[] bArr7 = new byte[d.f49162k];
        byte[] bArr8 = new byte[d.f49160i];
        if (length != 41000) {
            throw new IllegalArgumentException("signature wrong size");
        }
        byte[] bArr9 = new byte[64];
        for (int i10 = 0; i10 < 1056; i10++) {
            bArr8[i10] = bArr3[i10];
        }
        byte[] bArr10 = new byte[32];
        for (int i11 = 0; i11 < 32; i11++) {
            bArr10[i11] = bArr2[i11];
        }
        System.arraycopy(bArr2, 0, bArr7, 0, d.f49162k);
        s sVarA = aVar.a();
        sVarA.update(bArr10, 0, 32);
        sVarA.update(bArr8, 0, d.f49160i);
        sVarA.update(bArr, 0, bArr.length);
        sVarA.c(bArr9, 0);
        long j10 = 0;
        for (int i12 = 0; i12 < 8; i12++) {
            j10 ^= ((long) (bArr7[32 + i12] & 255)) << (i12 * 8);
        }
        new b();
        b.c(aVar, bArr6, bArr7, 40, bArr8, bArr9);
        m mVar = new m();
        int i13 = 0;
        int i14 = 13352;
        while (i13 < 12) {
            byte[] bArr11 = bArr8;
            mVar.f(aVar, bArr4, bArr7, i14, bArr6, bArr8);
            int i15 = i14 + m.f49181f;
            l.b(aVar, bArr5, 0, bArr4, 0, bArr11, 0);
            byte[] bArr12 = bArr7;
            g(aVar, bArr6, bArr5, (int) (31 & j10), bArr12, i15, bArr11, 5);
            j10 >>= 5;
            i14 = i15 + 160;
            i13++;
            bArr7 = bArr12;
            bArr8 = bArr11;
        }
        byte[] bArr13 = bArr8;
        boolean z10 = true;
        for (int i16 = 0; i16 < 32; i16++) {
            if (bArr6[i16] != bArr13[i16 + 1024]) {
                z10 = false;
            }
        }
        return z10;
    }

    public final void i(byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 != i11; i12++) {
            bArr[i10 + i12] = 0;
        }
    }
}
