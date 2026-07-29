package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.R;
import androidx.core.util.j;
import androidx.core.util.n;
import androidx.core.view.g0;
import androidx.core.view.h0;
import androidx.core.view.j0;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.m;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import com.google.common.collect.LinkedHashMultimap;
import g.d0;
import g.i1;
import g.l;
import g.n0;
import g.p0;
import g.v;
import g.x;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CoordinatorLayout extends ViewGroup implements g0, h0 {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final Comparator<View> D;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final n.a<Rect> f4523k0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f4524u = "CoordinatorLayout";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f4525v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f4526w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f4527x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Class<?>[] f4528y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ThreadLocal<Map<String, Constructor<c>>> f4529z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f4530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.a<View> f4531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<View> f4532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<View> f4533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f4534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f4535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f4536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f4539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f4540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f4541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f4542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4543n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j1 f4544o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4545p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f4546q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f4547r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public k0 f4548s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final j0 f4549t;

    public class a implements k0 {
        public a() {
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, j1 j1Var) {
            return CoordinatorLayout.this.b0(j1Var);
        }
    }

    public interface b {
        @n0
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public static void F(@n0 View view, @p0 Object obj) {
            ((g) view.getLayoutParams()).f4570r = obj;
        }

        @p0
        public static Object e(@n0 View view) {
            return ((g) view.getLayoutParams()).f4570r;
        }

        @Deprecated
        public boolean A(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, @n0 View view2, int i10) {
            return false;
        }

        public boolean B(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, @n0 View view2, int i10, int i11) {
            if (i11 == 0) {
                return A(coordinatorLayout, v10, view, view2, i10);
            }
            return false;
        }

        @Deprecated
        public void C(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view) {
        }

        public void D(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10) {
            if (i10 == 0) {
                C(coordinatorLayout, v10, view);
            }
        }

        public boolean E(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 MotionEvent motionEvent) {
            return false;
        }

        public boolean a(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10) {
            return d(coordinatorLayout, v10) > 0.0f;
        }

        public boolean b(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 Rect rect) {
            return false;
        }

        @l
        public int c(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10) {
            return -16777216;
        }

        @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public float d(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10) {
            return 0.0f;
        }

        public boolean f(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view) {
            return false;
        }

        @n0
        public j1 g(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 j1 j1Var) {
            return j1Var;
        }

        public void h(@n0 g gVar) {
        }

        public boolean i(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view) {
            return false;
        }

        public void j(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view) {
        }

        public void k() {
        }

        public boolean l(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 MotionEvent motionEvent) {
            return false;
        }

        public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, int i10) {
            return false;
        }

        public boolean n(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean o(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, float f10, float f11, boolean z10) {
            return false;
        }

        public boolean p(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, float f10, float f11) {
            return false;
        }

        @Deprecated
        public void q(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10, int i11, @n0 int[] iArr) {
        }

        public void r(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10, int i11, @n0 int[] iArr, int i12) {
            if (i12 == 0) {
                q(coordinatorLayout, v10, view, i10, i11, iArr);
            }
        }

        @Deprecated
        public void s(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        public void t(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                s(coordinatorLayout, v10, view, i10, i11, i12, i13);
            }
        }

        public void u(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10, int i11, int i12, int i13, int i14, @n0 int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            t(coordinatorLayout, v10, view, i10, i11, i12, i13, i14);
        }

        @Deprecated
        public void v(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, @n0 View view2, int i10) {
        }

        public void w(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, @n0 View view2, int i10, int i11) {
            if (i11 == 0) {
                v(coordinatorLayout, v10, view, view2, i10);
            }
        }

        public boolean x(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 Rect rect, boolean z10) {
            return false;
        }

        public void y(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 Parcelable parcelable) {
        }

        @p0
        public Parcelable z(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface e {
    }

    public class f implements ViewGroup.OnHierarchyChangeListener {
        public f() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4547r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.M(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4547r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class h implements ViewTreeObserver.OnPreDrawListener {
        public h() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.M(0);
            return true;
        }
    }

    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fF0 = u0.F0(view);
            float fF02 = u0.F0(view2);
            if (fF0 > fF02) {
                return -1;
            }
            return fF0 < fF02 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f4525v = r02 != null ? r02.getName() : null;
        D = new i();
        f4528y = new Class[]{Context.class, AttributeSet.class};
        f4529z = new ThreadLocal<>();
        f4523k0 = new n.c(12);
    }

    public CoordinatorLayout(@n0 Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c P(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(j3.b.f36044h)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f4525v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = f4529z;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f4528y);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e10);
        }
    }

    public static void T(@n0 Rect rect) {
        rect.setEmpty();
        f4523k0.b(rect);
    }

    public static int W(int i10) {
        if (i10 == 0) {
            return 17;
        }
        return i10;
    }

    public static int X(int i10) {
        if ((i10 & 7) == 0) {
            i10 |= m.f5025b;
        }
        return (i10 & 112) == 0 ? i10 | 48 : i10;
    }

    public static int Y(int i10) {
        if (i10 == 0) {
            return 8388661;
        }
        return i10;
    }

    @n0
    public static Rect e() {
        Rect rectA = f4523k0.a();
        return rectA == null ? new Rect() : rectA;
    }

    public static int g(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    public boolean A(@n0 View view, int i10, int i11) {
        Rect rectE = e();
        s(view, rectE);
        try {
            return rectE.contains(i10, i11);
        } finally {
            T(rectE);
        }
    }

    @Override // androidx.core.view.h0
    public void B(@n0 View view, int i10, int i11, int i12, int i13, int i14, @n0 int[] iArr) {
        c cVarF;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.k(i14) && (cVarF = gVar.f()) != null) {
                    int[] iArr2 = this.f4535f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.u(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    int[] iArr3 = this.f4535f;
                    iMax = i12 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    iMax2 = i13 > 0 ? Math.max(iMax2, this.f4535f[1]) : Math.min(iMax2, this.f4535f[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z10) {
            M(1);
        }
    }

    public final void C(View view, int i10) {
        g gVar = (g) view.getLayoutParams();
        Rect rectE = e();
        rectE.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) gVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin);
        if (this.f4544o != null && u0.U(this) && !u0.U(view)) {
            rectE.left += this.f4544o.p();
            rectE.top += this.f4544o.r();
            rectE.right -= this.f4544o.q();
            rectE.bottom -= this.f4544o.o();
        }
        Rect rectE2 = e();
        m.b(X(gVar.f4555c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectE, rectE2, i10);
        view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
        T(rectE);
        T(rectE2);
    }

    @Override // androidx.core.view.g0
    public void D(View view, int i10, int i11, int i12, int i13, int i14) {
        B(view, i10, i11, i12, i13, 0, this.f4536g);
    }

    public final void E(View view, View view2, int i10) {
        Rect rectE = e();
        Rect rectE2 = e();
        try {
            s(view2, rectE);
            t(view, i10, rectE, rectE2);
            view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
        } finally {
            T(rectE);
            T(rectE2);
        }
    }

    public final void F(View view, int i10, int i11) {
        g gVar = (g) view.getLayoutParams();
        int iD = m.d(Y(gVar.f4555c), i11);
        int i12 = iD & 7;
        int i13 = iD & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i11 == 1) {
            i10 = width - i10;
        }
        int iV = v(i10) - measuredWidth;
        int i14 = 0;
        if (i12 == 1) {
            iV += measuredWidth / 2;
        } else if (i12 == 5) {
            iV += measuredWidth;
        }
        if (i13 == 16) {
            i14 = 0 + (measuredHeight / 2);
        } else if (i13 == 80) {
            i14 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) gVar).leftMargin, Math.min(iV, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin, Math.min(i14, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    @Override // androidx.core.view.g0
    public boolean G(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                c cVarF = gVar.f();
                if (cVarF != null) {
                    boolean zB = cVarF.B(this, childAt, view, view2, i10, i11);
                    z10 |= zB;
                    gVar.t(i11, zB);
                } else {
                    gVar.t(i11, false);
                }
            }
        }
        return z10;
    }

    @Override // androidx.core.view.g0
    public void H(View view, View view2, int i10, int i11) {
        c cVarF;
        this.f4549t.c(view, view2, i10, i11);
        this.f4541l = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            g gVar = (g) childAt.getLayoutParams();
            if (gVar.k(i11) && (cVarF = gVar.f()) != null) {
                cVarF.w(this, childAt, view, view2, i10, i11);
            }
        }
    }

    public final void I(View view, Rect rect, int i10) {
        boolean z10;
        boolean z11;
        int width;
        int i11;
        int i12;
        int i13;
        int height;
        int i14;
        int i15;
        int i16;
        if (u0.U0(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            g gVar = (g) view.getLayoutParams();
            c cVarF = gVar.f();
            Rect rectE = e();
            Rect rectE2 = e();
            rectE2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (cVarF == null || !cVarF.b(this, view, rectE)) {
                rectE.set(rectE2);
            } else if (!rectE2.contains(rectE)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectE.toShortString() + " | Bounds:" + rectE2.toShortString());
            }
            T(rectE2);
            if (rectE.isEmpty()) {
                T(rectE);
                return;
            }
            int iD = m.d(gVar.f4560h, i10);
            boolean z12 = true;
            if ((iD & 48) != 48 || (i15 = (rectE.top - ((ViewGroup.MarginLayoutParams) gVar).topMargin) - gVar.f4562j) >= (i16 = rect.top)) {
                z10 = false;
            } else {
                a0(view, i16 - i15);
                z10 = true;
            }
            if ((iD & 80) == 80 && (height = ((getHeight() - rectE.bottom) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) + gVar.f4562j) < (i14 = rect.bottom)) {
                a0(view, height - i14);
                z10 = true;
            }
            if (!z10) {
                a0(view, 0);
            }
            if ((iD & 3) != 3 || (i12 = (rectE.left - ((ViewGroup.MarginLayoutParams) gVar).leftMargin) - gVar.f4561i) >= (i13 = rect.left)) {
                z11 = false;
            } else {
                Z(view, i13 - i12);
                z11 = true;
            }
            if ((iD & 5) != 5 || (width = ((getWidth() - rectE.right) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin) + gVar.f4561i) >= (i11 = rect.right)) {
                z12 = z11;
            } else {
                Z(view, width - i11);
            }
            if (!z12) {
                Z(view, 0);
            }
            T(rectE);
        }
    }

    @Override // androidx.core.view.g0
    public void J(View view, int i10) {
        this.f4549t.e(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            g gVar = (g) childAt.getLayoutParams();
            if (gVar.k(i10)) {
                c cVarF = gVar.f();
                if (cVarF != null) {
                    cVarF.D(this, childAt, view, i10);
                }
                gVar.m(i10);
                gVar.l();
            }
        }
        this.f4541l = null;
    }

    @Override // androidx.core.view.g0
    public void K(View view, int i10, int i11, int[] iArr, int i12) {
        c cVarF;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.k(i12) && (cVarF = gVar.f()) != null) {
                    int[] iArr2 = this.f4535f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.r(this, childAt, view, i10, i11, iArr2, i12);
                    int[] iArr3 = this.f4535f;
                    iMax = i10 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f4535f;
                    iMax2 = i11 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z10) {
            M(1);
        }
    }

    public void L(View view, int i10) {
        c cVarF;
        g gVar = (g) view.getLayoutParams();
        if (gVar.f4563k != null) {
            Rect rectE = e();
            Rect rectE2 = e();
            Rect rectE3 = e();
            s(gVar.f4563k, rectE);
            p(view, false, rectE2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            u(view, i10, rectE, rectE3, gVar, measuredWidth, measuredHeight);
            boolean z10 = (rectE3.left == rectE2.left && rectE3.top == rectE2.top) ? false : true;
            h(gVar, rectE3, measuredWidth, measuredHeight);
            int i11 = rectE3.left - rectE2.left;
            int i12 = rectE3.top - rectE2.top;
            if (i11 != 0) {
                u0.e1(view, i11);
            }
            if (i12 != 0) {
                u0.f1(view, i12);
            }
            if (z10 && (cVarF = gVar.f()) != null) {
                cVarF.i(this, view, gVar.f4563k);
            }
            T(rectE);
            T(rectE2);
            T(rectE3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M(int r18) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.M(int):void");
    }

    public void N(@n0 View view, int i10) {
        g gVar = (g) view.getLayoutParams();
        if (gVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = gVar.f4563k;
        if (view2 != null) {
            E(view, view2, i10);
            return;
        }
        int i11 = gVar.f4557e;
        if (i11 >= 0) {
            F(view, i11, i10);
        } else {
            C(view, i10);
        }
    }

    public void O(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    public final boolean Q(MotionEvent motionEvent, int i10) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f4532c;
        y(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zL = false;
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = list.get(i11);
            g gVar = (g) view.getLayoutParams();
            c cVarF = gVar.f();
            if (!(zL || z10) || actionMasked == 0) {
                if (!zL && cVarF != null) {
                    if (i10 == 0) {
                        zL = cVarF.l(this, view, motionEvent);
                    } else if (i10 == 1) {
                        zL = cVarF.E(this, view, motionEvent);
                    }
                    if (zL) {
                        this.f4540k = view;
                    }
                }
                boolean zC = gVar.c();
                boolean zJ = gVar.j(this, view);
                z10 = zJ && !zC;
                if (zJ && !z10) {
                    break;
                }
            } else if (cVarF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i10 == 0) {
                    cVarF.l(this, view, motionEventObtain);
                } else if (i10 == 1) {
                    cVarF.E(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zL;
    }

    public final void R() {
        this.f4530a.clear();
        this.f4531b.c();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            g gVarX = x(childAt);
            gVarX.d(this, childAt);
            this.f4531b.b(childAt);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (i11 != i10) {
                    View childAt2 = getChildAt(i11);
                    if (gVarX.b(this, childAt, childAt2)) {
                        if (!this.f4531b.d(childAt2)) {
                            this.f4531b.b(childAt2);
                        }
                        this.f4531b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f4530a.addAll(this.f4531b.i());
        Collections.reverse(this.f4530a);
    }

    public void S(View view, Rect rect) {
        ((g) view.getLayoutParams()).s(rect);
    }

    public void U() {
        if (this.f4538i && this.f4542m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4542m);
        }
        this.f4543n = false;
    }

    public final void V(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            c cVarF = ((g) childAt.getLayoutParams()).f();
            if (cVarF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    cVarF.l(this, childAt, motionEventObtain);
                } else {
                    cVarF.E(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((g) getChildAt(i11).getLayoutParams()).n();
        }
        this.f4540k = null;
        this.f4537h = false;
    }

    public final void Z(View view, int i10) {
        g gVar = (g) view.getLayoutParams();
        int i11 = gVar.f4561i;
        if (i11 != i10) {
            u0.e1(view, i10 - i11);
            gVar.f4561i = i10;
        }
    }

    public final void a0(View view, int i10) {
        g gVar = (g) view.getLayoutParams();
        int i11 = gVar.f4562j;
        if (i11 != i10) {
            u0.f1(view, i10 - i11);
            gVar.f4562j = i10;
        }
    }

    public final j1 b0(j1 j1Var) {
        if (j.a(this.f4544o, j1Var)) {
            return j1Var;
        }
        this.f4544o = j1Var;
        boolean z10 = j1Var != null && j1Var.r() > 0;
        this.f4545p = z10;
        setWillNotDraw(!z10 && getBackground() == null);
        j1 j1VarI = i(j1Var);
        requestLayout();
        return j1VarI;
    }

    public final void c0() {
        if (!u0.U(this)) {
            u0.a2(this, null);
            return;
        }
        if (this.f4548s == null) {
            this.f4548s = new a();
        }
        u0.a2(this, this.f4548s);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        g gVar = (g) view.getLayoutParams();
        c cVar = gVar.f4553a;
        if (cVar != null) {
            float fD = cVar.d(this, view);
            if (fD > 0.0f) {
                if (this.f4534e == null) {
                    this.f4534e = new Paint();
                }
                this.f4534e.setColor(gVar.f4553a.c(this, view));
                this.f4534e.setAlpha(g(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f4534e);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4546q;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public void f() {
        if (this.f4538i) {
            if (this.f4542m == null) {
                this.f4542m = new h();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4542m);
        }
        this.f4543n = true;
    }

    @i1
    public final List<View> getDependencySortedChildren() {
        R();
        return Collections.unmodifiableList(this.f4530a);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final j1 getLastWindowInsets() {
        return this.f4544o;
    }

    @Override // android.view.ViewGroup, androidx.core.view.i0
    public int getNestedScrollAxes() {
        return this.f4549t.a();
    }

    @p0
    public Drawable getStatusBarBackground() {
        return this.f4546q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public final void h(g gVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) gVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin));
        rect.set(iMax, iMax2, i10 + iMax, i11 + iMax2);
    }

    public final j1 i(j1 j1Var) {
        c cVarF;
        if (j1Var.A()) {
            return j1Var;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (u0.U(childAt) && (cVarF = ((g) childAt.getLayoutParams()).f()) != null) {
                j1Var = cVarF.g(this, childAt, j1Var);
                if (j1Var.A()) {
                    break;
                }
            }
        }
        return j1Var;
    }

    public void j(@n0 View view) {
        List listG = this.f4531b.g(view);
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < listG.size(); i10++) {
            View view2 = (View) listG.get(i10);
            c cVarF = ((g) view2.getLayoutParams()).f();
            if (cVarF != null) {
                cVarF.i(this, view2, view);
            }
        }
    }

    public boolean k(@n0 View view, @n0 View view2) {
        boolean z10 = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rectE = e();
        p(view, view.getParent() != this, rectE);
        Rect rectE2 = e();
        p(view2, view2.getParent() != this, rectE2);
        try {
            if (rectE.left <= rectE2.right && rectE.top <= rectE2.bottom && rectE.right >= rectE2.left) {
                if (rectE.bottom >= rectE2.top) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            T(rectE);
            T(rectE2);
        }
    }

    public void l() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (z(getChildAt(i10))) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10 != this.f4543n) {
            if (z10) {
                f();
            } else {
                U();
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        V(false);
        if (this.f4543n) {
            if (this.f4542m == null) {
                this.f4542m = new h();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4542m);
        }
        if (this.f4544o == null && u0.U(this)) {
            u0.v1(this);
        }
        this.f4538i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        V(false);
        if (this.f4543n && this.f4542m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4542m);
        }
        View view = this.f4541l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f4538i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f4545p || this.f4546q == null) {
            return;
        }
        j1 j1Var = this.f4544o;
        int iR = j1Var != null ? j1Var.r() : 0;
        if (iR > 0) {
            this.f4546q.setBounds(0, 0, getWidth(), iR);
            this.f4546q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            V(true);
        }
        boolean zQ = Q(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            V(true);
        }
        return zQ;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        c cVarF;
        int iZ = u0.Z(this);
        int size = this.f4530a.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = this.f4530a.get(i14);
            if (view.getVisibility() != 8 && ((cVarF = ((g) view.getLayoutParams()).f()) == null || !cVarF.m(this, view, iZ))) {
                N(view, iZ);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        c cVarF;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.k(0) && (cVarF = gVar.f()) != null) {
                    zO |= cVarF.o(this, childAt, view, f10, f11, z10);
                }
            }
        }
        if (zO) {
            M(1);
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedPreFling(View view, float f10, float f11) {
        c cVarF;
        int childCount = getChildCount();
        boolean zP = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.k(0) && (cVarF = gVar.f()) != null) {
                    zP |= cVarF.p(this, childAt, view, f10, f11);
                }
            }
        }
        return zP;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        K(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        D(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        H(view, view2, i10, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f4550c;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            c cVarF = x(childAt).f();
            if (id2 != -1 && cVarF != null && (parcelable2 = sparseArray.get(id2)) != null) {
                cVarF.y(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableZ;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            c cVarF = ((g) childAt.getLayoutParams()).f();
            if (id2 != -1 && cVarF != null && (parcelableZ = cVarF.z(this, childAt)) != null) {
                sparseArray.append(id2, parcelableZ);
            }
        }
        savedState.f4550c = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return G(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onStopNestedScroll(View view) {
        J(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[PHI: r3
  0x002b: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f4540k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.Q(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.f4540k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$g r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.g) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.f4540k
            boolean r6 = r6.E(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.f4540k
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.V(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(View view, boolean z10, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            s(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @n0
    public List<View> q(@n0 View view) {
        List<View> listH = this.f4531b.h(view);
        this.f4533d.clear();
        if (listH != null) {
            this.f4533d.addAll(listH);
        }
        return this.f4533d;
    }

    @n0
    public List<View> r(@n0 View view) {
        List listG = this.f4531b.g(view);
        this.f4533d.clear();
        if (listG != null) {
            this.f4533d.addAll(listG);
        }
        return this.f4533d;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        c cVarF = ((g) view.getLayoutParams()).f();
        if (cVarF == null || !cVarF.x(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (!z10 || this.f4537h) {
            return;
        }
        V(false);
        this.f4537h = true;
    }

    public void s(View view, Rect rect) {
        d0.b.a(this, view, rect);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        c0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f4547r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@p0 Drawable drawable) {
        Drawable drawable2 = this.f4546q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f4546q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f4546q.setState(getDrawableState());
                }
                n0.c.m(this.f4546q, u0.Z(this));
                this.f4546q.setVisible(getVisibility() == 0, false);
                this.f4546q.setCallback(this);
            }
            u0.n1(this);
        }
    }

    public void setStatusBarBackgroundColor(@l int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(@v int i10) {
        setStatusBarBackground(i10 != 0 ? h0.d.i(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f4546q;
        if (drawable == null || drawable.isVisible() == z10) {
            return;
        }
        this.f4546q.setVisible(z10, false);
    }

    public void t(View view, int i10, Rect rect, Rect rect2) {
        g gVar = (g) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        u(view, i10, rect, rect2, gVar, measuredWidth, measuredHeight);
        h(gVar, rect2, measuredWidth, measuredHeight);
    }

    public final void u(View view, int i10, Rect rect, Rect rect2, g gVar, int i11, int i12) {
        int iD = m.d(W(gVar.f4555c), i10);
        int iD2 = m.d(X(gVar.f4556d), i10);
        int i13 = iD & 7;
        int i14 = iD & 112;
        int i15 = iD2 & 7;
        int i16 = iD2 & 112;
        int iWidth = i15 != 1 ? i15 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i16 != 16 ? i16 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i13 == 1) {
            iWidth -= i11 / 2;
        } else if (i13 != 5) {
            iWidth -= i11;
        }
        if (i14 == 16) {
            iHeight -= i12 / 2;
        } else if (i14 != 80) {
            iHeight -= i12;
        }
        rect2.set(iWidth, iHeight, i11 + iWidth, i12 + iHeight);
    }

    public final int v(int i10) {
        int[] iArr = this.f4539j;
        if (iArr == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No keylines defined for ");
            sb2.append(this);
            sb2.append(" - attempted index lookup ");
            sb2.append(i10);
            return 0;
        }
        if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Keyline index ");
        sb3.append(i10);
        sb3.append(" out of range for ");
        sb3.append(this);
        return 0;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4546q;
    }

    public void w(View view, Rect rect) {
        rect.set(((g) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g x(View view) {
        g gVar = (g) view.getLayoutParams();
        if (!gVar.f4554b) {
            if (view instanceof b) {
                gVar.q(((b) view).getBehavior());
                gVar.f4554b = true;
            } else {
                d dVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    dVar = (d) superclass.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        gVar.q(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Default behavior class ");
                        sb2.append(dVar.value().getName());
                        sb2.append(" could not be instantiated. Did you forget a default constructor?");
                    }
                }
                gVar.f4554b = true;
            }
        }
        return gVar;
    }

    public final void y(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        Comparator<View> comparator = D;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public final boolean z(View view) {
        return this.f4531b.j(view);
    }

    public CoordinatorLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i10);
        this.f4530a = new ArrayList();
        this.f4531b = new d0.a<>();
        this.f4532c = new ArrayList();
        this.f4533d = new ArrayList();
        this.f4535f = new int[2];
        this.f4536g = new int[2];
        this.f4549t = new j0(this);
        if (i10 == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i10, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i10 == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f4539j = resources.getIntArray(resourceId);
            float f10 = resources.getDisplayMetrics().density;
            int length = this.f4539j.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.f4539j[i11] = (int) (r12[i11] * f10);
            }
        }
        this.f4546q = typedArrayObtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        c0();
        super.setOnHierarchyChangeListener(new f());
        if (u0.V(this) == 0) {
            u0.R1(this, 1);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SparseArray<Parcelable> f4550c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i10 = parcel.readInt();
            int[] iArr = new int[i10];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f4550c = new SparseArray<>(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.f4550c.append(iArr[i11], parcelableArray[i11]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            SparseArray<Parcelable> sparseArray = this.f4550c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = this.f4550c.keyAt(i11);
                parcelableArr[i11] = this.f4550c.valueAt(i11);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class g extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f4553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4556d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4557e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4558f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4559g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4560h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4561i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4562j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f4563k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View f4564l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4565m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f4566n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f4567o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f4568p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Rect f4569q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f4570r;

        public g(int i10, int i11) {
            super(i10, i11);
            this.f4554b = false;
            this.f4555c = 0;
            this.f4556d = 0;
            this.f4557e = -1;
            this.f4558f = -1;
            this.f4559g = 0;
            this.f4560h = 0;
            this.f4569q = new Rect();
        }

        public boolean a() {
            return this.f4563k == null && this.f4558f != -1;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f4564l || u(view2, u0.Z(coordinatorLayout)) || ((cVar = this.f4553a) != null && cVar.f(coordinatorLayout, view, view2));
        }

        public boolean c() {
            if (this.f4553a == null) {
                this.f4565m = false;
            }
            return this.f4565m;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f4558f == -1) {
                this.f4564l = null;
                this.f4563k = null;
                return null;
            }
            if (this.f4563k == null || !v(view, coordinatorLayout)) {
                o(view, coordinatorLayout);
            }
            return this.f4563k;
        }

        @d0
        public int e() {
            return this.f4558f;
        }

        @p0
        public c f() {
            return this.f4553a;
        }

        public boolean g() {
            return this.f4568p;
        }

        public Rect h() {
            return this.f4569q;
        }

        public void i() {
            this.f4564l = null;
            this.f4563k = null;
        }

        public boolean j(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10 = this.f4565m;
            if (z10) {
                return true;
            }
            c cVar = this.f4553a;
            boolean zA = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z10;
            this.f4565m = zA;
            return zA;
        }

        public boolean k(int i10) {
            if (i10 == 0) {
                return this.f4566n;
            }
            if (i10 != 1) {
                return false;
            }
            return this.f4567o;
        }

        public void l() {
            this.f4568p = false;
        }

        public void m(int i10) {
            t(i10, false);
        }

        public void n() {
            this.f4565m = false;
        }

        public final void o(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f4558f);
            this.f4563k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f4564l = null;
                    this.f4563k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f4558f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f4564l = null;
                this.f4563k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f4564l = null;
                    this.f4563k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f4564l = viewFindViewById;
        }

        public void p(@d0 int i10) {
            i();
            this.f4558f = i10;
        }

        public void q(@p0 c cVar) {
            c cVar2 = this.f4553a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.k();
                }
                this.f4553a = cVar;
                this.f4570r = null;
                this.f4554b = true;
                if (cVar != null) {
                    cVar.h(this);
                }
            }
        }

        public void r(boolean z10) {
            this.f4568p = z10;
        }

        public void s(Rect rect) {
            this.f4569q.set(rect);
        }

        public void t(int i10, boolean z10) {
            if (i10 == 0) {
                this.f4566n = z10;
            } else {
                if (i10 != 1) {
                    return;
                }
                this.f4567o = z10;
            }
        }

        public final boolean u(View view, int i10) {
            int iD = m.d(((g) view.getLayoutParams()).f4559g, i10);
            return iD != 0 && (m.d(this.f4560h, i10) & iD) == iD;
        }

        public final boolean v(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f4563k.getId() != this.f4558f) {
                return false;
            }
            View view2 = this.f4563k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f4564l = null;
                    this.f4563k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f4564l = view2;
            return true;
        }

        public g(@n0 Context context, @p0 AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4554b = false;
            this.f4555c = 0;
            this.f4556d = 0;
            this.f4557e = -1;
            this.f4558f = -1;
            this.f4559g = 0;
            this.f4560h = 0;
            this.f4569q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f4555c = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f4558f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f4556d = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f4557e = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f4559g = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f4560h = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i10 = R.styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i10);
            this.f4554b = zHasValue;
            if (zHasValue) {
                this.f4553a = CoordinatorLayout.P(context, attributeSet, typedArrayObtainStyledAttributes.getString(i10));
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f4553a;
            if (cVar != null) {
                cVar.h(this);
            }
        }

        public g(g gVar) {
            super((ViewGroup.MarginLayoutParams) gVar);
            this.f4554b = false;
            this.f4555c = 0;
            this.f4556d = 0;
            this.f4557e = -1;
            this.f4558f = -1;
            this.f4559g = 0;
            this.f4560h = 0;
            this.f4569q = new Rect();
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4554b = false;
            this.f4555c = 0;
            this.f4556d = 0;
            this.f4557e = -1;
            this.f4558f = -1;
            this.f4559g = 0;
            this.f4560h = 0;
            this.f4569q = new Rect();
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4554b = false;
            this.f4555c = 0;
            this.f4556d = 0;
            this.f4557e = -1;
            this.f4558f = -1;
            this.f4559g = 0;
            this.f4560h = 0;
            this.f4569q = new Rect();
        }
    }
}
