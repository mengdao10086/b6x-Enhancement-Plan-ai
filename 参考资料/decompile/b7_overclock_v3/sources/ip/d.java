package ip;

import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class d implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f35479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f35481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public mp.a f35482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35483f;

    public d(org.bouncycastle.crypto.f fVar) {
        this(fVar, 8, (fVar.c() * 8) / 2, null);
    }

    public d(org.bouncycastle.crypto.f fVar, int i10, int i11) {
        this(fVar, i10, i11, null);
    }

    public d(org.bouncycastle.crypto.f fVar, int i10, int i11, mp.a aVar) {
        this.f35482e = null;
        if (i11 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        this.f35478a = new byte[fVar.c()];
        o oVar = new o(fVar, i10);
        this.f35481d = oVar;
        this.f35482e = aVar;
        this.f35483f = i11 / 8;
        this.f35479b = new byte[oVar.b()];
        this.f35480c = 0;
    }

    public d(org.bouncycastle.crypto.f fVar, mp.a aVar) {
        this(fVar, 8, (fVar.c() * 8) / 2, aVar);
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        reset();
        this.f35481d.d(kVar);
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35481d.a();
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        int iB = this.f35481d.b();
        mp.a aVar = this.f35482e;
        if (aVar == null) {
            while (true) {
                int i11 = this.f35480c;
                if (i11 >= iB) {
                    break;
                }
                this.f35479b[i11] = 0;
                this.f35480c = i11 + 1;
            }
        } else {
            aVar.b(this.f35479b, this.f35480c);
        }
        this.f35481d.e(this.f35479b, 0, this.f35478a, 0);
        this.f35481d.c(this.f35478a);
        System.arraycopy(this.f35478a, 0, bArr, i10, this.f35483f);
        reset();
        return this.f35483f;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35483f;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f35479b;
            if (i10 >= bArr.length) {
                this.f35480c = 0;
                this.f35481d.f();
                return;
            } else {
                bArr[i10] = 0;
                i10++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        int i10 = this.f35480c;
        byte[] bArr = this.f35479b;
        if (i10 == bArr.length) {
            this.f35481d.e(bArr, 0, this.f35478a, 0);
            this.f35480c = 0;
        }
        byte[] bArr2 = this.f35479b;
        int i11 = this.f35480c;
        this.f35480c = i11 + 1;
        bArr2[i11] = b10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int iB = this.f35481d.b();
        int i12 = this.f35480c;
        int i13 = iB - i12;
        if (i11 > i13) {
            System.arraycopy(bArr, i10, this.f35479b, i12, i13);
            this.f35481d.e(this.f35479b, 0, this.f35478a, 0);
            this.f35480c = 0;
            i11 -= i13;
            i10 += i13;
            while (i11 > iB) {
                this.f35481d.e(bArr, i10, this.f35478a, 0);
                i11 -= iB;
                i10 += iB;
            }
        }
        System.arraycopy(bArr, i10, this.f35479b, this.f35480c, i11);
        this.f35480c += i11;
    }
}
