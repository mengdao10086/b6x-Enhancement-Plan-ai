package jp;

import java.util.Objects;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class g implements b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f36582l = 64;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f36583m = 32;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f36584n = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f36585o = 16;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f36586p = new byte[15];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f36587q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f36588r = 274877906880L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cp.o f36589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.bouncycastle.crypto.a0 f36590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f36591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f36592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f36593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f36594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f36595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f36596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f36597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f36598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f36599k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f36600a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f36601b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f36602c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f36603d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f36604e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f36605f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f36606g = 6;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f36607h = 7;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f36608i = 8;
    }

    public g() {
        this(new ip.q());
    }

    public g(org.bouncycastle.crypto.a0 a0Var) {
        this.f36591c = new byte[32];
        this.f36592d = new byte[12];
        this.f36593e = new byte[80];
        this.f36594f = new byte[16];
        this.f36598j = 0;
        Objects.requireNonNull(a0Var, "'poly1305' cannot be null");
        if (16 != a0Var.d()) {
            throw new IllegalArgumentException("'poly1305' must be a 128-bit MAC");
        }
        this.f36589a = new cp.o();
        this.f36590b = a0Var;
    }

    @Override // jp.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        v1 v1Var;
        n1 n1VarB;
        byte[] bArrA;
        if (kVar instanceof np.a) {
            np.a aVar = (np.a) kVar;
            int iC = aVar.c();
            if (128 != iC) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + iC);
            }
            n1VarB = aVar.b();
            bArrA = aVar.d();
            v1Var = new v1(n1VarB, bArrA);
            this.f36595g = aVar.a();
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("invalid parameters passed to ChaCha20Poly1305");
            }
            v1Var = (v1) kVar;
            n1VarB = (n1) v1Var.b();
            bArrA = v1Var.a();
            this.f36595g = null;
        }
        if (n1VarB == null) {
            if (this.f36598j == 0) {
                throw new IllegalArgumentException("Key must be specified in initial init");
            }
        } else if (32 != n1VarB.a().length) {
            throw new IllegalArgumentException("Key must be 256 bits");
        }
        if (bArrA == null || 12 != bArrA.length) {
            throw new IllegalArgumentException("Nonce must be 96 bits");
        }
        if (this.f36598j != 0 && z10 && org.bouncycastle.util.a.g(this.f36592d, bArrA) && (n1VarB == null || org.bouncycastle.util.a.g(this.f36591c, n1VarB.a()))) {
            throw new IllegalArgumentException("cannot reuse nonce for ChaCha20Poly1305 encryption");
        }
        if (n1VarB != null) {
            System.arraycopy(n1VarB.a(), 0, this.f36591c, 0, 32);
        }
        System.arraycopy(bArrA, 0, this.f36592d, 0, 12);
        this.f36589a.a(true, v1Var);
        this.f36598j = z10 ? 1 : 5;
        t(true, false);
    }

    @Override // jp.b
    public String b() {
        return "ChaCha20Poly1305";
    }

    @Override // jp.b
    public int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException {
        int i11;
        Objects.requireNonNull(bArr, "'out' cannot be null");
        if (i10 < 0) {
            throw new IllegalArgumentException("'outOff' cannot be negative");
        }
        m();
        org.bouncycastle.util.a.n(this.f36594f);
        int i12 = this.f36598j;
        if (i12 == 3) {
            int i13 = this.f36599k;
            i11 = i13 + 16;
            if (i10 > bArr.length - i11) {
                throw new OutputLengthException("Output buffer too short");
            }
            if (i13 > 0) {
                s(this.f36593e, 0, i13, bArr, i10);
                this.f36590b.update(bArr, i10, this.f36599k);
            }
            o(4);
            System.arraycopy(this.f36594f, 0, bArr, i10 + this.f36599k, 16);
        } else {
            if (i12 != 7) {
                throw new IllegalStateException();
            }
            int i14 = this.f36599k;
            if (i14 < 16) {
                throw new InvalidCipherTextException("data too short");
            }
            i11 = i14 - 16;
            if (i10 > bArr.length - i11) {
                throw new OutputLengthException("Output buffer too short");
            }
            if (i11 > 0) {
                this.f36590b.update(this.f36593e, 0, i11);
                s(this.f36593e, 0, i11, bArr, i10);
            }
            o(8);
            if (!org.bouncycastle.util.a.H(16, this.f36594f, 0, this.f36593e, i11)) {
                throw new InvalidCipherTextException("mac check in ChaCha20Poly1305 failed");
            }
        }
        t(false, true);
        return i11;
    }

    @Override // jp.b
    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f36594f);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0099 A[LOOP:2: B:28:0x0097->B:29:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    @Override // jp.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int e(byte[] r17, int r18, int r19, byte[] r20, int r21) throws org.bouncycastle.crypto.DataLengthException {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.g.e(byte[], int, int, byte[], int):int");
    }

    @Override // jp.b
    public int g(int i10) {
        int iMax = Math.max(0, i10) + this.f36599k;
        int i11 = this.f36598j;
        if (i11 != 1 && i11 != 2 && i11 != 3) {
            if (i11 != 5 && i11 != 6 && i11 != 7) {
                throw new IllegalStateException();
            }
            iMax = Math.max(0, iMax - 16);
        }
        return iMax - (iMax % 64);
    }

    @Override // jp.b
    public int h(int i10) {
        int iMax = Math.max(0, i10) + this.f36599k;
        int i11 = this.f36598j;
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            return iMax + 16;
        }
        if (i11 == 5 || i11 == 6 || i11 == 7) {
            return Math.max(0, iMax - 16);
        }
        throw new IllegalStateException();
    }

    @Override // jp.b
    public int i(byte b10, byte[] bArr, int i10) throws DataLengthException {
        m();
        int i11 = this.f36598j;
        if (i11 == 3) {
            byte[] bArr2 = this.f36593e;
            int i12 = this.f36599k;
            bArr2[i12] = b10;
            int i13 = i12 + 1;
            this.f36599k = i13;
            if (i13 != 64) {
                return 0;
            }
            s(bArr2, 0, 64, bArr, i10);
            this.f36590b.update(bArr, i10, 64);
            this.f36599k = 0;
            return 64;
        }
        if (i11 != 7) {
            throw new IllegalStateException();
        }
        byte[] bArr3 = this.f36593e;
        int i14 = this.f36599k;
        bArr3[i14] = b10;
        int i15 = i14 + 1;
        this.f36599k = i15;
        if (i15 != bArr3.length) {
            return 0;
        }
        this.f36590b.update(bArr3, 0, 64);
        s(this.f36593e, 0, 64, bArr, i10);
        byte[] bArr4 = this.f36593e;
        System.arraycopy(bArr4, 64, bArr4, 0, 16);
        this.f36599k = 16;
        return 64;
    }

    @Override // jp.b
    public void j(byte b10) {
        l();
        this.f36596h = p(this.f36596h, 1, -1L);
        this.f36590b.update(b10);
    }

    @Override // jp.b
    public void k(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "'in' cannot be null");
        if (i10 < 0) {
            throw new IllegalArgumentException("'inOff' cannot be negative");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        }
        if (i10 > bArr.length - i11) {
            throw new DataLengthException("Input buffer too short");
        }
        l();
        if (i11 > 0) {
            this.f36596h = p(this.f36596h, i11, -1L);
            this.f36590b.update(bArr, i10, i11);
        }
    }

    public final void l() {
        int i10 = this.f36598j;
        int i11 = 2;
        if (i10 != 1) {
            if (i10 == 2) {
                return;
            }
            if (i10 == 4) {
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            }
            i11 = 6;
            if (i10 != 5) {
                if (i10 != 6) {
                    throw new IllegalStateException();
                }
                return;
            }
        }
        this.f36598j = i11;
    }

    public final void m() {
        int i10;
        switch (this.f36598j) {
            case 1:
            case 2:
                i10 = 3;
                break;
            case 3:
            case 7:
                return;
            case 4:
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            case 5:
            case 6:
                i10 = 7;
                break;
            default:
                throw new IllegalStateException();
        }
        n(i10);
    }

    public final void n(int i10) {
        r(this.f36596h);
        this.f36598j = i10;
    }

    public final void o(int i10) {
        r(this.f36597i);
        byte[] bArr = new byte[16];
        org.bouncycastle.util.o.F(this.f36596h, bArr, 0);
        org.bouncycastle.util.o.F(this.f36597i, bArr, 8);
        this.f36590b.update(bArr, 0, 16);
        this.f36590b.c(this.f36594f, 0);
        this.f36598j = i10;
    }

    public final long p(long j10, int i10, long j11) {
        long j12 = i10;
        if (j10 - Long.MIN_VALUE <= (j11 - j12) - Long.MIN_VALUE) {
            return j10 + j12;
        }
        throw new IllegalStateException("Limit exceeded");
    }

    public final void q() {
        byte[] bArr = new byte[64];
        try {
            this.f36589a.e(bArr, 0, 64, bArr, 0);
            this.f36590b.a(new n1(bArr, 0, 32));
        } finally {
            org.bouncycastle.util.a.n(bArr);
        }
    }

    public final void r(long j10) {
        int i10 = ((int) j10) & 15;
        if (i10 != 0) {
            this.f36590b.update(f36586p, 0, 16 - i10);
        }
    }

    @Override // jp.b
    public void reset() {
        t(true, true);
    }

    public final void s(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (i12 > bArr2.length - i11) {
            throw new OutputLengthException("Output buffer too short");
        }
        this.f36589a.e(bArr, i10, i11, bArr2, i12);
        this.f36597i = p(this.f36597i, i11, f36588r);
    }

    public final void t(boolean z10, boolean z11) {
        org.bouncycastle.util.a.n(this.f36593e);
        if (z10) {
            org.bouncycastle.util.a.n(this.f36594f);
        }
        this.f36596h = 0L;
        this.f36597i = 0L;
        this.f36599k = 0;
        switch (this.f36598j) {
            case 1:
            case 5:
                break;
            case 2:
            case 3:
            case 4:
                this.f36598j = 4;
                return;
            case 6:
            case 7:
            case 8:
                this.f36598j = 5;
                break;
            default:
                throw new IllegalStateException();
        }
        if (z11) {
            this.f36589a.reset();
        }
        q();
        byte[] bArr = this.f36595g;
        if (bArr != null) {
            k(bArr, 0, bArr.length);
        }
    }
}
