package lf;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f39754f = new b(kf.a.f37226a, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f39755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f39756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f39757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f39758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f39759e;

    public b(int i10, int i11) {
        this.f39759e = i10;
        this.f39755a = new int[i10];
        this.f39756b = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f39755a[i13] = i12;
            i12 = (i12 * i11) % i10;
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f39756b[this.f39755a[i14]] = i14;
        }
        this.f39757c = new c(this, new int[]{0});
        this.f39758d = new c(this, new int[]{1});
    }

    public int a(int i10, int i11) {
        return (i10 + i11) % this.f39759e;
    }

    public c b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f39757c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new c(this, iArr);
    }

    public int c(int i10) {
        return this.f39755a[i10];
    }

    public c d() {
        return this.f39758d;
    }

    public int e() {
        return this.f39759e;
    }

    public c f() {
        return this.f39757c;
    }

    public int g(int i10) {
        if (i10 != 0) {
            return this.f39755a[(this.f39759e - this.f39756b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i10) {
        if (i10 != 0) {
            return this.f39756b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int i(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f39755a;
        int[] iArr2 = this.f39756b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f39759e - 1)];
    }

    public int j(int i10, int i11) {
        int i12 = this.f39759e;
        return ((i10 + i12) - i11) % i12;
    }
}
