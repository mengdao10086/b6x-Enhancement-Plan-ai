package com.google.android.material.tabs;

import a1.d;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.b1;
import androidx.core.util.n;
import androidx.core.view.o0;
import androidx.core.view.u0;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import g.c1;
import g.i0;
import g.n0;
import g.p0;
import g.r;
import g.v;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@ViewPager.e
public class TabLayout extends HorizontalScrollView {

    @r(unit = 0)
    public static final int J7 = 72;

    @r(unit = 0)
    public static final int K7 = 8;

    @r(unit = 0)
    public static final int L7 = 48;

    @r(unit = 0)
    public static final int M7 = 56;

    @r(unit = 0)
    public static final int N7 = 16;
    public static final int O7 = -1;
    public static final int P7 = 300;
    public static final int Q7 = -1;
    public static final String S7 = "TabLayout";
    public static final int T7 = 0;
    public static final int U7 = 1;
    public static final int V7 = 2;
    public static final int W7 = 0;
    public static final int X7 = 1;
    public static final int Y7 = 0;
    public static final int Z7 = 1;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final int f20770a8 = 2;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final int f20771b8 = 0;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public static final int f20772c8 = 1;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final int f20773d8 = 2;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final int f20774e8 = 3;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final int f20775f8 = 0;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final int f20776g8 = 1;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final int f20777h8 = 2;
    public boolean A;
    public boolean B;
    public int C;

    @p0
    public c C1;

