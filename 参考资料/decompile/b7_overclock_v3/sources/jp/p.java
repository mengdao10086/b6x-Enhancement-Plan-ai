package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class p extends j0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f36714k = 16843012;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f36715l = 16843009;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f36716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f36720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.crypto.f f36721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36724j;

    public p(org.bouncycastle.crypto.f fVar) {
        super(fVar);
        this.f36722h = true;
        this.f36721g = fVar;
        int iC = fVar.c();
        this.f36720f = iC;
        if (iC != 8) {
            throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
        }
        this.f36716b = new byte[fVar.c()];
        this.f36717c = new byte[fVar.c()];
        this.f36718d = new byte[fVar.c()];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        this.f36722h = true;
        this.f36723i = 0;
        this.f36724j = 0;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            int length = bArrA.length;
            byte[] bArr = this.f36716b;
            if (length < bArr.length) {
                System.arraycopy(bArrA, 0, bArr, bArr.length - bArrA.length, bArrA.length);
                int i10 = 0;
                while (true) {
                    byte[] bArr2 = this.f36716b;
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
            fVar = this.f36721g;
            kVar = v1Var.b();
        } else {
            reset();
            if (kVar == null) {
                return;
            } else {
                fVar = this.f36721g;
            }
        }
        fVar.a(true, kVar);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36721g.b() + "/GCTR";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36720f;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, this.f36720f, bArr2, i11);
        return this.f36720f;
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) {
        if (this.f36719e == 0) {
            if (this.f36722h) {
                this.f36722h = false;
                this.f36721g.d(this.f36717c, 0, this.f36718d, 0);
                this.f36723i = j(this.f36718d, 0);
                this.f36724j = j(this.f36718d, 4);
            }
            int i10 = this.f36723i + 16843009;
            this.f36723i = i10;
            int i11 = this.f36724j + 16843012;
            this.f36724j = i11;
            if (i11 < 16843012 && i11 > 0) {
                this.f36724j = i11 + 1;
            }
            k(i10, this.f36717c, 0);
            k(this.f36724j, this.f36717c, 4);
            this.f36721g.d(this.f36717c, 0, this.f36718d, 0);
        }
        byte[] bArr = this.f36718d;
        int i12 = this.f36719e;
        int i13 = i12 + 1;
        this.f36719e = i13;
        byte b11 = (byte) (b10 ^ bArr[i12]);
        int i14 = this.f36720f;
        if (i13 == i14) {
            this.f36719e = 0;
            byte[] bArr2 = this.f36717c;
            System.arraycopy(bArr2, i14, bArr2, 0, bArr2.length - i14);
            byte[] bArr3 = this.f36718d;
            byte[] bArr4 = this.f36717c;
            int length = bArr4.length;
            int i15 = this.f36720f;
            System.arraycopy(bArr3, 0, bArr4, length - i15, i15);
        }
        return b11;
    }

    public final int j(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] << 24) & (-16777216)) + ((bArr[i10 + 2] << 16) & 16711680) + ((bArr[i10 + 1] << 8) & 65280) + (bArr[i10] & 255);
    }

    public final void k(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >>> 24);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11] = (byte) i10;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        this.f36722h = true;
        this.f36723i = 0;
        this.f36724j = 0;
        byte[] bArr = this.f36716b;
        System.arraycopy(bArr, 0, this.f36717c, 0, bArr.length);
        this.f36719e = 0;
        this.f36721g.reset();
    }
}
