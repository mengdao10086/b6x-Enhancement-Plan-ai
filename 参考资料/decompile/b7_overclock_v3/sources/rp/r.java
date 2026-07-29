package rp;

import java.security.SecureRandom;
import np.e2;
import np.w1;
import np.y1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.f0;

/* JADX INFO: loaded from: classes5.dex */
public class r implements f0 {
    public static final int A = 13260;
    public static final int B = 13516;
    public static final int C = 13772;
    public static final int D = 14028;
    public static final int E = 14284;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f49035x = 188;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f49036y = 12748;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f49037z = 13004;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.s f49038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.bouncycastle.crypto.b f49039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SecureRandom f49040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f49041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f49042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f49045n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f49046o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f49047p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f49048q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f49049r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte[] f49050s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte[] f49051t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte[] f49052u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f49053v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f49054w;

    public r(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, int i10) {
        this(bVar, sVar, i10, false);
    }

    public r(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, int i10, boolean z10) {
        int iIntValue;
        this.f49039h = bVar;
        this.f49038g = sVar;
        this.f49042k = sVar.h();
        this.f49048q = i10;
        if (z10) {
            iIntValue = 188;
        } else {
            Integer numA = t.a(sVar);
            if (numA == null) {
                throw new IllegalArgumentException("no valid trailer for digest: " + sVar.b());
            }
            iIntValue = numA.intValue();
        }
        this.f49043l = iIntValue;
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        e2 e2Var;
        SecureRandom secureRandomF;
        int length = this.f49048q;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            e2Var = (e2) w1Var.a();
            if (z10) {
                secureRandomF = w1Var.b();
                this.f49040i = secureRandomF;
            }
        } else if (kVar instanceof y1) {
            y1 y1Var = (y1) kVar;
            e2Var = (e2) y1Var.a();
            byte[] bArrB = y1Var.b();
            this.f49041j = bArrB;
            length = bArrB.length;
            if (bArrB.length != this.f49048q) {
                throw new IllegalArgumentException("Fixed salt is of wrong length");
            }
        } else {
            e2Var = (e2) kVar;
            if (z10) {
                secureRandomF = org.bouncycastle.crypto.n.f();
                this.f49040i = secureRandomF;
            }
        }
        this.f49039h.a(z10, e2Var);
        int iBitLength = e2Var.e().bitLength();
        this.f49044m = iBitLength;
        byte[] bArr = new byte[(iBitLength + 7) / 8];
        this.f49045n = bArr;
        int i10 = this.f49043l;
        int length2 = bArr.length;
        if (i10 == 188) {
            this.f49046o = new byte[(((length2 - this.f49038g.h()) - length) - 1) - 1];
        } else {
            this.f49046o = new byte[(((length2 - this.f49038g.h()) - length) - 1) - 2];
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.f0
    public void b(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArrC = this.f49039h.c(bArr, 0, bArr.length);
        int length = bArrC.length;
        int i10 = this.f49044m;
        if (length < (i10 + 7) / 8) {
            int i11 = (i10 + 7) / 8;
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArrC, 0, bArr2, i11 - bArrC.length, bArrC.length);
            i(bArrC);
            bArrC = bArr2;
        }
        int i12 = 2;
        if (((bArrC[bArrC.length - 1] & 255) ^ 188) == 0) {
            i12 = 1;
        } else {
            int i13 = ((bArrC[bArrC.length - 2] & 255) << 8) | (bArrC[bArrC.length - 1] & 255);
            Integer numA = t.a(this.f49038g);
            if (numA == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            int iIntValue = numA.intValue();
            if (i13 != iIntValue && (iIntValue != 15052 || i13 != 16588)) {
                throw new IllegalStateException("signer initialised with wrong digest for trailer " + i13);
            }
        }
        this.f49038g.c(new byte[this.f49042k], 0);
        int length2 = bArrC.length;
        int i14 = this.f49042k;
        byte[] bArrK = k(bArrC, (length2 - i14) - i12, i14, (bArrC.length - i14) - i12);
        for (int i15 = 0; i15 != bArrK.length; i15++) {
            bArrC[i15] = (byte) (bArrC[i15] ^ bArrK[i15]);
        }
        bArrC[0] = (byte) (bArrC[0] & 127);
        int i16 = 0;
        while (i16 != bArrC.length && bArrC[i16] != 1) {
            i16++;
        }
        int i17 = i16 + 1;
        if (i17 >= bArrC.length) {
            i(bArrC);
        }
        this.f49049r = i17 > 1;
        byte[] bArr3 = new byte[(bArrK.length - i17) - this.f49048q];
        this.f49050s = bArr3;
        System.arraycopy(bArrC, i17, bArr3, 0, bArr3.length);
        byte[] bArr4 = this.f49050s;
        System.arraycopy(bArr4, 0, this.f49046o, 0, bArr4.length);
        this.f49051t = bArr;
        this.f49052u = bArrC;
        this.f49053v = i17;
        this.f49054w = i12;
    }

    @Override // org.bouncycastle.crypto.f0
    public boolean c() {
        return this.f49049r;
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        int i10 = this.f49042k;
        byte[] bArr2 = new byte[i10];
        this.f49038g.c(bArr2, 0);
        byte[] bArr3 = this.f49051t;
        if (bArr3 == null) {
            try {
                b(bArr);
            } catch (Exception unused) {
                return false;
            }
        } else if (!org.bouncycastle.util.a.g(bArr3, bArr)) {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        byte[] bArr4 = this.f49052u;
        int i11 = this.f49053v;
        int i12 = this.f49054w;
        this.f49051t = null;
        this.f49052u = null;
        byte[] bArr5 = new byte[8];
        h(this.f49050s.length * 8, bArr5);
        this.f49038g.update(bArr5, 0, 8);
        byte[] bArr6 = this.f49050s;
        if (bArr6.length != 0) {
            this.f49038g.update(bArr6, 0, bArr6.length);
        }
        this.f49038g.update(bArr2, 0, i10);
        byte[] bArr7 = this.f49041j;
        if (bArr7 != null) {
            this.f49038g.update(bArr7, 0, bArr7.length);
        } else {
            this.f49038g.update(bArr4, i11 + this.f49050s.length, this.f49048q);
        }
        int iH = this.f49038g.h();
        byte[] bArr8 = new byte[iH];
        this.f49038g.c(bArr8, 0);
        int length = (bArr4.length - i12) - iH;
        boolean z10 = true;
        for (int i13 = 0; i13 != iH; i13++) {
            if (bArr8[i13] != bArr4[length + i13]) {
                z10 = false;
            }
        }
        i(bArr4);
        i(bArr8);
        if (!z10) {
            this.f49049r = false;
            this.f49047p = 0;
            i(this.f49050s);
            return false;
        }
        if (this.f49047p == 0 || j(this.f49046o, this.f49050s)) {
            this.f49047p = 0;
            i(this.f49046o);
            return true;
        }
        this.f49047p = 0;
        i(this.f49046o);
        return false;
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() throws CryptoException {
        int iH = this.f49038g.h();
        byte[] bArr = new byte[iH];
        this.f49038g.c(bArr, 0);
        byte[] bArr2 = new byte[8];
        h(this.f49047p * 8, bArr2);
        this.f49038g.update(bArr2, 0, 8);
        this.f49038g.update(this.f49046o, 0, this.f49047p);
        this.f49038g.update(bArr, 0, iH);
        byte[] bArr3 = this.f49041j;
        if (bArr3 == null) {
            bArr3 = new byte[this.f49048q];
            this.f49040i.nextBytes(bArr3);
        }
        this.f49038g.update(bArr3, 0, bArr3.length);
        int iH2 = this.f49038g.h();
        byte[] bArr4 = new byte[iH2];
        this.f49038g.c(bArr4, 0);
        int i10 = this.f49043l == 188 ? 1 : 2;
        byte[] bArr5 = this.f49045n;
        int length = bArr5.length;
        int i11 = this.f49047p;
        int length2 = ((((length - i11) - bArr3.length) - this.f49042k) - i10) - 1;
        bArr5[length2] = 1;
        int i12 = length2 + 1;
        System.arraycopy(this.f49046o, 0, bArr5, i12, i11);
        System.arraycopy(bArr3, 0, this.f49045n, i12 + this.f49047p, bArr3.length);
        byte[] bArrK = k(bArr4, 0, iH2, (this.f49045n.length - this.f49042k) - i10);
        for (int i13 = 0; i13 != bArrK.length; i13++) {
            byte[] bArr6 = this.f49045n;
            bArr6[i13] = (byte) (bArr6[i13] ^ bArrK[i13]);
        }
        byte[] bArr7 = this.f49045n;
        int length3 = bArr7.length;
        int i14 = this.f49042k;
        System.arraycopy(bArr4, 0, bArr7, (length3 - i14) - i10, i14);
        int i15 = this.f49043l;
        if (i15 == 188) {
            byte[] bArr8 = this.f49045n;
            bArr8[bArr8.length - 1] = u.f49086t;
        } else {
            byte[] bArr9 = this.f49045n;
            bArr9[bArr9.length - 2] = (byte) (i15 >>> 8);
            bArr9[bArr9.length - 1] = (byte) i15;
        }
        byte[] bArr10 = this.f49045n;
        bArr10[0] = (byte) (bArr10[0] & 127);
        byte[] bArrC = this.f49039h.c(bArr10, 0, bArr10.length);
        int i16 = this.f49047p;
        byte[] bArr11 = new byte[i16];
        this.f49050s = bArr11;
        byte[] bArr12 = this.f49046o;
        this.f49049r = i16 <= bArr12.length;
        System.arraycopy(bArr12, 0, bArr11, 0, bArr11.length);
        i(this.f49046o);
        i(this.f49045n);
        this.f49047p = 0;
        return bArrC;
    }

    @Override // org.bouncycastle.crypto.f0
    public byte[] f() {
        return this.f49050s;
    }

    public final void g(int i10, byte[] bArr) {
        bArr[0] = (byte) (i10 >>> 24);
        bArr[1] = (byte) (i10 >>> 16);
        bArr[2] = (byte) (i10 >>> 8);
        bArr[3] = (byte) (i10 >>> 0);
    }

    public final void h(long j10, byte[] bArr) {
        bArr[0] = (byte) (j10 >>> 56);
        bArr[1] = (byte) (j10 >>> 48);
        bArr[2] = (byte) (j10 >>> 40);
        bArr[3] = (byte) (j10 >>> 32);
        bArr[4] = (byte) (j10 >>> 24);
        bArr[5] = (byte) (j10 >>> 16);
        bArr[6] = (byte) (j10 >>> 8);
        bArr[7] = (byte) (j10 >>> 0);
    }

    public final void i(byte[] bArr) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = 0;
        }
    }

    public final boolean j(byte[] bArr, byte[] bArr2) {
        boolean z10 = this.f49047p == bArr2.length;
        for (int i10 = 0; i10 != bArr2.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                z10 = false;
            }
        }
        return z10;
    }

