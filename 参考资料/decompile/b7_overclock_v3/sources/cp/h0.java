package cp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.e f25303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.q f25304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.bouncycastle.crypto.a0 f25305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.h f25306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.k f25309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.bouncycastle.crypto.k f25310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public np.g1 f25311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f25312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public fp.u f25313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public org.bouncycastle.crypto.z f25314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f25315m;

    public h0(org.bouncycastle.crypto.e eVar, org.bouncycastle.crypto.q qVar, org.bouncycastle.crypto.a0 a0Var) {
        this.f25303a = eVar;
        this.f25304b = qVar;
        this.f25305c = a0Var;
        this.f25307e = new byte[a0Var.d()];
        this.f25306d = null;
    }

    public h0(org.bouncycastle.crypto.e eVar, org.bouncycastle.crypto.q qVar, org.bouncycastle.crypto.a0 a0Var, org.bouncycastle.crypto.h hVar) {
        this.f25303a = eVar;
        this.f25304b = qVar;
        this.f25305c = a0Var;
        this.f25307e = new byte[a0Var.d()];
        this.f25306d = hVar;
    }

    public final byte[] a(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int iH;
        if (i11 < this.f25312j.length + this.f25305c.d()) {
            throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
        }
        if (this.f25306d == null) {
            int length = (i11 - this.f25312j.length) - this.f25305c.d();
            byte[] bArr4 = new byte[length];
            int iC = this.f25311i.c() / 8;
            bArr2 = new byte[iC];
            int i12 = length + iC;
            byte[] bArr5 = new byte[i12];
            this.f25304b.b(bArr5, 0, i12);
            if (this.f25312j.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, iC);
                System.arraycopy(bArr5, iC, bArr4, 0, length);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, length);
                System.arraycopy(bArr5, length, bArr2, 0, iC);
            }
            bArr3 = new byte[length];
            for (int i13 = 0; i13 != length; i13++) {
                bArr3[i13] = (byte) (bArr[(this.f25312j.length + i10) + i13] ^ bArr4[i13]);
            }
            iH = 0;
        } else {
            int iD = ((np.h1) this.f25311i).d() / 8;
            byte[] bArr6 = new byte[iD];
            int iC2 = this.f25311i.c() / 8;
            bArr2 = new byte[iC2];
            int i14 = iD + iC2;
            byte[] bArr7 = new byte[i14];
            this.f25304b.b(bArr7, 0, i14);
            System.arraycopy(bArr7, 0, bArr6, 0, iD);
            System.arraycopy(bArr7, iD, bArr2, 0, iC2);
            org.bouncycastle.crypto.k n1Var = new np.n1(bArr6);
            byte[] bArr8 = this.f25315m;
            if (bArr8 != null) {
                n1Var = new np.v1(n1Var, bArr8);
            }
            this.f25306d.f(false, n1Var);
            bArr3 = new byte[this.f25306d.c((i11 - this.f25312j.length) - this.f25305c.d())];
            org.bouncycastle.crypto.h hVar = this.f25306d;
            byte[] bArr9 = this.f25312j;
            iH = hVar.h(bArr, i10 + bArr9.length, (i11 - bArr9.length) - this.f25305c.d(), bArr3, 0);
        }
        byte[] bArrB = this.f25311i.b();
        byte[] bArrE = this.f25312j.length != 0 ? e(bArrB) : null;
        int i15 = i10 + i11;
        byte[] bArrW = org.bouncycastle.util.a.W(bArr, i15 - this.f25305c.d(), i15);
        int length2 = bArrW.length;
        byte[] bArr10 = new byte[length2];
        this.f25305c.a(new np.n1(bArr2));
        org.bouncycastle.crypto.a0 a0Var = this.f25305c;
        byte[] bArr11 = this.f25312j;
        a0Var.update(bArr, i10 + bArr11.length, (i11 - bArr11.length) - length2);
        if (bArrB != null) {
            this.f25305c.update(bArrB, 0, bArrB.length);
        }
        if (this.f25312j.length != 0) {
            this.f25305c.update(bArrE, 0, bArrE.length);
        }
        this.f25305c.c(bArr10, 0);
        if (!org.bouncycastle.util.a.I(bArrW, bArr10)) {
            throw new InvalidCipherTextException("invalid MAC");
        }
        org.bouncycastle.crypto.h hVar2 = this.f25306d;
        return hVar2 == null ? bArr3 : org.bouncycastle.util.a.W(bArr3, 0, iH + hVar2.a(bArr3, iH));
    }

    public final byte[] b(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        org.bouncycastle.crypto.h hVar;
        org.bouncycastle.crypto.k n1Var;
        byte[] bArr2;
        byte[] bArr3;
        if (this.f25306d == null) {
            byte[] bArr4 = new byte[i11];
            int iC = this.f25311i.c() / 8;
            bArr3 = new byte[iC];
            int i12 = i11 + iC;
            byte[] bArr5 = new byte[i12];
            this.f25304b.b(bArr5, 0, i12);
            if (this.f25312j.length != 0) {
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
            int iD = ((np.h1) this.f25311i).d() / 8;
            byte[] bArr6 = new byte[iD];
            int iC2 = this.f25311i.c() / 8;
            byte[] bArr7 = new byte[iC2];
            int i14 = iD + iC2;
            byte[] bArr8 = new byte[i14];
            this.f25304b.b(bArr8, 0, i14);
            System.arraycopy(bArr8, 0, bArr6, 0, iD);
            System.arraycopy(bArr8, iD, bArr7, 0, iC2);
            if (this.f25315m != null) {
                hVar = this.f25306d;
                n1Var = new np.v1(new np.n1(bArr6), this.f25315m);
            } else {
                hVar = this.f25306d;
                n1Var = new np.n1(bArr6);
            }
            hVar.f(true, n1Var);
            bArr2 = new byte[this.f25306d.c(i11)];
            int iH = this.f25306d.h(bArr, i10, i11, bArr2, 0);
            i11 = iH + this.f25306d.a(bArr2, iH);
            bArr3 = bArr7;
        }
        byte[] bArrB = this.f25311i.b();
        byte[] bArrE = this.f25312j.length != 0 ? e(bArrB) : null;
        int iD2 = this.f25305c.d();
        byte[] bArr9 = new byte[iD2];
        this.f25305c.a(new np.n1(bArr3));
        this.f25305c.update(bArr2, 0, bArr2.length);
        if (bArrB != null) {
            this.f25305c.update(bArrB, 0, bArrB.length);
        }
        if (this.f25312j.length != 0) {
            this.f25305c.update(bArrE, 0, bArrE.length);
        }
        this.f25305c.c(bArr9, 0);
        byte[] bArr10 = this.f25312j;
        byte[] bArr11 = new byte[bArr10.length + i11 + iD2];
        System.arraycopy(bArr10, 0, bArr11, 0, bArr10.length);
        System.arraycopy(bArr2, 0, bArr11, this.f25312j.length, i11);
        System.arraycopy(bArr9, 0, bArr11, this.f25312j.length + i11, iD2);
        return bArr11;
    }

    public final void c(org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.v1) {
            np.v1 v1Var = (np.v1) kVar;
            this.f25315m = v1Var.a();
            kVar = v1Var.b();
        } else {
            this.f25315m = null;
        }
        this.f25311i = (np.g1) kVar;
    }

    public org.bouncycastle.crypto.h d() {
        return this.f25306d;
    }

    public byte[] e(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            org.bouncycastle.util.o.z(((long) bArr.length) * 8, bArr2, 0);
        }
        return bArr2;
    }

    public org.bouncycastle.crypto.a0 f() {
        return this.f25305c;
    }

    public void g(np.c cVar, org.bouncycastle.crypto.k kVar, fp.u uVar) {
        this.f25308f = true;
        this.f25310h = cVar;
        this.f25313k = uVar;
        c(kVar);
    }

    public void h(np.c cVar, org.bouncycastle.crypto.k kVar, org.bouncycastle.crypto.z zVar) {
        this.f25308f = false;
        this.f25309g = cVar;
        this.f25314l = zVar;
        c(kVar);
    }

    public void i(boolean z10, org.bouncycastle.crypto.k kVar, org.bouncycastle.crypto.k kVar2, org.bouncycastle.crypto.k kVar3) {
        this.f25308f = z10;
        this.f25309g = kVar;
        this.f25310h = kVar2;
        this.f25312j = new byte[0];
        c(kVar3);
    }

    public byte[] j(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f25308f) {
            fp.u uVar = this.f25313k;
            if (uVar != null) {
                org.bouncycastle.crypto.u uVarA = uVar.a();
                this.f25309g = uVarA.b().a();
                this.f25312j = uVarA.a();
            }
        } else if (this.f25314l != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i10, i11);
            try {
                this.f25310h = this.f25314l.a(byteArrayInputStream);
                this.f25312j = org.bouncycastle.util.a.W(bArr, i10, (i11 - byteArrayInputStream.available()) + i10);
            } catch (IOException e10) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e10.getMessage(), e10);
            } catch (IllegalArgumentException e11) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e11.getMessage(), e11);
            }
        }
        this.f25303a.a(this.f25309g);
        byte[] bArrB = org.bouncycastle.util.b.b(this.f25303a.b(), this.f25303a.c(this.f25310h));
        byte[] bArr2 = this.f25312j;
        if (bArr2.length != 0) {
            byte[] bArrB2 = org.bouncycastle.util.a.B(bArr2, bArrB);
            org.bouncycastle.util.a.d0(bArrB, (byte) 0);
            bArrB = bArrB2;
        }
        try {
            this.f25304b.a(new np.m1(bArrB, this.f25311i.a()));
            return this.f25308f ? b(bArr, i10, i11) : a(bArr, i10, i11);
        } finally {
            org.bouncycastle.util.a.d0(bArrB, (byte) 0);
        }
    }
}
