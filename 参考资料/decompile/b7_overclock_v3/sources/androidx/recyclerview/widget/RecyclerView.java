package androidx.recyclerview.widget;

import a1.d;
import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.RestrictTo;
import androidx.core.view.q0;
import androidx.core.view.u0;
import androidx.core.view.w0;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g0;
import androidx.recyclerview.widget.h0;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.y;
import com.blankj.utilcode.util.i0;
import com.umeng.socialize.common.SocializeConstants;
import g.i1;
import g.n0;
import g.p0;
import g.t0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclerView extends ViewGroup implements q0, androidx.core.view.c0, androidx.core.view.d0 {
    public static final int A8 = -1;
    public static final long B8 = -1;
    public static final int C8 = -1;
    public static final int D8 = 0;
    public static final int E8 = 1;
    public static final int F8 = Integer.MIN_VALUE;
    public static final int G8 = 2000;
    public static final String H8 = "RV Scroll";
    public static final String I8 = "RV OnLayout";
    public static final String J8 = "RV FullInvalidate";
    public static final String K8 = "RV PartialInvalidate";
    public static final String L8 = "RV OnBindView";
    public static final String M8 = "RV Prefetch";
    public static final String N8 = "RV Nested Prefetch";
    public static final String O8 = "RV CreateView";
    public static final Class<?>[] P8;
    public static final int Q8 = -1;
    public static final int R8 = 0;
    public static final int S8 = 1;
    public static final int T8 = 2;
    public static final long U8 = Long.MAX_VALUE;
    public static final Interpolator V8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public static final String f6585m8 = "RecyclerView";

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public static final boolean f6586n8 = false;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public static final boolean f6587o8 = false;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public static final int[] f6588p8 = {R.attr.nestedScrollingEnabled};

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public static final boolean f6589q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public static final boolean f6590r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final boolean f6591s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final boolean f6592t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final boolean f6593u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final boolean f6594v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static final boolean f6595w8 = false;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public static final int f6596x8 = 0;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final int f6597y8 = 1;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public static final int f6598z8 = 1;
    public boolean A;
    public final AccessibilityManager B;
    public List<q> C;
    public EdgeEffect C1;
    public EdgeEffect C2;
    public boolean D;
    public int E7;
    public int F7;
    public VelocityTracker G7;
    public int H7;
    public int I7;
    public int J7;
    public int K0;
    public EdgeEffect K1;
    public l K2;
    public int K7;
    public int L7;
    public r M7;
    public final int N7;
    public final int O7;
    public float P7;
    public float Q7;
    public boolean R7;
    public final d0 S7;
    public androidx.recyclerview.widget.l T7;
    public l.b U7;
    public final b0 V7;
    public t W7;
    public List<t> X7;
    public boolean Y7;
    public boolean Z7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f6599a;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public l.c f6600a8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f6601b;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public boolean f6602b8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SavedState f6603c;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public androidx.recyclerview.widget.y f6604c8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.recyclerview.widget.a f6605d;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public j f6606d8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.recyclerview.widget.g f6607e;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public final int[] f6608e8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f6609f;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public androidx.core.view.f0 f6610f8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6611g;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public final int[] f6612g8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f6613h;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public final int[] f6614h8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f6615i;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public final int[] f6616i8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f6617j;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    @i1
    public final List<e0> f6618j8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f6619k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f6620k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f6621k1;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public Runnable f6622k8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f6623l;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public final h0.b f6624l8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @i1
    public o f6625m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public x f6626n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<n> f6627o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<s> f6628p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public s f6629q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6630r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6631s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6632t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @i1
    public boolean f6633u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6634v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    @n0
    public k f6635v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public EdgeEffect f6636v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6637w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6638x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6639y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6640z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f6633u || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f6630r) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f6638x) {
                recyclerView2.f6637w = true;
            } else {
                recyclerView2.E();
            }
        }
    }

    public static abstract class a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f6644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f6645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6647e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f6648f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f6650h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6643a = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f6649g = new a(0, 0);

        public static class a {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f6651h = Integer.MIN_VALUE;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6652a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f6653b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f6654c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f6655d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Interpolator f6656e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f6657f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f6658g;

            public a(@t0 int i10, @t0 int i11) {
                this(i10, i11, Integer.MIN_VALUE, null);
            }

            public int a() {
                return this.f6654c;
            }

            @t0
            public int b() {
                return this.f6652a;
            }

            @t0
            public int c() {
                return this.f6653b;
            }

            @p0
            public Interpolator d() {
                return this.f6656e;
            }

            public boolean e() {
                return this.f6655d >= 0;
            }

            public void f(int i10) {
                this.f6655d = i10;
            }

            public void g(RecyclerView recyclerView) {
                int i10 = this.f6655d;
                if (i10 >= 0) {
                    this.f6655d = -1;
                    recyclerView.Q0(i10);
                    this.f6657f = false;
                } else {
                    if (!this.f6657f) {
                        this.f6658g = 0;
                        return;
                    }
                    m();
                    recyclerView.S7.f(this.f6652a, this.f6653b, this.f6654c, this.f6656e);
                    this.f6658g++;
                    this.f6657f = false;
                }
            }

            public void h(int i10) {
                this.f6657f = true;
                this.f6654c = i10;
            }

            public void i(@t0 int i10) {
                this.f6657f = true;
                this.f6652a = i10;
            }

            public void j(@t0 int i10) {
                this.f6657f = true;
                this.f6653b = i10;
            }

            public void k(@p0 Interpolator interpolator) {
                this.f6657f = true;
                this.f6656e = interpolator;
            }

            public void l(@t0 int i10, @t0 int i11, int i12, @p0 Interpolator interpolator) {
                this.f6652a = i10;
                this.f6653b = i11;
                this.f6654c = i12;
                this.f6656e = interpolator;
                this.f6657f = true;
            }

            public final void m() {
                if (this.f6656e != null && this.f6654c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f6654c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public a(@t0 int i10, @t0 int i11, int i12) {
                this(i10, i11, i12, null);
            }

            public a(@t0 int i10, @t0 int i11, int i12, @p0 Interpolator interpolator) {
                this.f6655d = -1;
                this.f6657f = false;
                this.f6658g = 0;
                this.f6652a = i10;
                this.f6653b = i11;
                this.f6654c = i12;
                this.f6656e = interpolator;
            }
        }

        public interface b {
            @p0
            PointF a(int i10);
        }

        @p0
        public PointF a(int i10) {
            Object objE = e();
            if (objE instanceof b) {
                return ((b) objE).a(i10);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            sb2.append(b.class.getCanonicalName());
            return null;
        }

        public View b(int i10) {
            return this.f6644b.f6625m.R(i10);
        }

        public int c() {
            return this.f6644b.f6625m.Y();
        }

        public int d(View view) {
            return this.f6644b.r0(view);
        }

        @p0
        public o e() {
            return this.f6645c;
        }

        public int f() {
            return this.f6643a;
        }

        @Deprecated
        public void g(int i10) {
            this.f6644b.D1(i10);
        }

        public boolean h() {
            return this.f6646d;
        }

        public boolean i() {
            return this.f6647e;
        }

        public void j(@n0 PointF pointF) {
            float f10 = pointF.x;
            float f11 = pointF.y;
            float fSqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void k(int i10, int i11) {
            PointF pointFA;
            RecyclerView recyclerView = this.f6644b;
            if (this.f6643a == -1 || recyclerView == null) {
                s();
            }
            if (this.f6646d && this.f6648f == null && this.f6645c != null && (pointFA = a(this.f6643a)) != null) {
                float f10 = pointFA.x;
                if (f10 != 0.0f || pointFA.y != 0.0f) {
                    recyclerView.C1((int) Math.signum(f10), (int) Math.signum(pointFA.y), null);
                }
            }
            this.f6646d = false;
            View view = this.f6648f;
            if (view != null) {
                if (d(view) == this.f6643a) {
                    p(this.f6648f, recyclerView.V7, this.f6649g);
                    this.f6649g.g(recyclerView);
                    s();
                } else {
                    this.f6648f = null;
                }
            }
            if (this.f6647e) {
                m(i10, i11, recyclerView.V7, this.f6649g);
                boolean zE = this.f6649g.e();
                this.f6649g.g(recyclerView);
                if (zE && this.f6647e) {
                    this.f6646d = true;
                    recyclerView.S7.e();
                }
            }
        }

        public void l(View view) {
            if (d(view) == f()) {
                this.f6648f = view;
            }
        }

        public abstract void m(@t0 int i10, @t0 int i11, @n0 b0 b0Var, @n0 a aVar);

        public abstract void n();

        public abstract void o();

        public abstract void p(@n0 View view, @n0 b0 b0Var, @n0 a aVar);

        public void q(int i10) {
            this.f6643a = i10;
        }

        public void r(RecyclerView recyclerView, o oVar) {
            recyclerView.S7.stop();
            if (this.f6650h) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("An instance of ");
                sb2.append(getClass().getSimpleName());
                sb2.append(" was started more than once. Each instance of");
                sb2.append(getClass().getSimpleName());
                sb2.append(" is intended to only be used once. You should create a new instance for each use.");
            }
            this.f6644b = recyclerView;
            this.f6645c = oVar;
            int i10 = this.f6643a;
            if (i10 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.V7.f6663a = i10;
            this.f6647e = true;
            this.f6646d = true;
            this.f6648f = b(f());
            n();
            this.f6644b.S7.e();
            this.f6650h = true;
        }

        public final void s() {
            if (this.f6647e) {
                this.f6647e = false;
                o();
                this.f6644b.V7.f6663a = -1;
                this.f6648f = null;
                this.f6643a = -1;
                this.f6646d = false;
                this.f6645c.y1(this);
                this.f6645c = null;
                this.f6644b = null;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.K2;
            if (lVar != null) {
                lVar.x();
            }
            RecyclerView.this.f6602b8 = false;
        }
    }

    public static class b0 {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f6660r = 1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f6661s = 2;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f6662t = 4;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray<Object> f6664b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6675m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f6676n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6677o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f6678p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6679q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6663a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6665c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6666d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6667e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6668f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f6669g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f6670h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f6671i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f6672j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f6673k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f6674l = false;

        public void a(int i10) {
            if ((this.f6667e & i10) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f6667e));
        }

        public boolean b() {
            return this.f6669g;
        }

        public <T> T c(int i10) {
            SparseArray<Object> sparseArray = this.f6664b;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i10);
        }

        public int d() {
            return this.f6670h ? this.f6665c - this.f6666d : this.f6668f;
        }

        public int e() {
            return this.f6678p;
        }

        public int f() {
            return this.f6679q;
        }

        public int g() {
            return this.f6663a;
        }

        public boolean h() {
            return this.f6663a != -1;
        }

        public boolean i() {
            return this.f6672j;
        }

        public boolean j() {
            return this.f6670h;
        }

        public void k(g gVar) {
            this.f6667e = 1;
            this.f6668f = gVar.getItemCount();
            this.f6670h = false;
            this.f6671i = false;
            this.f6672j = false;
        }

        public void l(int i10, Object obj) {
            if (this.f6664b == null) {
                this.f6664b = new SparseArray<>();
            }
            this.f6664b.put(i10, obj);
        }

        public void m(int i10) {
            SparseArray<Object> sparseArray = this.f6664b;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(i10);
        }

        public boolean n() {
            return this.f6674l;
        }

        public boolean o() {
            return this.f6673k;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f6663a + ", mData=" + this.f6664b + ", mItemCount=" + this.f6668f + ", mIsMeasuring=" + this.f6672j + ", mPreviousLayoutItemCount=" + this.f6665c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f6666d + ", mStructureChanged=" + this.f6669g + ", mInPreLayout=" + this.f6670h + ", mRunSimpleAnimations=" + this.f6673k + ", mRunPredictiveAnimations=" + this.f6674l + '}';
        }
    }

    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public static abstract class c0 {
        @p0
        public abstract View a(@n0 w wVar, int i10, int i11);
    }

    public class d implements h0.b {
        public d() {
        }

        @Override // androidx.recyclerview.widget.h0.b
        public void a(e0 e0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f6625m.G1(e0Var.itemView, recyclerView.f6601b);
        }

        @Override // androidx.recyclerview.widget.h0.b
        public void b(e0 e0Var, l.d dVar, l.d dVar2) {
            RecyclerView.this.s(e0Var, dVar, dVar2);
        }

        @Override // androidx.recyclerview.widget.h0.b
        public void c(e0 e0Var, @n0 l.d dVar, @p0 l.d dVar2) {
            RecyclerView.this.f6601b.K(e0Var);
            RecyclerView.this.u(e0Var, dVar, dVar2);
        }

        @Override // androidx.recyclerview.widget.h0.b
        public void d(e0 e0Var, @n0 l.d dVar, @n0 l.d dVar2) {
            e0Var.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.D) {
                if (recyclerView.K2.b(e0Var, e0Var, dVar, dVar2)) {
                    RecyclerView.this.g1();
                }
            } else if (recyclerView.K2.d(e0Var, dVar, dVar2)) {
                RecyclerView.this.g1();
            }
        }
    }

    public class d0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScroller f6683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f6684d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6685e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6686f;

        public d0() {
            Interpolator interpolator = RecyclerView.V8;
            this.f6684d = interpolator;
            this.f6685e = false;
            this.f6686f = false;
            this.f6683c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i10, int i11, int i12, int i13) {
            int iRound;
            int iAbs = Math.abs(i10);
            int iAbs2 = Math.abs(i11);
            boolean z10 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i12 * i12) + (i13 * i13));
            int iSqrt2 = (int) Math.sqrt((i10 * i10) + (i11 * i11));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i14 = width / 2;
            float f10 = width;
            float f11 = i14;
            float fB = f11 + (b(Math.min(1.0f, (iSqrt2 * 1.0f) / f10)) * f11);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fB / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z10) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f10) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final float b(float f10) {
            return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
        }

        public void c(int i10, int i11) {
            RecyclerView.this.setScrollState(2);
            this.f6682b = 0;
            this.f6681a = 0;
            Interpolator interpolator = this.f6684d;
            Interpolator interpolator2 = RecyclerView.V8;
            if (interpolator != interpolator2) {
                this.f6684d = interpolator2;
                this.f6683c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f6683c.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        public final void d() {
            RecyclerView.this.removeCallbacks(this);
            u0.p1(RecyclerView.this, this);
        }

        public void e() {
            if (this.f6685e) {
                this.f6686f = true;
            } else {
                d();
            }
        }

        public void f(int i10, int i11, int i12, @p0 Interpolator interpolator) {
            if (i12 == Integer.MIN_VALUE) {
                i12 = a(i10, i11, 0, 0);
            }
            int i13 = i12;
            if (interpolator == null) {
                interpolator = RecyclerView.V8;
            }
            if (this.f6684d != interpolator) {
                this.f6684d = interpolator;
                this.f6683c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f6682b = 0;
            this.f6681a = 0;
            RecyclerView.this.setScrollState(2);
            this.f6683c.startScroll(0, 0, i10, i11, i13);
            if (Build.VERSION.SDK_INT < 23) {
                this.f6683c.computeScrollOffset();
            }
            e();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            int i11;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f6625m == null) {
                stop();
                return;
            }
            this.f6686f = false;
            this.f6685e = true;
            recyclerView.E();
            OverScroller overScroller = this.f6683c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i12 = currX - this.f6681a;
                int i13 = currY - this.f6682b;
                this.f6681a = currX;
                this.f6682b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f6616i8;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.b(i12, i13, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f6616i8;
                    i12 -= iArr2[0];
                    i13 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.D(i12, i13);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f6623l != null) {
                    int[] iArr3 = recyclerView3.f6616i8;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.C1(i12, i13, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f6616i8;
                    i11 = iArr4[0];
                    i10 = iArr4[1];
                    i12 -= i11;
                    i13 -= i10;
                    a0 a0Var = recyclerView4.f6625m.f6717g;
                    if (a0Var != null && !a0Var.h() && a0Var.i()) {
                        int iD = RecyclerView.this.V7.d();
                        if (iD == 0) {
                            a0Var.s();
                        } else if (a0Var.f() >= iD) {
                            a0Var.q(iD - 1);
                            a0Var.k(i11, i10);
                        } else {
                            a0Var.k(i11, i10);
                        }
                    }
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                if (!RecyclerView.this.f6627o.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f6616i8;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.c(i11, i10, i12, i13, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.f6616i8;
                int i14 = i12 - iArr6[0];
                int i15 = i13 - iArr6[1];
                if (i11 != 0 || i10 != 0) {
                    recyclerView6.Q(i11, i10);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i14 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i15 != 0));
                a0 a0Var2 = RecyclerView.this.f6625m.f6717g;
                if ((a0Var2 != null && a0Var2.h()) || !z10) {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.l lVar = recyclerView7.T7;
                    if (lVar != null) {
                        lVar.f(recyclerView7, i11, i10);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i16 = i14 < 0 ? -currVelocity : i14 > 0 ? currVelocity : 0;
                        if (i15 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i15 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.h(i16, currVelocity);
                    }
                    if (RecyclerView.f6592t8) {
                        RecyclerView.this.U7.b();
                    }
                }
            }
            a0 a0Var3 = RecyclerView.this.f6625m.f6717g;
            if (a0Var3 != null && a0Var3.h()) {
                a0Var3.k(0, 0);
            }
            this.f6685e = false;
            if (this.f6686f) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.g(1);
            }
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.f6683c.abortAnimation();
        }
    }

    public class e implements g.b {
        public e() {
        }

        @Override // androidx.recyclerview.widget.g.b
        public View a(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void addView(View view, int i10) {
            RecyclerView.this.addView(view, i10);
            RecyclerView.this.I(view);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void b(View view) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (e0VarU0 != null) {
                e0VarU0.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.g.b
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.g.b
        public int d(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.g.b
        public e0 e(View view) {
            return RecyclerView.u0(view);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void f(int i10) {
            e0 e0VarU0;
            View viewA = a(i10);
            if (viewA != null && (e0VarU0 = RecyclerView.u0(viewA)) != null) {
                if (e0VarU0.isTmpDetached() && !e0VarU0.shouldIgnore()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + e0VarU0 + RecyclerView.this.X());
                }
                e0VarU0.addFlags(256);
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void g(View view) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (e0VarU0 != null) {
                e0VarU0.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.g.b
        public void h(View view, int i10, ViewGroup.LayoutParams layoutParams) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (e0VarU0 != null) {
                if (!e0VarU0.isTmpDetached() && !e0VarU0.shouldIgnore()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + e0VarU0 + RecyclerView.this.X());
                }
                e0VarU0.clearTmpDetachFlag();
            }
            RecyclerView.this.attachViewToParent(view, i10, layoutParams);
        }

        @Override // androidx.recyclerview.widget.g.b
        public void removeAllViews() {
            int iC = c();
            for (int i10 = 0; i10 < iC; i10++) {
                View viewA = a(i10);
                RecyclerView.this.J(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.g.b
        public void removeViewAt(int i10) {
            View childAt = RecyclerView.this.getChildAt(i10);
            if (childAt != null) {
                RecyclerView.this.J(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i10);
        }
    }

    public static abstract class e0 {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

        @n0
        public final View itemView;
        public int mFlags;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public RecyclerView mOwnerRecyclerView;
        public int mPosition = -1;
        public int mOldPosition = -1;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public int mPreLayoutPosition = -1;
        public e0 mShadowedHolder = null;
        public e0 mShadowingHolder = null;
        public List<Object> mPayloads = null;
        public List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        public w mScrapContainer = null;
        public boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        @i1
        public int mPendingAccessibilityState = -1;

        public e0(@n0 View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i10) {
            this.mFlags = i10 | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && u0.M0(this.itemView);
        }

        public void flagRemovedAndOffsetPosition(int i10, int i11, boolean z10) {
            addFlags(8);
            offsetPosition(i11, z10);
            this.mPosition = i10;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.n0(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i10 = this.mPreLayoutPosition;
            return i10 == -1 ? this.mPosition : i10;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i10 = this.mPreLayoutPosition;
            return i10 == -1 ? this.mPosition : i10;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i10) {
            return (i10 & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !u0.M0(this.itemView);
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i10, boolean z10) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z10) {
                this.mPreLayoutPosition += i10;
            }
            this.mPosition += i10;
            if (this.itemView.getLayoutParams() != null) {
                ((p) this.itemView.getLayoutParams()).f6737c = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i10 = this.mPendingAccessibilityState;
            if (i10 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i10;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = u0.V(this.itemView);
            }
            recyclerView.F1(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.F1(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.z(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i10, int i11) {
            this.mFlags = (i10 & i11) | (this.mFlags & (~i11));
        }

        public final void setIsRecyclable(boolean z10) {
            int i10 = this.mIsRecyclableCount;
            int i11 = z10 ? i10 - 1 : i10 + 1;
            this.mIsRecyclableCount = i11;
            if (i11 < 0) {
                this.mIsRecyclableCount = 0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                sb2.append(this);
                return;
            }
            if (!z10 && i11 == 1) {
                this.mFlags |= 16;
            } else if (z10 && i11 == 0) {
                this.mFlags &= -17;
            }
        }

        public void setScrapContainer(w wVar, boolean z10) {
            this.mScrapContainer = wVar;
            this.mInChangeScrap = z10;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + zc.a.f58316d + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb2.append(" not recyclable(" + this.mIsRecyclableCount + ee.a.f26979d);
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append(zc.a.f58317e);
            return sb2.toString();
        }

        public void unScrap() {
            this.mScrapContainer.K(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    public class f implements a.InterfaceC0062a {
        public f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0062a
        public void a(int i10, int i11) {
            RecyclerView.this.W0(i10, i11);
            RecyclerView.this.Y7 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0062a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0062a
        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.R1(i10, i11, obj);
            RecyclerView.this.Z7 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0062a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0062a
        public e0 e(int i10) {
            e0 e0VarK0 = RecyclerView.this.k0(i10, true);
            if (e0VarK0 == null || RecyclerView.this.f6607e.n(e0VarK0.itemView)) {
                return null;
            }
            return e0VarK0;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0062a
        public void f(int i10, int i11) {
            RecyclerView.this.X0(i10, i11, false);
            RecyclerView.this.Y7 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0062a
        public void g(int i10, int i11) {
            RecyclerView.this.V0(i10, i11);
            RecyclerView.this.Y7 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0062a
        public void h(int i10, int i11) {
            RecyclerView.this.X0(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.Y7 = true;
            recyclerView.V7.f6666d += i11;
        }

        public void i(a.b bVar) {
            int i10 = bVar.f6821a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f6625m.k1(recyclerView, bVar.f6822b, bVar.f6824d);
                return;
            }
            if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f6625m.n1(recyclerView2, bVar.f6822b, bVar.f6824d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f6625m.p1(recyclerView3, bVar.f6822b, bVar.f6824d, bVar.f6823c);
            } else {
                if (i10 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f6625m.m1(recyclerView4, bVar.f6822b, bVar.f6824d, 1);
            }
        }
    }

    public static abstract class g<VH extends e0> {
        private final h mObservable = new h();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(@n0 VH vh2, int i10) {
            vh2.mPosition = i10;
            if (hasStableIds()) {
                vh2.mItemId = getItemId(i10);
            }
            vh2.setFlags(1, gg.b.f29438g0);
            androidx.core.os.y.b(RecyclerView.L8);
            onBindViewHolder(vh2, i10, vh2.getUnmodifiedPayloads());
            vh2.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh2.itemView.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f6737c = true;
            }
            androidx.core.os.y.d();
        }

        @n0
        public final VH createViewHolder(@n0 ViewGroup viewGroup, int i10) {
            try {
                androidx.core.os.y.b(RecyclerView.O8);
                VH vh2 = (VH) onCreateViewHolder(viewGroup, i10);
                if (vh2.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh2.mItemViewType = i10;
                return vh2;
            } finally {
                androidx.core.os.y.d();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i10) {
            return -1L;
        }

        public int getItemViewType(int i10) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i10) {
            this.mObservable.d(i10, 1);
        }

        public final void notifyItemInserted(int i10) {
            this.mObservable.f(i10, 1);
        }

        public final void notifyItemMoved(int i10, int i11) {
            this.mObservable.c(i10, i11);
        }

        public final void notifyItemRangeChanged(int i10, int i11) {
            this.mObservable.d(i10, i11);
        }

        public final void notifyItemRangeInserted(int i10, int i11) {
            this.mObservable.f(i10, i11);
        }

        public final void notifyItemRangeRemoved(int i10, int i11) {
            this.mObservable.g(i10, i11);
        }

        public final void notifyItemRemoved(int i10) {
            this.mObservable.g(i10, 1);
        }

        public void onAttachedToRecyclerView(@n0 RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@n0 VH vh2, int i10);

        public void onBindViewHolder(@n0 VH vh2, int i10, @n0 List<Object> list) {
            onBindViewHolder(vh2, i10);
        }

        @n0
        public abstract VH onCreateViewHolder(@n0 ViewGroup viewGroup, int i10);

        public void onDetachedFromRecyclerView(@n0 RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@n0 VH vh2) {
            return false;
        }

        public void onViewAttachedToWindow(@n0 VH vh2) {
        }

        public void onViewDetachedFromWindow(@n0 VH vh2) {
        }

        public void onViewRecycled(@n0 VH vh2) {
        }

        public void registerAdapterDataObserver(@n0 i iVar) {
            this.mObservable.registerObserver(iVar);
        }

        public void setHasStableIds(boolean z10) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z10;
        }

        public void unregisterAdapterDataObserver(@n0 i iVar) {
            this.mObservable.unregisterObserver(iVar);
        }

        public final void notifyItemChanged(int i10, @p0 Object obj) {
            this.mObservable.e(i10, 1, obj);
        }

        public final void notifyItemRangeChanged(int i10, int i11, @p0 Object obj) {
            this.mObservable.e(i10, i11, obj);
        }
    }

    public static class h extends Observable<i> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).e(i10, i11, 1);
            }
        }

        public void d(int i10, int i11) {
            e(i10, i11, null);
        }

        public void e(int i10, int i11, @p0 Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i10, i11, obj);
            }
        }

        public void f(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).d(i10, i11);
            }
        }

        public void g(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).f(i10, i11);
            }
        }
    }

    public static abstract class i {
        public void a() {
        }

        public void b(int i10, int i11) {
        }

        public void c(int i10, int i11, @p0 Object obj) {
            b(i10, i11);
        }

        public void d(int i10, int i11) {
        }

        public void e(int i10, int i11, int i12) {
        }

        public void f(int i10, int i11) {
        }
    }

    public interface j {
        int a(int i10, int i11);
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f6690a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6691b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6692c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6693d = 3;

        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        @n0
        public EdgeEffect a(@n0 RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f6694g = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f6695h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f6696i = 4;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f6697j = 2048;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f6698k = 4096;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f6699a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<b> f6700b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f6701c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f6702d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f6703e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f6704f = 250;

        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public interface b {
            void a();
        }

        public interface c {
            void a(@n0 e0 e0Var);
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6705a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f6706b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f6707c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f6708d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f6709e;

            @n0
            public d a(@n0 e0 e0Var) {
                return b(e0Var, 0);
            }

            @n0
            public d b(@n0 e0 e0Var, int i10) {
                View view = e0Var.itemView;
                this.f6705a = view.getLeft();
                this.f6706b = view.getTop();
                this.f6707c = view.getRight();
                this.f6708d = view.getBottom();
                return this;
            }
        }

        public static int e(e0 e0Var) {
            int i10 = e0Var.mFlags & 14;
            if (e0Var.isInvalid()) {
                return 4;
            }
            if ((i10 & 4) != 0) {
                return i10;
            }
            int oldPosition = e0Var.getOldPosition();
            int adapterPosition = e0Var.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i10 : i10 | 2048;
        }

        public void A(c cVar) {
            this.f6699a = cVar;
        }

        public void B(long j10) {
            this.f6703e = j10;
        }

        public void C(long j10) {
            this.f6702d = j10;
        }

        public abstract boolean a(@n0 e0 e0Var, @p0 d dVar, @n0 d dVar2);

        public abstract boolean b(@n0 e0 e0Var, @n0 e0 e0Var2, @n0 d dVar, @n0 d dVar2);

        public abstract boolean c(@n0 e0 e0Var, @n0 d dVar, @p0 d dVar2);

        public abstract boolean d(@n0 e0 e0Var, @n0 d dVar, @n0 d dVar2);

        public boolean f(@n0 e0 e0Var) {
            return true;
        }

        public boolean g(@n0 e0 e0Var, @n0 List<Object> list) {
            return f(e0Var);
        }

        public final void h(@n0 e0 e0Var) {
            t(e0Var);
            c cVar = this.f6699a;
            if (cVar != null) {
                cVar.a(e0Var);
            }
        }

        public final void i(@n0 e0 e0Var) {
            u(e0Var);
        }

        public final void j() {
            int size = this.f6700b.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f6700b.get(i10).a();
            }
            this.f6700b.clear();
        }

        public abstract void k(@n0 e0 e0Var);

        public abstract void l();

        public long m() {
            return this.f6701c;
        }

        public long n() {
            return this.f6704f;
        }

        public long o() {
            return this.f6703e;
        }

        public long p() {
            return this.f6702d;
        }

        public abstract boolean q();

        public final boolean r(@p0 b bVar) {
            boolean zQ = q();
            if (bVar != null) {
                if (zQ) {
                    this.f6700b.add(bVar);
                } else {
                    bVar.a();
                }
            }
            return zQ;
        }

        @n0
        public d s() {
            return new d();
        }

        public void t(@n0 e0 e0Var) {
        }

        public void u(@n0 e0 e0Var) {
        }

        @n0
        public d v(@n0 b0 b0Var, @n0 e0 e0Var) {
            return s().a(e0Var);
        }

        @n0
        public d w(@n0 b0 b0Var, @n0 e0 e0Var, int i10, @n0 List<Object> list) {
            return s().a(e0Var);
        }

        public abstract void x();

        public void y(long j10) {
            this.f6701c = j10;
        }

        public void z(long j10) {
            this.f6704f = j10;
        }
    }

    public class m implements l.c {
        public m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.c
        public void a(e0 e0Var) {
            e0Var.setIsRecyclable(true);
            if (e0Var.mShadowedHolder != null && e0Var.mShadowingHolder == null) {
                e0Var.mShadowedHolder = null;
            }
            e0Var.mShadowingHolder = null;
            if (e0Var.shouldBeKeptAsChild() || RecyclerView.this.p1(e0Var.itemView) || !e0Var.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(e0Var.itemView, false);
        }
    }

    public static abstract class n {
        @Deprecated
        public void c(@n0 Rect rect, int i10, @n0 RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void d(@n0 Rect rect, @n0 View view, @n0 RecyclerView recyclerView, @n0 b0 b0Var) {
            c(rect, ((p) view.getLayoutParams()).b(), recyclerView);
        }

        @Deprecated
        public void e(@n0 Canvas canvas, @n0 RecyclerView recyclerView) {
        }

        public void f(@n0 Canvas canvas, @n0 RecyclerView recyclerView, @n0 b0 b0Var) {
            e(canvas, recyclerView);
        }

        @Deprecated
        public void g(@n0 Canvas canvas, @n0 RecyclerView recyclerView) {
        }

        public void h(@n0 Canvas canvas, @n0 RecyclerView recyclerView, @n0 b0 b0Var) {
            g(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public androidx.recyclerview.widget.g f6711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView f6712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g0.b f6713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final g0.b f6714d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public g0 f6715e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g0 f6716f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public a0 f6717g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f6718h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f6719i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f6720j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f6721k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f6722l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6723m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f6724n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6725o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f6726p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6727q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f6728r;

        public class a implements g0.b {
            public a() {
            }

            @Override // androidx.recyclerview.widget.g0.b
            public View a(int i10) {
                return o.this.X(i10);
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int b(View view) {
                return o.this.g0(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int c() {
                return o.this.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int d() {
                return o.this.B0() - o.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int e(View view) {
                return o.this.j0(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }
        }

        public class b implements g0.b {
            public b() {
            }

            @Override // androidx.recyclerview.widget.g0.b
            public View a(int i10) {
                return o.this.X(i10);
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int b(View view) {
                return o.this.k0(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int c() {
                return o.this.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int d() {
                return o.this.m0() - o.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.g0.b
            public int e(View view) {
                return o.this.e0(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }
        }

        public interface c {
            void a(int i10, int i11);
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6731a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f6732b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f6733c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f6734d;
        }

        public o() {
            a aVar = new a();
            this.f6713c = aVar;
            b bVar = new b();
            this.f6714d = bVar;
            this.f6715e = new g0(aVar);
            this.f6716f = new g0(bVar);
            this.f6718h = false;
            this.f6719i = false;
            this.f6720j = false;
            this.f6721k = true;
            this.f6722l = true;
        }

        public static boolean N0(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (i12 > 0 && i10 != i12) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i10;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i10;
            }
            return true;
        }

        public static int Z(int i10, int i11, int i12, int i13, boolean z10) {
            int iMax = Math.max(0, i10 - i12);
            if (z10) {
                if (i13 < 0) {
                    if (i13 != -1 || (i11 != Integer.MIN_VALUE && (i11 == 0 || i11 != 1073741824))) {
                        i11 = 0;
                        i13 = 0;
                    } else {
                        i13 = iMax;
                    }
                }
                i11 = 1073741824;
            } else {
                if (i13 < 0) {
                    if (i13 != -1) {
                        if (i13 == -2) {
                            i11 = (i11 == Integer.MIN_VALUE || i11 == 1073741824) ? Integer.MIN_VALUE : 0;
                        }
                        i11 = 0;
                        i13 = 0;
                    }
                    i13 = iMax;
                }
                i11 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i13, i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int a0(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Lf
                if (r3 < 0) goto Ld
                goto L11
            Ld:
                r3 = 0
                goto L21
            Lf:
                if (r3 < 0) goto L14
            L11:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L21
            L14:
                r4 = -1
                if (r3 != r4) goto L1b
                r2 = 1073741824(0x40000000, float:2.0)
            L19:
                r3 = r1
                goto L21
            L1b:
                r4 = -2
                if (r3 != r4) goto Ld
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L19
            L21:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.a0(int, int, int, boolean):int");
        }

        public static d v0(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
            d dVar = new d();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i10, i11);
            dVar.f6731a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            dVar.f6732b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            dVar.f6733c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            dVar.f6734d = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return dVar;
        }

        public static int y(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
        }

        public void A(int i10, c cVar) {
        }

        public void A0(@n0 View view, boolean z10, @n0 Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((p) view.getLayoutParams()).f6736b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f6712b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f6712b.f6619k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean A1(@n0 w wVar, @n0 b0 b0Var, int i10, @p0 Bundle bundle) {
            int iM0;
            int iB0;
            int i11;
            int i12;
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView == null) {
                return false;
            }
            if (i10 == 4096) {
                iM0 = recyclerView.canScrollVertically(1) ? (m0() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.f6712b.canScrollHorizontally(1)) {
                    iB0 = (B0() - getPaddingLeft()) - getPaddingRight();
                    i11 = iM0;
                    i12 = iB0;
                }
                i11 = iM0;
                i12 = 0;
            } else if (i10 != 8192) {
                i12 = 0;
                i11 = 0;
            } else {
                iM0 = recyclerView.canScrollVertically(-1) ? -((m0() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.f6712b.canScrollHorizontally(-1)) {
                    iB0 = -((B0() - getPaddingLeft()) - getPaddingRight());
                    i11 = iM0;
                    i12 = iB0;
                }
                i11 = iM0;
                i12 = 0;
            }
            if (i11 == 0 && i12 == 0) {
                return false;
            }
            this.f6712b.K1(i12, i11, null, Integer.MIN_VALUE, true);
            return true;
        }

        public int B(@n0 b0 b0Var) {
            return 0;
        }

        @t0
        public int B0() {
            return this.f6727q;
        }

        public boolean B1(@n0 View view, int i10, @p0 Bundle bundle) {
            RecyclerView recyclerView = this.f6712b;
            return C1(recyclerView.f6601b, recyclerView.V7, view, i10, bundle);
        }

        public int C(@n0 b0 b0Var) {
            return 0;
        }

        public int C0() {
            return this.f6725o;
        }

        public boolean C1(@n0 w wVar, @n0 b0 b0Var, @n0 View view, int i10, @p0 Bundle bundle) {
            return false;
        }

        public int D(@n0 b0 b0Var) {
            return 0;
        }

        public boolean D0() {
            int iY = Y();
            for (int i10 = 0; i10 < iY; i10++) {
                ViewGroup.LayoutParams layoutParams = X(i10).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void D1(Runnable runnable) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                u0.p1(recyclerView, runnable);
            }
        }

        public int E(@n0 b0 b0Var) {
            return 0;
        }

        public boolean E0() {
            RecyclerView recyclerView = this.f6712b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void E1(@n0 w wVar) {
            for (int iY = Y() - 1; iY >= 0; iY--) {
                if (!RecyclerView.u0(X(iY)).shouldIgnore()) {
                    H1(iY, wVar);
                }
            }
        }

        public int F(@n0 b0 b0Var) {
            return 0;
        }

        public void F0(@n0 View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.f6712b;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.f6712b.X());
            }
            e0 e0VarU0 = RecyclerView.u0(view);
            e0VarU0.addFlags(128);
            this.f6712b.f6609f.q(e0VarU0);
        }

        public void F1(w wVar) {
            int iK = wVar.k();
            for (int i10 = iK - 1; i10 >= 0; i10--) {
                View viewO = wVar.o(i10);
                e0 e0VarU0 = RecyclerView.u0(viewO);
                if (!e0VarU0.shouldIgnore()) {
                    e0VarU0.setIsRecyclable(false);
                    if (e0VarU0.isTmpDetached()) {
                        this.f6712b.removeDetachedView(viewO, false);
                    }
                    l lVar = this.f6712b.K2;
                    if (lVar != null) {
                        lVar.k(e0VarU0);
                    }
                    e0VarU0.setIsRecyclable(true);
                    wVar.z(viewO);
                }
            }
            wVar.f();
            if (iK > 0) {
                this.f6712b.invalidate();
            }
        }

        public int G(@n0 b0 b0Var) {
            return 0;
        }

        public boolean G0() {
            return this.f6719i;
        }

        public void G1(@n0 View view, @n0 w wVar) {
            K1(view);
            wVar.C(view);
        }

        public void H(@n0 w wVar) {
            for (int iY = Y() - 1; iY >= 0; iY--) {
                P1(wVar, iY, X(iY));
            }
        }

        public boolean H0() {
            return this.f6720j;
        }

        public void H1(int i10, @n0 w wVar) {
            View viewX = X(i10);
            removeViewAt(i10);
            wVar.C(viewX);
        }

        public void I(@n0 View view, @n0 w wVar) {
            P1(wVar, this.f6711a.m(view), view);
        }

        public boolean I0() {
            RecyclerView recyclerView = this.f6712b;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean I1(Runnable runnable) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void J(int i10, @n0 w wVar) {
            P1(wVar, i10, X(i10));
        }

        public final boolean J0(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int iB0 = B0() - getPaddingRight();
            int iM0 = m0() - getPaddingBottom();
            Rect rect = this.f6712b.f6615i;
            f0(focusedChild, rect);
            return rect.left - i10 < iB0 && rect.right - i10 > paddingLeft && rect.top - i11 < iM0 && rect.bottom - i11 > paddingTop;
        }

        public void J1(@n0 View view) {
            this.f6712b.removeDetachedView(view, false);
        }

        public void K(@n0 View view) {
            int iM = this.f6711a.m(view);
            if (iM >= 0) {
                M(iM, view);
            }
        }

        public final boolean K0() {
            return this.f6722l;
        }

        public void K1(View view) {
            this.f6711a.p(view);
        }

        public void L(int i10) {
            M(i10, X(i10));
        }

        public boolean L0(@n0 w wVar, @n0 b0 b0Var) {
            return false;
        }

        public boolean L1(@n0 RecyclerView recyclerView, @n0 View view, @n0 Rect rect, boolean z10) {
            return M1(recyclerView, view, rect, z10, false);
        }

        public final void M(int i10, @n0 View view) {
            this.f6711a.d(i10);
        }

        public boolean M0() {
            return this.f6721k;
        }

        public boolean M1(@n0 RecyclerView recyclerView, @n0 View view, @n0 Rect rect, boolean z10, boolean z11) {
            int[] iArrB0 = b0(view, rect);
            int i10 = iArrB0[0];
            int i11 = iArrB0[1];
            if ((z11 && !J0(recyclerView, i10, i11)) || (i10 == 0 && i11 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i10, i11);
            } else {
                recyclerView.H1(i10, i11);
            }
            return true;
        }

        public void N(RecyclerView recyclerView) {
            this.f6719i = true;
            Z0(recyclerView);
        }

        public void N1() {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void O(RecyclerView recyclerView, w wVar) {
            this.f6719i = false;
            b1(recyclerView, wVar);
        }

        public boolean O0() {
            a0 a0Var = this.f6717g;
            return a0Var != null && a0Var.i();
        }

        public void O1() {
            this.f6718h = true;
        }

        public void P(View view) {
            l lVar = this.f6712b.K2;
            if (lVar != null) {
                lVar.k(RecyclerView.u0(view));
            }
        }

        public boolean P0(@n0 View view, boolean z10, boolean z11) {
            boolean z12 = this.f6715e.b(view, SocializeConstants.AUTH_EVENT) && this.f6716f.b(view, SocializeConstants.AUTH_EVENT);
            return z10 ? z12 : !z12;
        }

        public final void P1(w wVar, int i10, View view) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (e0VarU0.shouldIgnore()) {
                return;
            }
            if (e0VarU0.isInvalid() && !e0VarU0.isRemoved() && !this.f6712b.f6623l.hasStableIds()) {
                removeViewAt(i10);
                wVar.D(e0VarU0);
            } else {
                L(i10);
                wVar.E(view);
                this.f6712b.f6609f.k(e0VarU0);
            }
        }

        @p0
        public View Q(@n0 View view) {
            View viewA0;
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView == null || (viewA0 = recyclerView.a0(view)) == null || this.f6711a.n(viewA0)) {
                return null;
            }
            return viewA0;
        }

        public void Q0(@n0 View view, int i10, int i11, int i12, int i13) {
            Rect rect = ((p) view.getLayoutParams()).f6736b;
            view.layout(i10 + rect.left, i11 + rect.top, i12 - rect.right, i13 - rect.bottom);
        }

        public int Q1(int i10, w wVar, b0 b0Var) {
            return 0;
        }

        @p0
        public View R(int i10) {
            int iY = Y();
            for (int i11 = 0; i11 < iY; i11++) {
                View viewX = X(i11);
                e0 e0VarU0 = RecyclerView.u0(viewX);
                if (e0VarU0 != null && e0VarU0.getLayoutPosition() == i10 && !e0VarU0.shouldIgnore() && (this.f6712b.V7.j() || !e0VarU0.isRemoved())) {
                    return viewX;
                }
            }
            return null;
        }

        public void R0(@n0 View view, int i10, int i11, int i12, int i13) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f6736b;
            view.layout(i10 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i11 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i12 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i13 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void R1(int i10) {
        }

        public abstract p S();

        public void S0(@n0 View view, int i10, int i11) {
            p pVar = (p) view.getLayoutParams();
            Rect rectZ0 = this.f6712b.z0(view);
            int i12 = i10 + rectZ0.left + rectZ0.right;
            int i13 = i11 + rectZ0.top + rectZ0.bottom;
            int iZ = Z(B0(), C0(), getPaddingLeft() + getPaddingRight() + i12, ((ViewGroup.MarginLayoutParams) pVar).width, v());
            int iZ2 = Z(m0(), n0(), getPaddingTop() + getPaddingBottom() + i13, ((ViewGroup.MarginLayoutParams) pVar).height, w());
            if (c2(view, iZ, iZ2, pVar)) {
                view.measure(iZ, iZ2);
            }
        }

        public int S1(int i10, w wVar, b0 b0Var) {
            return 0;
        }

        public p T(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void T0(@n0 View view, int i10, int i11) {
            p pVar = (p) view.getLayoutParams();
            Rect rectZ0 = this.f6712b.z0(view);
            int i12 = i10 + rectZ0.left + rectZ0.right;
            int i13 = i11 + rectZ0.top + rectZ0.bottom;
            int iZ = Z(B0(), C0(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i12, ((ViewGroup.MarginLayoutParams) pVar).width, v());
            int iZ2 = Z(m0(), n0(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i13, ((ViewGroup.MarginLayoutParams) pVar).height, w());
            if (c2(view, iZ, iZ2, pVar)) {
                view.measure(iZ, iZ2);
            }
        }

        @Deprecated
        public void T1(boolean z10) {
            this.f6720j = z10;
        }

        public p U(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public void U0(int i10, int i11) {
            View viewX = X(i10);
            if (viewX != null) {
                L(i10);
                s(viewX, i11);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.f6712b.toString());
            }
        }

        public void U1(RecyclerView recyclerView) {
            W1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int V() {
            return -1;
        }

        public void V0(@t0 int i10) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                recyclerView.T0(i10);
            }
        }

        public final void V1(boolean z10) {
            if (z10 != this.f6722l) {
                this.f6722l = z10;
                this.f6723m = 0;
                RecyclerView recyclerView = this.f6712b;
                if (recyclerView != null) {
                    recyclerView.f6601b.L();
                }
            }
        }

        public int W(@n0 View view) {
            return ((p) view.getLayoutParams()).f6736b.bottom;
        }

        public void W0(@t0 int i10) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                recyclerView.U0(i10);
            }
        }

        public void W1(int i10, int i11) {
            this.f6727q = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.f6725o = mode;
            if (mode == 0 && !RecyclerView.f6590r8) {
                this.f6727q = 0;
            }
            this.f6728r = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f6726p = mode2;
            if (mode2 != 0 || RecyclerView.f6590r8) {
                return;
            }
            this.f6728r = 0;
        }

        @p0
        public View X(int i10) {
            androidx.recyclerview.widget.g gVar = this.f6711a;
            if (gVar != null) {
                return gVar.f(i10);
            }
            return null;
        }

        public void X0(@p0 g gVar, @p0 g gVar2) {
        }

        public void X1(int i10, int i11) {
            this.f6712b.setMeasuredDimension(i10, i11);
        }

        public int Y() {
            androidx.recyclerview.widget.g gVar = this.f6711a;
            if (gVar != null) {
                return gVar.g();
            }
            return 0;
        }

        public boolean Y0(@n0 RecyclerView recyclerView, @n0 ArrayList<View> arrayList, int i10, int i11) {
            return false;
        }

        public void Y1(Rect rect, int i10, int i11) {
            X1(y(i10, rect.width() + getPaddingLeft() + getPaddingRight(), t0()), y(i11, rect.height() + getPaddingTop() + getPaddingBottom(), s0()));
        }

        @g.i
        public void Z0(RecyclerView recyclerView) {
        }

        public void Z1(int i10, int i11) {
            int iY = Y();
            if (iY == 0) {
                this.f6712b.G(i10, i11);
                return;
            }
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MAX_VALUE;
            for (int i16 = 0; i16 < iY; i16++) {
                View viewX = X(i16);
                Rect rect = this.f6712b.f6615i;
                f0(viewX, rect);
                int i17 = rect.left;
                if (i17 < i14) {
                    i14 = i17;
                }
                int i18 = rect.right;
                if (i18 > i12) {
                    i12 = i18;
                }
                int i19 = rect.top;
                if (i19 < i15) {
                    i15 = i19;
                }
                int i20 = rect.bottom;
                if (i20 > i13) {
                    i13 = i20;
                }
            }
            this.f6712b.f6615i.set(i14, i15, i12, i13);
            Y1(this.f6712b.f6615i, i10, i11);
        }

        @Deprecated
        public void a1(RecyclerView recyclerView) {
        }

        public void a2(boolean z10) {
            this.f6721k = z10;
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public final int[] b0(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int iB0 = B0() - getPaddingRight();
            int iM0 = m0() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top2 = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top2;
            int i10 = left - paddingLeft;
            int iMin = Math.min(0, i10);
            int i11 = top2 - paddingTop;
            int iMin2 = Math.min(0, i11);
            int i12 = iWidth - iB0;
            int iMax = Math.max(0, i12);
            int iMax2 = Math.max(0, iHeight - iM0);
            if (q0() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i10, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i12);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i11, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        @g.i
        public void b1(RecyclerView recyclerView, w wVar) {
            a1(recyclerView);
        }

        public void b2(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f6712b = null;
                this.f6711a = null;
                this.f6727q = 0;
                this.f6728r = 0;
            } else {
                this.f6712b = recyclerView;
                this.f6711a = recyclerView.f6607e;
                this.f6727q = recyclerView.getWidth();
                this.f6728r = recyclerView.getHeight();
            }
            this.f6725o = 1073741824;
            this.f6726p = 1073741824;
        }

        public boolean c0() {
            RecyclerView recyclerView = this.f6712b;
            return recyclerView != null && recyclerView.f6611g;
        }

        @p0
        public View c1(@n0 View view, int i10, @n0 w wVar, @n0 b0 b0Var) {
            return null;
        }

        public boolean c2(View view, int i10, int i11, p pVar) {
            return (!view.isLayoutRequested() && this.f6721k && N0(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) pVar).width) && N0(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int d0(@n0 w wVar, @n0 b0 b0Var) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView == null || recyclerView.f6623l == null || !v()) {
                return 1;
            }
            return this.f6712b.f6623l.getItemCount();
        }

        public void d1(@n0 AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f6712b;
            e1(recyclerView.f6601b, recyclerView.V7, accessibilityEvent);
        }

        public boolean d2() {
            return false;
        }

        public int e0(@n0 View view) {
            return view.getBottom() + W(view);
        }

        public void e1(@n0 w wVar, @n0 b0 b0Var, @n0 AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f6712b.canScrollVertically(-1) && !this.f6712b.canScrollHorizontally(-1) && !this.f6712b.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            g gVar = this.f6712b.f6623l;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.getItemCount());
            }
        }

        public boolean e2(View view, int i10, int i11, p pVar) {
            return (this.f6721k && N0(view.getMeasuredWidth(), i10, ((ViewGroup.MarginLayoutParams) pVar).width) && N0(view.getMeasuredHeight(), i11, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public void f0(@n0 View view, @n0 Rect rect) {
            RecyclerView.w0(view, rect);
        }

        public void f1(a1.d dVar) {
            RecyclerView recyclerView = this.f6712b;
            g1(recyclerView.f6601b, recyclerView.V7, dVar);
        }

        public void f2(RecyclerView recyclerView, b0 b0Var, int i10) {
        }

        public int g0(@n0 View view) {
            return view.getLeft() - r0(view);
        }

        public void g1(@n0 w wVar, @n0 b0 b0Var, @n0 a1.d dVar) {
            if (this.f6712b.canScrollVertically(-1) || this.f6712b.canScrollHorizontally(-1)) {
                dVar.a(8192);
                dVar.M1(true);
            }
            if (this.f6712b.canScrollVertically(1) || this.f6712b.canScrollHorizontally(1)) {
                dVar.a(4096);
                dVar.M1(true);
            }
            dVar.d1(d.C0006d.f(x0(wVar, b0Var), d0(wVar, b0Var), L0(wVar, b0Var), y0(wVar, b0Var)));
        }

        public void g2(a0 a0Var) {
            a0 a0Var2 = this.f6717g;
            if (a0Var2 != null && a0Var != a0Var2 && a0Var2.i()) {
                this.f6717g.s();
            }
            this.f6717g = a0Var;
            a0Var.r(this.f6712b, this);
        }

        @t0
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @t0
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                return u0.j0(recyclerView);
            }
            return 0;
        }

        @t0
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @t0
        public int getPaddingRight() {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @t0
        public int getPaddingStart() {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                return u0.k0(recyclerView);
            }
            return 0;
        }

        @t0
        public int getPaddingTop() {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int h0(@n0 View view) {
            Rect rect = ((p) view.getLayoutParams()).f6736b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void h1(View view, a1.d dVar) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (e0VarU0 == null || e0VarU0.isRemoved() || this.f6711a.n(e0VarU0.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.f6712b;
            i1(recyclerView.f6601b, recyclerView.V7, view, dVar);
        }

        public void h2(@n0 View view) {
            e0 e0VarU0 = RecyclerView.u0(view);
            e0VarU0.stopIgnoring();
            e0VarU0.resetInternal();
            e0VarU0.addFlags(4);
        }

        public int i0(@n0 View view) {
            Rect rect = ((p) view.getLayoutParams()).f6736b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void i1(@n0 w wVar, @n0 b0 b0Var, @n0 View view, @n0 a1.d dVar) {
            dVar.e1(d.e.h(w() ? u0(view) : 0, 1, v() ? u0(view) : 0, 1, false, false));
        }

        public void i2() {
            a0 a0Var = this.f6717g;
            if (a0Var != null) {
                a0Var.s();
            }
        }

        public int j0(@n0 View view) {
            return view.getRight() + w0(view);
        }

        @p0
        public View j1(@n0 View view, int i10) {
            return null;
        }

        public boolean j2() {
            return false;
        }

        public int k0(@n0 View view) {
            return view.getTop() - z0(view);
        }

        public void k1(@n0 RecyclerView recyclerView, int i10, int i11) {
        }

        @p0
        public View l0() {
            View focusedChild;
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f6711a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void l1(@n0 RecyclerView recyclerView) {
        }

        public void m(View view) {
            n(view, -1);
        }

        @t0
        public int m0() {
            return this.f6728r;
        }

        public void m1(@n0 RecyclerView recyclerView, int i10, int i11, int i12) {
        }

        public void n(View view, int i10) {
            o(view, i10, true);
        }

        public int n0() {
            return this.f6726p;
        }

        public void n1(@n0 RecyclerView recyclerView, int i10, int i11) {
        }

        public final void o(View view, int i10, boolean z10) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (z10 || e0VarU0.isRemoved()) {
                this.f6712b.f6609f.b(e0VarU0);
            } else {
                this.f6712b.f6609f.p(e0VarU0);
            }
            p pVar = (p) view.getLayoutParams();
            if (e0VarU0.wasReturnedFromScrap() || e0VarU0.isScrap()) {
                if (e0VarU0.isScrap()) {
                    e0VarU0.unScrap();
                } else {
                    e0VarU0.clearReturnedFromScrapFlag();
                }
                this.f6711a.c(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f6712b) {
                int iM = this.f6711a.m(view);
                if (i10 == -1) {
                    i10 = this.f6711a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f6712b.indexOfChild(view) + this.f6712b.X());
                }
                if (iM != i10) {
                    this.f6712b.f6625m.U0(iM, i10);
                }
            } else {
                this.f6711a.a(view, i10, false);
                pVar.f6737c = true;
                a0 a0Var = this.f6717g;
                if (a0Var != null && a0Var.i()) {
                    this.f6717g.l(view);
                }
            }
            if (pVar.f6738d) {
                e0VarU0.itemView.invalidate();
                pVar.f6738d = false;
            }
        }

        public int o0() {
            RecyclerView recyclerView = this.f6712b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void o1(@n0 RecyclerView recyclerView, int i10, int i11) {
        }

        public void p(String str) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                recyclerView.v(str);
            }
        }

        public int p0(@n0 View view) {
            return RecyclerView.u0(view).getItemViewType();
        }

        public void p1(@n0 RecyclerView recyclerView, int i10, int i11, @p0 Object obj) {
            o1(recyclerView, i10, i11);
        }

        public void q(String str) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView != null) {
                recyclerView.w(str);
            }
        }

        public int q0() {
            return u0.Z(this.f6712b);
        }

        public void q1(w wVar, b0 b0Var) {
        }

        public void r(@n0 View view) {
            s(view, -1);
        }

        public int r0(@n0 View view) {
            return ((p) view.getLayoutParams()).f6736b.left;
        }

        public void r1(b0 b0Var) {
        }

        public void removeAllViews() {
            for (int iY = Y() - 1; iY >= 0; iY--) {
                this.f6711a.q(iY);
            }
        }

        public void removeViewAt(int i10) {
            if (X(i10) != null) {
                this.f6711a.q(i10);
            }
        }

        public void s(@n0 View view, int i10) {
            t(view, i10, (p) view.getLayoutParams());
        }

        @t0
        public int s0() {
            return u0.e0(this.f6712b);
        }

        public void s1(@n0 w wVar, @n0 b0 b0Var, int i10, int i11) {
            this.f6712b.G(i10, i11);
        }

        public void t(@n0 View view, int i10, p pVar) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (e0VarU0.isRemoved()) {
                this.f6712b.f6609f.b(e0VarU0);
            } else {
                this.f6712b.f6609f.p(e0VarU0);
            }
            this.f6711a.c(view, i10, pVar, e0VarU0.isRemoved());
        }

        @t0
        public int t0() {
            return u0.f0(this.f6712b);
        }

        @Deprecated
        public boolean t1(@n0 RecyclerView recyclerView, @n0 View view, @p0 View view2) {
            return O0() || recyclerView.N0();
        }

        public void u(@n0 View view, @n0 Rect rect) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.z0(view));
            }
        }

        public int u0(@n0 View view) {
            return ((p) view.getLayoutParams()).b();
        }

        public boolean u1(@n0 RecyclerView recyclerView, @n0 b0 b0Var, @n0 View view, @p0 View view2) {
            return t1(recyclerView, view, view2);
        }

        public boolean v() {
            return false;
        }

        public void v1(Parcelable parcelable) {
        }

        public boolean w() {
            return false;
        }

        public int w0(@n0 View view) {
            return ((p) view.getLayoutParams()).f6736b.right;
        }

        @p0
        public Parcelable w1() {
            return null;
        }

        public boolean x(p pVar) {
            return pVar != null;
        }

        public int x0(@n0 w wVar, @n0 b0 b0Var) {
            RecyclerView recyclerView = this.f6712b;
            if (recyclerView == null || recyclerView.f6623l == null || !w()) {
                return 1;
            }
            return this.f6712b.f6623l.getItemCount();
        }

        public void x1(int i10) {
        }

        public int y0(@n0 w wVar, @n0 b0 b0Var) {
            return 0;
        }

        public void y1(a0 a0Var) {
            if (this.f6717g == a0Var) {
                this.f6717g = null;
            }
        }

        public void z(int i10, int i11, b0 b0Var, c cVar) {
        }

        public int z0(@n0 View view) {
            return ((p) view.getLayoutParams()).f6736b.top;
        }

        public boolean z1(int i10, @p0 Bundle bundle) {
            RecyclerView recyclerView = this.f6712b;
            return A1(recyclerView.f6601b, recyclerView.V7, i10, bundle);
        }

        public void addView(View view, int i10) {
            o(view, i10, false);
        }
    }

    public interface q {
        void a(@n0 View view);

        void b(@n0 View view);
    }

    public static abstract class r {
        public abstract boolean a(int i10, int i11);
    }

    public interface s {
        boolean onInterceptTouchEvent(@n0 RecyclerView recyclerView, @n0 MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z10);

        void onTouchEvent(@n0 RecyclerView recyclerView, @n0 MotionEvent motionEvent);
    }

    public static abstract class t {
        public void a(@n0 RecyclerView recyclerView, int i10) {
        }

        public void b(@n0 RecyclerView recyclerView, int i10, int i11) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface u {
    }

    public static class v {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6739c = 5;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray<a> f6740a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6741b = 0;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList<e0> f6742a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f6743b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f6744c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f6745d = 0;
        }

        public void a() {
            this.f6741b++;
        }

        public void b() {
            for (int i10 = 0; i10 < this.f6740a.size(); i10++) {
                this.f6740a.valueAt(i10).f6742a.clear();
            }
        }

        public void c() {
            this.f6741b--;
        }

        public void d(int i10, long j10) {
            a aVarH = h(i10);
            aVarH.f6745d = k(aVarH.f6745d, j10);
        }

        public void e(int i10, long j10) {
            a aVarH = h(i10);
            aVarH.f6744c = k(aVarH.f6744c, j10);
        }

        @p0
        public e0 f(int i10) {
            a aVar = this.f6740a.get(i10);
            if (aVar == null || aVar.f6742a.isEmpty()) {
                return null;
            }
            ArrayList<e0> arrayList = aVar.f6742a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public int g(int i10) {
            return h(i10).f6742a.size();
        }

        public final a h(int i10) {
            a aVar = this.f6740a.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f6740a.put(i10, aVar2);
            return aVar2;
        }

        public void i(g gVar, g gVar2, boolean z10) {
            if (gVar != null) {
                c();
            }
            if (!z10 && this.f6741b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void j(e0 e0Var) {
            int itemViewType = e0Var.getItemViewType();
            ArrayList<e0> arrayList = h(itemViewType).f6742a;
            if (this.f6740a.get(itemViewType).f6743b <= arrayList.size()) {
                return;
            }
            e0Var.resetInternal();
            arrayList.add(e0Var);
        }

        public long k(long j10, long j11) {
            return j10 == 0 ? j11 : ((j10 / 4) * 3) + (j11 / 4);
        }

        public void l(int i10, int i11) {
            a aVarH = h(i10);
            aVarH.f6743b = i11;
            ArrayList<e0> arrayList = aVarH.f6742a;
            while (arrayList.size() > i11) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public int m() {
            int size = 0;
            for (int i10 = 0; i10 < this.f6740a.size(); i10++) {
                ArrayList<e0> arrayList = this.f6740a.valueAt(i10).f6742a;
                if (arrayList != null) {
                    size += arrayList.size();
                }
            }
            return size;
        }

        public boolean n(int i10, long j10, long j11) {
            long j12 = h(i10).f6745d;
            return j12 == 0 || j10 + j12 < j11;
        }

        public boolean o(int i10, long j10, long j11) {
            long j12 = h(i10).f6744c;
            return j12 == 0 || j10 + j12 < j11;
        }
    }

    public final class w {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f6746j = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<e0> f6747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<e0> f6748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<e0> f6749c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<e0> f6750d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6751e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6752f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public v f6753g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c0 f6754h;

        public w() {
            ArrayList<e0> arrayList = new ArrayList<>();
            this.f6747a = arrayList;
            this.f6748b = null;
            this.f6749c = new ArrayList<>();
            this.f6750d = Collections.unmodifiableList(arrayList);
            this.f6751e = 2;
            this.f6752f = 2;
        }

        public void A() {
            for (int size = this.f6749c.size() - 1; size >= 0; size--) {
                B(size);
            }
            this.f6749c.clear();
            if (RecyclerView.f6592t8) {
                RecyclerView.this.U7.b();
            }
        }

        public void B(int i10) {
            a(this.f6749c.get(i10), true);
            this.f6749c.remove(i10);
        }

        public void C(@n0 View view) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (e0VarU0.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (e0VarU0.isScrap()) {
                e0VarU0.unScrap();
            } else if (e0VarU0.wasReturnedFromScrap()) {
                e0VarU0.clearReturnedFromScrapFlag();
            }
            D(e0VarU0);
            if (RecyclerView.this.K2 == null || e0VarU0.isRecyclable()) {
                return;
            }
            RecyclerView.this.K2.k(e0VarU0);
        }

        public void D(e0 e0Var) {
            boolean z10;
            boolean z11 = true;
            if (e0Var.isScrap() || e0Var.itemView.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(e0Var.isScrap());
                sb2.append(" isAttached:");
                sb2.append(e0Var.itemView.getParent() != null);
                sb2.append(RecyclerView.this.X());
                throw new IllegalArgumentException(sb2.toString());
            }
            if (e0Var.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + e0Var + RecyclerView.this.X());
            }
            if (e0Var.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.X());
            }
            boolean zDoesTransientStatePreventRecycling = e0Var.doesTransientStatePreventRecycling();
            g gVar = RecyclerView.this.f6623l;
            if ((gVar != null && zDoesTransientStatePreventRecycling && gVar.onFailedToRecycleView(e0Var)) || e0Var.isRecyclable()) {
                if (this.f6752f <= 0 || e0Var.hasAnyOfTheFlags(gg.b.f29478q0)) {
                    z10 = false;
                } else {
                    int size = this.f6749c.size();
                    if (size >= this.f6752f && size > 0) {
                        B(0);
                        size--;
                    }
                    if (RecyclerView.f6592t8 && size > 0 && !RecyclerView.this.U7.d(e0Var.mPosition)) {
                        int i10 = size - 1;
                        while (i10 >= 0) {
                            if (!RecyclerView.this.U7.d(this.f6749c.get(i10).mPosition)) {
                                break;
                            } else {
                                i10--;
                            }
                        }
                        size = i10 + 1;
                    }
                    this.f6749c.add(size, e0Var);
                    z10 = true;
                }
                if (z10) {
                    z = z10;
                    z11 = false;
                } else {
                    a(e0Var, true);
                    z = z10;
                }
            } else {
                z11 = false;
            }
            RecyclerView.this.f6609f.q(e0Var);
            if (z || z11 || !zDoesTransientStatePreventRecycling) {
                return;
            }
            e0Var.mOwnerRecyclerView = null;
        }

        public void E(View view) {
            e0 e0VarU0 = RecyclerView.u0(view);
            if (!e0VarU0.hasAnyOfTheFlags(12) && e0VarU0.isUpdated() && !RecyclerView.this.x(e0VarU0)) {
                if (this.f6748b == null) {
                    this.f6748b = new ArrayList<>();
                }
                e0VarU0.setScrapContainer(this, true);
                this.f6748b.add(e0VarU0);
                return;
            }
            if (!e0VarU0.isInvalid() || e0VarU0.isRemoved() || RecyclerView.this.f6623l.hasStableIds()) {
                e0VarU0.setScrapContainer(this, false);
                this.f6747a.add(e0VarU0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.X());
            }
        }

        public void F(v vVar) {
            v vVar2 = this.f6753g;
            if (vVar2 != null) {
                vVar2.c();
            }
            this.f6753g = vVar;
            if (vVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f6753g.a();
        }

        public void G(c0 c0Var) {
            this.f6754h = c0Var;
        }

        public void H(int i10) {
            this.f6751e = i10;
            L();
        }

        public final boolean I(@n0 e0 e0Var, int i10, int i11, long j10) {
            e0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = e0Var.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j10 != Long.MAX_VALUE && !this.f6753g.n(itemViewType, nanoTime, j10)) {
                return false;
            }
            RecyclerView.this.f6623l.bindViewHolder(e0Var, i10);
            this.f6753g.d(e0Var.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(e0Var);
            if (!RecyclerView.this.V7.j()) {
                return true;
            }
            e0Var.mPreLayoutPosition = i11;
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0228 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x022b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0181 A[PHI: r1 r4
  0x0181: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$e0) = (r1v11 androidx.recyclerview.widget.RecyclerView$e0), (r1v31 androidx.recyclerview.widget.RecyclerView$e0) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x0181: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        @g.p0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.e0 J(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instruction units count: 615
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.w.J(int, boolean, long):androidx.recyclerview.widget.RecyclerView$e0");
        }

        public void K(e0 e0Var) {
            if (e0Var.mInChangeScrap) {
                this.f6748b.remove(e0Var);
            } else {
                this.f6747a.remove(e0Var);
            }
            e0Var.mScrapContainer = null;
            e0Var.mInChangeScrap = false;
            e0Var.clearReturnedFromScrapFlag();
        }

        public void L() {
            o oVar = RecyclerView.this.f6625m;
            this.f6752f = this.f6751e + (oVar != null ? oVar.f6723m : 0);
            for (int size = this.f6749c.size() - 1; size >= 0 && this.f6749c.size() > this.f6752f; size--) {
                B(size);
            }
        }

        public boolean M(e0 e0Var) {
            if (e0Var.isRemoved()) {
                return RecyclerView.this.V7.j();
            }
            int i10 = e0Var.mPosition;
            if (i10 >= 0 && i10 < RecyclerView.this.f6623l.getItemCount()) {
                if (RecyclerView.this.V7.j() || RecyclerView.this.f6623l.getItemViewType(e0Var.mPosition) == e0Var.getItemViewType()) {
                    return !RecyclerView.this.f6623l.hasStableIds() || e0Var.getItemId() == RecyclerView.this.f6623l.getItemId(e0Var.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + e0Var + RecyclerView.this.X());
        }

        public void N(int i10, int i11) {
            int i12;
            int i13 = i11 + i10;
            for (int size = this.f6749c.size() - 1; size >= 0; size--) {
                e0 e0Var = this.f6749c.get(size);
                if (e0Var != null && (i12 = e0Var.mPosition) >= i10 && i12 < i13) {
                    e0Var.addFlags(2);
                    B(size);
                }
            }
        }

        public void a(@n0 e0 e0Var, boolean z10) {
            RecyclerView.z(e0Var);
            View view = e0Var.itemView;
            androidx.recyclerview.widget.y yVar = RecyclerView.this.f6604c8;
            if (yVar != null) {
                androidx.core.view.a aVarN = yVar.n();
                u0.B1(view, aVarN instanceof y.a ? ((y.a) aVarN).n(view) : null);
            }
            if (z10) {
                h(e0Var);
            }
            e0Var.mOwnerRecyclerView = null;
            j().j(e0Var);
        }

        public final void b(e0 e0Var) {
            if (RecyclerView.this.L0()) {
                View view = e0Var.itemView;
                if (u0.V(view) == 0) {
                    u0.R1(view, 1);
                }
                androidx.recyclerview.widget.y yVar = RecyclerView.this.f6604c8;
                if (yVar == null) {
                    return;
                }
                androidx.core.view.a aVarN = yVar.n();
                if (aVarN instanceof y.a) {
                    ((y.a) aVarN).o(view);
                }
                u0.B1(view, aVarN);
            }
        }

        public void c(@n0 View view, int i10) {
            p pVar;
            e0 e0VarU0 = RecyclerView.u0(view);
            if (e0VarU0 == null) {
                throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.X());
            }
            int iN = RecyclerView.this.f6605d.n(i10);
            if (iN < 0 || iN >= RecyclerView.this.f6623l.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i10 + "(offset:" + iN + ").state:" + RecyclerView.this.V7.d() + RecyclerView.this.X());
            }
            I(e0VarU0, iN, i10, Long.MAX_VALUE);
            ViewGroup.LayoutParams layoutParams = e0VarU0.itemView.getLayoutParams();
            if (layoutParams == null) {
                pVar = (p) RecyclerView.this.generateDefaultLayoutParams();
                e0VarU0.itemView.setLayoutParams(pVar);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                pVar = (p) layoutParams;
            } else {
                pVar = (p) RecyclerView.this.generateLayoutParams(layoutParams);
                e0VarU0.itemView.setLayoutParams(pVar);
            }
            pVar.f6737c = true;
            pVar.f6735a = e0VarU0;
            pVar.f6738d = e0VarU0.itemView.getParent() == null;
        }

        public void d() {
            this.f6747a.clear();
            A();
        }

        public void e() {
            int size = this.f6749c.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f6749c.get(i10).clearOldPosition();
            }
            int size2 = this.f6747a.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f6747a.get(i11).clearOldPosition();
            }
            ArrayList<e0> arrayList = this.f6748b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    this.f6748b.get(i12).clearOldPosition();
                }
            }
        }

        public void f() {
            this.f6747a.clear();
            ArrayList<e0> arrayList = this.f6748b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int g(int i10) {
            if (i10 >= 0 && i10 < RecyclerView.this.V7.d()) {
                return !RecyclerView.this.V7.j() ? i10 : RecyclerView.this.f6605d.n(i10);
            }
            throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.V7.d() + RecyclerView.this.X());
        }

        public void h(@n0 e0 e0Var) {
            x xVar = RecyclerView.this.f6626n;
            if (xVar != null) {
                xVar.a(e0Var);
            }
            g gVar = RecyclerView.this.f6623l;
            if (gVar != null) {
                gVar.onViewRecycled(e0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.V7 != null) {
                recyclerView.f6609f.q(e0Var);
            }
        }

        public e0 i(int i10) {
            int size;
            int iN;
            ArrayList<e0> arrayList = this.f6748b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    e0 e0Var = this.f6748b.get(i11);
                    if (!e0Var.wasReturnedFromScrap() && e0Var.getLayoutPosition() == i10) {
                        e0Var.addFlags(32);
                        return e0Var;
                    }
                }
                if (RecyclerView.this.f6623l.hasStableIds() && (iN = RecyclerView.this.f6605d.n(i10)) > 0 && iN < RecyclerView.this.f6623l.getItemCount()) {
                    long itemId = RecyclerView.this.f6623l.getItemId(iN);
                    for (int i12 = 0; i12 < size; i12++) {
                        e0 e0Var2 = this.f6748b.get(i12);
                        if (!e0Var2.wasReturnedFromScrap() && e0Var2.getItemId() == itemId) {
                            e0Var2.addFlags(32);
                            return e0Var2;
                        }
                    }
                }
            }
            return null;
        }

        public v j() {
            if (this.f6753g == null) {
                this.f6753g = new v();
            }
            return this.f6753g;
        }

        public int k() {
            return this.f6747a.size();
        }

        @n0
        public List<e0> l() {
            return this.f6750d;
        }

        public e0 m(long j10, int i10, boolean z10) {
            for (int size = this.f6747a.size() - 1; size >= 0; size--) {
                e0 e0Var = this.f6747a.get(size);
                if (e0Var.getItemId() == j10 && !e0Var.wasReturnedFromScrap()) {
                    if (i10 == e0Var.getItemViewType()) {
                        e0Var.addFlags(32);
                        if (e0Var.isRemoved() && !RecyclerView.this.V7.j()) {
                            e0Var.setFlags(2, 14);
                        }
                        return e0Var;
                    }
                    if (!z10) {
                        this.f6747a.remove(size);
                        RecyclerView.this.removeDetachedView(e0Var.itemView, false);
                        z(e0Var.itemView);
                    }
                }
            }
            int size2 = this.f6749c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                e0 e0Var2 = this.f6749c.get(size2);
                if (e0Var2.getItemId() == j10 && !e0Var2.isAttachedToTransitionOverlay()) {
                    if (i10 == e0Var2.getItemViewType()) {
                        if (!z10) {
                            this.f6749c.remove(size2);
                        }
                        return e0Var2;
                    }
                    if (!z10) {
                        B(size2);
                        return null;
                    }
                }
            }
        }

        public e0 n(int i10, boolean z10) {
            View viewE;
            int size = this.f6747a.size();
            for (int i11 = 0; i11 < size; i11++) {
                e0 e0Var = this.f6747a.get(i11);
                if (!e0Var.wasReturnedFromScrap() && e0Var.getLayoutPosition() == i10 && !e0Var.isInvalid() && (RecyclerView.this.V7.f6670h || !e0Var.isRemoved())) {
                    e0Var.addFlags(32);
                    return e0Var;
                }
            }
            if (z10 || (viewE = RecyclerView.this.f6607e.e(i10)) == null) {
                int size2 = this.f6749c.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    e0 e0Var2 = this.f6749c.get(i12);
                    if (!e0Var2.isInvalid() && e0Var2.getLayoutPosition() == i10 && !e0Var2.isAttachedToTransitionOverlay()) {
                        if (!z10) {
                            this.f6749c.remove(i12);
                        }
                        return e0Var2;
                    }
                }
                return null;
            }
            e0 e0VarU0 = RecyclerView.u0(viewE);
            RecyclerView.this.f6607e.s(viewE);
            int iM = RecyclerView.this.f6607e.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f6607e.d(iM);
                E(viewE);
                e0VarU0.addFlags(8224);
                return e0VarU0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + e0VarU0 + RecyclerView.this.X());
        }

        public View o(int i10) {
            return this.f6747a.get(i10).itemView;
        }

        @n0
        public View p(int i10) {
            return q(i10, false);
        }

        public View q(int i10, boolean z10) {
            return J(i10, z10, Long.MAX_VALUE).itemView;
        }

        public final void r(ViewGroup viewGroup, boolean z10) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    r((ViewGroup) childAt, true);
                }
            }
            if (z10) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public final void s(e0 e0Var) {
            View view = e0Var.itemView;
            if (view instanceof ViewGroup) {
                r((ViewGroup) view, false);
            }
        }

        public void t() {
            int size = this.f6749c.size();
            for (int i10 = 0; i10 < size; i10++) {
                p pVar = (p) this.f6749c.get(i10).itemView.getLayoutParams();
                if (pVar != null) {
                    pVar.f6737c = true;
                }
            }
        }

        public void u() {
            int size = this.f6749c.size();
            for (int i10 = 0; i10 < size; i10++) {
                e0 e0Var = this.f6749c.get(i10);
                if (e0Var != null) {
                    e0Var.addFlags(6);
                    e0Var.addChangePayload(null);
                }
            }
            g gVar = RecyclerView.this.f6623l;
            if (gVar == null || !gVar.hasStableIds()) {
                A();
            }
        }

        public void v(int i10, int i11) {
            int size = this.f6749c.size();
            for (int i12 = 0; i12 < size; i12++) {
                e0 e0Var = this.f6749c.get(i12);
                if (e0Var != null && e0Var.mPosition >= i10) {
                    e0Var.offsetPosition(i11, true);
                }
            }
        }

        public void w(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (i10 < i11) {
                i12 = -1;
                i14 = i10;
                i13 = i11;
            } else {
                i12 = 1;
                i13 = i10;
                i14 = i11;
            }
            int size = this.f6749c.size();
            for (int i16 = 0; i16 < size; i16++) {
                e0 e0Var = this.f6749c.get(i16);
                if (e0Var != null && (i15 = e0Var.mPosition) >= i14 && i15 <= i13) {
                    if (i15 == i10) {
                        e0Var.offsetPosition(i11 - i10, false);
                    } else {
                        e0Var.offsetPosition(i12, false);
                    }
                }
            }
        }

        public void x(int i10, int i11, boolean z10) {
            int i12 = i10 + i11;
            for (int size = this.f6749c.size() - 1; size >= 0; size--) {
                e0 e0Var = this.f6749c.get(size);
                if (e0Var != null) {
                    int i13 = e0Var.mPosition;
                    if (i13 >= i12) {
                        e0Var.offsetPosition(-i11, z10);
                    } else if (i13 >= i10) {
                        e0Var.addFlags(8);
                        B(size);
                    }
                }
            }
        }

        public void y(g gVar, g gVar2, boolean z10) {
            d();
            j().i(gVar, gVar2, z10);
        }

        public void z(View view) {
            e0 e0VarU0 = RecyclerView.u0(view);
            e0VarU0.mScrapContainer = null;
            e0VarU0.mInChangeScrap = false;
            e0VarU0.clearReturnedFromScrapFlag();
            D(e0VarU0);
        }
    }

    public interface x {
        void a(@n0 e0 e0Var);
    }

    public class y extends i {
        public y() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.w(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.V7.f6669g = true;
            recyclerView.j1(true);
            if (RecyclerView.this.f6605d.q()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.w(null);
            if (RecyclerView.this.f6605d.s(i10, i11, obj)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            RecyclerView.this.w(null);
            if (RecyclerView.this.f6605d.t(i10, i11)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i10, int i11, int i12) {
            RecyclerView.this.w(null);
            if (RecyclerView.this.f6605d.u(i10, i11, i12)) {
                g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i10, int i11) {
            RecyclerView.this.w(null);
            if (RecyclerView.this.f6605d.v(i10, i11)) {
                g();
            }
        }

        public void g() {
            if (RecyclerView.f6591s8) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f6631s && recyclerView.f6630r) {
                    u0.p1(recyclerView, recyclerView.f6613h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.A = true;
            recyclerView2.requestLayout();
        }
    }

    public static class z implements s {
        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean onInterceptTouchEvent(@n0 RecyclerView recyclerView, @n0 MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onRequestDisallowInterceptTouchEvent(boolean z10) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onTouchEvent(@n0 RecyclerView recyclerView, @n0 MotionEvent motionEvent) {
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f6589q8 = false;
        f6590r8 = i10 >= 23;
        f6591s8 = true;
        f6592t8 = true;
        f6593u8 = false;
        f6594v8 = false;
        Class<?> cls = Integer.TYPE;
        P8 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        V8 = new c();
    }

    public RecyclerView(@n0 Context context) {
        this(context, null);
    }

    @p0
    public static RecyclerView e0(@n0 View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView recyclerViewE0 = e0(viewGroup.getChildAt(i10));
            if (recyclerViewE0 != null) {
                return recyclerViewE0;
            }
        }
        return null;
    }

    private androidx.core.view.f0 getScrollingChildHelper() {
        if (this.f6610f8 == null) {
            this.f6610f8 = new androidx.core.view.f0(this);
        }
        return this.f6610f8;
    }

    public static e0 u0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f6735a;
    }

    public static void w0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f6736b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    public static void z(@n0 e0 e0Var) {
        WeakReference<RecyclerView> weakReference = e0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == e0Var.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            e0Var.mNestedRecyclerView = null;
        }
    }

    public void A() {
        int iJ = this.f6607e.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            e0 e0VarU0 = u0(this.f6607e.i(i10));
            if (!e0VarU0.shouldIgnore()) {
                e0VarU0.clearOldPosition();
            }
        }
        this.f6601b.e();
    }

    @n0
    public n A0(int i10) {
        int itemDecorationCount = getItemDecorationCount();
        if (i10 >= 0 && i10 < itemDecorationCount) {
            return this.f6627o.get(i10);
        }
        throw new IndexOutOfBoundsException(i10 + " is an invalid index for size " + itemDecorationCount);
    }

    public void A1() {
        int iJ = this.f6607e.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            e0 e0VarU0 = u0(this.f6607e.i(i10));
            if (!e0VarU0.shouldIgnore()) {
                e0VarU0.saveOldPosition();
            }
        }
    }

    public void B() {
        List<q> list = this.C;
        if (list != null) {
            list.clear();
        }
    }

    public final void B0(long j10, e0 e0Var, e0 e0Var2) {
        int iG = this.f6607e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            e0 e0VarU0 = u0(this.f6607e.f(i10));
            if (e0VarU0 != e0Var && o0(e0VarU0) == j10) {
                g gVar = this.f6623l;
                if (gVar == null || !gVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + e0VarU0 + " \n View Holder 2:" + e0Var + X());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + e0VarU0 + " \n View Holder 2:" + e0Var + X());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb2.append(e0Var2);
        sb2.append(" cannot be found but it is necessary for ");
        sb2.append(e0Var);
        sb2.append(X());
    }

    public boolean B1(int i10, int i11, MotionEvent motionEvent) {
        int i12;
        int i13;
        int i14;
        int i15;
        E();
        if (this.f6623l != null) {
            int[] iArr = this.f6616i8;
            iArr[0] = 0;
            iArr[1] = 0;
            C1(i10, i11, iArr);
            int[] iArr2 = this.f6616i8;
            int i16 = iArr2[0];
            int i17 = iArr2[1];
            i12 = i17;
            i13 = i16;
            i14 = i10 - i16;
            i15 = i11 - i17;
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
        }
        if (!this.f6627o.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f6616i8;
        iArr3[0] = 0;
        iArr3[1] = 0;
        c(i13, i12, i14, i15, this.f6612g8, 0, iArr3);
        int[] iArr4 = this.f6616i8;
        int i18 = i14 - iArr4[0];
        int i19 = i15 - iArr4[1];
        boolean z10 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i20 = this.J7;
        int[] iArr5 = this.f6612g8;
        this.J7 = i20 - iArr5[0];
        this.K7 -= iArr5[1];
        int[] iArr6 = this.f6614h8;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.view.b0.l(motionEvent, 8194)) {
                k1(motionEvent.getX(), i18, motionEvent.getY(), i19);
            }
            D(i10, i11);
        }
        if (i13 != 0 || i12 != 0) {
            Q(i13, i12);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z10 && i13 == 0 && i12 == 0) ? false : true;
    }

    public void C() {
        List<t> list = this.X7;
        if (list != null) {
            list.clear();
        }
    }

    public boolean C0() {
        return this.f6631s;
    }

    public void C1(int i10, int i11, @p0 int[] iArr) {
        M1();
        a1();
        androidx.core.os.y.b(H8);
        Y(this.V7);
        int iQ1 = i10 != 0 ? this.f6625m.Q1(i10, this.f6601b, this.V7) : 0;
        int iS1 = i11 != 0 ? this.f6625m.S1(i11, this.f6601b, this.V7) : 0;
        androidx.core.os.y.d();
        v1();
        b1();
        N1(false);
        if (iArr != null) {
            iArr[0] = iQ1;
            iArr[1] = iS1;
        }
    }

    public void D(int i10, int i11) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.C1;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            zIsFinished = false;
        } else {
            this.C1.onRelease();
            zIsFinished = this.C1.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f6636v2;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.f6636v2.onRelease();
            zIsFinished |= this.f6636v2.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K1;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.K1.onRelease();
            zIsFinished |= this.K1.isFinished();
        }
        EdgeEffect edgeEffect4 = this.C2;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.C2.onRelease();
            zIsFinished |= this.C2.isFinished();
        }
        if (zIsFinished) {
            u0.n1(this);
        }
    }

    public boolean D0() {
        return !this.f6633u || this.D || this.f6605d.q();
    }

    public void D1(int i10) {
        if (this.f6638x) {
            return;
        }
        O1();
        o oVar = this.f6625m;
        if (oVar == null) {
            return;
        }
        oVar.R1(i10);
        awakenScrollBars();
    }

    public void E() {
        if (!this.f6633u || this.D) {
            androidx.core.os.y.b(J8);
            L();
            androidx.core.os.y.d();
            return;
        }
        if (this.f6605d.q()) {
            if (!this.f6605d.p(4) || this.f6605d.p(11)) {
                if (this.f6605d.q()) {
                    androidx.core.os.y.b(J8);
                    L();
                    androidx.core.os.y.d();
                    return;
                }
                return;
            }
            androidx.core.os.y.b(K8);
            M1();
            a1();
            this.f6605d.x();
            if (!this.f6637w) {
                if (E0()) {
                    L();
                } else {
                    this.f6605d.j();
                }
            }
            N1(true);
            b1();
            androidx.core.os.y.d();
        }
    }

    public final boolean E0() {
        int iG = this.f6607e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            e0 e0VarU0 = u0(this.f6607e.f(i10));
            if (e0VarU0 != null && !e0VarU0.shouldIgnore() && e0VarU0.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    public final void E1(@p0 g gVar, boolean z10, boolean z11) {
        g gVar2 = this.f6623l;
        if (gVar2 != null) {
            gVar2.unregisterAdapterDataObserver(this.f6599a);
            this.f6623l.onDetachedFromRecyclerView(this);
        }
        if (!z10 || z11) {
            o1();
        }
        this.f6605d.z();
        g gVar3 = this.f6623l;
        this.f6623l = gVar;
        if (gVar != null) {
            gVar.registerAdapterDataObserver(this.f6599a);
            gVar.onAttachedToRecyclerView(this);
        }
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.X0(gVar3, this.f6623l);
        }
        this.f6601b.y(gVar3, this.f6623l, z10);
        this.V7.f6669g = true;
    }

    public final void F(Context context, String str, AttributeSet attributeSet, int i10, int i11) {
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strY0 = y0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strY0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(P8);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11)};
                } catch (NoSuchMethodException e10) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e11) {
                        e11.initCause(e10);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strY0, e11);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strY0, e12);
            } catch (ClassNotFoundException e13) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strY0, e13);
            } catch (IllegalAccessException e14) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strY0, e14);
            } catch (InstantiationException e15) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strY0, e15);
            } catch (InvocationTargetException e16) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strY0, e16);
            }
        }
    }

    public void F0() {
        this.f6605d = new androidx.recyclerview.widget.a(new f());
    }

    @i1
    public boolean F1(e0 e0Var, int i10) {
        if (!N0()) {
            u0.R1(e0Var.itemView, i10);
            return true;
        }
        e0Var.mPendingAccessibilityState = i10;
        this.f6618j8.add(e0Var);
        return false;
    }

    public void G(int i10, int i11) {
        setMeasuredDimension(o.y(i10, getPaddingLeft() + getPaddingRight(), u0.f0(this)), o.y(i11, getPaddingTop() + getPaddingBottom(), u0.e0(this)));
    }

    @SuppressLint({"InlinedApi"})
    public final void G0() {
        if (u0.W(this) == 0) {
            u0.S1(this, 8);
        }
    }

    public boolean G1(AccessibilityEvent accessibilityEvent) {
        if (!N0()) {
            return false;
        }
        int iD = accessibilityEvent != null ? a1.b.d(accessibilityEvent) : 0;
        this.f6640z |= iD != 0 ? iD : 0;
        return true;
    }

    public final boolean H(int i10, int i11) {
        d0(this.f6608e8);
        int[] iArr = this.f6608e8;
        return (iArr[0] == i10 && iArr[1] == i11) ? false : true;
    }

    public final void H0() {
        this.f6607e = new androidx.recyclerview.widget.g(new e());
    }

    public void H1(@t0 int i10, @t0 int i11) {
        I1(i10, i11, null);
    }

    public void I(View view) {
        e0 e0VarU0 = u0(view);
        Y0(view);
        g gVar = this.f6623l;
        if (gVar != null && e0VarU0 != null) {
            gVar.onViewAttachedToWindow(e0VarU0);
        }
        List<q> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).b(view);
            }
        }
    }

    @i1
    public void I0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.k(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + X());
        }
    }

    public void I1(@t0 int i10, @t0 int i11, @p0 Interpolator interpolator) {
        J1(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    public void J(View view) {
        e0 e0VarU0 = u0(view);
        Z0(view);
        g gVar = this.f6623l;
        if (gVar != null && e0VarU0 != null) {
            gVar.onViewDetachedFromWindow(e0VarU0);
        }
        List<q> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).a(view);
            }
        }
    }

    public void J0() {
        this.C2 = null;
        this.K1 = null;
        this.f6636v2 = null;
        this.C1 = null;
    }

    public void J1(@t0 int i10, @t0 int i11, @p0 Interpolator interpolator, int i12) {
        K1(i10, i11, interpolator, i12, false);
    }

    public final void K() {
        int i10 = this.f6640z;
        this.f6640z = 0;
        if (i10 == 0 || !L0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        a1.b.i(accessibilityEventObtain, i10);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public void K0() {
        if (this.f6627o.size() == 0) {
            return;
        }
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.q("Cannot invalidate item decorations during a scroll or layout");
        }
        R0();
        requestLayout();
    }

    public void K1(@t0 int i10, @t0 int i11, @p0 Interpolator interpolator, int i12, boolean z10) {
        o oVar = this.f6625m;
        if (oVar == null || this.f6638x) {
            return;
        }
        if (!oVar.v()) {
            i10 = 0;
        }
        if (!this.f6625m.w()) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        if (!(i12 == Integer.MIN_VALUE || i12 > 0)) {
            scrollBy(i10, i11);
            return;
        }
        if (z10) {
            int i13 = i10 != 0 ? 1 : 0;
            if (i11 != 0) {
                i13 |= 2;
            }
            f(i13, 1);
        }
        this.S7.f(i10, i11, i12, interpolator);
    }

    public void L() {
        if (this.f6623l == null || this.f6625m == null) {
            return;
        }
        b0 b0Var = this.V7;
        b0Var.f6672j = false;
        if (b0Var.f6667e == 1) {
            M();
            this.f6625m.U1(this);
            N();
        } else if (!this.f6605d.r() && this.f6625m.B0() == getWidth() && this.f6625m.m0() == getHeight()) {
            this.f6625m.U1(this);
        } else {
            this.f6625m.U1(this);
            N();
        }
        O();
    }

    public boolean L0() {
        AccessibilityManager accessibilityManager = this.B;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void L1(int i10) {
        o oVar;
        if (this.f6638x || (oVar = this.f6625m) == null) {
            return;
        }
        oVar.f2(this, this.V7, i10);
    }

    public final void M() {
        this.V7.a(1);
        Y(this.V7);
        this.V7.f6672j = false;
        M1();
        this.f6609f.f();
        a1();
        i1();
        z1();
        b0 b0Var = this.V7;
        b0Var.f6671i = b0Var.f6673k && this.Z7;
        this.Z7 = false;
        this.Y7 = false;
        b0Var.f6670h = b0Var.f6674l;
        b0Var.f6668f = this.f6623l.getItemCount();
        d0(this.f6608e8);
        if (this.V7.f6673k) {
            int iG = this.f6607e.g();
            for (int i10 = 0; i10 < iG; i10++) {
                e0 e0VarU0 = u0(this.f6607e.f(i10));
                if (!e0VarU0.shouldIgnore() && (!e0VarU0.isInvalid() || this.f6623l.hasStableIds())) {
                    this.f6609f.e(e0VarU0, this.K2.w(this.V7, e0VarU0, l.e(e0VarU0), e0VarU0.getUnmodifiedPayloads()));
                    if (this.V7.f6671i && e0VarU0.isUpdated() && !e0VarU0.isRemoved() && !e0VarU0.shouldIgnore() && !e0VarU0.isInvalid()) {
                        this.f6609f.c(o0(e0VarU0), e0VarU0);
                    }
                }
            }
        }
        if (this.V7.f6674l) {
            A1();
            b0 b0Var2 = this.V7;
            boolean z10 = b0Var2.f6669g;
            b0Var2.f6669g = false;
            this.f6625m.q1(this.f6601b, b0Var2);
            this.V7.f6669g = z10;
            for (int i11 = 0; i11 < this.f6607e.g(); i11++) {
                e0 e0VarU02 = u0(this.f6607e.f(i11));
                if (!e0VarU02.shouldIgnore() && !this.f6609f.i(e0VarU02)) {
                    int iE = l.e(e0VarU02);
                    boolean zHasAnyOfTheFlags = e0VarU02.hasAnyOfTheFlags(8192);
                    if (!zHasAnyOfTheFlags) {
                        iE |= 4096;
                    }
                    l.d dVarW = this.K2.w(this.V7, e0VarU02, iE, e0VarU02.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        l1(e0VarU02, dVarW);
                    } else {
                        this.f6609f.a(e0VarU02, dVarW);
                    }
                }
            }
            A();
        } else {
            A();
        }
        b1();
        N1(false);
        this.V7.f6667e = 2;
    }

    public boolean M0() {
        l lVar = this.K2;
        return lVar != null && lVar.q();
    }

    public void M1() {
        int i10 = this.f6634v + 1;
        this.f6634v = i10;
        if (i10 != 1 || this.f6638x) {
            return;
        }
        this.f6637w = false;
    }

    public final void N() {
        M1();
        a1();
        this.V7.a(6);
        this.f6605d.k();
        this.V7.f6668f = this.f6623l.getItemCount();
        b0 b0Var = this.V7;
        b0Var.f6666d = 0;
        b0Var.f6670h = false;
        this.f6625m.q1(this.f6601b, b0Var);
        b0 b0Var2 = this.V7;
        b0Var2.f6669g = false;
        this.f6603c = null;
        b0Var2.f6673k = b0Var2.f6673k && this.K2 != null;
        b0Var2.f6667e = 4;
        b1();
        N1(false);
    }

    public boolean N0() {
        return this.K0 > 0;
    }

    public void N1(boolean z10) {
        if (this.f6634v < 1) {
            this.f6634v = 1;
        }
        if (!z10 && !this.f6638x) {
            this.f6637w = false;
        }
        if (this.f6634v == 1) {
            if (z10 && this.f6637w && !this.f6638x && this.f6625m != null && this.f6623l != null) {
                L();
            }
            if (!this.f6638x) {
                this.f6637w = false;
            }
        }
        this.f6634v--;
    }

    public final void O() {
        this.V7.a(4);
        M1();
        a1();
        b0 b0Var = this.V7;
        b0Var.f6667e = 1;
        if (b0Var.f6673k) {
            for (int iG = this.f6607e.g() - 1; iG >= 0; iG--) {
                e0 e0VarU0 = u0(this.f6607e.f(iG));
                if (!e0VarU0.shouldIgnore()) {
                    long jO0 = o0(e0VarU0);
                    l.d dVarV = this.K2.v(this.V7, e0VarU0);
                    e0 e0VarG = this.f6609f.g(jO0);
                    if (e0VarG == null || e0VarG.shouldIgnore()) {
                        this.f6609f.d(e0VarU0, dVarV);
                    } else {
                        boolean zH = this.f6609f.h(e0VarG);
                        boolean zH2 = this.f6609f.h(e0VarU0);
                        if (zH && e0VarG == e0VarU0) {
                            this.f6609f.d(e0VarU0, dVarV);
                        } else {
                            l.d dVarN = this.f6609f.n(e0VarG);
                            this.f6609f.d(e0VarU0, dVarV);
                            l.d dVarM = this.f6609f.m(e0VarU0);
                            if (dVarN == null) {
                                B0(jO0, e0VarU0, e0VarG);
                            } else {
                                t(e0VarG, e0VarU0, dVarN, dVarM, zH, zH2);
                            }
                        }
                    }
                }
            }
            this.f6609f.o(this.f6624l8);
        }
        this.f6625m.F1(this.f6601b);
        b0 b0Var2 = this.V7;
        b0Var2.f6665c = b0Var2.f6668f;
        this.D = false;
        this.f6620k0 = false;
        b0Var2.f6673k = false;
        b0Var2.f6674l = false;
        this.f6625m.f6718h = false;
        ArrayList<e0> arrayList = this.f6601b.f6748b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.f6625m;
        if (oVar.f6724n) {
            oVar.f6723m = 0;
            oVar.f6724n = false;
            this.f6601b.L();
        }
        this.f6625m.r1(this.V7);
        b1();
        N1(false);
        this.f6609f.f();
        int[] iArr = this.f6608e8;
        if (H(iArr[0], iArr[1])) {
            Q(0, 0);
        }
        m1();
        x1();
    }

    @Deprecated
    public boolean O0() {
        return isLayoutSuppressed();
    }

    public void O1() {
        setScrollState(0);
        P1();
    }

    public void P(int i10) {
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.x1(i10);
        }
        e1(i10);
        t tVar = this.W7;
        if (tVar != null) {
            tVar.a(this, i10);
        }
        List<t> list = this.X7;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.X7.get(size).a(this, i10);
            }
        }
    }

    public final boolean P0(View view, View view2, int i10) {
        int i11;
        if (view2 == null || view2 == this || a0(view2) == null) {
            return false;
        }
        if (view == null || a0(view) == null) {
            return true;
        }
        this.f6615i.set(0, 0, view.getWidth(), view.getHeight());
        this.f6617j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f6615i);
        offsetDescendantRectToMyCoords(view2, this.f6617j);
        byte b10 = -1;
        int i12 = this.f6625m.q0() == 1 ? -1 : 1;
        Rect rect = this.f6615i;
        int i13 = rect.left;
        Rect rect2 = this.f6617j;
        int i14 = rect2.left;
        if ((i13 < i14 || rect.right <= i14) && rect.right < rect2.right) {
            i11 = 1;
        } else {
            int i15 = rect.right;
            int i16 = rect2.right;
            i11 = ((i15 > i16 || i13 >= i16) && i13 > i14) ? -1 : 0;
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
            b10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                b10 = 0;
            }
        }
        if (i10 == 1) {
            return b10 < 0 || (b10 == 0 && i11 * i12 <= 0);
        }
        if (i10 == 2) {
            return b10 > 0 || (b10 == 0 && i11 * i12 >= 0);
        }
        if (i10 == 17) {
            return i11 < 0;
        }
        if (i10 == 33) {
            return b10 < 0;
        }
        if (i10 == 66) {
            return i11 > 0;
        }
        if (i10 == 130) {
            return b10 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i10 + X());
    }

    public final void P1() {
        this.S7.stop();
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.i2();
        }
    }

    public void Q(int i10, int i11) {
        this.f6621k1++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        f1(i10, i11);
        t tVar = this.W7;
        if (tVar != null) {
            tVar.b(this, i10, i11);
        }
        List<t> list = this.X7;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.X7.get(size).b(this, i10, i11);
            }
        }
        this.f6621k1--;
    }

    public void Q0(int i10) {
        if (this.f6625m == null) {
            return;
        }
        setScrollState(2);
        this.f6625m.R1(i10);
        awakenScrollBars();
    }

    public void Q1(@p0 g gVar, boolean z10) {
        setLayoutFrozen(false);
        E1(gVar, true, z10);
        j1(true);
        requestLayout();
    }

    public void R() {
        int i10;
        for (int size = this.f6618j8.size() - 1; size >= 0; size--) {
            e0 e0Var = this.f6618j8.get(size);
            if (e0Var.itemView.getParent() == this && !e0Var.shouldIgnore() && (i10 = e0Var.mPendingAccessibilityState) != -1) {
                u0.R1(e0Var.itemView, i10);
                e0Var.mPendingAccessibilityState = -1;
            }
        }
        this.f6618j8.clear();
    }

    public void R0() {
        int iJ = this.f6607e.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            ((p) this.f6607e.i(i10).getLayoutParams()).f6737c = true;
        }
        this.f6601b.t();
    }

    public void R1(int i10, int i11, Object obj) {
        int i12;
        int iJ = this.f6607e.j();
        int i13 = i10 + i11;
        for (int i14 = 0; i14 < iJ; i14++) {
            View viewI = this.f6607e.i(i14);
            e0 e0VarU0 = u0(viewI);
            if (e0VarU0 != null && !e0VarU0.shouldIgnore() && (i12 = e0VarU0.mPosition) >= i10 && i12 < i13) {
                e0VarU0.addFlags(2);
                e0VarU0.addChangePayload(obj);
                ((p) viewI.getLayoutParams()).f6737c = true;
            }
        }
        this.f6601b.N(i10, i11);
    }

    public final boolean S(MotionEvent motionEvent) {
        s sVar = this.f6629q;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return c0(motionEvent);
        }
        sVar.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f6629q = null;
        }
        return true;
    }

    public void S0() {
        int iJ = this.f6607e.j();
        for (int i10 = 0; i10 < iJ; i10++) {
            e0 e0VarU0 = u0(this.f6607e.i(i10));
            if (e0VarU0 != null && !e0VarU0.shouldIgnore()) {
                e0VarU0.addFlags(6);
            }
        }
        R0();
        this.f6601b.u();
    }

    public void T() {
        if (this.C2 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f6635v1.a(this, 3);
        this.C2 = edgeEffectA;
        if (this.f6611g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void T0(@t0 int i10) {
        int iG = this.f6607e.g();
        for (int i11 = 0; i11 < iG; i11++) {
            this.f6607e.f(i11).offsetLeftAndRight(i10);
        }
    }

    public void U() {
        if (this.C1 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f6635v1.a(this, 0);
        this.C1 = edgeEffectA;
        if (this.f6611g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void U0(@t0 int i10) {
        int iG = this.f6607e.g();
        for (int i11 = 0; i11 < iG; i11++) {
            this.f6607e.f(i11).offsetTopAndBottom(i10);
        }
    }

    public void V() {
        if (this.f6636v2 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f6635v1.a(this, 2);
        this.f6636v2 = edgeEffectA;
        if (this.f6611g) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void V0(int i10, int i11) {
        int iJ = this.f6607e.j();
        for (int i12 = 0; i12 < iJ; i12++) {
            e0 e0VarU0 = u0(this.f6607e.i(i12));
            if (e0VarU0 != null && !e0VarU0.shouldIgnore() && e0VarU0.mPosition >= i10) {
                e0VarU0.offsetPosition(i11, false);
                this.V7.f6669g = true;
            }
        }
        this.f6601b.v(i10, i11);
        requestLayout();
    }

    public void W() {
        if (this.K1 != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f6635v1.a(this, 1);
        this.K1 = edgeEffectA;
        if (this.f6611g) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void W0(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int iJ = this.f6607e.j();
        if (i10 < i11) {
            i14 = -1;
            i13 = i10;
            i12 = i11;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i16 = 0; i16 < iJ; i16++) {
            e0 e0VarU0 = u0(this.f6607e.i(i16));
            if (e0VarU0 != null && (i15 = e0VarU0.mPosition) >= i13 && i15 <= i12) {
                if (i15 == i10) {
                    e0VarU0.offsetPosition(i11 - i10, false);
                } else {
                    e0VarU0.offsetPosition(i14, false);
                }
                this.V7.f6669g = true;
            }
        }
        this.f6601b.w(i10, i11);
        requestLayout();
    }

    public String X() {
        return i0.f11861z + super.toString() + ", adapter:" + this.f6623l + ", layout:" + this.f6625m + ", context:" + getContext();
    }

    public void X0(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int iJ = this.f6607e.j();
        for (int i13 = 0; i13 < iJ; i13++) {
            e0 e0VarU0 = u0(this.f6607e.i(i13));
            if (e0VarU0 != null && !e0VarU0.shouldIgnore()) {
                int i14 = e0VarU0.mPosition;
                if (i14 >= i12) {
                    e0VarU0.offsetPosition(-i11, z10);
                    this.V7.f6669g = true;
                } else if (i14 >= i10) {
                    e0VarU0.flagRemovedAndOffsetPosition(i10 - 1, -i11, z10);
                    this.V7.f6669g = true;
                }
            }
        }
        this.f6601b.x(i10, i11, z10);
        requestLayout();
    }

    public final void Y(b0 b0Var) {
        if (getScrollState() != 2) {
            b0Var.f6678p = 0;
            b0Var.f6679q = 0;
        } else {
            OverScroller overScroller = this.S7.f6683c;
            b0Var.f6678p = overScroller.getFinalX() - overScroller.getCurrX();
            b0Var.f6679q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public void Y0(@n0 View view) {
    }

    @p0
    public View Z(float f10, float f11) {
        for (int iG = this.f6607e.g() - 1; iG >= 0; iG--) {
            View viewF = this.f6607e.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f10 >= viewF.getLeft() + translationX && f10 <= viewF.getRight() + translationX && f11 >= viewF.getTop() + translationY && f11 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    public void Z0(@n0 View view) {
    }

    @Override // androidx.core.view.c0
    public boolean a(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return getScrollingChildHelper().g(i10, i11, i12, i13, iArr, i14);
    }

    @p0
    public View a0(@n0 View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public void a1() {
        this.K0++;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        o oVar = this.f6625m;
        if (oVar == null || !oVar.Y0(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    @Override // androidx.core.view.c0
    public boolean b(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().d(i10, i11, iArr, iArr2, i12);
    }

    @p0
    public e0 b0(@n0 View view) {
        View viewA0 = a0(view);
        if (viewA0 == null) {
            return null;
        }
        return t0(viewA0);
    }

    public void b1() {
        c1(true);
    }

    @Override // androidx.core.view.d0
    public final void c(int i10, int i11, int i12, int i13, int[] iArr, int i14, @n0 int[] iArr2) {
        getScrollingChildHelper().e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public final boolean c0(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f6628p.size();
        for (int i10 = 0; i10 < size; i10++) {
            s sVar = this.f6628p.get(i10);
            if (sVar.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.f6629q = sVar;
                return true;
            }
        }
        return false;
    }

    public void c1(boolean z10) {
        int i10 = this.K0 - 1;
        this.K0 = i10;
        if (i10 < 1) {
            this.K0 = 0;
            if (z10) {
                K();
                R();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f6625m.x((p) layoutParams);
    }

    @Override // android.view.View, androidx.core.view.q0
    public int computeHorizontalScrollExtent() {
        o oVar = this.f6625m;
        if (oVar != null && oVar.v()) {
            return this.f6625m.B(this.V7);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.q0
    public int computeHorizontalScrollOffset() {
        o oVar = this.f6625m;
        if (oVar != null && oVar.v()) {
            return this.f6625m.C(this.V7);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.q0
    public int computeHorizontalScrollRange() {
        o oVar = this.f6625m;
        if (oVar != null && oVar.v()) {
            return this.f6625m.D(this.V7);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.q0
    public int computeVerticalScrollExtent() {
        o oVar = this.f6625m;
        if (oVar != null && oVar.w()) {
            return this.f6625m.E(this.V7);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.q0
    public int computeVerticalScrollOffset() {
        o oVar = this.f6625m;
        if (oVar != null && oVar.w()) {
            return this.f6625m.F(this.V7);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.q0
    public int computeVerticalScrollRange() {
        o oVar = this.f6625m;
        if (oVar != null && oVar.w()) {
            return this.f6625m.G(this.V7);
        }
        return 0;
    }

    @Override // androidx.core.view.c0
    public boolean d(int i10) {
        return getScrollingChildHelper().l(i10);
    }

    public final void d0(int[] iArr) {
        int iG = this.f6607e.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < iG; i12++) {
            e0 e0VarU0 = u0(this.f6607e.f(i12));
            if (!e0VarU0.shouldIgnore()) {
                int layoutPosition = e0VarU0.getLayoutPosition();
                if (layoutPosition < i10) {
                    i10 = layoutPosition;
                }
                if (layoutPosition > i11) {
                    i11 = layoutPosition;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public final void d1(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.F7) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.F7 = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.J7 = x10;
            this.H7 = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.K7 = y10;
            this.I7 = y10;
        }
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        int size = this.f6627o.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            this.f6627o.get(i10).h(canvas, this, this.V7);
        }
        EdgeEffect edgeEffect = this.C1;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f6611g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.C1;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.K1;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f6611g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K1;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f6636v2;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f6611g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f6636v2;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.C2;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f6611g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.C2;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(iSave4);
        }
        if ((z10 || this.K2 == null || this.f6627o.size() <= 0 || !this.K2.q()) ? z10 : true) {
            u0.n1(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public void e1(int i10) {
    }

    @Override // androidx.core.view.c0
    public boolean f(int i10, int i11) {
        return getScrollingChildHelper().s(i10, i11);
    }

    @p0
    public final View f0() {
        e0 e0VarG0;
        b0 b0Var = this.V7;
        int i10 = b0Var.f6675m;
        if (i10 == -1) {
            i10 = 0;
        }
        int iD = b0Var.d();
        for (int i11 = i10; i11 < iD; i11++) {
            e0 e0VarG02 = g0(i11);
            if (e0VarG02 == null) {
                break;
            }
            if (e0VarG02.itemView.hasFocusable()) {
                return e0VarG02.itemView;
            }
        }
        int iMin = Math.min(iD, i10);
        do {
            iMin--;
            if (iMin < 0 || (e0VarG0 = g0(iMin)) == null) {
                return null;
            }
        } while (!e0VarG0.itemView.hasFocusable());
        return e0VarG0.itemView;
    }

    public void f1(@t0 int i10, @t0 int i11) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View viewC1;
        boolean z10;
        View viewJ1 = this.f6625m.j1(view, i10);
        if (viewJ1 != null) {
            return viewJ1;
        }
        boolean z11 = (this.f6623l == null || this.f6625m == null || N0() || this.f6638x) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z11 && (i10 == 2 || i10 == 1)) {
            if (this.f6625m.w()) {
                int i11 = i10 == 2 ? 130 : 33;
                z10 = focusFinder.findNextFocus(this, view, i11) == null;
                if (f6593u8) {
                    i10 = i11;
                }
            } else {
                z10 = false;
            }
            if (!z10 && this.f6625m.v()) {
                int i12 = (this.f6625m.q0() == 1) ^ (i10 == 2) ? 66 : 17;
                boolean z12 = focusFinder.findNextFocus(this, view, i12) == null;
                if (f6593u8) {
                    i10 = i12;
                }
                z10 = z12;
            }
            if (z10) {
                E();
                if (a0(view) == null) {
                    return null;
                }
                M1();
                this.f6625m.c1(view, i10, this.f6601b, this.V7);
                N1(false);
            }
            viewC1 = focusFinder.findNextFocus(this, view, i10);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i10);
            if (viewFindNextFocus == null && z11) {
                E();
                if (a0(view) == null) {
                    return null;
                }
                M1();
                viewC1 = this.f6625m.c1(view, i10, this.f6601b, this.V7);
                N1(false);
            } else {
                viewC1 = viewFindNextFocus;
            }
        }
        if (viewC1 == null || viewC1.hasFocusable()) {
            return P0(view, viewC1, i10) ? viewC1 : super.focusSearch(view, i10);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i10);
        }
        w1(viewC1, null);
        return view;
    }

    @Override // androidx.core.view.c0
    public void g(int i10) {
        getScrollingChildHelper().u(i10);
    }

    @p0
    public e0 g0(int i10) {
        e0 e0Var = null;
        if (this.D) {
            return null;
        }
        int iJ = this.f6607e.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            e0 e0VarU0 = u0(this.f6607e.i(i11));
            if (e0VarU0 != null && !e0VarU0.isRemoved() && n0(e0VarU0) == i10) {
                if (!this.f6607e.n(e0VarU0.itemView)) {
                    return e0VarU0;
                }
                e0Var = e0VarU0;
            }
        }
        return e0Var;
    }

    public void g1() {
        if (this.f6602b8 || !this.f6630r) {
            return;
        }
        u0.p1(this, this.f6622k8);
        this.f6602b8 = true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f6625m;
        if (oVar != null) {
            return oVar.S();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + X());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f6625m;
        if (oVar != null) {
            return oVar.T(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + X());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @p0
    public g getAdapter() {
        return this.f6623l;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f6625m;
        return oVar != null ? oVar.V() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        j jVar = this.f6606d8;
        return jVar == null ? super.getChildDrawingOrder(i10, i11) : jVar.a(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f6611g;
    }

    @p0
    public androidx.recyclerview.widget.y getCompatAccessibilityDelegate() {
        return this.f6604c8;
    }

    @n0
    public k getEdgeEffectFactory() {
        return this.f6635v1;
    }

    @p0
    public l getItemAnimator() {
        return this.K2;
    }

    public int getItemDecorationCount() {
        return this.f6627o.size();
    }

    @p0
    public o getLayoutManager() {
        return this.f6625m;
    }

    public int getMaxFlingVelocity() {
        return this.O7;
    }

    public int getMinFlingVelocity() {
        return this.N7;
    }

    long getNanoTime() {
        if (f6592t8) {
            return System.nanoTime();
        }
        return 0L;
    }

    @p0
    public r getOnFlingListener() {
        return this.M7;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.R7;
    }

    @n0
    public v getRecycledViewPool() {
        return this.f6601b.j();
    }

    public int getScrollState() {
        return this.E7;
    }

    public void h(int i10, int i11) {
        if (i10 < 0) {
            U();
            if (this.C1.isFinished()) {
                this.C1.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            V();
            if (this.f6636v2.isFinished()) {
                this.f6636v2.onAbsorb(i10);
            }
        }
        if (i11 < 0) {
            W();
            if (this.K1.isFinished()) {
                this.K1.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            T();
            if (this.C2.isFinished()) {
                this.C2.onAbsorb(i11);
            }
        }
        if (i10 == 0 && i11 == 0) {
            return;
        }
        u0.n1(this);
    }

    public e0 h0(long j10) {
        g gVar = this.f6623l;
        e0 e0Var = null;
        if (gVar != null && gVar.hasStableIds()) {
            int iJ = this.f6607e.j();
            for (int i10 = 0; i10 < iJ; i10++) {
                e0 e0VarU0 = u0(this.f6607e.i(i10));
                if (e0VarU0 != null && !e0VarU0.isRemoved() && e0VarU0.getItemId() == j10) {
                    if (!this.f6607e.n(e0VarU0.itemView)) {
                        return e0VarU0;
                    }
                    e0Var = e0VarU0;
                }
            }
        }
        return e0Var;
    }

    public final boolean h1() {
        return this.K2 != null && this.f6625m.j2();
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    @p0
    public e0 i0(int i10) {
        return k0(i10, false);
    }

    public final void i1() {
        boolean z10;
        if (this.D) {
            this.f6605d.z();
            if (this.f6620k0) {
                this.f6625m.l1(this);
            }
        }
        if (h1()) {
            this.f6605d.x();
        } else {
            this.f6605d.k();
        }
        boolean z11 = false;
        boolean z12 = this.Y7 || this.Z7;
        this.V7.f6673k = this.f6633u && this.K2 != null && ((z10 = this.D) || z12 || this.f6625m.f6718h) && (!z10 || this.f6623l.hasStableIds());
        b0 b0Var = this.V7;
        if (b0Var.f6673k && z12 && !this.D && h1()) {
            z11 = true;
        }
        b0Var.f6674l = z11;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f6630r;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f6638x;
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    @p0
    @Deprecated
    public e0 j0(int i10) {
        return k0(i10, false);
    }

    public void j1(boolean z10) {
        this.f6620k0 = z10 | this.f6620k0;
        this.D = true;
        S0();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.e0 k0(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.g r0 = r5.f6607e
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.g r3 = r5.f6607e
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$e0 r3 = u0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.g r1 = r5.f6607e
            android.view.View r4 = r3.itemView
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.k0(int, boolean):androidx.recyclerview.widget.RecyclerView$e0");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k1(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.U()
            android.widget.EdgeEffect r3 = r6.C1
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.j.g(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.V()
            android.widget.EdgeEffect r3 = r6.f6636v2
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.j.g(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.W()
            android.widget.EdgeEffect r9 = r6.K1
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.j.g(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.T()
            android.widget.EdgeEffect r9 = r6.C2
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.j.g(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.view.u0.n1(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.k1(float, float, float, float):void");
    }

    public void l1(e0 e0Var, l.d dVar) {
        e0Var.setFlags(0, 8192);
        if (this.V7.f6671i && e0Var.isUpdated() && !e0Var.isRemoved() && !e0Var.shouldIgnore()) {
            this.f6609f.c(o0(e0Var), e0Var);
        }
        this.f6609f.e(e0Var, dVar);
    }

    public final void m(e0 e0Var) {
        View view = e0Var.itemView;
        boolean z10 = view.getParent() == this;
        this.f6601b.K(t0(view));
        if (e0Var.isTmpDetached()) {
            this.f6607e.c(view, -1, view.getLayoutParams(), true);
        } else if (z10) {
            this.f6607e.k(view);
        } else {
            this.f6607e.b(view, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean m0(int i10, int i11) {
        o oVar = this.f6625m;
        if (oVar == null || this.f6638x) {
            return false;
        }
        int iV = oVar.v();
        boolean zW = this.f6625m.w();
        if (iV == 0 || Math.abs(i10) < this.N7) {
            i10 = 0;
        }
        if (!zW || Math.abs(i11) < this.N7) {
            i11 = 0;
        }
        if (i10 == 0 && i11 == 0) {
            return false;
        }
        float f10 = i10;
        float f11 = i11;
        if (!dispatchNestedPreFling(f10, f11)) {
            boolean z10 = iV != 0 || zW;
            dispatchNestedFling(f10, f11, z10);
            r rVar = this.M7;
            if (rVar != null && rVar.a(i10, i11)) {
                return true;
            }
            if (z10) {
                if (zW) {
                    iV = (iV == true ? 1 : 0) | 2;
                }
                f(iV, 1);
                int i12 = this.O7;
                int iMax = Math.max(-i12, Math.min(i10, i12));
                int i13 = this.O7;
                this.S7.c(iMax, Math.max(-i13, Math.min(i11, i13)));
                return true;
            }
        }
        return false;
    }

    public final void m1() {
        View viewFindViewById;
        if (!this.R7 || this.f6623l == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!f6594v8 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f6607e.n(focusedChild)) {
                    return;
                }
            } else if (this.f6607e.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewF0 = null;
        e0 e0VarH0 = (this.V7.f6676n == -1 || !this.f6623l.hasStableIds()) ? null : h0(this.V7.f6676n);
        if (e0VarH0 != null && !this.f6607e.n(e0VarH0.itemView) && e0VarH0.itemView.hasFocusable()) {
            viewF0 = e0VarH0.itemView;
        } else if (this.f6607e.g() > 0) {
            viewF0 = f0();
        }
        if (viewF0 != null) {
            int i10 = this.V7.f6677o;
            if (i10 != -1 && (viewFindViewById = viewF0.findViewById(i10)) != null && viewFindViewById.isFocusable()) {
                viewF0 = viewFindViewById;
            }
            viewF0.requestFocus();
        }
    }

    public void n(@n0 n nVar) {
        o(nVar, -1);
    }

    public int n0(e0 e0Var) {
        if (e0Var.hasAnyOfTheFlags(524) || !e0Var.isBound()) {
            return -1;
        }
        return this.f6605d.f(e0Var.mPosition);
    }

    public final void n1() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.C1;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.C1.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.K1;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.K1.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f6636v2;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f6636v2.isFinished();
        }
        EdgeEffect edgeEffect4 = this.C2;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.C2.isFinished();
        }
        if (zIsFinished) {
            u0.n1(this);
        }
    }

    public void o(@n0 n nVar, int i10) {
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.q("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f6627o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.f6627o.add(nVar);
        } else {
            this.f6627o.add(i10, nVar);
        }
        R0();
        requestLayout();
    }

    public long o0(e0 e0Var) {
        return this.f6623l.hasStableIds() ? e0Var.getItemId() : e0Var.mPosition;
    }

    public void o1() {
        l lVar = this.K2;
        if (lVar != null) {
            lVar.l();
        }
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.E1(this.f6601b);
            this.f6625m.F1(this.f6601b);
        }
        this.f6601b.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K0 = 0;
        this.f6630r = true;
        this.f6633u = this.f6633u && !isLayoutRequested();
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.N(this);
        }
        this.f6602b8 = false;
        if (f6592t8) {
            ThreadLocal<androidx.recyclerview.widget.l> threadLocal = androidx.recyclerview.widget.l.f7093e;
            androidx.recyclerview.widget.l lVar = threadLocal.get();
            this.T7 = lVar;
            if (lVar == null) {
                this.T7 = new androidx.recyclerview.widget.l();
                Display displayQ = u0.Q(this);
                float f10 = 60.0f;
                if (!isInEditMode() && displayQ != null) {
                    float refreshRate = displayQ.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f10 = refreshRate;
                    }
                }
                androidx.recyclerview.widget.l lVar2 = this.T7;
                lVar2.f7097c = (long) (1.0E9f / f10);
                threadLocal.set(lVar2);
            }
            this.T7.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.recyclerview.widget.l lVar;
        super.onDetachedFromWindow();
        l lVar2 = this.K2;
        if (lVar2 != null) {
            lVar2.l();
        }
        O1();
        this.f6630r = false;
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.O(this, this.f6601b);
        }
        this.f6618j8.clear();
        removeCallbacks(this.f6622k8);
        this.f6609f.j();
        if (!f6592t8 || (lVar = this.T7) == null) {
            return;
        }
        lVar.j(this);
        this.T7 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f6627o.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f6627o.get(i10).f(canvas, this, this.V7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f6625m
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f6638x
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f6625m
            boolean r0 = r0.w()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f6625m
            boolean r3 = r3.v()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f6625m
            boolean r3 = r3.w()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f6625m
            boolean r3 = r3.v()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.P7
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.Q7
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.B1(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.f6638x) {
            return false;
        }
        this.f6629q = null;
        if (c0(motionEvent)) {
            y();
            return true;
        }
        o oVar = this.f6625m;
        if (oVar == null) {
            return false;
        }
        boolean zV = oVar.v();
        boolean zW = this.f6625m.w();
        if (this.G7 == null) {
            this.G7 = VelocityTracker.obtain();
        }
        this.G7.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f6639y) {
                this.f6639y = false;
            }
            this.F7 = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.J7 = x10;
            this.H7 = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.K7 = y10;
            this.I7 = y10;
            if (this.E7 == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                g(1);
            }
            int[] iArr = this.f6614h8;
            iArr[1] = 0;
            iArr[0] = 0;
            int i10 = zV;
            if (zW) {
                i10 = (zV ? 1 : 0) | 2;
            }
            f(i10, 0);
        } else if (actionMasked == 1) {
            this.G7.clear();
            g(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.F7);
            if (iFindPointerIndex < 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error processing scroll; pointer index for id ");
                sb2.append(this.F7);
                sb2.append(" not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.E7 != 1) {
                int i11 = x11 - this.H7;
                int i12 = y11 - this.I7;
                if (!zV || Math.abs(i11) <= this.L7) {
                    z10 = false;
                } else {
                    this.J7 = x11;
                    z10 = true;
                }
                if (zW && Math.abs(i12) > this.L7) {
                    this.K7 = y11;
                    z10 = true;
                }
                if (z10) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.F7 = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.J7 = x12;
            this.H7 = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.K7 = y12;
            this.I7 = y12;
        } else if (actionMasked == 6) {
            d1(motionEvent);
        }
        return this.E7 == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        androidx.core.os.y.b(I8);
        L();
        androidx.core.os.y.d();
        this.f6633u = true;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        o oVar = this.f6625m;
        if (oVar == null) {
            G(i10, i11);
            return;
        }
        boolean z10 = false;
        if (oVar.H0()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f6625m.s1(this.f6601b, this.V7, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            if (z10 || this.f6623l == null) {
                return;
            }
            if (this.V7.f6667e == 1) {
                M();
            }
            this.f6625m.W1(i10, i11);
            this.V7.f6672j = true;
            N();
            this.f6625m.Z1(i10, i11);
            if (this.f6625m.d2()) {
                this.f6625m.W1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.V7.f6672j = true;
                N();
                this.f6625m.Z1(i10, i11);
                return;
            }
            return;
        }
        if (this.f6631s) {
            this.f6625m.s1(this.f6601b, this.V7, i10, i11);
            return;
        }
        if (this.A) {
            M1();
            a1();
            i1();
            b1();
            b0 b0Var = this.V7;
            if (b0Var.f6674l) {
                b0Var.f6670h = true;
            } else {
                this.f6605d.k();
                this.V7.f6670h = false;
            }
            this.A = false;
            N1(false);
        } else if (this.V7.f6674l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f6623l;
        if (gVar != null) {
            this.V7.f6668f = gVar.getItemCount();
        } else {
            this.V7.f6668f = 0;
        }
        M1();
        this.f6625m.s1(this.f6601b, this.V7, i10, i11);
        N1(false);
        this.V7.f6670h = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (N0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f6603c = savedState;
        super.onRestoreInstanceState(savedState.a());
        o oVar = this.f6625m;
        if (oVar == null || (parcelable2 = this.f6603c.f6641c) == null) {
            return;
        }
        oVar.v1(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f6603c;
        if (savedState2 != null) {
            savedState.b(savedState2);
        } else {
            o oVar = this.f6625m;
            if (oVar != null) {
                savedState.f6641c = oVar.w1();
            } else {
                savedState.f6641c = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 == i12 && i11 == i13) {
            return;
        }
        J0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d6 A[PHI: r0
  0x00d6: PHI (r0v36 int) = (r0v26 int), (r0v40 int) binds: [B:41:0x00bf, B:45:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ef  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(@n0 q qVar) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(qVar);
    }

    public int p0(@n0 View view) {
        e0 e0VarU0 = u0(view);
        if (e0VarU0 != null) {
            return e0VarU0.getAdapterPosition();
        }
        return -1;
    }

    public boolean p1(View view) {
        M1();
        boolean zR = this.f6607e.r(view);
        if (zR) {
            e0 e0VarU0 = u0(view);
            this.f6601b.K(e0VarU0);
            this.f6601b.D(e0VarU0);
        }
        N1(!zR);
        return zR;
    }

    public void q(@n0 s sVar) {
        this.f6628p.add(sVar);
    }

    public long q0(@n0 View view) {
        e0 e0VarU0;
        g gVar = this.f6623l;
        if (gVar == null || !gVar.hasStableIds() || (e0VarU0 = u0(view)) == null) {
            return -1L;
        }
        return e0VarU0.getItemId();
    }

    public void q1(@n0 n nVar) {
        o oVar = this.f6625m;
        if (oVar != null) {
            oVar.q("Cannot remove item decoration during a scroll  or layout");
        }
        this.f6627o.remove(nVar);
        if (this.f6627o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        R0();
        requestLayout();
    }

    public void r(@n0 t tVar) {
        if (this.X7 == null) {
            this.X7 = new ArrayList();
        }
        this.X7.add(tVar);
    }

    public int r0(@n0 View view) {
        e0 e0VarU0 = u0(view);
        if (e0VarU0 != null) {
            return e0VarU0.getLayoutPosition();
        }
        return -1;
    }

    public void r1(int i10) {
        int itemDecorationCount = getItemDecorationCount();
        if (i10 >= 0 && i10 < itemDecorationCount) {
            q1(A0(i10));
            return;
        }
        throw new IndexOutOfBoundsException(i10 + " is an invalid index for size " + itemDecorationCount);
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z10) {
        e0 e0VarU0 = u0(view);
        if (e0VarU0 != null) {
            if (e0VarU0.isTmpDetached()) {
                e0VarU0.clearTmpDetachFlag();
            } else if (!e0VarU0.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + e0VarU0 + X());
            }
        }
        view.clearAnimation();
        J(view);
        super.removeDetachedView(view, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f6625m.u1(this, this.V7, view, view2) && view2 != null) {
            w1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f6625m.L1(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.f6628p.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f6628p.get(i10).onRequestDisallowInterceptTouchEvent(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f6634v != 0 || this.f6638x) {
            this.f6637w = true;
        } else {
            super.requestLayout();
        }
    }

    public void s(@n0 e0 e0Var, @p0 l.d dVar, @n0 l.d dVar2) {
        e0Var.setIsRecyclable(false);
        if (this.K2.a(e0Var, dVar, dVar2)) {
            g1();
        }
    }

    @Deprecated
    public int s0(@n0 View view) {
        return p0(view);
    }

    public void s1(@n0 q qVar) {
        List<q> list = this.C;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        o oVar = this.f6625m;
        if (oVar == null || this.f6638x) {
            return;
        }
        boolean zV = oVar.v();
        boolean zW = this.f6625m.w();
        if (zV || zW) {
            if (!zV) {
                i10 = 0;
            }
            if (!zW) {
                i11 = 0;
            }
            B1(i10, i11, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (G1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@p0 androidx.recyclerview.widget.y yVar) {
        this.f6604c8 = yVar;
        u0.B1(this, yVar);
    }

    public void setAdapter(@p0 g gVar) {
        setLayoutFrozen(false);
        E1(gVar, false, true);
        j1(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@p0 j jVar) {
        if (jVar == this.f6606d8) {
            return;
        }
        this.f6606d8 = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.f6611g) {
            J0();
        }
        this.f6611g = z10;
        super.setClipToPadding(z10);
        if (this.f6633u) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@n0 k kVar) {
        androidx.core.util.o.l(kVar);
        this.f6635v1 = kVar;
        J0();
    }

    public void setHasFixedSize(boolean z10) {
        this.f6631s = z10;
    }

    public void setItemAnimator(@p0 l lVar) {
        l lVar2 = this.K2;
        if (lVar2 != null) {
            lVar2.l();
            this.K2.A(null);
        }
        this.K2 = lVar;
        if (lVar != null) {
            lVar.A(this.f6600a8);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f6601b.H(i10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(@p0 o oVar) {
        if (oVar == this.f6625m) {
            return;
        }
        O1();
        if (this.f6625m != null) {
            l lVar = this.K2;
            if (lVar != null) {
                lVar.l();
            }
            this.f6625m.E1(this.f6601b);
            this.f6625m.F1(this.f6601b);
            this.f6601b.d();
            if (this.f6630r) {
                this.f6625m.O(this, this.f6601b);
            }
            this.f6625m.b2(null);
            this.f6625m = null;
        } else {
            this.f6601b.d();
        }
        this.f6607e.o();
        this.f6625m = oVar;
        if (oVar != null) {
            if (oVar.f6712b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f6712b.X());
            }
            oVar.b2(this);
            if (this.f6630r) {
                this.f6625m.N(this);
            }
        }
        this.f6601b.L();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View, androidx.core.view.e0
    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().p(z10);
    }

    public void setOnFlingListener(@p0 r rVar) {
        this.M7 = rVar;
    }

    @Deprecated
    public void setOnScrollListener(@p0 t tVar) {
        this.W7 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.R7 = z10;
    }

    public void setRecycledViewPool(@p0 v vVar) {
        this.f6601b.F(vVar);
    }

    public void setRecyclerListener(@p0 x xVar) {
        this.f6626n = xVar;
    }

    void setScrollState(int i10) {
        if (i10 == this.E7) {
            return;
        }
        this.E7 = i10;
        if (i10 != 2) {
            P1();
        }
        P(i10);
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 == 1) {
                this.L7 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setScrollingTouchSlop(): bad argument constant ");
            sb2.append(i10);
            sb2.append("; using default value");
        }
        this.L7 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@p0 c0 c0Var) {
        this.f6601b.G(c0Var);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().r(i10);
    }

    @Override // android.view.View, androidx.core.view.e0
    public void stopNestedScroll() {
        getScrollingChildHelper().t();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.f6638x) {
            w("Do not suppressLayout in layout or scroll");
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f6638x = true;
                this.f6639y = true;
                O1();
                return;
            }
            this.f6638x = false;
            if (this.f6637w && this.f6625m != null && this.f6623l != null) {
                requestLayout();
            }
            this.f6637w = false;
        }
    }

    public final void t(@n0 e0 e0Var, @n0 e0 e0Var2, @n0 l.d dVar, @n0 l.d dVar2, boolean z10, boolean z11) {
        e0Var.setIsRecyclable(false);
        if (z10) {
            m(e0Var);
        }
        if (e0Var != e0Var2) {
            if (z11) {
                m(e0Var2);
            }
            e0Var.mShadowedHolder = e0Var2;
            m(e0Var);
            this.f6601b.K(e0Var);
            e0Var2.setIsRecyclable(false);
            e0Var2.mShadowingHolder = e0Var;
        }
        if (this.K2.b(e0Var, e0Var2, dVar, dVar2)) {
            g1();
        }
    }

    public e0 t0(@n0 View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return u0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public void t1(@n0 s sVar) {
        this.f6628p.remove(sVar);
        if (this.f6629q == sVar) {
            this.f6629q = null;
        }
    }

    public void u(@n0 e0 e0Var, @n0 l.d dVar, @p0 l.d dVar2) {
        m(e0Var);
        e0Var.setIsRecyclable(false);
        if (this.K2.c(e0Var, dVar, dVar2)) {
            g1();
        }
    }

    public void u1(@n0 t tVar) {
        List<t> list = this.X7;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public void v(String str) {
        if (N0()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + X());
        }
        throw new IllegalStateException(str + X());
    }

    public void v0(@n0 View view, @n0 Rect rect) {
        w0(view, rect);
    }

    public void v1() {
        e0 e0Var;
        int iG = this.f6607e.g();
        for (int i10 = 0; i10 < iG; i10++) {
            View viewF = this.f6607e.f(i10);
            e0 e0VarT0 = t0(viewF);
            if (e0VarT0 != null && (e0Var = e0VarT0.mShadowingHolder) != null) {
                View view = e0Var.itemView;
                int left = viewF.getLeft();
                int top2 = viewF.getTop();
                if (left != view.getLeft() || top2 != view.getTop()) {
                    view.layout(left, top2, view.getWidth() + left, view.getHeight() + top2);
                }
            }
        }
    }

    public void w(String str) {
        if (N0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + X());
        }
        if (this.f6621k1 > 0) {
            new IllegalStateException("" + X());
        }
    }

    public final void w1(@n0 View view, @p0 View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f6615i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f6737c) {
                Rect rect = pVar.f6736b;
                Rect rect2 = this.f6615i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f6615i);
            offsetRectIntoDescendantCoords(view, this.f6615i);
        }
        this.f6625m.M1(this, view, this.f6615i, !this.f6633u, view2 == null);
    }

    public boolean x(e0 e0Var) {
        l lVar = this.K2;
        return lVar == null || lVar.g(e0Var, e0Var.getUnmodifiedPayloads());
    }

    public final int x0(View view) {
        int id2 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            }
        }
        return id2;
    }

    public final void x1() {
        b0 b0Var = this.V7;
        b0Var.f6676n = -1L;
        b0Var.f6675m = -1;
        b0Var.f6677o = -1;
    }

    public final void y() {
        y1();
        setScrollState(0);
    }

    public final String y0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(j3.b.f36044h)) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    public final void y1() {
        VelocityTracker velocityTracker = this.G7;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        g(0);
        n1();
    }

    public Rect z0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f6737c) {
            return pVar.f6736b;
        }
        if (this.V7.j() && (pVar.g() || pVar.s())) {
            return pVar.f6736b;
        }
        Rect rect = pVar.f6736b;
        rect.set(0, 0, 0, 0);
        int size = this.f6627o.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f6615i.set(0, 0, 0, 0);
            this.f6627o.get(i10).d(this.f6615i, view, this, this.V7);
            int i11 = rect.left;
            Rect rect2 = this.f6615i;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f6737c = false;
        return rect;
    }

    public final void z1() {
        View focusedChild = (this.R7 && hasFocus() && this.f6623l != null) ? getFocusedChild() : null;
        e0 e0VarB0 = focusedChild != null ? b0(focusedChild) : null;
        if (e0VarB0 == null) {
            x1();
            return;
        }
        this.V7.f6676n = this.f6623l.hasStableIds() ? e0VarB0.getItemId() : -1L;
        this.V7.f6675m = this.D ? -1 : e0VarB0.isRemoved() ? e0VarB0.mOldPosition : e0VarB0.getAdapterPosition();
        this.V7.f6677o = x0(e0VarB0.itemView);
    }

    public RecyclerView(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public RecyclerView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f6599a = new y();
        this.f6601b = new w();
        this.f6609f = new h0();
        this.f6613h = new a();
        this.f6615i = new Rect();
        this.f6617j = new Rect();
        this.f6619k = new RectF();
        this.f6627o = new ArrayList<>();
        this.f6628p = new ArrayList<>();
        this.f6634v = 0;
        this.D = false;
        this.f6620k0 = false;
        this.K0 = 0;
        this.f6621k1 = 0;
        this.f6635v1 = new k();
        this.K2 = new androidx.recyclerview.widget.h();
        this.E7 = 0;
        this.F7 = -1;
        this.P7 = Float.MIN_VALUE;
        this.Q7 = Float.MIN_VALUE;
        this.R7 = true;
        this.S7 = new d0();
        this.U7 = f6592t8 ? new l.b() : null;
        this.V7 = new b0();
        this.Y7 = false;
        this.Z7 = false;
        this.f6600a8 = new m();
        this.f6602b8 = false;
        this.f6608e8 = new int[2];
        this.f6612g8 = new int[2];
        this.f6614h8 = new int[2];
        this.f6616i8 = new int[2];
        this.f6618j8 = new ArrayList();
        this.f6622k8 = new b();
        this.f6624l8 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.L7 = viewConfiguration.getScaledTouchSlop();
        this.P7 = w0.b(viewConfiguration, context);
        this.Q7 = w0.e(viewConfiguration, context);
        this.N7 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.O7 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.K2.A(this.f6600a8);
        F0();
        H0();
        G0();
        if (u0.V(this) == 0) {
            u0.R1(this, 1);
        }
        this.B = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.y(this));
        int[] iArr = androidx.recyclerview.R.styleable.RecyclerView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f6611g = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
        this.f6632t = z10;
        if (z10) {
            I0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        F(context, string, attributeSet, i10, 0);
        int[] iArr2 = f6588p8;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i10, 0);
        if (i11 >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i10, 0);
        }
        boolean z11 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Parcelable f6641c;

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
            this.f6641c = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public void b(SavedState savedState) {
            this.f6641c = savedState.f6641c;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f6641c, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e0 f6735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f6736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6738d;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6736b = new Rect();
            this.f6737c = true;
            this.f6738d = false;
        }

        public int a() {
            return this.f6735a.getAdapterPosition();
        }

        public int b() {
            return this.f6735a.getLayoutPosition();
        }

        @Deprecated
        public int e() {
            return this.f6735a.getPosition();
        }

        public boolean g() {
            return this.f6735a.isUpdated();
        }

        public boolean j() {
            return this.f6735a.isRemoved();
        }

        public boolean s() {
            return this.f6735a.isInvalid();
        }

        public boolean z() {
            return this.f6735a.needsUpdate();
        }

        public p(int i10, int i11) {
            super(i10, i11);
            this.f6736b = new Rect();
            this.f6737c = true;
            this.f6738d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6736b = new Rect();
            this.f6737c = true;
            this.f6738d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6736b = new Rect();
            this.f6737c = true;
            this.f6738d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f6736b = new Rect();
            this.f6737c = true;
            this.f6738d = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f6625m;
        if (oVar != null) {
            return oVar.U(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + X());
    }
}
