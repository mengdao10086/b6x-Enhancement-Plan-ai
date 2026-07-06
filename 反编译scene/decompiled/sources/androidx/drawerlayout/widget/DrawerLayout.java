package androidx.drawerlayout.widget;

import a.ak;
import a.bg;
import a.eh;
import a.kd;
import a.lk;
import a.ni;
import a.qk;
import a.rf;
import a.rk;
import a.yb;
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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class DrawerLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8195a = {R.attr.colorPrimaryDark};
    public static final int[] b = {R.attr.layout_gravity};
    public static final boolean f;
    public static final boolean g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f4211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lk f4213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Matrix f4214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f4216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f4218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f4219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g f4220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f4221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f4222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<View> f4223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<d> f4224a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f4225b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4226b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final lk f4227b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f4228b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final g f4229b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f4230b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4231b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f4232c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Drawable f4233c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4234c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f4235d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public Drawable f4236d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4237d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public Drawable f4238e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4239e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f4240f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public Drawable f4241f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public int f4242g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public Drawable f4243g;

    public class a implements View.OnApplyWindowInsetsListener {
        public a(DrawerLayout drawerLayout) {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).M(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public class b extends rf {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f8196a = new Rect();

        public b() {
        }

        @Override // a.rf
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewN = DrawerLayout.this.n();
            if (viewN == null) {
                return true;
            }
            CharSequence charSequenceQ = DrawerLayout.this.q(DrawerLayout.this.r(viewN));
            if (charSequenceQ == null) {
                return true;
            }
            text.add(charSequenceQ);
            return true;
        }

        @Override // a.rf
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // a.rf
        public void g(View view, ni niVar) {
            if (DrawerLayout.f) {
                super.g(view, niVar);
            } else {
                ni niVarP = ni.P(niVar);
                super.g(view, niVarP);
                niVar.x0(view);
                Object objE = eh.E(view);
                if (objE instanceof View) {
                    niVar.q0((View) objE);
                }
                o(niVar, niVarP);
                niVarP.R();
                n(niVar, (ViewGroup) view);
            }
            niVar.a0(DrawerLayout.class.getName());
            niVar.i0(false);
            niVar.j0(false);
            niVar.S(ni.a.f6918a);
            niVar.S(ni.a.b);
        }

        @Override // a.rf
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f || DrawerLayout.y(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        public final void n(ni niVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.y(childAt)) {
                    niVar.c(childAt);
                }
            }
        }

        public final void o(ni niVar, ni niVar2) {
            Rect rect = this.f8196a;
            niVar2.m(rect);
            niVar.W(rect);
            niVar2.n(rect);
            niVar.X(rect);
            niVar.B0(niVar2.M());
            niVar.o0(niVar2.u());
            niVar.a0(niVar2.p());
            niVar.e0(niVar2.r());
            niVar.g0(niVar2.E());
            niVar.b0(niVar2.D());
            niVar.i0(niVar2.F());
            niVar.j0(niVar2.G());
            niVar.U(niVar2.A());
            niVar.v0(niVar2.K());
            niVar.m0(niVar2.H());
            niVar.a(niVar2.k());
        }
    }

    public static final class c extends rf {
        @Override // a.rf
        public void g(View view, ni niVar) {
            super.g(view, niVar);
            if (DrawerLayout.y(view)) {
                return;
            }
            niVar.q0(null);
        }
    }

    public interface d {
        void a(View view);

        void b(int i);

        void c(View view, float f);

        void d(View view);
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8197a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4245a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4246a;
        public int b;

        public e(int i, int i2) {
            super(i, i2);
            this.f4245a = 0;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4245a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.b);
            this.f4245a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4245a = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4245a = 0;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f4245a = 0;
            this.f4245a = eVar.f4245a;
        }
    }

    public static class f extends ak {
        public static final Parcelable.Creator<f> CREATOR = new qk();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8198a;
        public int b;
        public int c;
        public int d;
        public int e;

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8198a = 0;
            this.f8198a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
        }

        public f(Parcelable parcelable) {
            super(parcelable);
            this.f8198a = 0;
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8198a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
        }
    }

    public class g extends lk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8199a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public lk f4247a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Runnable f4249a = new rk(this);

        public g(int i) {
            this.f8199a = i;
        }

        @Override // a.lk.a
        public int a(View view, int i, int i2) {
            int width;
            int width2;
            if (DrawerLayout.this.c(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = DrawerLayout.this.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i, width));
        }

        @Override // a.lk.a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // a.lk.a
        public int d(View view) {
            if (DrawerLayout.this.B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // a.lk.a
        public void f(int i, int i2) {
            DrawerLayout drawerLayout;
            int i3;
            if ((i & 1) == 1) {
                drawerLayout = DrawerLayout.this;
                i3 = 3;
            } else {
                drawerLayout = DrawerLayout.this;
                i3 = 5;
            }
            View viewL = drawerLayout.l(i3);
            if (viewL == null || DrawerLayout.this.p(viewL) != 0) {
                return;
            }
            this.f4247a.b(viewL, i2);
        }

        @Override // a.lk.a
        public boolean g(int i) {
            return false;
        }

        @Override // a.lk.a
        public void h(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f4249a, 160L);
        }

        @Override // a.lk.a
        public void i(View view, int i) {
            ((e) view.getLayoutParams()).f4246a = false;
            n();
        }

        @Override // a.lk.a
        public void j(int i) {
            DrawerLayout.this.Q(this.f8199a, i, this.f4247a.v());
        }

        @Override // a.lk.a
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = (DrawerLayout.this.c(view, 3) ? i + r3 : DrawerLayout.this.getWidth() - i) / view.getWidth();
            DrawerLayout.this.O(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // a.lk.a
        public void l(View view, float f, float f2) {
            int i;
            float fS = DrawerLayout.this.s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && fS > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && fS > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f4247a.M(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // a.lk.a
        public boolean m(View view, int i) {
            return DrawerLayout.this.B(view) && DrawerLayout.this.c(view, this.f8199a) && DrawerLayout.this.p(view) == 0;
        }

        public final void n() {
            View viewL = DrawerLayout.this.l(this.f8199a == 3 ? 5 : 3);
            if (viewL != null) {
                DrawerLayout.this.d(viewL);
            }
        }

        public void o() {
            View viewL;
            int width;
            int iW = this.f4247a.w();
            boolean z = this.f8199a == 3;
            if (z) {
                viewL = DrawerLayout.this.l(3);
                width = (viewL != null ? -viewL.getWidth() : 0) + iW;
            } else {
                viewL = DrawerLayout.this.l(5);
                width = DrawerLayout.this.getWidth() - iW;
            }
            if (viewL != null) {
                if (((!z || viewL.getLeft() >= width) && (z || viewL.getLeft() <= width)) || DrawerLayout.this.p(viewL) != 0) {
                    return;
                }
                e eVar = (e) viewL.getLayoutParams();
                this.f4247a.O(viewL, width, viewL.getTop());
                eVar.f4246a = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f4249a);
        }

        public void q(lk lkVar) {
            this.f4247a = lkVar;
        }
    }

    static {
        f = Build.VERSION.SDK_INT >= 19;
        g = Build.VERSION.SDK_INT >= 21;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4218a = new c();
        this.f4226b = -1728053248;
        this.f4215a = new Paint();
        this.f4234c = true;
        this.f4235d = 3;
        this.e = 3;
        this.f4240f = 3;
        this.f4242g = 3;
        this.f4236d = null;
        this.f4238e = null;
        this.f4241f = null;
        this.f4243g = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f4212a = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        this.f4220a = new g(3);
        this.f4229b = new g(5);
        lk lkVarN = lk.n(this, 1.0f, this.f4220a);
        this.f4213a = lkVarN;
        lkVarN.K(1);
        this.f4213a.L(f3);
        this.f4220a.q(this.f4213a);
        lk lkVarN2 = lk.n(this, 1.0f, this.f4229b);
        this.f4227b = lkVarN2;
        lkVarN2.K(2);
        this.f4227b.L(f3);
        this.f4229b.q(this.f4227b);
        setFocusableInTouchMode(true);
        eh.t0(this, 1);
        eh.k0(this, new b());
        setMotionEventSplittingEnabled(false);
        if (eh.v(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new a(this));
                setSystemUiVisibility(1280);
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f8195a);
                try {
                    this.f4217a = typedArrayObtainStyledAttributes.getDrawable(0);
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            } else {
                this.f4217a = null;
            }
        }
        this.f4211a = f2 * 10.0f;
        this.f4223a = new ArrayList<>();
    }

    public static String u(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    public static boolean v(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public static boolean y(View view) {
        return (eh.w(view) == 4 || eh.w(view) == 2) ? false : true;
    }

    public boolean A(View view) {
        if (B(view)) {
            return (((e) view.getLayoutParams()).b & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean B(View view) {
        int iB = bg.b(((e) view.getLayoutParams()).f4245a, eh.y(view));
        return ((iB & 3) == 0 && (iB & 5) == 0) ? false : true;
    }

    public boolean C(View view) {
        if (B(view)) {
            return ((e) view.getLayoutParams()).f8197a > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final boolean D(float f2, float f3, View view) {
        if (this.f4216a == null) {
            this.f4216a = new Rect();
        }
        view.getHitRect(this.f4216a);
        return this.f4216a.contains((int) f2, (int) f3);
    }

    public final boolean E(Drawable drawable, int i) {
        if (drawable == null || !kd.h(drawable)) {
            return false;
        }
        kd.m(drawable, i);
        return true;
    }

    public void F(View view, float f2) {
        float fS = s(view);
        float width = view.getWidth();
        int i = ((int) (width * f2)) - ((int) (fS * width));
        if (!c(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        O(view, f2);
    }

    public void G(View view) {
        H(view, true);
    }

    public void H(View view, boolean z) {
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.f4234c) {
            eVar.f8197a = 1.0f;
            eVar.b = 1;
            P(view, true);
        } else if (z) {
            eVar.b |= 2;
            if (c(view, 3)) {
                this.f4213a.O(view, 0, view.getTop());
            } else {
                this.f4227b.O(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            F(view, 1.0f);
            Q(eVar.f4245a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void I(d dVar) {
        List<d> list;
        if (dVar == null || (list = this.f4224a) == null) {
            return;
        }
        list.remove(dVar);
    }

    public final Drawable J() {
        int iY = eh.y(this);
        if (iY == 0) {
            Drawable drawable = this.f4236d;
            if (drawable != null) {
                E(drawable, iY);
                return this.f4236d;
            }
        } else {
            Drawable drawable2 = this.f4238e;
            if (drawable2 != null) {
                E(drawable2, iY);
                return this.f4238e;
            }
        }
        return this.f4241f;
    }

    public final Drawable K() {
        int iY = eh.y(this);
        if (iY == 0) {
            Drawable drawable = this.f4238e;
            if (drawable != null) {
                E(drawable, iY);
                return this.f4238e;
            }
        } else {
            Drawable drawable2 = this.f4236d;
            if (drawable2 != null) {
                E(drawable2, iY);
                return this.f4236d;
            }
        }
        return this.f4243g;
    }

    public final void L() {
        if (g) {
            return;
        }
        this.f4228b = J();
        this.f4233c = K();
    }

    public void M(Object obj, boolean z) {
        this.f4222a = obj;
        this.f4239e = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void N(int i, int i2) {
        View viewL;
        int iB = bg.b(i2, eh.y(this));
        if (i2 == 3) {
            this.f4235d = i;
        } else if (i2 == 5) {
            this.e = i;
        } else if (i2 == 8388611) {
            this.f4240f = i;
        } else if (i2 == 8388613) {
            this.f4242g = i;
        }
        if (i != 0) {
            (iB == 3 ? this.f4213a : this.f4227b).a();
        }
        if (i != 1) {
            if (i == 2 && (viewL = l(iB)) != null) {
                G(viewL);
                return;
            }
            return;
        }
        View viewL2 = l(iB);
        if (viewL2 != null) {
            d(viewL2);
        }
    }

    public void O(View view, float f2) {
        e eVar = (e) view.getLayoutParams();
        if (f2 == eVar.f8197a) {
            return;
        }
        eVar.f8197a = f2;
        j(view, f2);
    }

    public final void P(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            eh.t0(childAt, ((z || B(childAt)) && !(z && childAt == view)) ? 4 : 1);
        }
    }

    public void Q(int i, int i2, View view) {
        int iZ = this.f4213a.z();
        int iZ2 = this.f4227b.z();
        int i3 = 2;
        if (iZ == 1 || iZ2 == 1) {
            i3 = 1;
        } else if (iZ != 2 && iZ2 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            float f2 = ((e) view.getLayoutParams()).f8197a;
            if (f2 == 0.0f) {
                h(view);
            } else if (f2 == 1.0f) {
                i(view);
            }
        }
        if (i3 != this.f4232c) {
            this.f4232c = i3;
            List<d> list = this.f4224a;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f4224a.get(size).b(i3);
                }
            }
        }
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.f4224a == null) {
            this.f4224a = new ArrayList();
        }
        this.f4224a.add(dVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!B(childAt)) {
                this.f4223a.add(childAt);
            } else if (A(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
        }
        if (!z) {
            int size = this.f4223a.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.f4223a.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.f4223a.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        eh.t0(view, (m() != null || B(view)) ? 4 : 1);
        if (f) {
            return;
        }
        eh.k0(view, this.f4218a);
    }

    public void b() {
        if (this.f4237d) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.f4237d = true;
    }

    public boolean c(View view, int i) {
        return (r(view) & i) == i;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((e) getChildAt(i).getLayoutParams()).f8197a);
        }
        this.f4225b = fMax;
        boolean zM = this.f4213a.m(true);
        boolean zM2 = this.f4227b.m(true);
        if (zM || zM2) {
            eh.b0(this);
        }
    }

    public void d(View view) {
        e(view, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f4225b <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (D(x, y, childAt) && !z(childAt) && k(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        Drawable drawable;
        int height = getHeight();
        boolean z = z(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i = 0;
        if (z) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && v(childAt) && B(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        float f2 = this.f4225b;
        if (f2 <= 0.0f || !z) {
            if (this.f4228b != null && c(view, 3)) {
                int intrinsicWidth = this.f4228b.getIntrinsicWidth();
                int right2 = view.getRight();
                float fMax = Math.max(0.0f, Math.min(right2 / this.f4213a.w(), 1.0f));
                this.f4228b.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.f4228b.setAlpha((int) (fMax * 255.0f));
                drawable = this.f4228b;
            } else if (this.f4233c != null && c(view, 5)) {
                int intrinsicWidth2 = this.f4233c.getIntrinsicWidth();
                int left2 = view.getLeft();
                float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f4227b.w(), 1.0f));
                this.f4233c.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.f4233c.setAlpha((int) (fMax2 * 255.0f));
                drawable = this.f4233c;
            }
            drawable.draw(canvas);
        } else {
            this.f4215a.setColor((this.f4226b & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f2)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.f4215a);
        }
        return zDrawChild;
    }

    public void e(View view, boolean z) {
        lk lkVar;
        int width;
        if (!B(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        e eVar = (e) view.getLayoutParams();
        if (this.f4234c) {
            eVar.f8197a = 0.0f;
            eVar.b = 0;
        } else if (z) {
            eVar.b |= 4;
            if (c(view, 3)) {
                lkVar = this.f4213a;
                width = -view.getWidth();
            } else {
                lkVar = this.f4227b;
                width = getWidth();
            }
            lkVar.O(view, width, view.getTop());
        } else {
            F(view, 0.0f);
            Q(eVar.f4245a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    public void f() {
        g(false);
    }

    public void g(boolean z) {
        int childCount = getChildCount();
        boolean zO = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            e eVar = (e) childAt.getLayoutParams();
            if (B(childAt) && (!z || eVar.f4246a)) {
                zO |= c(childAt, 3) ? this.f4213a.O(childAt, -childAt.getWidth(), childAt.getTop()) : this.f4227b.O(childAt, getWidth(), childAt.getTop());
                eVar.f4246a = false;
            }
        }
        this.f4220a.p();
        this.f4229b.p();
        if (zO) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public float getDrawerElevation() {
        if (g) {
            return this.f4211a;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f4217a;
    }

    public void h(View view) {
        View rootView;
        e eVar = (e) view.getLayoutParams();
        if ((eVar.b & 1) == 1) {
            eVar.b = 0;
            List<d> list = this.f4224a;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f4224a.get(size).d(view);
                }
            }
            P(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    public void i(View view) {
        e eVar = (e) view.getLayoutParams();
        if ((eVar.b & 1) == 0) {
            eVar.b = 1;
            List<d> list = this.f4224a;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f4224a.get(size).a(view);
                }
            }
            P(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public void j(View view, float f2) {
        List<d> list = this.f4224a;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4224a.get(size).c(view, f2);
            }
        }
    }

    public final boolean k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventT = t(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventT);
            motionEventT.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    public View l(int i) {
        int iB = bg.b(i, eh.y(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((r(childAt) & 7) == iB) {
                return childAt;
            }
        }
        return null;
    }

    public View m() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((e) childAt.getLayoutParams()).b & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public View n() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (B(childAt) && C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int o(int i) {
        int iY = eh.y(this);
        if (i == 3) {
            int i2 = this.f4235d;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iY == 0 ? this.f4240f : this.f4242g;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.e;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iY == 0 ? this.f4242g : this.f4240f;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.f4240f;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iY == 0 ? this.f4235d : this.e;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.f4242g;
        if (i8 != 3) {
            return i8;
        }
        int i9 = iY == 0 ? this.e : this.f4235d;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4234c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4234c = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.f4239e || this.f4217a == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.f4222a) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.f4217a.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.f4217a.draw(canvas);
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
            a.lk r1 = r6.f4213a
            boolean r1 = r1.N(r7)
            a.lk r2 = r6.f4227b
            boolean r2 = r2.N(r7)
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
            a.lk r7 = r6.f4213a
            boolean r7 = r7.d(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$g r7 = r6.f4220a
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$g r7 = r6.f4229b
            r7.p()
            goto L36
        L31:
            r6.g(r2)
            r6.f4237d = r3
        L36:
            r7 = r3
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.c = r0
            r6.d = r7
            float r4 = r6.f4225b
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            a.lk r4 = r6.f4213a
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.t(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.z(r7)
            if (r7 == 0) goto L5d
            r7 = r2
            goto L5e
        L5d:
            r7 = r3
        L5e:
            r6.f4237d = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.w()
            if (r7 != 0) goto L70
            boolean r7 = r6.f4237d
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !x()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewN = n();
        if (viewN != null && p(viewN) == 0) {
            f();
        }
        return viewN != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f2;
        int i5;
        int measuredHeight;
        int i6;
        int i7;
        boolean z2 = true;
        this.f4231b = true;
        int i8 = i3 - i;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z(childAt)) {
                    int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i10, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i10, ((ViewGroup.MarginLayoutParams) eVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (eVar.f8197a * f3));
                        f2 = (measuredWidth + i5) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i8 - r11) / f4;
                        i5 = i8 - ((int) (eVar.f8197a * f4));
                    }
                    boolean z3 = f2 != eVar.f8197a ? z2 : false;
                    int i11 = eVar.f4245a & 112;
                    if (i11 != 16) {
                        if (i11 != 80) {
                            measuredHeight = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                            i6 = measuredWidth + i5;
                            i7 = measuredHeight2 + measuredHeight;
                        } else {
                            int i12 = i4 - i2;
                            measuredHeight = (i12 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight();
                            i6 = measuredWidth + i5;
                            i7 = i12 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                        }
                        childAt.layout(i5, measuredHeight, i6, i7);
                    } else {
                        int i13 = i4 - i2;
                        int i14 = (i13 - measuredHeight2) / 2;
                        int i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i14 < i15) {
                            i14 = i15;
                        } else {
                            int i16 = i14 + measuredHeight2;
                            int i17 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i16 > i13 - i17) {
                                i14 = (i13 - i17) - measuredHeight2;
                            }
                        }
                        childAt.layout(i5, i14, measuredWidth + i5, measuredHeight2 + i14);
                    }
                    if (z3) {
                        O(childAt, f2);
                    }
                    int i18 = eVar.f8197a > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
            i9++;
            z2 = true;
        }
        this.f4231b = false;
        this.f4234c = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.f4222a != null && eh.v(this);
        int iY = eh.y(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z) {
                    int iB = bg.b(eVar.f4245a, iY);
                    boolean zV = eh.v(childAt);
                    int i5 = Build.VERSION.SDK_INT;
                    if (zV) {
                        if (i5 >= 21) {
                            WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.f4222a;
                            if (iB == 3) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            } else if (iB == 5) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                        }
                    } else if (i5 >= 21) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.f4222a;
                        if (iB == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iB == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, 1073741824));
                } else {
                    if (!B(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (g) {
                        float fT = eh.t(childAt);
                        float f2 = this.f4211a;
                        if (fT != f2) {
                            eh.q0(childAt, f2);
                        }
                    }
                    int iR = r(childAt) & 7;
                    int i6 = iR == 3 ? 1 : i3;
                    if ((i6 != 0 && z2) || (i6 == 0 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + u(iR) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (i6 != 0) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.f4212a + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                }
            }
            i4++;
            i3 = 0;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View viewL;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.q());
        int i = fVar.f8198a;
        if (i != 0 && (viewL = l(i)) != null) {
            G(viewL);
        }
        int i2 = fVar.b;
        if (i2 != 3) {
            N(i2, 3);
        }
        int i3 = fVar.c;
        if (i3 != 3) {
            N(i3, 5);
        }
        int i4 = fVar.d;
        if (i4 != 3) {
            N(i4, 8388611);
        }
        int i5 = fVar.e;
        if (i5 != 3) {
            N(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        L();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            e eVar = (e) getChildAt(i).getLayoutParams();
            boolean z = eVar.b == 1;
            boolean z2 = eVar.b == 2;
            if (z || z2) {
                fVar.f8198a = eVar.f4245a;
                break;
            }
        }
        fVar.b = this.f4235d;
        fVar.c = this.e;
        fVar.d = this.f4240f;
        fVar.e = this.f4242g;
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            a.lk r0 = r6.f4213a
            r0.E(r7)
            a.lk r0 = r6.f4227b
            r0.E(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5d
            if (r0 == r2) goto L1e
            r7 = 3
            if (r0 == r7) goto L1a
            goto L6b
        L1a:
            r6.g(r2)
            goto L69
        L1e:
            float r0 = r7.getX()
            float r7 = r7.getY()
            a.lk r3 = r6.f4213a
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.t(r4, r5)
            if (r3 == 0) goto L58
            boolean r3 = r6.z(r3)
            if (r3 == 0) goto L58
            float r3 = r6.c
            float r0 = r0 - r3
            float r3 = r6.d
            float r7 = r7 - r3
            a.lk r3 = r6.f4213a
            int r3 = r3.y()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L58
            android.view.View r7 = r6.m()
            if (r7 == 0) goto L58
            int r7 = r6.p(r7)
            r0 = 2
            if (r7 != r0) goto L59
        L58:
            r1 = r2
        L59:
            r6.g(r1)
            goto L6b
        L5d:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.c = r0
            r6.d = r7
        L69:
            r6.f4237d = r1
        L6b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public int p(View view) {
        if (B(view)) {
            return o(((e) view.getLayoutParams()).f4245a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence q(int i) {
        int iB = bg.b(i, eh.y(this));
        if (iB == 3) {
            return this.f4221a;
        }
        if (iB == 5) {
            return this.f4230b;
        }
        return null;
    }

    public int r(View view) {
        return bg.b(((e) view.getLayoutParams()).f4245a, eh.y(this));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            g(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f4231b) {
            return;
        }
        super.requestLayout();
    }

    public float s(View view) {
        return ((e) view.getLayoutParams()).f8197a;
    }

    public void setDrawerElevation(float f2) {
        this.f4211a = f2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (B(childAt)) {
                eh.q0(childAt, this.f4211a);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        d dVar2 = this.f4219a;
        if (dVar2 != null) {
            I(dVar2);
        }
        if (dVar != null) {
            a(dVar);
        }
        this.f4219a = dVar;
    }

    public void setDrawerLockMode(int i) {
        N(i, 3);
        N(i, 5);
    }

    public void setScrimColor(int i) {
        this.f4226b = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.f4217a = i != 0 ? yb.d(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f4217a = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f4217a = new ColorDrawable(i);
        invalidate();
    }

    public final MotionEvent t(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f4214a == null) {
                this.f4214a = new Matrix();
            }
            matrix.invert(this.f4214a);
            motionEventObtain.transform(this.f4214a);
        }
        return motionEventObtain;
    }

    public final boolean w() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((e) getChildAt(i).getLayoutParams()).f4246a) {
                return true;
            }
        }
        return false;
    }

    public final boolean x() {
        return n() != null;
    }

    public boolean z(View view) {
        return ((e) view.getLayoutParams()).f4245a == 0;
    }
}
