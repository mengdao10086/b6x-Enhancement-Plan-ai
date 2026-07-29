package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class i implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36629f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36630g;

    public i(org.bouncycastle.crypto.f fVar) {
        this.f36625b = fVar.c();
        this.f36628e = fVar;
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        this.f36630g = z10;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            if (bArrA.length < this.f36625b) {
                throw new IllegalArgumentException("Parameter m must blockSize <= m");
            }
            this.f36624a = bArrA.length;
            h();
            byte[] bArrP = org.bouncycastle.util.a.p(bArrA);
            this.f36627d = bArrP;
            System.arraycopy(bArrP, 0, this.f36626c, 0, bArrP.length);
            if (v1Var.b() != null) {
                fVar = this.f36628e;
                kVar = v1Var.b();
                fVar.a(z10, kVar);
            }
        } else {
            i();
            h();
            byte[] bArr = this.f36627d;
            System.arraycopy(bArr, 0, this.f36626c, 0, bArr.length);
            if (kVar != null) {
                fVar = this.f36628e;
                fVar.a(z10, kVar);
            }
        }
        this.f36629f = true;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36628e.b() + "/CBC";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36625b;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        return this.f36630g ? f(bArr, i10, bArr2, i11) : e(bArr, i10, bArr2, i11);
    }

    public final int e(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArrB = q.b(this.f36626c, this.f36625b);
        byte[] bArrC = q.c(bArr, this.f36625b, i10);
        byte[] bArr3 = new byte[bArrC.length];
        this.f36628e.d(bArrC, 0, bArr3, 0);
        byte[] bArrD = q.d(bArr3, bArrB);
        System.arraycopy(bArrD, 0, bArr2, i11, bArrD.length);
        if (bArr2.length > i11 + bArrD.length) {
            g(bArrC);
        }
        return bArrD.length;
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArrD = q.d(q.c(bArr, this.f36625b, i10), q.b(this.f36626c, this.f36625b));
        int length = bArrD.length;
        byte[] bArr3 = new byte[length];
        this.f36628e.d(bArrD, 0, bArr3, 0);
        System.arraycopy(bArr3, 0, bArr2, i11, length);
        if (bArr2.length > i11 + bArrD.length) {
            g(bArr3);
        }
        return length;
    }

    public final void g(byte[] bArr) {
        byte[] bArrA = q.a(this.f36626c, this.f36624a - this.f36625b);
        System.arraycopy(bArrA, 0, this.f36626c, 0, bArrA.length);
        System.arraycopy(bArr, 0, this.f36626c, bArrA.length, this.f36624a - bArrA.length);
    }

    public final void h() {
        int i10 = this.f36624a;
        this.f36626c = new byte[i10];
        this.f36627d = new byte[i10];
    }

    public final void i() {
        this.f36624a = this.f36625b;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        if (this.f36629f) {
            byte[] bArr = this.f36627d;
            System.arraycopy(bArr, 0, this.f36626c, 0, bArr.length);
            this.f36628e.reset();
        }
    }
}
