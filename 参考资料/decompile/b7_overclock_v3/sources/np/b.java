package np;

import org.bouncycastle.crypto.PasswordConverter;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f42331j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f42332k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f42333l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f42334m = 16;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f42335n = 19;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f42336o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f42337p = 12;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f42338q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f42339r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f42340s = 19;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f42341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f42343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f42345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f42346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f42347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f42348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final org.bouncycastle.crypto.i f42349i;

    /* JADX INFO: renamed from: np.b$b, reason: collision with other inner class name */
    public static class C0477b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f42350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f42351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f42352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f42353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f42354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f42355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f42356g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f42357h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public org.bouncycastle.crypto.i f42358i;

        public C0477b() {
            this(1);
        }

        public C0477b(int i10) {
            this.f42358i = PasswordConverter.UTF8;
            this.f42357h = i10;
            this.f42355f = 1;
            this.f42354e = 4096;
            this.f42353d = 3;
            this.f42356g = 19;
        }

        public b a() {
            return new b(this.f42357h, this.f42350a, this.f42351b, this.f42352c, this.f42353d, this.f42354e, this.f42355f, this.f42356g, this.f42358i);
        }

        public void b() {
            org.bouncycastle.util.a.n(this.f42350a);
            org.bouncycastle.util.a.n(this.f42351b);
            org.bouncycastle.util.a.n(this.f42352c);
        }

        public C0477b c(byte[] bArr) {
            this.f42352c = org.bouncycastle.util.a.p(bArr);
            return this;
        }

        public C0477b d(org.bouncycastle.crypto.i iVar) {
            this.f42358i = iVar;
            return this;
        }

        public C0477b e(int i10) {
            this.f42353d = i10;
            return this;
        }

        public C0477b f(int i10) {
            this.f42354e = i10;
            return this;
        }

        public C0477b g(int i10) {
            this.f42354e = 1 << i10;
            return this;
        }

        public C0477b h(int i10) {
            this.f42355f = i10;
            return this;
        }

        public C0477b i(byte[] bArr) {
            this.f42350a = org.bouncycastle.util.a.p(bArr);
            return this;
        }

        public C0477b j(byte[] bArr) {
            this.f42351b = org.bouncycastle.util.a.p(bArr);
            return this;
        }

        public C0477b k(int i10) {
            this.f42356g = i10;
            return this;
        }
    }

    public b(int i10, byte[] bArr, byte[] bArr2, byte[] bArr3, int i11, int i12, int i13, int i14, org.bouncycastle.crypto.i iVar) {
        this.f42341a = org.bouncycastle.util.a.p(bArr);
        this.f42342b = org.bouncycastle.util.a.p(bArr2);
        this.f42343c = org.bouncycastle.util.a.p(bArr3);
        this.f42344d = i11;
        this.f42345e = i12;
        this.f42346f = i13;
        this.f42347g = i14;
        this.f42348h = i10;
        this.f42349i = iVar;
    }

    public void a() {
        org.bouncycastle.util.a.n(this.f42341a);
        org.bouncycastle.util.a.n(this.f42342b);
        org.bouncycastle.util.a.n(this.f42343c);
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f42343c);
    }

    public org.bouncycastle.crypto.i c() {
        return this.f42349i;
    }

    public int d() {
        return this.f42344d;
    }

    public int e() {
        return this.f42346f;
    }

    public int f() {
        return this.f42345e;
    }

    public byte[] g() {
        return org.bouncycastle.util.a.p(this.f42341a);
    }

    public byte[] h() {
        return org.bouncycastle.util.a.p(this.f42342b);
    }

    public int i() {
        return this.f42348h;
    }

    public int j() {
        return this.f42347g;
    }
}
