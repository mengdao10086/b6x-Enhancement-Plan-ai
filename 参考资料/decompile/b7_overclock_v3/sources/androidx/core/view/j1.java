package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class j1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4927b = "WindowInsetsCompat";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public static final j1 f4928c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f4929a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    @g.v0(21)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f4930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Field f4931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f4932c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f4933d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f4930a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f4931b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f4932c = declaredField3;
                declaredField3.setAccessible(true);
                f4933d = true;
            } catch (ReflectiveOperationException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to get visible insets from AttachInfo ");
                sb2.append(e10.getMessage());
            }
        }

        @g.p0
        public static j1 a(@g.n0 View view) {
            if (f4933d && view.isAttachedToWindow()) {
                try {
                    Object obj = f4930a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f4931b.get(obj);
                        Rect rect2 = (Rect) f4932c.get(obj);
                        if (rect != null && rect2 != null) {
                            j1 j1VarA = new b().f(m0.i.e(rect)).h(m0.i.e(rect2)).a();
                            j1VarA.H(j1VarA);
                            j1VarA.d(view.getRootView());
                            return j1VarA;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get insets from AttachInfo. ");
                    sb2.append(e10.getMessage());
                }
            }
            return null;
        }
    }

    @g.v0(30)
    public static class e extends d {
        public e() {
        }

        @Override // androidx.core.view.j1.f
        public void d(int i10, @g.n0 m0.i iVar) {
            this.f4941c.setInsets(n.a(i10), iVar.h());
        }

        @Override // androidx.core.view.j1.f
        public void e(int i10, @g.n0 m0.i iVar) {
            this.f4941c.setInsetsIgnoringVisibility(n.a(i10), iVar.h());
        }

        @Override // androidx.core.view.j1.f
        public void k(int i10, boolean z10) {
            this.f4941c.setVisible(n.a(i10), z10);
        }

        public e(@g.n0 j1 j1Var) {
            super(j1Var);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j1 f4942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m0.i[] f4943b;

        public f() {
            this(new j1((j1) null));
        }

        public final void a() {
            m0.i[] iVarArr = this.f4943b;
            if (iVarArr != null) {
                m0.i iVarF = iVarArr[m.e(1)];
                m0.i iVarF2 = this.f4943b[m.e(2)];
                if (iVarF2 == null) {
                    iVarF2 = this.f4942a.f(2);
                }
                if (iVarF == null) {
                    iVarF = this.f4942a.f(1);
                }
                i(m0.i.b(iVarF, iVarF2));
                m0.i iVar = this.f4943b[m.e(16)];
                if (iVar != null) {
                    h(iVar);
                }
                m0.i iVar2 = this.f4943b[m.e(32)];
                if (iVar2 != null) {
                    f(iVar2);
                }
                m0.i iVar3 = this.f4943b[m.e(64)];
                if (iVar3 != null) {
                    j(iVar3);
                }
            }
        }

        @g.n0
        public j1 b() {
            a();
            return this.f4942a;
        }

        public void c(@g.p0 androidx.core.view.g gVar) {
        }

        public void d(int i10, @g.n0 m0.i iVar) {
            if (this.f4943b == null) {
                this.f4943b = new m0.i[9];
            }
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    this.f4943b[m.e(i11)] = iVar;
                }
            }
        }

        public void e(int i10, @g.n0 m0.i iVar) {
            if (i10 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        public void f(@g.n0 m0.i iVar) {
        }

        public void g(@g.n0 m0.i iVar) {
        }

        public void h(@g.n0 m0.i iVar) {
        }

        public void i(@g.n0 m0.i iVar) {
        }

        public void j(@g.n0 m0.i iVar) {
        }

        public void k(int i10, boolean z10) {
        }

        public f(@g.n0 j1 j1Var) {
            this.f4942a = j1Var;
        }
    }

    @g.v0(28)
    public static class i extends h {
        public i(@g.n0 j1 j1Var, @g.n0 WindowInsets windowInsets) {
            super(j1Var, windowInsets);
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public j1 a() {
            return j1.K(this.f4949c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.j1.g, androidx.core.view.j1.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f4949c, iVar.f4949c) && Objects.equals(this.f4953g, iVar.f4953g);
        }

        @Override // androidx.core.view.j1.l
        @g.p0
        public androidx.core.view.g f() {
            return androidx.core.view.g.i(this.f4949c.getDisplayCutout());
        }

        @Override // androidx.core.view.j1.l
        public int hashCode() {
            return this.f4949c.hashCode();
        }

        public i(@g.n0 j1 j1Var, @g.n0 i iVar) {
            super(j1Var, iVar);
        }
    }

    @g.v0(30)
    public static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @g.n0
        public static final j1 f4958q = j1.K(WindowInsets.CONSUMED);

        public k(@g.n0 j1 j1Var, @g.n0 WindowInsets windowInsets) {
            super(j1Var, windowInsets);
        }

        @Override // androidx.core.view.j1.g, androidx.core.view.j1.l
        public final void d(@g.n0 View view) {
        }

        @Override // androidx.core.view.j1.g, androidx.core.view.j1.l
        @g.n0
        public m0.i g(int i10) {
            return m0.i.g(this.f4949c.getInsets(n.a(i10)));
        }

        @Override // androidx.core.view.j1.g, androidx.core.view.j1.l
        @g.n0
        public m0.i h(int i10) {
            return m0.i.g(this.f4949c.getInsetsIgnoringVisibility(n.a(i10)));
        }

        @Override // androidx.core.view.j1.g, androidx.core.view.j1.l
        public boolean q(int i10) {
            return this.f4949c.isVisible(n.a(i10));
        }

        public k(@g.n0 j1 j1Var, @g.n0 k kVar) {
            super(j1Var, kVar);
        }
    }

    public static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.n0
        public static final j1 f4959b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j1 f4960a;

        public l(@g.n0 j1 j1Var) {
            this.f4960a = j1Var;
        }

        @g.n0
        public j1 a() {
            return this.f4960a;
        }

        @g.n0
        public j1 b() {
            return this.f4960a;
        }

        @g.n0
        public j1 c() {
            return this.f4960a;
        }

        public void d(@g.n0 View view) {
        }

        public void e(@g.n0 j1 j1Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return p() == lVar.p() && o() == lVar.o() && androidx.core.util.j.a(l(), lVar.l()) && androidx.core.util.j.a(j(), lVar.j()) && androidx.core.util.j.a(f(), lVar.f());
        }

        @g.p0
        public androidx.core.view.g f() {
            return null;
        }

        @g.n0
        public m0.i g(int i10) {
            return m0.i.f40558e;
        }

        @g.n0
        public m0.i h(int i10) {
            if ((i10 & 8) == 0) {
                return m0.i.f40558e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return androidx.core.util.j.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        @g.n0
        public m0.i i() {
            return l();
        }

        @g.n0
        public m0.i j() {
            return m0.i.f40558e;
        }

        @g.n0
        public m0.i k() {
            return l();
        }

        @g.n0
        public m0.i l() {
            return m0.i.f40558e;
        }

        @g.n0
        public m0.i m() {
            return l();
        }

        @g.n0
        public j1 n(int i10, int i11, int i12, int i13) {
            return f4959b;
        }

        public boolean o() {
            return false;
        }

        public boolean p() {
            return false;
        }

        public boolean q(int i10) {
            return true;
        }

        public void r(m0.i[] iVarArr) {
        }

        public void s(@g.n0 m0.i iVar) {
        }

        public void t(@g.p0 j1 j1Var) {
        }

        public void u(m0.i iVar) {
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f4961a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f4962b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f4963c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f4964d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f4965e = 8;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f4966f = 16;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f4967g = 32;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f4968h = 64;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f4969i = 128;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f4970j = 256;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f4971k = 9;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f4972l = 256;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface a {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static int a() {
            return -1;
        }

        public static int b() {
            return 4;
        }

        public static int c() {
            return 128;
        }

        public static int d() {
            return 8;
        }

        public static int e(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        public static int f() {
            return 32;
        }

        public static int g() {
            return 2;
        }

        public static int h() {
            return 1;
        }

        public static int i() {
            return 7;
        }

        public static int j() {
            return 16;
        }

        public static int k() {
            return 64;
        }
    }

    @g.v0(30)
    public static final class n {
        private n() {
        }

        public static int a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f4928c = k.f4958q;
        } else {
            f4928c = l.f4959b;
        }
    }

    @g.v0(20)
    public j1(@g.n0 WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f4929a = new k(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.f4929a = new j(this, windowInsets);
        } else if (i10 >= 28) {
            this.f4929a = new i(this, windowInsets);
        } else {
            this.f4929a = new h(this, windowInsets);
        }
    }

    @g.n0
    @g.v0(20)
    public static j1 K(@g.n0 WindowInsets windowInsets) {
        return L(windowInsets, null);
    }

    @g.n0
    @g.v0(20)
    public static j1 L(@g.n0 WindowInsets windowInsets, @g.p0 View view) {
        j1 j1Var = new j1((WindowInsets) androidx.core.util.o.l(windowInsets));
        if (view != null && u0.O0(view)) {
            j1Var.H(u0.o0(view));
            j1Var.d(view.getRootView());
        }
        return j1Var;
    }

    public static m0.i z(@g.n0 m0.i iVar, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, iVar.f40559a - i10);
        int iMax2 = Math.max(0, iVar.f40560b - i11);
        int iMax3 = Math.max(0, iVar.f40561c - i12);
        int iMax4 = Math.max(0, iVar.f40562d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? iVar : m0.i.d(iMax, iMax2, iMax3, iMax4);
    }

    public boolean A() {
        return this.f4929a.o();
    }

    public boolean B() {
        return this.f4929a.p();
    }

    public boolean C(int i10) {
        return this.f4929a.q(i10);
    }

    @g.n0
    @Deprecated
    public j1 D(int i10, int i11, int i12, int i13) {
        return new b(this).h(m0.i.d(i10, i11, i12, i13)).a();
    }

    @g.n0
    @Deprecated
    public j1 E(@g.n0 Rect rect) {
        return new b(this).h(m0.i.e(rect)).a();
    }

    public void F(m0.i[] iVarArr) {
        this.f4929a.r(iVarArr);
    }

    public void G(@g.n0 m0.i iVar) {
        this.f4929a.s(iVar);
    }

    public void H(@g.p0 j1 j1Var) {
        this.f4929a.t(j1Var);
    }

    public void I(@g.p0 m0.i iVar) {
        this.f4929a.u(iVar);
    }

    @g.p0
    @g.v0(20)
    public WindowInsets J() {
        l lVar = this.f4929a;
        if (lVar instanceof g) {
            return ((g) lVar).f4949c;
        }
        return null;
    }

    @g.n0
    @Deprecated
    public j1 a() {
        return this.f4929a.a();
    }

    @g.n0
    @Deprecated
    public j1 b() {
        return this.f4929a.b();
    }

    @g.n0
    @Deprecated
    public j1 c() {
        return this.f4929a.c();
    }

    public void d(@g.n0 View view) {
        this.f4929a.d(view);
    }

    @g.p0
    public androidx.core.view.g e() {
        return this.f4929a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j1) {
            return androidx.core.util.j.a(this.f4929a, ((j1) obj).f4929a);
        }
        return false;
    }

    @g.n0
    public m0.i f(int i10) {
        return this.f4929a.g(i10);
    }

    @g.n0
    public m0.i g(int i10) {
        return this.f4929a.h(i10);
    }

    @g.n0
    @Deprecated
    public m0.i h() {
        return this.f4929a.i();
    }

    public int hashCode() {
        l lVar = this.f4929a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f4929a.j().f40562d;
    }

    @Deprecated
    public int j() {
        return this.f4929a.j().f40559a;
    }

    @Deprecated
    public int k() {
        return this.f4929a.j().f40561c;
    }

    @Deprecated
    public int l() {
        return this.f4929a.j().f40560b;
    }

    @g.n0
    @Deprecated
    public m0.i m() {
        return this.f4929a.j();
    }

    @g.n0
    @Deprecated
    public m0.i n() {
        return this.f4929a.k();
    }

    @Deprecated
    public int o() {
        return this.f4929a.l().f40562d;
    }

    @Deprecated
    public int p() {
        return this.f4929a.l().f40559a;
    }

    @Deprecated
    public int q() {
        return this.f4929a.l().f40561c;
    }

    @Deprecated
    public int r() {
        return this.f4929a.l().f40560b;
    }

    @g.n0
    @Deprecated
    public m0.i s() {
        return this.f4929a.l();
    }

    @g.n0
    @Deprecated
    public m0.i t() {
        return this.f4929a.m();
    }

    public boolean u() {
        m0.i iVarF = f(m.a());
        m0.i iVar = m0.i.f40558e;
        return (iVarF.equals(iVar) && g(m.a() ^ m.d()).equals(iVar) && e() == null) ? false : true;
    }

    @Deprecated
    public boolean v() {
        return !this.f4929a.j().equals(m0.i.f40558e);
    }

    @Deprecated
    public boolean w() {
        return !this.f4929a.l().equals(m0.i.f40558e);
    }

    @g.n0
    public j1 x(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11, @g.f0(from = 0) int i12, @g.f0(from = 0) int i13) {
        return this.f4929a.n(i10, i11, i12, i13);
    }

    @g.n0
    public j1 y(@g.n0 m0.i iVar) {
        return x(iVar.f40559a, iVar.f40560b, iVar.f40561c, iVar.f40562d);
    }

    @g.v0(api = 20)
    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f4935e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f4936f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Constructor<WindowInsets> f4937g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f4938h;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsets f4939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m0.i f4940d;

        public c() {
            this.f4939c = l();
        }

        @g.p0
        private static WindowInsets l() {
            if (!f4936f) {
                try {
                    f4935e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f4936f = true;
            }
            Field field = f4935e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f4938h) {
                try {
                    f4937g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f4938h = true;
            }
            Constructor<WindowInsets> constructor = f4937g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // androidx.core.view.j1.f
        @g.n0
        public j1 b() {
            a();
            j1 j1VarK = j1.K(this.f4939c);
            j1VarK.F(this.f4943b);
            j1VarK.I(this.f4940d);
            return j1VarK;
        }

        @Override // androidx.core.view.j1.f
        public void g(@g.p0 m0.i iVar) {
            this.f4940d = iVar;
        }

        @Override // androidx.core.view.j1.f
        public void i(@g.n0 m0.i iVar) {
            WindowInsets windowInsets = this.f4939c;
            if (windowInsets != null) {
                this.f4939c = windowInsets.replaceSystemWindowInsets(iVar.f40559a, iVar.f40560b, iVar.f40561c, iVar.f40562d);
            }
        }

        public c(@g.n0 j1 j1Var) {
            super(j1Var);
            this.f4939c = j1Var.J();
        }
    }

    @g.v0(api = 29)
    public static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f4941c;

        public d() {
            this.f4941c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.j1.f
        @g.n0
        public j1 b() {
            a();
            j1 j1VarK = j1.K(this.f4941c.build());
            j1VarK.F(this.f4943b);
            return j1VarK;
        }

        @Override // androidx.core.view.j1.f
        public void c(@g.p0 androidx.core.view.g gVar) {
            this.f4941c.setDisplayCutout(gVar != null ? gVar.h() : null);
        }

        @Override // androidx.core.view.j1.f
        public void f(@g.n0 m0.i iVar) {
            this.f4941c.setMandatorySystemGestureInsets(iVar.h());
        }

        @Override // androidx.core.view.j1.f
        public void g(@g.n0 m0.i iVar) {
            this.f4941c.setStableInsets(iVar.h());
        }

        @Override // androidx.core.view.j1.f
        public void h(@g.n0 m0.i iVar) {
            this.f4941c.setSystemGestureInsets(iVar.h());
        }

        @Override // androidx.core.view.j1.f
        public void i(@g.n0 m0.i iVar) {
            this.f4941c.setSystemWindowInsets(iVar.h());
        }

        @Override // androidx.core.view.j1.f
        public void j(@g.n0 m0.i iVar) {
            this.f4941c.setTappableElementInsets(iVar.h());
        }

        public d(@g.n0 j1 j1Var) {
            WindowInsets.Builder builder;
            super(j1Var);
            WindowInsets windowInsetsJ = j1Var.J();
            if (windowInsetsJ != null) {
                builder = new WindowInsets.Builder(windowInsetsJ);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f4941c = builder;
        }
    }

    @g.v0(21)
    public static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public m0.i f4954m;

        public h(@g.n0 j1 j1Var, @g.n0 WindowInsets windowInsets) {
            super(j1Var, windowInsets);
            this.f4954m = null;
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public j1 b() {
            return j1.K(this.f4949c.consumeStableInsets());
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public j1 c() {
            return j1.K(this.f4949c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public final m0.i j() {
            if (this.f4954m == null) {
                this.f4954m = m0.i.d(this.f4949c.getStableInsetLeft(), this.f4949c.getStableInsetTop(), this.f4949c.getStableInsetRight(), this.f4949c.getStableInsetBottom());
            }
            return this.f4954m;
        }

        @Override // androidx.core.view.j1.l
        public boolean o() {
            return this.f4949c.isConsumed();
        }

        @Override // androidx.core.view.j1.l
        public void u(@g.p0 m0.i iVar) {
            this.f4954m = iVar;
        }

        public h(@g.n0 j1 j1Var, @g.n0 h hVar) {
            super(j1Var, hVar);
            this.f4954m = null;
            this.f4954m = hVar.f4954m;
        }
    }

    @g.v0(20)
    public static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f4944h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Method f4945i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Class<?> f4946j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Field f4947k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f4948l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.n0
        public final WindowInsets f4949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m0.i[] f4950d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public m0.i f4951e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public j1 f4952f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public m0.i f4953g;

        public g(@g.n0 j1 j1Var, @g.n0 WindowInsets windowInsets) {
            super(j1Var);
            this.f4951e = null;
            this.f4949c = windowInsets;
        }

        @SuppressLint({"PrivateApi"})
        private static void A() {
            try {
                f4945i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f4946j = cls;
                f4947k = cls.getDeclaredField("mVisibleInsets");
                f4948l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f4947k.setAccessible(true);
                f4948l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to get visible insets. (Reflection error). ");
                sb2.append(e10.getMessage());
            }
            f4944h = true;
        }

        @SuppressLint({"WrongConstant"})
        @g.n0
        private m0.i v(int i10, boolean z10) {
            m0.i iVarB = m0.i.f40558e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    iVarB = m0.i.b(iVarB, w(i11, z10));
                }
            }
            return iVarB;
        }

        private m0.i x() {
            j1 j1Var = this.f4952f;
            return j1Var != null ? j1Var.m() : m0.i.f40558e;
        }

        @g.p0
        private m0.i y(@g.n0 View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f4944h) {
                A();
            }
            Method method = f4945i;
            if (method != null && f4946j != null && f4947k != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        return null;
                    }
                    Rect rect = (Rect) f4947k.get(f4948l.get(objInvoke));
                    if (rect != null) {
                        return m0.i.e(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get visible insets. (Reflection error). ");
                    sb2.append(e10.getMessage());
                }
            }
            return null;
        }

        @Override // androidx.core.view.j1.l
        public void d(@g.n0 View view) {
            m0.i iVarY = y(view);
            if (iVarY == null) {
                iVarY = m0.i.f40558e;
            }
            s(iVarY);
        }

        @Override // androidx.core.view.j1.l
        public void e(@g.n0 j1 j1Var) {
            j1Var.H(this.f4952f);
            j1Var.G(this.f4953g);
        }

        @Override // androidx.core.view.j1.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f4953g, ((g) obj).f4953g);
            }
            return false;
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public m0.i g(int i10) {
            return v(i10, false);
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public m0.i h(int i10) {
            return v(i10, true);
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public final m0.i l() {
            if (this.f4951e == null) {
                this.f4951e = m0.i.d(this.f4949c.getSystemWindowInsetLeft(), this.f4949c.getSystemWindowInsetTop(), this.f4949c.getSystemWindowInsetRight(), this.f4949c.getSystemWindowInsetBottom());
            }
            return this.f4951e;
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public j1 n(int i10, int i11, int i12, int i13) {
            b bVar = new b(j1.K(this.f4949c));
            bVar.h(j1.z(l(), i10, i11, i12, i13));
            bVar.f(j1.z(j(), i10, i11, i12, i13));
            return bVar.a();
        }

        @Override // androidx.core.view.j1.l
        public boolean p() {
            return this.f4949c.isRound();
        }

        @Override // androidx.core.view.j1.l
        @SuppressLint({"WrongConstant"})
        public boolean q(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0 && !z(i11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.j1.l
        public void r(m0.i[] iVarArr) {
            this.f4950d = iVarArr;
        }

        @Override // androidx.core.view.j1.l
        public void s(@g.n0 m0.i iVar) {
            this.f4953g = iVar;
        }

        @Override // androidx.core.view.j1.l
        public void t(@g.p0 j1 j1Var) {
            this.f4952f = j1Var;
        }

        @g.n0
        public m0.i w(int i10, boolean z10) {
            m0.i iVarM;
            int i11;
            if (i10 == 1) {
                return z10 ? m0.i.d(0, Math.max(x().f40560b, l().f40560b), 0, 0) : m0.i.d(0, l().f40560b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    m0.i iVarX = x();
                    m0.i iVarJ = j();
                    return m0.i.d(Math.max(iVarX.f40559a, iVarJ.f40559a), 0, Math.max(iVarX.f40561c, iVarJ.f40561c), Math.max(iVarX.f40562d, iVarJ.f40562d));
                }
                m0.i iVarL = l();
                j1 j1Var = this.f4952f;
                iVarM = j1Var != null ? j1Var.m() : null;
                int iMin = iVarL.f40562d;
                if (iVarM != null) {
                    iMin = Math.min(iMin, iVarM.f40562d);
                }
                return m0.i.d(iVarL.f40559a, 0, iVarL.f40561c, iMin);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return k();
                }
                if (i10 == 32) {
                    return i();
                }
                if (i10 == 64) {
                    return m();
                }
                if (i10 != 128) {
                    return m0.i.f40558e;
                }
                j1 j1Var2 = this.f4952f;
                androidx.core.view.g gVarE = j1Var2 != null ? j1Var2.e() : f();
                return gVarE != null ? m0.i.d(gVarE.d(), gVarE.f(), gVarE.e(), gVarE.c()) : m0.i.f40558e;
            }
            m0.i[] iVarArr = this.f4950d;
            iVarM = iVarArr != null ? iVarArr[m.e(8)] : null;
            if (iVarM != null) {
                return iVarM;
            }
            m0.i iVarL2 = l();
            m0.i iVarX2 = x();
            int i12 = iVarL2.f40562d;
            if (i12 > iVarX2.f40562d) {
                return m0.i.d(0, 0, 0, i12);
            }
            m0.i iVar = this.f4953g;
            return (iVar == null || iVar.equals(m0.i.f40558e) || (i11 = this.f4953g.f40562d) <= iVarX2.f40562d) ? m0.i.f40558e : m0.i.d(0, 0, 0, i11);
        }

        public boolean z(int i10) {
            if (i10 != 1 && i10 != 2) {
                if (i10 == 4) {
                    return false;
                }
                if (i10 != 8 && i10 != 128) {
                    return true;
                }
            }
            return !w(i10, false).equals(m0.i.f40558e);
        }

        public g(@g.n0 j1 j1Var, @g.n0 g gVar) {
            this(j1Var, new WindowInsets(gVar.f4949c));
        }
    }

    @g.v0(29)
    public static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public m0.i f4955n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public m0.i f4956o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public m0.i f4957p;

        public j(@g.n0 j1 j1Var, @g.n0 WindowInsets windowInsets) {
            super(j1Var, windowInsets);
            this.f4955n = null;
            this.f4956o = null;
            this.f4957p = null;
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public m0.i i() {
            if (this.f4956o == null) {
                this.f4956o = m0.i.g(this.f4949c.getMandatorySystemGestureInsets());
            }
            return this.f4956o;
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public m0.i k() {
            if (this.f4955n == null) {
                this.f4955n = m0.i.g(this.f4949c.getSystemGestureInsets());
            }
            return this.f4955n;
        }

        @Override // androidx.core.view.j1.l
        @g.n0
        public m0.i m() {
            if (this.f4957p == null) {
                this.f4957p = m0.i.g(this.f4949c.getTappableElementInsets());
            }
            return this.f4957p;
        }

        @Override // androidx.core.view.j1.g, androidx.core.view.j1.l
        @g.n0
        public j1 n(int i10, int i11, int i12, int i13) {
            return j1.K(this.f4949c.inset(i10, i11, i12, i13));
        }

        @Override // androidx.core.view.j1.h, androidx.core.view.j1.l
        public void u(@g.p0 m0.i iVar) {
        }

        public j(@g.n0 j1 j1Var, @g.n0 j jVar) {
            super(j1Var, jVar);
            this.f4955n = null;
            this.f4956o = null;
            this.f4957p = null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f4934a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f4934a = new e();
            } else if (i10 >= 29) {
                this.f4934a = new d();
            } else {
                this.f4934a = new c();
            }
        }

        @g.n0
        public j1 a() {
            return this.f4934a.b();
        }

        @g.n0
        public b b(@g.p0 androidx.core.view.g gVar) {
            this.f4934a.c(gVar);
            return this;
        }

        @g.n0
        public b c(int i10, @g.n0 m0.i iVar) {
            this.f4934a.d(i10, iVar);
            return this;
        }

        @g.n0
        public b d(int i10, @g.n0 m0.i iVar) {
            this.f4934a.e(i10, iVar);
            return this;
        }

        @g.n0
        @Deprecated
        public b e(@g.n0 m0.i iVar) {
            this.f4934a.f(iVar);
            return this;
        }

        @g.n0
        @Deprecated
        public b f(@g.n0 m0.i iVar) {
            this.f4934a.g(iVar);
            return this;
        }

        @g.n0
        @Deprecated
        public b g(@g.n0 m0.i iVar) {
            this.f4934a.h(iVar);
            return this;
        }

        @g.n0
        @Deprecated
        public b h(@g.n0 m0.i iVar) {
            this.f4934a.i(iVar);
            return this;
        }

        @g.n0
        @Deprecated
        public b i(@g.n0 m0.i iVar) {
            this.f4934a.j(iVar);
            return this;
        }

        @g.n0
        public b j(int i10, boolean z10) {
            this.f4934a.k(i10, z10);
            return this;
        }

        public b(@g.n0 j1 j1Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f4934a = new e(j1Var);
            } else if (i10 >= 29) {
                this.f4934a = new d(j1Var);
            } else {
                this.f4934a = new c(j1Var);
            }
        }
    }

    public j1(@g.p0 j1 j1Var) {
        if (j1Var != null) {
            l lVar = j1Var.f4929a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (lVar instanceof k)) {
                this.f4929a = new k(this, (k) lVar);
            } else if (i10 >= 29 && (lVar instanceof j)) {
                this.f4929a = new j(this, (j) lVar);
            } else if (i10 >= 28 && (lVar instanceof i)) {
                this.f4929a = new i(this, (i) lVar);
            } else if (lVar instanceof h) {
                this.f4929a = new h(this, (h) lVar);
            } else if (lVar instanceof g) {
                this.f4929a = new g(this, (g) lVar);
            } else {
                this.f4929a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f4929a = new l(this);
    }
}
