package rp;

import np.e2;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.f0;

/* JADX INFO: loaded from: classes5.dex */
public class s implements f0 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f49055r = 188;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f49056s = 12748;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f49057t = 13004;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f49058u = 13260;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f49059v = 13516;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f49060w = 13772;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f49061x = 14028;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f49062y = 14284;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.s f49063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.bouncycastle.crypto.b f49064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f49065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f49066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f49067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f49068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f49069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f49070n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f49071o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte[] f49072p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public byte[] f49073q;

    public s(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar) {
        this(bVar, sVar, false);
    }

    public s(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, boolean z10) {
        int iIntValue;
        this.f49064h = bVar;
        this.f49063g = sVar;
        if (z10) {
            iIntValue = 188;
        } else {
            Integer numA = t.a(sVar);
            if (numA == null) {
                throw new IllegalArgumentException("no valid trailer for digest: " + sVar.b());
            }
            iIntValue = numA.intValue();
        }
        this.f49065i = iIntValue;
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        e2 e2Var = (e2) kVar;
        this.f49064h.a(z10, e2Var);
        int iBitLength = e2Var.e().bitLength();
        this.f49066j = iBitLength;
        byte[] bArr = new byte[(iBitLength + 7) / 8];
        this.f49067k = bArr;
        int i10 = this.f49065i;
        int length = bArr.length;
        if (i10 == 188) {
            this.f49068l = new byte[(length - this.f49063g.h()) - 2];
        } else {
            this.f49068l = new byte[(length - this.f49063g.h()) - 3];
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.f0
    public void b(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArrC = this.f49064h.c(bArr, 0, bArr.length);
        if (((bArrC[0] & i1.a.f31667o7) ^ 64) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        }
        if (((bArrC[bArrC.length - 1] & 15) ^ 12) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        }
        int i10 = 2;
        if (((bArrC[bArrC.length - 1] & 255) ^ 188) == 0) {
            i10 = 1;
        } else {
            int i11 = ((bArrC[bArrC.length - 2] & 255) << 8) | (bArrC[bArrC.length - 1] & 255);
            Integer numA = t.a(this.f49063g);
            if (numA == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            int iIntValue = numA.intValue();
            if (i11 != iIntValue && (iIntValue != 15052 || i11 != 16588)) {
                throw new IllegalStateException("signer initialised with wrong digest for trailer " + i11);
            }
        }
        int i12 = 0;
        while (i12 != bArrC.length && ((bArrC[i12] & 15) ^ 10) != 0) {
            i12++;
        }
        int i13 = i12 + 1;
        int length = ((bArrC.length - i10) - this.f49063g.h()) - i13;
        if (length <= 0) {
            throw new InvalidCipherTextException("malformed block");
        }
        if ((bArrC[0] & 32) == 0) {
            this.f49070n = true;
            byte[] bArr2 = new byte[length];
            this.f49071o = bArr2;
            System.arraycopy(bArrC, i13, bArr2, 0, bArr2.length);
        } else {
            this.f49070n = false;
            byte[] bArr3 = new byte[length];
            this.f49071o = bArr3;
            System.arraycopy(bArrC, i13, bArr3, 0, bArr3.length);
        }
        this.f49072p = bArr;
        this.f49073q = bArrC;
        org.bouncycastle.crypto.s sVar = this.f49063g;
        byte[] bArr4 = this.f49071o;
        sVar.update(bArr4, 0, bArr4.length);
        byte[] bArr5 = this.f49071o;
        this.f49069m = bArr5.length;
        System.arraycopy(bArr5, 0, this.f49068l, 0, bArr5.length);
    }

    @Override // org.bouncycastle.crypto.f0
    public boolean c() {
        return this.f49070n;
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        byte[] bArrC;
        byte[] bArr2 = this.f49072p;
        if (bArr2 == null) {
            try {
                bArrC = this.f49064h.c(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (!org.bouncycastle.util.a.g(bArr2, bArr)) {
                throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
            }
            bArrC = this.f49073q;
            this.f49072p = null;
            this.f49073q = null;
        }
        if (((bArrC[0] & i1.a.f31667o7) ^ 64) == 0 && ((bArrC[bArrC.length - 1] & 15) ^ 12) == 0) {
            int i10 = 2;
            if (((bArrC[bArrC.length - 1] & 255) ^ 188) == 0) {
                i10 = 1;
            } else {
                int i11 = ((bArrC[bArrC.length - 2] & 255) << 8) | (bArrC[bArrC.length - 1] & 255);
                Integer numA = t.a(this.f49063g);
                if (numA == null) {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                }
                int iIntValue = numA.intValue();
                if (i11 != iIntValue && (iIntValue != 15052 || i11 != 16588)) {
                    throw new IllegalStateException("signer initialised with wrong digest for trailer " + i11);
                }
            }
            int i12 = 0;
            while (i12 != bArrC.length && ((bArrC[i12] & 15) ^ 10) != 0) {
                i12++;
            }
            int i13 = i12 + 1;
            int iH = this.f49063g.h();
            byte[] bArr3 = new byte[iH];
            int length = (bArrC.length - i10) - iH;
            int i14 = length - i13;
            if (i14 <= 0) {
                return i(bArrC);
            }
            if ((bArrC[0] & 32) == 0) {
                this.f49070n = true;
                if (this.f49069m > i14) {
                    return i(bArrC);
                }
                this.f49063g.reset();
                this.f49063g.update(bArrC, i13, i14);
                this.f49063g.c(bArr3, 0);
                boolean z10 = true;
                for (int i15 = 0; i15 != iH; i15++) {
                    int i16 = length + i15;
                    bArrC[i16] = (byte) (bArrC[i16] ^ bArr3[i15]);
                    if (bArrC[i16] != 0) {
                        z10 = false;
                    }
                }
                if (!z10) {
                    return i(bArrC);
                }
                byte[] bArr4 = new byte[i14];
                this.f49071o = bArr4;
                System.arraycopy(bArrC, i13, bArr4, 0, bArr4.length);
            } else {
                this.f49070n = false;
                this.f49063g.c(bArr3, 0);
                boolean z11 = true;
                for (int i17 = 0; i17 != iH; i17++) {
                    int i18 = length + i17;
                    bArrC[i18] = (byte) (bArrC[i18] ^ bArr3[i17]);
                    if (bArrC[i18] != 0) {
                        z11 = false;
                    }
                }
                if (!z11) {
                    return i(bArrC);
                }
                byte[] bArr5 = new byte[i14];
                this.f49071o = bArr5;
                System.arraycopy(bArrC, i13, bArr5, 0, bArr5.length);
            }
            if (this.f49069m != 0 && !h(this.f49068l, this.f49071o)) {
                return i(bArrC);
            }
            g(this.f49068l);
            g(bArrC);
            this.f49069m = 0;
            return true;
        }
        return i(bArrC);
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() throws CryptoException {
        int i10;
        int length;
        byte b10;
        int i11;
        int iH = this.f49063g.h();
        if (this.f49065i == 188) {
            byte[] bArr = this.f49067k;
            length = (bArr.length - iH) - 1;
            this.f49063g.c(bArr, length);
            byte[] bArr2 = this.f49067k;
            bArr2[bArr2.length - 1] = u.f49086t;
            i10 = 8;
        } else {
            i10 = 16;
            byte[] bArr3 = this.f49067k;
            int length2 = (bArr3.length - iH) - 2;
            this.f49063g.c(bArr3, length2);
            byte[] bArr4 = this.f49067k;
            int length3 = bArr4.length - 2;
            int i12 = this.f49065i;
            bArr4[length3] = (byte) (i12 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i12;
            length = length2;
        }
        int i13 = this.f49069m;
        int i14 = ((((iH + i13) * 8) + i10) + 4) - this.f49066j;
        if (i14 > 0) {
            int i15 = i13 - ((i14 + 7) / 8);
            b10 = jt.l.f36952t;
            i11 = length - i15;
            System.arraycopy(this.f49068l, 0, this.f49067k, i11, i15);
            this.f49071o = new byte[i15];
        } else {
            b10 = 64;
            i11 = length - i13;
            System.arraycopy(this.f49068l, 0, this.f49067k, i11, i13);
            this.f49071o = new byte[this.f49069m];
        }
        int i16 = i11 - 1;
        if (i16 > 0) {
            for (int i17 = i16; i17 != 0; i17--) {
                this.f49067k[i17] = -69;
            }
            byte[] bArr5 = this.f49067k;
            bArr5[i16] = (byte) (bArr5[i16] ^ 1);
            bArr5[0] = 11;
            bArr5[0] = (byte) (bArr5[0] | b10);
        } else {
            byte[] bArr6 = this.f49067k;
            bArr6[0] = 10;
            bArr6[0] = (byte) (bArr6[0] | b10);
        }
        org.bouncycastle.crypto.b bVar = this.f49064h;
        byte[] bArr7 = this.f49067k;
        byte[] bArrC = bVar.c(bArr7, 0, bArr7.length);
        this.f49070n = (b10 & 32) == 0;
        byte[] bArr8 = this.f49068l;
        byte[] bArr9 = this.f49071o;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        this.f49069m = 0;
        g(this.f49068l);
        g(this.f49067k);
        return bArrC;
    }

    @Override // org.bouncycastle.crypto.f0
    public byte[] f() {
        return this.f49071o;
    }

    public final void g(byte[] bArr) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = 0;
        }
    }

    public final boolean h(byte[] bArr, byte[] bArr2) {
        boolean z10;
        int i10 = this.f49069m;
        byte[] bArr3 = this.f49068l;
        if (i10 > bArr3.length) {
            z10 = bArr3.length <= bArr2.length;
            for (int i11 = 0; i11 != this.f49068l.length; i11++) {
                if (bArr[i11] != bArr2[i11]) {
                    z10 = false;
                }
            }
        } else {
            z10 = i10 == bArr2.length;
            for (int i12 = 0; i12 != bArr2.length; i12++) {
                if (bArr[i12] != bArr2[i12]) {
                    z10 = false;
                }
            }
        }
        return z10;
    }

    public final boolean i(byte[] bArr) {
        this.f49069m = 0;
        g(this.f49068l);
        g(bArr);
        return false;
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49063g.reset();
        this.f49069m = 0;
        g(this.f49068l);
        byte[] bArr = this.f49071o;
        if (bArr != null) {
            g(bArr);
        }
        this.f49071o = null;
        this.f49070n = false;
        if (this.f49072p != null) {
            this.f49072p = null;
            g(this.f49073q);
            this.f49073q = null;
        }
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49063g.update(b10);
        int i10 = this.f49069m;
        byte[] bArr = this.f49068l;
        if (i10 < bArr.length) {
            bArr[i10] = b10;
        }
        this.f49069m = i10 + 1;
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        while (i11 > 0 && this.f49069m < this.f49068l.length) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
        this.f49063g.update(bArr, i10, i11);
        this.f49069m += i11;
    }
}
