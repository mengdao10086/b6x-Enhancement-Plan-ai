package cp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.e f25737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.q f25738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.bouncycastle.crypto.a0 f25739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.h f25740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f25742f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.bouncycastle.crypto.k f25744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public org.bouncycastle.crypto.k f25745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public np.g1 f25746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f25747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public fp.u f25748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public org.bouncycastle.crypto.z f25749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f25750n;

    public static class a implements org.bouncycastle.crypto.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public org.bouncycastle.crypto.s f25752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f25753c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f25754d;

        public a(int i10, org.bouncycastle.crypto.s sVar) {
            this.f25751a = i10;
            this.f25752b = sVar;
        }

        @Override // org.bouncycastle.crypto.q
        public void a(org.bouncycastle.crypto.r rVar) {
            if (rVar instanceof np.m1) {
                np.m1 m1Var = (np.m1) rVar;
                this.f25753c = m1Var.b();
                this.f25754d = m1Var.a();
            } else {
                if (!(rVar instanceof np.i1)) {
                    throw new IllegalArgumentException("KDF parameters required for generator");
                }
                this.f25753c = ((np.i1) rVar).a();
                this.f25754d = null;
            }
        }

        @Override // org.bouncycastle.crypto.q
        public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
            int i12 = i11;
            int i13 = i10;
            if (bArr.length - i12 < i13) {
                throw new OutputLengthException("output buffer too small");
            }
            long j10 = i12;
            int iH = this.f25752b.h();
            if (j10 > 8589934591L) {
                throw new IllegalArgumentException("output length too large");
            }
            long j11 = iH;
            int i14 = (int) (((j10 + j11) - 1) / j11);
            byte[] bArr2 = new byte[this.f25752b.h()];
            int i15 = 4;
            byte[] bArr3 = new byte[4];
            org.bouncycastle.util.o.h(this.f25751a, bArr3, 0);
            int i16 = this.f25751a & (-256);
            int i17 = 0;
            while (i17 < i14) {
                this.f25752b.update(bArr3, 0, i15);
                org.bouncycastle.crypto.s sVar = this.f25752b;
                byte[] bArr4 = this.f25753c;
                sVar.update(bArr4, 0, bArr4.length);
                byte[] bArr5 = this.f25754d;
                if (bArr5 != null) {
                    this.f25752b.update(bArr5, 0, bArr5.length);
                }
                this.f25752b.c(bArr2, 0);
                if (i12 > iH) {
                    System.arraycopy(bArr2, 0, bArr, i13, iH);
                    i13 += iH;
                    i12 -= iH;
                } else {
                    System.arraycopy(bArr2, 0, bArr, i13, i12);
                }
                byte b10 = (byte) (bArr3[3] + 1);
                bArr3[3] = b10;
                if (b10 == 0) {
                    i16 += 256;
                    org.bouncycastle.util.o.h(i16, bArr3, 0);
                }
                i17++;
                i15 = 4;
            }
            this.f25752b.reset();
            return (int) j10;
        }

        @Override // org.bouncycastle.crypto.t
        public org.bouncycastle.crypto.s c() {
            return this.f25752b;
        }
    }

    public y(org.bouncycastle.crypto.e eVar, org.bouncycastle.crypto.q qVar, org.bouncycastle.crypto.a0 a0Var, byte[] bArr) {
        this.f25737a = eVar;
        this.f25738b = qVar;
        this.f25739c = a0Var;
        this.f25741e = new byte[a0Var.d()];
        this.f25742f = bArr;
        this.f25740d = null;
    }

    public y(org.bouncycastle.crypto.e eVar, org.bouncycastle.crypto.q qVar, org.bouncycastle.crypto.a0 a0Var, byte[] bArr, org.bouncycastle.crypto.h hVar) {
        this.f25737a = eVar;
        this.f25738b = qVar;
        this.f25739c = a0Var;
        this.f25741e = new byte[a0Var.d()];
        this.f25742f = bArr;
        this.f25740d = hVar;
    }

    public final byte[] a(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int iH;
        if (i11 < this.f25747k.length + this.f25739c.d()) {
            throw new InvalidCipherTextException("length of input must be greater than the MAC and V combined");
        }
        if (this.f25740d == null) {
            int length = (i11 - this.f25747k.length) - this.f25739c.d();
            byte[] bArr4 = new byte[length];
            int iC = this.f25746j.c() / 8;
            bArr2 = new byte[iC];
            int i12 = length + iC;
            byte[] bArr5 = new byte[i12];
            this.f25738b.b(bArr5, 0, i12);
            if (this.f25747k.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, iC);
                System.arraycopy(bArr5, iC, bArr4, 0, length);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, length);
                System.arraycopy(bArr5, length, bArr2, 0, iC);
            }
            bArr3 = new byte[length];
            for (int i13 = 0; i13 != length; i13++) {
                bArr3[i13] = (byte) (bArr[(this.f25747k.length + i10) + i13] ^ bArr4[i13]);
            }
            iH = 0;
        } else {
            int iD = ((np.h1) this.f25746j).d() / 8;
            byte[] bArr6 = new byte[iD];
            int iC2 = this.f25746j.c() / 8;
            bArr2 = new byte[iC2];
            int i14 = iD + iC2;
            byte[] bArr7 = new byte[i14];
            this.f25738b.b(bArr7, 0, i14);
            System.arraycopy(bArr7, 0, bArr6, 0, iD);
            System.arraycopy(bArr7, iD, bArr2, 0, iC2);
            org.bouncycastle.crypto.k n1Var = new np.n1(bArr6);
            byte[] bArr8 = this.f25750n;
            if (bArr8 != null) {
                n1Var = new np.v1(n1Var, bArr8);
            }
            this.f25740d.f(false, n1Var);
            bArr3 = new byte[this.f25740d.c((i11 - this.f25747k.length) - this.f25739c.d())];
            org.bouncycastle.crypto.h hVar = this.f25740d;
            byte[] bArr9 = this.f25747k;
            iH = hVar.h(bArr, i10 + bArr9.length, (i11 - bArr9.length) - this.f25739c.d(), bArr3, 0);
        }
        byte[] bArrB = this.f25746j.b();
        byte[] bArrE = this.f25747k.length != 0 ? e(bArrB) : null;
        int i15 = i10 + i11;
        byte[] bArrW = org.bouncycastle.util.a.W(bArr, i15 - this.f25739c.d(), i15);
        int length2 = bArrW.length;
        byte[] bArr10 = new byte[length2];
        zo.e0 e0Var = new zo.e0();
        byte[] bArr11 = new byte[e0Var.h()];
        e0Var.reset();
        e0Var.update(bArr2, 0, bArr2.length);
        e0Var.c(bArr11, 0);
        this.f25739c.a(new np.n1(bArr11));
        org.bouncycastle.crypto.a0 a0Var = this.f25739c;
        byte[] bArr12 = this.f25750n;
        a0Var.update(bArr12, 0, bArr12.length);
        org.bouncycastle.crypto.a0 a0Var2 = this.f25739c;
        byte[] bArr13 = this.f25747k;
        a0Var2.update(bArr, i10 + bArr13.length, (i11 - bArr13.length) - length2);
        if (bArrB != null) {
            this.f25739c.update(bArrB, 0, bArrB.length);
        }
        if (this.f25747k.length != 0) {
            this.f25739c.update(bArrE, 0, bArrE.length);
        }
        org.bouncycastle.crypto.a0 a0Var3 = this.f25739c;
        byte[] bArr14 = this.f25742f;
        a0Var3.update(bArr14, 0, bArr14.length);
        this.f25739c.c(bArr10, 0);
        if (!org.bouncycastle.util.a.I(bArrW, bArr10)) {
            throw new InvalidCipherTextException("invalid MAC");
        }
        org.bouncycastle.crypto.h hVar2 = this.f25740d;
        return hVar2 == null ? bArr3 : org.bouncycastle.util.a.W(bArr3, 0, iH + hVar2.a(bArr3, iH));
    }

    public final byte[] b(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        org.bouncycastle.crypto.h hVar;
        org.bouncycastle.crypto.k n1Var;
        byte[] bArr2;
        byte[] bArr3;
        if (this.f25740d == null) {
            byte[] bArr4 = new byte[i11];
            int iC = this.f25746j.c() / 8;
            bArr3 = new byte[iC];
            int i12 = i11 + iC;
            byte[] bArr5 = new byte[i12];
            this.f25738b.b(bArr5, 0, i12);
            if (this.f25747k.length != 0) {
                System.arraycopy(bArr5, 0, bArr3, 0, iC);
                System.arraycopy(bArr5, iC, bArr4, 0, i11);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, i11);
                System.arraycopy(bArr5, i11, bArr3, 0, iC);
            }
            bArr2 = new byte[i11];
            for (int i13 = 0; i13 != i11; i13++) {
                bArr2[i13] = (byte) (bArr[i10 + i13] ^ bArr4[i13]);
            }
        } else {
            int iD = ((np.h1) this.f25746j).d() / 8;
            byte[] bArr6 = new byte[iD];
            int iC2 = this.f25746j.c() / 8;
            byte[] bArr7 = new byte[iC2];
            int i14 = iD + iC2;
            byte[] bArr8 = new byte[i14];
            this.f25738b.b(bArr8, 0, i14);
            System.arraycopy(bArr8, 0, bArr6, 0, iD);
            System.arraycopy(bArr8, iD, bArr7, 0, iC2);
            if (this.f25750n != null) {
                hVar = this.f25740d;
                n1Var = new np.v1(new np.n1(bArr6), this.f25750n);
            } else {
                hVar = this.f25740d;
                n1Var = new np.n1(bArr6);
            }
            hVar.f(true, n1Var);
            bArr2 = new byte[this.f25740d.c(i11)];
            int iH = this.f25740d.h(bArr, i10, i11, bArr2, 0);
            i11 = iH + this.f25740d.a(bArr2, iH);
            bArr3 = bArr7;
        }
        byte[] bArrB = this.f25746j.b();
        byte[] bArrE = this.f25747k.length != 0 ? e(bArrB) : null;
        int iD2 = this.f25739c.d();
        byte[] bArr9 = new byte[iD2];
        zo.e0 e0Var = new zo.e0();
        byte[] bArr10 = new byte[e0Var.h()];
        e0Var.reset();
        e0Var.update(bArr3, 0, bArr3.length);
        e0Var.c(bArr10, 0);
        this.f25739c.a(new np.n1(bArr10));
        org.bouncycastle.crypto.a0 a0Var = this.f25739c;
        byte[] bArr11 = this.f25750n;
        a0Var.update(bArr11, 0, bArr11.length);
        this.f25739c.update(bArr2, 0, bArr2.length);
        if (bArrB != null) {
            this.f25739c.update(bArrB, 0, bArrB.length);
        }
        if (this.f25747k.length != 0) {
            this.f25739c.update(bArrE, 0, bArrE.length);
        }
        org.bouncycastle.crypto.a0 a0Var2 = this.f25739c;
        byte[] bArr12 = this.f25742f;
        a0Var2.update(bArr12, 0, bArr12.length);
        this.f25739c.c(bArr9, 0);
        byte[] bArr13 = this.f25747k;
        byte[] bArr14 = new byte[bArr13.length + i11 + iD2];
        System.arraycopy(bArr13, 0, bArr14, 0, bArr13.length);
        System.arraycopy(bArr2, 0, bArr14, this.f25747k.length, i11);
        System.arraycopy(bArr9, 0, bArr14, this.f25747k.length + i11, iD2);
        return bArr14;
    }

    public final void c(org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.v1) {
            np.v1 v1Var = (np.v1) kVar;
            this.f25750n = v1Var.a();
            kVar = v1Var.b();
        } else {
            this.f25750n = null;
        }
        this.f25746j = (np.g1) kVar;
    }

    public org.bouncycastle.crypto.h d() {
        return this.f25740d;
    }

    public byte[] e(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            org.bouncycastle.util.o.z(((long) bArr.length) * 8, bArr2, 0);
        }
        return bArr2;
    }

    public org.bouncycastle.crypto.a0 f() {
        return this.f25739c;
    }

    public void g(np.c cVar, org.bouncycastle.crypto.k kVar, fp.u uVar) {
        this.f25743g = true;
        this.f25745i = cVar;
        this.f25748l = uVar;
        c(kVar);
    }

    public void h(np.c cVar, org.bouncycastle.crypto.k kVar, org.bouncycastle.crypto.z zVar) {
        this.f25743g = false;
        this.f25744h = cVar;
        this.f25749m = zVar;
        c(kVar);
    }

    public void i(boolean z10, org.bouncycastle.crypto.k kVar, org.bouncycastle.crypto.k kVar2, org.bouncycastle.crypto.k kVar3) {
        this.f25743g = z10;
        this.f25744h = kVar;
        this.f25745i = kVar2;
        this.f25747k = new byte[0];
        c(kVar3);
    }

    public byte[] j(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f25743g) {
            fp.u uVar = this.f25748l;
            if (uVar != null) {
                org.bouncycastle.crypto.u uVarA = uVar.a();
                this.f25744h = uVarA.b().a();
                this.f25747k = uVarA.a();
            }
        } else if (this.f25749m != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i10, i11);
            try {
                this.f25745i = this.f25749m.a(byteArrayInputStream);
                this.f25747k = org.bouncycastle.util.a.W(bArr, i10, (i11 - byteArrayInputStream.available()) + i10);
            } catch (IOException e10) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e10.getMessage(), e10);
            } catch (IllegalArgumentException e11) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e11.getMessage(), e11);
            }
        }
        this.f25737a.a(this.f25744h);
        byte[] bArrB = org.bouncycastle.util.b.b(this.f25737a.b(), this.f25737a.c(this.f25745i));
        byte[] bArr2 = this.f25747k;
        if (bArr2.length != 0) {
            byte[] bArrB2 = org.bouncycastle.util.a.B(bArr2, bArrB);
            org.bouncycastle.util.a.d0(bArrB, (byte) 0);
            bArrB = bArrB2;
        }
        try {
            this.f25738b.a(new np.m1(bArrB, this.f25746j.a()));
            return this.f25743g ? b(bArr, i10, i11) : a(bArr, i10, i11);
        } finally {
            org.bouncycastle.util.a.d0(bArrB, (byte) 0);
        }
    }
}
