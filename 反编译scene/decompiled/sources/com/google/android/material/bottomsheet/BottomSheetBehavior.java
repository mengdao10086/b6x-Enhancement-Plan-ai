package com.google.android.material.bottomsheet;

import a.ak;
import a.bj;
import a.bv;
import a.cw;
import a.eh;
import a.gy;
import a.hy;
import a.iv;
import a.iz;
import a.jv;
import a.lk;
import a.ni;
import a.ny;
import a.nz;
import a.sd;
import a.sh;
import a.ti;
import a.zu;
import android.R;
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int q = iv.Widget_Design_BottomSheet_Modal;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public iz f4571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lk.a f4572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lk f4573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nz f4574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f4575a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VelocityTracker f4576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BottomSheetBehavior<V>.h f4577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<V> f4578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<f> f4579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<View, Integer> f4580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4581a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4582b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public WeakReference<View> f4583b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4584b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f4585c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4586c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4587d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4588e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4589f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4590g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4591h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4592i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f4593j;
    public int k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f4594k;
    public int l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public boolean f4595l;
    public int m;
    public int n;
    public int o;
    public int p;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8289a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ View f4596a;

        public a(View view, int i) {
            this.f4596a = view;
            this.f8289a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.m0(this.f4596a, this.f8289a);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f4571a != null) {
                BottomSheetBehavior.this.f4571a.V(fFloatValue);
            }
        }
    }

    public class c implements gy.a {
        public c() {
        }

        @Override // a.gy.a
        public sh a(View view, sh shVar, hy hyVar) {
            BottomSheetBehavior.this.e = shVar.e().d;
            BottomSheetBehavior.this.t0(false);
            return shVar;
        }
    }

    public class d extends lk.a {
        public d() {
        }

        @Override // a.lk.a
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // a.lk.a
        public int b(View view, int i, int i2) {
            int iU = BottomSheetBehavior.this.U();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return sd.b(i, iU, bottomSheetBehavior.f4590g ? bottomSheetBehavior.n : bottomSheetBehavior.i);
        }

        @Override // a.lk.a
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.f4590g ? bottomSheetBehavior.n : bottomSheetBehavior.i;
        }

        @Override // a.lk.a
        public void j(int i) {
            if (i == 1 && BottomSheetBehavior.this.f4592i) {
                BottomSheetBehavior.this.k0(1);
            }
        }

        @Override // a.lk.a
        public void k(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.S(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        
            if (java.lang.Math.abs(r7.getTop() - r6.f8292a.f) < java.lang.Math.abs(r7.getTop() - r6.f8292a.h)) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
        
            r8 = r6.f8292a.f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
        
            if (java.lang.Math.abs(r8 - r6.f8292a.h) < java.lang.Math.abs(r8 - r6.f8292a.i)) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d8, code lost:
        
            if (java.lang.Math.abs(r8 - r6.f8292a.g) < java.lang.Math.abs(r8 - r6.f8292a.i)) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00ea, code lost:
        
            if (r8 < java.lang.Math.abs(r8 - r9.i)) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00fc, code lost:
        
            if (java.lang.Math.abs(r8 - r0) < java.lang.Math.abs(r8 - r6.f8292a.i)) goto L39;
         */
        @Override // a.lk.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r7, float r8, float r9) {
            /*
                Method dump skipped, instruction units count: 262
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.l(android.view.View, float, float):void");
        }

        @Override // a.lk.a
        public boolean m(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.j;
            if (i2 == 1 || bottomSheetBehavior.f4595l) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.o == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.f4583b;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.f4578a;
            return weakReference2 != null && weakReference2.get() == view;
        }

        public final boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.n + bottomSheetBehavior.U()) / 2;
        }
    }

    public class e implements bj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8293a;

        public e(int i) {
            this.f8293a = i;
        }

        @Override // a.bj
        public boolean a(View view, ti tiVar) {
            BottomSheetBehavior.this.j0(this.f8293a);
            return true;
        }
    }

    public static abstract class f {
        public abstract void a(View view, float f);

        public abstract void b(View view, int i);
    }

    public static class g extends ak {
        public static final Parcelable.Creator<g> CREATOR = new cw();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8294a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4599b;
        public boolean c;
        public boolean d;

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8294a = parcel.readInt();
            this.b = parcel.readInt();
            this.f4599b = parcel.readInt() == 1;
            this.c = parcel.readInt() == 1;
            this.d = parcel.readInt() == 1;
        }

        public g(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f8294a = bottomSheetBehavior.j;
            this.b = bottomSheetBehavior.f4582b;
            this.f4599b = bottomSheetBehavior.f4581a;
            this.c = bottomSheetBehavior.f4590g;
            this.d = bottomSheetBehavior.f4591h;
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8294a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.f4599b ? 1 : 0);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.d ? 1 : 0);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8295a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final View f4600a;
        public boolean b;

        public h(View view, int i) {
            this.f4600a = view;
            this.f8295a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            lk lkVar = BottomSheetBehavior.this.f4573a;
            if (lkVar == null || !lkVar.m(true)) {
                BottomSheetBehavior.this.k0(this.f8295a);
            } else {
                eh.c0(this.f4600a, this);
            }
            this.b = false;
        }
    }

    public BottomSheetBehavior() {
        this.f4570a = 0;
        this.f4581a = true;
        this.f4584b = false;
        this.f4577a = null;
        this.b = 0.5f;
        this.c = -1.0f;
        this.f4592i = true;
        this.j = 4;
        this.f4579a = new ArrayList<>();
        this.f4572a = new d();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.f4570a = 0;
        this.f4581a = true;
        this.f4584b = false;
        this.f4577a = null;
        this.b = 0.5f;
        this.c = -1.0f;
        this.f4592i = true;
        this.j = 4;
        this.f4579a = new ArrayList<>();
        this.f4572a = new d();
        this.d = context.getResources().getDimensionPixelSize(bv.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jv.BottomSheetBehavior_Layout);
        this.f4587d = typedArrayObtainStyledAttributes.hasValue(jv.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(jv.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            Q(context, attributeSet, zHasValue, ny.a(context, typedArrayObtainStyledAttributes, jv.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            P(context, attributeSet, zHasValue);
        }
        R();
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = typedArrayObtainStyledAttributes.getDimension(jv.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(jv.BottomSheetBehavior_Layout_behavior_peekHeight);
        f0((typedValuePeekValue == null || (i = typedValuePeekValue.data) != -1) ? typedArrayObtainStyledAttributes.getDimensionPixelSize(jv.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : i);
        e0(typedArrayObtainStyledAttributes.getBoolean(jv.BottomSheetBehavior_Layout_behavior_hideable, false));
        c0(typedArrayObtainStyledAttributes.getBoolean(jv.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        b0(typedArrayObtainStyledAttributes.getBoolean(jv.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        i0(typedArrayObtainStyledAttributes.getBoolean(jv.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        Z(typedArrayObtainStyledAttributes.getBoolean(jv.BottomSheetBehavior_Layout_behavior_draggable, true));
        h0(typedArrayObtainStyledAttributes.getInt(jv.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        d0(typedArrayObtainStyledAttributes.getFloat(jv.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(jv.BottomSheetBehavior_Layout_behavior_expandedOffset);
        a0((typedValuePeekValue2 == null || typedValuePeekValue2.type != 16) ? typedArrayObtainStyledAttributes.getDimensionPixelOffset(jv.BottomSheetBehavior_Layout_behavior_expandedOffset, 0) : typedValuePeekValue2.data);
        typedArrayObtainStyledAttributes.recycle();
        this.f8288a = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.k = 0;
        this.f4594k = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
    
        if (r3 < java.lang.Math.abs(r3 - r2.i)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0088, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.i)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a6, code lost:
    
        if (java.lang.Math.abs(r3 - r2.h) < java.lang.Math.abs(r3 - r2.i)) goto L47;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.U()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.k0(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r3 = r2.f4583b
            if (r3 == 0) goto Lb1
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb1
            boolean r3 = r2.f4594k
            if (r3 != 0) goto L1f
            goto Lb1
        L1f:
            int r3 = r2.k
            r5 = 4
            r6 = 6
            if (r3 <= 0) goto L3c
            boolean r3 = r2.f4581a
            if (r3 == 0) goto L2d
        L29:
            int r3 = r2.g
            goto Lab
        L2d:
            int r3 = r4.getTop()
            int r5 = r2.h
            if (r3 <= r5) goto L38
            r3 = r5
            goto Laa
        L38:
            int r3 = r2.f
            goto Lab
        L3c:
            boolean r3 = r2.f4590g
            if (r3 == 0) goto L4e
            float r3 = r2.V()
            boolean r3 = r2.o0(r4, r3)
            if (r3 == 0) goto L4e
            int r3 = r2.n
            r0 = 5
            goto Lab
        L4e:
            int r3 = r2.k
            if (r3 != 0) goto L8b
            int r3 = r4.getTop()
            boolean r1 = r2.f4581a
            if (r1 == 0) goto L6c
            int r6 = r2.g
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            int r1 = r2.i
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r6 >= r3) goto L8f
            goto L29
        L6c:
            int r1 = r2.h
            if (r3 >= r1) goto L7b
            int r5 = r2.i
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            if (r3 >= r5) goto La8
            goto L38
        L7b:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.i
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L8f
            goto La8
        L8b:
            boolean r3 = r2.f4581a
            if (r3 == 0) goto L93
        L8f:
            int r3 = r2.i
            r0 = r5
            goto Lab
        L93:
            int r3 = r4.getTop()
            int r0 = r2.h
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.i
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L8f
        La8:
            int r3 = r2.h
        Laa:
            r0 = r6
        Lab:
            r5 = 0
            r2.p0(r4, r0, r3, r5)
            r2.f4594k = r5
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.j == 1 && actionMasked == 0) {
            return true;
        }
        lk lkVar = this.f4573a;
        if (lkVar != null) {
            lkVar.E(motionEvent);
        }
        if (actionMasked == 0) {
            X();
        }
        if (this.f4576a == null) {
            this.f4576a = VelocityTracker.obtain();
        }
        this.f4576a.addMovement(motionEvent);
        if (this.f4573a != null && actionMasked == 2 && !this.f4593j && Math.abs(this.p - motionEvent.getY()) > this.f4573a.y()) {
            this.f4573a.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f4593j;
    }

    public final void L(V v, ni.a aVar, int i) {
        eh.g0(v, aVar, null, new e(i));
    }

    public final void M() {
        int iO = O();
        if (this.f4581a) {
            this.i = Math.max(this.n - iO, this.g);
        } else {
            this.i = this.n - iO;
        }
    }

    public final void N() {
        this.h = (int) (this.n * (1.0f - this.b));
    }

    public final int O() {
        int i;
        return this.f4586c ? Math.min(Math.max(this.f4585c, this.n - ((this.m * 9) / 16)), this.l) : (this.f4588e || (i = this.e) <= 0) ? this.f4582b : Math.max(this.f4582b, i + this.d);
    }

    public final void P(Context context, AttributeSet attributeSet, boolean z) {
        Q(context, attributeSet, z, null);
    }

    public final void Q(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.f4587d) {
            this.f4574a = nz.c(context, attributeSet, zu.bottomSheetStyle, q).m();
            iz izVar = new iz(this.f4574a);
            this.f4571a = izVar;
            izVar.K(context);
            if (z && colorStateList != null) {
                this.f4571a.U(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.f4571a.setTint(typedValue.data);
        }
    }

    public final void R() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4575a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f4575a.addUpdateListener(new b());
    }

    public void S(int i) {
        float f2;
        float fU;
        V v = this.f4578a.get();
        if (v == null || this.f4579a.isEmpty()) {
            return;
        }
        int i2 = this.i;
        if (i > i2 || i2 == U()) {
            int i3 = this.i;
            f2 = i3 - i;
            fU = this.n - i3;
        } else {
            int i4 = this.i;
            f2 = i4 - i;
            fU = i4 - U();
        }
        float f3 = f2 / fU;
        for (int i5 = 0; i5 < this.f4579a.size(); i5++) {
            this.f4579a.get(i5).a(v, f3);
        }
    }

    public View T(View view) {
        if (eh.R(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewT = T(viewGroup.getChildAt(i));
            if (viewT != null) {
                return viewT;
            }
        }
        return null;
    }

    public int U() {
        return this.f4581a ? this.g : this.f;
    }

    public final float V() {
        VelocityTracker velocityTracker = this.f4576a;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f8288a);
        return this.f4576a.getYVelocity(this.o);
    }

    public boolean W() {
        return this.f4588e;
    }

    public final void X() {
        this.o = -1;
        VelocityTracker velocityTracker = this.f4576a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4576a = null;
        }
    }

    public final void Y(g gVar) {
        int i = this.f4570a;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.f4582b = gVar.b;
        }
        int i2 = this.f4570a;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.f4581a = gVar.f4599b;
        }
        int i3 = this.f4570a;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.f4590g = gVar.c;
        }
        int i4 = this.f4570a;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.f4591h = gVar.d;
        }
    }

    public void Z(boolean z) {
        this.f4592i = z;
    }

    public void a0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f = i;
    }

    public void b0(boolean z) {
        if (this.f4581a == z) {
            return;
        }
        this.f4581a = z;
        if (this.f4578a != null) {
            M();
        }
        k0((this.f4581a && this.j == 6) ? 3 : this.j);
        q0();
    }

    public void c0(boolean z) {
        this.f4588e = z;
    }

    public void d0(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.b = f2;
        if (this.f4578a != null) {
            N();
        }
    }

    public void e0(boolean z) {
        if (this.f4590g != z) {
            this.f4590g = z;
            if (!z && this.j == 5) {
                j0(4);
            }
            q0();
        }
    }

    public void f0(int i) {
        g0(i, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.f4578a = null;
        this.f4573a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g0(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.f4586c
            if (r4 != 0) goto L15
            r3.f4586c = r0
            goto L1f
        Lc:
            boolean r2 = r3.f4586c
            if (r2 != 0) goto L17
            int r2 = r3.f4582b
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = r1
            goto L1f
        L17:
            r3.f4586c = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f4582b = r4
        L1f:
            if (r0 == 0) goto L24
            r3.t0(r5)
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.g0(int, boolean):void");
    }

    public void h0(int i) {
        this.f4570a = i;
    }

    public void i0(boolean z) {
        this.f4591h = z;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.f4578a = null;
        this.f4573a = null;
    }

    public void j0(int i) {
        if (i == this.j) {
            return;
        }
        if (this.f4578a != null) {
            n0(i);
            return;
        }
        if (i == 4 || i == 3 || i == 6 || (this.f4590g && i == 5)) {
            this.j = i;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        lk lkVar;
        if (!v.isShown() || !this.f4592i) {
            this.f4593j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            X();
        }
        if (this.f4576a == null) {
            this.f4576a = VelocityTracker.obtain();
        }
        this.f4576a.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.p = (int) motionEvent.getY();
            if (this.j != 2) {
                WeakReference<View> weakReference = this.f4583b;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.B(view, x, this.p)) {
                    this.o = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f4595l = true;
                }
            }
            this.f4593j = this.o == -1 && !coordinatorLayout.B(v, x, this.p);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4595l = false;
            this.o = -1;
            if (this.f4593j) {
                this.f4593j = false;
                return false;
            }
        }
        if (!this.f4593j && (lkVar = this.f4573a) != null && lkVar.N(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f4583b;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.f4593j || this.j == 1 || coordinatorLayout.B(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f4573a == null || Math.abs(((float) this.p) - motionEvent.getY()) <= ((float) this.f4573a.y())) ? false : true;
    }

    public void k0(int i) {
        V v;
        if (this.j == i) {
            return;
        }
        this.j = i;
        WeakReference<V> weakReference = this.f4578a;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            s0(true);
        } else if (i == 6 || i == 5 || i == 4) {
            s0(false);
        }
        r0(i);
        for (int i2 = 0; i2 < this.f4579a.size(); i2++) {
            this.f4579a.get(i2).b(v, i);
        }
        q0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        int iU;
        iz izVar;
        if (eh.v(coordinatorLayout) && !eh.v(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.f4578a == null) {
            this.f4585c = coordinatorLayout.getResources().getDimensionPixelSize(bv.design_bottom_sheet_peek_height_min);
            l0(v);
            this.f4578a = new WeakReference<>(v);
            if (this.f4587d && (izVar = this.f4571a) != null) {
                eh.m0(v, izVar);
            }
            iz izVar2 = this.f4571a;
            if (izVar2 != null) {
                float fT = this.c;
                if (fT == -1.0f) {
                    fT = eh.t(v);
                }
                izVar2.T(fT);
                boolean z = this.j == 3;
                this.f4589f = z;
                this.f4571a.V(z ? 0.0f : 1.0f);
            }
            q0();
            if (eh.w(v) == 0) {
                eh.t0(v, 1);
            }
        }
        if (this.f4573a == null) {
            this.f4573a = lk.o(coordinatorLayout, this.f4572a);
        }
        int top = v.getTop();
        coordinatorLayout.I(v, i);
        this.m = coordinatorLayout.getWidth();
        this.n = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.l = height;
        this.g = Math.max(0, this.n - height);
        N();
        M();
        int i2 = this.j;
        if (i2 == 3) {
            iU = U();
        } else if (i2 == 6) {
            iU = this.h;
        } else if (this.f4590g && i2 == 5) {
            iU = this.n;
        } else {
            int i3 = this.j;
            if (i3 != 4) {
                if (i3 == 1 || i3 == 2) {
                    eh.W(v, top - v.getTop());
                }
                this.f4583b = new WeakReference<>(T(v));
                return true;
            }
            iU = this.i;
        }
        eh.W(v, iU);
        this.f4583b = new WeakReference<>(T(v));
        return true;
    }

    public final void l0(View view) {
        if (Build.VERSION.SDK_INT < 29 || W() || this.f4586c) {
            return;
        }
        gy.a(view, new c());
    }

    public void m0(View view, int i) {
        int iU;
        int i2;
        if (i == 4) {
            iU = this.i;
        } else if (i == 6) {
            int i3 = this.h;
            if (!this.f4581a || i3 > (i2 = this.g)) {
                iU = i3;
            } else {
                i = 3;
                iU = i2;
            }
        } else if (i == 3) {
            iU = U();
        } else {
            if (!this.f4590g || i != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i);
            }
            iU = this.n;
        }
        p0(view, i, iU, false);
    }

    public final void n0(int i) {
        V v = this.f4578a.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && eh.P(v)) {
            v.post(new a(v, i));
        } else {
            m0(v, i);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.f4583b;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.j != 3 || super.o(coordinatorLayout, v, view, f2, f3);
    }

    public boolean o0(View view, float f2) {
        if (this.f4591h) {
            return true;
        }
        if (view.getTop() < this.i) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.i)) / ((float) O()) > 0.5f;
    }

    public void p0(View view, int i, int i2, boolean z) {
        lk lkVar = this.f4573a;
        if (!(lkVar != null && (!z ? !lkVar.O(view, view.getLeft(), i2) : !lkVar.M(view.getLeft(), i2)))) {
            k0(i);
            return;
        }
        k0(2);
        r0(i);
        if (this.f4577a == null) {
            this.f4577a = new h(view, i);
        }
        if (this.f4577a.b) {
            this.f4577a.f8295a = i;
            return;
        }
        BottomSheetBehavior<V>.h hVar = this.f4577a;
        hVar.f8295a = i;
        eh.c0(view, hVar);
        this.f4577a.b = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f4583b;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i2;
        if (i2 > 0) {
            if (i5 < U()) {
                iArr[1] = top - U();
                eh.W(v, -iArr[1]);
                i4 = 3;
                k0(i4);
            } else {
                if (!this.f4592i) {
                    return;
                }
                iArr[1] = i2;
                eh.W(v, -i2);
                k0(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.i;
            if (i5 > i6 && !this.f4590g) {
                iArr[1] = top - i6;
                eh.W(v, -iArr[1]);
                i4 = 4;
                k0(i4);
            } else {
                if (!this.f4592i) {
                    return;
                }
                iArr[1] = i2;
                eh.W(v, -i2);
                k0(1);
            }
        }
        S(v.getTop());
        this.k = i2;
        this.f4594k = true;
    }

    public final void q0() {
        V v;
        int i;
        ni.a aVar;
        WeakReference<V> weakReference = this.f4578a;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        eh.e0(v, 524288);
        eh.e0(v, 262144);
        eh.e0(v, 1048576);
        if (this.f4590g && this.j != 5) {
            L(v, ni.a.h, 5);
        }
        int i2 = this.j;
        if (i2 == 3) {
            i = this.f4581a ? 4 : 6;
            aVar = ni.a.g;
        } else {
            if (i2 != 4) {
                if (i2 != 6) {
                    return;
                }
                L(v, ni.a.g, 4);
                L(v, ni.a.f, 3);
                return;
            }
            i = this.f4581a ? 3 : 6;
            aVar = ni.a.f;
        }
        L(v, aVar, i);
    }

    public final void r0(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.f4589f != z) {
            this.f4589f = z;
            if (this.f4571a == null || (valueAnimator = this.f4575a) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f4575a.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.f4575a.setFloatValues(1.0f - f2, f2);
            this.f4575a.start();
        }
    }

    public final void s0(boolean z) {
        Map<View, Integer> map;
        int iIntValue;
        WeakReference<V> weakReference = this.f4578a;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.f4580a != null) {
                    return;
                } else {
                    this.f4580a = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.f4578a.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f4580a.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.f4584b) {
                            iIntValue = 4;
                            eh.t0(childAt, iIntValue);
                        }
                    } else if (this.f4584b && (map = this.f4580a) != null && map.containsKey(childAt)) {
                        iIntValue = this.f4580a.get(childAt).intValue();
                        eh.t0(childAt, iIntValue);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f4580a = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public final void t0(boolean z) {
        V v;
        if (this.f4578a != null) {
            M();
            if (this.j != 4 || (v = this.f4578a.get()) == null) {
                return;
            }
            if (z) {
                n0(this.j);
            } else {
                v.requestLayout();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.x(coordinatorLayout, v, gVar.q());
        Y(gVar);
        int i = gVar.f8294a;
        if (i == 1 || i == 2) {
            i = 4;
        }
        this.j = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, V v) {
        return new g(super.y(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }
}
