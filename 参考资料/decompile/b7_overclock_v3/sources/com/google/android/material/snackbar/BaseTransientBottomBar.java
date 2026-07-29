package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.b0;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.a;
import g.d0;
import g.f0;
import g.i0;
import g.n0;
import g.p0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final int A = 150;
    public static final int B = 75;
    public static final float C = 0.8f;
    public static final int E = 0;
    public static final int F = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f20679t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f20680u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f20681v = -2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f20682w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f20683x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f20684y = 250;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f20685z = 180;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ViewGroup f20686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f20687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final w f20688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final me.a f20689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public q f20692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @v0(29)
    public final Runnable f20694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f20698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f20699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f20700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<s<B>> f20701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Behavior f20702q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public final AccessibilityManager f20703r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @n0
    public a.b f20704s;
    public static final boolean G = false;
    public static final int[] H = {R.attr.snackbarStyle};
    public static final String I = BaseTransientBottomBar.class.getSimpleName();

    @n0
    public static final Handler D = new Handler(Looper.getMainLooper(), new h());

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @n0
        public final t f20705t = new t(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean G(View view) {
            return this.f20705t.a(view);
        }

        public final void V(@n0 BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f20705t.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean l(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 MotionEvent motionEvent) {
            this.f20705t.b(coordinatorLayout, view, motionEvent);
            return super.l(coordinatorLayout, view, motionEvent);
        }
    }

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20706a;

        public a(int i10) {
            this.f20706a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.W(this.f20706a);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f20688c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f20688c.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f20688c.setScaleY(fFloatValue);
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.X();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f20689d.a(70, 180);
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20712b;

        public e(int i10) {
            this.f20712b = i10;
            this.f20711a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.G) {
                u0.f1(BaseTransientBottomBar.this.f20688c, iIntValue - this.f20711a);
            } else {
                BaseTransientBottomBar.this.f20688c.setTranslationY(iIntValue);
            }
            this.f20711a = iIntValue;
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20714a;

        public f(int i10) {
            this.f20714a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.W(this.f20714a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f20689d.b(0, 180);
        }
    }

    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20716a = 0;

        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.G) {
                u0.f1(BaseTransientBottomBar.this.f20688c, iIntValue - this.f20716a);
            } else {
                BaseTransientBottomBar.this.f20688c.setTranslationY(iIntValue);
            }
            this.f20716a = iIntValue;
        }
    }

    public class h implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@n0 Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                ((BaseTransientBottomBar) message.obj).l0();
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).N(message.arg1);
            return true;
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iH;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f20688c == null || baseTransientBottomBar.f20687b == null || (iH = (BaseTransientBottomBar.this.H() - BaseTransientBottomBar.this.L()) + ((int) BaseTransientBottomBar.this.f20688c.getTranslationY())) >= BaseTransientBottomBar.this.f20698m) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f20688c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                String unused = BaseTransientBottomBar.I;
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f20698m - iH;
            BaseTransientBottomBar.this.f20688c.requestLayout();
        }
    }

    public class j implements k0 {
        public j() {
        }

        @Override // androidx.core.view.k0
        @n0
        public j1 a(View view, @n0 j1 j1Var) {
            BaseTransientBottomBar.this.f20695j = j1Var.o();
            BaseTransientBottomBar.this.f20696k = j1Var.p();
            BaseTransientBottomBar.this.f20697l = j1Var.q();
            BaseTransientBottomBar.this.r0();
            return j1Var;
        }
    }

    public class k extends androidx.core.view.a {
        public k() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @n0 a1.d dVar) {
            super.g(view, dVar);
            dVar.a(1048576);
            dVar.i1(true);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (i10 != 1048576) {
                return super.j(view, i10, bundle);
            }
            BaseTransientBottomBar.this.x();
            return true;
        }
    }

    public class l implements a.b {
        public l() {
        }

        @Override // com.google.android.material.snackbar.a.b
        public void a() {
            Handler handler = BaseTransientBottomBar.D;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.a.b
        public void b(int i10) {
            Handler handler = BaseTransientBottomBar.D;
            handler.sendMessage(handler.obtainMessage(1, i10, 0, BaseTransientBottomBar.this));
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.W(3);
        }
    }

    public class n implements SwipeDismissBehavior.c {
        public n() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(@n0 View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.y(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i10) {
            if (i10 == 0) {
                com.google.android.material.snackbar.a.c().l(BaseTransientBottomBar.this.f20704s);
            } else if (i10 == 1 || i10 == 2) {
                com.google.android.material.snackbar.a.c().k(BaseTransientBottomBar.this.f20704s);
            }
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w wVar = BaseTransientBottomBar.this.f20688c;
            if (wVar == null) {
                return;
            }
            if (wVar.getParent() != null) {
                BaseTransientBottomBar.this.f20688c.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f20688c.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.n0();
            } else {
                BaseTransientBottomBar.this.p0();
            }
        }
    }

    public class p extends AnimatorListenerAdapter {
        public p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.X();
        }
    }

    public static class q implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final WeakReference<BaseTransientBottomBar> f20726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final WeakReference<View> f20727b;

        public q(@n0 BaseTransientBottomBar baseTransientBottomBar, @n0 View view) {
            this.f20726a = new WeakReference<>(baseTransientBottomBar);
            this.f20727b = new WeakReference<>(view);
        }

        public static q a(@n0 BaseTransientBottomBar baseTransientBottomBar, @n0 View view) {
            q qVar = new q(baseTransientBottomBar, view);
            if (u0.O0(view)) {
                b0.a(view, qVar);
            }
            view.addOnAttachStateChangeListener(qVar);
            return qVar;
        }

        @p0
        public View b() {
            return this.f20727b.get();
        }

        public void c() {
            if (this.f20727b.get() != null) {
                this.f20727b.get().removeOnAttachStateChangeListener(this);
                b0.n(this.f20727b.get(), this);
            }
            this.f20727b.clear();
            this.f20726a.clear();
        }

        public final boolean d() {
            if (this.f20726a.get() != null) {
                return false;
            }
            c();
            return true;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d() || !this.f20726a.get().f20693h) {
                return;
            }
            this.f20726a.get().Y();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (d()) {
                return;
            }
            b0.a(view, this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (d()) {
                return;
            }
            b0.n(view, this);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface r {
    }

    public static abstract class s<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f20728a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f20729b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f20730c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f20731d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f20732e = 4;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface a {
        }

        public void a(B b10, int i10) {
        }

        public void b(B b10) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a.b f20733a;

        public t(@n0 SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.R(0.1f);
            swipeDismissBehavior.O(0.6f);
            swipeDismissBehavior.S(0);
        }

        public boolean a(View view) {
            return view instanceof w;
        }

        public void b(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.A(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.a.c().k(this.f20733a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.a.c().l(this.f20733a);
            }
        }

        public void c(@n0 BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f20733a = baseTransientBottomBar.f20704s;
        }
    }

    @Deprecated
    public interface u extends me.a {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @f0(from = al.q.f769e)
    public @interface v {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class w extends FrameLayout {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final View.OnTouchListener f20734l = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public BaseTransientBottomBar<?> f20735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public le.o f20736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f20738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f20739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f20740f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f20741g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ColorStateList f20742h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PorterDuff.Mode f20743i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @p0
        public Rect f20744j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f20745k;

        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public w(@n0 Context context) {
            this(context, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f20735a = baseTransientBottomBar;
        }

        public void c(ViewGroup viewGroup) {
            this.f20745k = true;
            viewGroup.addView(this);
            this.f20745k = false;
        }

        @n0
        public final Drawable d() {
            int iP = vd.m.p(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            le.o oVar = this.f20736b;
            Drawable drawableW = oVar != null ? BaseTransientBottomBar.w(iP, oVar) : BaseTransientBottomBar.v(iP, getResources());
            if (this.f20742h == null) {
                return n0.c.r(drawableW);
            }
            Drawable drawableR = n0.c.r(drawableW);
            n0.c.o(drawableR, this.f20742h);
            return drawableR;
        }

        public final void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f20744j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        public float getActionTextColorAlpha() {
            return this.f20739e;
        }

        public int getAnimationMode() {
            return this.f20737c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f20738d;
        }

        public int getMaxInlineActionWidth() {
            return this.f20741g;
        }

        public int getMaxWidth() {
            return this.f20740f;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f20735a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.T();
            }
            u0.v1(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f20735a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.U();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f20735a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.V();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (this.f20740f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = this.f20740f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        public void setAnimationMode(int i10) {
            this.f20737c = i10;
        }

        @Override // android.view.View
        public void setBackground(@p0 Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@p0 Drawable drawable) {
            if (drawable != null && this.f20742h != null) {
                drawable = n0.c.r(drawable.mutate());
                n0.c.o(drawable, this.f20742h);
                n0.c.p(drawable, this.f20743i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@p0 ColorStateList colorStateList) {
            this.f20742h = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = n0.c.r(getBackground().mutate());
                n0.c.o(drawableR, colorStateList);
                n0.c.p(drawableR, this.f20743i);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@p0 PorterDuff.Mode mode) {
            this.f20743i = mode;
            if (getBackground() != null) {
                Drawable drawableR = n0.c.r(getBackground().mutate());
                n0.c.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f20745k || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            e((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f20735a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.r0();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(@p0 View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f20734l);
            super.setOnClickListener(onClickListener);
        }

        public w(@n0 Context context, AttributeSet attributeSet) {
            super(pe.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                u0.N1(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(r2, 0));
            }
            this.f20737c = typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearance) || typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_shapeAppearanceOverlay)) {
                this.f20736b = le.o.e(context2, attributeSet, 0, 0).m();
            }
            this.f20738d = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(ie.c.a(context2, typedArrayObtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(b0.m(typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f20739e = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f20740f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
            this.f20741g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f20734l);
            setFocusable(true);
            if (getBackground() == null) {
                u0.I1(this, d());
            }
        }
    }

    public BaseTransientBottomBar(@n0 ViewGroup viewGroup, @n0 View view, @n0 me.a aVar) {
        this(viewGroup.getContext(), viewGroup, view, aVar);
    }

    @n0
    public static GradientDrawable v(@g.l int i10, @n0 Resources resources) {
        float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }

    @n0
    public static le.j w(@g.l int i10, @n0 le.o oVar) {
        le.j jVar = new le.j(oVar);
        jVar.o0(ColorStateList.valueOf(i10));
        return jVar;
    }

    @p0
    public View A() {
        q qVar = this.f20692g;
        if (qVar == null) {
            return null;
        }
        return qVar.b();
    }

    public int B() {
        return this.f20688c.getAnimationMode();
    }

    public Behavior C() {
        return this.f20702q;
    }

    @n0
    public Context D() {
        return this.f20687b;
    }

    public int E() {
        return this.f20690e;
    }

    @n0
    public SwipeDismissBehavior<? extends View> F() {
        return new Behavior();
    }

    public final ValueAnimator G(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(kd.a.f37169d);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    @v0(17)
    public final int H() {
        WindowManager windowManager = (WindowManager) this.f20687b.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @i0
    public int I() {
        return M() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    public final int J() {
        int height = this.f20688c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f20688c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    @n0
    public View K() {
        return this.f20688c;
    }

    public final int L() {
        int[] iArr = new int[2];
        this.f20688c.getLocationOnScreen(iArr);
        return iArr[1] + this.f20688c.getHeight();
    }

    public boolean M() {
        TypedArray typedArrayObtainStyledAttributes = this.f20687b.obtainStyledAttributes(H);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public final void N(int i10) {
        if (i0() && this.f20688c.getVisibility() == 0) {
            t(i10);
        } else {
            W(i10);
        }
    }

    public boolean O() {
        return this.f20693h;
    }

    public boolean P() {
        return this.f20691f;
    }

    public boolean Q() {
        return com.google.android.material.snackbar.a.c().e(this.f20704s);
    }

    public boolean R() {
        return com.google.android.material.snackbar.a.c().f(this.f20704s);
    }

    public final boolean S() {
        ViewGroup.LayoutParams layoutParams = this.f20688c.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.g) && (((CoordinatorLayout.g) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    public void T() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.f20688c.getRootWindowInsets()) == null) {
            return;
        }
        this.f20698m = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        r0();
    }

    public void U() {
        if (R()) {
            D.post(new m());
        }
    }

    public void V() {
        if (this.f20700o) {
            m0();
            this.f20700o = false;
        }
    }

    public void W(int i10) {
        com.google.android.material.snackbar.a.c().i(this.f20704s);
        List<s<B>> list = this.f20701p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f20701p.get(size).a(this, i10);
            }
        }
        ViewParent parent = this.f20688c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f20688c);
        }
    }

    public void X() {
        com.google.android.material.snackbar.a.c().j(this.f20704s);
        List<s<B>> list = this.f20701p;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f20701p.get(size).b(this);
            }
        }
    }

    public final void Y() {
        int iU = u();
        if (iU == this.f20699n) {
            return;
        }
        this.f20699n = iU;
        r0();
    }

    @n0
    public B Z(@p0 s<B> sVar) {
        List<s<B>> list;
        if (sVar == null || (list = this.f20701p) == null) {
            return this;
        }
        list.remove(sVar);
        return this;
    }

    @n0
    public B a0(@d0 int i10) {
        View viewFindViewById = this.f20686a.findViewById(i10);
        if (viewFindViewById != null) {
            return (B) b0(viewFindViewById);
        }
        throw new IllegalArgumentException("Unable to find anchor view with id: " + i10);
    }

    @n0
    public B b0(@p0 View view) {
        q qVar = this.f20692g;
        if (qVar != null) {
            qVar.c();
        }
        this.f20692g = view == null ? null : q.a(this, view);
        return this;
    }

    public void c0(boolean z10) {
        this.f20693h = z10;
    }

    @n0
    public B d0(int i10) {
        this.f20688c.setAnimationMode(i10);
        return this;
    }

    @n0
    public B e0(Behavior behavior) {
        this.f20702q = behavior;
        return this;
    }

    @n0
    public B f0(int i10) {
        this.f20690e = i10;
        return this;
    }

    @n0
    public B g0(boolean z10) {
        this.f20691f = z10;
        return this;
    }

    public final void h0(CoordinatorLayout.g gVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorF = this.f20702q;
        if (swipeDismissBehaviorF == null) {
            swipeDismissBehaviorF = F();
        }
        if (swipeDismissBehaviorF instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorF).V(this);
        }
        swipeDismissBehaviorF.P(new n());
        gVar.q(swipeDismissBehaviorF);
        if (A() == null) {
            gVar.f4559g = 80;
        }
    }

    public boolean i0() {
        AccessibilityManager accessibilityManager = this.f20703r;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public final boolean j0() {
        return this.f20698m > 0 && !this.f20691f && S();
    }

    public void k0() {
        com.google.android.material.snackbar.a.c().n(E(), this.f20704s);
    }

    public final void l0() {
        if (this.f20688c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f20688c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.g) {
                h0((CoordinatorLayout.g) layoutParams);
            }
            this.f20688c.c(this.f20686a);
            Y();
            this.f20688c.setVisibility(4);
        }
        if (u0.U0(this.f20688c)) {
            m0();
        } else {
            this.f20700o = true;
        }
    }

    public final void m0() {
        if (i0()) {
            s();
            return;
        }
        if (this.f20688c.getParent() != null) {
            this.f20688c.setVisibility(0);
        }
        X();
    }

    public final void n0() {
        ValueAnimator valueAnimatorZ = z(0.0f, 1.0f);
        ValueAnimator valueAnimatorG = G(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorZ, valueAnimatorG);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new p());
        animatorSet.start();
    }

    public final void o0(int i10) {
        ValueAnimator valueAnimatorZ = z(1.0f, 0.0f);
        valueAnimatorZ.setDuration(75L);
        valueAnimatorZ.addListener(new a(i10));
        valueAnimatorZ.start();
    }

    public final void p0() {
        int iJ = J();
        if (G) {
            u0.f1(this.f20688c, iJ);
        } else {
            this.f20688c.setTranslationY(iJ);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iJ, 0);
        valueAnimator.setInterpolator(kd.a.f37167b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(iJ));
        valueAnimator.start();
    }

    public final void q0(int i10) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, J());
        valueAnimator.setInterpolator(kd.a.f37167b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f(i10));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    @n0
    public B r(@p0 s<B> sVar) {
        if (sVar == null) {
            return this;
        }
        if (this.f20701p == null) {
            this.f20701p = new ArrayList();
        }
        this.f20701p.add(sVar);
        return this;
    }

    public final void r0() {
        ViewGroup.LayoutParams layoutParams = this.f20688c.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.f20688c.f20744j == null || this.f20688c.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = this.f20688c.f20744j.bottom + (A() != null ? this.f20699n : this.f20695j);
        marginLayoutParams.leftMargin = this.f20688c.f20744j.left + this.f20696k;
        marginLayoutParams.rightMargin = this.f20688c.f20744j.right + this.f20697l;
        marginLayoutParams.topMargin = this.f20688c.f20744j.top;
        this.f20688c.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !j0()) {
            return;
        }
        this.f20688c.removeCallbacks(this.f20694i);
        this.f20688c.post(this.f20694i);
    }

    public void s() {
        this.f20688c.post(new o());
    }

    public final void t(int i10) {
        if (this.f20688c.getAnimationMode() == 1) {
            o0(i10);
        } else {
            q0(i10);
        }
    }

    public final int u() {
        if (A() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        A().getLocationOnScreen(iArr);
        int i10 = iArr[1];
        int[] iArr2 = new int[2];
        this.f20686a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f20686a.getHeight()) - i10;
    }

    public void x() {
        y(3);
    }

    public void y(int i10) {
        com.google.android.material.snackbar.a.c().b(this.f20704s, i10);
    }

    public final ValueAnimator z(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(kd.a.f37166a);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    public BaseTransientBottomBar(@n0 Context context, @n0 ViewGroup viewGroup, @n0 View view, @n0 me.a aVar) {
        this.f20693h = false;
        this.f20694i = new i();
        this.f20704s = new l();
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f20686a = viewGroup;
        this.f20689d = aVar;
        this.f20687b = context;
        com.google.android.material.internal.t.a(context);
        w wVar = (w) LayoutInflater.from(context).inflate(I(), viewGroup, false);
        this.f20688c = wVar;
        wVar.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
            snackbarContentLayout.c(wVar.getActionTextColorAlpha());
            snackbarContentLayout.setMaxInlineActionWidth(wVar.getMaxInlineActionWidth());
        }
        wVar.addView(view);
        u0.D1(wVar, 1);
        u0.R1(wVar, 1);
        u0.O1(wVar, true);
        u0.a2(wVar, new j());
        u0.B1(wVar, new k());
        this.f20703r = (AccessibilityManager) context.getSystemService("accessibility");
    }
}
