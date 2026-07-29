package ip;

import cp.s1;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public final class v implements a0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f35608g = 128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35610b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s1 f35612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35614f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f35609a = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f35611c = new int[2];

    public static class b extends s1 {
        public b() {
        }

        public int y() {
            return super.v();
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f35609a.a(true, kVar);
        this.f35612d = (s1) this.f35609a.d();
        g();
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "Zuc128Mac";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        h();
        int iF = this.f35610b ^ f(this.f35614f * 8);
        this.f35610b = iF;
        int iE = iF ^ e();
        this.f35610b = iE;
        s1.s(iE, bArr, i10);
        reset();
        return d();
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return 4;
    }

    public final int e() {
        if (this.f35614f != 0) {
            return this.f35609a.y();
        }
        int i10 = this.f35613e + 1;
        int[] iArr = this.f35611c;
        int length = i10 % iArr.length;
        this.f35613e = length;
        return iArr[length];
    }

    public final int f(int i10) {
        int[] iArr = this.f35611c;
        int i11 = this.f35613e;
        int i12 = iArr[i11];
        if (i10 == 0) {
            return i12;
        }
        int i13 = iArr[(i11 + 1) % iArr.length];
        return (i13 >>> (32 - i10)) | (i12 << i10);
    }

    public final void g() {
        int i10 = 0;
        this.f35610b = 0;
        while (true) {
            int[] iArr = this.f35611c;
            if (i10 >= iArr.length - 1) {
                this.f35613e = iArr.length - 1;
                this.f35614f = 3;
                return;
            } else {
                iArr[i10] = this.f35609a.y();
                i10++;
            }
        }
    }

    public final void h() {
        int i10 = (this.f35614f + 1) % 4;
        this.f35614f = i10;
        if (i10 == 0) {
            this.f35611c[this.f35613e] = this.f35609a.y();
            this.f35613e = (this.f35613e + 1) % this.f35611c.length;
        }
    }

    public final void i(int i10) {
        this.f35610b = f(i10) ^ this.f35610b;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        s1 s1Var = this.f35612d;
        if (s1Var != null) {
            this.f35609a.i(s1Var);
        }
        g();
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        h();
        int i10 = this.f35614f * 8;
        int i11 = 128;
        int i12 = 0;
        while (i11 > 0) {
            if ((b10 & i11) != 0) {
                i(i10 + i12);
            }
            i11 >>= 1;
            i12++;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            update(bArr[i10 + i12]);
        }
    }
}
