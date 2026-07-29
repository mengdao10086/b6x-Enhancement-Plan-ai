package zo;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l implements org.bouncycastle.crypto.v, org.bouncycastle.util.m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f59340d = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f59341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f59343c;

    public l() {
        this.f59341a = new byte[4];
        this.f59342b = 0;
    }

    public l(l lVar) {
        this.f59341a = new byte[4];
        k(lVar);
    }

    public l(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        this.f59341a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f59342b = org.bouncycastle.util.o.a(bArr, 4);
        this.f59343c = org.bouncycastle.util.o.d(bArr, 8);
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return 64;
    }

    public void k(l lVar) {
        byte[] bArr = lVar.f59341a;
        System.arraycopy(bArr, 0, this.f59341a, 0, bArr.length);
        this.f59342b = lVar.f59342b;
        this.f59343c = lVar.f59343c;
    }

    public void l() {
        long j10 = this.f59343c << 3;
        byte b10 = -128;
        while (true) {
            update(b10);
            if (this.f59342b == 0) {
                o(j10);
                n();
                return;
            }
            b10 = 0;
        }
    }

    public void m(byte[] bArr) {
        System.arraycopy(this.f59341a, 0, bArr, 0, this.f59342b);
        org.bouncycastle.util.o.h(this.f59342b, bArr, 4);
        org.bouncycastle.util.o.z(this.f59343c, bArr, 8);
    }

    public abstract void n();

    public abstract void o(long j10);

    public abstract void p(byte[] bArr, int i10);

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59343c = 0L;
        this.f59342b = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f59341a;
            if (i10 >= bArr.length) {
                return;
            }
            bArr[i10] = 0;
            i10++;
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        byte[] bArr = this.f59341a;
        int i10 = this.f59342b;
        int i11 = i10 + 1;
        this.f59342b = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            p(bArr, 0);
            this.f59342b = 0;
        }
        this.f59343c++;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        int iMax = Math.max(0, i11);
        if (this.f59342b != 0) {
            int i13 = 0;
            while (true) {
                if (i13 >= iMax) {
                    i12 = i13;
                    break;
                }
                byte[] bArr2 = this.f59341a;
                int i14 = this.f59342b;
                int i15 = i14 + 1;
                this.f59342b = i15;
                int i16 = i13 + 1;
                bArr2[i14] = bArr[i13 + i10];
                if (i15 == 4) {
                    p(bArr2, 0);
                    this.f59342b = 0;
                    i12 = i16;
                    break;
                }
                i13 = i16;
            }
        }
        int i17 = ((iMax - i12) & (-4)) + i12;
        while (i12 < i17) {
            p(bArr, i10 + i12);
            i12 += 4;
        }
        while (i12 < iMax) {
            byte[] bArr3 = this.f59341a;
            int i18 = this.f59342b;
            this.f59342b = i18 + 1;
            bArr3[i18] = bArr[i12 + i10];
            i12++;
        }
        this.f59343c += (long) iMax;
    }
}
