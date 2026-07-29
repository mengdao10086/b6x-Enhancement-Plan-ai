package bp;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.n;
import org.bouncycastle.util.p;

/* JADX INFO: loaded from: classes5.dex */
public class c implements org.bouncycastle.crypto.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9531i = "org.bouncycastle.pkcs1.strict";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9532j = "org.bouncycastle.pkcs1.not_strict";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f9533k = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f9534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.b f9535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f9540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f9541h;

    public c(org.bouncycastle.crypto.b bVar) {
        this.f9539f = -1;
        this.f9540g = null;
        this.f9535b = bVar;
        this.f9538e = k();
    }

    public c(org.bouncycastle.crypto.b bVar, int i10) {
        this.f9539f = -1;
        this.f9540g = null;
        this.f9535b = bVar;
        this.f9538e = k();
        this.f9539f = i10;
    }

    public c(org.bouncycastle.crypto.b bVar, byte[] bArr) {
        this.f9539f = -1;
        this.f9540g = null;
        this.f9535b = bVar;
        this.f9538e = k();
        this.f9540g = bArr;
        this.f9539f = bArr.length;
    }

    public static int e(byte[] bArr, int i10) {
        int i11 = 0 | (bArr[0] ^ 2);
        int i12 = i10 + 1;
        int length = bArr.length - i12;
        for (int i13 = 1; i13 < length; i13++) {
            byte b10 = bArr[i13];
            int i14 = b10 | (b10 >> 1);
            int i15 = i14 | (i14 >> 2);
            i11 |= ((i15 | (i15 >> 4)) & 1) - 1;
        }
        int i16 = bArr[bArr.length - i12] | i11;
        int i17 = i16 | (i16 >> 1);
        int i18 = i17 | (i17 >> 2);
        return ~(((i18 | (i18 >> 4)) & 1) - 1);
    }

    @Override // org.bouncycastle.crypto.b
    public void a(boolean z10, k kVar) {
        np.c cVar;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f9534a = w1Var.b();
            cVar = (np.c) w1Var.a();
        } else {
            cVar = (np.c) kVar;
            if (!cVar.c() && z10) {
                this.f9534a = n.f();
            }
        }
        this.f9535b.a(z10, kVar);
        this.f9537d = cVar.c();
        this.f9536c = z10;
        this.f9541h = new byte[this.f9535b.d()];
        if (this.f9539f > 0 && this.f9540g == null && this.f9534a == null) {
            throw new IllegalArgumentException("encoder requires random");
        }
    }

    @Override // org.bouncycastle.crypto.b
    public int b() {
        int iB = this.f9535b.b();
        return this.f9536c ? iB - 10 : iB;
    }

    @Override // org.bouncycastle.crypto.b
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        return this.f9536c ? h(bArr, i10, i11) : f(bArr, i10, i11);
    }

    @Override // org.bouncycastle.crypto.b
    public int d() {
        int iD = this.f9535b.d();
        return this.f9536c ? iD : iD - 10;
    }

    public final byte[] f(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f9539f != -1) {
            return g(bArr, i10, i11);
        }
        byte[] bArrC = this.f9535b.c(bArr, i10, i11);
        boolean z10 = this.f9538e & (bArrC.length != this.f9535b.d());
        if (bArrC.length < d()) {
            bArrC = this.f9541h;
        }
        byte b10 = bArrC[0];
        boolean z11 = !this.f9537d ? b10 == 1 : b10 == 2;
        int i12 = i(b10, bArrC) + 1;
        if (z11 || (i12 < 10)) {
            org.bouncycastle.util.a.d0(bArrC, (byte) 0);
            throw new InvalidCipherTextException("block incorrect");
        }
        if (z10) {
            org.bouncycastle.util.a.d0(bArrC, (byte) 0);
            throw new InvalidCipherTextException("block incorrect size");
        }
        int length = bArrC.length - i12;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArrC, i12, bArr2, 0, length);
        return bArr2;
    }

    public final byte[] g(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (!this.f9537d) {
            throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
        }
        byte[] bArrC = this.f9535b.c(bArr, i10, i11);
        byte[] bArr2 = this.f9540g;
        if (bArr2 == null) {
            bArr2 = new byte[this.f9539f];
            this.f9534a.nextBytes(bArr2);
        }
        if (this.f9538e & (bArrC.length != this.f9535b.d())) {
            bArrC = this.f9541h;
        }
        int iE = e(bArrC, this.f9539f);
        byte[] bArr3 = new byte[this.f9539f];
        int i12 = 0;
        while (true) {
            int i13 = this.f9539f;
            if (i12 >= i13) {
                org.bouncycastle.util.a.d0(bArrC, (byte) 0);
                return bArr3;
            }
            bArr3[i12] = (byte) ((bArrC[(bArrC.length - i13) + i12] & (~iE)) | (bArr2[i12] & iE));
            i12++;
        }
    }

    public final byte[] h(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (i11 > b()) {
            throw new IllegalArgumentException("input data too large");
        }
        int iB = this.f9535b.b();
        byte[] bArr2 = new byte[iB];
        if (this.f9537d) {
            bArr2[0] = 1;
            for (int i12 = 1; i12 != (iB - i11) - 1; i12++) {
                bArr2[i12] = -1;
            }
        } else {
            this.f9534a.nextBytes(bArr2);
            bArr2[0] = 2;
            for (int i13 = 1; i13 != (iB - i11) - 1; i13++) {
                while (bArr2[i13] == 0) {
                    bArr2[i13] = (byte) this.f9534a.nextInt();
                }
            }
        }
        int i14 = iB - i11;
        bArr2[i14 - 1] = 0;
        System.arraycopy(bArr, i10, bArr2, i14, i11);
        return this.f9535b.c(bArr2, 0, iB);
    }

    public final int i(byte b10, byte[] bArr) throws InvalidCipherTextException {
        boolean z10 = false;
        int i10 = -1;
        for (int i11 = 1; i11 != bArr.length; i11++) {
            byte b11 = bArr[i11];
            if ((b11 == 0) & (i10 < 0)) {
                i10 = i11;
            }
            z10 |= (b11 != -1) & (b10 == 1) & (i10 < 0);
        }
        if (z10) {
            return -1;
        }
        return i10;
    }

    public org.bouncycastle.crypto.b j() {
        return this.f9535b;
    }

    public final boolean k() {
        if (p.e(f9532j, true)) {
            return false;
        }
        return !p.e(f9531i, false);
    }
}
