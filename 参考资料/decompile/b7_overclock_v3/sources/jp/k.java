package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class k extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f36646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.crypto.f f36647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36649i;

    public k(org.bouncycastle.crypto.f fVar) {
        this(fVar, fVar.c() * 8);
    }

    public k(org.bouncycastle.crypto.f fVar, int i10) {
        super(fVar);
        this.f36648h = 0;
        if (i10 < 0 || i10 > fVar.c() * 8) {
            throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (fVar.c() * 8));
        }
        this.f36647g = fVar;
        int iC = fVar.c();
        this.f36646f = iC;
        this.f36642b = i10 / 8;
        this.f36643c = new byte[iC];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            l();
            byte[] bArrP = org.bouncycastle.util.a.p(v1Var.a());
            this.f36644d = bArrP;
            if (bArrP.length != this.f36646f / 2) {
                throw new IllegalArgumentException("Parameter IV length must be == blockSize/2");
            }
            System.arraycopy(bArrP, 0, this.f36643c, 0, bArrP.length);
            for (int length = this.f36644d.length; length < this.f36646f; length++) {
                this.f36643c[length] = 0;
            }
            if (v1Var.b() != null) {
                fVar = this.f36647g;
                kVar = v1Var.b();
                fVar.a(true, kVar);
            }
        } else {
            l();
            if (kVar != null) {
                fVar = this.f36647g;
                fVar.a(true, kVar);
            }
        }
        this.f36649i = true;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36647g.b() + "/GCTR";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36642b;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, this.f36642b, bArr2, i11);
        return this.f36642b;
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) {
        if (this.f36648h == 0) {
            this.f36645e = j();
        }
        byte[] bArr = this.f36645e;
        int i10 = this.f36648h;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        int i11 = i10 + 1;
        this.f36648h = i11;
        if (i11 == this.f36642b) {
            this.f36648h = 0;
            k();
        }
        return b11;
    }

    public final byte[] j() {
        byte[] bArr = this.f36643c;
        byte[] bArr2 = new byte[bArr.length];
        this.f36647g.d(bArr, 0, bArr2, 0);
        return q.b(bArr2, this.f36642b);
    }

    public final void k() {
        byte[] bArr = this.f36643c;
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] + 1);
    }

    public final void l() {
        int i10 = this.f36646f;
        this.f36644d = new byte[i10 / 2];
        this.f36643c = new byte[i10];
        this.f36645e = new byte[this.f36642b];
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        if (this.f36649i) {
            byte[] bArr = this.f36644d;
            System.arraycopy(bArr, 0, this.f36643c, 0, bArr.length);
            for (int length = this.f36644d.length; length < this.f36646f; length++) {
                this.f36643c[length] = 0;
            }
            this.f36648h = 0;
            this.f36647g.reset();
        }
    }
}
