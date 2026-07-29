package hd;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f31099f = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31100a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31101b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31102c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f31103d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31104e;

    public o() {
        this.f31104e = r0.length - 1;
    }

    public void a(int i10) {
        if (this.f31102c == this.f31103d.length) {
            d();
        }
        int i11 = (this.f31101b + 1) & this.f31104e;
        this.f31101b = i11;
        this.f31103d[i11] = i10;
        this.f31102c++;
    }

    public int b() {
        return this.f31103d.length;
    }

    public void c() {
        this.f31100a = 0;
        this.f31101b = -1;
        this.f31102c = 0;
    }

    public final void d() {
        int[] iArr = this.f31103d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i10 = this.f31100a;
        int i11 = length2 - i10;
        System.arraycopy(iArr, i10, iArr2, 0, i11);
        System.arraycopy(this.f31103d, 0, iArr2, i11, i10);
        this.f31100a = 0;
        this.f31101b = this.f31102c - 1;
        this.f31103d = iArr2;
        this.f31104e = iArr2.length - 1;
    }

    public boolean e() {
        return this.f31102c == 0;
    }

    public int f() {
        int i10 = this.f31102c;
        if (i10 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f31103d;
        int i11 = this.f31100a;
        int i12 = iArr[i11];
        this.f31100a = (i11 + 1) & this.f31104e;
        this.f31102c = i10 - 1;
        return i12;
    }

    public int g() {
        return this.f31102c;
    }
}
