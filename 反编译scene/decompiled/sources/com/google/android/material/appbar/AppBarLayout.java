package com.google.android.material.appbar;

import a.ak;
import a.bj;
import a.bv;
import a.dy;
import a.eh;
import a.ev;
import a.hg;
import a.iv;
import a.iz;
import a.jv;
import a.jz;
import a.kd;
import a.kf;
import a.kv;
import a.ng;
import a.ni;
import a.r2;
import a.r20;
import a.sd;
import a.sh;
import a.sv;
import a.ti;
import a.tv;
import a.uv;
import a.xv;
import a.zu;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public static final int g = iv.Widget_Design_AppBarLayout;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sh f4536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f4537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<View> f4539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<c> f4540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f4541a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4542b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4543c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4544d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4545e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4546f;

    public static class BaseBehavior<T extends AppBarLayout> extends tv<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8272a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ValueAnimator f4547a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public d f4548a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WeakReference<View> f4549a;
        public boolean b;
        public int f;
        public int g;
        public int h;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f8273a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ AppBarLayout f4551a;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f8273a = coordinatorLayout;
                this.f4551a = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.f8273a, this.f4551a, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public class b implements bj {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f8274a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ View f4552a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ CoordinatorLayout f4553a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ AppBarLayout f4555a;

            public b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
                this.f4553a = coordinatorLayout;
                this.f4555a = appBarLayout;
                this.f4552a = view;
                this.f8274a = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // a.bj
            public boolean a(View view, ti tiVar) {
                BaseBehavior.this.q(this.f4553a, this.f4555a, this.f4552a, 0, this.f8274a, new int[]{0, 0}, 1);
                return true;
            }
        }

        public class c implements bj {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f8275a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ boolean f4556a;

            public c(BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
                this.f8275a = appBarLayout;
                this.f4556a = z;
            }

            @Override // a.bj
            public boolean a(View view, ti tiVar) {
                this.f8275a.setExpanded(this.f4556a);
                return true;
            }
        }

        public static abstract class d<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public static class e extends ak {
            public static final Parcelable.Creator<e> CREATOR = new sv();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public float f8276a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public int f4557a;
            public boolean b;

            public e(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f4557a = parcel.readInt();
                this.f8276a = parcel.readFloat();
                this.b = parcel.readByte() != 0;
            }

            public e(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // a.ak, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f4557a);
                parcel.writeFloat(this.f8276a);
                parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.h = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
        }

        public static boolean Y(int i, int i2) {
            return (i & i2) == i2;
        }

        public static View a0(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // a.tv
        public int M() {
            return E() + this.f;
        }

        public final void S(CoordinatorLayout coordinatorLayout, T t, View view) {
            if (M() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
                T(coordinatorLayout, t, ni.a.d, false);
            }
            if (M() != 0) {
                if (!view.canScrollVertically(-1)) {
                    T(coordinatorLayout, t, ni.a.e, true);
                    return;
                }
                int i = -t.getDownNestedPreScrollRange();
                if (i != 0) {
                    eh.g0(coordinatorLayout, ni.a.e, null, new b(coordinatorLayout, t, view, i));
                }
            }
        }

        public final void T(CoordinatorLayout coordinatorLayout, T t, ni.a aVar, boolean z) {
            eh.g0(coordinatorLayout, aVar, null, new c(this, t, z));
        }

        public final void U(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int iAbs = Math.abs(M() - i);
            float fAbs = Math.abs(f);
            V(coordinatorLayout, t, i, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t.getHeight()) + 1.0f) * 150.0f));
        }

        public final void V(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            int iM = M();
            if (iM == i) {
                ValueAnimator valueAnimator = this.f4547a;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f4547a.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f4547a;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f4547a = valueAnimator3;
                valueAnimator3.setInterpolator(kv.e);
                this.f4547a.addUpdateListener(new a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.f4547a.setDuration(Math.min(i2, 600));
            this.f4547a.setIntValues(iM, i);
            this.f4547a.start();
        }

        @Override // a.tv
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public boolean H(T t) {
            d dVar = this.f4548a;
            if (dVar != null) {
                return dVar.a(t);
            }
            WeakReference<View> weakReference = this.f4549a;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        public final boolean X(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.h() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        public final View Z(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof hg) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final int b0(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                d dVar = (d) childAt.getLayoutParams();
                if (Y(dVar.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) dVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) dVar).bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // a.tv
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
        public int K(T t) {
            return -t.getDownNestedScrollRange();
        }

        @Override // a.tv
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public int L(T t) {
            return t.getTotalScrollRange();
        }

        public final int e0(T t, int i) {
            int iAbs = Math.abs(i);
            int childCount = t.getChildCount();
            int topInset = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i2);
                d dVar = (d) childAt.getLayoutParams();
                Interpolator interpolatorB = dVar.b();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i2++;
                } else if (interpolatorB != null) {
                    int iA = dVar.a();
                    if ((iA & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                        if ((iA & 2) != 0) {
                            topInset -= eh.z(childAt);
                        }
                    }
                    if (eh.v(childAt)) {
                        topInset -= t.getTopInset();
                    }
                    if (topInset > 0) {
                        float f = topInset;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * interpolatorB.getInterpolation((iAbs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        @Override // a.tv
        /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
        public void N(CoordinatorLayout coordinatorLayout, T t) {
            q0(coordinatorLayout, t);
            if (t.j()) {
                t.q(t.s(Z(coordinatorLayout)));
            }
        }

        @Override // a.vv, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, T t, int i) {
            boolean zL = super.l(coordinatorLayout, t, i);
            int pendingAction = t.getPendingAction();
            int i2 = this.h;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i2);
                P(coordinatorLayout, t, (-childAt.getBottom()) + (this.b ? eh.z(childAt) + t.getTopInset() : Math.round(childAt.getHeight() * this.f8272a)));
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        U(coordinatorLayout, t, i3, 0.0f);
                    } else {
                        P(coordinatorLayout, t, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        U(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        P(coordinatorLayout, t, 0);
                    }
                }
            }
            t.m();
            this.h = -1;
            G(sd.b(E(), -t.getTotalScrollRange(), 0));
            s0(coordinatorLayout, t, E(), 0, true);
            t.k(E());
            r0(coordinatorLayout, t);
            return zL;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, t, i, i2, i3, i4);
            }
            coordinatorLayout.J(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -t.getTotalScrollRange();
                    downNestedPreScrollRange = t.getDownNestedPreScrollRange() + i4;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i5 = i4;
                int i6 = downNestedPreScrollRange;
                if (i5 != i6) {
                    iArr[1] = O(coordinatorLayout, t, i2, i5, i6);
                }
            }
            if (t.j()) {
                t.q(t.s(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void t(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = O(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
            }
            if (i4 == 0) {
                r0(coordinatorLayout, t);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (!(parcelable instanceof e)) {
                super.x(coordinatorLayout, t, parcelable);
                this.h = -1;
                return;
            }
            e eVar = (e) parcelable;
            super.x(coordinatorLayout, t, eVar.q());
            this.h = eVar.f4557a;
            this.f8272a = eVar.f8276a;
            this.b = eVar.b;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable parcelableY = super.y(coordinatorLayout, t);
            int iE = E();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + iE;
                if (childAt.getTop() + iE <= 0 && bottom >= 0) {
                    e eVar = new e(parcelableY);
                    eVar.f4557a = i;
                    eVar.b = bottom == eh.z(childAt) + t.getTopInset();
                    eVar.f8276a = bottom / childAt.getHeight();
                    return eVar;
                }
            }
            return parcelableY;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (t.j() || X(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.f4547a) != null) {
                valueAnimator.cancel();
            }
            this.f4549a = null;
            this.g = i2;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.g == 0 || i == 1) {
                q0(coordinatorLayout, t);
                if (t.j()) {
                    t.q(t.s(view));
                }
            }
            this.f4549a = new WeakReference<>(view);
        }

        @Override // a.tv
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public int Q(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int iM = M();
            int i4 = 0;
            if (i2 == 0 || iM < i2 || iM > i3) {
                this.f = 0;
            } else {
                int iB = sd.b(i, i2, i3);
                if (iM != iB) {
                    int iE0 = t.f() ? e0(t, iB) : iB;
                    boolean zG = G(iE0);
                    i4 = iM - iB;
                    this.f = iB - iE0;
                    if (!zG && t.f()) {
                        coordinatorLayout.f(t);
                    }
                    t.k(E());
                    s0(coordinatorLayout, t, iB, iB < iM ? -1 : 1, false);
                }
            }
            r0(coordinatorLayout, t);
            return i4;
        }

        public final boolean p0(CoordinatorLayout coordinatorLayout, T t) {
            List<View> listS = coordinatorLayout.s(t);
            int size = listS.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) listS.get(i).getLayoutParams()).f();
                if (cVarF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarF).K() != 0;
                }
            }
            return false;
        }

        public final void q0(CoordinatorLayout coordinatorLayout, T t) {
            int iM = M();
            int iB0 = b0(t, iM);
            if (iB0 >= 0) {
                View childAt = t.getChildAt(iB0);
                d dVar = (d) childAt.getLayoutParams();
                int iA = dVar.a();
                if ((iA & 17) == 17) {
                    int i = -childAt.getTop();
                    int iZ = -childAt.getBottom();
                    if (iB0 == t.getChildCount() - 1) {
                        iZ += t.getTopInset();
                    }
                    if (Y(iA, 2)) {
                        iZ += eh.z(childAt);
                    } else if (Y(iA, 5)) {
                        int iZ2 = eh.z(childAt) + iZ;
                        if (iM < iZ2) {
                            i = iZ2;
                        } else {
                            iZ = iZ2;
                        }
                    }
                    if (Y(iA, 32)) {
                        i += ((LinearLayout.LayoutParams) dVar).topMargin;
                        iZ -= ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    }
                    if (iM < (iZ + i) / 2) {
                        i = iZ;
                    }
                    U(coordinatorLayout, t, sd.b(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void r0(CoordinatorLayout coordinatorLayout, T t) {
            eh.e0(coordinatorLayout, ni.a.d.b());
            eh.e0(coordinatorLayout, ni.a.e.b());
            View viewZ = Z(coordinatorLayout);
            if (viewZ == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.f) viewZ.getLayoutParams()).f() instanceof ScrollingViewBehavior)) {
                return;
            }
            S(coordinatorLayout, t, viewZ);
        }

        public final void s0(CoordinatorLayout coordinatorLayout, T t, int i, int i2, boolean z) {
            View viewA0 = a0(t, i);
            if (viewA0 != null) {
                int iA = ((d) viewA0.getLayoutParams()).a();
                boolean zS = false;
                if ((iA & 1) != 0) {
                    int iZ = eh.z(viewA0);
                    if (i2 <= 0 || (iA & 12) == 0 ? !((iA & 2) == 0 || (-i) < (viewA0.getBottom() - iZ) - t.getTopInset()) : (-i) >= (viewA0.getBottom() - iZ) - t.getTopInset()) {
                        zS = true;
                    }
                }
                if (t.j()) {
                    zS = t.s(Z(coordinatorLayout));
                }
                boolean zQ = t.q(zS);
                if (z || (zQ && p0(coordinatorLayout, t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends uv {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jv.ScrollingViewBehavior_Layout);
            O(typedArrayObtainStyledAttributes.getDimensionPixelSize(jv.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        public static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                return ((BaseBehavior) cVarF).M();
            }
            return 0;
        }

        @Override // a.uv
        public float J(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iR = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iR > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iR / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // a.uv
        public int L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.L(view);
        }

        @Override // a.uv
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public final void S(View view, View view2) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                eh.W(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarF).f) + M()) - I(view2));
            }
        }

        public final void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.j()) {
                    appBarLayout.q(appBarLayout.s(view));
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                eh.e0(coordinatorLayout, ni.a.d.b());
                eh.e0(coordinatorLayout, ni.a.e.b());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutH = H(coordinatorLayout.r(view));
            if (appBarLayoutH != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = ((uv) this).f7634a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutH.n(false, !z);
                    return true;
                }
            }
            return false;
        }
    }

    public class a implements ng {
        public a() {
        }

        @Override // a.ng
        public sh a(View view, sh shVar) {
            AppBarLayout.this.l(shVar);
            return shVar;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ iz f8278a;

        public b(AppBarLayout appBarLayout, iz izVar) {
            this.f8278a = izVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f8278a.T(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface c<T extends AppBarLayout> {
        void a(T t, int i);
    }

    public static class d extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8279a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Interpolator f4558a;

        public d(int i, int i2) {
            super(i, i2);
            this.f8279a = 1;
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8279a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jv.AppBarLayout_Layout);
            this.f8279a = typedArrayObtainStyledAttributes.getInt(jv.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(jv.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f4558a = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(jv.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8279a = 1;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8279a = 1;
        }

        public d(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8279a = 1;
        }

        public int a() {
            return this.f8279a;
        }

        public Interpolator b() {
            return this.f4558a;
        }

        public boolean c() {
            int i = this.f8279a;
            return (i & 1) == 1 && (i & 10) != 0;
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, zu.appBarLayoutStyle);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(r20.c(context, attributeSet, i, g), attributeSet, i);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = 0;
        Context context2 = getContext();
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            xv.a(this);
            xv.c(this, attributeSet, i, g);
        }
        TypedArray typedArrayH = dy.h(context2, attributeSet, jv.AppBarLayout, i, g, new int[0]);
        eh.m0(this, typedArrayH.getDrawable(jv.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            iz izVar = new iz();
            izVar.U(ColorStateList.valueOf(colorDrawable.getColor()));
            izVar.K(context2);
            eh.m0(this, izVar);
        }
        if (typedArrayH.hasValue(jv.AppBarLayout_expanded)) {
            o(typedArrayH.getBoolean(jv.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && typedArrayH.hasValue(jv.AppBarLayout_elevation)) {
            xv.b(this, typedArrayH.getDimensionPixelSize(jv.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (typedArrayH.hasValue(jv.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayH.getBoolean(jv.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayH.hasValue(jv.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayH.getBoolean(jv.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.f4546f = typedArrayH.getBoolean(jv.AppBarLayout_liftOnScroll, false);
        this.f = typedArrayH.getResourceId(jv.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayH.getDrawable(jv.AppBarLayout_statusBarForeground));
        typedArrayH.recycle();
        eh.v0(this, new a());
    }

    public final void a() {
        WeakReference<View> weakReference = this.f4539a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f4539a = null;
    }

    public final View b(View view) {
        int i;
        if (this.f4539a == null && (i = this.f) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f);
            }
            if (viewFindViewById != null) {
                this.f4539a = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f4539a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d generateDefaultLayoutParams() {
        return new d(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (r()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f8271a);
            this.f4538a.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4538a;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams) : new d((LinearLayout.LayoutParams) layoutParams);
    }

    public boolean f() {
        return this.f4542b;
    }

    public final boolean g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((d) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int iZ;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = dVar.f8279a;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
            } else {
                int i4 = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                if ((i3 & 8) != 0) {
                    iZ = eh.z(childAt);
                } else if ((i3 & 2) != 0) {
                    iZ = measuredHeight - eh.z(childAt);
                } else {
                    iMin = i4 + measuredHeight;
                    if (childCount == 0 && eh.v(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i2 += iMin;
                }
                iMin = i4 + iZ;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i2 += iMin;
            }
        }
        int iMax = Math.max(0, i2);
        this.c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iZ = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
            int i3 = dVar.f8279a;
            if ((i3 & 1) == 0) {
                break;
            }
            iZ += measuredHeight;
            if ((i3 & 2) != 0) {
                iZ -= eh.z(childAt);
                break;
            }
            i2++;
        }
        int iMax = Math.max(0, iZ);
        this.d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iZ = eh.z(this);
        if (iZ == 0) {
            int childCount = getChildCount();
            iZ = childCount >= 1 ? eh.z(getChildAt(childCount - 1)) : 0;
            if (iZ == 0) {
                return getHeight() / 3;
            }
        }
        return (iZ * 2) + topInset;
    }

    public int getPendingAction() {
        return this.e;
    }

    public Drawable getStatusBarForeground() {
        return this.f4538a;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        sh shVar = this.f4536a;
        if (shVar != null) {
            return shVar.i();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iZ = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = dVar.f8279a;
            if ((i3 & 1) == 0) {
                break;
            }
            iZ += measuredHeight + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
            if (i2 == 0 && eh.v(childAt)) {
                iZ -= getTopInset();
            }
            if ((i3 & 2) != 0) {
                iZ -= eh.z(childAt);
                break;
            }
            i2++;
        }
        int iMax = Math.max(0, iZ);
        this.b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean h() {
        return getTotalScrollRange() != 0;
    }

    public final void i() {
        this.b = -1;
        this.c = -1;
        this.d = -1;
    }

    public boolean j() {
        return this.f4546f;
    }

    public void k(int i) {
        this.f8271a = i;
        if (!willNotDraw()) {
            eh.b0(this);
        }
        List<c> list = this.f4540a;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = this.f4540a.get(i2);
                if (cVar != null) {
                    cVar.a(this, i);
                }
            }
        }
    }

    public sh l(sh shVar) {
        sh shVar2 = eh.v(this) ? shVar : null;
        if (!kf.a(this.f4536a, shVar2)) {
            this.f4536a = shVar2;
            v();
            requestLayout();
        }
        return shVar;
    }

    public void m() {
        this.e = 0;
    }

    public void n(boolean z, boolean z2) {
        o(z, z2, true);
    }

    public final void o(boolean z, boolean z2, boolean z3) {
        this.e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        jz.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.f4541a == null) {
            this.f4541a = new int[4];
        }
        int[] iArr = this.f4541a;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.f4544d ? zu.state_liftable : -zu.state_liftable;
        iArr[1] = (this.f4544d && this.f4545e) ? zu.state_lifted : -zu.state_lifted;
        iArr[2] = this.f4544d ? zu.state_collapsible : -zu.state_collapsible;
        iArr[3] = (this.f4544d && this.f4545e) ? zu.state_collapsed : -zu.state_collapsed;
        return LinearLayout.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = true;
        if (eh.v(this) && t()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                eh.W(getChildAt(childCount), topInset);
            }
        }
        i();
        this.f4542b = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            }
            if (((d) getChildAt(i5).getLayoutParams()).b() != null) {
                this.f4542b = true;
                break;
            }
            i5++;
        }
        Drawable drawable = this.f4538a;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f4543c) {
            return;
        }
        if (!this.f4546f && !g()) {
            z2 = false;
        }
        p(z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && eh.v(this) && t()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = sd.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        i();
    }

    public final boolean p(boolean z) {
        if (this.f4544d == z) {
            return false;
        }
        this.f4544d = z;
        refreshDrawableState();
        return true;
    }

    public boolean q(boolean z) {
        if (this.f4545e == z) {
            return false;
        }
        this.f4545e = z;
        refreshDrawableState();
        if (!this.f4546f || !(getBackground() instanceof iz)) {
            return true;
        }
        u((iz) getBackground(), z);
        return true;
    }

    public final boolean r() {
        return this.f4538a != null && getTopInset() > 0;
    }

    public boolean s(View view) {
        View viewB = b(view);
        if (viewB != null) {
            view = viewB;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        jz.d(this, f);
    }

    public void setExpanded(boolean z) {
        n(z, eh.Q(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.f4546f = z;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.f = i;
        a();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f4538a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f4538a = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f4538a.setState(getDrawableState());
                }
                kd.m(this.f4538a, eh.y(this));
                this.f4538a.setVisible(getVisibility() == 0, false);
                this.f4538a.setCallback(this);
            }
            v();
            eh.b0(this);
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(r2.d(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            xv.b(this, f);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f4538a;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public final boolean t() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || eh.v(childAt)) ? false : true;
    }

    public final void u(iz izVar, boolean z) {
        float dimension = getResources().getDimension(bv.design_appbar_elevation);
        float f = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f4537a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, dimension);
        this.f4537a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(getResources().getInteger(ev.app_bar_elevation_anim_duration));
        this.f4537a.setInterpolator(kv.f6644a);
        this.f4537a.addUpdateListener(new b(this, izVar));
        this.f4537a.start();
    }

    public final void v() {
        setWillNotDraw(!r());
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4538a;
    }
}
