package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class l extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f36654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f36656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36657i;

    public l(org.bouncycastle.crypto.f fVar) {
        super(fVar);
        this.f36657i = false;
        int iC = fVar.c();
        this.f36651c = iC;
        this.f36655g = fVar;
        this.f36654f = new byte[iC];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            if (bArrA.length < this.f36651c) {
                throw new IllegalArgumentException("Parameter m must blockSize <= m");
            }
            this.f36650b = bArrA.length;
            l();
            byte[] bArrP = org.bouncycastle.util.a.p(bArrA);
            this.f36653e = bArrP;
            System.arraycopy(bArrP, 0, this.f36652d, 0, bArrP.length);
            if (v1Var.b() != null) {
                fVar = this.f36655g;
                kVar = v1Var.b();
                fVar.a(true, kVar);
            }
        } else {
            m();
            l();
            byte[] bArr = this.f36653e;
            System.arraycopy(bArr, 0, this.f36652d, 0, bArr.length);
            if (kVar != null) {
                fVar = this.f36655g;
                fVar.a(true, kVar);
            }
        }
        this.f36657i = true;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36655g.b() + "/OFB";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36651c;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, this.f36651c, bArr2, i11);
        return this.f36651c;
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) {
        if (this.f36656h == 0) {
            k();
        }
        byte[] bArr = this.f36654f;
        int i10 = this.f36656h;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        int i11 = i10 + 1;
        this.f36656h = i11;
        if (i11 == c()) {
            this.f36656h = 0;
            j();
        }
        return b11;
    }

    public final void j() {
        byte[] bArrA = q.a(this.f36652d, this.f36650b - this.f36651c);
        System.arraycopy(bArrA, 0, this.f36652d, 0, bArrA.length);
        System.arraycopy(this.f36654f, 0, this.f36652d, bArrA.length, this.f36650b - bArrA.length);
    }

    public final void k() {
        this.f36655g.d(q.b(this.f36652d, this.f36651c), 0, this.f36654f, 0);
    }

    public final void l() {
        int i10 = this.f36650b;
        this.f36652d = new byte[i10];
        this.f36653e = new byte[i10];
    }

    public final void m() {
        this.f36650b = this.f36651c * 2;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        if (this.f36657i) {
            byte[] bArr = this.f36653e;
            System.arraycopy(bArr, 0, this.f36652d, 0, bArr.length);
            org.bouncycastle.util.a.n(this.f36654f);
            this.f36656h = 0;
            this.f36655g.reset();
        }
    }
}
