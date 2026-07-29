package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.j1;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import g.l0;
import g.n0;
import g.p0;
import g.r;
import g.t0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public static final int f19653k8 = 300;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public static final float f19656n8 = 0.2f;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public static final int f19657o8 = 0;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public static final int f19658p8 = 1;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public static final int f19659q8 = 0;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public static final int f19660r8 = 1;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final int f19661s8 = 0;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final int f19662t8 = 1;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final int f19663u8 = 0;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final int f19664v8 = 1;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static final int f19665w8 = -1;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public static final int f19666x8 = 0;

    @p0
    public Integer J7;
    public final le.j K7;

    @p0
    public Animator L7;

    @p0
    public Animator M7;
    public int N7;
    public int O7;
    public int P7;
    public final int Q7;

    @t0
    public int R7;
    public int S7;
    public final boolean T7;
    public boolean U7;
    public final boolean V7;
    public final boolean W7;
    public final boolean X7;
    public int Y7;
    public ArrayList<j> Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    @l0
    public int f19667a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public boolean f19668b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public boolean f19669c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public Behavior f19670d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public int f19671e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public int f19672f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public int f19673g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    @n0
    public AnimatorListenerAdapter f19674h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    @n0
    public kd.k<FloatingActionButton> f19675i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public static final int f19652j8 = R.style.Widget_MaterialComponents_BottomAppBar;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public static final int f19654l8 = R.attr.motionDurationLong2;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public static final int f19655m8 = R.attr.motionEasingEmphasizedInterpolator;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19681c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19682d;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @p0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f19681c);
            parcel.writeInt(this.f19682d ? 1 : 0);
        }

        public SavedState(@n0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f19681c = parcel.readInt();
            this.f19682d = parcel.readInt() != 0;
        }
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.f19668b8) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.X0(bottomAppBar.N7, BottomAppBar.this.f19669c8);
        }
    }

    public class b implements kd.k<FloatingActionButton> {
        public b() {
        }

        @Override // kd.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@n0 FloatingActionButton floatingActionButton) {
            BottomAppBar.this.K7.p0((floatingActionButton.getVisibility() == 0 && BottomAppBar.this.P7 == 1) ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // kd.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(@n0 FloatingActionButton floatingActionButton) {
            if (BottomAppBar.this.P7 != 1) {
                return;
            }
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().i() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().o(translationX);
                BottomAppBar.this.K7.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().d() != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().j(fMax);
                BottomAppBar.this.K7.invalidateSelf();
            }
            BottomAppBar.this.K7.p0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    public class c implements b0.e {
        public c() {
        }

        @Override // com.google.android.material.internal.b0.e
        @n0
        public j1 a(View view, @n0 j1 j1Var, @n0 b0.f fVar) {
            boolean z10;
            if (BottomAppBar.this.V7) {
                BottomAppBar.this.f19671e8 = j1Var.o();
            }
            boolean z11 = false;
            if (BottomAppBar.this.W7) {
                z10 = BottomAppBar.this.f19673g8 != j1Var.p();
                BottomAppBar.this.f19673g8 = j1Var.p();
            } else {
                z10 = false;
            }
            if (BottomAppBar.this.X7) {
                boolean z12 = BottomAppBar.this.f19672f8 != j1Var.q();
                BottomAppBar.this.f19672f8 = j1Var.q();
                z11 = z12;
            }
            if (z10 || z11) {
                BottomAppBar.this.J0();
                BottomAppBar.this.i1();
                BottomAppBar.this.h1();
            }
            return j1Var;
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.O0();
            BottomAppBar.this.L7 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.P0();
        }
    }

    public class e extends FloatingActionButton.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19687a;

        public class a extends FloatingActionButton.b {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.O0();
            }
        }

        public e(int i10) {
            this.f19687a = i10;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@n0 FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.T0(this.f19687a));
            floatingActionButton.y(new a());
        }
    }

    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.O0();
            BottomAppBar.this.f19668b8 = false;
            BottomAppBar.this.M7 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.P0();
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f19692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f19693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f19694d;

        public g(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f19692b = actionMenuView;
            this.f19693c = i10;
            this.f19694d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f19691a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f19691a) {
                return;
            }
            boolean z10 = BottomAppBar.this.f19667a8 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.g1(bottomAppBar.f19667a8);
            BottomAppBar.this.m1(this.f19692b, this.f19693c, this.f19694d, z10);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f19696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f19697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f19698c;

        public h(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f19696a = actionMenuView;
            this.f19697b = i10;
            this.f19698c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19696a.setTranslationX(BottomAppBar.this.S0(r0, this.f19697b, this.f19698c));
        }
    }

    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f19674h8.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonQ0 = BottomAppBar.this.Q0();
            if (floatingActionButtonQ0 != null) {
                floatingActionButtonQ0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    public interface j {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface l {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface m {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface n {
    }

    public BottomAppBar(@n0 Context context) {
        this(context, null);
    }

    @p0
    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f19671e8;
    }

    private int getFabAlignmentAnimationDuration() {
        return ee.a.f(getContext(), f19654l8, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return T0(this.N7);
    }

    private float getFabTranslationY() {
        if (this.P7 == 1) {
            return -getTopEdgeTreatment().d();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f19673g8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f19672f8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @n0
    public com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.K7.getShapeAppearanceModel().p();
    }

    public static void n1(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.g gVar = (CoordinatorLayout.g) view.getLayoutParams();
        gVar.f4556d = 17;
        int i10 = bottomAppBar.P7;
        if (i10 == 1) {
            gVar.f4556d = 17 | 48;
        }
        if (i10 == 0) {
            gVar.f4556d |= 80;
        }
    }

    public void G0(@n0 j jVar) {
        if (this.Z7 == null) {
            this.Z7 = new ArrayList<>();
        }
        this.Z7.add(jVar);
    }

    public final void H0(@n0 FloatingActionButton floatingActionButton) {
        floatingActionButton.d(this.f19674h8);
        floatingActionButton.e(new i());
        floatingActionButton.f(this.f19675i8);
    }

    public void I0(@n0 HideBottomViewOnScrollBehavior.b bVar) {
        getBehavior().H(bVar);
    }

    public final void J0() {
        Animator animator = this.M7;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.L7;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    public void K0() {
        getBehavior().J();
    }

    public void L0(int i10, List<Animator> list) {
        FloatingActionButton floatingActionButtonQ0 = Q0();
        if (floatingActionButtonQ0 == null || floatingActionButtonQ0.o()) {
            return;
        }
        P0();
        floatingActionButtonQ0.m(new e(i10));
    }

    public final void M0(int i10, @n0 List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(Q0(), "translationX", T0(i10));
        objectAnimatorOfFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(objectAnimatorOfFloat);
    }

    public final void N0(int i10, boolean z10, @n0 List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        animatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
        if (Math.abs(actionMenuView.getTranslationX() - S0(actionMenuView, i10, z10)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
            objectAnimatorOfFloat.addListener(new g(actionMenuView, i10, z10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    public final void O0() {
        ArrayList<j> arrayList;
        int i10 = this.Y7 - 1;
        this.Y7 = i10;
        if (i10 != 0 || (arrayList = this.Z7) == null) {
            return;
        }
        Iterator<j> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().b(this);
        }
    }

    public final void P0() {
        ArrayList<j> arrayList;
        int i10 = this.Y7;
        this.Y7 = i10 + 1;
        if (i10 != 0 || (arrayList = this.Z7) == null) {
            return;
        }
        Iterator<j> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().a(this);
        }
    }

    @p0
    public final FloatingActionButton Q0() {
        View viewR0 = R0();
        if (viewR0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewR0;
        }
        return null;
    }

    @p0
    public final View R0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).r(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public int S0(@n0 ActionMenuView actionMenuView, int i10, boolean z10) {
        int i11 = 0;
        if (this.S7 != 1 && (i10 != 1 || !z10)) {
            return 0;
        }
        boolean zL = b0.l(this);
        int measuredWidth = zL ? getMeasuredWidth() : 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).f1604a & androidx.core.view.m.f5027d) == 8388611) {
                measuredWidth = zL ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zL ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i13 = zL ? this.f19672f8 : -this.f19673g8;
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
            i11 = zL ? dimensionPixelOffset : -dimensionPixelOffset;
        }
        return measuredWidth - ((right + i13) + i11);
    }

    public final float T0(int i10) {
        boolean zL = b0.l(this);
        if (i10 != 1) {
            return 0.0f;
        }
        return ((getMeasuredWidth() / 2) - ((zL ? this.f19673g8 : this.f19672f8) + ((this.R7 == -1 || R0() == null) ? this.Q7 : (r6.getMeasuredWidth() / 2) + this.R7))) * (zL ? -1 : 1);
    }

    public final boolean U0() {
        FloatingActionButton floatingActionButtonQ0 = Q0();
        return floatingActionButtonQ0 != null && floatingActionButtonQ0.p();
    }

    public boolean V0() {
        return getBehavior().K();
    }

    public boolean W0() {
        return getBehavior().L();
    }

    public final void X0(int i10, boolean z10) {
        if (!u0.U0(this)) {
            this.f19668b8 = false;
            g1(this.f19667a8);
            return;
        }
        Animator animator = this.M7;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!U0()) {
            i10 = 0;
            z10 = false;
        }
        N0(i10, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.M7 = animatorSet;
        animatorSet.addListener(new f());
        this.M7.start();
    }

    public final void Y0(int i10) {
        if (this.N7 == i10 || !u0.U0(this)) {
            return;
        }
        Animator animator = this.L7;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.O7 == 1) {
            M0(i10, arrayList);
        } else {
            L0(i10, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(ee.a.g(getContext(), f19655m8, kd.a.f37166a));
        this.L7 = animatorSet;
        animatorSet.addListener(new d());
        this.L7.start();
    }

    @p0
    public final Drawable Z0(@p0 Drawable drawable) {
        if (drawable == null || this.J7 == null) {
            return drawable;
        }
        Drawable drawableR = n0.c.r(drawable.mutate());
        n0.c.n(drawableR, this.J7.intValue());
        return drawableR;
    }

    public void a1() {
        b1(true);
    }

    public void b1(boolean z10) {
        getBehavior().P(this, z10);
    }

    public void c1() {
        d1(true);
    }

    public void d1(boolean z10) {
        getBehavior().R(this, z10);
    }

    public void e1(@n0 j jVar) {
        ArrayList<j> arrayList = this.Z7;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(jVar);
    }

    public void f1(@n0 HideBottomViewOnScrollBehavior.b bVar) {
        getBehavior().M(bVar);
    }

    public void g1(@l0 int i10) {
        if (i10 != 0) {
            this.f19667a8 = 0;
            getMenu().clear();
            y(i10);
        }
    }

    @p0
    public ColorStateList getBackgroundTint() {
        return this.K7.R();
    }

    @r
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().d();
    }

    public int getFabAlignmentMode() {
        return this.N7;
    }

    @t0
    public int getFabAlignmentModeEndMargin() {
        return this.R7;
    }

    public int getFabAnchorMode() {
        return this.P7;
    }

    public int getFabAnimationMode() {
        return this.O7;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f();
    }

    @r
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().g();
    }

    public boolean getHideOnScroll() {
        return this.U7;
    }

    public int getMenuAlignmentMode() {
        return this.S7;
    }

    public final void h1() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.M7 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (U0()) {
            l1(actionMenuView, this.N7, this.f19669c8);
        } else {
            l1(actionMenuView, 0, false);
        }
    }

    public final void i1() {
        getTopEdgeTreatment().o(getFabTranslationX());
        this.K7.p0((this.f19669c8 && U0() && this.P7 == 1) ? 1.0f : 0.0f);
        View viewR0 = R0();
        if (viewR0 != null) {
            viewR0.setTranslationY(getFabTranslationY());
            viewR0.setTranslationX(getFabTranslationX());
        }
    }

    public void j1(int i10, @l0 int i11) {
        this.f19667a8 = i11;
        this.f19668b8 = true;
        X0(i10, this.f19669c8);
        Y0(i10);
        this.N7 = i10;
    }

    public boolean k1(@t0 int i10) {
        float f10 = i10;
        if (f10 == getTopEdgeTreatment().h()) {
            return false;
        }
        getTopEdgeTreatment().n(f10);
        this.K7.invalidateSelf();
        return true;
    }

    public final void l1(@n0 ActionMenuView actionMenuView, int i10, boolean z10) {
        m1(actionMenuView, i10, z10, false);
    }

    public final void m1(@n0 ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        h hVar = new h(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        le.k.f(this, this.K7);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            J0();
            i1();
        }
        h1();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.N7 = savedState.f19681c;
        this.f19669c8 = savedState.f19682d;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @n0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19681c = this.N7;
        savedState.f19682d = this.f19669c8;
        return savedState;
    }

    public void setBackgroundTint(@p0 ColorStateList colorStateList) {
        n0.c.o(this.K7, colorStateList);
    }

    public void setCradleVerticalOffset(@r float f10) {
        if (f10 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().j(f10);
            this.K7.invalidateSelf();
            i1();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        this.K7.n0(f10);
        getBehavior().N(this, this.K7.K() - this.K7.J());
    }

    public void setFabAlignmentMode(int i10) {
        j1(i10, 0);
    }

    public void setFabAlignmentModeEndMargin(@t0 int i10) {
        if (this.R7 != i10) {
            this.R7 = i10;
            i1();
        }
    }

    public void setFabAnchorMode(int i10) {
        this.P7 = i10;
        i1();
        View viewR0 = R0();
        if (viewR0 != null) {
            n1(this, viewR0);
            viewR0.requestLayout();
            this.K7.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i10) {
        this.O7 = i10;
    }

    public void setFabCornerSize(@r float f10) {
        if (f10 != getTopEdgeTreatment().e()) {
            getTopEdgeTreatment().k(f10);
            this.K7.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@r float f10) {
        if (f10 != getFabCradleMargin()) {
            getTopEdgeTreatment().l(f10);
            this.K7.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@r float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().m(f10);
            this.K7.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.U7 = z10;
    }

    public void setMenuAlignmentMode(int i10) {
        if (this.S7 != i10) {
            this.S7 = i10;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                l1(actionMenuView, this.N7, U0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@p0 Drawable drawable) {
        super.setNavigationIcon(Z0(drawable));
    }

    public void setNavigationIconTint(@g.l int i10) {
        this.J7 = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @n0
    public Behavior getBehavior() {
        if (this.f19670d8 == null) {
            this.f19670d8 = new Behavior();
        }
        return this.f19670d8;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @n0
        public final Rect f19676j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public WeakReference<BottomAppBar> f19677k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f19678l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final View.OnLayoutChangeListener f19679m;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f19677k.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.j(Behavior.this.f19676j);
                    int iHeight = Behavior.this.f19676j.height();
                    bottomAppBar.k1(iHeight);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f19676j)));
                    height = iHeight;
                }
                CoordinatorLayout.g gVar = (CoordinatorLayout.g) view.getLayoutParams();
                if (Behavior.this.f19678l == 0) {
                    int measuredHeight = (view.getMeasuredHeight() - height) / 2;
                    if (bottomAppBar.P7 == 1) {
                        ((ViewGroup.MarginLayoutParams) gVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - measuredHeight);
                    } else if (bottomAppBar.P7 == 0) {
                        ((ViewGroup.MarginLayoutParams) gVar).bottomMargin = ((bottomAppBar.getMeasuredHeight() + bottomAppBar.getBottomInset()) - view.getMeasuredHeight()) / 2;
                    }
                    ((ViewGroup.MarginLayoutParams) gVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) gVar).rightMargin = bottomAppBar.getRightInset();
                    if (b0.l(view)) {
                        ((ViewGroup.MarginLayoutParams) gVar).leftMargin += bottomAppBar.Q7;
                    } else {
                        ((ViewGroup.MarginLayoutParams) gVar).rightMargin += bottomAppBar.Q7;
                    }
                }
            }
        }

        public Behavior() {
            this.f19679m = new a();
            this.f19676j = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 BottomAppBar bottomAppBar, int i10) {
            this.f19677k = new WeakReference<>(bottomAppBar);
            View viewR0 = bottomAppBar.R0();
            if (viewR0 != null && !u0.U0(viewR0)) {
                BottomAppBar.n1(bottomAppBar, viewR0);
                this.f19678l = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.g) viewR0.getLayoutParams())).bottomMargin;
                if (viewR0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewR0;
                    if (bottomAppBar.P7 == 0 && bottomAppBar.T7) {
                        u0.N1(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.H0(floatingActionButton);
                }
                viewR0.addOnLayoutChangeListener(this.f19679m);
                bottomAppBar.i1();
            }
            coordinatorLayout.N(bottomAppBar, i10);
            return super.m(coordinatorLayout, bottomAppBar, i10);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
        public boolean B(@n0 CoordinatorLayout coordinatorLayout, @n0 BottomAppBar bottomAppBar, @n0 View view, @n0 View view2, int i10, int i11) {
            return bottomAppBar.getHideOnScroll() && super.B(coordinatorLayout, bottomAppBar, view, view2, i10, i11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f19679m = new a();
            this.f19676j = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f19652j8;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        le.j jVar = new le.j();
        this.K7 = jVar;
        this.Y7 = 0;
        this.f19667a8 = 0;
        this.f19668b8 = false;
        this.f19669c8 = true;
        this.f19674h8 = new a();
        this.f19675i8 = new b();
        Context context2 = getContext();
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.BottomAppBar, i10, i11, new int[0]);
        ColorStateList colorStateListA = ie.c.a(context2, typedArrayK, R.styleable.BottomAppBar_backgroundTint);
        int i12 = R.styleable.BottomAppBar_navigationIconTint;
        if (typedArrayK.hasValue(i12)) {
            setNavigationIconTint(typedArrayK.getColor(i12, -1));
        }
        int dimensionPixelSize = typedArrayK.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayK.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayK.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayK.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.N7 = typedArrayK.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.O7 = typedArrayK.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.P7 = typedArrayK.getInt(R.styleable.BottomAppBar_fabAnchorMode, 1);
        this.T7 = typedArrayK.getBoolean(R.styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.S7 = typedArrayK.getInt(R.styleable.BottomAppBar_menuAlignmentMode, 0);
        this.U7 = typedArrayK.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.V7 = typedArrayK.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.W7 = typedArrayK.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.X7 = typedArrayK.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.R7 = typedArrayK.getDimensionPixelOffset(R.styleable.BottomAppBar_fabAlignmentModeEndMargin, -1);
        typedArrayK.recycle();
        this.Q7 = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        jVar.setShapeAppearanceModel(o.a().G(new com.google.android.material.bottomappbar.a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).m());
        jVar.x0(2);
        jVar.r0(Paint.Style.FILL);
        jVar.Z(context2);
        setElevation(dimensionPixelSize);
        n0.c.o(jVar, colorStateListA);
        u0.I1(this, jVar);
        b0.c(this, attributeSet, i10, i11, new c());
    }
}
