package ip;

import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class c implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f35472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f35473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.f f35475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public mp.a f35476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35477f;

    public c(org.bouncycastle.crypto.f fVar) {
        this(fVar, (fVar.c() * 8) / 2, null);
    }

    public c(org.bouncycastle.crypto.f fVar, int i10) {
        this(fVar, i10, null);
    }

    public c(org.bouncycastle.crypto.f fVar, int i10, mp.a aVar) {
        if (i10 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        this.f35475d = new jp.c(fVar);
        this.f35476e = aVar;
        this.f35477f = i10 / 8;
        this.f35472a = new byte[fVar.c()];
        this.f35473b = new byte[fVar.c()];
        this.f35474c = 0;
    }

    public c(org.bouncycastle.crypto.f fVar, mp.a aVar) {
        this(fVar, (fVar.c() * 8) / 2, aVar);
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        reset();
        this.f35475d.a(true, kVar);
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35475d.b();
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        int iC = this.f35475d.c();
        if (this.f35476e == null) {
            while (true) {
                int i11 = this.f35474c;
                if (i11 >= iC) {
                    break;
                }
                this.f35473b[i11] = 0;
                this.f35474c = i11 + 1;
            }
        } else {
            if (this.f35474c == iC) {
                this.f35475d.d(this.f35473b, 0, this.f35472a, 0);
                this.f35474c = 0;
            }
            this.f35476e.b(this.f35473b, this.f35474c);
        }
        this.f35475d.d(this.f35473b, 0, this.f35472a, 0);
        System.arraycopy(this.f35472a, 0, bArr, i10, this.f35477f);
        reset();
        return this.f35477f;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35477f;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f35473b;
            if (i10 >= bArr.length) {
                this.f35474c = 0;
                this.f35475d.reset();
                return;
            } else {
                bArr[i10] = 0;
                i10++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        int i10 = this.f35474c;
        byte[] bArr = this.f35473b;
        if (i10 == bArr.length) {
            this.f35475d.d(bArr, 0, this.f35472a, 0);
            this.f35474c = 0;
        }
        byte[] bArr2 = this.f35473b;
        int i11 = this.f35474c;
        this.f35474c = i11 + 1;
        bArr2[i11] = b10;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int iC = this.f35475d.c();
        int i12 = this.f35474c;
        int i13 = iC - i12;
        if (i11 > i13) {
            System.arraycopy(bArr, i10, this.f35473b, i12, i13);
            this.f35475d.d(this.f35473b, 0, this.f35472a, 0);
            this.f35474c = 0;
            i11 -= i13;
            i10 += i13;
            while (i11 > iC) {
                this.f35475d.d(bArr, i10, this.f35472a, 0);
                i11 -= iC;
                i10 += iC;
            }
        }
        System.arraycopy(bArr, i10, this.f35473b, this.f35474c, i11);
        this.f35474c += i11;
    }
}