    public final byte[] k(byte[] bArr, int i10, int i11, int i12) {
        int i13;
        byte[] bArr2 = new byte[i12];
        byte[] bArr3 = new byte[this.f49042k];
        byte[] bArr4 = new byte[4];
        this.f49038g.reset();
        int i14 = 0;
        while (true) {
            i13 = this.f49042k;
            if (i14 >= i12 / i13) {
                break;
            }
            g(i14, bArr4);
            this.f49038g.update(bArr, i10, i11);
            this.f49038g.update(bArr4, 0, 4);
            this.f49038g.c(bArr3, 0);
            int i15 = this.f49042k;
            System.arraycopy(bArr3, 0, bArr2, i14 * i15, i15);
            i14++;
        }
        if (i13 * i14 < i12) {
            g(i14, bArr4);
            this.f49038g.update(bArr, i10, i11);
            this.f49038g.update(bArr4, 0, 4);
            this.f49038g.c(bArr3, 0);
            int i16 = this.f49042k;
            System.arraycopy(bArr3, 0, bArr2, i14 * i16, i12 - (i14 * i16));
        }
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49038g.reset();
        this.f49047p = 0;
        byte[] bArr = this.f49046o;
        if (bArr != null) {
            i(bArr);
        }
        byte[] bArr2 = this.f49050s;
        if (bArr2 != null) {
            i(bArr2);
            this.f49050s = null;
        }
        this.f49049r = false;
        if (this.f49051t != null) {
            this.f49051t = null;
            i(this.f49052u);
            this.f49052u = null;
        }
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        if (this.f49051t == null) {
            int i10 = this.f49047p;
            byte[] bArr = this.f49046o;
            if (i10 < bArr.length) {
                this.f49047p = i10 + 1;
                bArr[i10] = b10;
                return;
            }
        }
        this.f49038g.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        if (this.f49051t == null) {
            while (i11 > 0 && this.f49047p < this.f49046o.length) {
                update(bArr[i10]);
                i10++;
                i11--;
            }
        }
        if (i11 > 0) {
            this.f49038g.update(bArr, i10, i11);
        }
    }
}
