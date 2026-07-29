package androidx.collection;

/* JADX INFO: loaded from: classes2.dex */
public final class e<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E[] f2817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2820d;

    public e() {
        this(8);
    }

    public void a(E e10) {
        int i10 = (this.f2818b - 1) & this.f2820d;
        this.f2818b = i10;
        this.f2817a[i10] = e10;
        if (i10 == this.f2819c) {
            d();
        }
    }

    public void b(E e10) {
        E[] eArr = this.f2817a;
        int i10 = this.f2819c;
        eArr[i10] = e10;
        int i11 = this.f2820d & (i10 + 1);
        this.f2819c = i11;
        if (i11 == this.f2818b) {
            d();
        }
    }

    public void c() {
        l(m());
    }

    public final void d() {
        E[] eArr = this.f2817a;
        int length = eArr.length;
        int i10 = this.f2818b;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr2 = (E[]) new Object[i12];
        System.arraycopy(eArr, i10, eArr2, 0, i11);
        System.arraycopy(this.f2817a, 0, eArr2, i11, this.f2818b);
        this.f2817a = eArr2;
        this.f2818b = 0;
        this.f2819c = length;
        this.f2820d = i12 - 1;
    }

    public E e(int i10) {
        if (i10 < 0 || i10 >= m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f2817a[this.f2820d & (this.f2818b + i10)];
    }

    public E f() {
        int i10 = this.f2818b;
        if (i10 != this.f2819c) {
            return this.f2817a[i10];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E g() {
        int i10 = this.f2818b;
        int i11 = this.f2819c;
        if (i10 != i11) {
            return this.f2817a[(i11 - 1) & this.f2820d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean h() {
        return this.f2818b == this.f2819c;
    }

    public E i() {
        int i10 = this.f2818b;
        if (i10 == this.f2819c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.f2817a;
        E e10 = eArr[i10];
        eArr[i10] = null;
        this.f2818b = (i10 + 1) & this.f2820d;
        return e10;
    }

    public E j() {
        int i10 = this.f2818b;
        int i11 = this.f2819c;
        if (i10 == i11) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.f2820d & (i11 - 1);
        E[] eArr = this.f2817a;
        E e10 = eArr[i12];
        eArr[i12] = null;
        this.f2819c = i12;
        return e10;
    }

    public void k(int i10) {
        int i11;
        if (i10 <= 0) {
            return;
        }
        if (i10 > m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.f2819c;
        int i13 = i10 < i12 ? i12 - i10 : 0;
        int i14 = i13;
        while (true) {
            i11 = this.f2819c;
            if (i14 >= i11) {
                break;
            }
            this.f2817a[i14] = null;
            i14++;
        }
        int i15 = i11 - i13;
        int i16 = i10 - i15;
        this.f2819c = i11 - i15;
        if (i16 > 0) {
            int length = this.f2817a.length;
            this.f2819c = length;
            int i17 = length - i16;
            for (int i18 = i17; i18 < this.f2819c; i18++) {
                this.f2817a[i18] = null;
            }
            this.f2819c = i17;
        }
    }

    public void l(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.f2817a.length;
        int i11 = this.f2818b;
        if (i10 < length - i11) {
            length = i11 + i10;
        }
        while (i11 < length) {
            this.f2817a[i11] = null;
            i11++;
        }
        int i12 = this.f2818b;
        int i13 = length - i12;
        int i14 = i10 - i13;
        this.f2818b = this.f2820d & (i12 + i13);
        if (i14 > 0) {
            for (int i15 = 0; i15 < i14; i15++) {
                this.f2817a[i15] = null;
            }
            this.f2818b = i14;
        }
    }

    public int m() {
        return (this.f2819c - this.f2818b) & this.f2820d;
    }

    public e(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i10 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i10 = Integer.bitCount(i10) != 1 ? Integer.highestOneBit(i10 - 1) << 1 : i10;
        this.f2820d = i10 - 1;
        this.f2817a = (E[]) new Object[i10];
    }
}
