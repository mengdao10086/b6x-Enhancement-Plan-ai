package fp;

import np.f1;
import np.n1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class x implements org.bouncycastle.crypto.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ip.k f28701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f28703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f28704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f28705e;

    public x(org.bouncycastle.crypto.s sVar) {
        this.f28701a = new ip.k(sVar);
        this.f28702b = sVar.h();
    }

    @Override // org.bouncycastle.crypto.q
    public void a(org.bouncycastle.crypto.r rVar) {
        ip.k kVar;
        n1 n1VarF;
        if (!(rVar instanceof f1)) {
            throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
        }
        f1 f1Var = (f1) rVar;
        if (f1Var.e()) {
            kVar = this.f28701a;
            n1VarF = new n1(f1Var.b());
        } else {
            kVar = this.f28701a;
            n1VarF = f(f1Var.d(), f1Var.b());
        }
        kVar.a(n1VarF);
        this.f28703c = f1Var.c();
        this.f28705e = 0;
        this.f28704d = new byte[this.f28702b];
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12 = this.f28705e;
        int i13 = i12 + i11;
        int i14 = this.f28702b;
        if (i13 > i14 * 255) {
            throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
        }
        if (i12 % i14 == 0) {
            e();
        }
        int i15 = this.f28705e;
        int i16 = this.f28702b;
        int i17 = i15 % i16;
        int iMin = Math.min(i16 - (i15 % i16), i11);
        System.arraycopy(this.f28704d, i17, bArr, i10, iMin);
        this.f28705e += iMin;
        int i18 = i11 - iMin;
        while (true) {
            i10 += iMin;
            if (i18 <= 0) {
                return i11;
            }
            e();
            iMin = Math.min(this.f28702b, i18);
            System.arraycopy(this.f28704d, 0, bArr, i10, iMin);
            this.f28705e += iMin;
            i18 -= iMin;
        }
    }

    public org.bouncycastle.crypto.s c() {
        return this.f28701a.f();
    }

    public final void e() throws DataLengthException {
        int i10 = this.f28705e;
        int i11 = this.f28702b;
        int i12 = (i10 / i11) + 1;
        if (i12 >= 256) {
            throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
        }
        if (i10 != 0) {
            this.f28701a.update(this.f28704d, 0, i11);
        }
        ip.k kVar = this.f28701a;
        byte[] bArr = this.f28703c;
        kVar.update(bArr, 0, bArr.length);
        this.f28701a.update((byte) i12);
        this.f28701a.c(this.f28704d, 0);
    }

    public final n1 f(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            this.f28701a.a(new n1(new byte[this.f28702b]));
        } else {
            this.f28701a.a(new n1(bArr));
        }
        this.f28701a.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[this.f28702b];
        this.f28701a.c(bArr3, 0);
        return new n1(bArr3);
    }
}
