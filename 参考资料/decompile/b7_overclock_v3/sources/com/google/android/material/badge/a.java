package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.q;
import com.google.android.material.internal.t;
import g.c1;
import g.d1;
import g.f;
import g.k1;
import g.l;
import g.n0;
import g.p0;
import g.s0;
import g.t0;
import ie.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;
import le.j;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Drawable implements q.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f19583n = 8388661;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f19584o = 8388659;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f19585p = 8388693;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f19586q = 8388691;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f19587r = 9;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @d1
    public static final int f19588s = R.style.Widget_MaterialComponents_Badge;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @f
    public static final int f19589t = R.attr.badgeStyle;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f19590u = "+";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final WeakReference<Context> f19591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final j f19592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final q f19593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Rect f19594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final BadgeState f19595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f19596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f19597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f19599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f19600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f19601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public WeakReference<View> f19602l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public WeakReference<FrameLayout> f19603m;

    /* JADX INFO: renamed from: com.google.android.material.badge.a$a, reason: collision with other inner class name */
    public class RunnableC0200a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f19604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f19605b;

        public RunnableC0200a(View view, FrameLayout frameLayout) {
            this.f19604a = view;
            this.f19605b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i0(this.f19604a, this.f19605b);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public a(@n0 Context context, @k1 int i10, @f int i11, @d1 int i12, @p0 BadgeState.State state) {
        this.f19591a = new WeakReference<>(context);
        t.c(context);
        this.f19594d = new Rect();
        this.f19592b = new j();
        q qVar = new q(this);
        this.f19593c = qVar;
        qVar.e().setTextAlign(Paint.Align.CENTER);
        Z(R.style.TextAppearance_MaterialComponents_Badge);
        this.f19595e = new BadgeState(context, i10, i11, i12, state);
        J();
    }

    @n0
    public static a d(@n0 Context context) {
        return new a(context, 0, f19589t, f19588s, null);
    }

    @n0
    public static a e(@n0 Context context, @k1 int i10) {
        return new a(context, i10, f19589t, f19588s, null);
    }

    @n0
    public static a f(@n0 Context context, @n0 BadgeState.State state) {
        return new a(context, 0, f19589t, f19588s, state);
    }

    public static void f0(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    @t0
    public int A() {
        return this.f19595e.s();
    }

    public boolean B() {
        return this.f19595e.t();
    }

    public final void C() {
        this.f19593c.e().setAlpha(getAlpha());
        invalidateSelf();
    }

    public final void D() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.f19595e.f());
        if (this.f19592b.y() != colorStateListValueOf) {
            this.f19592b.o0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public final void E() {
        WeakReference<View> weakReference = this.f19602l;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.f19602l.get();
        WeakReference<FrameLayout> weakReference2 = this.f19603m;
        i0(view, weakReference2 != null ? weakReference2.get() : null);
    }

    public final void F() {
        this.f19593c.e().setColor(this.f19595e.h());
        invalidateSelf();
    }

    public final void G() {
        k0();
        this.f19593c.j(true);
        j0();
        invalidateSelf();
    }

    public final void H() {
        this.f19593c.j(true);
        j0();
        invalidateSelf();
    }

    public final void I() {
        boolean zU = this.f19595e.u();
        setVisible(zU, false);
        if (!com.google.android.material.badge.b.f19607a || p() == null || zU) {
            return;
        }
        ((ViewGroup) p().getParent()).invalidate();
    }

    public final void J() {
        G();
        H();
        C();
        D();
        F();
        E();
        j0();
        I();
    }

    public void K(int i10) {
        this.f19595e.w(i10);
        j0();
    }

    public void L(@t0 int i10) {
        this.f19595e.x(i10);
        j0();
    }

    public void M(@l int i10) {
        this.f19595e.z(i10);
        D();
    }

    public void N(int i10) {
        if (this.f19595e.g() != i10) {
            this.f19595e.A(i10);
            E();
        }
    }

    public void O(@n0 Locale locale) {
        if (locale.equals(this.f19595e.p())) {
            return;
        }
        this.f19595e.J(locale);
        invalidateSelf();
    }

    public void P(@l int i10) {
        if (this.f19593c.e().getColor() != i10) {
            this.f19595e.B(i10);
            F();
        }
    }

    public void Q(@c1 int i10) {
        this.f19595e.C(i10);
    }

    public void R(CharSequence charSequence) {
        this.f19595e.D(charSequence);
    }

    public void S(@s0 int i10) {
        this.f19595e.E(i10);
    }

    public void T(int i10) {
        V(i10);
        U(i10);
    }

    public void U(@t0 int i10) {
        this.f19595e.F(i10);
        j0();
    }

    public void V(@t0 int i10) {
        this.f19595e.G(i10);
        j0();
    }

    public void W(int i10) {
        if (this.f19595e.n() != i10) {
            this.f19595e.H(i10);
            G();
        }
    }

    public void X(int i10) {
        int iMax = Math.max(0, i10);
        if (this.f19595e.o() != iMax) {
            this.f19595e.I(iMax);
            H();
        }
    }

    public final void Y(@p0 d dVar) {
        Context context;
        if (this.f19593c.d() == dVar || (context = this.f19591a.get()) == null) {
            return;
        }
        this.f19593c.i(dVar, context);
        j0();
    }

    public final void Z(@d1 int i10) {
        Context context = this.f19591a.get();
        if (context == null) {
            return;
        }
        Y(new d(context, i10));
    }

    @Override // com.google.android.material.internal.q.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    public void a0(int i10) {
        c0(i10);
        b0(i10);
    }

    public final void b(@n0 Context context, @n0 Rect rect, @n0 View view) {
        int iX = x();
        int iG = this.f19595e.g();
        if (iG == 8388691 || iG == 8388693) {
            this.f19597g = rect.bottom - iX;
        } else {
            this.f19597g = rect.top + iX;
        }
        if (u() <= 9) {
            float f10 = !B() ? this.f19595e.f19560c : this.f19595e.f19561d;
            this.f19599i = f10;
            this.f19601k = f10;
            this.f19600j = f10;
        } else {
            float f11 = this.f19595e.f19561d;
            this.f19599i = f11;
            this.f19601k = f11;
            this.f19600j = (this.f19593c.f(m()) / 2.0f) + this.f19595e.f19562e;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(B() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int iW = w();
        int iG2 = this.f19595e.g();
        if (iG2 == 8388659 || iG2 == 8388691) {
            this.f19596f = u0.Z(view) == 0 ? (rect.left - this.f19600j) + dimensionPixelSize + iW : ((rect.right + this.f19600j) - dimensionPixelSize) - iW;
        } else {
            this.f19596f = u0.Z(view) == 0 ? ((rect.right + this.f19600j) - dimensionPixelSize) - iW : (rect.left - this.f19600j) + dimensionPixelSize + iW;
        }
    }

    public void b0(@t0 int i10) {
        this.f19595e.K(i10);
        j0();
    }

    public void c() {
        if (B()) {
            this.f19595e.a();
            H();
        }
    }

    public void c0(@t0 int i10) {
        this.f19595e.L(i10);
        j0();
    }

    public void d0(boolean z10) {
        this.f19595e.M(z10);
        I();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f19592b.draw(canvas);
        if (B()) {
            g(canvas);
        }
    }

    public final void e0(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f19603m;
            if (weakReference == null || weakReference.get() != viewGroup) {
                f0(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int iIndexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(iIndexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, iIndexOfChild);
                this.f19603m = new WeakReference<>(frameLayout);
                frameLayout.post(new RunnableC0200a(view, frameLayout));
            }
        }
    }

    public final void g(Canvas canvas) {
        Rect rect = new Rect();
        String strM = m();
        this.f19593c.e().getTextBounds(strM, 0, strM.length(), rect);
        canvas.drawText(strM, this.f19596f, this.f19597g + (rect.height() / 2), this.f19593c.e());
    }

    public void g0(@n0 View view) {
        i0(view, null);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f19595e.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f19594d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f19594d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f19595e.c();
    }

    @Deprecated
    public void h0(@n0 View view, @p0 ViewGroup viewGroup) {
        if (!(viewGroup instanceof FrameLayout)) {
            throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
        }
        i0(view, (FrameLayout) viewGroup);
    }

    @t0
    public int i() {
        return this.f19595e.d();
    }

    public void i0(@n0 View view, @p0 FrameLayout frameLayout) {
        this.f19602l = new WeakReference<>(view);
        boolean z10 = com.google.android.material.badge.b.f19607a;
        if (z10 && frameLayout == null) {
            e0(view);
        } else {
            this.f19603m = new WeakReference<>(frameLayout);
        }
        if (!z10) {
            f0(view);
        }
        j0();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @l
    public int j() {
        return this.f19592b.y().getDefaultColor();
    }

    public final void j0() {
        Context context = this.f19591a.get();
        WeakReference<View> weakReference = this.f19602l;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f19594d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.f19603m;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || com.google.android.material.badge.b.f19607a) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        b(context, rect2, view);
        com.google.android.material.badge.b.o(this.f19594d, this.f19596f, this.f19597g, this.f19600j, this.f19601k);
        this.f19592b.k0(this.f19599i);
        if (rect.equals(this.f19594d)) {
            return;
        }
        this.f19592b.setBounds(this.f19594d);
    }

    public int k() {
        return this.f19595e.g();
    }

    public final void k0() {
        this.f19598h = ((int) Math.pow(10.0d, ((double) t()) - 1.0d)) - 1;
    }

    @n0
    public Locale l() {
        return this.f19595e.p();
    }

    @n0
    public final String m() {
        if (u() <= this.f19598h) {
            return NumberFormat.getInstance(this.f19595e.p()).format(u());
        }
        Context context = this.f19591a.get();
        return context == null ? "" : String.format(this.f19595e.p(), context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f19598h), f19590u);
    }

    @l
    public int n() {
        return this.f19593c.e().getColor();
    }

    @p0
    public CharSequence o() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!B()) {
            return this.f19595e.j();
        }
        if (this.f19595e.k() == 0 || (context = this.f19591a.get()) == null) {
            return null;
        }
        return u() <= this.f19598h ? context.getResources().getQuantityString(this.f19595e.k(), u(), Integer.valueOf(u())) : context.getString(this.f19595e.i(), Integer.valueOf(this.f19598h));
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.q.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @p0
    public FrameLayout p() {
        WeakReference<FrameLayout> weakReference = this.f19603m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int q() {
        return this.f19595e.m();
    }

    @t0
    public int r() {
        return this.f19595e.l();
    }

    @t0
    public int s() {
        return this.f19595e.m();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f19595e.y(i10);
        C();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int t() {
        return this.f19595e.n();
    }

    public int u() {
        if (B()) {
            return this.f19595e.o();
        }
        return 0;
    }

    @n0
    public BadgeState.State v() {
        return this.f19595e.q();
    }

    public final int w() {
        return (B() ? this.f19595e.l() : this.f19595e.m()) + this.f19595e.c();
    }

    public final int x() {
        return (B() ? this.f19595e.r() : this.f19595e.s()) + this.f19595e.d();
    }

    public int y() {
        return this.f19595e.s();
    }

    @t0
    public int z() {
        return this.f19595e.r();
    }
}
