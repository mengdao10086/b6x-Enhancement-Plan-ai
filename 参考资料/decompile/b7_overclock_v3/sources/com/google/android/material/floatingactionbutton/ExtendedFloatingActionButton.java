package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.t;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.i1;
import g.n0;
import g.p0;
import java.util.Iterator;
import java.util.List;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    public static final int G7 = 0;
    public static final int H7 = 1;
    public static final int I7 = 2;
    public int A;
    public final be.a B;

    @n0
    public final com.google.android.material.floatingactionbutton.b C;
    public int C1;
    public boolean C2;

    @n0
    public final com.google.android.material.floatingactionbutton.b D;

    @n0
    public ColorStateList E7;
    public final com.google.android.material.floatingactionbutton.b K0;

    @n0
    public final CoordinatorLayout.c<ExtendedFloatingActionButton> K1;
    public boolean K2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final com.google.android.material.floatingactionbutton.b f20172k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final int f20173k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f20174v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f20175v2;
    public static final int F7 = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> J7 = new d(Float.class, SocializeProtocolConstants.WIDTH);
    public static final Property<View, Float> K7 = new e(Float.class, SocializeProtocolConstants.HEIGHT);
    public static final Property<View, Float> L7 = new f(Float.class, "paddingStart");
    public static final Property<View, Float> M7 = new g(Float.class, "paddingEnd");

    public class a implements l {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.C1;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f20174v1;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.f20174v1 + ExtendedFloatingActionButton.this.C1;
        }
    }

    public class b implements l {
        public b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams a() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.floatingactionbutton.b f20186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f20187c;

        public c(com.google.android.material.floatingactionbutton.b bVar, j jVar) {
            this.f20186b = bVar;
            this.f20187c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f20185a = true;
            this.f20186b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f20186b.i();
            if (this.f20185a) {
                return;
            }
            this.f20186b.m(this.f20187c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f20186b.onAnimationStart(animator);
            this.f20185a = false;
        }
    }

    public class d extends Property<View, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@n0 View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@n0 View view, @n0 Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    public class e extends Property<View, Float> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@n0 View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@n0 View view, @n0 Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    public class f extends Property<View, Float> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@n0 View view) {
            return Float.valueOf(u0.k0(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@n0 View view, @n0 Float f10) {
            u0.d2(view, f10.intValue(), view.getPaddingTop(), u0.j0(view), view.getPaddingBottom());
        }
    }

    public class g extends Property<View, Float> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@n0 View view) {
            return Float.valueOf(u0.j0(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@n0 View view, @n0 Float f10) {
            u0.d2(view, u0.k0(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    public class h extends be.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final l f20189g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f20190h;

        public h(be.a aVar, l lVar, boolean z10) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f20189g = lVar;
            this.f20190h = z10;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int c() {
            return this.f20190h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void d() {
            ExtendedFloatingActionButton.this.f20175v2 = this.f20190h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f20189g.a().width;
            layoutParams.height = this.f20189g.a().height;
            u0.d2(ExtendedFloatingActionButton.this, this.f20189g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f20189g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean f() {
            return this.f20190h == ExtendedFloatingActionButton.this.f20175v2 || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // be.b, com.google.android.material.floatingactionbutton.b
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.C2 = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f20189g.a().width;
            layoutParams.height = this.f20189g.a().height;
        }

        @Override // be.b, com.google.android.material.floatingactionbutton.b
        @n0
        public AnimatorSet k() {
            kd.h hVarB = b();
            if (hVarB.j(SocializeProtocolConstants.WIDTH)) {
                PropertyValuesHolder[] propertyValuesHolderArrG = hVarB.g(SocializeProtocolConstants.WIDTH);
                propertyValuesHolderArrG[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f20189g.getWidth());
                hVarB.l(SocializeProtocolConstants.WIDTH, propertyValuesHolderArrG);
            }
            if (hVarB.j(SocializeProtocolConstants.HEIGHT)) {
                PropertyValuesHolder[] propertyValuesHolderArrG2 = hVarB.g(SocializeProtocolConstants.HEIGHT);
                propertyValuesHolderArrG2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f20189g.getHeight());
                hVarB.l(SocializeProtocolConstants.HEIGHT, propertyValuesHolderArrG2);
            }
            if (hVarB.j("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrG3 = hVarB.g("paddingStart");
                propertyValuesHolderArrG3[0].setFloatValues(u0.k0(ExtendedFloatingActionButton.this), this.f20189g.getPaddingStart());
                hVarB.l("paddingStart", propertyValuesHolderArrG3);
            }
            if (hVarB.j("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrG4 = hVarB.g("paddingEnd");
                propertyValuesHolderArrG4[0].setFloatValues(u0.j0(ExtendedFloatingActionButton.this), this.f20189g.getPaddingEnd());
                hVarB.l("paddingEnd", propertyValuesHolderArrG4);
            }
            if (hVarB.j("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrG5 = hVarB.g("labelOpacity");
                boolean z10 = this.f20190h;
                propertyValuesHolderArrG5[0].setFloatValues(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
                hVarB.l("labelOpacity", propertyValuesHolderArrG5);
            }
            return super.o(hVarB);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void m(@p0 j jVar) {
            if (jVar == null) {
                return;
            }
            if (this.f20190h) {
                jVar.a(ExtendedFloatingActionButton.this);
            } else {
                jVar.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // be.b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.f20175v2 = this.f20190h;
            ExtendedFloatingActionButton.this.C2 = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    public class i extends be.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f20192g;

        public i(be.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // be.b, com.google.android.material.floatingactionbutton.b
        public void a() {
            super.a();
            this.f20192g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int c() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean f() {
            return ExtendedFloatingActionButton.this.M();
        }

        @Override // be.b, com.google.android.material.floatingactionbutton.b
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.A = 0;
            if (this.f20192g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void m(@p0 j jVar) {
            if (jVar != null) {
                jVar.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // be.b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f20192g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.A = 1;
        }
    }

    public static abstract class j {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    public class k extends be.b {
        public k(be.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int c() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean f() {
            return ExtendedFloatingActionButton.this.N();
        }

        @Override // be.b, com.google.android.material.floatingactionbutton.b
        public void i() {
            super.i();
            ExtendedFloatingActionButton.this.A = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void m(@p0 j jVar) {
            if (jVar != null) {
                jVar.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // be.b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.A = 2;
        }
    }

    public interface l {
        ViewGroup.LayoutParams a();

        int getHeight();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@n0 Context context) {
        this(context, null);
    }

    public void D(@n0 Animator.AnimatorListener animatorListener) {
        this.D.h(animatorListener);
    }

    public void E(@n0 Animator.AnimatorListener animatorListener) {
        this.K0.h(animatorListener);
    }

    public void F(@n0 Animator.AnimatorListener animatorListener) {
        this.f20172k0.h(animatorListener);
    }

    public void G(@n0 Animator.AnimatorListener animatorListener) {
        this.C.h(animatorListener);
    }

    public void H() {
        O(this.D, null);
    }

    public void I(@n0 j jVar) {
        O(this.D, jVar);
    }

    public void J() {
        O(this.K0, null);
    }

    public void K(@n0 j jVar) {
        O(this.K0, jVar);
    }

    public final boolean L() {
        return this.f20175v2;
    }

    public final boolean M() {
        return getVisibility() == 0 ? this.A == 1 : this.A != 2;
    }

    public final boolean N() {
        return getVisibility() != 0 ? this.A == 2 : this.A != 1;
    }

    public final void O(@n0 com.google.android.material.floatingactionbutton.b bVar, @p0 j jVar) {
        if (bVar.f()) {
            return;
        }
        if (!U()) {
            bVar.d();
            bVar.m(jVar);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetK = bVar.k();
        animatorSetK.addListener(new c(bVar, jVar));
        Iterator<Animator.AnimatorListener> it2 = bVar.l().iterator();
        while (it2.hasNext()) {
            animatorSetK.addListener(it2.next());
        }
        animatorSetK.start();
    }

    public void P(@n0 Animator.AnimatorListener animatorListener) {
        this.D.g(animatorListener);
    }

    public void Q(@n0 Animator.AnimatorListener animatorListener) {
        this.K0.g(animatorListener);
    }

    public void R(@n0 Animator.AnimatorListener animatorListener) {
        this.f20172k0.g(animatorListener);
    }

    public void S(@n0 Animator.AnimatorListener animatorListener) {
        this.C.g(animatorListener);
    }

    public final void T() {
        this.E7 = getTextColors();
    }

    public final boolean U() {
        return (u0.U0(this) || (!N() && this.K2)) && !isInEditMode();
    }

    public void V() {
        O(this.f20172k0, null);
    }

    public void W(@n0 j jVar) {
        O(this.f20172k0, jVar);
    }

    public void X() {
        O(this.C, null);
    }

    public void Y(@n0 j jVar) {
        O(this.C, jVar);
    }

    public void Z(@n0 ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @n0
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.K1;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @i1
    public int getCollapsedSize() {
        int i10 = this.f20173k1;
        return i10 < 0 ? (Math.min(u0.k0(this), u0.j0(this)) * 2) + getIconSize() : i10;
    }

    @p0
    public kd.h getExtendMotionSpec() {
        return this.D.e();
    }

    @p0
    public kd.h getHideMotionSpec() {
        return this.K0.e();
    }

    @p0
    public kd.h getShowMotionSpec() {
        return this.f20172k0.e();
    }

    @p0
    public kd.h getShrinkMotionSpec() {
        return this.C.e();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f20175v2 && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f20175v2 = false;
            this.C.d();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.K2 = z10;
    }

    public void setExtendMotionSpec(@p0 kd.h hVar) {
        this.D.j(hVar);
    }

    public void setExtendMotionSpecResource(@g.b int i10) {
        setExtendMotionSpec(kd.h.d(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        if (this.f20175v2 == z10) {
            return;
        }
        com.google.android.material.floatingactionbutton.b bVar = z10 ? this.D : this.C;
        if (bVar.f()) {
            return;
        }
        bVar.d();
    }

    public void setHideMotionSpec(@p0 kd.h hVar) {
        this.K0.j(hVar);
    }

    public void setHideMotionSpecResource(@g.b int i10) {
        setHideMotionSpec(kd.h.d(getContext(), i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (!this.f20175v2 || this.C2) {
            return;
        }
        this.f20174v1 = u0.k0(this);
        this.C1 = u0.j0(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        if (!this.f20175v2 || this.C2) {
            return;
        }
        this.f20174v1 = i10;
        this.C1 = i12;
    }

    public void setShowMotionSpec(@p0 kd.h hVar) {
        this.f20172k0.j(hVar);
    }

    public void setShowMotionSpecResource(@g.b int i10) {
        setShowMotionSpec(kd.h.d(getContext(), i10));
    }

    public void setShrinkMotionSpec(@p0 kd.h hVar) {
        this.C.j(hVar);
    }

    public void setShrinkMotionSpecResource(@g.b int i10) {
        setShrinkMotionSpec(kd.h.d(getContext(), i10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        T();
    }

    public ExtendedFloatingActionButton(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final boolean f20176f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final boolean f20177g = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f20178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public j f20179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public j f20180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f20181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f20182e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f20181d = false;
            this.f20182e = true;
        }

        public static boolean K(@n0 View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.g) {
                return ((CoordinatorLayout.g) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public void G(@n0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z10 = this.f20182e;
            extendedFloatingActionButton.O(z10 ? extendedFloatingActionButton.D : extendedFloatingActionButton.f20172k0, z10 ? this.f20180c : this.f20179b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean b(@n0 CoordinatorLayout coordinatorLayout, @n0 ExtendedFloatingActionButton extendedFloatingActionButton, @n0 Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean I() {
            return this.f20181d;
        }

        public boolean J() {
            return this.f20182e;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean i(CoordinatorLayout coordinatorLayout, @n0 ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                T(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!K(view)) {
                return false;
            }
            U(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List<View> listQ = coordinatorLayout.q(extendedFloatingActionButton);
            int size = listQ.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = listQ.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (K(view) && U(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (T(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.N(extendedFloatingActionButton, i10);
            return true;
        }

        public void N(boolean z10) {
            this.f20181d = z10;
        }

        public void O(boolean z10) {
            this.f20182e = z10;
        }

        @i1
        public void P(@p0 j jVar) {
            this.f20179b = jVar;
        }

        @i1
        public void Q(@p0 j jVar) {
            this.f20180c = jVar;
        }

        public final boolean R(@n0 View view, @n0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f20181d || this.f20182e) && ((CoordinatorLayout.g) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        public void S(@n0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z10 = this.f20182e;
            extendedFloatingActionButton.O(z10 ? extendedFloatingActionButton.C : extendedFloatingActionButton.K0, z10 ? this.f20180c : this.f20179b);
        }

        public final boolean T(CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, @n0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!R(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f20178a == null) {
                this.f20178a = new Rect();
            }
            Rect rect = this.f20178a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                S(extendedFloatingActionButton);
                return true;
            }
            G(extendedFloatingActionButton);
            return true;
        }

        public final boolean U(@n0 View view, @n0 ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!R(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.g) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                S(extendedFloatingActionButton);
                return true;
            }
            G(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void h(@n0 CoordinatorLayout.g gVar) {
            if (gVar.f4560h == 0) {
                gVar.f4560h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@n0 Context context, @p0 AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f20181d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f20182e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = F7;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.A = 0;
        be.a aVar = new be.a();
        this.B = aVar;
        k kVar = new k(aVar);
        this.f20172k0 = kVar;
        i iVar = new i(aVar);
        this.K0 = iVar;
        this.f20175v2 = true;
        this.C2 = false;
        this.K2 = false;
        Context context2 = getContext();
        this.K1 = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.ExtendedFloatingActionButton, i10, i11, new int[0]);
        kd.h hVarC = kd.h.c(context2, typedArrayK, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        kd.h hVarC2 = kd.h.c(context2, typedArrayK, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        kd.h hVarC3 = kd.h.c(context2, typedArrayK, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        kd.h hVarC4 = kd.h.c(context2, typedArrayK, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.f20173k1 = typedArrayK.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.f20174v1 = u0.k0(this);
        this.C1 = u0.j0(this);
        be.a aVar2 = new be.a();
        h hVar = new h(aVar2, new a(), true);
        this.D = hVar;
        h hVar2 = new h(aVar2, new b(), false);
        this.C = hVar2;
        kVar.j(hVarC);
        iVar.j(hVarC2);
        hVar.j(hVarC3);
        hVar2.j(hVarC4);
        typedArrayK.recycle();
        setShapeAppearanceModel(o.g(context2, attributeSet, i10, i11, o.f39664m).m());
        T();
    }

    @Override // android.widget.TextView
    public void setTextColor(@n0 ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        T();
    }
}
