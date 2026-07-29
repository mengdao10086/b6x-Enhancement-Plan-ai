package cf;

import za.h1;
import zo.q0;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f10934h = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f10935i = new a(h1.V, 1024, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f10936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f10937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f10938l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f10939m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f10940n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f10941o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f10942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f10943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f10944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f10945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10948g;

    static {
        a aVar = new a(67, 64, 1);
        f10936j = aVar;
        f10937k = new a(19, 16, 1);
        f10938l = new a(q0.f59440m, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f10939m = aVar2;
        f10940n = aVar2;
        f10941o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f10947f = i10;
        this.f10946e = i11;
        this.f10948g = i12;
        this.f10942a = new int[i11];
        this.f10943b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f10942a[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f10943b[this.f10942a[i15]] = i15;
        }
        this.f10944c = new b(this, new int[]{0});
        this.f10945d = new b(this, new int[]{1});
    }

    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f10944c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new b(this, iArr);
    }

    public int c(int i10) {
        return this.f10942a[i10];
    }

    public int d() {
        return this.f10948g;
    }

    public b e() {
        return this.f10945d;
    }

    public int f() {
        return this.f10946e;
    }

    public b g() {
        return this.f10944c;
    }

    public int h(int i10) {
        if (i10 != 0) {
            return this.f10942a[(this.f10946e - this.f10943b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int i(int i10) {
        if (i10 != 0) {
            return this.f10943b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int j(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f10942a;
        int[] iArr2 = this.f10943b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f10946e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f10947f) + ',' + this.f10946e + ')';
    }
}
