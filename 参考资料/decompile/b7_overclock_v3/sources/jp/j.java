package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class j extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f36635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f36639j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f36640k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f36641l;

    public j(org.bouncycastle.crypto.f fVar) {
        this(fVar, fVar.c() * 8);
    }

    public j(org.bouncycastle.crypto.f fVar, int i10) {
        super(fVar);
        this.f36638i = false;
        if (i10 < 0 || i10 > fVar.c() * 8) {
            throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (fVar.c() * 8));
        }
        this.f36633d = fVar.c();
        this.f36636g = fVar;
        this.f36631b = i10 / 8;
        this.f36640k = new byte[c()];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        this.f36637h = z10;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            if (bArrA.length < this.f36633d) {
                throw new IllegalArgumentException("Parameter m must blockSize <= m");
            }
            this.f36632c = bArrA.length;
            l();
            byte[] bArrP = org.bouncycastle.util.a.p(bArrA);
            this.f36635f = bArrP;
            System.arraycopy(bArrP, 0, this.f36634e, 0, bArrP.length);
            if (v1Var.b() != null) {
                fVar = this.f36636g;
                kVar = v1Var.b();
                fVar.a(true, kVar);
            }
        } else {
            m();
            l();
            byte[] bArr = this.f36635f;
            System.arraycopy(bArr, 0, this.f36634e, 0, bArr.length);
            if (kVar != null) {
                fVar = this.f36636g;
                fVar.a(true, kVar);
            }
        }
        this.f36638i = true;
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36636g.b() + "/CFB" + (this.f36633d * 8);
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36631b;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, c(), bArr2, i11);
        return c();
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) {
        if (this.f36641l == 0) {
            this.f36639j = j();
        }
        byte[] bArr = this.f36639j;
        int i10 = this.f36641l;
        byte b11 = (byte) (bArr[i10] ^ b10);
        byte[] bArr2 = this.f36640k;
        int i11 = i10 + 1;
        this.f36641l = i11;
        if (this.f36637h) {
            b10 = b11;
        }
        bArr2[i10] = b10;
        if (i11 == c()) {
            this.f36641l = 0;
            k(this.f36640k);
        }
        return b11;
    }

    public byte[] j() {
        byte[] bArrB = q.b(this.f36634e, this.f36633d);
        byte[] bArr = new byte[bArrB.length];
        this.f36636g.d(bArrB, 0, bArr, 0);
        return q.b(bArr, this.f36631b);
    }

    public void k(byte[] bArr) {
        byte[] bArrA = q.a(this.f36634e, this.f36632c - this.f36631b);
        System.arraycopy(bArrA, 0, this.f36634e, 0, bArrA.length);
        System.arraycopy(bArr, 0, this.f36634e, bArrA.length, this.f36632c - bArrA.length);
    }

    public final void l() {
        int i10 = this.f36632c;
        this.f36634e = new byte[i10];
        this.f36635f = new byte[i10];
    }

    public final void m() {
        this.f36632c = this.f36633d * 2;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        this.f36641l = 0;
        org.bouncycastle.util.a.n(this.f36640k);
        org.bouncycastle.util.a.n(this.f36639j);
        if (this.f36638i) {
            byte[] bArr = this.f36635f;
            System.arraycopy(bArr, 0, this.f36634e, 0, bArr.length);
            this.f36636g.reset();
        }
    }
}
