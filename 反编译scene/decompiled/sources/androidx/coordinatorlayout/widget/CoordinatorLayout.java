package androidx.coordinatorlayout.widget;

import a.ak;
import a.bg;
import a.eh;
import a.jg;
import a.ka;
import a.kd;
import a.kf;
import a.kg;
import a.la;
import a.ma;
import a.mf;
import a.mg;
import a.na;
import a.ng;
import a.oa;
import a.of;
import a.pa;
import a.sh;
import a.yb;
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
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class CoordinatorLayout extends ViewGroup implements jg, kg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mf<Rect> f8183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f4145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ThreadLocal<Map<String, Constructor<c>>> f4146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Comparator<View> f4147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?>[] f4148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mg f4149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ng f4150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final oa<View> f4151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sh f4152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup.OnHierarchyChangeListener f4156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f4157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<View> f4158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f4159a;
    public View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<View> f4160b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4161b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f4162b;
    public final List<View> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4163c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int[] f4164c;
    public boolean d;
    public boolean e;

    public class a implements ng {
        public a() {
        }

        @Override // a.ng
        public sh a(View view, sh shVar) {
            CoordinatorLayout.this.W(shVar);
            return shVar;
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return z(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        @Deprecated
        public void B(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void C(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                B(coordinatorLayout, v, view);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return d(coordinatorLayout, v) > 0.0f;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public sh f(CoordinatorLayout coordinatorLayout, V v, sh shVar) {
            return shVar;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                p(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void s(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                r(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            s(coordinatorLayout, v, view, i, i2, i3, i4, i5);
        }

        @Deprecated
        public void u(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void v(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                u(coordinatorLayout, v, view, view2, i);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4156a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.H(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f4156a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8186a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Rect f4165a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public View f4166a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public c f4167a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4168a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public View f4169b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4170b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f4171c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f4172d;
        public int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public boolean f4173e;
        public int f;
        public int g;
        public int h;

        public f(int i, int i2) {
            super(i, i2);
            this.f4168a = false;
            this.f8186a = 0;
            this.b = 0;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = 0;
            this.f4165a = new Rect();
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4168a = false;
            this.f8186a = 0;
            this.b = 0;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = 0;
            this.f4165a = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ma.CoordinatorLayout_Layout);
            this.f8186a = typedArrayObtainStyledAttributes.getInteger(ma.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.d = typedArrayObtainStyledAttributes.getResourceId(ma.CoordinatorLayout_Layout_layout_anchor, -1);
            this.b = typedArrayObtainStyledAttributes.getInteger(ma.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.c = typedArrayObtainStyledAttributes.getInteger(ma.CoordinatorLayout_Layout_layout_keyline, -1);
            this.e = typedArrayObtainStyledAttributes.getInt(ma.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f = typedArrayObtainStyledAttributes.getInt(ma.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(ma.CoordinatorLayout_Layout_layout_behavior);
            this.f4168a = zHasValue;
            if (zHasValue) {
                this.f4167a = CoordinatorLayout.K(context, attributeSet, typedArrayObtainStyledAttributes.getString(ma.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f4167a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4168a = false;
            this.f8186a = 0;
            this.b = 0;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = 0;
            this.f4165a = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4168a = false;
            this.f8186a = 0;
            this.b = 0;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = 0;
            this.f4165a = new Rect();
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f4168a = false;
            this.f8186a = 0;
            this.b = 0;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = 0;
            this.f4165a = new Rect();
        }

        public boolean a() {
            return this.f4166a == null && this.d != -1;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.f4169b || s(view2, eh.y(coordinatorLayout)) || ((cVar = this.f4167a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        public boolean c() {
            if (this.f4167a == null) {
                this.f4170b = false;
            }
            return this.f4170b;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.d == -1) {
                this.f4169b = null;
                this.f4166a = null;
                return null;
            }
            if (this.f4166a == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f4166a;
        }

        public int e() {
            return this.d;
        }

        public c f() {
            return this.f4167a;
        }

        public boolean g() {
            return this.f4173e;
        }

        public Rect h() {
            return this.f4165a;
        }

        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.f4170b;
            if (z) {
                return true;
            }
            c cVar = this.f4167a;
            boolean zA = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z;
            this.f4170b = zA;
            return zA;
        }

        public boolean j(int i) {
            if (i == 0) {
                return this.f4171c;
            }
            if (i != 1) {
                return false;
            }
            return this.f4172d;
        }

        public void k() {
            this.f4173e = false;
        }

        public void l(int i) {
            r(i, false);
        }

        public void m() {
            this.f4170b = false;
        }

        public final void n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.d);
            this.f4166a = viewFindViewById;
            if (viewFindViewById != null) {
                if (viewFindViewById != coordinatorLayout) {
                    for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                viewFindViewById = parent;
                            }
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f4169b = viewFindViewById;
                    return;
                }
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.d) + " to anchor view " + view);
            }
            this.f4169b = null;
            this.f4166a = null;
        }

        public void o(c cVar) {
            c cVar2 = this.f4167a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.f4167a = cVar;
                this.f4168a = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        public void p(boolean z) {
            this.f4173e = z;
        }

        public void q(Rect rect) {
            this.f4165a.set(rect);
        }

        public void r(int i, boolean z) {
            if (i == 0) {
                this.f4171c = z;
            } else {
                if (i != 1) {
                    return;
                }
                this.f4172d = z;
            }
        }

        public final boolean s(View view, int i) {
            int iB = bg.b(((f) view.getLayoutParams()).e, i);
            return iB != 0 && (bg.b(this.f, i) & iB) == iB;
        }

        public final boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f4166a.getId() != this.d) {
                return false;
            }
            View view2 = this.f4166a;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f4169b = null;
                    this.f4166a = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f4169b = view2;
            return true;
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.H(0);
            return true;
        }
    }

    public static class h extends ak {
        public static final Parcelable.Creator<h> CREATOR = new na();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray<Parcelable> f8188a;

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f8188a = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f8188a.append(iArr[i2], parcelableArray[i2]);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f8188a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f8188a.keyAt(i2);
                parcelableArr[i2] = this.f8188a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fK = eh.K(view);
            float fK2 = eh.K(view2);
            if (fK > fK2) {
                return -1;
            }
            return fK < fK2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f4145a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f4147a = new i();
        } else {
            f4147a = null;
        }
        f4148a = new Class[]{Context.class, AttributeSet.class};
        f4146a = new ThreadLocal<>();
        f8183a = new of(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ka.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4158a = new ArrayList();
        this.f4151a = new oa<>();
        this.f4160b = new ArrayList();
        this.c = new ArrayList();
        this.f4159a = new int[2];
        this.f4162b = new int[2];
        this.f4149a = new mg(this);
        int[] iArr = ma.CoordinatorLayout;
        TypedArray typedArrayObtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, la.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            int[] iArr2 = ma.CoordinatorLayout;
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes, 0, la.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(ma.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f4164c = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.f4164c.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.f4164c[i3] = (int) (r12[i3] * f2);
            }
        }
        this.f4154a = typedArrayObtainStyledAttributes.getDrawable(ma.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        X();
        super.setOnHierarchyChangeListener(new e());
        if (eh.w(this) == 0) {
            eh.t0(this, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c K(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f4145a)) {
            str = f4145a + '.' + str;
        }
        try {
            Map<String, Constructor<c>> map = f4146a.get();
            if (map == null) {
                map = new HashMap<>();
                f4146a.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f4148a);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    public static void O(Rect rect) {
        rect.setEmpty();
        f8183a.b(rect);
    }

    public static int R(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    public static int S(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    public static int T(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    public static Rect a() {
        Rect rectA = f8183a.a();
        return rectA == null ? new Rect() : rectA;
    }

    public static int c(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public final boolean A(View view) {
        return this.f4151a.j(view);
    }

    public boolean B(View view, int i2, int i3) {
        Rect rectA = a();
        t(view, rectA);
        try {
            return rectA.contains(i2, i3);
        } finally {
            O(rectA);
        }
    }

    public final void C(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        Rect rectA = a();
        rectA.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f4152a != null && eh.v(this) && !eh.v(view)) {
            rectA.left += this.f4152a.g();
            rectA.top += this.f4152a.i();
            rectA.right -= this.f4152a.h();
            rectA.bottom -= this.f4152a.f();
        }
        Rect rectA2 = a();
        bg.a(S(fVar.f8186a), view.getMeasuredWidth(), view.getMeasuredHeight(), rectA, rectA2, i2);
        view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        O(rectA);
        O(rectA2);
    }

    public final void D(View view, View view2, int i2) {
        Rect rectA = a();
        Rect rectA2 = a();
        try {
            t(view2, rectA);
            u(view, i2, rectA, rectA2);
            view.layout(rectA2.left, rectA2.top, rectA2.right, rectA2.bottom);
        } finally {
            O(rectA);
            O(rectA2);
        }
    }

    public final void E(View view, int i2, int i3) {
        f fVar = (f) view.getLayoutParams();
        int iB = bg.b(T(fVar.f8186a), i3);
        int i4 = iB & 7;
        int i5 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int iW = w(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            iW += measuredWidth / 2;
        } else if (i4 == 5) {
            iW += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(iW, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    public final void F(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (eh.Q(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            Rect rectA = a();
            Rect rectA2 = a();
            rectA2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (cVarF == null || !cVarF.b(this, view, rectA)) {
                rectA.set(rectA2);
            } else if (!rectA2.contains(rectA)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectA.toShortString() + " | Bounds:" + rectA2.toShortString());
            }
            O(rectA2);
            if (rectA.isEmpty()) {
                O(rectA);
                return;
            }
            int iB = bg.b(fVar.f, i2);
            boolean z3 = true;
            if ((iB & 48) != 48 || (i7 = (rectA.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.h) >= (i8 = rect.top)) {
                z = false;
            } else {
                V(view, i8 - i7);
                z = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectA.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.h) < (i6 = rect.bottom)) {
                V(view, height - i6);
                z = true;
            }
            if (!z) {
                V(view, 0);
            }
            if ((iB & 3) != 3 || (i4 = (rectA.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.g) >= (i5 = rect.left)) {
                z2 = false;
            } else {
                U(view, i5 - i4);
                z2 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectA.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.g) >= (i3 = rect.right)) {
                z3 = z2;
            } else {
                U(view, width - i3);
            }
            if (!z3) {
                U(view, 0);
            }
            O(rectA);
        }
    }

    public void G(View view, int i2) {
        c cVarF;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f4166a != null) {
            Rect rectA = a();
            Rect rectA2 = a();
            Rect rectA3 = a();
            t(fVar.f4166a, rectA);
            q(view, false, rectA2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            v(view, i2, rectA, rectA3, fVar, measuredWidth, measuredHeight);
            boolean z = (rectA3.left == rectA2.left && rectA3.top == rectA2.top) ? false : true;
            d(fVar, rectA3, measuredWidth, measuredHeight);
            int i3 = rectA3.left - rectA2.left;
            int i4 = rectA3.top - rectA2.top;
            if (i3 != 0) {
                eh.V(view, i3);
            }
            if (i4 != 0) {
                eh.W(view, i4);
            }
            if (z && (cVarF = fVar.f()) != null) {
                cVarF.h(this, view, fVar.f4166a);
            }
            O(rectA);
            O(rectA2);
            O(rectA3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(int r18) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.H(int):void");
    }

    public void I(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f4166a;
        if (view2 != null) {
            D(view, view2, i2);
            return;
        }
        int i3 = fVar.c;
        if (i3 >= 0) {
            E(view, i3, i2);
        } else {
            C(view, i2);
        }
    }

    public void J(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public final boolean L(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f4160b;
        z(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            if (!(zK || z) || actionMasked == 0) {
                if (!zK && cVarF != null) {
                    if (i2 == 0) {
                        zK = cVarF.k(this, view, motionEvent);
                    } else if (i2 == 1) {
                        zK = cVarF.D(this, view, motionEvent);
                    }
                    if (zK) {
                        this.f4155a = view;
                    }
                }
                boolean zC = fVar.c();
                boolean zI = fVar.i(this, view);
                z = zI && !zC;
                if (zI && !z) {
                    break;
                }
            } else if (cVarF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    cVarF.k(this, view, motionEventObtain);
                } else if (i2 == 1) {
                    cVarF.D(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zK;
    }

    public final void M() {
        this.f4158a.clear();
        this.f4151a.c();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f fVarY = y(childAt);
            fVarY.d(this, childAt);
            this.f4151a.b(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (fVarY.b(this, childAt, childAt2)) {
                        if (!this.f4151a.d(childAt2)) {
                            this.f4151a.b(childAt2);
                        }
                        this.f4151a.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f4158a.addAll(this.f4151a.i());
        Collections.reverse(this.f4158a);
    }

    public void N(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    public void P() {
        if (this.f4163c && this.f4157a != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4157a);
        }
        this.d = false;
    }

    public final void Q(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (cVarF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    cVarF.k(this, childAt, motionEventObtain);
                } else {
                    cVarF.D(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).m();
        }
        this.f4155a = null;
        this.f4161b = false;
    }

    public final void U(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.g;
        if (i3 != i2) {
            eh.V(view, i2 - i3);
            fVar.g = i2;
        }
    }

    public final void V(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.h;
        if (i3 != i2) {
            eh.W(view, i2 - i3);
            fVar.h = i2;
        }
    }

    public final sh W(sh shVar) {
        if (!kf.a(this.f4152a, shVar)) {
            this.f4152a = shVar;
            boolean z = shVar != null && shVar.i() > 0;
            this.e = z;
            setWillNotDraw(!z && getBackground() == null);
            e(shVar);
            requestLayout();
        }
        return shVar;
    }

    public final void X() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!eh.v(this)) {
            eh.v0(this, null);
            return;
        }
        if (this.f4150a == null) {
            this.f4150a = new a();
        }
        eh.v0(this, this.f4150a);
        setSystemUiVisibility(1280);
    }

    public void b() {
        if (this.f4163c) {
            if (this.f4157a == null) {
                this.f4157a = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4157a);
        }
        this.d = true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public final void d(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i2 + iMax, i3 + iMax2);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f4167a;
        if (cVar != null) {
            float fD = cVar.d(this, view);
            if (fD > 0.0f) {
                if (this.f4153a == null) {
                    this.f4153a = new Paint();
                }
                this.f4153a.setColor(fVar.f4167a.c(this, view));
                this.f4153a.setAlpha(c(Math.round(fD * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f4153a);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4154a;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    public final sh e(sh shVar) {
        c cVarF;
        if (shVar.l()) {
            return shVar;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (eh.v(childAt) && (cVarF = ((f) childAt.getLayoutParams()).f()) != null) {
                cVarF.f(this, childAt, shVar);
                if (shVar.l()) {
                    break;
                }
            }
        }
        return shVar;
    }

    public void f(View view) {
        List listG = this.f4151a.g(view);
        if (listG == null || listG.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < listG.size(); i2++) {
            View view2 = (View) listG.get(i2);
            c cVarF = ((f) view2.getLayoutParams()).f();
            if (cVarF != null) {
                cVarF.h(this, view2, view);
            }
        }
    }

    public void g() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            if (A(getChildAt(i2))) {
                z = true;
                break;
            }
            i2++;
        }
        if (z != this.d) {
            if (z) {
                b();
            } else {
                P();
            }
        }
    }

    public final List<View> getDependencySortedChildren() {
        M();
        return Collections.unmodifiableList(this.f4158a);
    }

    public final sh getLastWindowInsets() {
        return this.f4152a;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f4149a.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f4154a;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // a.jg
    public boolean h(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVarF = fVar.f();
                if (cVarF != null) {
                    boolean zA = cVarF.A(this, childAt, view, view2, i2, i3);
                    z |= zA;
                    fVar.r(i3, zA);
                } else {
                    fVar.r(i3, false);
                }
            }
        }
        return z;
    }

    @Override // a.jg
    public void i(View view, int i2, int i3, int[] iArr, int i4) {
        c cVarF;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i4) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f4159a;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.q(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f4159a;
                    iMax = i2 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    int[] iArr4 = this.f4159a;
                    iMax2 = i3 > 0 ? Math.max(iMax2, iArr4[1]) : Math.min(iMax2, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            H(1);
        }
    }

    @Override // a.jg
    public void j(View view, View view2, int i2, int i3) {
        c cVarF;
        this.f4149a.c(view, view2, i2, i3);
        this.b = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i3) && (cVarF = fVar.f()) != null) {
                cVarF.v(this, childAt, view, view2, i2, i3);
            }
        }
    }

    @Override // a.jg
    public void k(View view, int i2, int i3, int i4, int i5, int i6) {
        m(view, i2, i3, i4, i5, 0, this.f4162b);
    }

    @Override // a.jg
    public void l(View view, int i2) {
        this.f4149a.d(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i2)) {
                c cVarF = fVar.f();
                if (cVarF != null) {
                    cVarF.C(this, childAt, view, i2);
                }
                fVar.l(i2);
                fVar.k();
            }
        }
        this.b = null;
    }

    @Override // a.kg
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c cVarF;
        boolean z;
        int iMin;
        int childCount = getChildCount();
        boolean z2 = false;
        int iMax = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i6) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f4159a;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.t(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.f4159a;
                    iMax = i4 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    if (i5 > 0) {
                        z = true;
                        iMin = Math.max(i7, this.f4159a[1]);
                    } else {
                        z = true;
                        iMin = Math.min(i7, this.f4159a[1]);
                    }
                    i7 = iMin;
                    z2 = z;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + i7;
        if (z2) {
            H(1);
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q(false);
        if (this.d) {
            if (this.f4157a == null) {
                this.f4157a = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f4157a);
        }
        if (this.f4152a == null && eh.v(this)) {
            eh.h0(this);
        }
        this.f4163c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q(false);
        if (this.d && this.f4157a != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f4157a);
        }
        View view = this.b;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f4163c = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.e || this.f4154a == null) {
            return;
        }
        sh shVar = this.f4152a;
        int i2 = shVar != null ? shVar.i() : 0;
        if (i2 > 0) {
            this.f4154a.setBounds(0, 0, getWidth(), i2);
            this.f4154a.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q(true);
        }
        boolean zL = L(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            Q(true);
        }
        return zL;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c cVarF;
        int iY = eh.y(this);
        int size = this.f4158a.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f4158a.get(i6);
            if (view.getVisibility() != 8 && ((cVarF = ((f) view.getLayoutParams()).f()) == null || !cVarF.l(this, view, iY))) {
                I(view, iY);
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

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        c cVarF;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (cVarF = fVar.f()) != null) {
                    zN |= cVarF.n(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (zN) {
            H(1);
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onNestedPreFling(View view, float f2, float f3) {
        c cVarF;
        int childCount = getChildCount();
        boolean zO = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (cVarF = fVar.f()) != null) {
                    zO |= cVarF.o(this, childAt, view, f2, f3);
                }
            }
        }
        return zO;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        i(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        k(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        j(view, view2, i2, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.q());
        SparseArray<Parcelable> sparseArray = hVar.f8188a;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVarF = y(childAt).f();
            if (id != -1 && cVarF != null && (parcelable2 = sparseArray.get(id)) != null) {
                cVarF.x(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableY;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && cVarF != null && (parcelableY = cVarF.y(this, childAt)) != null) {
                sparseArray.append(id, parcelableY);
            }
        }
        hVar.f8188a = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return h(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onStopNestedScroll(View view) {
        l(view, 0);
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
            android.view.View r3 = r0.f4155a
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.L(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = r5
        L16:
            android.view.View r6 = r0.f4155a
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.f4155a
            boolean r6 = r6.D(r0, r7, r1)
            goto L2c
        L2b:
            r6 = r5
        L2c:
            android.view.View r7 = r0.f4155a
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
            r0.Q(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public void q(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            t(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> r(View view) {
        List<View> listH = this.f4151a.h(view);
        this.c.clear();
        if (listH != null) {
            this.c.addAll(listH);
        }
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        c cVarF = ((f) view.getLayoutParams()).f();
        if (cVarF == null || !cVarF.w(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.f4161b) {
            return;
        }
        Q(false);
        this.f4161b = true;
    }

    public List<View> s(View view) {
        List listG = this.f4151a.g(view);
        this.c.clear();
        if (listG != null) {
            this.c.addAll(listG);
        }
        return this.c;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        X();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f4156a = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f4154a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f4154a = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f4154a.setState(getDrawableState());
                }
                kd.m(this.f4154a, eh.y(this));
                this.f4154a.setVisible(getVisibility() == 0, false);
                this.f4154a.setCallback(this);
            }
            eh.b0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? yb.d(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f4154a;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.f4154a.setVisible(z, false);
    }

    public void t(View view, Rect rect) {
        pa.a(this, view, rect);
    }

    public void u(View view, int i2, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        v(view, i2, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    public final void v(View view, int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int iB = bg.b(R(fVar.f8186a), i2);
        int iB2 = bg.b(S(fVar.b), i2);
        int i5 = iB & 7;
        int i6 = iB & 112;
        int i7 = iB2 & 7;
        int i8 = iB2 & 112;
        int iWidth = i7 != 1 ? i7 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i8 != 16 ? i8 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i5 == 1) {
            iWidth -= i3 / 2;
        } else if (i5 != 5) {
            iWidth -= i3;
        }
        if (i6 == 16) {
            iHeight -= i4 / 2;
        } else if (i6 != 80) {
            iHeight -= i4;
        }
        rect2.set(iWidth, iHeight, i3 + iWidth, i4 + iHeight);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4154a;
    }

    public final int w(int i2) {
        StringBuilder sb;
        int[] iArr = this.f4164c;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i2);
        } else {
            if (i2 >= 0 && i2 < iArr.length) {
                return iArr[i2];
            }
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i2);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    public void x(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f y(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f4168a) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
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
                        fVar.o(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
            }
            fVar.f4168a = true;
        }
        return fVar;
    }

    public final void z(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = f4147a;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }
}
