package ms;

import ft.z;

/* JADX INFO: loaded from: classes6.dex */
public class o implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f41656f = 11;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f41657g = 50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.s f41662e;

    public o() {
        this(11, 50);
    }

    public o(int i10) {
        this(i10, (org.bouncycastle.crypto.s) null);
    }

    public o(int i10, int i11) {
        this(i10, i11, (org.bouncycastle.crypto.s) null);
    }

    public o(int i10, int i11, int i12) {
        this(i10, i11, i12, null);
    }

    public o(int i10, int i11, int i12, org.bouncycastle.crypto.s sVar) {
        this.f41658a = i10;
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i10 > 32) {
            throw new IllegalArgumentException(" m is too large");
        }
        int i13 = 1 << i10;
        this.f41660c = i13;
        this.f41659b = i11;
        if (i11 < 0) {
            throw new IllegalArgumentException("t must be positive");
        }
        if (i11 > i13) {
            throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        if (z.b(i12) != i10 || !z.f(i12)) {
            throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
        }
        this.f41661d = i12;
        this.f41662e = sVar;
    }

    public o(int i10, int i11, org.bouncycastle.crypto.s sVar) {
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i10 > 32) {
            throw new IllegalArgumentException("m is too large");
        }
        this.f41658a = i10;
        int i12 = 1 << i10;
        this.f41660c = i12;
        if (i11 < 0) {
            throw new IllegalArgumentException("t must be positive");
        }
        if (i11 > i12) {
            throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        this.f41659b = i11;
        this.f41661d = z.e(i10);
        this.f41662e = sVar;
    }

    public o(int i10, org.bouncycastle.crypto.s sVar) {
        if (i10 < 1) {
            throw new IllegalArgumentException("key size must be positive");
        }
        this.f41658a = 0;
        this.f41660c = 1;
        while (true) {
            int i11 = this.f41660c;
            if (i11 >= i10) {
                int i12 = i11 >>> 1;
                this.f41659b = i12;
                int i13 = this.f41658a;
                this.f41659b = i12 / i13;
                this.f41661d = z.e(i13);
                this.f41662e = sVar;
                return;
            }
            this.f41660c = i11 << 1;
            this.f41658a++;
        }
    }

    public o(org.bouncycastle.crypto.s sVar) {
        this(11, 50, sVar);
    }

    public int a() {
        return this.f41661d;
    }

    public int b() {
        return this.f41658a;
    }

    public int c() {
        return this.f41660c;
    }

    public int d() {
        return this.f41659b;
    }
}
