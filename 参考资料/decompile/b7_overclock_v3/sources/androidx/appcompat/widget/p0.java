package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes2.dex */
public class p0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2623i = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2624a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2625b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2626c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2627d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2628e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2629f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2630g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2631h = false;

    public int a() {
        return this.f2630g ? this.f2624a : this.f2625b;
    }

    public int b() {
        return this.f2624a;
    }

    public int c() {
        return this.f2625b;
    }

    public int d() {
        return this.f2630g ? this.f2625b : this.f2624a;
    }

    public void e(int i10, int i11) {
        this.f2631h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f2628e = i10;
            this.f2624a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f2629f = i11;
            this.f2625b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 == this.f2630g) {
            return;
        }
        this.f2630g = z10;
        if (!this.f2631h) {
            this.f2624a = this.f2628e;
            this.f2625b = this.f2629f;
            return;
        }
        if (z10) {
            int i10 = this.f2627d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.f2628e;
            }
            this.f2624a = i10;
            int i11 = this.f2626c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f2629f;
            }
            this.f2625b = i11;
            return;
        }
        int i12 = this.f2626c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = this.f2628e;
        }
        this.f2624a = i12;
        int i13 = this.f2627d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f2629f;
        }
        this.f2625b = i13;
    }

    public void g(int i10, int i11) {
        this.f2626c = i10;
        this.f2627d = i11;
        this.f2631h = true;
        if (this.f2630g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f2624a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f2625b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f2624a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f2625b = i11;
        }
    }
}
