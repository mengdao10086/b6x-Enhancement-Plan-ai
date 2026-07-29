package androidx.drawerlayout.widget;

import a1.d;
import a1.g;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import androidx.core.view.j1;
import androidx.core.view.m;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import e1.d;
import g.l;
import g.n0;
import g.p0;
import g.v;
import java.util.ArrayList;
import java.util.List;
import m0.i;

/* JADX INFO: loaded from: classes2.dex */
public class DrawerLayout extends ViewGroup implements e1.c {
    public static final String C2 = "DrawerLayout";
    public static final int E7 = 0;
    public static final int F7 = 1;
    public static final int G7 = 2;
    public static final int H7 = 0;
    public static final int I7 = 1;
    public static final int J7 = 2;
    public static final int K7 = 3;
    public static final int L7 = 64;
    public static final int M7 = -1728053248;
    public static final int N7 = 160;
    public static final int O7 = 400;
    public static final boolean P7 = false;
    public static final boolean Q7 = true;
    public static final float R7 = 1.0f;
    public static final boolean T7;
    public static final boolean U7;
    public static final String V7 = "androidx.drawerlayout.widget.DrawerLayout";
    public static boolean W7;
    public CharSequence A;
    public Object B;
    public boolean C;
    public Rect C1;
    public Drawable D;
    public Drawable K0;
    public Matrix K1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f5284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f5285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f5289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e1.d f5290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e1.d f5291h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f5292i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f5293j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5294k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Drawable f5295k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public Drawable f5296k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5297l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5298m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5299n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5300o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5301p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5302q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f5303r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public e f5304s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<e> f5305t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f5306u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f5307v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final ArrayList<View> f5308v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final a1.g f5309v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f5310w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f5311x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f5312y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f5313z;
    public static final int[] K2 = {R.attr.colorPrimaryDark};
    public static final int[] S7 = {R.attr.layout_gravity};

    public class a implements a1.g {
        public a() {
        }

        @Override // a1.g
        public boolean a(@n0 View view, @p0 g.a aVar) {
            if (!DrawerLayout.this.D(view) || DrawerLayout.this.r(view) == 2) {
                return false;
            }
            DrawerLayout.this.f(view);
            return true;
        }
    }

