package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class x extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f36817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.crypto.f f36818g;

    public x(org.bouncycastle.crypto.f fVar, int i10) {
        super(fVar);
        if (i10 > fVar.c() * 8 || i10 < 8 || i10 % 8 != 0) {
            throw new IllegalArgumentException("0FB" + i10 + " not supported");
        }
        this.f36818g = fVar;
        this.f36817f = i10 / 8;
        this.f36814c = new byte[fVar.c()];
        this.f36815d = new byte[fVar.c()];
        this.f36816e = new byte[fVar.c()];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            int length = bArrA.length;
            byte[] bArr = this.f36814c;
            if (length < bArr.length) {
                System.arraycopy(bArrA, 0, bArr, bArr.length - bArrA.length, bArrA.length);
                int i10 = 0;
                while (true) {
                    byte[] bArr2 = this.f36814c;
                    if (i10 >= bArr2.length - bArrA.length) {
                        break;
                    }
                    bArr2[i10] = 0;
                    i10++;
                }
            } else {
                System.arraycopy(bArrA, 0, bArr, 0, bArr.length);
            }
            reset();
            if (v1Var.b() == null) {
                return;
            }
            fVar = this.f36818g;
            kVar = v1Var.b();
        } else {
            reset();
            if (kVar == null) {
                return;
            } else {
                fVar = this.f36818g;
            }
        }
        fVar.a(true, kVar);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36818g.b() + "/OFB" + (this.f36817f * 8);
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36817f;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, this.f36817f, bArr2, i11);
        return this.f36817f;
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) throws IllegalStateException, DataLengthException {
        if (this.f36813b == 0) {
            this.f36818g.d(this.f36815d, 0, this.f36816e, 0);
        }
        byte[] bArr = this.f36816e;
        int i10 = this.f36813b;
        int i11 = i10 + 1;
        this.f36813b = i11;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        int i12 = this.f36817f;
        if (i11 == i12) {
            this.f36813b = 0;
            byte[] bArr2 = this.f36815d;
            System.arraycopy(bArr2, i12, bArr2, 0, bArr2.length - i12);
            byte[] bArr3 = this.f36816e;
            byte[] bArr4 = this.f36815d;
            int length = bArr4.length;
            int i13 = this.f36817f;
            System.arraycopy(bArr3, 0, bArr4, length - i13, i13);
        }
        return b11;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        byte[] bArr = this.f36814c;
        System.arraycopy(bArr, 0, this.f36815d, 0, bArr.length);
        this.f36813b = 0;
        this.f36818g.reset();
    }
}
