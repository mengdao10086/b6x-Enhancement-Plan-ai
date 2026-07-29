package ip;

import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class b implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f35468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.f f35470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35471e;

    public b(org.bouncycastle.crypto.f fVar) {
        this(fVar, (fVar.c() * 8) / 2);
    }

    public b(org.bouncycastle.crypto.f fVar, int i10) {
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        this.f35470d = new jp.c(fVar);
        this.f35471e = i10 / 8;
        this.f35467a = new byte[fVar.c()];
        this.f35468b = new byte[fVar.c()];
        this.f35469c = 0;
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        reset();
        this.f35470d.a(true, kVar);
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35470d.b();
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        int iC = this.f35470d.c();
        while (true) {
            int i11 = this.f35469c;
            if (i11 >= iC) {
                this.f35470d.d(this.f35468b, 0, this.f35467a, 0);
                System.arraycopy(this.f35467a, 0, bArr, i10, this.f35471e);
                reset();
                return this.f35471e;
            }
            this.f35468b[i11] = 0;
            this.f35469c = i11 + 1;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35471e;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f35468b;
            if (i10 >= bArr.length) {
                this.f35469c = 0;
                this.f35470d.reset();
                return;
            } else {
                bArr[i10] = 0;
                i10++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        int i10 = this.f35469c;
        byte[] bArr = this.f35468b;
        if (i10 == bArr.length) {
            this.f35470d.d(bArr, 0, this.f35467a, 0);
            this.f35469c = 0;
        }
        byte[] bArr2 = this.f35468b;
        int i11 = this.f35469c;
        this.f35469c = i11 + 1;
        bArr2[i11] = b10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int iC = this.f35470d.c();
        int i12 = this.f35469c;
        int i13 = iC - i12;
        if (i11 > i13) {
            System.arraycopy(bArr, i10, this.f35468b, i12, i13);
            this.f35470d.d(this.f35468b, 0, this.f35467a, 0);
            this.f35469c = 0;
            i11 -= i13;
            i10 += i13;
            while (i11 > iC) {
                this.f35470d.d(bArr, i10, this.f35467a, 0);
                i11 -= iC;
                i10 += iC;
            }
        }
        System.arraycopy(bArr, i10, this.f35468b, this.f35469c, i11);
        this.f35469c += i11;
    }
}
