package ip;

import cp.s1;
import cp.u1;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public final class w implements a0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f35615h = 128;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f35616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f35618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f35619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u1 f35620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f35622g;

    public static class a extends u1 {
        public a(int i10) {
            super(i10);
        }

        public int z() {
            return super.v();
        }
    }

    public w(int i10) {
        this.f35616a = new a(i10);
        this.f35617b = i10;
        int i11 = i10 / 32;
        this.f35618c = new int[i11];
        this.f35619d = new int[i11 + 1];
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f35616a.a(true, kVar);
        this.f35620e = (u1) this.f35616a.d();
        f();
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "Zuc256Mac-" + this.f35617b;
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        g();
        i(this.f35622g * 8);
        int i11 = 0;
        while (true) {
            int[] iArr = this.f35618c;
            if (i11 >= iArr.length) {
                reset();
                return d();
            }
            s1.s(iArr[i11], bArr, (i11 * 4) + i10);
            i11++;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35617b / 8;
    }

    public final int e(int i10, int i11) {
        int[] iArr = this.f35619d;
        int i12 = this.f35621f;
        int i13 = iArr[(i12 + i10) % iArr.length];
        if (i11 == 0) {
            return i13;
        }
        int i14 = iArr[((i12 + i10) + 1) % iArr.length];
        return (i14 >>> (32 - i11)) | (i13 << i11);
    }

    public final void f() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f35618c;
            if (i11 >= iArr.length) {
                break;
            }
            iArr[i11] = this.f35616a.z();
            i11++;
        }
        while (true) {
            int[] iArr2 = this.f35619d;
            if (i10 >= iArr2.length - 1) {
                this.f35621f = iArr2.length - 1;
                this.f35622g = 3;
                return;
            } else {
                iArr2[i10] = this.f35616a.z();
                i10++;
            }
        }
    }

    public final void g() {
        int i10 = (this.f35622g + 1) % 4;
        this.f35622g = i10;
        if (i10 == 0) {
            this.f35621f = (this.f35621f + 1) % this.f35619d.length;
        }
    }

    public final void h() {
        int i10 = (this.f35622g + 1) % 4;
        this.f35622g = i10;
        if (i10 == 0) {
            this.f35619d[this.f35621f] = this.f35616a.z();
            this.f35621f = (this.f35621f + 1) % this.f35619d.length;
        }
    }

    public final void i(int i10) {
        int i11 = 0;
        while (true) {
            int[] iArr = this.f35618c;
            if (i11 >= iArr.length) {
                return;
            }
            iArr[i11] = iArr[i11] ^ e(i11, i10);
            i11++;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        u1 u1Var = this.f35620e;
        if (u1Var != null) {
            this.f35616a.i(u1Var);
        }
        f();
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        h();
        int i10 = this.f35622g * 8;
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
