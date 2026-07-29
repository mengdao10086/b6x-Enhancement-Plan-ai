package hb;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f30832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f30833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30835d;

    public e0(byte[] bArr) {
        this.f30832a = bArr;
        this.f30833b = bArr.length;
    }

    public final void a() {
        int i10;
        int i11 = this.f30834c;
        hd.a.i(i11 >= 0 && (i11 < (i10 = this.f30833b) || (i11 == i10 && this.f30835d == 0)));
    }

    public int b() {
        return ((this.f30833b - this.f30834c) * 8) - this.f30835d;
    }

    public int c() {
        return (this.f30834c * 8) + this.f30835d;
    }

    public boolean d() {
        boolean z10 = (((this.f30832a[this.f30834c] & 255) >> this.f30835d) & 1) == 1;
        h(1);
        return z10;
    }

    public int e(int i10) {
        int i11 = this.f30834c;
        int iMin = Math.min(i10, 8 - this.f30835d);
        int i12 = i11 + 1;
        int i13 = ((this.f30832a[i11] & 255) >> this.f30835d) & (255 >> (8 - iMin));
        while (iMin < i10) {
            i13 |= (this.f30832a[i12] & 255) << iMin;
            iMin += 8;
            i12++;
        }
        int i14 = i13 & ((-1) >>> (32 - i10));
        h(i10);
        return i14;
    }

    public void f() {
        this.f30834c = 0;
        this.f30835d = 0;
    }

    public void g(int i10) {
        int i11 = i10 / 8;
        this.f30834c = i11;
        this.f30835d = i10 - (i11 * 8);
        a();
    }

    public void h(int i10) {
        int i11 = i10 / 8;
        int i12 = this.f30834c + i11;
        this.f30834c = i12;
        int i13 = this.f30835d + (i10 - (i11 * 8));
        this.f30835d = i13;
        if (i13 > 7) {
            this.f30834c = i12 + 1;
            this.f30835d = i13 - 8;
        }
        a();
    }
}