    public class b implements View.OnApplyWindowInsetsListener {
        public b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).S(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public class c extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f5321d = new Rect();

        public c() {
        }

        @Override // androidx.core.view.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewP = DrawerLayout.this.p();
            if (viewP == null) {
                return true;
            }
            CharSequence charSequenceS = DrawerLayout.this.s(DrawerLayout.this.t(viewP));
            if (charSequenceS == null) {
                return true;
            }
            text.add(charSequenceS);
            return true;
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.V7);
        }

        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            if (DrawerLayout.T7) {
                super.g(view, dVar);
            } else {
                a1.d dVarI0 = a1.d.I0(dVar);
                super.g(view, dVarI0);
                dVar.P1(view);
                Object objL0 = u0.l0(view);
                if (objL0 instanceof View) {
                    dVar.F1((View) objL0);
                }
                o(dVar, dVarI0);
                dVarI0.N0();
                n(dVar, (ViewGroup) view);
            }
            dVar.b1(DrawerLayout.V7);
            dVar.n1(false);
            dVar.o1(false);
            dVar.P0(d.a.f106f);
            dVar.P0(d.a.f107g);
        }

        @Override // androidx.core.view.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.T7 || DrawerLayout.A(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        public final void n(a1.d dVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (DrawerLayout.A(childAt)) {
                    dVar.c(childAt);
                }
            }
        }

        public final void o(a1.d dVar, a1.d dVar2) {
            Rect rect = this.f5321d;
            dVar2.t(rect);
            dVar.X0(rect);
            dVar.e2(dVar2.G0());
            dVar.D1(dVar2.P());
            dVar.b1(dVar2.w());
            dVar.f1(dVar2.A());
            dVar.l1(dVar2.s0());
            dVar.o1(dVar2.u0());
            dVar.T0(dVar2.k0());
            dVar.N1(dVar2.C0());
            dVar.a(dVar2.p());
        }
    }

    public static final class d extends androidx.core.view.a {
        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            if (DrawerLayout.A(view)) {
                return;
            }
            dVar.F1(null);
        }
    }

    public interface e {
        void a(@n0 View view);

        void b(@n0 View view);

        void c(int i10);

        void d(@n0 View view, float f10);
    }

    public static abstract class g implements e {
        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View view) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void c(int i10) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void d(View view, float f10) {
        }
    }

    public class h extends d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e1.d f5331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f5332c = new a();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.o();
            }
        }

        public h(int i10) {
            this.f5330a = i10;
        }

        @Override // e1.d.c
        public int a(View view, int i10, int i11) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i10, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i10, width));
        }

        @Override // e1.d.c
        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // e1.d.c
        public int d(View view) {
            if (DrawerLayout.this.E(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // e1.d.c
        public void f(int i10, int i11) {
            View viewN = (i10 & 1) == 1 ? DrawerLayout.this.n(3) : DrawerLayout.this.n(5);
            if (viewN == null || DrawerLayout.this.r(viewN) != 0) {
                return;
            }
            this.f5331b.d(viewN, i11);
        }

        @Override // e1.d.c
        public boolean g(int i10) {
            return false;
        }

        @Override // e1.d.c
        public void h(int i10, int i11) {
            DrawerLayout.this.postDelayed(this.f5332c, 160L);
        }

        @Override // e1.d.c
        public void i(View view, int i10) {
            ((f) view.getLayoutParams()).f5328c = false;
            n();
        }

        @Override // e1.d.c
        public void j(int i10) {
            DrawerLayout.this.b0(i10, this.f5331b.z());
        }

        @Override // e1.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            float width = (DrawerLayout.this.c(view, 3) ? i10 + r3 : DrawerLayout.this.getWidth() - i10) / view.getWidth();
            DrawerLayout.this.Y(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // e1.d.c
        public void l(View view, float f10, float f11) {
            int i10;
            float fU = DrawerLayout.this.u(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i10 = (f10 > 0.0f || (f10 == 0.0f && fU > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f10 < 0.0f || (f10 == 0.0f && fU > 0.5f)) {
                    width2 -= width;
                }
                i10 = width2;
            }
            this.f5331b.V(i10, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // e1.d.c
        public boolean m(View view, int i10) {
            return DrawerLayout.this.E(view) && DrawerLayout.this.c(view, this.f5330a) && DrawerLayout.this.r(view) == 0;
        }

        public final void n() {
            View viewN = DrawerLayout.this.n(this.f5330a == 3 ? 5 : 3);
            if (viewN != null) {
                DrawerLayout.this.f(viewN);
            }
        }

        public void o() {
            View viewN;
            int width;
            int iB = this.f5331b.B();
            boolean z10 = this.f5330a == 3;
            if (z10) {
                viewN = DrawerLayout.this.n(3);
                width = (viewN != null ? -viewN.getWidth() : 0) + iB;
            } else {
                viewN = DrawerLayout.this.n(5);
                width = DrawerLayout.this.getWidth() - iB;
            }
            if (viewN != null) {
                if (((!z10 || viewN.getLeft() >= width) && (z10 || viewN.getLeft() <= width)) || DrawerLayout.this.r(viewN) != 0) {
                    return;
                }
                f fVar = (f) viewN.getLayoutParams();
                this.f5331b.X(viewN, width, viewN.getTop());
                fVar.f5328c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f5332c);
        }

        public void q(e1.d dVar) {
            this.f5331b = dVar;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        T7 = true;
        U7 = true;
        W7 = i10 >= 29;
    }

    public DrawerLayout(@n0 Context context) {
        this(context, null);
    }

    public static boolean A(View view) {
        return (u0.V(view) == 4 || u0.V(view) == 2) ? false : true;
    }

    public static String w(int i10) {
        return (i10 & 3) == 3 ? "LEFT" : (i10 & 5) == 5 ? "RIGHT" : Integer.toHexString(i10);
    }

    public static boolean x(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public boolean B(View view) {
        return ((f) view.getLayoutParams()).f5326a == 0;
    }

    public boolean C(int i10) {
        View viewN = n(i10);
        if (viewN != null) {
            return D(viewN);
        }
        return false;
    }

    public boolean D(@n0 View view) {
        if (E(view)) {
            return (((f) view.getLayoutParams()).f5329d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean E(View view) {
        int iD = m.d(((f) view.getLayoutParams()).f5326a, u0.Z(view));
        return ((iD & 3) == 0 && (iD & 5) == 0) ? false : true;
    }

    public boolean F(int i10) {
        View viewN = n(i10);
        if (viewN != null) {
            return G(viewN);
        }
        return false;
    }

    public boolean G(@n0 View view) {
        if (E(view)) {
            return ((f) view.getLayoutParams()).f5327b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final boolean H(float f10, float f11, View view) {
        if (this.C1 == null) {
            this.C1 = new Rect();
        }
        view.getHitRect(this.C1);
        return this.C1.contains((int) f10, (int) f11);
    }

    public final void I(Drawable drawable, int i10) {
        if (drawable == null || !n0.c.h(drawable)) {
            return;
        }
        n0.c.m(drawable, i10);
    }

    public void J(View view, float f10) {
        float fU = u(view);
        float width = view.getWidth();
        int i10 = ((int) (width * f10)) - ((int) (fU * width));
        if (!c(view, 3)) {
            i10 = -i10;
        }
        view.offsetLeftAndRight(i10);
        Y(view, f10);
    }

    public void K(int i10) {
        L(i10, true);
    }

    public void L(int i10, boolean z10) {
        View viewN = n(i10);
        if (viewN != null) {
            N(viewN, z10);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i10));
    }

    public void M(@n0 View view) {
        N(view, true);
    }

    public void N(@n0 View view, boolean z10) {
        if (!E(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.f5298m) {
            fVar.f5327b = 1.0f;
            fVar.f5329d = 1;
            a0(view, true);
            Z(view);
        } else if (z10) {
            fVar.f5329d |= 2;
            if (c(view, 3)) {
                this.f5290g.X(view, 0, view.getTop());
            } else {
                this.f5291h.X(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            J(view, 1.0f);
            b0(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void O(@n0 e eVar) {
        List<e> list;
        if (eVar == null || (list = this.f5305t) == null) {
            return;
        }
        list.remove(eVar);
    }

    public final Drawable P() {
        int iZ = u0.Z(this);
        if (iZ == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                I(drawable, iZ);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.f5295k0;
            if (drawable2 != null) {
                I(drawable2, iZ);
                return this.f5295k0;
            }
        }
        return this.K0;
    }

    public final Drawable Q() {
        int iZ = u0.Z(this);
        if (iZ == 0) {
            Drawable drawable = this.f5295k0;
            if (drawable != null) {
                I(drawable, iZ);
                return this.f5295k0;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                I(drawable2, iZ);
                return this.D;
            }
        }
        return this.f5296k1;
    }

    public final void R() {
        if (U7) {
            return;
        }
        this.f5311x = P();
        this.f5312y = Q();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void S(Object obj, boolean z10) {
        this.B = obj;
        this.C = z10;
        setWillNotDraw(!z10 && getBackground() == null);
        requestLayout();
    }

    public void T(int i10, int i11) {
        View viewN;
        int iD = m.d(i11, u0.Z(this));
        if (i11 == 3) {
            this.f5299n = i10;
        } else if (i11 == 5) {
            this.f5300o = i10;
        } else if (i11 == 8388611) {
            this.f5301p = i10;
        } else if (i11 == 8388613) {
            this.f5302q = i10;
        }
        if (i10 != 0) {
            (iD == 3 ? this.f5290g : this.f5291h).c();
        }
        if (i10 != 1) {
            if (i10 == 2 && (viewN = n(iD)) != null) {
                M(viewN);
                return;
            }
            return;
        }
        View viewN2 = n(iD);
        if (viewN2 != null) {
            f(viewN2);
        }
    }

    public void U(int i10, @n0 View view) {
        if (E(view)) {
            T(i10, ((f) view.getLayoutParams()).f5326a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void V(@v int i10, int i11) {
        W(h0.d.i(getContext(), i10), i11);
    }

    public void W(Drawable drawable, int i10) {
        if (U7) {
            return;
        }
        if ((i10 & m.f5025b) == 8388611) {
            this.D = drawable;
        } else if ((i10 & 8388613) == 8388613) {
            this.f5295k0 = drawable;
        } else if ((i10 & 3) == 3) {
            this.K0 = drawable;
        } else if ((i10 & 5) != 5) {
            return;
        } else {
            this.f5296k1 = drawable;
        }
        R();
        invalidate();
    }

    public void X(int i10, @p0 CharSequence charSequence) {
        int iD = m.d(i10, u0.Z(this));
        if (iD == 3) {
            this.f5313z = charSequence;
        } else if (iD == 5) {
            this.A = charSequence;
        }
    }

    public void Y(View view, float f10) {
        f fVar = (f) view.getLayoutParams();
        if (f10 == fVar.f5327b) {
            return;
        }
        fVar.f5327b = f10;
        l(view, f10);
    }

    public final void Z(View view) {
        d.a aVar = d.a.f126z;
        u0.r1(view, aVar.b());
        if (!D(view) || r(view) == 2) {
            return;
        }
        u0.u1(view, aVar, null, this.f5309v2);
    }

    public void a(@n0 e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.f5305t == null) {
            this.f5305t = new ArrayList();
        }
        this.f5305t.add(eVar);
    }

    public final void a0(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((z10 || E(childAt)) && !(z10 && childAt == view)) {
                u0.R1(childAt, 4);
            } else {
                u0.R1(childAt, 1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (!E(childAt)) {
                this.f5308v1.add(childAt);
            } else if (D(childAt)) {
                childAt.addFocusables(arrayList, i10, i11);
                z10 = true;
            }
        }
        if (!z10) {
            int size = this.f5308v1.size();
            for (int i13 = 0; i13 < size; i13++) {
                View view = this.f5308v1.get(i13);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i10, i11);
                }
            }
        }
        this.f5308v1.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (o() != null || E(view)) {
            u0.R1(view, 4);
        } else {
            u0.R1(view, 1);
        }
        if (T7) {
            return;
        }
        u0.B1(view, this.f5284a);
    }

    public void b() {
        if (this.f5303r) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.f5303r = true;
    }

    public void b0(int i10, View view) {
        int iF = this.f5290g.F();
        int iF2 = this.f5291h.F();
        int i11 = 2;
        if (iF == 1 || iF2 == 1) {
            i11 = 1;
        } else if (iF != 2 && iF2 != 2) {
            i11 = 0;
        }
        if (view != null && i10 == 0) {
            float f10 = ((f) view.getLayoutParams()).f5327b;
            if (f10 == 0.0f) {
                j(view);
            } else if (f10 == 1.0f) {
                k(view);
            }
        }
        if (i11 != this.f5294k) {
            this.f5294k = i11;
            List<e> list = this.f5305t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f5305t.get(size).c(i11);
                }
            }
        }
    }

    public boolean c(View view, int i10) {
        return (t(view) & i10) == i10;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // e1.c
    public void close() {
        d(m.f5025b);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            fMax = Math.max(fMax, ((f) getChildAt(i10).getLayoutParams()).f5327b);
        }
        this.f5288e = fMax;
        boolean zO = this.f5290g.o(true);
        boolean zO2 = this.f5291h.o(true);
        if (zO || zO2) {
            u0.n1(this);
        }
    }

    public void d(int i10) {
        e(i10, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f5288e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt = getChildAt(i10);
            if (H(x10, y10, childAt) && !B(childAt) && m(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        int height = getHeight();
        boolean zB = B(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i10 = 0;
        if (zB) {
            int childCount = getChildCount();
            int i11 = 0;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt != view && childAt.getVisibility() == 0 && x(childAt) && E(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i11) {
                            i11 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i11, 0, width, getHeight());
            i10 = i11;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(iSave);
        float f10 = this.f5288e;
        if (f10 > 0.0f && zB) {
            this.f5289f.setColor((this.f5287d & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f10)) << 24));
            canvas.drawRect(i10, 0.0f, width, getHeight(), this.f5289f);
        } else if (this.f5311x != null && c(view, 3)) {
            int intrinsicWidth = this.f5311x.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.f5290g.B(), 1.0f));
            this.f5311x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f5311x.setAlpha((int) (fMax * 255.0f));
            this.f5311x.draw(canvas);
        } else if (this.f5312y != null && c(view, 5)) {
            int intrinsicWidth2 = this.f5312y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f5291h.B(), 1.0f));
            this.f5312y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f5312y.setAlpha((int) (fMax2 * 255.0f));
            this.f5312y.draw(canvas);
        }
        return zDrawChild;
    }

    public void e(int i10, boolean z10) {
        View viewN = n(i10);
        if (viewN != null) {
            g(viewN, z10);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i10));
    }

    public void f(@n0 View view) {
        g(view, true);
    }

    public void g(@n0 View view, boolean z10) {
        if (!E(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.f5298m) {
            fVar.f5327b = 0.0f;
            fVar.f5329d = 0;
        } else if (z10) {
            fVar.f5329d |= 4;
            if (c(view, 3)) {
                this.f5290g.X(view, -view.getWidth(), view.getTop());
            } else {
                this.f5291h.X(view, getWidth(), view.getTop());
            }
        } else {
            J(view, 0.0f);
            b0(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (U7) {
            return this.f5285b;
        }
        return 0.0f;
    }

    @p0
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f5310w;
    }

    public void h() {
        i(false);
    }

    public void i(boolean z10) {
        int childCount = getChildCount();
        boolean zX = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f fVar = (f) childAt.getLayoutParams();
            if (E(childAt) && (!z10 || fVar.f5328c)) {
                zX |= c(childAt, 3) ? this.f5290g.X(childAt, -childAt.getWidth(), childAt.getTop()) : this.f5291h.X(childAt, getWidth(), childAt.getTop());
                fVar.f5328c = false;
            }
        }
        this.f5292i.p();
        this.f5293j.p();
        if (zX) {
            invalidate();
        }
    }

    @Override // e1.c
    public boolean isOpen() {
        return C(m.f5025b);
    }

    public void j(View view) {
        View rootView;
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f5329d & 1) == 1) {
            fVar.f5329d = 0;
            List<e> list = this.f5305t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f5305t.get(size).b(view);
                }
            }
            a0(view, false);
            Z(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    public void k(View view) {
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f5329d & 1) == 0) {
            fVar.f5329d = 1;
            List<e> list = this.f5305t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f5305t.get(size).a(view);
                }
            }
            a0(view, true);
            Z(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public void l(View view, float f10) {
        List<e> list = this.f5305t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f5305t.get(size).d(view, f10);
            }
        }
    }

    public final boolean m(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventV = v(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventV);
            motionEventV.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    public View n(int i10) {
        int iD = m.d(i10, u0.Z(this)) & 7;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((t(childAt) & 7) == iD) {
                return childAt;
            }
        }
        return null;
    }

    public View o() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((((f) childAt.getLayoutParams()).f5329d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5298m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5298m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.C || this.f5310w == null) {
            return;
        }
        Object obj = this.B;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.f5310w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f5310w.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            e1.d r1 = r6.f5290g
            boolean r1 = r1.W(r7)
            e1.d r2 = r6.f5291h
            boolean r2 = r2.W(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            e1.d r7 = r6.f5290g
            boolean r7 = r7.f(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$h r7 = r6.f5292i
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$h r7 = r6.f5293j
            r7.p()
            goto L36
        L31:
            r6.i(r2)
            r6.f5303r = r3
        L36:
            r7 = 0
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f5306u = r0
            r6.f5307v = r7
            float r4 = r6.f5288e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            e1.d r4 = r6.f5290g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.v(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.B(r7)
            if (r7 == 0) goto L5d
            r7 = 1
            goto L5e
        L5d:
            r7 = 0
        L5e:
            r6.f5303r = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.y()
            if (r7 != 0) goto L70
            boolean r7 = r6.f5303r
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = 0
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !z()) {
            return super.onKeyDown(i10, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        View viewP = p();
        if (viewP != null && r(viewP) == 0) {
            h();
        }
        return viewP != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        WindowInsets rootWindowInsets;
        float f10;
        int i14;
        this.f5297l = true;
        int i15 = i12 - i10;
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (B(childAt)) {
                    int i17 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    childAt.layout(i17, ((ViewGroup.MarginLayoutParams) fVar).topMargin, childAt.getMeasuredWidth() + i17, ((ViewGroup.MarginLayoutParams) fVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f11 = measuredWidth;
                        i14 = (-measuredWidth) + ((int) (fVar.f5327b * f11));
                        f10 = (measuredWidth + i14) / f11;
                    } else {
                        float f12 = measuredWidth;
                        f10 = (i15 - r11) / f12;
                        i14 = i15 - ((int) (fVar.f5327b * f12));
                    }
                    boolean z11 = f10 != fVar.f5327b;
                    int i18 = fVar.f5326a & 112;
                    if (i18 == 16) {
                        int i19 = i13 - i11;
                        int i20 = (i19 - measuredHeight) / 2;
                        int i21 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        if (i20 < i21) {
                            i20 = i21;
                        } else {
                            int i22 = i20 + measuredHeight;
                            int i23 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                            if (i22 > i19 - i23) {
                                i20 = (i19 - i23) - measuredHeight;
                            }
                        }
                        childAt.layout(i14, i20, measuredWidth + i14, measuredHeight + i20);
                    } else if (i18 != 80) {
                        int i24 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        childAt.layout(i14, i24, measuredWidth + i14, measuredHeight + i24);
                    } else {
                        int i25 = i13 - i11;
                        childAt.layout(i14, (i25 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i14, i25 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    }
                    if (z11) {
                        Y(childAt, f10);
                    }
                    int i26 = fVar.f5327b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i26) {
                        childAt.setVisibility(i26);
                    }
                }
            }
        }
        if (W7 && (rootWindowInsets = getRootWindowInsets()) != null) {
            i iVarN = j1.K(rootWindowInsets).n();
            e1.d dVar = this.f5290g;
            dVar.S(Math.max(dVar.A(), iVarN.f40559a));
            e1.d dVar2 = this.f5291h;
            dVar2.S(Math.max(dVar2.A(), iVarN.f40561c));
        }
        this.f5297l = false;
        this.f5298m = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i12 = 0;
        boolean z10 = this.B != null && u0.U(this);
        int iZ = u0.Z(this);
        int childCount = getChildCount();
        int i13 = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z10) {
                    int iD = m.d(fVar.f5326a, iZ);
                    if (u0.U(childAt)) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.B;
                        if (iD == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), i12, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (iD == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(i12, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.B;
                        if (iD == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), i12, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iD == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(i12, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) fVar).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (B(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, 1073741824));
                } else {
                    if (!E(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i13 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (U7) {
                        float fR = u0.R(childAt);
                        float f10 = this.f5285b;
                        if (fR != f10) {
                            u0.N1(childAt, f10);
                        }
                    }
                    int iT = t(childAt) & 7;
                    boolean z13 = iT == 3;
                    if ((z13 && z11) || (!z13 && z12)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + w(iT) + " but this " + C2 + " already has a drawer view along that edge");
                    }
                    if (z13) {
                        z11 = true;
                    } else {
                        z12 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i10, this.f5286c + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((ViewGroup.MarginLayoutParams) fVar).width), ViewGroup.getChildMeasureSpec(i11, ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, ((ViewGroup.MarginLayoutParams) fVar).height));
                }
            }
            i13++;
            i12 = 0;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View viewN;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i10 = savedState.f5314c;
        if (i10 != 0 && (viewN = n(i10)) != null) {
            M(viewN);
        }
        int i11 = savedState.f5315d;
        if (i11 != 3) {
            T(i11, 3);
        }
        int i12 = savedState.f5316e;
        if (i12 != 3) {
            T(i12, 5);
        }
        int i13 = savedState.f5317f;
        if (i13 != 3) {
            T(i13, m.f5025b);
        }
        int i14 = savedState.f5318g;
        if (i14 != 3) {
            T(i14, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        R();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            f fVar = (f) getChildAt(i10).getLayoutParams();
            int i11 = fVar.f5329d;
            boolean z10 = i11 == 1;
            boolean z11 = i11 == 2;
            if (z10 || z11) {
                savedState.f5314c = fVar.f5326a;
                break;
            }
        }
        savedState.f5315d = this.f5299n;
        savedState.f5316e = this.f5300o;
        savedState.f5317f = this.f5301p;
        savedState.f5318g = this.f5302q;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            e1.d r0 = r6.f5290g
            r0.M(r7)
            e1.d r0 = r6.f5291h
            r0.M(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L62
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L70
        L1a:
            r6.i(r2)
            r6.f5303r = r1
            goto L70
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            e1.d r3 = r6.f5290g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.v(r4, r5)
            if (r3 == 0) goto L5d
            boolean r3 = r6.B(r3)
            if (r3 == 0) goto L5d
            float r3 = r6.f5306u
            float r0 = r0 - r3
            float r3 = r6.f5307v
            float r7 = r7 - r3
            e1.d r3 = r6.f5290g
            int r3 = r3.E()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5d
            android.view.View r7 = r6.o()
            if (r7 == 0) goto L5d
            int r7 = r6.r(r7)
            r0 = 2
            if (r7 != r0) goto L5e
        L5d:
            r1 = 1
        L5e:
            r6.i(r1)
            goto L70
        L62:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f5306u = r0
            r6.f5307v = r7
            r6.f5303r = r1
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // e1.c
    public void open() {
        K(m.f5025b);
    }

    public View p() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (E(childAt) && G(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int q(int i10) {
        int iZ = u0.Z(this);
        if (i10 == 3) {
            int i11 = this.f5299n;
            if (i11 != 3) {
                return i11;
            }
            int i12 = iZ == 0 ? this.f5301p : this.f5302q;
            if (i12 != 3) {
                return i12;
            }
            return 0;
        }
        if (i10 == 5) {
            int i13 = this.f5300o;
            if (i13 != 3) {
                return i13;
            }
            int i14 = iZ == 0 ? this.f5302q : this.f5301p;
            if (i14 != 3) {
                return i14;
            }
            return 0;
        }
        if (i10 == 8388611) {
            int i15 = this.f5301p;
            if (i15 != 3) {
                return i15;
            }
            int i16 = iZ == 0 ? this.f5299n : this.f5300o;
            if (i16 != 3) {
                return i16;
            }
            return 0;
        }
        if (i10 != 8388613) {
            return 0;
        }
        int i17 = this.f5302q;
        if (i17 != 3) {
            return i17;
        }
        int i18 = iZ == 0 ? this.f5300o : this.f5299n;
        if (i18 != 3) {
            return i18;
        }
        return 0;
    }

    public int r(@n0 View view) {
        if (E(view)) {
            return q(((f) view.getLayoutParams()).f5326a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            i(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f5297l) {
            return;
        }
        super.requestLayout();
    }

    @p0
    public CharSequence s(int i10) {
        int iD = m.d(i10, u0.Z(this));
        if (iD == 3) {
            return this.f5313z;
        }
        if (iD == 5) {
            return this.A;
        }
        return null;
    }

    public void setDrawerElevation(float f10) {
        this.f5285b = f10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (E(childAt)) {
                u0.N1(childAt, this.f5285b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.f5304s;
        if (eVar2 != null) {
            O(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.f5304s = eVar;
    }

    public void setDrawerLockMode(int i10) {
        T(i10, 3);
        T(i10, 5);
    }

    public void setScrimColor(@l int i10) {
        this.f5287d = i10;
        invalidate();
    }

    public void setStatusBarBackground(@p0 Drawable drawable) {
        this.f5310w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@l int i10) {
        this.f5310w = new ColorDrawable(i10);
        invalidate();
    }

    public int t(View view) {
        return m.d(((f) view.getLayoutParams()).f5326a, u0.Z(this));
    }

    public float u(View view) {
        return ((f) view.getLayoutParams()).f5327b;
    }

    public final MotionEvent v(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.K1 == null) {
                this.K1 = new Matrix();
            }
            matrix.invert(this.K1);
            motionEventObtain.transform(this.K1);
        }
        return motionEventObtain;
    }

    public final boolean y() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((f) getChildAt(i10).getLayoutParams()).f5328c) {
                return true;
            }
        }
        return false;
    }

    public final boolean z() {
        return p() != null;
    }

    public DrawerLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.drawerlayout.R.attr.drawerLayoutStyle);
    }

    public DrawerLayout(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f5284a = new d();
        this.f5287d = M7;
        this.f5289f = new Paint();
        this.f5298m = true;
        this.f5299n = 3;
        this.f5300o = 3;
        this.f5301p = 3;
        this.f5302q = 3;
        this.D = null;
        this.f5295k0 = null;
        this.K0 = null;
        this.f5296k1 = null;
        this.f5309v2 = new a();
        setDescendantFocusability(262144);
        float f10 = getResources().getDisplayMetrics().density;
        this.f5286c = (int) ((64.0f * f10) + 0.5f);
        float f11 = f10 * 400.0f;
        h hVar = new h(3);
        this.f5292i = hVar;
        h hVar2 = new h(5);
        this.f5293j = hVar2;
        e1.d dVarP = e1.d.p(this, 1.0f, hVar);
        this.f5290g = dVarP;
        dVarP.T(1);
        dVarP.U(f11);
        hVar.q(dVarP);
        e1.d dVarP2 = e1.d.p(this, 1.0f, hVar2);
        this.f5291h = dVarP2;
        dVarP2.T(2);
        dVarP2.U(f11);
        hVar2.q(dVarP2);
        setFocusableInTouchMode(true);
        u0.R1(this, 1);
        u0.B1(this, new c());
        setMotionEventSplittingEnabled(false);
        if (u0.U(this)) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(K2);
            try {
                this.f5310w = typedArrayObtainStyledAttributes.getDrawable(0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i10, 0);
        try {
            int i11 = androidx.drawerlayout.R.styleable.DrawerLayout_elevation;
            if (typedArrayObtainStyledAttributes2.hasValue(i11)) {
                this.f5285b = typedArrayObtainStyledAttributes2.getDimension(i11, 0.0f);
            } else {
                this.f5285b = getResources().getDimension(androidx.drawerlayout.R.dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.f5308v1 = new ArrayList<>();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setStatusBarBackground(int i10) {
        this.f5310w = i10 != 0 ? h0.d.i(getContext(), i10) : null;
        invalidate();
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f5323e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f5324f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f5325g = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f5327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5329d;

        public f(@n0 Context context, @p0 AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5326a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.S7);
            this.f5326a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public f(int i10, int i11) {
            super(i10, i11);
            this.f5326a = 0;
        }

        public f(int i10, int i11, int i12) {
            this(i10, i11);
            this.f5326a = i12;
        }

        public f(@n0 f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f5326a = 0;
            this.f5326a = fVar.f5326a;
        }

        public f(@n0 ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f5326a = 0;
        }

        public f(@n0 ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f5326a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5317f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5318g;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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

        public SavedState(@n0 Parcel parcel, @p0 ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5314c = 0;
            this.f5314c = parcel.readInt();
            this.f5315d = parcel.readInt();
            this.f5316e = parcel.readInt();
            this.f5317f = parcel.readInt();
            this.f5318g = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f5314c);
            parcel.writeInt(this.f5315d);
            parcel.writeInt(this.f5316e);
            parcel.writeInt(this.f5317f);
            parcel.writeInt(this.f5318g);
        }

        public SavedState(@n0 Parcelable parcelable) {
            super(parcelable);
            this.f5314c = 0;
        }
    }
}
