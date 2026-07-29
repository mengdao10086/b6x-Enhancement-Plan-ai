package com.google.android.material.navigation;

import a1.d;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.b1;
import androidx.core.view.o0;
import androidx.core.view.u0;
import androidx.core.widget.r;
import com.google.common.collect.LinkedHashMultimap;
import g.d1;
import g.i0;
import g.n0;
import g.p0;
import g.q;
import g.t0;
import g.v;
import g.x;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class a extends FrameLayout implements k.a {
    public static final int[] K0 = {R.attr.state_checked};

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f20546k0 = -1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final d f20547k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final d f20548v1;
    public int A;
    public boolean B;
    public int C;

    @p0
    public com.google.android.material.badge.a D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f20550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public Drawable f20551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f20554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f20555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f20556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f20558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final FrameLayout f20559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public final View f20560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f20561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewGroup f20562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f20563o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f20564p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20565q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public h f20566r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public ColorStateList f20567s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public Drawable f20568t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public Drawable f20569u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ValueAnimator f20570v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public d f20571w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f20572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f20573y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20574z;

    /* JADX INFO: renamed from: com.google.android.material.navigation.a$a, reason: collision with other inner class name */
    public class ViewOnLayoutChangeListenerC0209a implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC0209a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (a.this.f20561m.getVisibility() == 0) {
                a aVar = a.this;
                aVar.y(aVar.f20561m);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20576a;

        public b(int i10) {
            this.f20576a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.z(this.f20576a);
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f20578a;

        public c(float f10) {
            this.f20578a = f10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.s(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f20578a);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final float f20580a = 0.4f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final float f20581b = 1.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final float f20582c = 0.2f;

        public d() {
        }

        public float a(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11) {
            return kd.a.b(0.0f, 1.0f, f11 == 0.0f ? 0.8f : 0.0f, f11 == 0.0f ? 1.0f : 0.2f, f10);
        }

        public float b(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11) {
            return kd.a.a(0.4f, 1.0f, f10);
        }

        public float c(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11) {
            return 1.0f;
        }

        public void d(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11, @n0 View view) {
            view.setScaleX(b(f10, f11));
            view.setScaleY(c(f10, f11));
            view.setAlpha(a(f10, f11));
        }

        public /* synthetic */ d(ViewOnLayoutChangeListenerC0209a viewOnLayoutChangeListenerC0209a) {
            this();
        }
    }

    public static class e extends d {
        public e() {
            super(null);
        }

        @Override // com.google.android.material.navigation.a.d
        public float c(float f10, float f11) {
            return b(f10, f11);
        }

        public /* synthetic */ e(ViewOnLayoutChangeListenerC0209a viewOnLayoutChangeListenerC0209a) {
            this();
        }
    }

    static {
        ViewOnLayoutChangeListenerC0209a viewOnLayoutChangeListenerC0209a = null;
        f20547k1 = new d(viewOnLayoutChangeListenerC0209a);
        f20548v1 = new e(viewOnLayoutChangeListenerC0209a);
    }

    public a(@n0 Context context) {
        super(context);
        this.f20549a = false;
        this.f20565q = -1;
        this.f20571w = f20547k1;
        this.f20572x = 0.0f;
        this.f20573y = false;
        this.f20574z = 0;
        this.A = 0;
        this.B = false;
        this.C = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f20559k = (FrameLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container);
        this.f20560l = findViewById(com.google.android.material.R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        this.f20561m = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.f20562n = viewGroup;
        TextView textView = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.f20563o = textView;
        TextView textView2 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.f20564p = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f20552d = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f20553e = viewGroup.getPaddingBottom();
        u0.R1(textView, 2);
        u0.R1(textView2, 2);
        setFocusable(true);
        i(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0209a());
        }
    }

    public static void B(@n0 View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f20559k;
        return frameLayout != null ? frameLayout : this.f20561m;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i10 = 0;
        for (int i11 = 0; i11 < iIndexOfChild; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof a) && childAt.getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private int getSuggestedIconHeight() {
        com.google.android.material.badge.a aVar = this.D;
        int minimumHeight = aVar != null ? aVar.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.f20561m.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        com.google.android.material.badge.a aVar = this.D;
        int minimumWidth = aVar == null ? 0 : aVar.getMinimumWidth() - this.D.q();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f20561m.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    public static Drawable k(@n0 ColorStateList colorStateList) {
        return new RippleDrawable(je.b.a(colorStateList), null, null);
    }

    public static void t(TextView textView, @d1 int i10) {
        r.E(textView, i10);
        int iH = ie.c.h(textView.getContext(), i10, 0);
        if (iH != 0) {
            textView.setTextSize(0, iH);
        }
    }

    public static void u(@n0 View view, float f10, float f11, int i10) {
        view.setScaleX(f10);
        view.setScaleY(f11);
        view.setVisibility(i10);
    }

    public static void v(@n0 View view, int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i10;
        layoutParams.bottomMargin = i10;
        layoutParams.gravity = i11;
        view.setLayoutParams(layoutParams);
    }

    public final void A() {
        if (n()) {
            this.f20571w = f20548v1;
        } else {
            this.f20571w = f20547k1;
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void c(boolean z10, char c10) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f20559k;
        if (frameLayout != null && this.f20573y) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean g() {
        return true;
    }

    @p0
    public Drawable getActiveIndicatorDrawable() {
        View view = this.f20560l;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @p0
    public com.google.android.material.badge.a getBadge() {
        return this.D;
    }

    @v
    public int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.k.a
    @p0
    public h getItemData() {
        return this.f20566r;
    }

    @q
    public int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @i0
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f20565q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20562n.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f20562n.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20562n.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f20562n.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void h(@n0 h hVar, int i10) {
        this.f20566r = hVar;
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setIcon(hVar.getIcon());
        setTitle(hVar.getTitle());
        setId(hVar.getItemId());
        if (!TextUtils.isEmpty(hVar.getContentDescription())) {
            setContentDescription(hVar.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(hVar.getTooltipText()) ? hVar.getTooltipText() : hVar.getTitle();
        if (Build.VERSION.SDK_INT > 23) {
            b1.a(this, tooltipText);
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        this.f20549a = true;
    }

    public final void i(float f10, float f11) {
        this.f20554f = f10 - f11;
        this.f20555g = (f11 * 1.0f) / f10;
        this.f20556h = (f10 * 1.0f) / f11;
    }

    public void j() {
        r();
        this.f20566r = null;
        this.f20572x = 0.0f;
        this.f20549a = false;
    }

    @p0
    public final FrameLayout l(View view) {
        ImageView imageView = this.f20561m;
        if (view == imageView && com.google.android.material.badge.b.f19607a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    public final boolean m() {
        return this.D != null;
    }

    public final boolean n() {
        return this.B && this.f20557i == 2;
    }

    public final void o(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        if (!this.f20573y || !this.f20549a || !u0.O0(this)) {
            s(f10, f10);
            return;
        }
        ValueAnimator valueAnimator = this.f20570v;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f20570v = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f20572x, f10);
        this.f20570v = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new c(f10));
        this.f20570v.setInterpolator(ee.a.g(getContext(), com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, kd.a.f37167b));
        this.f20570v.setDuration(ee.a.f(getContext(), com.google.android.material.R.attr.motionDurationLong2, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
        this.f20570v.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    @n0
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        h hVar = this.f20566r;
        if (hVar != null && hVar.isCheckable() && this.f20566r.isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, K0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        com.google.android.material.badge.a aVar = this.D;
        if (aVar != null && aVar.isVisible()) {
            CharSequence title = this.f20566r.getTitle();
            if (!TextUtils.isEmpty(this.f20566r.getContentDescription())) {
                title = this.f20566r.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.D.o()));
        }
        a1.d dVarG2 = a1.d.g2(accessibilityNodeInfo);
        dVarG2.e1(d.e.h(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            dVarG2.c1(false);
            dVarG2.P0(d.a.f110j);
        }
        dVarG2.K1(getResources().getString(com.google.android.material.R.string.item_view_role_description));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new b(i10));
    }

    public final void p() {
        h hVar = this.f20566r;
        if (hVar != null) {
            setChecked(hVar.isChecked());
        }
    }

    public final void q() {
        Drawable drawableK = this.f20551c;
        RippleDrawable rippleDrawable = null;
        boolean z10 = true;
        if (this.f20550b != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.f20573y && getActiveIndicatorDrawable() != null && this.f20559k != null && activeIndicatorDrawable != null) {
                z10 = false;
                rippleDrawable = new RippleDrawable(je.b.e(this.f20550b), null, activeIndicatorDrawable);
            } else if (drawableK == null) {
                drawableK = k(this.f20550b);
            }
        }
        FrameLayout frameLayout = this.f20559k;
        if (frameLayout != null) {
            u0.I1(frameLayout, rippleDrawable);
        }
        u0.I1(this, drawableK);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z10);
        }
    }

    public void r() {
        x(this.f20561m);
    }

    public final void s(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, float f11) {
        View view = this.f20560l;
        if (view != null) {
            this.f20571w.d(f10, f11, view);
        }
        this.f20572x = f10;
    }

    public void setActiveIndicatorDrawable(@p0 Drawable drawable) {
        View view = this.f20560l;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        q();
    }

    public void setActiveIndicatorEnabled(boolean z10) {
        this.f20573y = z10;
        q();
        View view = this.f20560l;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i10) {
        this.A = i10;
        z(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(@t0 int i10) {
        this.C = i10;
        z(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z10) {
        this.B = z10;
    }

    public void setActiveIndicatorWidth(int i10) {
        this.f20574z = i10;
        z(getWidth());
    }

    public void setBadge(@n0 com.google.android.material.badge.a aVar) {
        if (this.D == aVar) {
            return;
        }
        if (m() && this.f20561m != null) {
            x(this.f20561m);
        }
        this.D = aVar;
        ImageView imageView = this.f20561m;
        if (imageView != null) {
            w(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setCheckable(boolean z10) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setChecked(boolean z10) {
        this.f20564p.setPivotX(r0.getWidth() / 2);
        this.f20564p.setPivotY(r0.getBaseline());
        this.f20563o.setPivotX(r0.getWidth() / 2);
        this.f20563o.setPivotY(r0.getBaseline());
        o(z10 ? 1.0f : 0.0f);
        int i10 = this.f20557i;
        if (i10 != -1) {
            if (i10 == 0) {
                if (z10) {
                    v(getIconOrContainer(), this.f20552d, 49);
                    B(this.f20562n, this.f20553e);
                    this.f20564p.setVisibility(0);
                } else {
                    v(getIconOrContainer(), this.f20552d, 17);
                    B(this.f20562n, 0);
                    this.f20564p.setVisibility(4);
                }
                this.f20563o.setVisibility(4);
            } else if (i10 == 1) {
                B(this.f20562n, this.f20553e);
                if (z10) {
                    v(getIconOrContainer(), (int) (this.f20552d + this.f20554f), 49);
                    u(this.f20564p, 1.0f, 1.0f, 0);
                    TextView textView = this.f20563o;
                    float f10 = this.f20555g;
                    u(textView, f10, f10, 4);
                } else {
                    v(getIconOrContainer(), this.f20552d, 49);
                    TextView textView2 = this.f20564p;
                    float f11 = this.f20556h;
                    u(textView2, f11, f11, 4);
                    u(this.f20563o, 1.0f, 1.0f, 0);
                }
            } else if (i10 == 2) {
                v(getIconOrContainer(), this.f20552d, 17);
                this.f20564p.setVisibility(8);
                this.f20563o.setVisibility(8);
            }
        } else if (this.f20558j) {
            if (z10) {
                v(getIconOrContainer(), this.f20552d, 49);
                B(this.f20562n, this.f20553e);
                this.f20564p.setVisibility(0);
            } else {
                v(getIconOrContainer(), this.f20552d, 17);
                B(this.f20562n, 0);
                this.f20564p.setVisibility(4);
            }
            this.f20563o.setVisibility(4);
        } else {
            B(this.f20562n, this.f20553e);
            if (z10) {
                v(getIconOrContainer(), (int) (this.f20552d + this.f20554f), 49);
                u(this.f20564p, 1.0f, 1.0f, 0);
                TextView textView3 = this.f20563o;
                float f12 = this.f20555g;
                u(textView3, f12, f12, 4);
            } else {
                v(getIconOrContainer(), this.f20552d, 49);
                TextView textView4 = this.f20564p;
                float f13 = this.f20556h;
                u(textView4, f13, f13, 4);
                u(this.f20563o, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z10);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.k.a
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f20563o.setEnabled(z10);
        this.f20564p.setEnabled(z10);
        this.f20561m.setEnabled(z10);
        if (z10) {
            u0.g2(this, o0.c(getContext(), 1002));
        } else {
            u0.g2(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setIcon(@p0 Drawable drawable) {
        if (drawable == this.f20568t) {
            return;
        }
        this.f20568t = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = n0.c.r(drawable).mutate();
            this.f20569u = drawable;
            ColorStateList colorStateList = this.f20567s;
            if (colorStateList != null) {
                n0.c.o(drawable, colorStateList);
            }
        }
        this.f20561m.setImageDrawable(drawable);
    }

    public void setIconSize(int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20561m.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.f20561m.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@p0 ColorStateList colorStateList) {
        Drawable drawable;
        this.f20567s = colorStateList;
        if (this.f20566r == null || (drawable = this.f20569u) == null) {
            return;
        }
        n0.c.o(drawable, colorStateList);
        this.f20569u.invalidateSelf();
    }

    public void setItemBackground(int i10) {
        setItemBackground(i10 == 0 ? null : h0.d.i(getContext(), i10));
    }

    public void setItemPaddingBottom(int i10) {
        if (this.f20553e != i10) {
            this.f20553e = i10;
            p();
        }
    }

    public void setItemPaddingTop(int i10) {
        if (this.f20552d != i10) {
            this.f20552d = i10;
            p();
        }
    }

    public void setItemPosition(int i10) {
        this.f20565q = i10;
    }

    public void setItemRippleColor(@p0 ColorStateList colorStateList) {
        this.f20550b = colorStateList;
        q();
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.f20557i != i10) {
            this.f20557i = i10;
            A();
            z(getWidth());
            p();
        }
    }

    public void setShifting(boolean z10) {
        if (this.f20558j != z10) {
            this.f20558j = z10;
            p();
        }
    }

    public void setTextAppearanceActive(@d1 int i10) {
        t(this.f20564p, i10);
        i(this.f20563o.getTextSize(), this.f20564p.getTextSize());
    }

    public void setTextAppearanceInactive(@d1 int i10) {
        t(this.f20563o, i10);
        i(this.f20563o.getTextSize(), this.f20564p.getTextSize());
    }

    public void setTextColor(@p0 ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f20563o.setTextColor(colorStateList);
            this.f20564p.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void setTitle(@p0 CharSequence charSequence) {
        this.f20563o.setText(charSequence);
        this.f20564p.setText(charSequence);
        h hVar = this.f20566r;
        if (hVar == null || TextUtils.isEmpty(hVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        h hVar2 = this.f20566r;
        if (hVar2 != null && !TextUtils.isEmpty(hVar2.getTooltipText())) {
            charSequence = this.f20566r.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            b1.a(this, charSequence);
        }
    }

    public final void w(@p0 View view) {
        if (m() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.b.d(this.D, view, l(view));
        }
    }

    public final void x(@p0 View view) {
        if (m()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.b.j(this.D, view);
            }
            this.D = null;
        }
    }

    public final void y(View view) {
        if (m()) {
            com.google.android.material.badge.b.m(this.D, view, l(view));
        }
    }

    public final void z(int i10) {
        if (this.f20560l == null) {
            return;
        }
        int iMin = Math.min(this.f20574z, i10 - (this.C * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20560l.getLayoutParams();
        layoutParams.height = n() ? iMin : this.A;
        layoutParams.width = iMin;
        this.f20560l.setLayoutParams(layoutParams);
    }

    public void setItemBackground(@p0 Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f20551c = drawable;
        q();
    }
}
