package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
import g.l;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class b extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f1768m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f1769n = "DrawableContainer";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f1770o = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f1771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f1772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f1773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f1774d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1776f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f1779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f1782l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1775e = 255;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1777g = -1;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.graphics.drawable.b$b, reason: collision with other inner class name */
    @v0(21)
    public static class C0031b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    public static class c implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable.Callback f1784a;

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f1784a;
            this.f1784a = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f1784a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@n0 Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable, long j10) {
            Drawable.Callback callback = this.f1784a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable) {
            Drawable.Callback callback = this.f1784a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    public static abstract class d extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f1785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Resources f1786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1788d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1789e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f1790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Drawable[] f1791g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1792h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f1793i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f1794j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Rect f1795k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f1796l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f1797m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1798n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1799o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1800p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1801q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f1802r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f1803s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f1804t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f1805u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f1806v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f1807w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f1808x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f1809y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f1810z;

        public d(d dVar, b bVar, Resources resources) {
            this.f1793i = false;
            this.f1796l = false;
            this.f1808x = true;
            this.A = 0;
            this.B = 0;
            this.f1785a = bVar;
            this.f1786b = resources != null ? resources : dVar != null ? dVar.f1786b : null;
            int iG = b.g(resources, dVar != null ? dVar.f1787c : 0);
            this.f1787c = iG;
            if (dVar == null) {
                this.f1791g = new Drawable[10];
                this.f1792h = 0;
                return;
            }
            this.f1788d = dVar.f1788d;
            this.f1789e = dVar.f1789e;
            this.f1806v = true;
            this.f1807w = true;
            this.f1793i = dVar.f1793i;
            this.f1796l = dVar.f1796l;
            this.f1808x = dVar.f1808x;
            this.f1809y = dVar.f1809y;
            this.f1810z = dVar.f1810z;
            this.A = dVar.A;
            this.B = dVar.B;
            this.C = dVar.C;
            this.D = dVar.D;
            this.E = dVar.E;
            this.F = dVar.F;
            this.G = dVar.G;
            this.H = dVar.H;
            this.I = dVar.I;
            if (dVar.f1787c == iG) {
                if (dVar.f1794j) {
                    this.f1795k = dVar.f1795k != null ? new Rect(dVar.f1795k) : null;
                    this.f1794j = true;
                }
                if (dVar.f1797m) {
                    this.f1798n = dVar.f1798n;
                    this.f1799o = dVar.f1799o;
                    this.f1800p = dVar.f1800p;
                    this.f1801q = dVar.f1801q;
                    this.f1797m = true;
                }
            }
            if (dVar.f1802r) {
                this.f1803s = dVar.f1803s;
                this.f1802r = true;
            }
            if (dVar.f1804t) {
                this.f1805u = dVar.f1805u;
                this.f1804t = true;
            }
            Drawable[] drawableArr = dVar.f1791g;
            this.f1791g = new Drawable[drawableArr.length];
            this.f1792h = dVar.f1792h;
            SparseArray<Drawable.ConstantState> sparseArray = dVar.f1790f;
            if (sparseArray != null) {
                this.f1790f = sparseArray.clone();
            } else {
                this.f1790f = new SparseArray<>(this.f1792h);
            }
            int i10 = this.f1792h;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11] != null) {
                    Drawable.ConstantState constantState = drawableArr[i11].getConstantState();
                    if (constantState != null) {
                        this.f1790f.put(i11, constantState);
                    } else {
                        this.f1791g[i11] = drawableArr[i11];
                    }
                }
            }
        }

        public final boolean A(int i10, int i11) {
            int i12 = this.f1792h;
            Drawable[] drawableArr = this.f1791g;
            boolean z10 = false;
            for (int i13 = 0; i13 < i12; i13++) {
                if (drawableArr[i13] != null) {
                    boolean zM = Build.VERSION.SDK_INT >= 23 ? n0.c.m(drawableArr[i13], i10) : false;
                    if (i13 == i11) {
                        z10 = zM;
                    }
                }
            }
            this.f1810z = i10;
            return z10;
        }

        public final void B(boolean z10) {
            this.f1793i = z10;
        }

        public final void C(Resources resources) {
            if (resources != null) {
                this.f1786b = resources;
                int iG = b.g(resources, this.f1787c);
                int i10 = this.f1787c;
                this.f1787c = iG;
                if (i10 != iG) {
                    this.f1797m = false;
                    this.f1794j = false;
                }
            }
        }

        public final int a(Drawable drawable) {
            int i10 = this.f1792h;
            if (i10 >= this.f1791g.length) {
                r(i10, i10 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1785a);
            this.f1791g[i10] = drawable;
            this.f1792h++;
            this.f1789e = drawable.getChangingConfigurations() | this.f1789e;
            s();
            this.f1795k = null;
            this.f1794j = false;
            this.f1797m = false;
            this.f1806v = false;
            return i10;
        }

        @v0(21)
        public final void b(Resources.Theme theme) {
            if (theme != null) {
                f();
                int i10 = this.f1792h;
                Drawable[] drawableArr = this.f1791g;
                for (int i11 = 0; i11 < i10; i11++) {
                    if (drawableArr[i11] != null && n0.c.b(drawableArr[i11])) {
                        n0.c.a(drawableArr[i11], theme);
                        this.f1789e |= drawableArr[i11].getChangingConfigurations();
                    }
                }
                C(C0031b.c(theme));
            }
        }

        public boolean c() {
            if (this.f1806v) {
                return this.f1807w;
            }
            f();
            this.f1806v = true;
            int i10 = this.f1792h;
            Drawable[] drawableArr = this.f1791g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getConstantState() == null) {
                    this.f1807w = false;
                    return false;
                }
            }
            this.f1807w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @v0(21)
        public boolean canApplyTheme() {
            int i10 = this.f1792h;
            Drawable[] drawableArr = this.f1791g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f1790f.get(i11);
                    if (constantState != null && C0031b.a(constantState)) {
                        return true;
                    }
                } else if (n0.c.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public final void d() {
            this.f1809y = false;
        }

        public void e() {
            this.f1797m = true;
            f();
            int i10 = this.f1792h;
            Drawable[] drawableArr = this.f1791g;
            this.f1799o = -1;
            this.f1798n = -1;
            this.f1801q = 0;
            this.f1800p = 0;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f1798n) {
                    this.f1798n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f1799o) {
                    this.f1799o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f1800p) {
                    this.f1800p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f1801q) {
                    this.f1801q = minimumHeight;
                }
            }
        }

        public final void f() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f1790f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.f1791g[this.f1790f.keyAt(i10)] = w(this.f1790f.valueAt(i10).newDrawable(this.f1786b));
                }
                this.f1790f = null;
            }
        }

        public final int g() {
            return this.f1791g.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1788d | this.f1789e;
        }

        public final Drawable h(int i10) {
            int iIndexOfKey;
            Drawable drawable = this.f1791g[i10];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f1790f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i10)) < 0) {
                return null;
            }
            Drawable drawableW = w(this.f1790f.valueAt(iIndexOfKey).newDrawable(this.f1786b));
            this.f1791g[i10] = drawableW;
            this.f1790f.removeAt(iIndexOfKey);
            if (this.f1790f.size() == 0) {
                this.f1790f = null;
            }
            return drawableW;
        }

        public final int i() {
            return this.f1792h;
        }

        public final int j() {
            if (!this.f1797m) {
                e();
            }
            return this.f1799o;
        }

        public final int k() {
            if (!this.f1797m) {
                e();
            }
            return this.f1801q;
        }

        public final int l() {
            if (!this.f1797m) {
                e();
            }
            return this.f1800p;
        }

        public final Rect m() {
            Rect rect = null;
            if (this.f1793i) {
                return null;
            }
            Rect rect2 = this.f1795k;
            if (rect2 != null || this.f1794j) {
                return rect2;
            }
            f();
            Rect rect3 = new Rect();
            int i10 = this.f1792h;
            Drawable[] drawableArr = this.f1791g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i12 = rect3.left;
                    if (i12 > rect.left) {
                        rect.left = i12;
                    }
                    int i13 = rect3.top;
                    if (i13 > rect.top) {
                        rect.top = i13;
                    }
                    int i14 = rect3.right;
                    if (i14 > rect.right) {
                        rect.right = i14;
                    }
                    int i15 = rect3.bottom;
                    if (i15 > rect.bottom) {
                        rect.bottom = i15;
                    }
                }
            }
            this.f1794j = true;
            this.f1795k = rect;
            return rect;
        }

        public final int n() {
            if (!this.f1797m) {
                e();
            }
            return this.f1798n;
        }

        public final int o() {
            return this.A;
        }

        public final int p() {
            return this.B;
        }

        public final int q() {
            if (this.f1802r) {
                return this.f1803s;
            }
            f();
            int i10 = this.f1792h;
            Drawable[] drawableArr = this.f1791g;
            int opacity = i10 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i11 = 1; i11 < i10; i11++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i11].getOpacity());
            }
            this.f1803s = opacity;
            this.f1802r = true;
            return opacity;
        }

        public void r(int i10, int i11) {
            Drawable[] drawableArr = new Drawable[i11];
            Drawable[] drawableArr2 = this.f1791g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i10);
            }
            this.f1791g = drawableArr;
        }

        public void s() {
            this.f1802r = false;
            this.f1804t = false;
        }

        public final boolean t() {
            return this.f1796l;
        }

        public final boolean u() {
            if (this.f1804t) {
                return this.f1805u;
            }
            f();
            int i10 = this.f1792h;
            Drawable[] drawableArr = this.f1791g;
            boolean z10 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    break;
                }
                if (drawableArr[i11].isStateful()) {
                    z10 = true;
                    break;
                }
                i11++;
            }
            this.f1805u = z10;
            this.f1804t = true;
            return z10;
        }

        public void v() {
            int i10 = this.f1792h;
            Drawable[] drawableArr = this.f1791g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11] != null) {
                    drawableArr[i11].mutate();
                }
            }
            this.f1809y = true;
        }

        public final Drawable w(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                n0.c.m(drawable, this.f1810z);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f1785a);
            return drawableMutate;
        }

        public final void x(boolean z10) {
            this.f1796l = z10;
        }

        public final void y(int i10) {
            this.A = i10;
        }

        public final void z(int i10) {
            this.B = i10;
        }
    }

    public static int g(@p0 Resources resources, int i10) {
        if (resources != null) {
            i10 = resources.getDisplayMetrics().densityDpi;
        }
        if (i10 == 0) {
            return 160;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f1776f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f1773c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f1780j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f1775e
            r3.setAlpha(r9)
            r13.f1780j = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.graphics.drawable.b$d r9 = r13.f1771a
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f1775e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f1780j = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f1774d
            if (r9 == 0) goto L65
            long r10 = r13.f1781k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f1774d = r0
            r13.f1781k = r7
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.b$d r4 = r13.f1771a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f1775e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f1781k = r7
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f1779i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.b.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    @v0(21)
    public void applyTheme(@n0 Resources.Theme theme) {
        this.f1771a.b(theme);
    }

    public void b() {
        this.f1771a.d();
        this.f1778h = false;
    }

    public d c() {
        return this.f1771a;
    }

    @Override // android.graphics.drawable.Drawable
    @v0(21)
    public boolean canApplyTheme() {
        return this.f1771a.canApplyTheme();
    }

    int d() {
        return this.f1777g;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f1774d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final void e(Drawable drawable) {
        if (this.f1782l == null) {
            this.f1782l = new c();
        }
        drawable.setCallback(this.f1782l.b(drawable.getCallback()));
        try {
            if (this.f1771a.A <= 0 && this.f1776f) {
                drawable.setAlpha(this.f1775e);
            }
            d dVar = this.f1771a;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    n0.c.o(drawable, dVar.F);
                }
                d dVar2 = this.f1771a;
                if (dVar2.I) {
                    n0.c.p(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1771a.f1808x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                n0.c.m(drawable, n0.c.f(this));
            }
            n0.c.j(drawable, this.f1771a.C);
            Rect rect = this.f1772b;
            if (rect != null) {
                n0.c.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f1782l.a());
        }
    }

    public final boolean f() {
        return isAutoMirrored() && n0.c.f(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1775e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1771a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f1771a.c()) {
            return null;
        }
        this.f1771a.f1788d = getChangingConfigurations();
        return this.f1771a;
    }

    @Override // android.graphics.drawable.Drawable
    @n0
    public Drawable getCurrent() {
        return this.f1773c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@n0 Rect rect) {
        Rect rect2 = this.f1772b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1771a.t()) {
            return this.f1771a.j();
        }
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1771a.t()) {
            return this.f1771a.n();
        }
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f1771a.t()) {
            return this.f1771a.k();
        }
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f1771a.t()) {
            return this.f1771a.l();
        }
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1773c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f1771a.q();
    }

    @Override // android.graphics.drawable.Drawable
    @v0(21)
    public void getOutline(@n0 Outline outline) {
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            C0031b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@n0 Rect rect) {
        boolean padding;
        Rect rectM = this.f1771a.m();
        if (rectM != null) {
            rect.set(rectM);
            padding = (rectM.right | ((rectM.left | rectM.top) | rectM.bottom)) != 0;
        } else {
            Drawable drawable = this.f1773c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (f()) {
            int i10 = rect.left;
            rect.left = rect.right;
            rect.right = i10;
        }
        return padding;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean h(int r10) {
        /*
            r9 = this;
            int r0 = r9.f1777g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.b$d r0 = r9.f1771a
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f1774d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f1773c
            if (r0 == 0) goto L29
            r9.f1774d = r0
            androidx.appcompat.graphics.drawable.b$d r0 = r9.f1771a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f1781k = r0
            goto L35
        L29:
            r9.f1774d = r4
            r9.f1781k = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f1773c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            androidx.appcompat.graphics.drawable.b$d r0 = r9.f1771a
            int r1 = r0.f1792h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.h(r10)
            r9.f1773c = r0
            r9.f1777g = r10
            if (r0 == 0) goto L5a
            androidx.appcompat.graphics.drawable.b$d r10 = r9.f1771a
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f1780j = r2
        L51:
            r9.e(r0)
            goto L5a
        L55:
            r9.f1773c = r4
            r10 = -1
            r9.f1777g = r10
        L5a:
            long r0 = r9.f1780j
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f1781k
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f1779i
            if (r0 != 0) goto L73
            androidx.appcompat.graphics.drawable.b$a r0 = new androidx.appcompat.graphics.drawable.b$a
            r0.<init>()
            r9.f1779i = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.b.h(int):boolean");
    }

    public void i(d dVar) {
        this.f1771a = dVar;
        int i10 = this.f1777g;
        if (i10 >= 0) {
            Drawable drawableH = dVar.h(i10);
            this.f1773c = drawableH;
            if (drawableH != null) {
                e(drawableH);
            }
        }
        this.f1774d = null;
    }

    public void invalidateDrawable(@n0 Drawable drawable) {
        d dVar = this.f1771a;
        if (dVar != null) {
            dVar.s();
        }
        if (drawable != this.f1773c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1771a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f1771a.u();
    }

    public void j(int i10) {
        h(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f1774d;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f1774d = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f1773c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1776f) {
                this.f1773c.setAlpha(this.f1775e);
            }
        }
        if (this.f1781k != 0) {
            this.f1781k = 0L;
            z10 = true;
        }
        if (this.f1780j != 0) {
            this.f1780j = 0L;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    public void k(int i10) {
        this.f1771a.A = i10;
    }

    public void l(int i10) {
        this.f1771a.B = i10;
    }

    public final void m(Resources resources) {
        this.f1771a.C(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1778h && super.mutate() == this) {
            d dVarC = c();
            dVarC.v();
            i(dVarC);
            this.f1778h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1774d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1773c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return this.f1771a.A(i10, d());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f1774d;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f1773c;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@n0 int[] iArr) {
        Drawable drawable = this.f1774d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1773c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable, long j10) {
        if (drawable != this.f1773c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f1776f && this.f1775e == i10) {
            return;
        }
        this.f1776f = true;
        this.f1775e = i10;
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            if (this.f1780j == 0) {
                drawable.setAlpha(i10);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        d dVar = this.f1771a;
        if (dVar.C != z10) {
            dVar.C = z10;
            Drawable drawable = this.f1773c;
            if (drawable != null) {
                n0.c.j(drawable, z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f1771a;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f1773c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        d dVar = this.f1771a;
        if (dVar.f1808x != z10) {
            dVar.f1808x = z10;
            Drawable drawable = this.f1773c;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            n0.c.k(drawable, f10, f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f1772b;
        if (rect == null) {
            this.f1772b = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f1773c;
        if (drawable != null) {
            n0.c.l(drawable, i10, i11, i12, i13);
        }
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTint(@l int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f1771a;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            n0.c.o(this.f1773c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintMode(@n0 PorterDuff.Mode mode) {
        d dVar = this.f1771a;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            n0.c.p(this.f1773c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f1774d;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f1773c;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    public void unscheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable) {
        if (drawable != this.f1773c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
