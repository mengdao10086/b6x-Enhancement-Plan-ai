package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.fragment.app.g0;
import g.c1;
import g.n0;
import g.p0;
import g.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import l.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f1596a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f1597b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f1598c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f1599d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f1600e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1601f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1602g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f1603h = 16;

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface InterfaceC0028a {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    public interface d {
        void a(boolean z10);
    }

    @Deprecated
    public interface e {
        boolean a(int i10, long j10);
    }

    @Deprecated
    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1605a = -1;

        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract int d();

        public abstract Object e();

        public abstract CharSequence f();

        public abstract void g();

        public abstract f h(@c1 int i10);

        public abstract f i(CharSequence charSequence);

        public abstract f j(int i10);

        public abstract f k(View view);

        public abstract f l(@v int i10);

        public abstract f m(Drawable drawable);

        public abstract f n(g gVar);

        public abstract f o(Object obj);

        public abstract f p(int i10);

        public abstract f q(CharSequence charSequence);
    }

    @Deprecated
    public interface g {
        void a(f fVar, g0 g0Var);

        void b(f fVar, g0 g0Var);

        void c(f fVar, g0 g0Var);
    }

    public Context A() {
        return null;
    }

    public abstract void A0(CharSequence charSequence);

    @p0
    public abstract CharSequence B();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void B0(CharSequence charSequence) {
    }

    public abstract void C();

    public abstract void C0();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean D() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public l.b D0(b.a aVar) {
        return null;
    }

    public boolean E() {
        return false;
    }

    public abstract boolean F();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean G() {
        return false;
    }

    @Deprecated
    public abstract f H();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void I(Configuration configuration) {
    }

    public void J() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean K(int i10, KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean L(KeyEvent keyEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean M() {
        return false;
    }

    @Deprecated
    public abstract void N();

    public abstract void O(d dVar);

    @Deprecated
    public abstract void P(f fVar);

    @Deprecated
    public abstract void Q(int i10);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean R() {
        return false;
    }

    @Deprecated
    public abstract void S(f fVar);

    public abstract void T(@p0 Drawable drawable);

    public abstract void U(int i10);

    public abstract void V(View view);

    public abstract void W(View view, b bVar);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void X(boolean z10) {
    }

    public abstract void Y(boolean z10);

    public abstract void Z(int i10);

    public abstract void a0(int i10, int i11);

    public abstract void b0(boolean z10);

    public abstract void c0(boolean z10);

    public abstract void d0(boolean z10);

    public abstract void e0(boolean z10);

    public void f0(float f10) {
        if (f10 != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public abstract void g(d dVar);

    public void g0(int i10) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }

    @Deprecated
    public abstract void h(f fVar);

    public void h0(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    @Deprecated
    public abstract void i(f fVar, int i10);

    public void i0(@c1 int i10) {
    }

    @Deprecated
    public abstract void j(f fVar, int i10, boolean z10);

    public void j0(@p0 CharSequence charSequence) {
    }

    @Deprecated
    public abstract void k(f fVar, boolean z10);

    public void k0(@v int i10) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean l() {
        return false;
    }

    public void l0(@p0 Drawable drawable) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean m() {
        return false;
    }

    public void m0(boolean z10) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void n(boolean z10) {
    }

    public abstract void n0(@v int i10);

    public abstract View o();

    public abstract void o0(Drawable drawable);

    public abstract int p();

    @Deprecated
    public abstract void p0(SpinnerAdapter spinnerAdapter, e eVar);

    public float q() {
        return 0.0f;
    }

    public abstract void q0(@v int i10);

    public abstract int r();

    public abstract void r0(Drawable drawable);

    public int s() {
        return 0;
    }

    @Deprecated
    public abstract void s0(int i10);

    @Deprecated
    public abstract int t();

    @Deprecated
    public abstract void t0(int i10);

    @Deprecated
    public abstract int u();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void u0(boolean z10) {
    }

    @Deprecated
    public abstract int v();

    public void v0(Drawable drawable) {
    }

    @p0
    @Deprecated
    public abstract f w();

    public void w0(Drawable drawable) {
    }

    @p0
    public abstract CharSequence x();

    public abstract void x0(int i10);

    @Deprecated
    public abstract f y(int i10);

    public abstract void y0(CharSequence charSequence);

    @Deprecated
    public abstract int z();

    public abstract void z0(@c1 int i10);

    public static class b extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1604a;

        public b(@n0 Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1604a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f1604a = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f1604a = 8388627;
        }

        public b(int i10, int i11, int i12) {
            super(i10, i11);
            this.f1604a = i12;
        }

        public b(int i10) {
            this(-2, -1, i10);
        }

        public b(b bVar) {
            super((ViewGroup.MarginLayoutParams) bVar);
            this.f1604a = 0;
            this.f1604a = bVar.f1604a;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1604a = 0;
        }
    }
}
