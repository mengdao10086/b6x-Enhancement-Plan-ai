package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class s extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f36744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36749g;

    public s(org.bouncycastle.crypto.f fVar) {
        super(fVar);
        this.f36749g = fVar;
        this.f36744b = new byte[fVar.c()];
        this.f36745c = new byte[fVar.c()];
        this.f36746d = new byte[fVar.c()];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        this.f36748f = true;
        if (!(kVar instanceof v1)) {
            throw new IllegalArgumentException("invalid parameter passed");
        }
        v1 v1Var = (v1) kVar;
        byte[] bArrA = v1Var.a();
        byte[] bArr = this.f36744b;
        int length = bArr.length - bArrA.length;
        org.bouncycastle.util.a.d0(bArr, (byte) 0);
        System.arraycopy(bArrA, 0, this.f36744b, length, bArrA.length);
        org.bouncycastle.crypto.k kVarB = v1Var.b();
        if (kVarB != null) {
            this.f36749g.a(true, kVarB);
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36749g.b() + "/KCTR";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36749g.c();
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        if (bArr.length - i10 < c()) {
            throw new DataLengthException("input buffer too short");
        }
        if (bArr2.length - i11 < c()) {
            throw new OutputLengthException("output buffer too short");
        }
        e(bArr, i10, c(), bArr2, i11);
        return c();
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) {
        int i10 = this.f36747e;
        if (i10 == 0) {
            k(0);
            j();
            this.f36749g.d(this.f36745c, 0, this.f36746d, 0);
            byte[] bArr = this.f36746d;
            int i11 = this.f36747e;
            this.f36747e = i11 + 1;
            return (byte) (b10 ^ bArr[i11]);
        }
        byte[] bArr2 = this.f36746d;
        int i12 = i10 + 1;
        this.f36747e = i12;
        byte b11 = (byte) (b10 ^ bArr2[i10]);
        if (i12 == this.f36745c.length) {
            this.f36747e = 0;
        }
        return b11;
    }

    public final void j() {
    }

    public final void k(int i10) {
        while (true) {
            byte[] bArr = this.f36745c;
            if (i10 >= bArr.length) {
                return;
            }
            int i11 = i10 + 1;
            byte b10 = (byte) (bArr[i10] + 1);
            bArr[i10] = b10;
            if (b10 != 0) {
                return;
            } else {
                i10 = i11;
            }
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        if (this.f36748f) {
            this.f36749g.d(this.f36744b, 0, this.f36745c, 0);
        }
        this.f36749g.reset();
        this.f36747e = 0;
    }
}