    @p0
    public k2.a C2;
    public int D;
    public m E7;
    public b F7;
    public boolean G7;
    public final n.a<n> H7;
    public com.google.android.material.tabs.a K0;
    public ValueAnimator K1;
    public DataSetObserver K2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<i> f20778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public i f20779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final h f20780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f20786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f20787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f20788k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f20789k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    @p0
    public c f20790k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public Drawable f20791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f20792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PorterDuff.Mode f20793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f20794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f20795p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f20796q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20797r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f20798s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f20799t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f20800u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f20801v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final ArrayList<c> f20802v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    @p0
    public ViewPager f20803v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f20804w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f20805x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f20806y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20807z;
    public static final int I7 = R.style.Widget_Design_TabLayout;
    public static final n.a<i> R7 = new n.c(16);

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20809a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(@n0 ViewPager viewPager, @p0 k2.a aVar, @p0 k2.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f20803v2 == viewPager) {
                tabLayout.O(aVar2, this.f20809a);
            }
        }

        public void b(boolean z10) {
            this.f20809a = z10;
        }
    }

    @Deprecated
    public interface c<T extends i> {
        void a(T t10);

        void b(T t10);

        void c(T t10);
    }

    public @interface d {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface e {
    }

    public interface f extends c<i> {
    }

    public class g extends DataSetObserver {
        public g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.E();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.E();
        }
    }

    public class h extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueAnimator f20812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20813b;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f20815a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f20816b;

            public a(View view, View view2) {
                this.f20815a = view;
                this.f20816b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
                h.this.h(this.f20815a, this.f20816b, valueAnimator.getAnimatedFraction());
            }
        }

        public h(Context context) {
            super(context);
            this.f20813b = -1;
            setWillNotDraw(false);
        }

        public void c(int i10, int i11) {
            ValueAnimator valueAnimator = this.f20812a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f20812a.cancel();
            }
            i(true, i10, i11);
        }

        public boolean d() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(@n0 Canvas canvas) {
            int iHeight = TabLayout.this.f20791l.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.f20791l.getIntrinsicHeight();
            }
            int i10 = TabLayout.this.f20806y;
            int height = 0;
            if (i10 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i10 == 1) {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            } else if (i10 != 2) {
                iHeight = i10 != 3 ? 0 : getHeight();
            }
            if (TabLayout.this.f20791l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f20791l.getBounds();
                TabLayout.this.f20791l.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout.this.f20791l.draw(canvas);
            }
            super.draw(canvas);
        }

        public final void e() {
            View childAt = getChildAt(TabLayout.this.getSelectedTabPosition());
            com.google.android.material.tabs.a aVar = TabLayout.this.K0;
            TabLayout tabLayout = TabLayout.this;
            aVar.c(tabLayout, childAt, tabLayout.f20791l);
        }

        public void f(int i10, float f10) {
            ValueAnimator valueAnimator = this.f20812a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f20812a.cancel();
            }
            h(getChildAt(i10), getChildAt(i10 + 1), f10);
        }

        public void g(int i10) {
            Rect bounds = TabLayout.this.f20791l.getBounds();
            TabLayout.this.f20791l.setBounds(bounds.left, 0, bounds.right, i10);
            requestLayout();
        }

        public final void h(View view, View view2, float f10) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.a aVar = TabLayout.this.K0;
                TabLayout tabLayout = TabLayout.this;
                aVar.d(tabLayout, view, view2, f10, tabLayout.f20791l);
            } else {
                Drawable drawable = TabLayout.this.f20791l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f20791l.getBounds().bottom);
            }
            u0.n1(this);
        }

        public final void i(boolean z10, int i10, int i11) {
            View childAt = getChildAt(TabLayout.this.getSelectedTabPosition());
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                e();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (!z10) {
                this.f20812a.removeAllUpdateListeners();
                this.f20812a.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f20812a = valueAnimator;
            valueAnimator.setInterpolator(kd.a.f37167b);
            valueAnimator.setDuration(i11);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.start();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f20812a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                i(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z10 = true;
            if (tabLayout.f20804w == 1 || tabLayout.f20807z == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) b0.e(getContext(), 16)) * 2)) {
                    boolean z11 = false;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i13).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z11 = true;
                        }
                    }
                    z10 = z11;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.f20804w = 0;
                    tabLayout2.W(false);
                }
                if (z10) {
                    super.onMeasure(i10, i11);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
            if (Build.VERSION.SDK_INT >= 23 || this.f20813b == i10) {
                return;
            }
            requestLayout();
            this.f20813b = i10;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f20818k = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public Object f20819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public Drawable f20820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public CharSequence f20821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public CharSequence f20822d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public View f20824f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public TabLayout f20826h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @n0
        public n f20827i;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20823e = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @d
        public int f20825g = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20828j = -1;

        @n0
        public i A(@d int i10) {
            this.f20825g = i10;
            TabLayout tabLayout = this.f20826h;
            if (tabLayout.f20804w == 1 || tabLayout.f20807z == 2) {
                tabLayout.W(true);
            }
            E();
            if (com.google.android.material.badge.b.f19607a && this.f20827i.o() && this.f20827i.f20836e.isVisible()) {
                this.f20827i.invalidate();
            }
            return this;
        }

        @n0
        public i B(@p0 Object obj) {
            this.f20819a = obj;
            return this;
        }

        @n0
        public i C(@c1 int i10) {
            TabLayout tabLayout = this.f20826h;
            if (tabLayout != null) {
                return D(tabLayout.getResources().getText(i10));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @n0
        public i D(@p0 CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f20822d) && !TextUtils.isEmpty(charSequence)) {
                this.f20827i.setContentDescription(charSequence);
            }
            this.f20821c = charSequence;
            E();
            return this;
        }

        public void E() {
            n nVar = this.f20827i;
            if (nVar != null) {
                nVar.x();
            }
        }

        @p0
        public com.google.android.material.badge.a e() {
            return this.f20827i.getBadge();
        }

        @p0
        public CharSequence f() {
            n nVar = this.f20827i;
            if (nVar == null) {
                return null;
            }
            return nVar.getContentDescription();
        }

        @p0
        public View g() {
            return this.f20824f;
        }

        @p0
        public Drawable h() {
            return this.f20820b;
        }

        public int i() {
            return this.f20828j;
        }

        @n0
        public com.google.android.material.badge.a j() {
            return this.f20827i.getOrCreateBadge();
        }

        public int k() {
            return this.f20823e;
        }

        @d
        public int l() {
            return this.f20825g;
        }

        @p0
        public Object m() {
            return this.f20819a;
        }

        @p0
        public CharSequence n() {
            return this.f20821c;
        }

        public boolean o() {
            TabLayout tabLayout = this.f20826h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.f20823e;
        }

        public void p() {
            this.f20827i.r();
        }

        public void q() {
            this.f20826h = null;
            this.f20827i = null;
            this.f20819a = null;
            this.f20820b = null;
            this.f20828j = -1;
            this.f20821c = null;
            this.f20822d = null;
            this.f20823e = -1;
            this.f20824f = null;
        }

        public void r() {
            TabLayout tabLayout = this.f20826h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.M(this);
        }

        @n0
        public i s(@c1 int i10) {
            TabLayout tabLayout = this.f20826h;
            if (tabLayout != null) {
                return t(tabLayout.getResources().getText(i10));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @n0
        public i t(@p0 CharSequence charSequence) {
            this.f20822d = charSequence;
            E();
            return this;
        }

        @n0
        public i u(@i0 int i10) {
            return v(LayoutInflater.from(this.f20827i.getContext()).inflate(i10, (ViewGroup) this.f20827i, false));
        }

        @n0
        public i v(@p0 View view) {
            this.f20824f = view;
            E();
            return this;
        }

        @n0
        public i w(@v int i10) {
            TabLayout tabLayout = this.f20826h;
            if (tabLayout != null) {
                return x(i.a.b(tabLayout.getContext(), i10));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @n0
        public i x(@p0 Drawable drawable) {
            this.f20820b = drawable;
            TabLayout tabLayout = this.f20826h;
            if (tabLayout.f20804w == 1 || tabLayout.f20807z == 2) {
                tabLayout.W(true);
            }
            E();
            if (com.google.android.material.badge.b.f19607a && this.f20827i.o() && this.f20827i.f20836e.isVisible()) {
                this.f20827i.invalidate();
            }
            return this;
        }

        @n0
        public i y(int i10) {
            this.f20828j = i10;
            n nVar = this.f20827i;
            if (nVar != null) {
                nVar.setId(i10);
            }
            return this;
        }

        public void z(int i10) {
            this.f20823e = i10;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface j {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface k {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface l {
    }

    public static class m implements ViewPager.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final WeakReference<TabLayout> f20829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20831c;

        public m(TabLayout tabLayout) {
            this.f20829a = new WeakReference<>(tabLayout);
        }

        public void a() {
            this.f20831c = 0;
            this.f20830b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            this.f20830b = this.f20831c;
            this.f20831c = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            TabLayout tabLayout = this.f20829a.get();
            if (tabLayout != null) {
                int i12 = this.f20831c;
                tabLayout.Q(i10, f10, i12 != 2 || this.f20830b == 1, (i12 == 2 && this.f20830b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            TabLayout tabLayout = this.f20829a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i10 || i10 >= tabLayout.getTabCount()) {
                return;
            }
            int i11 = this.f20831c;
            tabLayout.N(tabLayout.y(i10), i11 == 0 || (i11 == 2 && this.f20830b == 0));
        }
    }

    public final class n extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f20832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f20833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f20834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public View f20835d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public com.google.android.material.badge.a f20836e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public View f20837f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public TextView f20838g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public ImageView f20839h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @p0
        public Drawable f20840i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20841j;

        public class a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f20843a;

            public a(View view) {
                this.f20843a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (this.f20843a.getVisibility() == 0) {
                    n.this.w(this.f20843a);
                }
            }
        }

        public n(@n0 Context context) {
            super(context);
            this.f20841j = 2;
            y(context);
            u0.d2(this, TabLayout.this.f20781d, TabLayout.this.f20782e, TabLayout.this.f20783f, TabLayout.this.f20784g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            u0.g2(this, o0.c(getContext(), 1002));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @p0
        public com.google.android.material.badge.a getBadge() {
            return this.f20836e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @n0
        public com.google.android.material.badge.a getOrCreateBadge() {
            if (this.f20836e == null) {
                this.f20836e = com.google.android.material.badge.a.d(getContext());
            }
            v();
            com.google.android.material.badge.a aVar = this.f20836e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void A(@p0 TextView textView, @p0 ImageView imageView) {
            i iVar = this.f20832a;
            Drawable drawableMutate = (iVar == null || iVar.h() == null) ? null : n0.c.r(this.f20832a.h()).mutate();
            if (drawableMutate != null) {
                n0.c.o(drawableMutate, TabLayout.this.f20787j);
                PorterDuff.Mode mode = TabLayout.this.f20793n;
                if (mode != null) {
                    n0.c.p(drawableMutate, mode);
                }
            }
            i iVar2 = this.f20832a;
            CharSequence charSequenceN = iVar2 != null ? iVar2.n() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(charSequenceN);
            if (textView != null) {
                if (z10) {
                    textView.setText(charSequenceN);
                    if (this.f20832a.f20825g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iE = (z10 && imageView.getVisibility() == 0) ? (int) b0.e(getContext(), 8) : 0;
                if (TabLayout.this.A) {
                    if (iE != androidx.core.view.r.b(marginLayoutParams)) {
                        androidx.core.view.r.g(marginLayoutParams, iE);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iE != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iE;
                    androidx.core.view.r.g(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            i iVar3 = this.f20832a;
            CharSequence charSequence = iVar3 != null ? iVar3.f20822d : null;
            if (Build.VERSION.SDK_INT > 23) {
                if (!z10) {
                    charSequenceN = charSequence;
                }
                b1.a(this, charSequenceN);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f20840i;
            boolean state = false;
            if (drawable != null && drawable.isStateful()) {
                state = false | this.f20840i.setState(drawableState);
            }
            if (state) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.f20833b, this.f20834c, this.f20837f};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z10 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f20833b, this.f20834c, this.f20837f};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z10 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        @p0
        public i getTab() {
            return this.f20832a;
        }

        public final void i(@p0 View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        public final float j(@n0 Layout layout, int i10, float f10) {
            return layout.getLineWidth(i10) * (f10 / layout.getPaint().getTextSize());
        }

        public final void k(boolean z10) {
            setClipChildren(z10);
            setClipToPadding(z10);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z10);
                viewGroup.setClipToPadding(z10);
            }
        }

        @n0
        public final FrameLayout l() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        public final void m(@n0 Canvas canvas) {
            Drawable drawable = this.f20840i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f20840i.draw(canvas);
            }
        }

        @p0
        public final FrameLayout n(@n0 View view) {
            if ((view == this.f20834c || view == this.f20833b) && com.google.android.material.badge.b.f19607a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        public final boolean o() {
            return this.f20836e != null;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            com.google.android.material.badge.a aVar = this.f20836e;
            if (aVar != null && aVar.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f20836e.o()));
            }
            a1.d dVarG2 = a1.d.g2(accessibilityNodeInfo);
            dVarG2.e1(d.e.h(0, 1, this.f20832a.k(), 1, false, isSelected()));
            if (isSelected()) {
                dVarG2.c1(false);
                dVarG2.P0(d.a.f110j);
            }
            dVarG2.K1(getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i10 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f20797r, Integer.MIN_VALUE);
            }
            super.onMeasure(i10, i11);
            if (this.f20833b != null) {
                float f10 = TabLayout.this.f20794o;
                int i12 = this.f20841j;
                ImageView imageView = this.f20834c;
                boolean z10 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f20833b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f10 = TabLayout.this.f20795p;
                    }
                } else {
                    i12 = 1;
                }
                float textSize = this.f20833b.getTextSize();
                int lineCount = this.f20833b.getLineCount();
                int iK = androidx.core.widget.r.k(this.f20833b);
                if (f10 != textSize || (iK >= 0 && i12 != iK)) {
                    if (TabLayout.this.f20807z == 1 && f10 > textSize && lineCount == 1 && ((layout = this.f20833b.getLayout()) == null || j(layout, 0, f10) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z10 = false;
                    }
                    if (z10) {
                        this.f20833b.setTextSize(0, f10);
                        this.f20833b.setMaxLines(i12);
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }

        public final void p() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.b.f19607a) {
                FrameLayout frameLayoutL = l();
                addView(frameLayoutL, 0);
                viewGroup = frameLayoutL;
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, viewGroup, false);
            this.f20834c = imageView;
            viewGroup.addView(imageView, 0);
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f20832a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f20832a.r();
            return true;
        }

        public final void q() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.b.f19607a) {
                FrameLayout frameLayoutL = l();
                addView(frameLayoutL);
                viewGroup = frameLayoutL;
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, viewGroup, false);
            this.f20833b = textView;
            viewGroup.addView(textView);
        }

        public final void r() {
            if (this.f20835d != null) {
                u();
            }
            this.f20836e = null;
        }

        public void s() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            if (isSelected() != z10) {
            }
            super.setSelected(z10);
            TextView textView = this.f20833b;
            if (textView != null) {
                textView.setSelected(z10);
            }
            ImageView imageView = this.f20834c;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f20837f;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        public void setTab(@p0 i iVar) {
            if (iVar != this.f20832a) {
                this.f20832a = iVar;
                x();
            }
        }

        public final void t(@p0 View view) {
            if (o() && view != null) {
                k(false);
                com.google.android.material.badge.b.d(this.f20836e, view, n(view));
                this.f20835d = view;
            }
        }

        public final void u() {
            if (o()) {
                k(true);
                View view = this.f20835d;
                if (view != null) {
                    com.google.android.material.badge.b.j(this.f20836e, view);
                    this.f20835d = null;
                }
            }
        }

        public final void v() {
            i iVar;
            i iVar2;
            if (o()) {
                if (this.f20837f != null) {
                    u();
                    return;
                }
                if (this.f20834c != null && (iVar2 = this.f20832a) != null && iVar2.h() != null) {
                    View view = this.f20835d;
                    ImageView imageView = this.f20834c;
                    if (view == imageView) {
                        w(imageView);
                        return;
                    } else {
                        u();
                        t(this.f20834c);
                        return;
                    }
                }
                if (this.f20833b == null || (iVar = this.f20832a) == null || iVar.l() != 1) {
                    u();
                    return;
                }
                View view2 = this.f20835d;
                TextView textView = this.f20833b;
                if (view2 == textView) {
                    w(textView);
                } else {
                    u();
                    t(this.f20833b);
                }
            }
        }

        public final void w(@n0 View view) {
            if (o() && view == this.f20835d) {
                com.google.android.material.badge.b.m(this.f20836e, view, n(view));
            }
        }

        public final void x() {
            i iVar = this.f20832a;
            View viewG = iVar != null ? iVar.g() : null;
            if (viewG != null) {
                ViewParent parent = viewG.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewG);
                    }
                    addView(viewG);
                }
                this.f20837f = viewG;
                TextView textView = this.f20833b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f20834c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f20834c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewG.findViewById(android.R.id.text1);
                this.f20838g = textView2;
                if (textView2 != null) {
                    this.f20841j = androidx.core.widget.r.k(textView2);
                }
                this.f20839h = (ImageView) viewG.findViewById(android.R.id.icon);
            } else {
                View view = this.f20837f;
                if (view != null) {
                    removeView(view);
                    this.f20837f = null;
                }
                this.f20838g = null;
                this.f20839h = null;
            }
            if (this.f20837f == null) {
                if (this.f20834c == null) {
                    p();
                }
                if (this.f20833b == null) {
                    q();
                    this.f20841j = androidx.core.widget.r.k(this.f20833b);
                }
                androidx.core.widget.r.E(this.f20833b, TabLayout.this.f20785h);
                ColorStateList colorStateList = TabLayout.this.f20786i;
                if (colorStateList != null) {
                    this.f20833b.setTextColor(colorStateList);
                }
                A(this.f20833b, this.f20834c);
                v();
                i(this.f20834c);
                i(this.f20833b);
            } else {
                TextView textView3 = this.f20838g;
                if (textView3 != null || this.f20839h != null) {
                    A(textView3, this.f20839h);
                }
            }
            if (iVar != null && !TextUtils.isEmpty(iVar.f20822d)) {
                setContentDescription(iVar.f20822d);
            }
            setSelected(iVar != null && iVar.o());
        }

        public final void y(Context context) {
            int i10 = TabLayout.this.f20796q;
            if (i10 != 0) {
                Drawable drawableB = i.a.b(context, i10);
                this.f20840i = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.f20840i.setState(getDrawableState());
                }
            } else {
                this.f20840i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            Drawable rippleDrawable = gradientDrawable;
            if (TabLayout.this.f20788k != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = je.b.a(TabLayout.this.f20788k);
                boolean z10 = TabLayout.this.f20789k0;
                GradientDrawable gradientDrawable3 = gradientDrawable;
                if (z10) {
                    gradientDrawable3 = null;
                }
                rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, z10 ? null : gradientDrawable2);
            }
            u0.I1(this, rippleDrawable);
            TabLayout.this.invalidate();
        }

        public final void z() {
            setOrientation(!TabLayout.this.A ? 1 : 0);
            TextView textView = this.f20838g;
            if (textView == null && this.f20839h == null) {
                A(this.f20833b, this.f20834c);
            } else {
                A(textView, this.f20839h);
            }
        }
    }

    public static class o implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f20845a;

        public o(ViewPager viewPager) {
            this.f20845a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(i iVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(@n0 i iVar) {
            this.f20845a.setCurrentItem(iVar.k());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(i iVar) {
        }
    }

    public TabLayout(@n0 Context context) {
        this(context, null);
    }

    @r(unit = 0)
    private int getDefaultHeight() {
        int size = this.f20778a.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                i iVar = this.f20778a.get(i10);
                if (iVar != null && iVar.h() != null && !TextUtils.isEmpty(iVar.n())) {
                    z10 = true;
                    break;
                }
                i10++;
            } else {
                break;
            }
        }
        return (!z10 || this.A) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i10 = this.f20798s;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.f20807z;
        if (i11 == 0 || i11 == 2) {
            return this.f20800u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f20780c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    @n0
    public static ColorStateList q(int i10, int i11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    private void setSelectedTabView(int i10) {
        int childCount = this.f20780c.getChildCount();
        if (i10 < childCount) {
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = this.f20780c.getChildAt(i11);
                boolean z10 = true;
                childAt.setSelected(i11 == i10);
                if (i11 != i10) {
                    z10 = false;
                }
                childAt.setActivated(z10);
                i11++;
            }
        }
    }

    public boolean A() {
        return this.A;
    }

    public final boolean B() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    public boolean C() {
        return this.B;
    }

    @n0
    public i D() {
        i iVarS = s();
        iVarS.f20826h = this;
        iVarS.f20827i = t(iVarS);
        if (iVarS.f20828j != -1) {
            iVarS.f20827i.setId(iVarS.f20828j);
        }
        return iVarS;
    }

    public void E() {
        int currentItem;
        G();
        k2.a aVar = this.C2;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                g(D().D(this.C2.getPageTitle(i10)), false);
            }
            ViewPager viewPager = this.f20803v2;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            M(y(currentItem));
        }
    }

    public boolean F(i iVar) {
        return R7.b(iVar);
    }

    public void G() {
        for (int childCount = this.f20780c.getChildCount() - 1; childCount >= 0; childCount--) {
            L(childCount);
        }
        Iterator<i> it2 = this.f20778a.iterator();
        while (it2.hasNext()) {
            i next = it2.next();
            it2.remove();
            next.q();
            F(next);
        }
        this.f20779b = null;
    }

    @Deprecated
    public void H(@p0 c cVar) {
        this.f20802v1.remove(cVar);
    }

    public void I(@n0 f fVar) {
        H(fVar);
    }

    public void J(@n0 i iVar) {
        if (iVar.f20826h != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        K(iVar.k());
    }

    public void K(int i10) {
        i iVar = this.f20779b;
        int iK = iVar != null ? iVar.k() : 0;
        L(i10);
        i iVarRemove = this.f20778a.remove(i10);
        if (iVarRemove != null) {
            iVarRemove.q();
            F(iVarRemove);
        }
        int size = this.f20778a.size();
        for (int i11 = i10; i11 < size; i11++) {
            this.f20778a.get(i11).z(i11);
        }
        if (iK == i10) {
            M(this.f20778a.isEmpty() ? null : this.f20778a.get(Math.max(0, i10 - 1)));
        }
    }

    public final void L(int i10) {
        n nVar = (n) this.f20780c.getChildAt(i10);
        this.f20780c.removeViewAt(i10);
        if (nVar != null) {
            nVar.s();
            this.H7.b(nVar);
        }
        requestLayout();
    }

    public void M(@p0 i iVar) {
        N(iVar, true);
    }

    public void N(@p0 i iVar, boolean z10) {
        i iVar2 = this.f20779b;
        if (iVar2 == iVar) {
            if (iVar2 != null) {
                u(iVar);
                k(iVar.k());
                return;
            }
            return;
        }
        int iK = iVar != null ? iVar.k() : -1;
        if (z10) {
            if ((iVar2 == null || iVar2.k() == -1) && iK != -1) {
                P(iK, 0.0f, true);
            } else {
                k(iK);
            }
            if (iK != -1) {
                setSelectedTabView(iK);
            }
        }
        this.f20779b = iVar;
        if (iVar2 != null) {
            w(iVar2);
        }
        if (iVar != null) {
            v(iVar);
        }
    }

    public void O(@p0 k2.a aVar, boolean z10) {
        DataSetObserver dataSetObserver;
        k2.a aVar2 = this.C2;
        if (aVar2 != null && (dataSetObserver = this.K2) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.C2 = aVar;
        if (z10 && aVar != null) {
            if (this.K2 == null) {
                this.K2 = new g();
            }
            aVar.registerDataSetObserver(this.K2);
        }
        E();
    }

    public void P(int i10, float f10, boolean z10) {
        Q(i10, f10, z10, true);
    }

    public void Q(int i10, float f10, boolean z10, boolean z11) {
        int iRound = Math.round(i10 + f10);
        if (iRound < 0 || iRound >= this.f20780c.getChildCount()) {
            return;
        }
        if (z11) {
            this.f20780c.f(i10, f10);
        }
        ValueAnimator valueAnimator = this.K1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K1.cancel();
        }
        scrollTo(i10 < 0 ? 0 : n(i10, f10), 0);
        if (z10) {
            setSelectedTabView(iRound);
        }
    }

    public void R(int i10, int i11) {
        setTabTextColors(q(i10, i11));
    }

    public void S(@p0 ViewPager viewPager, boolean z10) {
        T(viewPager, z10, false);
    }

    public final void T(@p0 ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.f20803v2;
        if (viewPager2 != null) {
            m mVar = this.E7;
            if (mVar != null) {
                viewPager2.Q(mVar);
            }
            b bVar = this.F7;
            if (bVar != null) {
                this.f20803v2.P(bVar);
            }
        }
        c cVar = this.C1;
        if (cVar != null) {
            H(cVar);
            this.C1 = null;
        }
        if (viewPager != null) {
            this.f20803v2 = viewPager;
            if (this.E7 == null) {
                this.E7 = new m(this);
            }
            this.E7.a();
            viewPager.e(this.E7);
            o oVar = new o(viewPager);
            this.C1 = oVar;
            b(oVar);
            k2.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                O(adapter, z10);
            }
            if (this.F7 == null) {
                this.F7 = new b();
            }
            this.F7.b(z10);
            viewPager.d(this.F7);
            P(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f20803v2 = null;
            O(null, false);
        }
        this.G7 = z11;
    }

    public final void U() {
        int size = this.f20778a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f20778a.get(i10).E();
        }
    }

    public final void V(@n0 LinearLayout.LayoutParams layoutParams) {
        if (this.f20807z == 1 && this.f20804w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void W(boolean z10) {
        for (int i10 = 0; i10 < this.f20780c.getChildCount(); i10++) {
            View childAt = this.f20780c.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            V((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z10) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        j(view);
    }

    @Deprecated
    public void b(@p0 c cVar) {
        if (this.f20802v1.contains(cVar)) {
            return;
        }
        this.f20802v1.add(cVar);
    }

    public void c(@n0 f fVar) {
        b(fVar);
    }

    public void d(@n0 i iVar) {
        g(iVar, this.f20778a.isEmpty());
    }

    public void e(@n0 i iVar, int i10) {
        f(iVar, i10, this.f20778a.isEmpty());
    }

    public void f(@n0 i iVar, int i10, boolean z10) {
        if (iVar.f20826h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        p(iVar, i10);
        i(iVar);
        if (z10) {
            iVar.r();
        }
    }

    public void g(@n0 i iVar, boolean z10) {
        f(iVar, this.f20778a.size(), z10);
    }

    public int getSelectedTabPosition() {
        i iVar = this.f20779b;
        if (iVar != null) {
            return iVar.k();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f20778a.size();
    }

    public int getTabGravity() {
        return this.f20804w;
    }

    @p0
    public ColorStateList getTabIconTint() {
        return this.f20787j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.D;
    }

    public int getTabIndicatorGravity() {
        return this.f20806y;
    }

    public int getTabMaxWidth() {
        return this.f20797r;
    }

    public int getTabMode() {
        return this.f20807z;
    }

    @p0
    public ColorStateList getTabRippleColor() {
        return this.f20788k;
    }

    @n0
    public Drawable getTabSelectedIndicator() {
        return this.f20791l;
    }

    @p0
    public ColorStateList getTabTextColors() {
        return this.f20786i;
    }

    public final void h(@n0 TabItem tabItem) {
        i iVarD = D();
        CharSequence charSequence = tabItem.f20767a;
        if (charSequence != null) {
            iVarD.D(charSequence);
        }
        Drawable drawable = tabItem.f20768b;
        if (drawable != null) {
            iVarD.x(drawable);
        }
        int i10 = tabItem.f20769c;
        if (i10 != 0) {
            iVarD.u(i10);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            iVarD.t(tabItem.getContentDescription());
        }
        d(iVarD);
    }

    public final void i(@n0 i iVar) {
        n nVar = iVar.f20827i;
        nVar.setSelected(false);
        nVar.setActivated(false);
        this.f20780c.addView(nVar, iVar.k(), r());
    }

    public final void j(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        h((TabItem) view);
    }

    public final void k(int i10) {
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() == null || !u0.U0(this) || this.f20780c.d()) {
            P(i10, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iN = n(i10, 0.0f);
        if (scrollX != iN) {
            x();
            this.K1.setIntValues(scrollX, iN);
            this.K1.start();
        }
        this.f20780c.c(i10, this.f20805x);
    }

    public final void l(int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                this.f20780c.setGravity(1);
                return;
            } else if (i10 != 2) {
                return;
            }
        }
        this.f20780c.setGravity(androidx.core.view.m.f5025b);
    }

    public final void m() {
        int i10 = this.f20807z;
        u0.d2(this.f20780c, (i10 == 0 || i10 == 2) ? Math.max(0, this.f20801v - this.f20781d) : 0, 0, 0, 0);
        int i11 = this.f20807z;
        if (i11 == 0) {
            l(this.f20804w);
        } else if (i11 == 1 || i11 == 2) {
            this.f20780c.setGravity(1);
        }
        W(true);
    }

    public final int n(int i10, float f10) {
        View childAt;
        int i11 = this.f20807z;
        if ((i11 != 0 && i11 != 2) || (childAt = this.f20780c.getChildAt(i10)) == null) {
            return 0;
        }
        int i12 = i10 + 1;
        View childAt2 = i12 < this.f20780c.getChildCount() ? this.f20780c.getChildAt(i12) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i13 = (int) ((width + width2) * 0.5f * f10);
        return u0.Z(this) == 0 ? left + i13 : left - i13;
    }

    public void o() {
        this.f20802v1.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        le.k.e(this);
        if (this.f20803v2 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                T((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.G7) {
            setupWithViewPager(null);
            this.G7 = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@n0 Canvas canvas) {
        for (int i10 = 0; i10 < this.f20780c.getChildCount(); i10++) {
            View childAt = this.f20780c.getChildAt(i10);
            if (childAt instanceof n) {
                ((n) childAt).m(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        a1.d.g2(accessibilityNodeInfo).d1(d.C0006d.f(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return B() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.b0.e(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.f20799t
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.b0.e(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.f20797r = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.f20807z
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || B()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void p(@n0 i iVar, int i10) {
        iVar.z(i10);
        this.f20778a.add(i10, iVar);
        int size = this.f20778a.size();
        while (true) {
            i10++;
            if (i10 >= size) {
                return;
            } else {
                this.f20778a.get(i10).z(i10);
            }
        }
    }

    @n0
    public final LinearLayout.LayoutParams r() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        V(layoutParams);
        return layoutParams;
    }

    public i s() {
        i iVarA = R7.a();
        return iVarA == null ? new i() : iVarA;
    }

    @Override // android.view.View
    @v0(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        le.k.d(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.A != z10) {
            this.A = z10;
            for (int i10 = 0; i10 < this.f20780c.getChildCount(); i10++) {
                View childAt = this.f20780c.getChildAt(i10);
                if (childAt instanceof n) {
                    ((n) childAt).z();
                }
            }
            m();
        }
    }

    public void setInlineLabelResource(@g.h int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(@p0 f fVar) {
        setOnTabSelectedListener((c) fVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        x();
        this.K1.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@p0 Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = n0.c.r(drawable).mutate();
        this.f20791l = drawableMutate;
        yd.a.i(drawableMutate, this.f20792m);
        int intrinsicHeight = this.C;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.f20791l.getIntrinsicHeight();
        }
        this.f20780c.g(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(@g.l int i10) {
        this.f20792m = i10;
        yd.a.i(this.f20791l, i10);
        W(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.f20806y != i10) {
            this.f20806y = i10;
            u0.n1(this.f20780c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.C = i10;
        this.f20780c.g(i10);
    }

    public void setTabGravity(int i10) {
        if (this.f20804w != i10) {
            this.f20804w = i10;
            m();
        }
    }

    public void setTabIconTint(@p0 ColorStateList colorStateList) {
        if (this.f20787j != colorStateList) {
            this.f20787j = colorStateList;
            U();
        }
    }

    public void setTabIconTintResource(@g.n int i10) {
        setTabIconTint(i.a.a(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        this.D = i10;
        if (i10 == 0) {
            this.K0 = new com.google.android.material.tabs.a();
            return;
        }
        if (i10 == 1) {
            this.K0 = new ne.a();
        } else {
            if (i10 == 2) {
                this.K0 = new ne.b();
                return;
            }
            throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.B = z10;
        this.f20780c.e();
        u0.n1(this.f20780c);
    }

    public void setTabMode(int i10) {
        if (i10 != this.f20807z) {
            this.f20807z = i10;
            m();
        }
    }

    public void setTabRippleColor(@p0 ColorStateList colorStateList) {
        if (this.f20788k != colorStateList) {
            this.f20788k = colorStateList;
            for (int i10 = 0; i10 < this.f20780c.getChildCount(); i10++) {
                View childAt = this.f20780c.getChildAt(i10);
                if (childAt instanceof n) {
                    ((n) childAt).y(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@g.n int i10) {
        setTabRippleColor(i.a.a(getContext(), i10));
    }

    public void setTabTextColors(@p0 ColorStateList colorStateList) {
        if (this.f20786i != colorStateList) {
            this.f20786i = colorStateList;
            U();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@p0 k2.a aVar) {
        O(aVar, false);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.f20789k0 != z10) {
            this.f20789k0 = z10;
            for (int i10 = 0; i10 < this.f20780c.getChildCount(); i10++) {
                View childAt = this.f20780c.getChildAt(i10);
                if (childAt instanceof n) {
                    ((n) childAt).y(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@g.h int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(@p0 ViewPager viewPager) {
        S(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @n0
    public final n t(@n0 i iVar) {
        n.a<n> aVar = this.H7;
        n nVarA = aVar != null ? aVar.a() : null;
        if (nVarA == null) {
            nVarA = new n(getContext());
        }
        nVarA.setTab(iVar);
        nVarA.setFocusable(true);
        nVarA.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(iVar.f20822d)) {
            nVarA.setContentDescription(iVar.f20821c);
        } else {
            nVarA.setContentDescription(iVar.f20822d);
        }
        return nVarA;
    }

    public final void u(@n0 i iVar) {
        for (int size = this.f20802v1.size() - 1; size >= 0; size--) {
            this.f20802v1.get(size).a(iVar);
        }
    }

    public final void v(@n0 i iVar) {
        for (int size = this.f20802v1.size() - 1; size >= 0; size--) {
            this.f20802v1.get(size).b(iVar);
        }
    }

    public final void w(@n0 i iVar) {
        for (int size = this.f20802v1.size() - 1; size >= 0; size--) {
            this.f20802v1.get(size).c(iVar);
        }
    }

    public final void x() {
        if (this.K1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.K1 = valueAnimator;
            valueAnimator.setInterpolator(kd.a.f37167b);
            this.K1.setDuration(this.f20805x);
            this.K1.addUpdateListener(new a());
        }
    }

    @p0
    public i y(int i10) {
        if (i10 < 0 || i10 >= getTabCount()) {
            return null;
        }
        return this.f20778a.get(i10);
    }

    public boolean z() {
        return this.f20789k0;
    }

    public TabLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        j(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@p0 c cVar) {
        c cVar2 = this.f20790k1;
        if (cVar2 != null) {
            H(cVar2);
        }
        this.f20790k1 = cVar;
        if (cVar != null) {
            b(cVar);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = I7;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20778a = new ArrayList<>();
        this.f20792m = 0;
        this.f20797r = Integer.MAX_VALUE;
        this.C = -1;
        this.f20802v1 = new ArrayList<>();
        this.H7 = new n.b(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        h hVar = new h(context2);
        this.f20780c = hVar;
        super.addView(hVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R.styleable.TabLayout;
        int i12 = R.styleable.TabLayout_tabTextAppearance;
        TypedArray typedArrayK = t.k(context2, attributeSet, iArr, i10, i11, i12);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            le.j jVar = new le.j();
            jVar.o0(ColorStateList.valueOf(colorDrawable.getColor()));
            jVar.Z(context2);
            jVar.n0(u0.R(this));
            u0.I1(this, jVar);
        }
        setSelectedTabIndicator(ie.c.e(context2, typedArrayK, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayK.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        hVar.g(typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayK.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayK.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayK.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f20784g = dimensionPixelSize;
        this.f20783f = dimensionPixelSize;
        this.f20782e = dimensionPixelSize;
        this.f20781d = dimensionPixelSize;
        this.f20781d = typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f20782e = typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.f20782e);
        this.f20783f = typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.f20783f);
        this.f20784g = typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.f20784g);
        int resourceId = typedArrayK.getResourceId(i12, R.style.TextAppearance_Design_Tab);
        this.f20785h = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.f20794o = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.f20786i = ie.c.a(context2, typedArrayObtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            int i13 = R.styleable.TabLayout_tabTextColor;
            if (typedArrayK.hasValue(i13)) {
                this.f20786i = ie.c.a(context2, typedArrayK, i13);
            }
            int i14 = R.styleable.TabLayout_tabSelectedTextColor;
            if (typedArrayK.hasValue(i14)) {
                this.f20786i = q(this.f20786i.getDefaultColor(), typedArrayK.getColor(i14, 0));
            }
            this.f20787j = ie.c.a(context2, typedArrayK, R.styleable.TabLayout_tabIconTint);
            this.f20793n = b0.m(typedArrayK.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.f20788k = ie.c.a(context2, typedArrayK, R.styleable.TabLayout_tabRippleColor);
            this.f20805x = typedArrayK.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.f20798s = typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.f20799t = typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.f20796q = typedArrayK.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.f20801v = typedArrayK.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.f20807z = typedArrayK.getInt(R.styleable.TabLayout_tabMode, 1);
            this.f20804w = typedArrayK.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.A = typedArrayK.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.f20789k0 = typedArrayK.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayK.recycle();
            Resources resources = getResources();
            this.f20795p = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.f20800u = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            m();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    public void setSelectedTabIndicator(@v int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(i.a.b(getContext(), i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
