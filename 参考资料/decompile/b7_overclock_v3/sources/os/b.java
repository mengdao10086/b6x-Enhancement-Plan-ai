package os;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f46209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f46210b;

    public b(int[] iArr, int i10) {
        this.f46209a = iArr;
        this.f46210b = i10;
    }

    public final int a(int i10) {
        return this.f46209a[this.f46210b + i10];
    }

    public final int b(int i10, int i11) {
        this.f46209a[this.f46210b + i10] = i11;
        return i11;
    }

    public final int c(int i10, long j10) {
        int[] iArr = this.f46209a;
        int i11 = this.f46210b + i10;
        int i12 = (int) j10;
        iArr[i11] = i12;
        return i12;
    }

    public final b d() {
        return new b(this.f46209a, this.f46210b);
    }

    public final b e(int i10) {
        return new b(this.f46209a, this.f46210b + i10);
    }

    public final void f(int i10) {
        this.f46210b += i10;
    }
}
