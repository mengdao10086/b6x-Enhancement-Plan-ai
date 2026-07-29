package com.google.android.material.bottomsheet;

import a1.d;
import a1.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import com.google.common.collect.LinkedHashMultimap;
import e1.d;
import g.c1;
import g.i1;
import g.n0;
import g.p0;
import g.t0;
import g.x;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import le.o;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f19712e0 = 1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f19713f0 = 2;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f19714g0 = 3;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f19715h0 = 4;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f19716i0 = 5;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f19717j0 = 6;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f19718k0 = -1;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f19719l0 = 1;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f19720m0 = 2;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f19721n0 = 4;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f19722o0 = 8;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int f19723p0 = -1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int f19724q0 = 0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f19725r0 = "BottomSheetBehavior";

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f19726s0 = 500;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final float f19727t0 = 0.5f;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final float f19728u0 = 0.1f;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f19729v0 = 500;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int f19730w0 = -1;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int f19731x0 = R.style.Widget_Design_BottomSheet_Modal;

    @p0
    public ValueAnimator A;
    public int B;
    public int C;
    public int D;
    public float E;
    public int F;
    public float G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;
    public int L;

    @p0
    public e1.d M;
    public boolean N;
    public int O;
    public boolean P;
    public float Q;
    public int R;
    public int S;
    public int T;

    @p0
    public WeakReference<V> U;

    @p0
    public WeakReference<View> V;

    @n0
    public final ArrayList<f> W;

    @p0
    public VelocityTracker X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19732a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f19733a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19734b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @p0
    public Map<View, Integer> f19735b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19736c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f19737c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f19738d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final d.c f19739d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public le.j f19744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public ColorStateList f19745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19747l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19748m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19749n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19750o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f19751p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f19752q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19753r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f19754s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f19755t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f19756u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f19757v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f19758w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public o f19759x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f19760y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final BottomSheetBehavior<V>.j f19761z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f19764e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f19765f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19766g;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @p0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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

        public SavedState(@n0 Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f19762c);
            parcel.writeInt(this.f19763d);
            parcel.writeInt(this.f19764e ? 1 : 0);
            parcel.writeInt(this.f19765f ? 1 : 0);
            parcel.writeInt(this.f19766g ? 1 : 0);
        }

        public SavedState(@n0 Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f19762c = parcel.readInt();
            this.f19763d = parcel.readInt();
            this.f19764e = parcel.readInt() == 1;
            this.f19765f = parcel.readInt() == 1;
            this.f19766g = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, @n0 BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f19762c = bottomSheetBehavior.K;
            this.f19763d = bottomSheetBehavior.f19740e;
            this.f19764e = bottomSheetBehavior.f19734b;
            this.f19765f = bottomSheetBehavior.H;
            this.f19766g = bottomSheetBehavior.I;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.f19762c = i10;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f19767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f19768b;

        public a(View view, int i10) {
            this.f19767a = view;
            this.f19768b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.h1(this.f19767a, this.f19768b, false);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f19744i != null) {
                BottomSheetBehavior.this.f19744i.p0(fFloatValue);
            }
        }
    }

    public class c implements b0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f19771a;

        public c(boolean z10) {
            this.f19771a = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
        @Override // com.google.android.material.internal.b0.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.core.view.j1 a(android.view.View r11, androidx.core.view.j1 r12, com.google.android.material.internal.b0.f r13) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.a(android.view.View, androidx.core.view.j1, com.google.android.material.internal.b0$f):androidx.core.view.j1");
        }
    }

    public class d extends d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f19773a;

        public d() {
        }

        @Override // e1.d.c
        public int a(@n0 View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // e1.d.c
        public int b(@n0 View view, int i10, int i11) {
            int iK0 = BottomSheetBehavior.this.k0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return t0.a.e(i10, iK0, bottomSheetBehavior.H ? bottomSheetBehavior.T : bottomSheetBehavior.F);
        }

        @Override // e1.d.c
        public int e(@n0 View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.H ? bottomSheetBehavior.T : bottomSheetBehavior.F;
        }

        @Override // e1.d.c
        public void j(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.J) {
                BottomSheetBehavior.this.Z0(1);
            }
        }

        @Override // e1.d.c
        public void k(@n0 View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.g0(i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
        @Override // e1.d.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(@g.n0 android.view.View r9, float r10, float r11) {
            /*
                Method dump skipped, instruction units count: 303
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.l(android.view.View, float, float):void");
        }

        @Override // e1.d.c
        public boolean m(@n0 View view, int i10) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.K;
            if (i11 == 1 || bottomSheetBehavior.f19733a0) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.Y == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.V;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f19773a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.U;
            return weakReference2 != null && weakReference2.get() == view;
        }

        public final boolean n(@n0 View view) {
            int top2 = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top2 > (bottomSheetBehavior.T + bottomSheetBehavior.k0()) / 2;
        }
    }

    public class e implements a1.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19775a;

        public e(int i10) {
            this.f19775a = i10;
        }

        @Override // a1.g
        public boolean a(@n0 View view, @p0 g.a aVar) {
            BottomSheetBehavior.this.Y0(this.f19775a);
            return true;
        }
    }

    public static abstract class f {
        public void a(@n0 View view) {
        }

        public abstract void b(@n0 View view, float f10);

        public abstract void c(@n0 View view, int i10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface h {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface i {
    }

    public BottomSheetBehavior() {
        this.f19732a = 0;
        this.f19734b = true;
        this.f19736c = false;
        this.f19746k = -1;
        this.f19747l = -1;
        this.f19761z = new j(this, null);
        this.E = 0.5f;
        this.G = -1.0f;
        this.J = true;
        this.K = 4;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList<>();
        this.f19737c0 = -1;
        this.f19739d0 = new d();
    }

    @n0
    public static <V extends View> BottomSheetBehavior<V> i0(@n0 V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.g)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.g) layoutParams).f();
        if (cVarF instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) cVarF;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    public boolean A0() {
        return this.f19749n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean B(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, @n0 View view2, int i10, int i11) {
        this.O = 0;
        this.P = false;
        return (i10 & 2) != 0;
    }

    public boolean B0() {
        return this.H;
    }

    public final boolean C0(V v10) {
        ViewParent parent = v10.getParent();
        return parent != null && parent.isLayoutRequested() && u0.O0(v10);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D(@g.n0 androidx.coordinatorlayout.widget.CoordinatorLayout r3, @g.n0 V r4, @g.n0 android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.k0()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.Z0(r0)
            return
        Lf:
            boolean r3 = r2.D0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.V
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.P
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.O
            r5 = 6
            r6 = 4
            if (r3 <= 0) goto L3a
            boolean r3 = r2.f19734b
            if (r3 == 0) goto L30
            goto Laa
        L30:
            int r3 = r4.getTop()
            int r6 = r2.D
            if (r3 <= r6) goto Laa
            goto La9
        L3a:
            boolean r3 = r2.H
            if (r3 == 0) goto L4a
            float r3 = r2.x0()
            boolean r3 = r2.e1(r4, r3)
            if (r3 == 0) goto L4a
            r0 = 5
            goto Laa
        L4a:
            int r3 = r2.O
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.f19734b
            if (r1 == 0) goto L68
            int r5 = r2.C
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.D
            if (r3 >= r1) goto L7e
            int r1 = r2.F
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.f1()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.f19734b
            if (r3 == 0) goto L94
        L92:
            r0 = 4
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.D
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.F
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = 6
        Laa:
            r3 = 0
            r2.h1(r4, r0, r3)
            r2.P = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean D0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean E(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.K == 1 && actionMasked == 0) {
            return true;
        }
        if (d1()) {
            this.M.M(motionEvent);
        }
        if (actionMasked == 0) {
            G0();
        }
        if (this.X == null) {
            this.X = VelocityTracker.obtain();
        }
        this.X.addMovement(motionEvent);
        if (d1() && actionMasked == 2 && !this.N && Math.abs(this.Z - motionEvent.getY()) > this.M.E()) {
            this.M.d(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.N;
    }

    public void E0(@n0 f fVar) {
        this.W.remove(fVar);
    }

    public final void F0(V v10, d.a aVar, int i10) {
        u0.u1(v10, aVar, null, c0(i10));
    }

    public final void G0() {
        this.Y = -1;
        VelocityTracker velocityTracker = this.X;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.X = null;
        }
    }

    public final void H0(@n0 SavedState savedState) {
        int i10 = this.f19732a;
        if (i10 == 0) {
            return;
        }
        if (i10 == -1 || (i10 & 1) == 1) {
            this.f19740e = savedState.f19763d;
        }
        if (i10 == -1 || (i10 & 2) == 2) {
            this.f19734b = savedState.f19764e;
        }
        if (i10 == -1 || (i10 & 4) == 4) {
            this.H = savedState.f19765f;
        }
        if (i10 == -1 || (i10 & 8) == 8) {
            this.I = savedState.f19766g;
        }
    }

    public final void I0(V v10, Runnable runnable) {
        if (C0(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    @Deprecated
    public void J0(f fVar) {
        this.W.clear();
        if (fVar != null) {
            this.W.add(fVar);
        }
    }

    public void K0(boolean z10) {
        this.J = z10;
    }

    public void L0(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.B = i10;
    }

    public void M0(boolean z10) {
        if (this.f19734b == z10) {
            return;
        }
        this.f19734b = z10;
        if (this.U != null) {
            Z();
        }
        Z0((this.f19734b && this.K == 6) ? 3 : this.K);
        i1();
    }

    public void N0(boolean z10) {
        this.f19749n = z10;
    }

    public void O0(@x(from = 0.0d, fromInclusive = false, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR, toInclusive = false) float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.E = f10;
        if (this.U != null) {
            a0();
        }
    }

    public void P0(float f10) {
        this.Q = f10;
    }

    public void Q0(boolean z10) {
        if (this.H != z10) {
            this.H = z10;
            if (!z10 && this.K == 5) {
                Y0(4);
            }
            i1();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void R0(boolean z10) {
        this.H = z10;
    }

    public void S0(@t0 int i10) {
        this.f19747l = i10;
    }

    public void T0(@t0 int i10) {
        this.f19746k = i10;
    }

    public void U0(int i10) {
        V0(i10, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V0(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.f19741f
            if (r4 != 0) goto L15
            r3.f19741f = r0
            goto L1f
        Lc:
            boolean r2 = r3.f19741f
            if (r2 != 0) goto L17
            int r2 = r3.f19740e
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = 0
            goto L1f
        L17:
            r3.f19741f = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f19740e = r4
        L1f:
            if (r0 == 0) goto L24
            r3.l1(r5)
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.V0(int, boolean):void");
    }

    public void W0(int i10) {
        this.f19732a = i10;
    }

    public final int X(V v10, @c1 int i10, int i11) {
        return u0.c(v10, v10.getResources().getString(i10), c0(i11));
    }

    public void X0(boolean z10) {
        this.I = z10;
    }

    public void Y(@n0 f fVar) {
        if (this.W.contains(fVar)) {
            return;
        }
        this.W.add(fVar);
    }

    public void Y0(int i10) {
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            sb2.append(i10 == 1 ? "DRAGGING" : "SETTLING");
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!this.H && i10 == 5) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cannot set state: ");
            sb3.append(i10);
            return;
        }
        int i11 = (i10 == 6 && this.f19734b && w0(i10) <= this.C) ? 3 : i10;
        WeakReference<V> weakReference = this.U;
        if (weakReference == null || weakReference.get() == null) {
            Z0(i10);
        } else {
            V v10 = this.U.get();
            I0(v10, new a(v10, i11));
        }
    }

    public final void Z() {
        int iB0 = b0();
        if (this.f19734b) {
            this.F = Math.max(this.T - iB0, this.C);
        } else {
            this.F = this.T - iB0;
        }
    }

    public void Z0(int i10) {
        V v10;
        if (this.K == i10) {
            return;
        }
        this.K = i10;
        if (i10 == 4 || i10 == 3 || i10 == 6 || (this.H && i10 == 5)) {
            this.L = i10;
        }
        WeakReference<V> weakReference = this.U;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            k1(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            k1(false);
        }
        j1(i10);
        for (int i11 = 0; i11 < this.W.size(); i11++) {
            this.W.get(i11).c(v10, i10);
        }
        i1();
    }

    public final void a0() {
        this.D = (int) (this.T * (1.0f - this.E));
    }

    public void a1(boolean z10) {
        this.f19736c = z10;
    }

    public final int b0() {
        int i10;
        return this.f19741f ? Math.min(Math.max(this.f19742g, this.T - ((this.S * 9) / 16)), this.R) + this.f19757v : (this.f19749n || this.f19750o || (i10 = this.f19748m) <= 0) ? this.f19740e + this.f19757v : Math.max(this.f19740e, i10 + this.f19743h);
    }

    public final void b1(@n0 View view) {
        boolean z10 = (Build.VERSION.SDK_INT < 29 || A0() || this.f19741f) ? false : true;
        if (this.f19750o || this.f19751p || this.f19752q || this.f19754s || this.f19755t || this.f19756u || z10) {
            b0.d(view, new c(z10));
        }
    }

    public final a1.g c0(int i10) {
        return new e(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean c1(long j10, @x(from = 0.0d, to = m0.g.f40541b) float f10) {
        return false;
    }

    public final void d0(@n0 Context context) {
        if (this.f19759x == null) {
            return;
        }
        le.j jVar = new le.j(this.f19759x);
        this.f19744i = jVar;
        jVar.Z(context);
        ColorStateList colorStateList = this.f19745j;
        if (colorStateList != null) {
            this.f19744i.o0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        this.f19744i.setTint(typedValue.data);
    }

    public final boolean d1() {
        return this.M != null && (this.J || this.K == 1);
    }

    public final void e0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.A = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.A.addUpdateListener(new b());
    }

    public boolean e1(@n0 View view, float f10) {
        if (this.I) {
            return true;
        }
        if (view.getTop() < this.F) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f10 * this.Q)) - ((float) this.F)) / ((float) b0()) > 0.5f;
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void f0() {
        this.A = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean f1() {
        return false;
    }

    public void g0(int i10) {
        float f10;
        float fK0;
        V v10 = this.U.get();
        if (v10 == null || this.W.isEmpty()) {
            return;
        }
        int i11 = this.F;
        if (i10 > i11 || i11 == k0()) {
            int i12 = this.F;
            f10 = i12 - i10;
            fK0 = this.T - i12;
        } else {
            int i13 = this.F;
            f10 = i13 - i10;
            fK0 = i13 - k0();
        }
        float f11 = f10 / fK0;
        for (int i14 = 0; i14 < this.W.size(); i14++) {
            this.W.get(i14).b(v10, f11);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean g1() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void h(@n0 CoordinatorLayout.g gVar) {
        super.h(gVar);
        this.U = null;
        this.M = null;
    }

    @i1
    @p0
    public View h0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (u0.W0(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View viewH0 = h0(viewGroup.getChildAt(i10));
                if (viewH0 != null) {
                    return viewH0;
                }
            }
        }
        return null;
    }

    public final void h1(View view, int i10, boolean z10) {
        int iW0 = w0(i10);
        e1.d dVar = this.M;
        if (!(dVar != null && (!z10 ? !dVar.X(view, view.getLeft(), iW0) : !dVar.V(view.getLeft(), iW0)))) {
            Z0(i10);
            return;
        }
        Z0(2);
        j1(i10);
        this.f19761z.c(i10);
    }

    public final void i1() {
        V v10;
        WeakReference<V> weakReference = this.U;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        u0.r1(v10, 524288);
        u0.r1(v10, 262144);
        u0.r1(v10, 1048576);
        int i10 = this.f19737c0;
        if (i10 != -1) {
            u0.r1(v10, i10);
        }
        if (!this.f19734b && this.K != 6) {
            this.f19737c0 = X(v10, R.string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.H && this.K != 5) {
            F0(v10, d.a.f126z, 5);
        }
        int i11 = this.K;
        if (i11 == 3) {
            F0(v10, d.a.f125y, this.f19734b ? 4 : 6);
            return;
        }
        if (i11 == 4) {
            F0(v10, d.a.f124x, this.f19734b ? 3 : 6);
        } else {
            if (i11 != 6) {
                return;
            }
            F0(v10, d.a.f125y, 4);
            F0(v10, d.a.f124x, 3);
        }
    }

    public final int j0(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    public final void j1(int i10) {
        ValueAnimator valueAnimator;
        if (i10 == 2) {
            return;
        }
        boolean z10 = i10 == 3;
        if (this.f19760y != z10) {
            this.f19760y = z10;
            if (this.f19744i == null || (valueAnimator = this.A) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.A.reverse();
                return;
            }
            float f10 = z10 ? 0.0f : 1.0f;
            this.A.setFloatValues(1.0f - f10, f10);
            this.A.start();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void k() {
        super.k();
        this.U = null;
        this.M = null;
    }

    public int k0() {
        if (this.f19734b) {
            return this.C;
        }
        return Math.max(this.B, this.f19753r ? 0 : this.f19758w);
    }

    public final void k1(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.f19735b0 != null) {
                    return;
                } else {
                    this.f19735b0 = new HashMap(childCount);
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt != this.U.get()) {
                    if (z10) {
                        this.f19735b0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.f19736c) {
                            u0.R1(childAt, 4);
                        }
                    } else if (this.f19736c && (map = this.f19735b0) != null && map.containsKey(childAt)) {
                        u0.R1(childAt, this.f19735b0.get(childAt).intValue());
                    }
                }
            }
            if (!z10) {
                this.f19735b0 = null;
            } else if (this.f19736c) {
                this.U.get().sendAccessibilityEvent(8);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 MotionEvent motionEvent) {
        e1.d dVar;
        if (!v10.isShown() || !this.J) {
            this.N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            G0();
        }
        if (this.X == null) {
            this.X = VelocityTracker.obtain();
        }
        this.X.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.Z = (int) motionEvent.getY();
            if (this.K != 2) {
                WeakReference<View> weakReference = this.V;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.A(view, x10, this.Z)) {
                    this.Y = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f19733a0 = true;
                }
            }
            this.N = this.Y == -1 && !coordinatorLayout.A(v10, x10, this.Z);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f19733a0 = false;
            this.Y = -1;
            if (this.N) {
                this.N = false;
                return false;
            }
        }
        if (!this.N && (dVar = this.M) != null && dVar.W(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.V;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.N || this.K == 1 || coordinatorLayout.A(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || Math.abs(((float) this.Z) - motionEvent.getY()) <= ((float) this.M.E())) ? false : true;
    }

    @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float l0() {
        return this.E;
    }

    public final void l1(boolean z10) {
        V v10;
        if (this.U != null) {
            Z();
            if (this.K != 4 || (v10 = this.U.get()) == null) {
                return;
            }
            if (z10) {
                Y0(4);
            } else {
                v10.requestLayout();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, int i10) {
        if (u0.U(coordinatorLayout) && !u0.U(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.U == null) {
            this.f19742g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            b1(v10);
            this.U = new WeakReference<>(v10);
            le.j jVar = this.f19744i;
            if (jVar != null) {
                u0.I1(v10, jVar);
                le.j jVar2 = this.f19744i;
                float fR = this.G;
                if (fR == -1.0f) {
                    fR = u0.R(v10);
                }
                jVar2.n0(fR);
                boolean z10 = this.K == 3;
                this.f19760y = z10;
                this.f19744i.p0(z10 ? 0.0f : 1.0f);
            } else {
                ColorStateList colorStateList = this.f19745j;
                if (colorStateList != null) {
                    u0.J1(v10, colorStateList);
                }
            }
            i1();
            if (u0.V(v10) == 0) {
                u0.R1(v10, 1);
            }
        }
        if (this.M == null) {
            this.M = e1.d.q(coordinatorLayout, this.f19739d0);
        }
        int top2 = v10.getTop();
        coordinatorLayout.N(v10, i10);
        this.S = coordinatorLayout.getWidth();
        this.T = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.R = height;
        int i11 = this.T;
        int i12 = i11 - height;
        int i13 = this.f19758w;
        if (i12 < i13) {
            if (this.f19753r) {
                this.R = i11;
            } else {
                this.R = i11 - i13;
            }
        }
        this.C = Math.max(0, i11 - this.R);
        a0();
        Z();
        int i14 = this.K;
        if (i14 == 3) {
            u0.f1(v10, k0());
        } else if (i14 == 6) {
            u0.f1(v10, this.D);
        } else if (this.H && i14 == 5) {
            u0.f1(v10, this.T);
        } else if (i14 == 4) {
            u0.f1(v10, this.F);
        } else if (i14 == 1 || i14 == 2) {
            u0.f1(v10, top2 - v10.getTop());
        }
        this.V = new WeakReference<>(h0(v10));
        for (int i15 = 0; i15 < this.W.size(); i15++) {
            this.W.get(i15).a(v10);
        }
        return true;
    }

    public float m0() {
        return this.Q;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(j0(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f19746k, marginLayoutParams.width), j0(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.f19747l, marginLayoutParams.height));
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int n0() {
        return this.L;
    }

    public le.j o0() {
        return this.f19744i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, float f10, float f11) {
        WeakReference<View> weakReference;
        if (D0() && (weakReference = this.V) != null && view == weakReference.get()) {
            return this.K != 3 || super.p(coordinatorLayout, v10, view, f10, f11);
        }
        return false;
    }

    @t0
    public int p0() {
        return this.f19747l;
    }

    @t0
    public int q0() {
        return this.f19746k;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10, int i11, @n0 int[] iArr, int i12) {
        if (i12 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.V;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (!D0() || view == view2) {
            int top2 = v10.getTop();
            int i13 = top2 - i11;
            if (i11 > 0) {
                if (i13 < k0()) {
                    iArr[1] = top2 - k0();
                    u0.f1(v10, -iArr[1]);
                    Z0(3);
                } else {
                    if (!this.J) {
                        return;
                    }
                    iArr[1] = i11;
                    u0.f1(v10, -i11);
                    Z0(1);
                }
            } else if (i11 < 0 && !view.canScrollVertically(-1)) {
                int i14 = this.F;
                if (i13 > i14 && !this.H) {
                    iArr[1] = top2 - i14;
                    u0.f1(v10, -iArr[1]);
                    Z0(4);
                } else {
                    if (!this.J) {
                        return;
                    }
                    iArr[1] = i11;
                    u0.f1(v10, -i11);
                    Z0(1);
                }
            }
            g0(v10.getTop());
            this.O = i11;
            this.P = true;
        }
    }

    public int r0() {
        if (this.f19741f) {
            return -1;
        }
        return this.f19740e;
    }

    @i1
    public int s0() {
        return this.f19742g;
    }

    public int t0() {
        return this.f19732a;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10, int i11, int i12, int i13, int i14, @n0 int[] iArr) {
    }

    public boolean u0() {
        return this.I;
    }

    public int v0() {
        return this.K;
    }

    public final int w0(int i10) {
        if (i10 == 3) {
            return k0();
        }
        if (i10 == 4) {
            return this.F;
        }
        if (i10 == 5) {
            return this.T;
        }
        if (i10 == 6) {
            return this.D;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i10);
    }

    public final float x0() {
        VelocityTracker velocityTracker = this.X;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f19738d);
        return this.X.getYVelocity(this.Y);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void y(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.y(coordinatorLayout, v10, savedState.a());
        H0(savedState);
        int i10 = savedState.f19762c;
        if (i10 == 1 || i10 == 2) {
            this.K = 4;
            this.L = 4;
        } else {
            this.K = i10;
            this.L = i10;
        }
    }

    public boolean y0() {
        return this.J;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    @n0
    public Parcelable z(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10) {
        return new SavedState(super.z(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    public boolean z0() {
        return this.f19734b;
    }

    public class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f19778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f19779c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j.this.f19778b = false;
                e1.d dVar = BottomSheetBehavior.this.M;
                if (dVar != null && dVar.o(true)) {
                    j jVar = j.this;
                    jVar.c(jVar.f19777a);
                    return;
                }
                j jVar2 = j.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.K == 2) {
                    bottomSheetBehavior.Z0(jVar2.f19777a);
                }
            }
        }

        public j() {
            this.f19779c = new a();
        }

        public void c(int i10) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.U;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f19777a = i10;
            if (this.f19778b) {
                return;
            }
            u0.p1(BottomSheetBehavior.this.U.get(), this.f19779c);
            this.f19778b = true;
        }

        public /* synthetic */ j(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    public BottomSheetBehavior(@n0 Context context, @p0 AttributeSet attributeSet) {
        int i10;
        super(context, attributeSet);
        this.f19732a = 0;
        this.f19734b = true;
        this.f19736c = false;
        this.f19746k = -1;
        this.f19747l = -1;
        this.f19761z = new j(this, null);
        this.E = 0.5f;
        this.G = -1.0f;
        this.J = true;
        this.K = 4;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList<>();
        this.f19737c0 = -1;
        this.f19739d0 = new d();
        this.f19743h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        int i11 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f19745j = ie.c.a(context, typedArrayObtainStyledAttributes, i11);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.f19759x = o.e(context, attributeSet, R.attr.bottomSheetStyle, f19731x0).m();
        }
        d0(context);
        e0();
        this.G = typedArrayObtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i12 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            T0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            S0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i14);
        if (typedValuePeekValue != null && (i10 = typedValuePeekValue.data) == -1) {
            U0(i10);
        } else {
            U0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i14, -1));
        }
        Q0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        N0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        M0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        X0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        K0(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        W0(typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        O0(typedArrayObtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i15 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i15);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            L0(typedValuePeekValue2.data);
        } else {
            L0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        }
        this.f19750o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f19751p = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f19752q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f19753r = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.f19754s = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.f19755t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.f19756u = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f19738d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
