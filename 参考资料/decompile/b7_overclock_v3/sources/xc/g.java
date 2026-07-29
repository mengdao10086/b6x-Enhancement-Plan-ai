package xc;

import android.text.Layout;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final int A = 3;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 1;
    public static final int E = 2;
    public static final int F = 3;
    public static final int G = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f55133s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f55134t = Float.MAX_VALUE;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f55135u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f55136v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f55137w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f55138x = 3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f55139y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f55140z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public String f55141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f55142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f55143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f55144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f55145e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f55151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public String f55152l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public Layout.Alignment f55155o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public xc.b f55157q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f55146f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f55147g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f55148h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f55149i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f55150j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f55153m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f55154n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f55156p = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f55158r = Float.MAX_VALUE;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public g A(@p0 String str) {
        this.f55152l = str;
        return this;
    }

    public g B(boolean z10) {
        this.f55149i = z10 ? 1 : 0;
        return this;
    }

    public g C(boolean z10) {
        this.f55146f = z10 ? 1 : 0;
        return this;
    }

    public g D(int i10) {
        this.f55154n = i10;
        return this;
    }

    public g E(int i10) {
        this.f55153m = i10;
        return this;
    }

    public g F(float f10) {
        this.f55158r = f10;
        return this;
    }

    public g G(@p0 Layout.Alignment alignment) {
        this.f55155o = alignment;
        return this;
    }

    public g H(boolean z10) {
        this.f55156p = z10 ? 1 : 0;
        return this;
    }

    public g I(@p0 xc.b bVar) {
        this.f55157q = bVar;
        return this;
    }

    public g J(boolean z10) {
        this.f55147g = z10 ? 1 : 0;
        return this;
    }

    public g a(@p0 g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.f55145e) {
            return this.f55144d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f55143c) {
            return this.f55142b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @p0
    public String d() {
        return this.f55141a;
    }

    public float e() {
        return this.f55151k;
    }

    public int f() {
        return this.f55150j;
    }

    @p0
    public String g() {
        return this.f55152l;
    }

    public int h() {
        return this.f55154n;
    }

    public int i() {
        return this.f55153m;
    }

    public float j() {
        return this.f55158r;
    }

    public int k() {
        int i10 = this.f55148h;
        if (i10 == -1 && this.f55149i == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.f55149i == 1 ? 2 : 0);
    }

    @p0
    public Layout.Alignment l() {
        return this.f55155o;
    }

    public boolean m() {
        return this.f55156p == 1;
    }

    @p0
    public xc.b n() {
        return this.f55157q;
    }

    public boolean o() {
        return this.f55145e;
    }

    public boolean p() {
        return this.f55143c;
    }

    public g q(@p0 g gVar) {
        return r(gVar, false);
    }

    public final g r(@p0 g gVar, boolean z10) {
        int i10;
        Layout.Alignment alignment;
        String str;
        if (gVar != null) {
            if (!this.f55143c && gVar.f55143c) {
                w(gVar.f55142b);
            }
            if (this.f55148h == -1) {
                this.f55148h = gVar.f55148h;
            }
            if (this.f55149i == -1) {
                this.f55149i = gVar.f55149i;
            }
            if (this.f55141a == null && (str = gVar.f55141a) != null) {
                this.f55141a = str;
            }
            if (this.f55146f == -1) {
                this.f55146f = gVar.f55146f;
            }
            if (this.f55147g == -1) {
                this.f55147g = gVar.f55147g;
            }
            if (this.f55154n == -1) {
                this.f55154n = gVar.f55154n;
            }
            if (this.f55155o == null && (alignment = gVar.f55155o) != null) {
                this.f55155o = alignment;
            }
            if (this.f55156p == -1) {
                this.f55156p = gVar.f55156p;
            }
            if (this.f55150j == -1) {
                this.f55150j = gVar.f55150j;
                this.f55151k = gVar.f55151k;
            }
            if (this.f55157q == null) {
                this.f55157q = gVar.f55157q;
            }
            if (this.f55158r == Float.MAX_VALUE) {
                this.f55158r = gVar.f55158r;
            }
            if (z10 && !this.f55145e && gVar.f55145e) {
                u(gVar.f55144d);
            }
            if (z10 && this.f55153m == -1 && (i10 = gVar.f55153m) != -1) {
                this.f55153m = i10;
            }
        }
        return this;
    }

    public boolean s() {
        return this.f55146f == 1;
    }

    public boolean t() {
        return this.f55147g == 1;
    }

    public g u(int i10) {
        this.f55144d = i10;
        this.f55145e = true;
        return this;
    }

    public g v(boolean z10) {
        this.f55148h = z10 ? 1 : 0;
        return this;
    }

    public g w(int i10) {
        this.f55142b = i10;
        this.f55143c = true;
        return this;
    }

    public g x(@p0 String str) {
        this.f55141a = str;
        return this;
    }

    public g y(float f10) {
        this.f55151k = f10;
        return this;
    }

    public g z(int i10) {
        this.f55150j = i10;
        return this;
    }
}
