package androidx.collection;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f2821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2824d;

    public f() {
        this(8);
    }

    public void a(int i10) {
        int i11 = (this.f2822b - 1) & this.f2824d;
        this.f2822b = i11;
        this.f2821a[i11] = i10;
        if (i11 == this.f2823c) {
            d();
        }
    }

    public void b(int i10) {
        int[] iArr = this.f2821a;
        int i11 = this.f2823c;
        iArr[i11] = i10;
        int i12 = this.f2824d & (i11 + 1);
        this.f2823c = i12;
        if (i12 == this.f2822b) {
            d();
        }
    }

    public void c() {
        this.f2823c = this.f2822b;
    }

    public final void d() {
        int[] iArr = this.f2821a;
        int length = iArr.length;
        int i10 = this.f2822b;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i12];
        System.arraycopy(iArr, i10, iArr2, 0, i11);
        System.arraycopy(this.f2821a, 0, iArr2, i11, this.f2822b);
        this.f2821a = iArr2;
        this.f2822b = 0;
        this.f2823c = length;
        this.f2824d = i12 - 1;
    }

    public int e(int i10) {
        if (i10 < 0 || i10 >= m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f2821a[this.f2824d & (this.f2822b + i10)];
    }

    public int f() {
        int i10 = this.f2822b;
        if (i10 != this.f2823c) {
            return this.f2821a[i10];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int g() {
        int i10 = this.f2822b;
        int i11 = this.f2823c;
        if (i10 != i11) {
            return this.f2821a[(i11 - 1) & this.f2824d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean h() {
        return this.f2822b == this.f2823c;
    }

    public int i() {
        int i10 = this.f2822b;
        if (i10 == this.f2823c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = this.f2821a[i10];
        this.f2822b = (i10 + 1) & this.f2824d;
        return i11;
    }

    public int j() {
        int i10 = this.f2822b;
        int i11 = this.f2823c;
        if (i10 == i11) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.f2824d & (i11 - 1);
        int i13 = this.f2821a[i12];
        this.f2823c = i12;
        return i13;
    }

    public void k(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f2823c = this.f2824d & (this.f2823c - i10);
    }

    public void l(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f2822b = this.f2824d & (this.f2822b + i10);
    }

    public int m() {
        return (this.f2823c - this.f2822b) & this.f2824d;
    }

    public f(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i10 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i10 = Integer.bitCount(i10) != 1 ? Integer.highestOneBit(i10 - 1) << 1 : i10;
        this.f2824d = i10 - 1;
        this.f2821a = new int[i10];
    }
}
