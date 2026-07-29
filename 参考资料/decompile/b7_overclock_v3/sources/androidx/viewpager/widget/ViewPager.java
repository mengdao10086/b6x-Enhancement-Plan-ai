package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import g.n0;
import g.p0;
import g.t0;
import g.v;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPager extends ViewGroup {
    public static final String W7 = "ViewPager";
    public static final boolean X7 = false;
    public static final boolean Y7 = false;
    public static final int Z7 = 1;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final int f8070a8 = 600;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final int f8071b8 = 25;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public static final int f8072c8 = 16;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final int f8073d8 = 400;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final int f8077h8 = -1;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final int f8078i8 = 2;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public static final int f8079j8 = 0;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public static final int f8080k8 = 1;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public static final int f8081l8 = 2;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public static final int f8083n8 = 0;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public static final int f8084o8 = 1;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public static final int f8085p8 = 2;
    public int A;
    public int B;
    public int C;
    public VelocityTracker C1;
    public int C2;
    public float D;
    public boolean E7;
    public long F7;
    public EdgeEffect G7;
    public EdgeEffect H7;
    public boolean I7;
    public boolean J7;
    public float K0;
    public int K1;
    public int K2;
    public boolean K7;
    public int L7;
    public List<j> M7;
    public j N7;
    public j O7;
    public List<i> P7;
    public k Q7;
    public int R7;
    public int S7;
    public ArrayList<View> T7;
    public final Runnable U7;
    public int V7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<f> f8087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f8088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f8089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k2.a f8090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Parcelable f8093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ClassLoader f8094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Scroller f8095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8096k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f8097k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f8098k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l f8099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f8101n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8102o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8103p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f8104q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f8105r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f8106s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f8107t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8108u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8109v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f8110v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f8111v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8112w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8113x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f8114y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f8115z;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final int[] f8074e8 = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final Comparator<f> f8075f8 = new a();

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final Interpolator f8076g8 = new b();

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public static final n f8082m8 = new n();

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Parcelable f8117d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ClassLoader f8118e;

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

        public SavedState(@n0 Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f8116c + zc.a.f58317e;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f8116c);
            parcel.writeParcelable(this.f8117d, i10);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f8116c = parcel.readInt();
            this.f8117d = parcel.readParcelable(classLoader);
            this.f8118e = classLoader;
        }
    }

    public static class a implements Comparator<f> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f8123b - fVar2.f8123b;
        }
    }

    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.L();
        }
    }

    public class d implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f8120a = new Rect();

        public d() {
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, j1 j1Var) {
            j1 j1VarG1 = u0.g1(view, j1Var);
            if (j1VarG1.A()) {
                return j1VarG1;
            }
            Rect rect = this.f8120a;
            rect.left = j1VarG1.p();
            rect.top = j1VarG1.r();
            rect.right = j1VarG1.q();
            rect.bottom = j1VarG1.o();
            int childCount = ViewPager.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                j1 j1VarP = u0.p(ViewPager.this.getChildAt(i10), j1VarG1);
                rect.left = Math.min(j1VarP.p(), rect.left);
                rect.top = Math.min(j1VarP.r(), rect.top);
                rect.right = Math.min(j1VarP.q(), rect.right);
                rect.bottom = Math.min(j1VarP.o(), rect.bottom);
            }
            return j1VarG1.D(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f8122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f8125d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f8126e;
    }

    public class h extends androidx.core.view.a {
        public h() {
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            k2.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.f8090e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.getCount());
            accessibilityEvent.setFromIndex(ViewPager.this.f8091f);
            accessibilityEvent.setToIndex(ViewPager.this.f8091f);
        }

        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            dVar.b1(ViewPager.class.getName());
            dVar.M1(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                dVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                dVar.a(8192);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            if (i10 == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f8091f + 1);
                return true;
            }
            if (i10 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f8091f - 1);
            return true;
        }

        public final boolean n() {
            k2.a aVar = ViewPager.this.f8090e;
            return aVar != null && aVar.getCount() > 1;
        }
    }

    public interface i {
        void a(@n0 ViewPager viewPager, @p0 k2.a aVar, @p0 k2.a aVar2);
    }

    public interface j {
        void onPageScrollStateChanged(int i10);

        void onPageScrolled(int i10, float f10, @t0 int i11);

        void onPageSelected(int i10);
    }

    public interface k {
        void a(@n0 View view, float f10);
    }

    public class l extends DataSetObserver {
        public l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.l();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.l();
        }
    }

    public static class m implements j {
        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
        }
    }

    public static class n implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z10 = gVar.f8127a;
            return z10 != gVar2.f8127a ? z10 ? 1 : -1 : gVar.f8131e - gVar2.f8131e;
        }
    }

    public ViewPager(@n0 Context context) {
        super(context);
        this.f8087b = new ArrayList<>();
        this.f8088c = new f();
        this.f8089d = new Rect();
        this.f8092g = -1;
        this.f8093h = null;
        this.f8094i = null;
        this.f8104q = -3.4028235E38f;
        this.f8105r = Float.MAX_VALUE;
        this.f8113x = 1;
        this.f8110v1 = -1;
        this.I7 = true;
        this.J7 = false;
        this.U7 = new c();
        this.V7 = 0;
        B();
    }

    public static boolean C(@n0 View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.f8109v != z10) {
            this.f8109v = z10;
        }
    }

    public f A(int i10) {
        for (int i11 = 0; i11 < this.f8087b.size(); i11++) {
            f fVar = this.f8087b.get(i11);
            if (fVar.f8123b == i10) {
                return fVar;
            }
        }
        return null;
    }

    public void B() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f8095j = new Scroller(context, f8076g8);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.C = viewConfiguration.getScaledPagingTouchSlop();
        this.K1 = (int) (400.0f * f10);
        this.f8111v2 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.G7 = new EdgeEffect(context);
        this.H7 = new EdgeEffect(context);
        this.C2 = (int) (25.0f * f10);
        this.K2 = (int) (2.0f * f10);
        this.A = (int) (f10 * 16.0f);
        u0.B1(this, new h());
        if (u0.V(this) == 0) {
            u0.R1(this, 1);
        }
        u0.a2(this, new d());
    }

    public boolean D() {
        return this.E7;
    }

    public final boolean E(float f10, float f11) {
        return (f10 < ((float) this.B) && f11 > 0.0f) || (f10 > ((float) (getWidth() - this.B)) && f11 < 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    @g.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.L7
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r9 = (androidx.viewpager.widget.ViewPager.g) r9
            boolean r10 = r9.f8127a
            if (r10 != 0) goto L2c
            goto L68
        L2c:
            int r9 = r9.f8128b
            r9 = r9 & 7
            if (r9 == r2) goto L4d
            r10 = 3
            if (r9 == r10) goto L47
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5c
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L59
        L47:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L59:
            r11 = r9
            r9 = r3
            r3 = r11
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            r12.n(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$k r13 = r12.Q7
            if (r13 == 0) goto L9f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7a:
            if (r1 >= r14) goto L9f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r0 = (androidx.viewpager.widget.ViewPager.g) r0
            boolean r0 = r0.f8127a
            if (r0 == 0) goto L8b
            goto L9c
        L8b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$k r3 = r12.Q7
            r3.a(r15, r0)
        L9c:
            int r1 = r1 + 1
            goto L7a
        L9f:
            r12.K7 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.F(int, float, int):void");
    }

    public final void G(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f8110v1) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.D = motionEvent.getX(i10);
            this.f8110v1 = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.C1;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean H() {
        int i10 = this.f8091f;
        if (i10 <= 0) {
            return false;
        }
        U(i10 - 1, true);
        return true;
    }

    public boolean I() {
        k2.a aVar = this.f8090e;
        if (aVar == null || this.f8091f >= aVar.getCount() - 1) {
            return false;
        }
        U(this.f8091f + 1, true);
        return true;
    }

    public final boolean J(int i10) {
        if (this.f8087b.size() == 0) {
            if (this.I7) {
                return false;
            }
            this.K7 = false;
            F(0, 0.0f, 0);
            if (this.K7) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarZ = z();
        int clientWidth = getClientWidth();
        int i11 = this.f8100m;
        int i12 = clientWidth + i11;
        float f10 = clientWidth;
        int i13 = fVarZ.f8123b;
        float f11 = ((i10 / f10) - fVarZ.f8126e) / (fVarZ.f8125d + (i11 / f10));
        this.K7 = false;
        F(i13, f11, (int) (i12 * f11));
        if (this.K7) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean K(float f10) {
        boolean z10;
        boolean z11;
        float f11 = this.D - f10;
        this.D = f10;
        float scrollX = getScrollX() + f11;
        float clientWidth = getClientWidth();
        float f12 = this.f8104q * clientWidth;
        float f13 = this.f8105r * clientWidth;
        boolean z12 = false;
        f fVar = this.f8087b.get(0);
        ArrayList<f> arrayList = this.f8087b;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f8123b != 0) {
            f12 = fVar.f8126e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (fVar2.f8123b != this.f8090e.getCount() - 1) {
            f13 = fVar2.f8126e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f12) {
            if (z10) {
                this.G7.onPull(Math.abs(f12 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f12;
        } else if (scrollX > f13) {
            if (z11) {
                this.H7.onPull(Math.abs(scrollX - f13) / clientWidth);
                z12 = true;
            }
            scrollX = f13;
        }
        int i10 = (int) scrollX;
        this.D += scrollX - i10;
        scrollTo(i10, getScrollY());
        J(i10);
        return z12;
    }

    public void L() {
        M(this.f8091f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f7 A[PHI: r7 r10 r15
  0x00f7: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00f7: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00f7: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ec, B:59:0x00d6, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M(int r18) {
        /*
            Method dump skipped, instruction units count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.M(int):void");
    }

    public final void N(int i10, int i11, int i12, int i13) {
        if (i11 > 0 && !this.f8087b.isEmpty()) {
            if (!this.f8095j.isFinished()) {
                this.f8095j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)) * (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)), getScrollY());
                return;
            }
        }
        f fVarA = A(this.f8091f);
        int iMin = (int) ((fVarA != null ? Math.min(fVarA.f8126e, this.f8105r) : 0.0f) * ((i10 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            k(false);
            scrollTo(iMin, getScrollY());
        }
    }

    public final void O() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((g) getChildAt(i10).getLayoutParams()).f8127a) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    public void P(@n0 i iVar) {
        List<i> list = this.P7;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void Q(@n0 j jVar) {
        List<j> list = this.M7;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public final void R(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public final boolean S() {
        this.f8110v1 = -1;
        s();
        this.G7.onRelease();
        this.H7.onRelease();
        return this.G7.isFinished() || this.H7.isFinished();
    }

    public final void T(int i10, boolean z10, int i11, boolean z11) {
        f fVarA = A(i10);
        int clientWidth = fVarA != null ? (int) (getClientWidth() * Math.max(this.f8104q, Math.min(fVarA.f8126e, this.f8105r))) : 0;
        if (z10) {
            b0(clientWidth, 0, i11);
            if (z11) {
                o(i10);
                return;
            }
            return;
        }
        if (z11) {
            o(i10);
        }
        k(false);
        scrollTo(clientWidth, 0);
        J(clientWidth);
    }

    public void U(int i10, boolean z10) {
        this.f8112w = false;
        V(i10, z10, false);
    }

    public void V(int i10, boolean z10, boolean z11) {
        W(i10, z10, z11, 0);
    }

    public void W(int i10, boolean z10, boolean z11, int i11) {
        k2.a aVar = this.f8090e;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z11 && this.f8091f == i10 && this.f8087b.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 >= this.f8090e.getCount()) {
            i10 = this.f8090e.getCount() - 1;
        }
        int i12 = this.f8113x;
        int i13 = this.f8091f;
        if (i10 > i13 + i12 || i10 < i13 - i12) {
            for (int i14 = 0; i14 < this.f8087b.size(); i14++) {
                this.f8087b.get(i14).f8124c = true;
            }
        }
        boolean z12 = this.f8091f != i10;
        if (!this.I7) {
            M(i10);
            T(i10, z10, i11, z12);
        } else {
            this.f8091f = i10;
            if (z12) {
                o(i10);
            }
            requestLayout();
        }
    }

    public j X(j jVar) {
        j jVar2 = this.O7;
        this.O7 = jVar;
        return jVar2;
    }

    public void Y(boolean z10, @p0 k kVar) {
        Z(z10, kVar, 2);
    }

    public void Z(boolean z10, @p0 k kVar, int i10) {
        boolean z11 = kVar != null;
        boolean z12 = z11 != (this.Q7 != null);
        this.Q7 = kVar;
        setChildrenDrawingOrderEnabled(z11);
        if (z11) {
            this.S7 = z10 ? 2 : 1;
            this.R7 = i10;
        } else {
            this.S7 = 0;
        }
        if (z12) {
            L();
        }
    }

    public void a0(int i10, int i11) {
        b0(i10, i11, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        f fVarY;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (fVarY = y(childAt)) != null && fVarY.f8123b == this.f8091f) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f fVarY;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (fVarY = y(childAt)) != null && fVarY.f8123b == this.f8091f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean zC = gVar.f8127a | C(view);
        gVar.f8127a = zC;
        if (!this.f8108u) {
            super.addView(view, i10, layoutParams);
        } else {
            if (zC) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.f8130d = true;
            addViewInLayout(view, i10, layoutParams);
        }
    }

    public void b0(int i10, int i11, int i12) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f8095j;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f8096k ? this.f8095j.getCurrX() : this.f8095j.getStartX();
            this.f8095j.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i13 = scrollX;
        int scrollY = getScrollY();
        int i14 = i10 - i13;
        int i15 = i11 - scrollY;
        if (i14 == 0 && i15 == 0) {
            k(false);
            L();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i16 = clientWidth / 2;
        float f10 = clientWidth;
        float f11 = i16;
        float fQ = f11 + (q(Math.min(1.0f, (Math.abs(i14) * 1.0f) / f10)) * f11);
        int iAbs = Math.abs(i12);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fQ / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i14) / ((f10 * this.f8090e.getPageWidth(this.f8091f)) + this.f8100m)) + 1.0f) * 100.0f), 600);
        this.f8096k = false;
        this.f8095j.startScroll(i13, scrollY, i14, i15, iMin);
        u0.n1(this);
    }

    public f c(int i10, int i11) {
        f fVar = new f();
        fVar.f8123b = i10;
        fVar.f8122a = this.f8090e.instantiateItem((ViewGroup) this, i10);
        fVar.f8125d = this.f8090e.getPageWidth(i10);
        if (i11 < 0 || i11 >= this.f8087b.size()) {
            this.f8087b.add(fVar);
        } else {
            this.f8087b.add(i11, fVar);
        }
        return fVar;
    }

    public final void c0() {
        if (this.S7 != 0) {
            ArrayList<View> arrayList = this.T7;
            if (arrayList == null) {
                this.T7 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.T7.add(getChildAt(i10));
            }
            Collections.sort(this.T7, f8082m8);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.f8090e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i10 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f8104q)) : i10 > 0 && scrollX < ((int) (((float) clientWidth) * this.f8105r));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f8096k = true;
        if (this.f8095j.isFinished() || !this.f8095j.computeScrollOffset()) {
            k(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f8095j.getCurrX();
        int currY = this.f8095j.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!J(currX)) {
                this.f8095j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        u0.n1(this);
    }

    public void d(@n0 i iVar) {
        if (this.P7 == null) {
            this.P7 = new ArrayList();
        }
        this.P7.add(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || u(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarY;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (fVarY = y(childAt)) != null && fVarY.f8123b == this.f8091f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        k2.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f8090e) != null && aVar.getCount() > 1)) {
            if (!this.G7.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f8104q * width);
                this.G7.setSize(height, width);
                zDraw = false | this.G7.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.H7.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f8105r + 1.0f)) * width2);
                this.H7.setSize(height2, width2);
                zDraw |= this.H7.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.G7.finish();
            this.H7.finish();
        }
        if (zDraw) {
            u0.n1(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f8101n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void e(@n0 j jVar) {
        if (this.M7 == null) {
            this.M7 = new ArrayList();
        }
        this.M7.add(jVar);
    }

    public boolean f(int i10) {
        boolean z10;
        boolean zRequestFocus;
        View viewFindFocus = findFocus();
        boolean zH = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z10 = false;
                    break;
                }
                if (parent == this) {
                    z10 = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb2.append(" => ");
                    sb2.append(parent2.getClass().getSimpleName());
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("arrowScroll tried to find focus based on non-child current focused view ");
                sb3.append(sb2.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i10 == 17) {
                zRequestFocus = (viewFindFocus == null || w(this.f8089d, viewFindNextFocus).left < w(this.f8089d, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : H();
            } else if (i10 == 66) {
                zRequestFocus = (viewFindFocus == null || w(this.f8089d, viewFindNextFocus).left > w(this.f8089d, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : I();
            }
            zH = zRequestFocus;
        } else if (i10 == 17 || i10 == 1) {
            zH = H();
        } else if (i10 == 66 || i10 == 2) {
            zH = I();
        }
        if (zH) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
        }
        return zH;
    }

    public boolean g() {
        if (this.f8114y) {
            return false;
        }
        this.E7 = true;
        setScrollState(1);
        this.D = 0.0f;
        this.K0 = 0.0f;
        VelocityTracker velocityTracker = this.C1;
        if (velocityTracker == null) {
            this.C1 = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.C1.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.F7 = jUptimeMillis;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @p0
    public k2.a getAdapter() {
        return this.f8090e;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        if (this.S7 == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((g) this.T7.get(i11).getLayoutParams()).f8132f;
    }

    public int getCurrentItem() {
        return this.f8091f;
    }

    public int getOffscreenPageLimit() {
        return this.f8113x;
    }

    public int getPageMargin() {
        return this.f8100m;
    }

    public final void h(f fVar, int i10, f fVar2) {
        int i11;
        int i12;
        f fVar3;
        f fVar4;
        int count = this.f8090e.getCount();
        int clientWidth = getClientWidth();
        float f10 = clientWidth > 0 ? this.f8100m / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i13 = fVar2.f8123b;
            int i14 = fVar.f8123b;
            if (i13 < i14) {
                float pageWidth = fVar2.f8126e + fVar2.f8125d + f10;
                int i15 = i13 + 1;
                int i16 = 0;
                while (i15 <= fVar.f8123b && i16 < this.f8087b.size()) {
                    f fVar5 = this.f8087b.get(i16);
                    while (true) {
                        fVar4 = fVar5;
                        if (i15 <= fVar4.f8123b || i16 >= this.f8087b.size() - 1) {
                            break;
                        }
                        i16++;
                        fVar5 = this.f8087b.get(i16);
                    }
                    while (i15 < fVar4.f8123b) {
                        pageWidth += this.f8090e.getPageWidth(i15) + f10;
                        i15++;
                    }
                    fVar4.f8126e = pageWidth;
                    pageWidth += fVar4.f8125d + f10;
                    i15++;
                }
            } else if (i13 > i14) {
                int size = this.f8087b.size() - 1;
                float pageWidth2 = fVar2.f8126e;
                while (true) {
                    i13--;
                    if (i13 < fVar.f8123b || size < 0) {
                        break;
                    }
                    f fVar6 = this.f8087b.get(size);
                    while (true) {
                        fVar3 = fVar6;
                        if (i13 >= fVar3.f8123b || size <= 0) {
                            break;
                        }
                        size--;
                        fVar6 = this.f8087b.get(size);
                    }
                    while (i13 > fVar3.f8123b) {
                        pageWidth2 -= this.f8090e.getPageWidth(i13) + f10;
                        i13--;
                    }
                    pageWidth2 -= fVar3.f8125d + f10;
                    fVar3.f8126e = pageWidth2;
                }
            }
        }
        int size2 = this.f8087b.size();
        float pageWidth3 = fVar.f8126e;
        int i17 = fVar.f8123b;
        int i18 = i17 - 1;
        this.f8104q = i17 == 0 ? pageWidth3 : -3.4028235E38f;
        int i19 = count - 1;
        this.f8105r = i17 == i19 ? (fVar.f8125d + pageWidth3) - 1.0f : Float.MAX_VALUE;
        int i20 = i10 - 1;
        while (i20 >= 0) {
            f fVar7 = this.f8087b.get(i20);
            while (true) {
                i12 = fVar7.f8123b;
                if (i18 <= i12) {
                    break;
                }
                pageWidth3 -= this.f8090e.getPageWidth(i18) + f10;
                i18--;
            }
            pageWidth3 -= fVar7.f8125d + f10;
            fVar7.f8126e = pageWidth3;
            if (i12 == 0) {
                this.f8104q = pageWidth3;
            }
            i20--;
            i18--;
        }
        float pageWidth4 = fVar.f8126e + fVar.f8125d + f10;
        int i21 = fVar.f8123b + 1;
        int i22 = i10 + 1;
        while (i22 < size2) {
            f fVar8 = this.f8087b.get(i22);
            while (true) {
                i11 = fVar8.f8123b;
                if (i21 >= i11) {
                    break;
                }
                pageWidth4 += this.f8090e.getPageWidth(i21) + f10;
                i21++;
            }
            if (i11 == i19) {
                this.f8105r = (fVar8.f8125d + pageWidth4) - 1.0f;
            }
            fVar8.f8126e = pageWidth4;
            pageWidth4 += fVar8.f8125d + f10;
            i22++;
            i21++;
        }
        this.J7 = false;
    }

    public boolean i(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && i(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && view.canScrollHorizontally(-i10);
    }

    public void j() {
        List<j> list = this.M7;
        if (list != null) {
            list.clear();
        }
    }

    public final void k(boolean z10) {
        boolean z11 = this.V7 == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            if (!this.f8095j.isFinished()) {
                this.f8095j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f8095j.getCurrX();
                int currY = this.f8095j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        J(currX);
                    }
                }
            }
        }
        this.f8112w = false;
        for (int i10 = 0; i10 < this.f8087b.size(); i10++) {
            f fVar = this.f8087b.get(i10);
            if (fVar.f8124c) {
                fVar.f8124c = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                u0.p1(this, this.U7);
            } else {
                this.U7.run();
            }
        }
    }

    public void l() {
        int count = this.f8090e.getCount();
        this.f8086a = count;
        boolean z10 = this.f8087b.size() < (this.f8113x * 2) + 1 && this.f8087b.size() < count;
        int iMax = this.f8091f;
        int i10 = 0;
        boolean z11 = false;
        while (i10 < this.f8087b.size()) {
            f fVar = this.f8087b.get(i10);
            int itemPosition = this.f8090e.getItemPosition(fVar.f8122a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f8087b.remove(i10);
                    i10--;
                    if (!z11) {
                        this.f8090e.startUpdate((ViewGroup) this);
                        z11 = true;
                    }
                    this.f8090e.destroyItem((ViewGroup) this, fVar.f8123b, fVar.f8122a);
                    int i11 = this.f8091f;
                    if (i11 == fVar.f8123b) {
                        iMax = Math.max(0, Math.min(i11, count - 1));
                    }
                } else {
                    int i12 = fVar.f8123b;
                    if (i12 != itemPosition) {
                        if (i12 == this.f8091f) {
                            iMax = itemPosition;
                        }
                        fVar.f8123b = itemPosition;
                    }
                }
                z10 = true;
            }
            i10++;
        }
        if (z11) {
            this.f8090e.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f8087b, f8075f8);
        if (z10) {
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                g gVar = (g) getChildAt(i13).getLayoutParams();
                if (!gVar.f8127a) {
                    gVar.f8129c = 0.0f;
                }
            }
            V(iMax, false, true);
            requestLayout();
        }
    }

    public final int m(int i10, float f10, int i11, int i12) {
        if (Math.abs(i12) <= this.C2 || Math.abs(i11) <= this.K1) {
            i10 += (int) (f10 + (i10 >= this.f8091f ? 0.4f : 0.6f));
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.f8087b.size() <= 0) {
            return i10;
        }
        return Math.max(this.f8087b.get(0).f8123b, Math.min(i10, this.f8087b.get(r4.size() - 1).f8123b));
    }

    public final void n(int i10, float f10, int i11) {
        j jVar = this.N7;
        if (jVar != null) {
            jVar.onPageScrolled(i10, f10, i11);
        }
        List<j> list = this.M7;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                j jVar2 = this.M7.get(i12);
                if (jVar2 != null) {
                    jVar2.onPageScrolled(i10, f10, i11);
                }
            }
        }
        j jVar3 = this.O7;
        if (jVar3 != null) {
            jVar3.onPageScrolled(i10, f10, i11);
        }
    }

    public final void o(int i10) {
        j jVar = this.N7;
        if (jVar != null) {
            jVar.onPageSelected(i10);
        }
        List<j> list = this.M7;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.M7.get(i11);
                if (jVar2 != null) {
                    jVar2.onPageSelected(i10);
                }
            }
        }
        j jVar3 = this.O7;
        if (jVar3 != null) {
            jVar3.onPageSelected(i10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I7 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.U7);
        Scroller scroller = this.f8095j;
        if (scroller != null && !scroller.isFinished()) {
            this.f8095j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.f8100m <= 0 || this.f8101n == null || this.f8087b.size() <= 0 || this.f8090e == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f12 = this.f8100m / width;
        int i11 = 0;
        f fVar = this.f8087b.get(0);
        float f13 = fVar.f8126e;
        int size = this.f8087b.size();
        int i12 = fVar.f8123b;
        int i13 = this.f8087b.get(size - 1).f8123b;
        while (i12 < i13) {
            while (true) {
                i10 = fVar.f8123b;
                if (i12 <= i10 || i11 >= size) {
                    break;
                }
                i11++;
                fVar = this.f8087b.get(i11);
            }
            if (i12 == i10) {
                float f14 = fVar.f8126e;
                float f15 = fVar.f8125d;
                f10 = (f14 + f15) * width;
                f13 = f14 + f15 + f12;
            } else {
                float pageWidth = this.f8090e.getPageWidth(i12);
                f10 = (f13 + pageWidth) * width;
                f13 += pageWidth + f12;
            }
            if (this.f8100m + f10 > scrollX) {
                f11 = f12;
                this.f8101n.setBounds(Math.round(f10), this.f8102o, Math.round(this.f8100m + f10), this.f8103p);
                this.f8101n.draw(canvas);
            } else {
                f11 = f12;
            }
            if (f10 > scrollX + r2) {
                return;
            }
            i12++;
            f12 = f11;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            S();
            return false;
        }
        if (action != 0) {
            if (this.f8114y) {
                return true;
            }
            if (this.f8115z) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.K0 = x10;
            this.D = x10;
            float y10 = motionEvent.getY();
            this.f8098k1 = y10;
            this.f8097k0 = y10;
            this.f8110v1 = motionEvent.getPointerId(0);
            this.f8115z = false;
            this.f8096k = true;
            this.f8095j.computeScrollOffset();
            if (this.V7 != 2 || Math.abs(this.f8095j.getFinalX() - this.f8095j.getCurrX()) <= this.K2) {
                k(false);
                this.f8114y = false;
            } else {
                this.f8095j.abortAnimation();
                this.f8112w = false;
                L();
                this.f8114y = true;
                R(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.f8110v1;
            if (i10 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i10);
                float x11 = motionEvent.getX(iFindPointerIndex);
                float f10 = x11 - this.D;
                float fAbs = Math.abs(f10);
                float y11 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y11 - this.f8098k1);
                if (f10 != 0.0f && !E(this.D, f10) && i(this, false, (int) f10, (int) x11, (int) y11)) {
                    this.D = x11;
                    this.f8097k0 = y11;
                    this.f8115z = true;
                    return false;
                }
                int i11 = this.C;
                if (fAbs > i11 && fAbs * 0.5f > fAbs2) {
                    this.f8114y = true;
                    R(true);
                    setScrollState(1);
                    float f11 = this.K0;
                    float f12 = this.C;
                    this.D = f10 > 0.0f ? f11 + f12 : f11 - f12;
                    this.f8097k0 = y11;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i11) {
                    this.f8115z = true;
                }
                if (this.f8114y && K(x11)) {
                    u0.n1(this);
                }
            }
        } else if (action == 6) {
            G(motionEvent);
        }
        if (this.C1 == null) {
            this.C1 = VelocityTracker.obtain();
        }
        this.C1.addMovement(motionEvent);
        return this.f8114y;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        f fVarY;
        int childCount = getChildCount();
        int i13 = -1;
        if ((i10 & 2) != 0) {
            i13 = childCount;
            i11 = 0;
            i12 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
        }
        while (i11 != i13) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (fVarY = y(childAt)) != null && fVarY.f8123b == this.f8091f && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i12;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        k2.a aVar = this.f8090e;
        if (aVar != null) {
            aVar.restoreState(savedState.f8117d, savedState.f8118e);
            V(savedState.f8116c, false, true);
        } else {
            this.f8092g = savedState.f8116c;
            this.f8093h = savedState.f8117d;
            this.f8094i = savedState.f8118e;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8116c = this.f8091f;
        k2.a aVar = this.f8090e;
        if (aVar != null) {
            savedState.f8117d = aVar.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.f8100m;
            N(i10, i12, i14, i14);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i10) {
        j jVar = this.N7;
        if (jVar != null) {
            jVar.onPageScrollStateChanged(i10);
        }
        List<j> list = this.M7;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.M7.get(i11);
                if (jVar2 != null) {
                    jVar2.onPageScrollStateChanged(i10);
                }
            }
        }
        j jVar3 = this.O7;
        if (jVar3 != null) {
            jVar3.onPageScrollStateChanged(i10);
        }
    }

    public float q(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public final void r(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setLayerType(z10 ? this.R7 : 0, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f8108u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final void s() {
        this.f8114y = false;
        this.f8115z = false;
        VelocityTracker velocityTracker = this.C1;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.C1 = null;
        }
    }

    public void setAdapter(@p0 k2.a aVar) {
        k2.a aVar2 = this.f8090e;
        if (aVar2 != null) {
            aVar2.setViewPagerObserver(null);
            this.f8090e.startUpdate((ViewGroup) this);
            for (int i10 = 0; i10 < this.f8087b.size(); i10++) {
                f fVar = this.f8087b.get(i10);
                this.f8090e.destroyItem((ViewGroup) this, fVar.f8123b, fVar.f8122a);
            }
            this.f8090e.finishUpdate((ViewGroup) this);
            this.f8087b.clear();
            O();
            this.f8091f = 0;
            scrollTo(0, 0);
        }
        k2.a aVar3 = this.f8090e;
        this.f8090e = aVar;
        this.f8086a = 0;
        if (aVar != null) {
            if (this.f8099l == null) {
                this.f8099l = new l();
            }
            this.f8090e.setViewPagerObserver(this.f8099l);
            this.f8112w = false;
            boolean z10 = this.I7;
            this.I7 = true;
            this.f8086a = this.f8090e.getCount();
            if (this.f8092g >= 0) {
                this.f8090e.restoreState(this.f8093h, this.f8094i);
                V(this.f8092g, false, true);
                this.f8092g = -1;
                this.f8093h = null;
                this.f8094i = null;
            } else if (z10) {
                requestLayout();
            } else {
                L();
            }
        }
        List<i> list = this.P7;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.P7.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.P7.get(i11).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i10) {
        this.f8112w = false;
        V(i10, !this.I7, false);
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Requested offscreen page limit ");
            sb2.append(i10);
            sb2.append(" too small; defaulting to ");
            sb2.append(1);
            i10 = 1;
        }
        if (i10 != this.f8113x) {
            this.f8113x = i10;
            L();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.N7 = jVar;
    }

    public void setPageMargin(int i10) {
        int i11 = this.f8100m;
        this.f8100m = i10;
        int width = getWidth();
        N(width, width, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(@p0 Drawable drawable) {
        this.f8101n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i10) {
        if (this.V7 == i10) {
            return;
        }
        this.V7 = i10;
        if (this.Q7 != null) {
            r(i10 != 0);
        }
        p(i10);
    }

    public void t() {
        if (!this.E7) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f8090e != null) {
            VelocityTracker velocityTracker = this.C1;
            velocityTracker.computeCurrentVelocity(1000, this.f8111v2);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f8110v1);
            this.f8112w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f fVarZ = z();
            W(m(fVarZ.f8123b, ((scrollX / clientWidth) - fVarZ.f8126e) / fVarZ.f8125d, xVelocity, (int) (this.D - this.K0)), true, true, xVelocity);
        }
        s();
        this.E7 = false;
    }

    public boolean u(@n0 KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? H() : f(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? I() : f(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return f(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return f(1);
                }
            }
        }
        return false;
    }

    public void v(float f10) {
        if (!this.E7) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.f8090e == null) {
            return;
        }
        this.D += f10;
        float scrollX = getScrollX() - f10;
        float clientWidth = getClientWidth();
        float f11 = this.f8104q * clientWidth;
        float f12 = this.f8105r * clientWidth;
        f fVar = this.f8087b.get(0);
        f fVar2 = this.f8087b.get(r4.size() - 1);
        if (fVar.f8123b != 0) {
            f11 = fVar.f8126e * clientWidth;
        }
        if (fVar2.f8123b != this.f8090e.getCount() - 1) {
            f12 = fVar2.f8126e * clientWidth;
        }
        if (scrollX < f11) {
            scrollX = f11;
        } else if (scrollX > f12) {
            scrollX = f12;
        }
        int i10 = (int) scrollX;
        this.D += scrollX - i10;
        scrollTo(i10, getScrollY());
        J(i10);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.F7, SystemClock.uptimeMillis(), 2, this.D, 0.0f, 0);
        this.C1.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f8101n;
    }

    public final Rect w(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public f x(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return y(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public f y(View view) {
        for (int i10 = 0; i10 < this.f8087b.size(); i10++) {
            f fVar = this.f8087b.get(i10);
            if (this.f8090e.isViewFromObject(view, fVar.f8122a)) {
                return fVar;
            }
        }
        return null;
    }

    public final f z() {
        int i10;
        int clientWidth = getClientWidth();
        float f10 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f11 = clientWidth > 0 ? this.f8100m / clientWidth : 0.0f;
        f fVar = null;
        float f12 = 0.0f;
        int i11 = -1;
        int i12 = 0;
        boolean z10 = true;
        while (i12 < this.f8087b.size()) {
            f fVar2 = this.f8087b.get(i12);
            if (!z10 && fVar2.f8123b != (i10 = i11 + 1)) {
                fVar2 = this.f8088c;
                fVar2.f8126e = f10 + f12 + f11;
                fVar2.f8123b = i10;
                fVar2.f8125d = this.f8090e.getPageWidth(i10);
                i12--;
            }
            f10 = fVar2.f8126e;
            float f13 = fVar2.f8125d + f10 + f11;
            if (!z10 && scrollX < f10) {
                return fVar;
            }
            if (scrollX < f13 || i12 == this.f8087b.size() - 1) {
                return fVar2;
            }
            i11 = fVar2.f8123b;
            f12 = fVar2.f8125d;
            i12++;
            fVar = fVar2;
            z10 = false;
        }
        return fVar;
    }

    public static class g extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f8129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8130d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8131e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8132f;

        public g() {
            super(-1, -1);
            this.f8129c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8129c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f8074e8);
            this.f8128b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(@v int i10) {
        setPageMarginDrawable(h0.d.i(getContext(), i10));
    }

    public ViewPager(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8087b = new ArrayList<>();
        this.f8088c = new f();
        this.f8089d = new Rect();
        this.f8092g = -1;
        this.f8093h = null;
        this.f8094i = null;
        this.f8104q = -3.4028235E38f;
        this.f8105r = Float.MAX_VALUE;
        this.f8113x = 1;
        this.f8110v1 = -1;
        this.I7 = true;
        this.J7 = false;
        this.U7 = new c();
        this.V7 = 0;
        B();
    }
}
