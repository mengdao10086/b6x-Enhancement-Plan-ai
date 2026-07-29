package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class c implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f36550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f36551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f36555f;

    public c(org.bouncycastle.crypto.f fVar) {
        this.f36554e = fVar;
        int iC = fVar.c();
        this.f36553d = iC;
        this.f36550a = new byte[iC];
        this.f36551b = new byte[iC];
        this.f36552c = new byte[iC];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        boolean z11 = this.f36555f;
        this.f36555f = z10;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            if (bArrA.length != this.f36553d) {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
            System.arraycopy(bArrA, 0, this.f36550a, 0, bArrA.length);
            reset();
            if (v1Var.b() == null) {
                if (z11 != z10) {
                    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
                }
                return;
            } else {
                fVar = this.f36554e;
                kVar = v1Var.b();
            }
        } else {
            reset();
            if (kVar == null) {
                if (z11 != z10) {
                    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
                }
                return;
            }
            fVar = this.f36554e;
        }
        fVar.a(z10, kVar);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36554e.b() + "/CBC";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36554e.c();
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        return this.f36555f ? f(bArr, i10, bArr2, i11) : e(bArr, i10, bArr2, i11);
    }

    public final int e(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12 = this.f36553d;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        System.arraycopy(bArr, i10, this.f36552c, 0, i12);
        int iD = this.f36554e.d(bArr, i10, bArr2, i11);
        for (int i13 = 0; i13 < this.f36553d; i13++) {
            int i14 = i11 + i13;
            bArr2[i14] = (byte) (bArr2[i14] ^ this.f36551b[i13]);
        }
        byte[] bArr3 = this.f36551b;
        this.f36551b = this.f36552c;
        this.f36552c = bArr3;
        return iD;
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        if (this.f36553d + i10 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        for (int i12 = 0; i12 < this.f36553d; i12++) {
            byte[] bArr3 = this.f36551b;
            bArr3[i12] = (byte) (bArr3[i12] ^ bArr[i10 + i12]);
        }
        int iD = this.f36554e.d(this.f36551b, 0, bArr2, i11);
        byte[] bArr4 = this.f36551b;
        System.arraycopy(bArr2, i11, bArr4, 0, bArr4.length);
        return iD;
    }

    public org.bouncycastle.crypto.f g() {
        return this.f36554e;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        byte[] bArr = this.f36550a;
        System.arraycopy(bArr, 0, this.f36551b, 0, bArr.length);
        org.bouncycastle.util.a.d0(this.f36552c, (byte) 0);
        this.f36554e.reset();
    }
}
