package com.google.android.material.tabs;

import a.aw;
import a.bv;
import a.bw;
import a.c0;
import a.dy;
import a.e10;
import a.eg;
import a.eh;
import a.f10;
import a.fv;
import a.g10;
import a.gy;
import a.iv;
import a.iz;
import a.jv;
import a.jz;
import a.kd;
import a.ku;
import a.kv;
import a.mf;
import a.nf;
import a.ni;
import a.ny;
import a.of;
import a.oj;
import a.pg;
import a.r2;
import a.r20;
import a.t8;
import a.wy;
import a.zu;
import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@ViewPager.e
public class TabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4677a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ku f4678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mf<i> f4679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f4680a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f4681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataSetObserver f4682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f4683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f4684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewPager f4686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f4687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f4688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f f4689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f4690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f4691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<g> f4692a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f4693b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4694b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f4695b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public c f4696b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<c> f4697b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4698b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ColorStateList f4699c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4700c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4701d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4702e;
    public final int f;
    public int g;
    public final int h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public static final int p = iv.Widget_Design_TabLayout;
    public static final mf<g> b = new of(16);

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.i {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4703a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, ku kuVar, ku kuVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f4686a == viewPager) {
                tabLayout.D(kuVar2, this.f4703a);
            }
        }

        public void b(boolean z) {
            this.f4703a = z;
        }
    }

    @Deprecated
    public interface c<T extends g> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface d extends c<g> {
    }

    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.w();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.w();
        }
    }

    public class f extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8325a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4704a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ValueAnimator f4705a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Paint f4706a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final GradientDrawable f4707a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public f(Context context) {
            super(context);
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            setWillNotDraw(false);
            this.f4706a = new Paint();
            this.f4707a = new GradientDrawable();
        }

        public void c(int i, int i2) {
            ValueAnimator valueAnimator = this.f4705a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f4705a.cancel();
            }
            k(true, i, i2);
        }

        public final void d(i iVar, RectF rectF) {
            int contentWidth = iVar.getContentWidth();
            int iB = (int) gy.b(getContext(), 24);
            if (contentWidth < iB) {
                contentWidth = iB;
            }
            int left = (iVar.getLeft() + iVar.getRight()) / 2;
            int i = contentWidth / 2;
            rectF.set(left - i, 0.0f, left + i, 0.0f);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void draw(android.graphics.Canvas r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.f4685a
                r1 = 0
                if (r0 == 0) goto Lc
                int r0 = r0.getIntrinsicHeight()
                goto Ld
            Lc:
                r0 = r1
            Ld:
                int r2 = r5.f4704a
                if (r2 < 0) goto L12
                r0 = r2
            L12:
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                int r2 = r2.n
                if (r2 == 0) goto L31
                r3 = 1
                r4 = 2
                if (r2 == r3) goto L23
                if (r2 == r4) goto L3a
                r0 = 3
                if (r2 == r0) goto L36
                r0 = r1
                goto L3a
            L23:
                int r1 = r5.getHeight()
                int r1 = r1 - r0
                int r1 = r1 / r4
                int r2 = r5.getHeight()
                int r2 = r2 + r0
                int r0 = r2 / 2
                goto L3a
            L31:
                int r1 = r5.getHeight()
                int r1 = r1 - r0
            L36:
                int r0 = r5.getHeight()
            L3a:
                int r2 = r5.d
                if (r2 < 0) goto L74
                int r3 = r5.e
                if (r3 <= r2) goto L74
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r2 = r2.f4685a
                if (r2 == 0) goto L49
                goto L4b
            L49:
                android.graphics.drawable.GradientDrawable r2 = r5.f4707a
            L4b:
                android.graphics.drawable.Drawable r2 = a.kd.r(r2)
                android.graphics.drawable.Drawable r2 = r2.mutate()
                int r3 = r5.d
                int r4 = r5.e
                r2.setBounds(r3, r1, r4, r0)
                android.graphics.Paint r0 = r5.f4706a
                if (r0 == 0) goto L71
                int r1 = android.os.Build.VERSION.SDK_INT
                r3 = 21
                int r0 = r0.getColor()
                if (r1 != r3) goto L6e
                android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_IN
                r2.setColorFilter(r0, r1)
                goto L71
            L6e:
                a.kd.n(r2, r0)
            L71:
                r2.draw(r6)
            L74:
                super.draw(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.f.draw(android.graphics.Canvas):void");
        }

        public boolean e() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public void f(int i, int i2) {
            if (i == this.d && i2 == this.e) {
                return;
            }
            this.d = i;
            this.e = i2;
            eh.b0(this);
        }

        public void g(int i, float f) {
            ValueAnimator valueAnimator = this.f4705a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f4705a.cancel();
            }
            this.b = i;
            this.f8325a = f;
            j();
        }

        public void h(int i) {
            if (this.f4706a.getColor() != i) {
                this.f4706a.setColor(i);
                eh.b0(this);
            }
        }

        public void i(int i) {
            if (this.f4704a != i) {
                this.f4704a = i;
                eh.b0(this);
            }
        }

        public final void j() {
            int left;
            int right;
            View childAt = getChildAt(this.b);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.f4700c && (childAt instanceof i)) {
                    d((i) childAt, tabLayout.f4684a);
                    left = (int) TabLayout.this.f4684a.left;
                    right = (int) TabLayout.this.f4684a.right;
                }
                if (this.f8325a > 0.0f && this.b < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.b + 1);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.f4700c && (childAt2 instanceof i)) {
                        d((i) childAt2, tabLayout2.f4684a);
                        left2 = (int) TabLayout.this.f4684a.left;
                        right2 = (int) TabLayout.this.f4684a.right;
                    }
                    float f = this.f8325a;
                    left = (int) ((left2 * f) + ((1.0f - f) * left));
                    right = (int) ((right2 * f) + ((1.0f - f) * right));
                }
            }
            f(left, right);
        }

        public final void k(boolean z, int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                j();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.f4700c && (childAt instanceof i)) {
                d((i) childAt, tabLayout.f4684a);
                left = (int) TabLayout.this.f4684a.left;
                right = (int) TabLayout.this.f4684a.right;
            }
            int i3 = this.d;
            int i4 = this.e;
            if (i3 == left && i4 == right) {
                return;
            }
            if (z) {
                this.f = i3;
                this.g = i4;
            }
            e10 e10Var = new e10(this, left, right);
            if (!z) {
                this.f4705a.removeAllUpdateListeners();
                this.f4705a.addUpdateListener(e10Var);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f4705a = valueAnimator;
            valueAnimator.setInterpolator(kv.b);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(e10Var);
            valueAnimator.addListener(new f10(this, i));
            valueAnimator.start();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.f4705a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                j();
            } else {
                k(false, this.b, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.l == 1 || tabLayout.o == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) gy.b(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.l = 0;
                    tabLayout2.K(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.c == i) {
                return;
            }
            requestLayout();
            this.c = i;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Drawable f4709a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public View f4710a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public i f4711a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TabLayout f4712a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CharSequence f4713a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public CharSequence f4714b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8326a = -1;
        public int b = 1;

        public View d() {
            return this.f4710a;
        }

        public Drawable e() {
            return this.f4709a;
        }

        public int f() {
            return this.f8326a;
        }

        public int g() {
            return this.b;
        }

        public CharSequence h() {
            return this.f4713a;
        }

        public boolean i() {
            TabLayout tabLayout = this.f4712a;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f8326a;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void j() {
            this.f4712a = null;
            this.f4711a = null;
            this.f4709a = null;
            this.f4713a = null;
            this.f4714b = null;
            this.f8326a = -1;
            this.f4710a = null;
        }

        public void k() {
            TabLayout tabLayout = this.f4712a;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.B(this);
        }

        public g l(View view) {
            this.f4710a = view;
            o();
            return this;
        }

        public void m(int i) {
            this.f8326a = i;
        }

        public g n(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f4714b) && !TextUtils.isEmpty(charSequence)) {
                this.f4711a.setContentDescription(charSequence);
            }
            this.f4713a = charSequence;
            o();
            return this;
        }

        public void o() {
            i iVar = this.f4711a;
            if (iVar != null) {
                iVar.s();
            }
        }
    }

    public static class h implements ViewPager.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8327a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final WeakReference<TabLayout> f4715a;
        public int b;

        public h(TabLayout tabLayout) {
            this.f4715a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void a(int i) {
            this.f8327a = this.b;
            this.b = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i) {
            TabLayout tabLayout = this.f4715a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.b;
            tabLayout.C(tabLayout.u(i), i2 == 0 || (i2 == 2 && this.f8327a == 0));
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i, float f, int i2) {
            TabLayout tabLayout = this.f4715a.get();
            if (tabLayout != null) {
                tabLayout.F(i, f, this.b != 2 || this.f8327a == 1, (this.b == 2 && this.f8327a == 0) ? false : true);
            }
        }

        public void d() {
            this.b = 0;
            this.f8327a = 0;
        }
    }

    public final class i extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8328a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public aw f4716a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Drawable f4717a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public View f4718a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ImageView f4719a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f4720a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public g f4721a;
        public View b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ImageView f4723b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public TextView f4724b;

        public i(Context context) {
            super(context);
            this.f8328a = 2;
            t(context);
            eh.w0(this, TabLayout.this.f4677a, TabLayout.this.f4694b, TabLayout.this.c, TabLayout.this.d);
            setGravity(17);
            setOrientation(!TabLayout.this.f4698b ? 1 : 0);
            setClickable(true);
            eh.x0(this, pg.b(getContext(), 1002));
        }

        private aw getBadge() {
            return this.f4716a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            View[] viewArr = {this.f4720a, this.f4719a, this.b};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        private aw getOrCreateBadge() {
            if (this.f4716a == null) {
                this.f4716a = aw.c(getContext());
            }
            q();
            aw awVar = this.f4716a;
            if (awVar != null) {
                return awVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f4717a;
            boolean state = false;
            if (drawable != null && drawable.isStateful()) {
                state = false | this.f4717a.setState(drawableState);
            }
            if (state) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new g10(this, view));
        }

        public final float f(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        public final void g(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        public g getTab() {
            return this.f4721a;
        }

        public final FrameLayout h() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        public final void i(Canvas canvas) {
            Drawable drawable = this.f4717a;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f4717a.draw(canvas);
            }
        }

        public final FrameLayout j(View view) {
            if ((view == this.f4719a || view == this.f4720a) && bw.f5737a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        public final boolean k() {
            return this.f4716a != null;
        }

        public final void l() {
            ViewGroup viewGroup;
            if (bw.f5737a) {
                FrameLayout frameLayoutH = h();
                addView(frameLayoutH, 0);
                viewGroup = frameLayoutH;
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(fv.design_layout_tab_icon, viewGroup, false);
            this.f4719a = imageView;
            viewGroup.addView(imageView, 0);
        }

        public final void m() {
            ViewGroup viewGroup;
            if (bw.f5737a) {
                FrameLayout frameLayoutH = h();
                addView(frameLayoutH);
                viewGroup = frameLayoutH;
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(fv.design_layout_tab_text, viewGroup, false);
            this.f4720a = textView;
            viewGroup.addView(textView);
        }

        public void n() {
            setTab(null);
            setSelected(false);
        }

        public final void o(View view) {
            if (k() && view != null) {
                g(false);
                bw.a(this.f4716a, view, j(view));
                this.f4718a = view;
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            aw awVar = this.f4716a;
            if (awVar != null && awVar.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f4716a.g()));
            }
            ni niVarD0 = ni.D0(accessibilityNodeInfo);
            niVarD0.d0(ni.c.a(0, 1, this.f4721a.f(), 1, false, isSelected()));
            if (isSelected()) {
                niVarD0.b0(false);
                niVarD0.S(ni.a.c);
            }
            niVarD0.s0("Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.g, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.f4720a != null) {
                float f = TabLayout.this.f8321a;
                int i3 = this.f8328a;
                ImageView imageView = this.f4719a;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f4720a;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.f4693b;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.f4720a.getTextSize();
                int lineCount = this.f4720a.getLineCount();
                int iD = oj.d(this.f4720a);
                if (f != textSize || (iD >= 0 && i3 != iD)) {
                    if (TabLayout.this.o == 1 && f > textSize && lineCount == 1 && ((layout = this.f4720a.getLayout()) == null || f(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f4720a.setTextSize(0, f);
                        this.f4720a.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        public final void p() {
            if (k()) {
                g(true);
                View view = this.f4718a;
                if (view != null) {
                    bw.b(this.f4716a, view, j(view));
                    this.f4718a = null;
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f4721a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f4721a.k();
            return true;
        }

        public final void q() {
            g gVar;
            View view;
            View view2;
            g gVar2;
            if (k()) {
                if (this.b == null) {
                    if (this.f4719a != null && (gVar2 = this.f4721a) != null && gVar2.e() != null) {
                        View view3 = this.f4718a;
                        view = this.f4719a;
                        if (view3 != view) {
                            p();
                            view2 = this.f4719a;
                            o(view2);
                            return;
                        }
                        r(view);
                        return;
                    }
                    if (this.f4720a != null && (gVar = this.f4721a) != null && gVar.g() == 1) {
                        View view4 = this.f4718a;
                        view = this.f4720a;
                        if (view4 != view) {
                            p();
                            view2 = this.f4720a;
                            o(view2);
                            return;
                        }
                        r(view);
                        return;
                    }
                }
                p();
            }
        }

        public final void r(View view) {
            if (k() && view == this.f4718a) {
                bw.c(this.f4716a, view, j(view));
            }
        }

        public final void s() {
            g gVar = this.f4721a;
            Drawable drawableMutate = null;
            View viewD = gVar != null ? gVar.d() : null;
            if (viewD != null) {
                ViewParent parent = viewD.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewD);
                    }
                    addView(viewD);
                }
                this.b = viewD;
                TextView textView = this.f4720a;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f4719a;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f4719a.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewD.findViewById(R.id.text1);
                this.f4724b = textView2;
                if (textView2 != null) {
                    this.f8328a = oj.d(textView2);
                }
                this.f4723b = (ImageView) viewD.findViewById(R.id.icon);
            } else {
                View view = this.b;
                if (view != null) {
                    removeView(view);
                    this.b = null;
                }
                this.f4724b = null;
                this.f4723b = null;
            }
            if (this.b == null) {
                if (this.f4719a == null) {
                    l();
                }
                if (gVar != null && gVar.e() != null) {
                    drawableMutate = kd.r(gVar.e()).mutate();
                }
                if (drawableMutate != null) {
                    kd.o(drawableMutate, TabLayout.this.f4695b);
                    PorterDuff.Mode mode = TabLayout.this.f4683a;
                    if (mode != null) {
                        kd.p(drawableMutate, mode);
                    }
                }
                if (this.f4720a == null) {
                    m();
                    this.f8328a = oj.d(this.f4720a);
                }
                oj.q(this.f4720a, TabLayout.this.e);
                ColorStateList colorStateList = TabLayout.this.f4681a;
                if (colorStateList != null) {
                    this.f4720a.setTextColor(colorStateList);
                }
                v(this.f4720a, this.f4719a);
                q();
                e(this.f4719a);
                e(this.f4720a);
            } else if (this.f4724b != null || this.f4723b != null) {
                v(this.f4724b, this.f4723b);
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f4714b)) {
                setContentDescription(gVar.f4714b);
            }
            setSelected(gVar != null && gVar.i());
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f4720a;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f4719a;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.b;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.f4721a) {
                this.f4721a = gVar;
                s();
            }
        }

        public final void t(Context context) {
            int i = TabLayout.this.f;
            if (i != 0) {
                Drawable drawableD = r2.d(context, i);
                this.f4717a = drawableD;
                if (drawableD != null && drawableD.isStateful()) {
                    this.f4717a.setState(getDrawableState());
                }
            } else {
                this.f4717a = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            Drawable layerDrawable = gradientDrawable;
            if (TabLayout.this.f4699c != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = wy.a(TabLayout.this.f4699c);
                if (Build.VERSION.SDK_INT >= 21) {
                    GradientDrawable gradientDrawable3 = gradientDrawable;
                    if (TabLayout.this.f4701d) {
                        gradientDrawable3 = null;
                    }
                    layerDrawable = new RippleDrawable(colorStateListA, gradientDrawable3, TabLayout.this.f4701d ? null : gradientDrawable2);
                } else {
                    Drawable drawableR = kd.r(gradientDrawable2);
                    kd.o(drawableR, colorStateListA);
                    layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, drawableR});
                }
            }
            eh.m0(this, layerDrawable);
            TabLayout.this.invalidate();
        }

        public final void u() {
            TextView textView;
            ImageView imageView;
            setOrientation(!TabLayout.this.f4698b ? 1 : 0);
            if (this.f4724b == null && this.f4723b == null) {
                textView = this.f4720a;
                imageView = this.f4719a;
            } else {
                textView = this.f4724b;
                imageView = this.f4723b;
            }
            v(textView, imageView);
        }

        public final void v(TextView textView, ImageView imageView) {
            g gVar = this.f4721a;
            Drawable drawableMutate = (gVar == null || gVar.e() == null) ? null : kd.r(this.f4721a.e()).mutate();
            g gVar2 = this.f4721a;
            CharSequence charSequenceH = gVar2 != null ? gVar2.h() : null;
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
            boolean z = !TextUtils.isEmpty(charSequenceH);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequenceH);
                    if (this.f4721a.b == 1) {
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
                int iB = (z && imageView.getVisibility() == 0) ? (int) gy.b(getContext(), 8) : 0;
                if (TabLayout.this.f4698b) {
                    if (iB != eg.a(marginLayoutParams)) {
                        eg.c(marginLayoutParams, iB);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iB != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iB;
                    eg.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f4721a;
            t8.a(this, z ? null : gVar3 != null ? gVar3.f4714b : null);
        }
    }

    public static class j implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f8329a;

        public j(ViewPager viewPager) {
            this.f8329a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
            this.f8329a.setCurrentItem(gVar.f());
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.tabStyle);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(r20.c(context, attributeSet, i2, p), attributeSet, i2);
        this.f4692a = new ArrayList<>();
        this.f4684a = new RectF();
        this.g = Integer.MAX_VALUE;
        this.f4697b = new ArrayList<>();
        this.f4679a = new nf(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f4689a = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayH = dy.h(context2, attributeSet, jv.TabLayout, i2, p, jv.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            iz izVar = new iz();
            izVar.U(ColorStateList.valueOf(colorDrawable.getColor()));
            izVar.K(context2);
            izVar.T(eh.t(this));
            eh.m0(this, izVar);
        }
        this.f4689a.i(typedArrayH.getDimensionPixelSize(jv.TabLayout_tabIndicatorHeight, -1));
        this.f4689a.h(typedArrayH.getColor(jv.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(ny.d(context2, typedArrayH, jv.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(typedArrayH.getInt(jv.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayH.getBoolean(jv.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayH.getDimensionPixelSize(jv.TabLayout_tabPadding, 0);
        this.d = dimensionPixelSize;
        this.c = dimensionPixelSize;
        this.f4694b = dimensionPixelSize;
        this.f4677a = dimensionPixelSize;
        this.f4677a = typedArrayH.getDimensionPixelSize(jv.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f4694b = typedArrayH.getDimensionPixelSize(jv.TabLayout_tabPaddingTop, this.f4694b);
        this.c = typedArrayH.getDimensionPixelSize(jv.TabLayout_tabPaddingEnd, this.c);
        this.d = typedArrayH.getDimensionPixelSize(jv.TabLayout_tabPaddingBottom, this.d);
        int resourceId = typedArrayH.getResourceId(jv.TabLayout_tabTextAppearance, iv.TextAppearance_Design_Tab);
        this.e = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, c0.TextAppearance);
        try {
            this.f8321a = typedArrayObtainStyledAttributes.getDimensionPixelSize(c0.TextAppearance_android_textSize, 0);
            this.f4681a = ny.a(context2, typedArrayObtainStyledAttributes, c0.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayH.hasValue(jv.TabLayout_tabTextColor)) {
                this.f4681a = ny.a(context2, typedArrayH, jv.TabLayout_tabTextColor);
            }
            if (typedArrayH.hasValue(jv.TabLayout_tabSelectedTextColor)) {
                this.f4681a = m(this.f4681a.getDefaultColor(), typedArrayH.getColor(jv.TabLayout_tabSelectedTextColor, 0));
            }
            this.f4695b = ny.a(context2, typedArrayH, jv.TabLayout_tabIconTint);
            this.f4683a = gy.e(typedArrayH.getInt(jv.TabLayout_tabIconTintMode, -1), null);
            this.f4699c = ny.a(context2, typedArrayH, jv.TabLayout_tabRippleColor);
            this.m = typedArrayH.getInt(jv.TabLayout_tabIndicatorAnimationDuration, 300);
            this.h = typedArrayH.getDimensionPixelSize(jv.TabLayout_tabMinWidth, -1);
            this.i = typedArrayH.getDimensionPixelSize(jv.TabLayout_tabMaxWidth, -1);
            this.f = typedArrayH.getResourceId(jv.TabLayout_tabBackground, 0);
            this.k = typedArrayH.getDimensionPixelSize(jv.TabLayout_tabContentStart, 0);
            this.o = typedArrayH.getInt(jv.TabLayout_tabMode, 1);
            this.l = typedArrayH.getInt(jv.TabLayout_tabGravity, 0);
            this.f4698b = typedArrayH.getBoolean(jv.TabLayout_tabInlineLabel, false);
            this.f4701d = typedArrayH.getBoolean(jv.TabLayout_tabUnboundedRipple, false);
            typedArrayH.recycle();
            Resources resources = getResources();
            this.f4693b = resources.getDimensionPixelSize(bv.design_tab_text_size_2line);
            this.j = resources.getDimensionPixelSize(bv.design_tab_scrollable_min_width);
            j();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int getDefaultHeight() {
        int size = this.f4692a.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.f4692a.get(i2);
                if (gVar != null && gVar.e() != null && !TextUtils.isEmpty(gVar.h())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.f4698b) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.h;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.o;
        if (i3 == 0 || i3 == 2) {
            return this.j;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f4689a.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public static ColorStateList m(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.f4689a.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f4689a.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    public final void A(int i2) {
        i iVar = (i) this.f4689a.getChildAt(i2);
        this.f4689a.removeViewAt(i2);
        if (iVar != null) {
            iVar.n();
            this.f4679a.b(iVar);
        }
        requestLayout();
    }

    public void B(g gVar) {
        C(gVar, true);
    }

    public void C(g gVar, boolean z) {
        g gVar2 = this.f4690a;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                q(gVar);
                h(gVar.f());
                return;
            }
            return;
        }
        int iF = gVar != null ? gVar.f() : -1;
        if (z) {
            if ((gVar2 == null || gVar2.f() == -1) && iF != -1) {
                E(iF, 0.0f, true);
            } else {
                h(iF);
            }
            if (iF != -1) {
                setSelectedTabView(iF);
            }
        }
        this.f4690a = gVar;
        if (gVar2 != null) {
            s(gVar2);
        }
        if (gVar != null) {
            r(gVar);
        }
    }

    public void D(ku kuVar, boolean z) {
        DataSetObserver dataSetObserver;
        ku kuVar2 = this.f4678a;
        if (kuVar2 != null && (dataSetObserver = this.f4682a) != null) {
            kuVar2.p(dataSetObserver);
        }
        this.f4678a = kuVar;
        if (z && kuVar != null) {
            if (this.f4682a == null) {
                this.f4682a = new e();
            }
            kuVar.j(this.f4682a);
        }
        w();
    }

    public void E(int i2, float f2, boolean z) {
        F(i2, f2, z, true);
    }

    public void F(int i2, float f2, boolean z, boolean z2) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.f4689a.getChildCount()) {
            return;
        }
        if (z2) {
            this.f4689a.g(i2, f2);
        }
        ValueAnimator valueAnimator = this.f4680a;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f4680a.cancel();
        }
        scrollTo(k(i2, f2), 0);
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    public void G(ViewPager viewPager, boolean z) {
        H(viewPager, z, false);
    }

    public final void H(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.f4686a;
        if (viewPager2 != null) {
            h hVar = this.f4691a;
            if (hVar != null) {
                viewPager2.J(hVar);
            }
            b bVar = this.f4687a;
            if (bVar != null) {
                this.f4686a.I(bVar);
            }
        }
        c cVar = this.f4696b;
        if (cVar != null) {
            z(cVar);
            this.f4696b = null;
        }
        if (viewPager != null) {
            this.f4686a = viewPager;
            if (this.f4691a == null) {
                this.f4691a = new h(this);
            }
            this.f4691a.d();
            viewPager.c(this.f4691a);
            j jVar = new j(viewPager);
            this.f4696b = jVar;
            b(jVar);
            ku adapter = viewPager.getAdapter();
            if (adapter != null) {
                D(adapter, z);
            }
            if (this.f4687a == null) {
                this.f4687a = new b();
            }
            this.f4687a.b(z);
            viewPager.b(this.f4687a);
            E(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f4686a = null;
            D(null, false);
        }
        this.f4702e = z2;
    }

    public final void I() {
        int size = this.f4692a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4692a.get(i2).o();
        }
    }

    public final void J(LinearLayout.LayoutParams layoutParams) {
        float f2;
        if (this.o == 1 && this.l == 0) {
            layoutParams.width = 0;
            f2 = 1.0f;
        } else {
            layoutParams.width = -2;
            f2 = 0.0f;
        }
        layoutParams.weight = f2;
    }

    public void K(boolean z) {
        for (int i2 = 0; i2 < this.f4689a.getChildCount(); i2++) {
            View childAt = this.f4689a.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            J((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        g(view);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        g(view);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        g(view);
        throw null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        g(view);
        throw null;
    }

    @Deprecated
    public void b(c cVar) {
        if (this.f4697b.contains(cVar)) {
            return;
        }
        this.f4697b.add(cVar);
    }

    public void c(d dVar) {
        b(dVar);
    }

    public void d(g gVar, int i2, boolean z) {
        if (gVar.f4712a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        l(gVar, i2);
        f(gVar);
        if (z) {
            gVar.k();
        }
    }

    public void e(g gVar, boolean z) {
        d(gVar, this.f4692a.size(), z);
    }

    public final void f(g gVar) {
        i iVar = gVar.f4711a;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.f4689a.addView(iVar, gVar.f(), n());
    }

    public final void g(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        g gVar = this.f4690a;
        if (gVar != null) {
            return gVar.f();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f4692a.size();
    }

    public int getTabGravity() {
        return this.l;
    }

    public ColorStateList getTabIconTint() {
        return this.f4695b;
    }

    public int getTabIndicatorGravity() {
        return this.n;
    }

    public int getTabMaxWidth() {
        return this.g;
    }

    public int getTabMode() {
        return this.o;
    }

    public ColorStateList getTabRippleColor() {
        return this.f4699c;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f4685a;
    }

    public ColorStateList getTabTextColors() {
        return this.f4681a;
    }

    public final void h(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !eh.Q(this) || this.f4689a.e()) {
            E(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iK = k(i2, 0.0f);
        if (scrollX != iK) {
            t();
            this.f4680a.setIntValues(scrollX, iK);
            this.f4680a.start();
        }
        this.f4689a.c(i2, this.m);
    }

    public final void i(int i2) {
        f fVar;
        int i3;
        if (i2 != 0) {
            i3 = 1;
            if (i2 == 1) {
                fVar = this.f4689a;
                fVar.setGravity(i3);
            } else if (i2 != 2) {
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        fVar = this.f4689a;
        i3 = 8388611;
        fVar.setGravity(i3);
    }

    public final void j() {
        int i2 = this.o;
        eh.w0(this.f4689a, (i2 == 0 || i2 == 2) ? Math.max(0, this.k - this.f4677a) : 0, 0, 0, 0);
        int i3 = this.o;
        if (i3 == 0) {
            i(this.l);
        } else if (i3 == 1 || i3 == 2) {
            if (this.l == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f4689a.setGravity(1);
        }
        K(true);
    }

    public final int k(int i2, float f2) {
        int i3 = this.o;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.f4689a.getChildAt(i2);
        int i4 = i2 + 1;
        View childAt2 = i4 < this.f4689a.getChildCount() ? this.f4689a.getChildAt(i4) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return eh.y(this) == 0 ? left + i5 : left - i5;
    }

    public final void l(g gVar, int i2) {
        gVar.m(i2);
        this.f4692a.add(i2, gVar);
        int size = this.f4692a.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.f4692a.get(i2).m(i2);
            }
        }
    }

    public final LinearLayout.LayoutParams n() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        J(layoutParams);
        return layoutParams;
    }

    public g o() {
        g gVarA = b.a();
        return gVarA == null ? new g() : gVarA;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        jz.e(this);
        if (this.f4686a == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                H((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f4702e) {
            setupWithViewPager(null);
            this.f4702e = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f4689a.getChildCount(); i2++) {
            View childAt = this.f4689a.getChildAt(i2);
            if (childAt instanceof i) {
                ((i) childAt).i(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ni.D0(accessibilityNodeInfo).c0(ni.b.a(1, getTabCount(), false, 1));
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
            float r0 = a.gy.b(r0, r1)
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
            int r1 = r6.i
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = a.gy.b(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.g = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.o
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
            r4 = r5
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

    public final i p(g gVar) {
        mf<i> mfVar = this.f4679a;
        i iVarA = mfVar != null ? mfVar.a() : null;
        if (iVarA == null) {
            iVarA = new i(getContext());
        }
        iVarA.setTab(gVar);
        iVarA.setFocusable(true);
        iVarA.setMinimumWidth(getTabMinWidth());
        iVarA.setContentDescription(TextUtils.isEmpty(gVar.f4714b) ? gVar.f4713a : gVar.f4714b);
        return iVarA;
    }

    public final void q(g gVar) {
        for (int size = this.f4697b.size() - 1; size >= 0; size--) {
            this.f4697b.get(size).b(gVar);
        }
    }

    public final void r(g gVar) {
        for (int size = this.f4697b.size() - 1; size >= 0; size--) {
            this.f4697b.get(size).c(gVar);
        }
    }

    public final void s(g gVar) {
        for (int size = this.f4697b.size() - 1; size >= 0; size--) {
            this.f4697b.get(size).a(gVar);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        jz.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.f4698b != z) {
            this.f4698b = z;
            for (int i2 = 0; i2 < this.f4689a.getChildCount(); i2++) {
                View childAt = this.f4689a.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).u();
                }
            }
            j();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.f4688a;
        if (cVar2 != null) {
            z(cVar2);
        }
        this.f4688a = cVar;
        if (cVar != null) {
            b(cVar);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        t();
        this.f4680a.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(int i2) {
        setSelectedTabIndicator(i2 != 0 ? r2.d(getContext(), i2) : null);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.f4685a != drawable) {
            this.f4685a = drawable;
            eh.b0(this.f4689a);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.f4689a.h(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.n != i2) {
            this.n = i2;
            eh.b0(this.f4689a);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f4689a.i(i2);
    }

    public void setTabGravity(int i2) {
        if (this.l != i2) {
            this.l = i2;
            j();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f4695b != colorStateList) {
            this.f4695b = colorStateList;
            I();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(r2.c(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.f4700c = z;
        eh.b0(this.f4689a);
    }

    public void setTabMode(int i2) {
        if (i2 != this.o) {
            this.o = i2;
            j();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f4699c != colorStateList) {
            this.f4699c = colorStateList;
            for (int i2 = 0; i2 < this.f4689a.getChildCount(); i2++) {
                View childAt = this.f4689a.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).t(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(r2.c(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f4681a != colorStateList) {
            this.f4681a = colorStateList;
            I();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(ku kuVar) {
        D(kuVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.f4701d != z) {
            this.f4701d = z;
            for (int i2 = 0; i2 < this.f4689a.getChildCount(); i2++) {
                View childAt = this.f4689a.getChildAt(i2);
                if (childAt instanceof i) {
                    ((i) childAt).t(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        G(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public final void t() {
        if (this.f4680a == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f4680a = valueAnimator;
            valueAnimator.setInterpolator(kv.b);
            this.f4680a.setDuration(this.m);
            this.f4680a.addUpdateListener(new a());
        }
    }

    public g u(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f4692a.get(i2);
    }

    public g v() {
        g gVarO = o();
        gVarO.f4712a = this;
        gVarO.f4711a = p(gVarO);
        return gVarO;
    }

    public void w() {
        int currentItem;
        y();
        ku kuVar = this.f4678a;
        if (kuVar != null) {
            int iC = kuVar.c();
            for (int i2 = 0; i2 < iC; i2++) {
                g gVarV = v();
                gVarV.n(this.f4678a.e(i2));
                e(gVarV, false);
            }
            ViewPager viewPager = this.f4686a;
            if (viewPager == null || iC <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            B(u(currentItem));
        }
    }

    public boolean x(g gVar) {
        return b.b(gVar);
    }

    public void y() {
        for (int childCount = this.f4689a.getChildCount() - 1; childCount >= 0; childCount--) {
            A(childCount);
        }
        Iterator<g> it = this.f4692a.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.j();
            x(next);
        }
        this.f4690a = null;
    }

    @Deprecated
    public void z(c cVar) {
        this.f4697b.remove(cVar);
    }
}
