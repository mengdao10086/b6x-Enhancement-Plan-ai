package androidx.viewpager.widget;

import a.ak;
import a.eh;
import a.ku;
import a.lu;
import a.ng;
import a.ni;
import a.rf;
import a.sh;
import a.yb;
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
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ViewPager extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f4455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ku f4457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Parcelable f4460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VelocityTracker f4461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EdgeEffect f4462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Scroller f4463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f f4464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j f4465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k f4466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l f4467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ClassLoader f4468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<f> f4470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<j> f4471a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4472b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public EdgeEffect f4473b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public j f4474b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<View> f4475b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<i> f4476b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4477b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f4478c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4479c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f4480d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4481d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f4482e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4483e;
    public float f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f4484f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4485f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4486g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4487h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4488i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f4489j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f4454a = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Comparator<f> f4453a = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f8253a = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final n f4452a = new n();

    public static class a implements Comparator<f> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.f4491a - fVar2.f4491a;
        }
    }

    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.E();
        }
    }

    public class d implements ng {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f8255a = new Rect();

        public d() {
        }

        @Override // a.ng
        public sh a(View view, sh shVar) {
            sh shVarX = eh.X(view, shVar);
            if (shVarX.l()) {
                return shVarX;
            }
            Rect rect = this.f8255a;
            rect.left = shVarX.g();
            rect.top = shVarX.i();
            rect.right = shVarX.h();
            rect.bottom = shVarX.f();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                sh shVarG = eh.g(ViewPager.this.getChildAt(i), shVarX);
                rect.left = Math.min(shVarG.g(), rect.left);
                rect.top = Math.min(shVarG.i(), rect.top);
                rect.right = Math.min(shVarG.h(), rect.right);
                rect.bottom = Math.min(shVarG.f(), rect.bottom);
            }
            return shVarX.m(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8256a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4491a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4492a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4493a;
        public float b;
    }

    public static class g extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8257a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4494a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4495a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4496b;
        public int c;

        public g() {
            super(-1, -1);
            this.f8257a = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8257a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f4454a);
            this.f4494a = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class h extends rf {
        public h() {
        }

        @Override // a.rf
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            ku kuVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() != 4096 || (kuVar = ViewPager.this.f4457a) == null) {
                return;
            }
            accessibilityEvent.setItemCount(kuVar.c());
            accessibilityEvent.setFromIndex(ViewPager.this.f4472b);
            accessibilityEvent.setToIndex(ViewPager.this.f4472b);
        }

        @Override // a.rf
        public void g(View view, ni niVar) {
            super.g(view, niVar);
            niVar.a0(ViewPager.class.getName());
            niVar.u0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                niVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                niVar.a(8192);
            }
        }

        @Override // a.rf
        public boolean j(View view, int i, Bundle bundle) {
            ViewPager viewPager;
            int i2;
            if (super.j(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i2 = viewPager.f4472b - 1;
            } else {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i2 = viewPager.f4472b + 1;
            }
            viewPager.setCurrentItem(i2);
            return true;
        }

        public final boolean n() {
            ku kuVar = ViewPager.this.f4457a;
            return kuVar != null && kuVar.c() > 1;
        }
    }

    public interface i {
        void a(ViewPager viewPager, ku kuVar, ku kuVar2);
    }

    public interface j {
        void a(int i);

        void b(int i);

        void c(int i, float f, int i2);
    }

    public interface k {
        void a(View view, float f);
    }

    public class l extends DataSetObserver {
        public l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.h();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.h();
        }
    }

    public static class m extends ak {
        public static final Parcelable.Creator<m> CREATOR = new lu();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8260a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ClassLoader f4497a;
        public Parcelable b;

        public m(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? m.class.getClassLoader() : classLoader;
            this.f8260a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.f4497a = classLoader;
        }

        public m(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f8260a + "}";
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8260a);
            parcel.writeParcelable(this.b, i);
        }
    }

    public static class n implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z = gVar.f4495a;
            return z != gVar2.f4495a ? z ? 1 : -1 : gVar.b - gVar2.b;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4470a = new ArrayList<>();
        this.f4464a = new f();
        this.f4458a = new Rect();
        this.f4478c = -1;
        this.f4460a = null;
        this.f4468a = null;
        this.f4455a = -3.4028235E38f;
        this.b = Float.MAX_VALUE;
        this.h = 1;
        this.l = -1;
        this.f4488i = true;
        this.f4469a = new c();
        this.t = 0;
        v();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f4481d != z) {
            this.f4481d = z;
        }
    }

    public static boolean w(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    public boolean A() {
        int i2 = this.f4472b;
        if (i2 <= 0) {
            return false;
        }
        N(i2 - 1, true);
        return true;
    }

    public boolean B() {
        ku kuVar = this.f4457a;
        if (kuVar == null || this.f4472b >= kuVar.c() - 1) {
            return false;
        }
        N(this.f4472b + 1, true);
        return true;
    }

    public final boolean C(int i2) {
        if (this.f4470a.size() == 0) {
            if (this.f4488i) {
                return false;
            }
            this.f4489j = false;
            y(0, 0.0f, 0);
            if (this.f4489j) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarT = t();
        int clientWidth = getClientWidth();
        int i3 = this.f4480d;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = fVarT.f4491a;
        float f3 = ((i2 / f2) - fVarT.b) / (fVarT.f8256a + (i3 / f2));
        this.f4489j = false;
        y(i5, f3, (int) (i4 * f3));
        if (this.f4489j) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean D(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.c - f2;
        this.c = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.f4455a * clientWidth;
        float f5 = this.b * clientWidth;
        boolean z3 = false;
        f fVar = this.f4470a.get(0);
        ArrayList<f> arrayList = this.f4470a;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f4491a != 0) {
            f4 = fVar.b * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.f4491a != this.f4457a.c() - 1) {
            f5 = fVar2.b * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.f4462a.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.f4473b.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.c += scrollX - i2;
        scrollTo(i2, getScrollY());
        C(i2);
        return z3;
    }

    public void E() {
        F(this.f4472b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00de A[PHI: r7 r10 r15
  0x00de: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v10 int) binds: [B:62:0x00dc, B:59:0x00ce, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v13 int) binds: [B:62:0x00dc, B:59:0x00ce, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00dc, B:59:0x00ce, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e7 A[PHI: r7 r10 r15
  0x00e7: PHI (r7v9 int) = (r7v5 int), (r7v4 int), (r7v10 int) binds: [B:62:0x00dc, B:59:0x00ce, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00e7: PHI (r10v12 int) = (r10v1 int), (r10v8 int), (r10v13 int) binds: [B:62:0x00dc, B:59:0x00ce, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
  0x00e7: PHI (r15v10 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00dc, B:59:0x00ce, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F(int r18) {
        /*
            Method dump skipped, instruction units count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.F(int):void");
    }

    public final void G(int i2, int i3, int i4, int i5) {
        int iMin;
        if (i3 <= 0 || this.f4470a.isEmpty()) {
            f fVarU = u(this.f4472b);
            iMin = (int) ((fVarU != null ? Math.min(fVarU.b, this.b) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
            if (iMin == getScrollX()) {
                return;
            } else {
                g(false);
            }
        } else if (!this.f4463a.isFinished()) {
            this.f4463a.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            iMin = (int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4));
        }
        scrollTo(iMin, getScrollY());
    }

    public final void H() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).f4495a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public void I(i iVar) {
        List<i> list = this.f4476b;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void J(j jVar) {
        List<j> list = this.f4471a;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public final void K(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final boolean L() {
        this.l = -1;
        o();
        this.f4462a.onRelease();
        this.f4473b.onRelease();
        return this.f4462a.isFinished() || this.f4473b.isFinished();
    }

    public final void M(int i2, boolean z, int i3, boolean z2) {
        f fVarU = u(i2);
        int clientWidth = fVarU != null ? (int) (getClientWidth() * Math.max(this.f4455a, Math.min(fVarU.b, this.b))) : 0;
        if (z) {
            Q(clientWidth, 0, i3);
            if (z2) {
                k(i2);
                return;
            }
            return;
        }
        if (z2) {
            k(i2);
        }
        g(false);
        scrollTo(clientWidth, 0);
        C(clientWidth);
    }

    public void N(int i2, boolean z) {
        this.f4483e = false;
        O(i2, z, false);
    }

    public void O(int i2, boolean z, boolean z2) {
        P(i2, z, z2, 0);
    }

    public void P(int i2, boolean z, boolean z2, int i3) {
        ku kuVar = this.f4457a;
        if (kuVar == null || kuVar.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f4472b == i2 && this.f4470a.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.f4457a.c()) {
            i2 = this.f4457a.c() - 1;
        }
        int i4 = this.h;
        int i5 = this.f4472b;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.f4470a.size(); i6++) {
                this.f4470a.get(i6).f4493a = true;
            }
        }
        boolean z3 = this.f4472b != i2;
        if (!this.f4488i) {
            F(i2);
            M(i2, z, i3, z3);
        } else {
            this.f4472b = i2;
            if (z3) {
                k(i2);
            }
            requestLayout();
        }
    }

    public void Q(int i2, int i3, int i4) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f4463a;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.f4477b ? this.f4463a.getCurrX() : this.f4463a.getStartX();
            this.f4463a.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            g(false);
            E();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fM = f3 + (m(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fM / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.f4457a.f(this.f4472b)) + this.f4480d)) + 1.0f) * 100.0f), 600);
        this.f4477b = false;
        this.f4463a.startScroll(i5, scrollY, i6, i7, iMin);
        eh.b0(this);
    }

    public final void R() {
        if (this.s != 0) {
            ArrayList<View> arrayList = this.f4475b;
            if (arrayList == null) {
                this.f4475b = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.f4475b.add(getChildAt(i2));
            }
            Collections.sort(this.f4475b, f4452a);
        }
    }

    public f a(int i2, int i3) {
        f fVar = new f();
        fVar.f4491a = i2;
        fVar.f4492a = this.f4457a.g(this, i2);
        fVar.f8256a = this.f4457a.f(i2);
        if (i3 < 0 || i3 >= this.f4470a.size()) {
            this.f4470a.add(fVar);
        } else {
            this.f4470a.add(i3, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        f fVarS;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.f4491a == this.f4472b) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f fVarS;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.f4491a == this.f4472b) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean zW = gVar.f4495a | w(view);
        gVar.f4495a = zW;
        if (!this.f4479c) {
            super.addView(view, i2, layoutParams);
        } else {
            if (gVar != null && zW) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.f4496b = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void b(i iVar) {
        if (this.f4476b == null) {
            this.f4476b = new ArrayList();
        }
        this.f4476b.add(iVar);
    }

    public void c(j jVar) {
        if (this.f4471a == null) {
            this.f4471a = new ArrayList();
        }
        this.f4471a.add(jVar);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.f4457a == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f4455a)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.b));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f4477b = true;
        if (this.f4463a.isFinished() || !this.f4463a.computeScrollOffset()) {
            g(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f4463a.getCurrX();
        int currY = this.f4463a.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!C(currX)) {
                this.f4463a.abortAnimation();
                scrollTo(0, currY);
            }
        }
        eh.b0(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(int r7) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.d(int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || p(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarS;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.f4491a == this.f4472b && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        ku kuVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (kuVar = this.f4457a) != null && kuVar.c() > 1)) {
            if (!this.f4462a.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f4455a * width);
                this.f4462a.setSize(height, width);
                zDraw = false | this.f4462a.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f4473b.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.b + 1.0f)) * width2);
                this.f4473b.setSize(height2, width2);
                zDraw |= this.f4473b.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f4462a.finish();
            this.f4473b.finish();
        }
        if (zDraw) {
            eh.b0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4459a;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int iC = this.f4457a.c();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.f4480d / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.f4491a;
            int i6 = fVar.f4491a;
            if (i5 < i6) {
                int i7 = 0;
                float f3 = fVar2.b + fVar2.f8256a + f2;
                while (true) {
                    i5++;
                    if (i5 > fVar.f4491a || i7 >= this.f4470a.size()) {
                        break;
                    }
                    while (true) {
                        fVar4 = this.f4470a.get(i7);
                        if (i5 <= fVar4.f4491a || i7 >= this.f4470a.size() - 1) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                    while (i5 < fVar4.f4491a) {
                        f3 += this.f4457a.f(i5) + f2;
                        i5++;
                    }
                    fVar4.b = f3;
                    f3 += fVar4.f8256a + f2;
                }
            } else if (i5 > i6) {
                int size = this.f4470a.size() - 1;
                float f4 = fVar2.b;
                while (true) {
                    i5--;
                    if (i5 < fVar.f4491a || size < 0) {
                        break;
                    }
                    while (true) {
                        fVar3 = this.f4470a.get(size);
                        if (i5 >= fVar3.f4491a || size <= 0) {
                            break;
                        } else {
                            size--;
                        }
                    }
                    while (i5 > fVar3.f4491a) {
                        f4 -= this.f4457a.f(i5) + f2;
                        i5--;
                    }
                    f4 -= fVar3.f8256a + f2;
                    fVar3.b = f4;
                }
            }
        }
        int size2 = this.f4470a.size();
        float f5 = fVar.b;
        int i8 = fVar.f4491a;
        int i9 = i8 - 1;
        this.f4455a = i8 == 0 ? f5 : -3.4028235E38f;
        int i10 = iC - 1;
        this.b = fVar.f4491a == i10 ? (fVar.b + fVar.f8256a) - 1.0f : Float.MAX_VALUE;
        int i11 = i2 - 1;
        while (i11 >= 0) {
            f fVar5 = this.f4470a.get(i11);
            while (true) {
                i4 = fVar5.f4491a;
                if (i9 <= i4) {
                    break;
                }
                f5 -= this.f4457a.f(i9) + f2;
                i9--;
            }
            f5 -= fVar5.f8256a + f2;
            fVar5.b = f5;
            if (i4 == 0) {
                this.f4455a = f5;
            }
            i11--;
            i9--;
        }
        float f6 = fVar.b + fVar.f8256a + f2;
        int i12 = fVar.f4491a + 1;
        int i13 = i2 + 1;
        while (i13 < size2) {
            f fVar6 = this.f4470a.get(i13);
            while (true) {
                i3 = fVar6.f4491a;
                if (i12 >= i3) {
                    break;
                }
                f6 += this.f4457a.f(i12) + f2;
                i12++;
            }
            if (i3 == i10) {
                this.b = (fVar6.f8256a + f6) - 1.0f;
            }
            fVar6.b = f6;
            f6 += fVar6.f8256a + f2;
            i13++;
            i12++;
        }
    }

    public boolean f(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && f(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    public final void g(boolean z) {
        boolean z2 = this.t == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f4463a.isFinished()) {
                this.f4463a.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f4463a.getCurrX();
                int currY = this.f4463a.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        C(currX);
                    }
                }
            }
        }
        this.f4483e = false;
        for (int i2 = 0; i2 < this.f4470a.size(); i2++) {
            f fVar = this.f4470a.get(i2);
            if (fVar.f4493a) {
                fVar.f4493a = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                eh.c0(this, this.f4469a);
            } else {
                this.f4469a.run();
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public ku getAdapter() {
        return this.f4457a;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.s == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) this.f4475b.get(i3).getLayoutParams()).c;
    }

    public int getCurrentItem() {
        return this.f4472b;
    }

    public int getOffscreenPageLimit() {
        return this.h;
    }

    public int getPageMargin() {
        return this.f4480d;
    }

    public void h() {
        int iC = this.f4457a.c();
        this.f4456a = iC;
        boolean z = this.f4470a.size() < (this.h * 2) + 1 && this.f4470a.size() < iC;
        int iMax = this.f4472b;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f4470a.size()) {
            f fVar = this.f4470a.get(i2);
            int iD = this.f4457a.d(fVar.f4492a);
            if (iD != -1) {
                if (iD == -2) {
                    this.f4470a.remove(i2);
                    i2--;
                    if (!z2) {
                        this.f4457a.o(this);
                        z2 = true;
                    }
                    this.f4457a.a(this, fVar.f4491a, fVar.f4492a);
                    int i3 = this.f4472b;
                    if (i3 == fVar.f4491a) {
                        iMax = Math.max(0, Math.min(i3, iC - 1));
                    }
                } else {
                    int i4 = fVar.f4491a;
                    if (i4 != iD) {
                        if (i4 == this.f4472b) {
                            iMax = iD;
                        }
                        fVar.f4491a = iD;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.f4457a.b(this);
        }
        Collections.sort(this.f4470a, f4453a);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                g gVar = (g) getChildAt(i5).getLayoutParams();
                if (!gVar.f4495a) {
                    gVar.f8257a = 0.0f;
                }
            }
            O(iMax, false, true);
            requestLayout();
        }
    }

    public final int i(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.o || Math.abs(i3) <= this.m) {
            i2 += (int) (f2 + (i2 >= this.f4472b ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f4470a.size() <= 0) {
            return i2;
        }
        return Math.max(this.f4470a.get(0).f4491a, Math.min(i2, this.f4470a.get(r4.size() - 1).f4491a));
    }

    public final void j(int i2, float f2, int i3) {
        j jVar = this.f4465a;
        if (jVar != null) {
            jVar.c(i2, f2, i3);
        }
        List<j> list = this.f4471a;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = this.f4471a.get(i4);
                if (jVar2 != null) {
                    jVar2.c(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.f4474b;
        if (jVar3 != null) {
            jVar3.c(i2, f2, i3);
        }
    }

    public final void k(int i2) {
        j jVar = this.f4465a;
        if (jVar != null) {
            jVar.b(i2);
        }
        List<j> list = this.f4471a;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.f4471a.get(i3);
                if (jVar2 != null) {
                    jVar2.b(i2);
                }
            }
        }
        j jVar3 = this.f4474b;
        if (jVar3 != null) {
            jVar3.b(i2);
        }
    }

    public final void l(int i2) {
        j jVar = this.f4465a;
        if (jVar != null) {
            jVar.a(i2);
        }
        List<j> list = this.f4471a;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.f4471a.get(i3);
                if (jVar2 != null) {
                    jVar2.a(i2);
                }
            }
        }
        j jVar3 = this.f4474b;
        if (jVar3 != null) {
            jVar3.a(i2);
        }
    }

    public float m(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public final void n(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.r : 0, null);
        }
    }

    public final void o() {
        this.f4485f = false;
        this.f4486g = false;
        VelocityTracker velocityTracker = this.f4461a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4461a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4488i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4469a);
        Scroller scroller = this.f4463a;
        if (scroller != null && !scroller.isFinished()) {
            this.f4463a.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.f4480d <= 0 || this.f4459a == null || this.f4470a.size() <= 0 || this.f4457a == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.f4480d / width;
        int i2 = 0;
        f fVar = this.f4470a.get(0);
        float f5 = fVar.b;
        int size = this.f4470a.size();
        int i3 = fVar.f4491a;
        int i4 = this.f4470a.get(size - 1).f4491a;
        while (i3 < i4) {
            while (i3 > fVar.f4491a && i2 < size) {
                i2++;
                fVar = this.f4470a.get(i2);
            }
            if (i3 == fVar.f4491a) {
                float f6 = fVar.b;
                float f7 = fVar.f8256a;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float f8 = this.f4457a.f(i3);
                f2 = (f5 + f8) * width;
                f5 += f8 + f4;
            }
            if (this.f4480d + f2 > scrollX) {
                f3 = f4;
                this.f4459a.setBounds(Math.round(f2), this.f4482e, Math.round(this.f4480d + f2), this.f4484f);
                this.f4459a.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i3++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            L();
            return false;
        }
        if (action != 0) {
            if (this.f4485f) {
                return true;
            }
            if (this.f4486g) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.e = x;
            this.c = x;
            float y = motionEvent.getY();
            this.f = y;
            this.d = y;
            this.l = motionEvent.getPointerId(0);
            this.f4486g = false;
            this.f4477b = true;
            this.f4463a.computeScrollOffset();
            if (this.t != 2 || Math.abs(this.f4463a.getFinalX() - this.f4463a.getCurrX()) <= this.p) {
                g(false);
                this.f4485f = false;
            } else {
                this.f4463a.abortAnimation();
                this.f4483e = false;
                E();
                this.f4485f = true;
                K(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.l;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.c;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.f);
                if (f2 != 0.0f && !x(this.c, f2) && f(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.c = x2;
                    this.d = y2;
                    this.f4486g = true;
                    return false;
                }
                if (fAbs > this.k && fAbs * 0.5f > fAbs2) {
                    this.f4485f = true;
                    K(true);
                    setScrollState(1);
                    float f3 = this.e;
                    float f4 = this.k;
                    this.c = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.d = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > this.k) {
                    this.f4486g = true;
                }
                if (this.f4485f && D(x2)) {
                    eh.b0(this);
                }
            }
        } else if (action == 6) {
            z(motionEvent);
        }
        if (this.f4461a == null) {
            this.f4461a = VelocityTracker.obtain();
        }
        this.f4461a.addMovement(motionEvent);
        return this.f4485f;
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
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        g gVar;
        g gVar2;
        int i4;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.j = Math.min(measuredWidth / 10, this.i);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z = true;
            int i6 = 1073741824;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (gVar2 = (g) childAt.getLayoutParams()) != null && gVar2.f4495a) {
                int i7 = gVar2.f4494a;
                int i8 = i7 & 7;
                int i9 = i7 & 112;
                boolean z2 = i9 == 48 || i9 == 80;
                if (i8 != 3 && i8 != 5) {
                    z = false;
                }
                int i10 = Integer.MIN_VALUE;
                if (z2) {
                    i4 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i4 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i11 = ((ViewGroup.LayoutParams) gVar2).width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i10 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = ((ViewGroup.LayoutParams) gVar2).height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i4;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.g = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f4479c = true;
        E();
        this.f4479c = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.f4495a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * gVar.f8257a), 1073741824), this.g);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        f fVarS;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.f4491a == this.f4472b && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof m)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        m mVar = (m) parcelable;
        super.onRestoreInstanceState(mVar.q());
        ku kuVar = this.f4457a;
        if (kuVar != null) {
            kuVar.k(mVar.b, mVar.f4497a);
            O(mVar.f8260a, false, true);
        } else {
            this.f4478c = mVar.f8260a;
            this.f4460a = mVar.b;
            this.f4468a = mVar.f4497a;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        m mVar = new m(super.onSaveInstanceState());
        mVar.f8260a = this.f4472b;
        ku kuVar = this.f4457a;
        if (kuVar != null) {
            mVar.b = kuVar.l();
        }
        return mVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.f4480d;
            G(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean p(KeyEvent keyEvent) {
        int i2;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return d(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return d(1);
                        }
                    }
                } else {
                    if (keyEvent.hasModifiers(2)) {
                        return B();
                    }
                    i2 = 66;
                }
            } else {
                if (keyEvent.hasModifiers(2)) {
                    return A();
                }
                i2 = 17;
            }
            return d(i2);
        }
        return false;
    }

    public final Rect q(Rect rect, View view) {
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

    public f r(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return s(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f4479c) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public f s(View view) {
        for (int i2 = 0; i2 < this.f4470a.size(); i2++) {
            f fVar = this.f4470a.get(i2);
            if (this.f4457a.h(view, fVar.f4492a)) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(ku kuVar) {
        ku kuVar2 = this.f4457a;
        if (kuVar2 != null) {
            kuVar2.n(null);
            this.f4457a.o(this);
            for (int i2 = 0; i2 < this.f4470a.size(); i2++) {
                f fVar = this.f4470a.get(i2);
                this.f4457a.a(this, fVar.f4491a, fVar.f4492a);
            }
            this.f4457a.b(this);
            this.f4470a.clear();
            H();
            this.f4472b = 0;
            scrollTo(0, 0);
        }
        ku kuVar3 = this.f4457a;
        this.f4457a = kuVar;
        this.f4456a = 0;
        if (kuVar != null) {
            if (this.f4467a == null) {
                this.f4467a = new l();
            }
            this.f4457a.n(this.f4467a);
            this.f4483e = false;
            boolean z = this.f4488i;
            this.f4488i = true;
            this.f4456a = this.f4457a.c();
            if (this.f4478c >= 0) {
                this.f4457a.k(this.f4460a, this.f4468a);
                O(this.f4478c, false, true);
                this.f4478c = -1;
                this.f4460a = null;
                this.f4468a = null;
            } else if (z) {
                requestLayout();
            } else {
                E();
            }
        }
        List<i> list = this.f4476b;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f4476b.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f4476b.get(i3).a(this, kuVar3, kuVar);
        }
    }

    public void setCurrentItem(int i2) {
        this.f4483e = false;
        O(i2, !this.f4488i, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.h) {
            this.h = i2;
            E();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.f4465a = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.f4480d;
        this.f4480d = i2;
        int width = getWidth();
        G(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(yb.d(getContext(), i2));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f4459a = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.t == i2) {
            return;
        }
        this.t = i2;
        if (this.f4466a != null) {
            n(i2 != 0);
        }
        l(i2);
    }

    public final f t() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.f4480d / clientWidth : 0.0f;
        f fVar = null;
        int i3 = 0;
        int i4 = -1;
        boolean z = true;
        float f4 = 0.0f;
        while (i3 < this.f4470a.size()) {
            f fVar2 = this.f4470a.get(i3);
            if (!z && fVar2.f4491a != (i2 = i4 + 1)) {
                fVar2 = this.f4464a;
                fVar2.b = f2 + f4 + f3;
                fVar2.f4491a = i2;
                fVar2.f8256a = this.f4457a.f(i2);
                i3--;
            }
            f2 = fVar2.b;
            float f5 = fVar2.f8256a + f2 + f3;
            if (!z && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f5 || i3 == this.f4470a.size() - 1) {
                return fVar2;
            }
            i4 = fVar2.f4491a;
            f4 = fVar2.f8256a;
            i3++;
            z = false;
            fVar = fVar2;
        }
        return fVar;
    }

    public f u(int i2) {
        for (int i3 = 0; i3 < this.f4470a.size(); i3++) {
            f fVar = this.f4470a.get(i3);
            if (fVar.f4491a == i2) {
                return fVar;
            }
        }
        return null;
    }

    public void v() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f4463a = new Scroller(context, f8253a);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.k = viewConfiguration.getScaledPagingTouchSlop();
        this.m = (int) (400.0f * f2);
        this.n = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4462a = new EdgeEffect(context);
        this.f4473b = new EdgeEffect(context);
        this.o = (int) (25.0f * f2);
        this.p = (int) (2.0f * f2);
        this.i = (int) (f2 * 16.0f);
        eh.k0(this, new h());
        if (eh.w(this) == 0) {
            eh.t0(this, 1);
        }
        eh.v0(this, new d());
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4459a;
    }

    public final boolean x(float f2, float f3) {
        return (f2 < ((float) this.j) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.j)) && f3 < 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.q
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r9 = (androidx.viewpager.widget.ViewPager.g) r9
            boolean r10 = r9.f4495a
            if (r10 != 0) goto L2c
            goto L68
        L2c:
            int r9 = r9.f4494a
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
            r12.j(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$k r13 = r12.f4466a
            if (r13 == 0) goto L9f
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7a:
            if (r1 >= r14) goto L9f
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$g r0 = (androidx.viewpager.widget.ViewPager.g) r0
            boolean r0 = r0.f4495a
            if (r0 == 0) goto L8b
            goto L9c
        L8b:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$k r3 = r12.f4466a
            r3.a(r15, r0)
        L9c:
            int r1 = r1 + 1
            goto L7a
        L9f:
            r12.f4489j = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.y(int, float, int):void");
    }

    public final void z(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.l) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.c = motionEvent.getX(i2);
            this.l = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f4461a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }
}
