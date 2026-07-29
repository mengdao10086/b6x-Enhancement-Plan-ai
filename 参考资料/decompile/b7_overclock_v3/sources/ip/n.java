package ip;

import np.n1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.a0;
import org.bouncycastle.crypto.m0;
import org.bouncycastle.util.Strings;
import zo.r0;

/* JADX INFO: loaded from: classes5.dex */
public class n implements a0, m0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f35540g = new byte[100];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zo.e f35541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f35544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f35545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f35546f;

    public n(int i10, byte[] bArr) {
        this.f35541a = new zo.e(i10, Strings.i("KMAC"), bArr);
        this.f35542b = i10;
        this.f35543c = (i10 * 2) / 8;
    }

    public static byte[] j(byte[] bArr) {
        return org.bouncycastle.util.a.B(r0.c(bArr.length * 8), bArr);
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        this.f35544d = org.bouncycastle.util.a.p(((n1) kVar).a());
        this.f35545e = true;
        reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "KMAC" + this.f35541a.b().substring(6);
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        if (this.f35546f) {
            if (!this.f35545e) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrD = r0.d(d() * 8);
            this.f35541a.update(bArrD, 0, bArrD.length);
        }
        int iF = this.f35541a.f(bArr, i10, d());
        reset();
        return iF;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35543c;
    }

    @Override // org.bouncycastle.crypto.m0
    public int e(byte[] bArr, int i10, int i11) {
        if (this.f35546f) {
            if (!this.f35545e) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrD = r0.d(0L);
            this.f35541a.update(bArrD, 0, bArrD.length);
            this.f35546f = false;
        }
        return this.f35541a.e(bArr, i10, i11);
    }

    @Override // org.bouncycastle.crypto.m0
    public int f(byte[] bArr, int i10, int i11) {
        if (this.f35546f) {
            if (!this.f35545e) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrD = r0.d(i11 * 8);
            this.f35541a.update(bArrD, 0, bArrD.length);
        }
        int iF = this.f35541a.f(bArr, i10, i11);
        reset();
        return iF;
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return this.f35541a.g();
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f35543c;
    }

    public final void i(byte[] bArr, int i10) {
        byte[] bArrC = r0.c(i10);
        update(bArrC, 0, bArrC.length);
        byte[] bArrJ = j(bArr);
        update(bArrJ, 0, bArrJ.length);
        int length = i10 - ((bArrC.length + bArrJ.length) % i10);
        if (length <= 0 || length == i10) {
            return;
        }
        while (true) {
            byte[] bArr2 = f35540g;
            if (length <= bArr2.length) {
                update(bArr2, 0, length);
                return;
            } else {
                update(bArr2, 0, bArr2.length);
                length -= bArr2.length;
            }
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35541a.reset();
        byte[] bArr = this.f35544d;
        if (bArr != null) {
            i(bArr, this.f35542b == 128 ? os.a.f46207a : 136);
        }
        this.f35546f = true;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) throws IllegalStateException {
        if (!this.f35545e) {
            throw new IllegalStateException("KMAC not initialized");
        }
        this.f35541a.update(b10);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        if (!this.f35545e) {
            throw new IllegalStateException("KMAC not initialized");
        }
        this.f35541a.update(bArr, i10, i11);
    }
}
