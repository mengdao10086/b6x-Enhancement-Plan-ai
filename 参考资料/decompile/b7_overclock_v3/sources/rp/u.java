package rp;

import java.security.SecureRandom;
import np.c2;
import np.e2;
import np.w1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.e0;
import org.bouncycastle.crypto.m0;

/* JADX INFO: loaded from: classes5.dex */
public class u implements e0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte f49086t = -68;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.s f49087g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.bouncycastle.crypto.s f49088h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public org.bouncycastle.crypto.b f49089i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SecureRandom f49090j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f49091k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f49092l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f49093m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f49094n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f49095o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte[] f49096p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public byte[] f49097q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte[] f49098r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte f49099s;

    public u(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, int i10) {
        this(bVar, sVar, i10, f49086t);
    }

    public u(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, int i10, byte b10) {
        this(bVar, sVar, sVar, i10, b10);
    }

    public u(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, org.bouncycastle.crypto.s sVar2, int i10) {
        this(bVar, sVar, sVar2, i10, f49086t);
    }

    public u(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, org.bouncycastle.crypto.s sVar2, int i10, byte b10) {
        this.f49089i = bVar;
        this.f49087g = sVar;
        this.f49088h = sVar2;
        this.f49091k = sVar.h();
        this.f49092l = sVar2.h();
        this.f49093m = false;
        this.f49094n = i10;
        this.f49096p = new byte[i10];
        this.f49097q = new byte[i10 + 8 + this.f49091k];
        this.f49099s = b10;
    }

    public u(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, org.bouncycastle.crypto.s sVar2, byte[] bArr) {
        this(bVar, sVar, sVar2, bArr, f49086t);
    }

    public u(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, org.bouncycastle.crypto.s sVar2, byte[] bArr, byte b10) {
        this.f49089i = bVar;
        this.f49087g = sVar;
        this.f49088h = sVar2;
        this.f49091k = sVar.h();
        this.f49092l = sVar2.h();
        this.f49093m = true;
        int length = bArr.length;
        this.f49094n = length;
        this.f49096p = bArr;
        this.f49097q = new byte[length + 8 + this.f49091k];
        this.f49099s = b10;
    }

    public u(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar, byte[] bArr) {
        this(bVar, sVar, sVar, bArr, f49086t);
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        org.bouncycastle.crypto.k kVarA;
        e2 e2VarB;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            kVarA = w1Var.a();
            this.f49090j = w1Var.b();
        } else {
            if (z10) {
                this.f49090j = org.bouncycastle.crypto.n.f();
            }
            kVarA = kVar;
        }
        if (kVarA instanceof c2) {
            e2VarB = ((c2) kVarA).b();
            this.f49089i.a(z10, kVar);
        } else {
            e2VarB = (e2) kVarA;
            this.f49089i.a(z10, kVarA);
        }
        int iBitLength = e2VarB.e().bitLength() - 1;
        this.f49095o = iBitLength;
        if (iBitLength < (this.f49091k * 8) + (this.f49094n * 8) + 9) {
            throw new IllegalArgumentException("key too small for specified hash and salt lengths");
        }
        this.f49098r = new byte[(iBitLength + 7) / 8];
        reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        byte[] bArr2;
        int length;
        org.bouncycastle.crypto.s sVar = this.f49087g;
        byte[] bArr3 = this.f49097q;
        sVar.c(bArr3, (bArr3.length - this.f49091k) - this.f49094n);
        try {
            byte[] bArrC = this.f49089i.c(bArr, 0, bArr.length);
            byte[] bArr4 = this.f49098r;
            org.bouncycastle.util.a.e0(bArr4, 0, bArr4.length - bArrC.length, (byte) 0);
            byte[] bArr5 = this.f49098r;
            System.arraycopy(bArrC, 0, bArr5, bArr5.length - bArrC.length, bArrC.length);
            bArr2 = this.f49098r;
            length = 255 >>> ((bArr2.length * 8) - this.f49095o);
        } catch (Exception unused) {
        }
        if ((255 & bArr2[0]) != (bArr2[0] & length) || bArr2[bArr2.length - 1] != this.f49099s) {
            h(bArr2);
            return false;
        }
        int length2 = bArr2.length;
        int i10 = this.f49091k;
        byte[] bArrI = i(bArr2, (length2 - i10) - 1, i10, (bArr2.length - i10) - 1);
        for (int i11 = 0; i11 != bArrI.length; i11++) {
            byte[] bArr6 = this.f49098r;
            bArr6[i11] = (byte) (bArr6[i11] ^ bArrI[i11]);
        }
        byte[] bArr7 = this.f49098r;
        bArr7[0] = (byte) (length & bArr7[0]);
        int i12 = 0;
        while (true) {
            byte[] bArr8 = this.f49098r;
            int length3 = bArr8.length;
            int i13 = this.f49091k;
            int i14 = this.f49094n;
            if (i12 != ((length3 - i13) - i14) - 2) {
                if (bArr8[i12] != 0) {
                    h(bArr8);
                    return false;
                }
                i12++;
            } else {
                if (bArr8[((bArr8.length - i13) - i14) - 2] != 1) {
                    h(bArr8);
                    return false;
                }
                if (this.f49093m) {
                    byte[] bArr9 = this.f49096p;
                    byte[] bArr10 = this.f49097q;
                    System.arraycopy(bArr9, 0, bArr10, bArr10.length - i14, i14);
                } else {
                    int length4 = ((bArr8.length - i14) - i13) - 1;
                    byte[] bArr11 = this.f49097q;
                    System.arraycopy(bArr8, length4, bArr11, bArr11.length - i14, i14);
                }
                org.bouncycastle.crypto.s sVar2 = this.f49087g;
                byte[] bArr12 = this.f49097q;
                sVar2.update(bArr12, 0, bArr12.length);
                org.bouncycastle.crypto.s sVar3 = this.f49087g;
                byte[] bArr13 = this.f49097q;
                sVar3.c(bArr13, bArr13.length - this.f49091k);
                int length5 = this.f49098r.length;
                int i15 = this.f49091k;
                int i16 = (length5 - i15) - 1;
                int length6 = this.f49097q.length - i15;
                while (true) {
                    byte[] bArr14 = this.f49097q;
                    if (length6 == bArr14.length) {
                        h(bArr14);
                        h(this.f49098r);
                        return true;
                    }
                    if ((this.f49098r[i16] ^ bArr14[length6]) != 0) {
                        h(bArr14);
                        h(this.f49098r);
                        return false;
                    }
                    i16++;
                    length6++;
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() throws DataLengthException, CryptoException {
        org.bouncycastle.crypto.s sVar = this.f49087g;
        byte[] bArr = this.f49097q;
        sVar.c(bArr, (bArr.length - this.f49091k) - this.f49094n);
        if (this.f49094n != 0) {
            if (!this.f49093m) {
                this.f49090j.nextBytes(this.f49096p);
            }
            byte[] bArr2 = this.f49096p;
            byte[] bArr3 = this.f49097q;
            int length = bArr3.length;
            int i10 = this.f49094n;
            System.arraycopy(bArr2, 0, bArr3, length - i10, i10);
        }
        int i11 = this.f49091k;
        byte[] bArr4 = new byte[i11];
        org.bouncycastle.crypto.s sVar2 = this.f49087g;
        byte[] bArr5 = this.f49097q;
        sVar2.update(bArr5, 0, bArr5.length);
        this.f49087g.c(bArr4, 0);
        byte[] bArr6 = this.f49098r;
        int length2 = bArr6.length;
        int i12 = this.f49094n;
        int i13 = this.f49091k;
        bArr6[(((length2 - i12) - 1) - i13) - 1] = 1;
        System.arraycopy(this.f49096p, 0, bArr6, ((bArr6.length - i12) - i13) - 1, i12);
        byte[] bArrI = i(bArr4, 0, i11, (this.f49098r.length - this.f49091k) - 1);
        for (int i14 = 0; i14 != bArrI.length; i14++) {
            byte[] bArr7 = this.f49098r;
            bArr7[i14] = (byte) (bArr7[i14] ^ bArrI[i14]);
        }
        byte[] bArr8 = this.f49098r;
        int length3 = bArr8.length;
        int i15 = this.f49091k;
        System.arraycopy(bArr4, 0, bArr8, (length3 - i15) - 1, i15);
        byte[] bArr9 = this.f49098r;
        bArr9[0] = (byte) ((255 >>> ((bArr9.length * 8) - this.f49095o)) & bArr9[0]);
        bArr9[bArr9.length - 1] = this.f49099s;
        byte[] bArrC = this.f49089i.c(bArr9, 0, bArr9.length);
        h(this.f49098r);
        return bArrC;
    }

    public final void g(int i10, byte[] bArr) {
        bArr[0] = (byte) (i10 >>> 24);
        bArr[1] = (byte) (i10 >>> 16);
        bArr[2] = (byte) (i10 >>> 8);
        bArr[3] = (byte) (i10 >>> 0);
    }

    public final void h(byte[] bArr) {
        for (int i10 = 0; i10 != bArr.length; i10++) {
            bArr[i10] = 0;
        }
    }

    public final byte[] i(byte[] bArr, int i10, int i11, int i12) {
        org.bouncycastle.crypto.s sVar = this.f49088h;
        if (!(sVar instanceof m0)) {
            return j(bArr, i10, i11, i12);
        }
        byte[] bArr2 = new byte[i12];
        sVar.update(bArr, i10, i11);
        ((m0) this.f49088h).f(bArr2, 0, i12);
        return bArr2;
    }

    public final byte[] j(byte[] bArr, int i10, int i11, int i12) {
        int i13;
        byte[] bArr2 = new byte[i12];
        byte[] bArr3 = new byte[this.f49092l];
        byte[] bArr4 = new byte[4];
        this.f49088h.reset();
        int i14 = 0;
        while (true) {
            i13 = this.f49092l;
            if (i14 >= i12 / i13) {
                break;
            }
            g(i14, bArr4);
            this.f49088h.update(bArr, i10, i11);
            this.f49088h.update(bArr4, 0, 4);
            this.f49088h.c(bArr3, 0);
            int i15 = this.f49092l;
            System.arraycopy(bArr3, 0, bArr2, i14 * i15, i15);
            i14++;
        }
        if (i13 * i14 < i12) {
            g(i14, bArr4);
            this.f49088h.update(bArr, i10, i11);
            this.f49088h.update(bArr4, 0, 4);
            this.f49088h.c(bArr3, 0);
            int i16 = this.f49092l;
            System.arraycopy(bArr3, 0, bArr2, i14 * i16, i12 - (i14 * i16));
        }
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49087g.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49087g.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49087g.update(bArr, i10, i11);
    }
}
