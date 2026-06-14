package com.google.android.material.snackbar;

import a.b00;
import a.b10;
import a.bv;
import a.c00;
import a.d00;
import a.dy;
import a.e00;
import a.eh;
import a.f00;
import a.fv;
import a.g00;
import a.gy;
import a.h00;
import a.i00;
import a.iw;
import a.j00;
import a.jv;
import a.k00;
import a.kd;
import a.kv;
import a.l00;
import a.m00;
import a.n00;
import a.ny;
import a.p00;
import a.q00;
import a.r00;
import a.r20;
import a.s00;
import a.t00;
import a.u00;
import a.v00;
import a.w00;
import a.x00;
import a.z00;
import a.zu;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f8316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f4652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f4653a;
    public static final boolean b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final x00 f4655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f4657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f4658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ViewGroup f4660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AccessibilityManager f4661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Behavior f4662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f4663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<t00<B>> f4665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4666a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4667b;
    public int c;
    public int d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4664a = new k00(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z00 f4656a = new n00(this);

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f8317a = new a(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.f8317a.a(view);
        }

        public final void P(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f8317a.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f8317a.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z00 f8318a;

        public a(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof b;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    b10.c().j(this.f8318a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                b10.c().k(this.f8318a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f8318a = baseTransientBottomBar.f4656a;
        }
    }

    public static class b extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final View.OnTouchListener f8319a = new w00();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final float f4668a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4669a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public u00 f4670a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public v00 f4671a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ColorStateList f4672a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public PorterDuff.Mode f4673a;
        public final float b;

        public b(Context context, AttributeSet attributeSet) {
            super(r20.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, jv.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(jv.SnackbarLayout_elevation)) {
                eh.q0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(jv.SnackbarLayout_elevation, 0));
            }
            this.f4669a = typedArrayObtainStyledAttributes.getInt(jv.SnackbarLayout_animationMode, 0);
            this.f4668a = typedArrayObtainStyledAttributes.getFloat(jv.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(ny.a(context2, typedArrayObtainStyledAttributes, jv.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(gy.e(typedArrayObtainStyledAttributes.getInt(jv.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.b = typedArrayObtainStyledAttributes.getFloat(jv.SnackbarLayout_actionTextColorAlpha, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f8319a);
            setFocusable(true);
            if (getBackground() == null) {
                eh.m0(this, a());
            }
        }

        public final Drawable a() {
            float dimension = getResources().getDimension(bv.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(iw.g(this, zu.colorSurface, zu.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f4672a == null) {
                return kd.r(gradientDrawable);
            }
            Drawable drawableR = kd.r(gradientDrawable);
            kd.o(drawableR, this.f4672a);
            return drawableR;
        }

        public float getActionTextColorAlpha() {
            return this.b;
        }

        public int getAnimationMode() {
            return this.f4669a;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f4668a;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            u00 u00Var = this.f4670a;
            if (u00Var != null) {
                u00Var.onViewAttachedToWindow(this);
            }
            eh.h0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            u00 u00Var = this.f4670a;
            if (u00Var != null) {
                u00Var.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            v00 v00Var = this.f4671a;
            if (v00Var != null) {
                v00Var.a(this, i, i2, i3, i4);
            }
        }

        public void setAnimationMode(int i) {
            this.f4669a = i;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f4672a != null) {
                drawable = kd.r(drawable.mutate());
                kd.o(drawable, this.f4672a);
                kd.p(drawable, this.f4673a);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f4672a = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = kd.r(getBackground().mutate());
                kd.o(drawableR, colorStateList);
                kd.p(drawableR, this.f4673a);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f4673a = mode;
            if (getBackground() != null) {
                Drawable drawableR = kd.r(getBackground().mutate());
                kd.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        public void setOnAttachStateChangeListener(u00 u00Var) {
            this.f4670a = u00Var;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f8319a);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(v00 v00Var) {
            this.f4671a = v00Var;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        b = i >= 16 && i <= 19;
        f4653a = new int[]{zu.snackbarStyle};
        f4652a = BaseTransientBottomBar.class.getSimpleName();
        f8316a = new Handler(Looper.getMainLooper(), new j00());
    }

    public BaseTransientBottomBar(ViewGroup viewGroup, View view, x00 x00Var) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (x00Var == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f4660a = viewGroup;
        this.f4655a = x00Var;
        Context context = viewGroup.getContext();
        this.f4657a = context;
        dy.a(context);
        b bVar = (b) LayoutInflater.from(this.f4657a).inflate(z(), this.f4660a, false);
        this.f4663a = bVar;
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).c(bVar.getActionTextColorAlpha());
        }
        this.f4663a.addView(view);
        ViewGroup.LayoutParams layoutParams = this.f4663a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.f4658a = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        eh.l0(this.f4663a, 1);
        eh.t0(this.f4663a, 1);
        eh.r0(this.f4663a, true);
        eh.v0(this.f4663a, new l00(this));
        eh.k0(this.f4663a, new m00(this));
        this.f4661a = (AccessibilityManager) this.f4657a.getSystemService("accessibility");
    }

    public final int A() {
        int height = this.f4663a.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f4663a.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public final int B() {
        int[] iArr = new int[2];
        this.f4663a.getLocationOnScreen(iArr);
        return iArr[1] + this.f4663a.getHeight();
    }

    public boolean C() {
        TypedArray typedArrayObtainStyledAttributes = this.f4657a.obtainStyledAttributes(f4653a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public final void D(int i) {
        if (K() && this.f4663a.getVisibility() == 0) {
            q(i);
        } else {
            G(i);
        }
    }

    public boolean E() {
        return b10.c().e(this.f4656a);
    }

    public final boolean F() {
        ViewGroup.LayoutParams layoutParams = this.f4663a.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    public void G(int i) {
        b10.c().h(this.f4656a);
        List<t00<B>> list = this.f4665a;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4665a.get(size).a(this, i);
            }
        }
        ViewParent parent = this.f4663a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f4663a);
        }
    }

    public void H() {
        b10.c().i(this.f4656a);
        List<t00<B>> list = this.f4665a;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4665a.get(size).b(this);
            }
        }
    }

    public B I(int i) {
        this.f4654a = i;
        return this;
    }

    public final void J(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorW = this.f4662a;
        if (swipeDismissBehaviorW == null) {
            swipeDismissBehaviorW = w();
        }
        if (swipeDismissBehaviorW instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorW).P(this);
        }
        swipeDismissBehaviorW.K(new r00(this));
        fVar.o(swipeDismissBehaviorW);
        if (this.f4659a == null) {
            fVar.e = 80;
        }
    }

    public boolean K() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.f4661a.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public final boolean L() {
        return this.e > 0 && !this.f4666a && F();
    }

    public void M() {
        b10.c().m(v(), this.f4656a);
    }

    public final void N() {
        this.f4663a.setOnAttachStateChangeListener(new p00(this));
        if (this.f4663a.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f4663a.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                J((CoordinatorLayout.f) layoutParams);
            }
            this.f = r();
            T();
            this.f4663a.setVisibility(4);
            this.f4660a.addView(this.f4663a);
        }
        if (eh.Q(this.f4663a)) {
            O();
        } else {
            this.f4663a.setOnLayoutChangeListener(new q00(this));
        }
    }

    public final void O() {
        if (K()) {
            p();
        } else {
            this.f4663a.setVisibility(0);
            H();
        }
    }

    public final void P() {
        ValueAnimator valueAnimatorU = u(0.0f, 1.0f);
        ValueAnimator valueAnimatorX = x(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorU, valueAnimatorX);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new b00(this));
        animatorSet.start();
    }

    public final void Q(int i) {
        ValueAnimator valueAnimatorU = u(1.0f, 0.0f);
        valueAnimatorU.setDuration(75L);
        valueAnimatorU.addListener(new c00(this, i));
        valueAnimatorU.start();
    }

    public final void R() {
        int iA = A();
        if (b) {
            eh.W(this.f4663a, iA);
        } else {
            this.f4663a.setTranslationY(iA);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iA, 0);
        valueAnimator.setInterpolator(kv.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f00(this));
        valueAnimator.addUpdateListener(new g00(this, iA));
        valueAnimator.start();
    }

    public final void S(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, A());
        valueAnimator.setInterpolator(kv.b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new h00(this, i));
        valueAnimator.addUpdateListener(new i00(this));
        valueAnimator.start();
    }

    public final void T() {
        ViewGroup.LayoutParams layoutParams = this.f4663a.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.f4658a == null) {
            Log.w(f4652a, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        int i = this.f4659a != null ? this.f : this.f4667b;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = this.f4658a;
        marginLayoutParams.bottomMargin = rect.bottom + i;
        marginLayoutParams.leftMargin = rect.left + this.c;
        marginLayoutParams.rightMargin = rect.right + this.d;
        this.f4663a.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !L()) {
            return;
        }
        this.f4663a.removeCallbacks(this.f4664a);
        this.f4663a.post(this.f4664a);
    }

    public void p() {
        this.f4663a.post(new s00(this));
    }

    public final void q(int i) {
        if (this.f4663a.getAnimationMode() == 1) {
            Q(i);
        } else {
            S(i);
        }
    }

    public final int r() {
        View view = this.f4659a;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int[] iArr2 = new int[2];
        this.f4660a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f4660a.getHeight()) - i;
    }

    public void s() {
        t(3);
    }

    public void t(int i) {
        b10.c().b(this.f4656a, i);
    }

    public final ValueAnimator u(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(kv.f6644a);
        valueAnimatorOfFloat.addUpdateListener(new d00(this));
        return valueAnimatorOfFloat;
    }

    public int v() {
        return this.f4654a;
    }

    public SwipeDismissBehavior<? extends View> w() {
        return new Behavior();
    }

    public final ValueAnimator x(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(kv.d);
        valueAnimatorOfFloat.addUpdateListener(new e00(this));
        return valueAnimatorOfFloat;
    }

    public final int y() {
        WindowManager windowManager = (WindowManager) this.f4657a.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public int z() {
        return C() ? fv.mtrl_layout_snackbar : fv.design_layout_snackbar;
    }
}
