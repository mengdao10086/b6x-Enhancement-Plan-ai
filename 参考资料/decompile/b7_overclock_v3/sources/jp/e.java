package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class e extends j0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f36573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f36580i;

    public e(org.bouncycastle.crypto.f fVar, int i10) {
        super(fVar);
        this.f36578g = null;
        if (i10 > fVar.c() * 8 || i10 < 8 || i10 % 8 != 0) {
            throw new IllegalArgumentException("CFB" + i10 + " not supported");
        }
        this.f36578g = fVar;
        this.f36577f = i10 / 8;
        this.f36573b = new byte[fVar.c()];
        this.f36574c = new byte[fVar.c()];
        this.f36575d = new byte[fVar.c()];
        this.f36576e = new byte[this.f36577f];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        this.f36579h = z10;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            int length = bArrA.length;
            byte[] bArr = this.f36573b;
            if (length < bArr.length) {
                System.arraycopy(bArrA, 0, bArr, bArr.length - bArrA.length, bArrA.length);
                int i10 = 0;
                while (true) {
                    byte[] bArr2 = this.f36573b;
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
            fVar = this.f36578g;
            kVar = v1Var.b();
        } else {
            reset();
            if (kVar == null) {
                return;
            } else {
                fVar = this.f36578g;
            }
        }
        fVar.a(true, kVar);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36578g.b() + "/CFB" + (this.f36577f * 8);
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36577f;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, this.f36577f, bArr2, i11);
        return this.f36577f;
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) throws IllegalStateException, DataLengthException {
        return this.f36579h ? m(b10) : k(b10);
    }

    public int j(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, this.f36577f, bArr2, i11);
        return this.f36577f;
    }

    public final byte k(byte b10) {
        if (this.f36580i == 0) {
            this.f36578g.d(this.f36574c, 0, this.f36575d, 0);
        }
        byte[] bArr = this.f36576e;
        int i10 = this.f36580i;
        bArr[i10] = b10;
        byte[] bArr2 = this.f36575d;
        int i11 = i10 + 1;
        this.f36580i = i11;
        byte b11 = (byte) (b10 ^ bArr2[i10]);
        int i12 = this.f36577f;
        if (i11 == i12) {
            this.f36580i = 0;
            byte[] bArr3 = this.f36574c;
            System.arraycopy(bArr3, i12, bArr3, 0, bArr3.length - i12);
            byte[] bArr4 = this.f36576e;
            byte[] bArr5 = this.f36574c;
            int length = bArr5.length;
            int i13 = this.f36577f;
            System.arraycopy(bArr4, 0, bArr5, length - i13, i13);
        }
        return b11;
    }

    public int l(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        e(bArr, i10, this.f36577f, bArr2, i11);
        return this.f36577f;
    }

    public final byte m(byte b10) {
        if (this.f36580i == 0) {
            this.f36578g.d(this.f36574c, 0, this.f36575d, 0);
        }
        byte[] bArr = this.f36575d;
        int i10 = this.f36580i;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        byte[] bArr2 = this.f36576e;
        int i11 = i10 + 1;
        this.f36580i = i11;
        bArr2[i10] = b11;
        int i12 = this.f36577f;
        if (i11 == i12) {
            this.f36580i = 0;
            byte[] bArr3 = this.f36574c;
            System.arraycopy(bArr3, i12, bArr3, 0, bArr3.length - i12);
            byte[] bArr4 = this.f36576e;
            byte[] bArr5 = this.f36574c;
            int length = bArr5.length;
            int i13 = this.f36577f;
            System.arraycopy(bArr4, 0, bArr5, length - i13, i13);
        }
        return b11;
    }

    public byte[] n() {
        return org.bouncycastle.util.a.p(this.f36574c);
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        byte[] bArr = this.f36573b;
        System.arraycopy(bArr, 0, this.f36574c, 0, bArr.length);
        org.bouncycastle.util.a.d0(this.f36576e, (byte) 0);
        this.f36580i = 0;
        this.f36578g.reset();
    }
}
