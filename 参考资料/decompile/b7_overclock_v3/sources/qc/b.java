package qc;

import android.graphics.Bitmap;
import android.text.Layout;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final int A = 2;
    public static final int B = 1;
    public static final int C = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f47222q = new c().z("").a();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f47223r = -3.4028235E38f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f47224s = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f47225t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f47226u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f47227v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f47228w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f47229x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f47230y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f47231z = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final CharSequence f47232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final Layout.Alignment f47233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final Bitmap f47234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f47235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f47236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f47237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f47238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f47239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f47240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f47241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f47242k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f47243l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f47244m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f47245n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f47246o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f47247p;

    /* JADX INFO: renamed from: qc.b$b, reason: collision with other inner class name */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0543b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public CharSequence f47248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public Bitmap f47249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public Layout.Alignment f47250c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f47251d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f47252e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f47253f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f47254g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f47255h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f47256i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f47257j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f47258k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f47259l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f47260m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @g.l
        public int f47261n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f47262o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f47263p;

        public c A(@p0 Layout.Alignment alignment) {
            this.f47250c = alignment;
            return this;
        }

        public c B(float f10, int i10) {
            this.f47257j = f10;
            this.f47256i = i10;
            return this;
        }

        public c C(int i10) {
            this.f47262o = i10;
            return this;
        }

        public c D(@g.l int i10) {
            this.f47261n = i10;
            this.f47260m = true;
            return this;
        }

        public b a() {
            return new b(this.f47248a, this.f47250c, this.f47249b, this.f47251d, this.f47252e, this.f47253f, this.f47254g, this.f47255h, this.f47256i, this.f47257j, this.f47258k, this.f47259l, this.f47260m, this.f47261n, this.f47262o, this.f47263p);
        }

        public c b() {
            this.f47260m = false;
            return this;
        }

        @p0
        public Bitmap c() {
            return this.f47249b;
        }

        public float d() {
            return this.f47259l;
        }

        public float e() {
            return this.f47251d;
        }

        public int f() {
            return this.f47253f;
        }

        public int g() {
            return this.f47252e;
        }

        public float h() {
            return this.f47254g;
        }

        public int i() {
            return this.f47255h;
        }

        public float j() {
            return this.f47258k;
        }

        @p0
        public CharSequence k() {
            return this.f47248a;
        }

        @p0
        public Layout.Alignment l() {
            return this.f47250c;
        }

        public float m() {
            return this.f47257j;
        }

        public int n() {
            return this.f47256i;
        }

        public int o() {
            return this.f47262o;
        }

        @g.l
        public int p() {
            return this.f47261n;
        }

        public boolean q() {
            return this.f47260m;
        }

        public c r(Bitmap bitmap) {
            this.f47249b = bitmap;
            return this;
        }

        public c s(float f10) {
            this.f47259l = f10;
            return this;
        }

        public c t(float f10, int i10) {
            this.f47251d = f10;
            this.f47252e = i10;
            return this;
        }

        public c u(int i10) {
            this.f47253f = i10;
            return this;
        }

        public c v(float f10) {
            this.f47254g = f10;
            return this;
        }

        public c w(int i10) {
            this.f47255h = i10;
            return this;
        }

        public c x(float f10) {
            this.f47263p = f10;
            return this;
        }

        public c y(float f10) {
            this.f47258k = f10;
            return this;
        }

        public c z(CharSequence charSequence) {
            this.f47248a = charSequence;
            return this;
        }

        public c() {
            this.f47248a = null;
            this.f47249b = null;
            this.f47250c = null;
            this.f47251d = -3.4028235E38f;
            this.f47252e = Integer.MIN_VALUE;
            this.f47253f = Integer.MIN_VALUE;
            this.f47254g = -3.4028235E38f;
            this.f47255h = Integer.MIN_VALUE;
            this.f47256i = Integer.MIN_VALUE;
            this.f47257j = -3.4028235E38f;
            this.f47258k = -3.4028235E38f;
            this.f47259l = -3.4028235E38f;
            this.f47260m = false;
            this.f47261n = -16777216;
            this.f47262o = Integer.MIN_VALUE;
        }

        public c(b bVar) {
            this.f47248a = bVar.f47232a;
            this.f47249b = bVar.f47234c;
            this.f47250c = bVar.f47233b;
            this.f47251d = bVar.f47235d;
            this.f47252e = bVar.f47236e;
            this.f47253f = bVar.f47237f;
            this.f47254g = bVar.f47238g;
            this.f47255h = bVar.f47239h;
            this.f47256i = bVar.f47244m;
            this.f47257j = bVar.f47245n;
            this.f47258k = bVar.f47240i;
            this.f47259l = bVar.f47241j;
            this.f47260m = bVar.f47242k;
            this.f47261n = bVar.f47243l;
            this.f47262o = bVar.f47246o;
            this.f47263p = bVar.f47247p;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    public c a() {
        return new c();
    }

    @Deprecated
    public b(CharSequence charSequence) {
        this(charSequence, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f);
    }

    @Deprecated
    public b(CharSequence charSequence, @p0 Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12) {
        this(charSequence, alignment, f10, i10, i11, f11, i12, f12, false, -16777216);
    }

    @Deprecated
    public b(CharSequence charSequence, @p0 Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12, int i13, float f13) {
        this(charSequence, alignment, null, f10, i10, i11, f11, i12, i13, f13, f12, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, 0.0f);
    }

    @Deprecated
    public b(CharSequence charSequence, @p0 Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12, boolean z10, int i13) {
        this(charSequence, alignment, null, f10, i10, i11, f11, i12, Integer.MIN_VALUE, -3.4028235E38f, f12, -3.4028235E38f, z10, i13, Integer.MIN_VALUE, 0.0f);
    }

    public b(@p0 CharSequence charSequence, @p0 Layout.Alignment alignment, @p0 Bitmap bitmap, float f10, int i10, int i11, float f11, int i12, int i13, float f12, float f13, float f14, boolean z10, int i14, int i15, float f15) {
        if (charSequence == null) {
            hd.a.g(bitmap);
        } else {
            hd.a.a(bitmap == null);
        }
        this.f47232a = charSequence;
        this.f47233b = alignment;
        this.f47234c = bitmap;
        this.f47235d = f10;
        this.f47236e = i10;
        this.f47237f = i11;
        this.f47238g = f11;
        this.f47239h = i12;
        this.f47240i = f13;
        this.f47241j = f14;
        this.f47242k = z10;
        this.f47243l = i14;
        this.f47244m = i13;
        this.f47245n = f12;
        this.f47246o = i15;
        this.f47247p = f15;
    }
}
