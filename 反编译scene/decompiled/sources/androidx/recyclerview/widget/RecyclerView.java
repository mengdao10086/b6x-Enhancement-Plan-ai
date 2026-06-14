package androidx.recyclerview.widget;

import a.Cdo;
import a.ak;
import a.ap;
import a.aq;
import a.bq;
import a.co;
import a.cq;
import a.dq;
import a.eh;
import a.fh;
import a.fo;
import a.gg;
import a.go;
import a.hg;
import a.ig;
import a.io;
import a.jq;
import a.kq;
import a.mi;
import a.mq;
import a.ni;
import a.pf;
import a.rf;
import a.to;
import a.ud;
import a.xp;
import a.yo;
import a.yp;
import a.zp;
import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
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
import android.util.Log;
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
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class RecyclerView extends ViewGroup implements hg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f8222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?>[] f4314a;
    public static final int[] e = {R.attr.nestedScrollingEnabled};
    public static final boolean q;
    public static final boolean r;
    public static final boolean s;
    public static final boolean t;
    public static final boolean u;
    public static final boolean v;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f4315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ap.a f4317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ap f4318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dq f4319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public go f4320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ig f4321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public io f4322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mq.a f4323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mq f4324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f4326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VelocityTracker f4327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AccessibilityManager f4328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EdgeEffect f4329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a0 f4330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c0 f4331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f4332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j f4333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k f4334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l.a f4335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l f4336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public o f4337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r f4338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s f4339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public t f4340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v f4341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public w f4342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final x f4343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public y f4344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<n> f4346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<q> f4347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f4348a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4349b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f4350b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public EdgeEffect f4351b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Runnable f4352b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<s> f4353b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<t> f4354b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4355b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f4356b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public EdgeEffect f4357c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final List<d0> f4358c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4359c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int[] f4360c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public EdgeEffect f4361d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4362d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int[] f4363d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f4364e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4365e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4366f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4367g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4368h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4369i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f4370j;
    public int k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f4371k;
    public final int l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public boolean f4372l;
    public final int m;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public boolean f4373m;
    public boolean n;
    public boolean o;
    public boolean p;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f4366f || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f4359c) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f4368h) {
                recyclerView2.f4367g = true;
            } else {
                recyclerView2.v();
            }
        }
    }

    public static class a0 {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f4374a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public SparseArray<Object> f4375a;
        public int f;
        public int g;
        public int h;
        public int i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8224a = -1;
        public int b = 0;
        public int c = 0;
        public int d = 1;
        public int e = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4376a = false;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4377b = false;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f4378c = false;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f4379d = false;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public boolean f4380e = false;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public boolean f4381f = false;

        public void a(int i) {
            if ((this.d & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.d));
        }

        public int b() {
            return this.f4377b ? this.b - this.c : this.e;
        }

        public int c() {
            return this.f8224a;
        }

        public boolean d() {
            return this.f8224a != -1;
        }

        public boolean e() {
            return this.f4377b;
        }

        public void f(g gVar) {
            this.d = 1;
            this.e = gVar.e();
            this.f4377b = false;
            this.f4378c = false;
            this.f4379d = false;
        }

        public boolean g() {
            return this.f4381f;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f8224a + ", mData=" + this.f4375a + ", mItemCount=" + this.e + ", mIsMeasuring=" + this.f4379d + ", mPreviousLayoutItemCount=" + this.b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.f4376a + ", mInPreLayout=" + this.f4377b + ", mRunSimpleAnimations=" + this.f4380e + ", mRunPredictiveAnimations=" + this.f4381f + '}';
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.f4336a;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.p = false;
        }
    }

    public static abstract class b0 {
        public abstract View a(v vVar, int i, int i2);
    }

    public static class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class c0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8226a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public OverScroller f4383a;
        public int b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Interpolator f4382a = RecyclerView.f8222a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4385b = false;
        public boolean c = false;

        public c0() {
            this.f4383a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f8222a);
        }

        public final int a(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fB = f2 + (b(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fB / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final float b(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        public void c(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.b = 0;
            this.f8226a = 0;
            Interpolator interpolator = this.f4382a;
            Interpolator interpolator2 = RecyclerView.f8222a;
            if (interpolator != interpolator2) {
                this.f4382a = interpolator2;
                this.f4383a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f8222a);
            }
            this.f4383a.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        public final void d() {
            RecyclerView.this.removeCallbacks(this);
            eh.c0(RecyclerView.this, this);
        }

        public void e() {
            if (this.f4385b) {
                this.c = true;
            } else {
                d();
            }
        }

        public void f(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.f8222a;
            }
            if (this.f4382a != interpolator) {
                this.f4382a = interpolator;
                this.f4383a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.b = 0;
            this.f8226a = 0;
            RecyclerView.this.setScrollState(2);
            this.f4383a.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f4383a.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f4383a.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f4337a == null) {
                g();
                return;
            }
            this.c = false;
            this.f4385b = true;
            recyclerView.v();
            OverScroller overScroller = this.f4383a;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.f8226a;
                int i5 = currY - this.b;
                this.f8226a = currX;
                this.b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f4363d;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.G(i4, i5, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f4363d;
                    i4 -= iArr2[0];
                    i5 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.u(i4, i5);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f4332a != null) {
                    int[] iArr3 = recyclerView3.f4363d;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.g1(i4, i5, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.f4363d;
                    int i6 = iArr4[0];
                    int i7 = iArr4[1];
                    int i8 = i4 - i6;
                    i5 -= i7;
                    z zVar = recyclerView4.f4337a.f4402a;
                    if (zVar != null && !zVar.b() && zVar.c()) {
                        int iB = RecyclerView.this.f4330a.b();
                        if (iB == 0) {
                            zVar.g();
                            throw null;
                        }
                        if (zVar.a() >= iB) {
                            zVar.f(iB - 1);
                        }
                        zVar.d(i6, i7);
                    }
                    i3 = i8;
                    i = i7;
                    i2 = i6;
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = i4;
                }
                int i9 = i5;
                if (!RecyclerView.this.f4346a.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.f4363d;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.H(i2, i, i3, i9, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.f4363d;
                int i10 = i3 - iArr6[0];
                int i11 = i9 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    RecyclerView.this.J(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i10 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i11 != 0));
                z zVar2 = RecyclerView.this.f4337a.f4402a;
                if ((zVar2 != null && zVar2.b()) || !z) {
                    e();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    ap apVar = recyclerView6.f4318a;
                    if (apVar != null) {
                        apVar.f(recyclerView6, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i12 = i10 < 0 ? -currVelocity : i10 > 0 ? currVelocity : 0;
                        if (i11 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i11 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i12, currVelocity);
                    }
                    if (RecyclerView.t) {
                        RecyclerView.this.f4317a.b();
                    }
                }
            }
            z zVar3 = RecyclerView.this.f4337a.f4402a;
            if (zVar3 != null && zVar3.b()) {
                zVar3.d(0, 0);
            }
            this.f4385b = false;
            if (this.c) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.s1(1);
            }
        }
    }

    public class d implements mq.a {
        public d() {
        }

        @Override // a.mq.a
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f4337a.s1(d0Var.f4387a, recyclerView.f4341a);
        }

        @Override // a.mq.a
        public void b(d0 d0Var, l.b bVar, l.b bVar2) {
            RecyclerView.this.m(d0Var, bVar, bVar2);
        }

        @Override // a.mq.a
        public void c(d0 d0Var, l.b bVar, l.b bVar2) {
            d0Var.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            boolean z = recyclerView.f4371k;
            l lVar = recyclerView.f4336a;
            if (z) {
                if (!lVar.b(d0Var, d0Var, bVar, bVar2)) {
                    return;
                }
            } else if (!lVar.d(d0Var, bVar, bVar2)) {
                return;
            }
            RecyclerView.this.L0();
        }

        @Override // a.mq.a
        public void d(d0 d0Var, l.b bVar, l.b bVar2) {
            RecyclerView.this.f4341a.J(d0Var);
            RecyclerView.this.o(d0Var, bVar, bVar2);
        }
    }

    public static abstract class d0 {
        public static final List<Object> c = Collections.emptyList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final View f4387a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public RecyclerView f4390a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WeakReference<RecyclerView> f4391a;
        public int e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8228a = -1;
        public int b = -1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f4386a = -1;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f4396c = -1;
        public int d = -1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public d0 f4388a = null;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public d0 f4394b = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<Object> f4392a = null;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public List<Object> f4395b = null;
        public int f = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public v f4389a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4393a = false;
        public int g = 0;
        public int h = -1;

        public d0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f4387a = view;
        }

        public void A(int i, boolean z) {
            if (this.b == -1) {
                this.b = this.f8228a;
            }
            if (this.d == -1) {
                this.d = this.f8228a;
            }
            if (z) {
                this.d += i;
            }
            this.f8228a += i;
            if (this.f4387a.getLayoutParams() != null) {
                ((p) this.f4387a.getLayoutParams()).b = true;
            }
        }

        public void B(RecyclerView recyclerView) {
            int iW = this.h;
            if (iW == -1) {
                iW = eh.w(this.f4387a);
            }
            this.g = iW;
            recyclerView.j1(this, 4);
        }

        public void C(RecyclerView recyclerView) {
            recyclerView.j1(this, this.g);
            this.g = 0;
        }

        public void D() {
            this.e = 0;
            this.f8228a = -1;
            this.b = -1;
            this.f4386a = -1L;
            this.d = -1;
            this.f = 0;
            this.f4388a = null;
            this.f4394b = null;
            d();
            this.g = 0;
            this.h = -1;
            RecyclerView.s(this);
        }

        public void E() {
            if (this.b == -1) {
                this.b = this.f8228a;
            }
        }

        public void F(int i, int i2) {
            this.e = (i & i2) | (this.e & (~i2));
        }

        public final void G(boolean z) {
            int i;
            int i2 = this.f;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.f = i3;
            if (i3 < 0) {
                this.f = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i3 == 1) {
                i = this.e | 16;
            } else if (!z || this.f != 0) {
                return;
            } else {
                i = this.e & (-17);
            }
            this.e = i;
        }

        public void H(v vVar, boolean z) {
            this.f4389a = vVar;
            this.f4393a = z;
        }

        public boolean I() {
            return (this.e & 16) != 0;
        }

        public boolean J() {
            return (this.e & 128) != 0;
        }

        public void K() {
            this.f4389a.J(this);
        }

        public boolean L() {
            return (this.e & 32) != 0;
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.e) == 0) {
                g();
                this.f4392a.add(obj);
            }
        }

        public void b(int i) {
            this.e = i | this.e;
        }

        public void c() {
            this.b = -1;
            this.d = -1;
        }

        public void d() {
            List<Object> list = this.f4392a;
            if (list != null) {
                list.clear();
            }
            this.e &= -1025;
        }

        public void e() {
            this.e &= -33;
        }

        public void f() {
            this.e &= -257;
        }

        public final void g() {
            if (this.f4392a == null) {
                ArrayList arrayList = new ArrayList();
                this.f4392a = arrayList;
                this.f4395b = Collections.unmodifiableList(arrayList);
            }
        }

        public boolean h() {
            return (this.e & 16) == 0 && eh.N(this.f4387a);
        }

        public void i(int i, int i2, boolean z) {
            b(8);
            A(i2, z);
            this.f8228a = i;
        }

        public final int j() {
            RecyclerView recyclerView = this.f4390a;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.d0(this);
        }

        public final long k() {
            return this.f4386a;
        }

        public final int l() {
            return this.f4396c;
        }

        public final int m() {
            int i = this.d;
            return i == -1 ? this.f8228a : i;
        }

        public final int n() {
            return this.b;
        }

        public List<Object> o() {
            if ((this.e & 1024) != 0) {
                return c;
            }
            List<Object> list = this.f4392a;
            return (list == null || list.size() == 0) ? c : this.f4395b;
        }

        public boolean p(int i) {
            return (i & this.e) != 0;
        }

        public boolean q() {
            return (this.e & 512) != 0 || t();
        }

        public boolean r() {
            return (this.f4387a.getParent() == null || this.f4387a.getParent() == this.f4390a) ? false : true;
        }

        public boolean s() {
            return (this.e & 1) != 0;
        }

        public boolean t() {
            return (this.e & 4) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f8228a + " id=" + this.f4386a + ", oldPos=" + this.b + ", pLpos:" + this.d);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.f4393a ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.f + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f4387a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.e & 16) == 0 && !eh.N(this.f4387a);
        }

        public boolean v() {
            return (this.e & 8) != 0;
        }

        public boolean w() {
            return this.f4389a != null;
        }

        public boolean x() {
            return (this.e & 256) != 0;
        }

        public boolean y() {
            return (this.e & 2) != 0;
        }

        public boolean z() {
            return (this.e & 2) != 0;
        }
    }

    public class e implements io.a {
        public e() {
        }

        @Override // a.io.a
        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        @Override // a.io.a
        public void b(View view, int i, ViewGroup.LayoutParams layoutParams) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0 != null) {
                if (!d0VarG0.x() && !d0VarG0.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + d0VarG0 + RecyclerView.this.Q());
                }
                d0VarG0.f();
            }
            RecyclerView.this.attachViewToParent(view, i, layoutParams);
        }

        @Override // a.io.a
        public void c(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }

        @Override // a.io.a
        public int d(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // a.io.a
        public void e(int i) {
            d0 d0VarG0;
            View viewA = a(i);
            if (viewA != null && (d0VarG0 = RecyclerView.g0(viewA)) != null) {
                if (d0VarG0.x() && !d0VarG0.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + d0VarG0 + RecyclerView.this.Q());
                }
                d0VarG0.b(256);
            }
            RecyclerView.this.detachViewFromParent(i);
        }

        @Override // a.io.a
        public int f() {
            return RecyclerView.this.getChildCount();
        }

        @Override // a.io.a
        public void g() {
            int iF = f();
            for (int i = 0; i < iF; i++) {
                View viewA = a(i);
                RecyclerView.this.A(viewA);
                viewA.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // a.io.a
        public d0 h(View view) {
            return RecyclerView.g0(view);
        }

        @Override // a.io.a
        public void i(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0 != null) {
                d0VarG0.B(RecyclerView.this);
            }
        }

        @Override // a.io.a
        public void j(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0 != null) {
                d0VarG0.C(RecyclerView.this);
            }
        }

        @Override // a.io.a
        public void k(View view, int i) {
            RecyclerView.this.addView(view, i);
            RecyclerView.this.z(view);
        }
    }

    public class f implements go.a {
        public f() {
        }

        @Override // a.go.a
        public d0 a(int i) {
            d0 d0VarB0 = RecyclerView.this.b0(i, true);
            if (d0VarB0 == null || RecyclerView.this.f4322a.n(d0VarB0.f4387a)) {
                return null;
            }
            return d0VarB0;
        }

        @Override // a.go.a
        public void b(go.b bVar) {
            i(bVar);
        }

        @Override // a.go.a
        public void c(int i, int i2) {
            RecyclerView.this.A0(i, i2);
            RecyclerView.this.n = true;
        }

        @Override // a.go.a
        public void d(int i, int i2, Object obj) {
            RecyclerView.this.v1(i, i2, obj);
            RecyclerView.this.o = true;
        }

        @Override // a.go.a
        public void e(int i, int i2) {
            RecyclerView.this.B0(i, i2);
            RecyclerView.this.n = true;
        }

        @Override // a.go.a
        public void f(go.b bVar) {
            i(bVar);
        }

        @Override // a.go.a
        public void g(int i, int i2) {
            RecyclerView.this.C0(i, i2, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.n = true;
            recyclerView.f4330a.c += i2;
        }

        @Override // a.go.a
        public void h(int i, int i2) {
            RecyclerView.this.C0(i, i2, false);
            RecyclerView.this.n = true;
        }

        public void i(go.b bVar) {
            int i = bVar.f6226a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f4337a.X0(recyclerView, bVar.b, bVar.c);
                return;
            }
            if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f4337a.a1(recyclerView2, bVar.b, bVar.c);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f4337a.c1(recyclerView3, bVar.b, bVar.c, bVar.f1047a);
            } else {
                if (i != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f4337a.Z0(recyclerView4, bVar.b, bVar.c, 1);
            }
        }
    }

    public static abstract class g<VH extends d0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f8231a = new h();
        public boolean b = false;

        public final void c(VH vh, int i) {
            vh.f8228a = i;
            if (h()) {
                vh.f4386a = f(i);
            }
            vh.F(1, 519);
            ud.a("RV OnBindView");
            o(vh, i, vh.o());
            vh.d();
            ViewGroup.LayoutParams layoutParams = vh.f4387a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).b = true;
            }
            ud.b();
        }

        public final VH d(ViewGroup viewGroup, int i) {
            try {
                ud.a("RV CreateView");
                VH vh = (VH) p(viewGroup, i);
                if (vh.f4387a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.f4396c = i;
                return vh;
            } finally {
                ud.b();
            }
        }

        public abstract int e();

        public long f(int i) {
            return -1L;
        }

        public int g(int i) {
            return 0;
        }

        public final boolean h() {
            return this.b;
        }

        public final void i() {
            this.f8231a.a();
        }

        public final void j(int i) {
            this.f8231a.c(i, 1);
        }

        public final void k(int i, int i2) {
            this.f8231a.b(i, i2);
        }

        public final void l(int i) {
            this.f8231a.e(i, 1);
        }

        public void m(RecyclerView recyclerView) {
        }

        public abstract void n(VH vh, int i);

        public void o(VH vh, int i, List<Object> list) {
            n(vh, i);
        }

        public abstract VH p(ViewGroup viewGroup, int i);

        public void q(RecyclerView recyclerView) {
        }

        public boolean r(VH vh) {
            return false;
        }

        public void s(VH vh) {
        }

        public void t(VH vh) {
        }

        public void u(VH vh) {
        }

        public void v(i iVar) {
            this.f8231a.registerObserver(iVar);
        }

        public void w(i iVar) {
            this.f8231a.unregisterObserver(iVar);
        }
    }

    public static class h extends Observable<i> {
        public void a() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void b(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i, i2, 1);
            }
        }

        public void c(int i, int i2) {
            d(i, i2, null);
        }

        public void d(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).b(i, i2, obj);
            }
        }

        public void e(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).d(i, i2);
            }
        }
    }

    public static abstract class i {
        public abstract void a();

        public abstract void b(int i, int i2, Object obj);

        public abstract void c(int i, int i2, int i3);

        public abstract void d(int i, int i2);
    }

    public interface j {
        int a(int i, int i2);
    }

    public static class k {
        public EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public a f4397a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ArrayList<xp> f4398a = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8232a = 120;
        public long b = 120;
        public long c = 250;
        public long d = 250;

        public interface a {
            void a(d0 d0Var);
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8233a;
            public int b;

            public b a(d0 d0Var) {
                b(d0Var, 0);
                return this;
            }

            public b b(d0 d0Var, int i) {
                View view = d0Var.f4387a;
                this.f8233a = view.getLeft();
                this.b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        public static int e(d0 d0Var) {
            int i = d0Var.e & 14;
            if (d0Var.t()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iN = d0Var.n();
            int iJ = d0Var.j();
            return (iN == -1 || iJ == -1 || iN == iJ) ? i : i | 2048;
        }

        public abstract boolean a(d0 d0Var, b bVar, b bVar2);

        public abstract boolean b(d0 d0Var, d0 d0Var2, b bVar, b bVar2);

        public abstract boolean c(d0 d0Var, b bVar, b bVar2);

        public abstract boolean d(d0 d0Var, b bVar, b bVar2);

        public abstract boolean f(d0 d0Var);

        public boolean g(d0 d0Var, List<Object> list) {
            return f(d0Var);
        }

        public final void h(d0 d0Var) {
            s(d0Var);
            a aVar = this.f4397a;
            if (aVar != null) {
                aVar.a(d0Var);
            }
        }

        public final void i() {
            int size = this.f4398a.size();
            for (int i = 0; i < size; i++) {
                this.f4398a.get(i).a();
            }
            this.f4398a.clear();
        }

        public abstract void j(d0 d0Var);

        public abstract void k();

        public long l() {
            return this.f8232a;
        }

        public long m() {
            return this.d;
        }

        public long n() {
            return this.c;
        }

        public long o() {
            return this.b;
        }

        public abstract boolean p();

        public final boolean q(xp xpVar) {
            boolean zP = p();
            if (xpVar != null) {
                if (zP) {
                    this.f4398a.add(xpVar);
                } else {
                    xpVar.a();
                }
            }
            return zP;
        }

        public b r() {
            return new b();
        }

        public void s(d0 d0Var) {
        }

        public b t(a0 a0Var, d0 d0Var) {
            b bVarR = r();
            bVarR.a(d0Var);
            return bVarR;
        }

        public b u(a0 a0Var, d0 d0Var, int i, List<Object> list) {
            b bVarR = r();
            bVarR.a(d0Var);
            return bVarR;
        }

        public abstract void v();

        public void w(a aVar) {
            this.f4397a = aVar;
        }
    }

    public class m implements l.a {
        public m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.a
        public void a(d0 d0Var) {
            d0Var.G(true);
            if (d0Var.f4388a != null && d0Var.f4394b == null) {
                d0Var.f4388a = null;
            }
            d0Var.f4394b = null;
            if (d0Var.I() || RecyclerView.this.U0(d0Var.f4387a) || !d0Var.x()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d0Var.f4387a, false);
        }
    }

    public static abstract class n {
        @Deprecated
        public void f(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            f(rect, ((p) view.getLayoutParams()).q(), recyclerView);
        }

        @Deprecated
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            h(canvas, recyclerView);
        }

        public abstract void j(Canvas canvas, RecyclerView recyclerView, a0 a0Var);
    }

    public static abstract class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8235a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public io f4399a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public z f4402a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public RecyclerView f4403a;
        public int b;
        public int c;
        public int d;
        public int e;
        public boolean f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final jq f4400a = new yp(this);

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final jq f4404b = new zp(this);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public kq f4401a = new kq(this.f4400a);

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public kq f4405b = new kq(this.f4404b);

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4406b = false;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f4407c = false;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f4408d = true;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public boolean f4409e = true;

        public interface a {
            void a(int i, int i2);
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8236a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f4410a;
            public int b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            public boolean f4411b;
        }

        public static boolean C0(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int U(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L20
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L20
                goto L2f
            L1a:
                if (r7 < 0) goto L1e
            L1c:
                r5 = r3
                goto L31
            L1e:
                if (r7 != r1) goto L22
            L20:
                r7 = r4
                goto L31
            L22:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L29
                goto L2c
            L29:
                r7 = r4
                r5 = r6
                goto L31
            L2c:
                r7 = r4
                r5 = r2
                goto L31
            L2f:
                r5 = r6
                r7 = r5
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.U(int, int, int, int, boolean):int");
        }

        public static b n0(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, fo.RecyclerView, i, i2);
            bVar.f8236a = typedArrayObtainStyledAttributes.getInt(fo.RecyclerView_android_orientation, 1);
            bVar.b = typedArrayObtainStyledAttributes.getInt(fo.RecyclerView_spanCount, 1);
            bVar.f4410a = typedArrayObtainStyledAttributes.getBoolean(fo.RecyclerView_reverseLayout, false);
            bVar.f4411b = typedArrayObtainStyledAttributes.getBoolean(fo.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        public static int x(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        public abstract int A(a0 a0Var);

        public boolean A0(v vVar, a0 a0Var) {
            return false;
        }

        public void A1() {
            this.f4406b = true;
        }

        public abstract int B(a0 a0Var);

        public boolean B0() {
            return this.f4408d;
        }

        public final void B1(v vVar, int i, View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0.J()) {
                return;
            }
            if (d0VarG0.t() && !d0VarG0.v() && !this.f4403a.f4332a.h()) {
                w1(i);
                vVar.C(d0VarG0);
            } else {
                H(i);
                vVar.D(view);
                this.f4403a.f4324a.k(d0VarG0);
            }
        }

        public abstract int C(a0 a0Var);

        public abstract int C1(int i, v vVar, a0 a0Var);

        public abstract int D(a0 a0Var);

        public boolean D0() {
            z zVar = this.f4402a;
            return zVar != null && zVar.c();
        }

        public abstract void D1(int i);

        public abstract int E(a0 a0Var);

        public boolean E0(View view, boolean z, boolean z2) {
            boolean z3 = this.f4401a.b(view, 24579) && this.f4405b.b(view, 24579);
            return z ? z3 : !z3;
        }

        public abstract int E1(int i, v vVar, a0 a0Var);

        public abstract int F(a0 a0Var);

        public void F0(View view, int i, int i2, int i3, int i4) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f8237a;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        public void F1(RecyclerView recyclerView) {
            G1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void G(v vVar) {
            for (int iT = T() - 1; iT >= 0; iT--) {
                B1(vVar, iT, S(iT));
            }
        }

        public void G0(View view, int i, int i2) {
            p pVar = (p) view.getLayoutParams();
            Rect rectK0 = this.f4403a.k0(view);
            int i3 = i + rectK0.left + rectK0.right;
            int i4 = i2 + rectK0.top + rectK0.bottom;
            int iU = U(t0(), u0(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) pVar).width, u());
            int iU2 = U(g0(), h0(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) pVar).height, v());
            if (L1(view, iU, iU2, pVar)) {
                view.measure(iU, iU2);
            }
        }

        public void G1(int i, int i2) {
            this.d = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.b = mode;
            if (mode == 0 && !RecyclerView.r) {
                this.d = 0;
            }
            this.e = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.c = mode2;
            if (mode2 != 0 || RecyclerView.r) {
                return;
            }
            this.e = 0;
        }

        public void H(int i) {
            I(i, S(i));
        }

        public void H0(int i, int i2) {
            View viewS = S(i);
            if (viewS != null) {
                H(i);
                r(viewS, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f4403a.toString());
            }
        }

        public void H1(int i, int i2) {
            this.f4403a.setMeasuredDimension(i, i2);
        }

        public final void I(int i, View view) {
            this.f4399a.d(i);
        }

        public void I0(int i) {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                recyclerView.y0(i);
            }
        }

        public void I1(Rect rect, int i, int i2) {
            H1(x(i, rect.width() + getPaddingLeft() + getPaddingRight(), l0()), x(i2, rect.height() + getPaddingTop() + getPaddingBottom(), k0()));
        }

        public void J(RecyclerView recyclerView) {
            this.f4407c = true;
            M0(recyclerView);
        }

        public void J0(int i) {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                recyclerView.z0(i);
            }
        }

        public void J1(int i, int i2) {
            int iT = T();
            if (iT == 0) {
                this.f4403a.x(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < iT; i7++) {
                View viewS = S(i7);
                Rect rect = this.f4403a.f4325a;
                Z(viewS, rect);
                int i8 = rect.left;
                if (i8 < i4) {
                    i4 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i5) {
                    i5 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.f4403a.f4325a.set(i4, i5, i3, i6);
            I1(this.f4403a.f4325a, i, i2);
        }

        public void K(RecyclerView recyclerView, v vVar) {
            this.f4407c = false;
            O0(recyclerView, vVar);
        }

        public void K0(g gVar, g gVar2) {
        }

        public void K1(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f4403a = null;
                this.f4399a = null;
                height = 0;
                this.d = 0;
            } else {
                this.f4403a = recyclerView;
                this.f4399a = recyclerView.f4322a;
                this.d = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.e = height;
            this.b = 1073741824;
            this.c = 1073741824;
        }

        public View L(View view) {
            View viewT;
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView == null || (viewT = recyclerView.T(view)) == null || this.f4399a.n(viewT)) {
                return null;
            }
            return viewT;
        }

        public boolean L0(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public boolean L1(View view, int i, int i2, p pVar) {
            return (!view.isLayoutRequested() && this.f4408d && C0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && C0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View M(int i) {
            int iT = T();
            for (int i2 = 0; i2 < iT; i2++) {
                View viewS = S(i2);
                d0 d0VarG0 = RecyclerView.g0(viewS);
                if (d0VarG0 != null && d0VarG0.m() == i && !d0VarG0.J() && (this.f4403a.f4330a.e() || !d0VarG0.v())) {
                    return viewS;
                }
            }
            return null;
        }

        public void M0(RecyclerView recyclerView) {
        }

        public boolean M1() {
            return false;
        }

        public abstract p N();

        @Deprecated
        public void N0(RecyclerView recyclerView) {
        }

        public boolean N1(View view, int i, int i2, p pVar) {
            return (this.f4408d && C0(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && C0(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public p O(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void O0(RecyclerView recyclerView, v vVar) {
            N0(recyclerView);
        }

        public void O1() {
            z zVar = this.f4402a;
            if (zVar == null) {
                return;
            }
            zVar.g();
            throw null;
        }

        public p P(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public View P0(View view, int i, v vVar, a0 a0Var) {
            return null;
        }

        public boolean P1() {
            return false;
        }

        public int Q() {
            return -1;
        }

        public void Q0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f4403a;
            R0(recyclerView.f4341a, recyclerView.f4330a, accessibilityEvent);
        }

        public int R(View view) {
            return ((p) view.getLayoutParams()).f8237a.bottom;
        }

        public void R0(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f4403a.canScrollVertically(-1) && !this.f4403a.canScrollHorizontally(-1) && !this.f4403a.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            g gVar = this.f4403a.f4332a;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.e());
            }
        }

        public View S(int i) {
            io ioVar = this.f4399a;
            if (ioVar != null) {
                return ioVar.f(i);
            }
            return null;
        }

        public void S0(ni niVar) {
            RecyclerView recyclerView = this.f4403a;
            T0(recyclerView.f4341a, recyclerView.f4330a, niVar);
        }

        public int T() {
            io ioVar = this.f4399a;
            if (ioVar != null) {
                return ioVar.g();
            }
            return 0;
        }

        public void T0(v vVar, a0 a0Var, ni niVar) {
            if (this.f4403a.canScrollVertically(-1) || this.f4403a.canScrollHorizontally(-1)) {
                niVar.a(8192);
                niVar.u0(true);
            }
            if (this.f4403a.canScrollVertically(1) || this.f4403a.canScrollHorizontally(1)) {
                niVar.a(4096);
                niVar.u0(true);
            }
            niVar.c0(ni.b.a(p0(vVar, a0Var), X(vVar, a0Var), A0(vVar, a0Var), q0(vVar, a0Var)));
        }

        public void U0(View view, ni niVar) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0 == null || d0VarG0.v() || this.f4399a.n(d0VarG0.f4387a)) {
                return;
            }
            RecyclerView recyclerView = this.f4403a;
            V0(recyclerView.f4341a, recyclerView.f4330a, view, niVar);
        }

        public final int[] V(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int iT0 = t0() - getPaddingRight();
            int iG0 = g0() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - paddingLeft;
            int iMin = Math.min(0, i);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iT0;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iG0);
            if (i0() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public void V0(v vVar, a0 a0Var, View view, ni niVar) {
            niVar.d0(ni.c.a(v() ? m0(view) : 0, 1, u() ? m0(view) : 0, 1, false, false));
        }

        public boolean W() {
            RecyclerView recyclerView = this.f4403a;
            return recyclerView != null && recyclerView.f4355b;
        }

        public View W0(View view, int i) {
            return null;
        }

        public int X(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView == null || recyclerView.f4332a == null || !u()) {
                return 1;
            }
            return this.f4403a.f4332a.e();
        }

        public void X0(RecyclerView recyclerView, int i, int i2) {
        }

        public int Y(View view) {
            return view.getBottom() + R(view);
        }

        public void Y0(RecyclerView recyclerView) {
        }

        public void Z(View view, Rect rect) {
            RecyclerView.h0(view, rect);
        }

        public void Z0(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public int a0(View view) {
            return view.getLeft() - j0(view);
        }

        public void a1(RecyclerView recyclerView, int i, int i2) {
        }

        public int b0(View view) {
            Rect rect = ((p) view.getLayoutParams()).f8237a;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void b1(RecyclerView recyclerView, int i, int i2) {
        }

        public int c0(View view) {
            Rect rect = ((p) view.getLayoutParams()).f8237a;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void c1(RecyclerView recyclerView, int i, int i2, Object obj) {
            b1(recyclerView, i, i2);
        }

        public int d0(View view) {
            return view.getRight() + o0(view);
        }

        public abstract void d1(v vVar, a0 a0Var);

        public int e0(View view) {
            return view.getTop() - r0(view);
        }

        public void e1(a0 a0Var) {
        }

        public View f0() {
            View focusedChild;
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f4399a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void f1(v vVar, a0 a0Var, int i, int i2) {
            this.f4403a.x(i, i2);
        }

        public int g0() {
            return this.e;
        }

        @Deprecated
        public boolean g1(RecyclerView recyclerView, View view, View view2) {
            return D0() || recyclerView.u0();
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                return eh.C(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                return eh.D(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int h0() {
            return this.c;
        }

        public boolean h1(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return g1(recyclerView, view, view2);
        }

        public int i0() {
            return eh.y(this.f4403a);
        }

        public abstract void i1(Parcelable parcelable);

        public int j0(View view) {
            return ((p) view.getLayoutParams()).f8237a.left;
        }

        public abstract Parcelable j1();

        public int k0() {
            return eh.z(this.f4403a);
        }

        public void k1(int i) {
        }

        public void l(View view) {
            m(view, -1);
        }

        public int l0() {
            return eh.A(this.f4403a);
        }

        public boolean l1(int i, Bundle bundle) {
            RecyclerView recyclerView = this.f4403a;
            return m1(recyclerView.f4341a, recyclerView.f4330a, i, bundle);
        }

        public void m(View view, int i) {
            p(view, i, true);
        }

        public int m0(View view) {
            return ((p) view.getLayoutParams()).q();
        }

        public boolean m1(v vVar, a0 a0Var, int i, Bundle bundle) {
            int iG0;
            int iT0;
            int i2;
            int i3;
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                iG0 = recyclerView.canScrollVertically(1) ? (g0() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.f4403a.canScrollHorizontally(1)) {
                    iT0 = (t0() - getPaddingLeft()) - getPaddingRight();
                    i2 = iG0;
                    i3 = iT0;
                }
                i2 = iG0;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                iG0 = recyclerView.canScrollVertically(-1) ? -((g0() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.f4403a.canScrollHorizontally(-1)) {
                    iT0 = -((t0() - getPaddingLeft()) - getPaddingRight());
                    i2 = iG0;
                    i3 = iT0;
                }
                i2 = iG0;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.f4403a.o1(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void n(View view) {
            o(view, -1);
        }

        public boolean n1(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.f4403a;
            return o1(recyclerView.f4341a, recyclerView.f4330a, view, i, bundle);
        }

        public void o(View view, int i) {
            p(view, i, false);
        }

        public int o0(View view) {
            return ((p) view.getLayoutParams()).f8237a.right;
        }

        public boolean o1(v vVar, a0 a0Var, View view, int i, Bundle bundle) {
            return false;
        }

        public final void p(View view, int i, boolean z) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (z || d0VarG0.v()) {
                this.f4403a.f4324a.b(d0VarG0);
            } else {
                this.f4403a.f4324a.p(d0VarG0);
            }
            p pVar = (p) view.getLayoutParams();
            if (d0VarG0.L() || d0VarG0.w()) {
                if (d0VarG0.w()) {
                    d0VarG0.K();
                } else {
                    d0VarG0.e();
                }
                this.f4399a.c(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f4403a) {
                int iM = this.f4399a.m(view);
                if (i == -1) {
                    i = this.f4399a.g();
                }
                if (iM == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f4403a.indexOfChild(view) + this.f4403a.Q());
                }
                if (iM != i) {
                    this.f4403a.f4337a.H0(iM, i);
                }
            } else {
                this.f4399a.a(view, i, false);
                pVar.b = true;
                z zVar = this.f4402a;
                if (zVar != null && zVar.c()) {
                    this.f4402a.e(view);
                }
            }
            if (pVar.c) {
                d0VarG0.f4387a.invalidate();
                pVar.c = false;
            }
        }

        public int p0(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView == null || recyclerView.f4332a == null || !v()) {
                return 1;
            }
            return this.f4403a.f4332a.e();
        }

        public void p1() {
            for (int iT = T() - 1; iT >= 0; iT--) {
                this.f4399a.q(iT);
            }
        }

        public void q(String str) {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int q0(v vVar, a0 a0Var) {
            return 0;
        }

        public void q1(v vVar) {
            for (int iT = T() - 1; iT >= 0; iT--) {
                if (!RecyclerView.g0(S(iT)).J()) {
                    t1(iT, vVar);
                }
            }
        }

        public void r(View view, int i) {
            s(view, i, (p) view.getLayoutParams());
        }

        public int r0(View view) {
            return ((p) view.getLayoutParams()).f8237a.top;
        }

        public void r1(v vVar) {
            int iJ = vVar.j();
            for (int i = iJ - 1; i >= 0; i--) {
                View viewN = vVar.n(i);
                d0 d0VarG0 = RecyclerView.g0(viewN);
                if (!d0VarG0.J()) {
                    d0VarG0.G(false);
                    if (d0VarG0.x()) {
                        this.f4403a.removeDetachedView(viewN, false);
                    }
                    l lVar = this.f4403a.f4336a;
                    if (lVar != null) {
                        lVar.j(d0VarG0);
                    }
                    d0VarG0.G(true);
                    vVar.y(viewN);
                }
            }
            vVar.e();
            if (iJ > 0) {
                this.f4403a.invalidate();
            }
        }

        public void s(View view, int i, p pVar) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0.v()) {
                this.f4403a.f4324a.b(d0VarG0);
            } else {
                this.f4403a.f4324a.p(d0VarG0);
            }
            this.f4399a.c(view, i, pVar, d0VarG0.v());
        }

        public void s0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((p) view.getLayoutParams()).f8237a;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f4403a != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f4403a.f4326a;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void s1(View view, v vVar) {
            v1(view);
            vVar.B(view);
        }

        public void t(View view, Rect rect) {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.k0(view));
            }
        }

        public int t0() {
            return this.d;
        }

        public void t1(int i, v vVar) {
            View viewS = S(i);
            w1(i);
            vVar.B(viewS);
        }

        public abstract boolean u();

        public int u0() {
            return this.b;
        }

        public boolean u1(Runnable runnable) {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public abstract boolean v();

        public boolean v0() {
            int iT = T();
            for (int i = 0; i < iT; i++) {
                ViewGroup.LayoutParams layoutParams = S(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void v1(View view) {
            this.f4399a.p(view);
        }

        public boolean w(p pVar) {
            return pVar != null;
        }

        public boolean w0() {
            return this.f4407c;
        }

        public void w1(int i) {
            if (S(i) != null) {
                this.f4399a.q(i);
            }
        }

        public abstract boolean x0();

        public boolean x1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return y1(recyclerView, view, rect, z, false);
        }

        public void y(int i, int i2, a0 a0Var, a aVar) {
        }

        public final boolean y0(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int iT0 = t0() - getPaddingRight();
            int iG0 = g0() - getPaddingBottom();
            Rect rect = this.f4403a.f4325a;
            Z(focusedChild, rect);
            return rect.left - i < iT0 && rect.right - i > paddingLeft && rect.top - i2 < iG0 && rect.bottom - i2 > paddingTop;
        }

        public boolean y1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrV = V(view, rect);
            int i = iArrV[0];
            int i2 = iArrV[1];
            if ((z2 && !y0(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.l1(i, i2);
            }
            return true;
        }

        public void z(int i, a aVar) {
        }

        public final boolean z0() {
            return this.f4409e;
        }

        public void z1() {
            RecyclerView recyclerView = this.f4403a;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f8237a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public d0 f4412a;
        public boolean b;
        public boolean c;

        public p(int i, int i2) {
            super(i, i2);
            this.f8237a = new Rect();
            this.b = true;
            this.c = false;
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8237a = new Rect();
            this.b = true;
            this.c = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8237a = new Rect();
            this.b = true;
            this.c = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8237a = new Rect();
            this.b = true;
            this.c = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f8237a = new Rect();
            this.b = true;
            this.c = false;
        }

        public int q() {
            return this.f4412a.m();
        }

        public boolean r() {
            return this.f4412a.y();
        }

        public boolean s() {
            return this.f4412a.v();
        }

        public boolean t() {
            return this.f4412a.t();
        }
    }

    public interface q {
        void b(View view);

        void e(View view);
    }

    public static abstract class r {
        public abstract boolean a(int i, int i2);
    }

    public interface s {
        void a(boolean z);

        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);

        void d(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i) {
        }

        public abstract void b(RecyclerView recyclerView, int i, int i2);
    }

    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public SparseArray<aq> f4413a = new SparseArray<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8238a = 0;

        public void a() {
            this.f8238a++;
        }

        public void b() {
            for (int i = 0; i < this.f4413a.size(); i++) {
                this.f4413a.valueAt(i).f100a.clear();
            }
        }

        public void c() {
            this.f8238a--;
        }

        public void d(int i, long j) {
            aq aqVarG = g(i);
            aqVarG.b = j(aqVarG.b, j);
        }

        public void e(int i, long j) {
            aq aqVarG = g(i);
            aqVarG.f99a = j(aqVarG.f99a, j);
        }

        public d0 f(int i) {
            aq aqVar = this.f4413a.get(i);
            if (aqVar == null || aqVar.f100a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = aqVar.f100a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).r()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public final aq g(int i) {
            aq aqVar = this.f4413a.get(i);
            if (aqVar != null) {
                return aqVar;
            }
            aq aqVar2 = new aq();
            this.f4413a.put(i, aqVar2);
            return aqVar2;
        }

        public void h(g gVar, g gVar2, boolean z) {
            if (gVar != null) {
                c();
            }
            if (!z && this.f8238a == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(d0 d0Var) {
            int iL = d0Var.l();
            ArrayList<d0> arrayList = g(iL).f100a;
            if (this.f4413a.get(iL).f5631a <= arrayList.size()) {
                return;
            }
            d0Var.D();
            arrayList.add(d0Var);
        }

        public long j(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public boolean k(int i, long j, long j2) {
            long j3 = g(i).b;
            return j3 == 0 || j + j3 < j2;
        }

        public boolean l(int i, long j, long j2) {
            long j3 = g(i).f99a;
            return j3 == 0 || j + j3 < j2;
        }
    }

    public final class v {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public b0 f4414a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public u f4415a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ArrayList<d0> f4417a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ArrayList<d0> f4419b = null;
        public final ArrayList<d0> c = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<d0> f4418a = Collections.unmodifiableList(this.f4417a);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8239a = 2;
        public int b = 2;

        public v() {
        }

        public void A(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        public void B(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            if (d0VarG0.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (d0VarG0.w()) {
                d0VarG0.K();
            } else if (d0VarG0.L()) {
                d0VarG0.e();
            }
            C(d0VarG0);
            if (RecyclerView.this.f4336a == null || d0VarG0.u()) {
                return;
            }
            RecyclerView.this.f4336a.j(d0VarG0);
        }

        public void C(d0 d0Var) {
            boolean z;
            boolean z2 = true;
            if (d0Var.w() || d0Var.f4387a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d0Var.w());
                sb.append(" isAttached:");
                sb.append(d0Var.f4387a.getParent() != null);
                sb.append(RecyclerView.this.Q());
                throw new IllegalArgumentException(sb.toString());
            }
            if (d0Var.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.Q());
            }
            if (d0Var.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.Q());
            }
            boolean zH = d0Var.h();
            g gVar = RecyclerView.this.f4332a;
            if ((gVar != null && zH && gVar.r(d0Var)) || d0Var.u()) {
                if (this.b <= 0 || d0Var.p(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.b && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.t && size > 0 && !RecyclerView.this.f4317a.d(d0Var.f8228a)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.f4317a.d(this.c.get(i).f8228a)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.c.add(size, d0Var);
                    z = true;
                }
                if (z) {
                    z2 = false;
                } else {
                    a(d0Var, true);
                }
                z = z;
            } else {
                z2 = false;
            }
            RecyclerView.this.f4324a.q(d0Var);
            if (z || z2 || !zH) {
                return;
            }
            d0Var.f4390a = null;
        }

        public void D(View view) {
            ArrayList<d0> arrayList;
            d0 d0VarG0 = RecyclerView.g0(view);
            if (!d0VarG0.p(12) && d0VarG0.y() && !RecyclerView.this.q(d0VarG0)) {
                if (this.f4419b == null) {
                    this.f4419b = new ArrayList<>();
                }
                d0VarG0.H(this, true);
                arrayList = this.f4419b;
            } else {
                if (d0VarG0.t() && !d0VarG0.v() && !RecyclerView.this.f4332a.h()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.Q());
                }
                d0VarG0.H(this, false);
                arrayList = this.f4417a;
            }
            arrayList.add(d0VarG0);
        }

        public void E(u uVar) {
            u uVar2 = this.f4415a;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f4415a = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f4415a.a();
        }

        public void F(b0 b0Var) {
            this.f4414a = b0Var;
        }

        public void G(int i) {
            this.f8239a = i;
            K();
        }

        public final boolean H(d0 d0Var, int i, int i2, long j) {
            d0Var.f4390a = RecyclerView.this;
            int iL = d0Var.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.f4415a.k(iL, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.f4332a.c(d0Var, i);
            this.f4415a.d(d0Var.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.f4330a.e()) {
                return true;
            }
            d0Var.d = i2;
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0221 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0224  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0181 A[PHI: r1 r4
  0x0181: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$d0) = (r1v11 androidx.recyclerview.widget.RecyclerView$d0), (r1v31 androidx.recyclerview.widget.RecyclerView$d0) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x0181: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.d0 I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instruction units count: 608
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$d0");
        }

        public void J(d0 d0Var) {
            (d0Var.f4393a ? this.f4419b : this.f4417a).remove(d0Var);
            d0Var.f4389a = null;
            d0Var.f4393a = false;
            d0Var.e();
        }

        public void K() {
            o oVar = RecyclerView.this.f4337a;
            this.b = this.f8239a + (oVar != null ? oVar.f8235a : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.b; size--) {
                A(size);
            }
        }

        public boolean L(d0 d0Var) {
            if (d0Var.v()) {
                return RecyclerView.this.f4330a.e();
            }
            int i = d0Var.f8228a;
            if (i >= 0 && i < RecyclerView.this.f4332a.e()) {
                if (RecyclerView.this.f4330a.e() || RecyclerView.this.f4332a.g(d0Var.f8228a) == d0Var.l()) {
                    return !RecyclerView.this.f4332a.h() || d0Var.k() == RecyclerView.this.f4332a.f(d0Var.f8228a);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.Q());
        }

        public void M(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.c.get(size);
                if (d0Var != null && (i3 = d0Var.f8228a) >= i && i3 < i4) {
                    d0Var.b(2);
                    A(size);
                }
            }
        }

        public void a(d0 d0Var, boolean z) {
            RecyclerView.s(d0Var);
            View view = d0Var.f4387a;
            dq dqVar = RecyclerView.this.f4319a;
            if (dqVar != null) {
                rf rfVarN = dqVar.n();
                eh.k0(view, rfVarN instanceof cq ? ((cq) rfVarN).n(view) : null);
            }
            if (z) {
                g(d0Var);
            }
            d0Var.f4390a = null;
            i().i(d0Var);
        }

        public final void b(d0 d0Var) {
            if (RecyclerView.this.t0()) {
                View view = d0Var.f4387a;
                if (eh.w(view) == 0) {
                    eh.t0(view, 1);
                }
                dq dqVar = RecyclerView.this.f4319a;
                if (dqVar == null) {
                    return;
                }
                rf rfVarN = dqVar.n();
                if (rfVarN instanceof cq) {
                    ((cq) rfVarN).o(view);
                }
                eh.k0(view, rfVarN);
            }
        }

        public void c() {
            this.f4417a.clear();
            z();
        }

        public void d() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).c();
            }
            int size2 = this.f4417a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f4417a.get(i2).c();
            }
            ArrayList<d0> arrayList = this.f4419b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f4419b.get(i3).c();
                }
            }
        }

        public void e() {
            this.f4417a.clear();
            ArrayList<d0> arrayList = this.f4419b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i) {
            if (i >= 0 && i < RecyclerView.this.f4330a.b()) {
                return !RecyclerView.this.f4330a.e() ? i : RecyclerView.this.f4320a.m(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.f4330a.b() + RecyclerView.this.Q());
        }

        public void g(d0 d0Var) {
            w wVar = RecyclerView.this.f4342a;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.f4332a;
            if (gVar != null) {
                gVar.u(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f4330a != null) {
                recyclerView.f4324a.q(d0Var);
            }
        }

        public d0 h(int i) {
            int size;
            int iM;
            ArrayList<d0> arrayList = this.f4419b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    d0 d0Var = this.f4419b.get(i2);
                    if (!d0Var.L() && d0Var.m() == i) {
                        d0Var.b(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.f4332a.h() && (iM = RecyclerView.this.f4320a.m(i)) > 0 && iM < RecyclerView.this.f4332a.e()) {
                    long jF = RecyclerView.this.f4332a.f(iM);
                    for (int i3 = 0; i3 < size; i3++) {
                        d0 d0Var2 = this.f4419b.get(i3);
                        if (!d0Var2.L() && d0Var2.k() == jF) {
                            d0Var2.b(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        public u i() {
            if (this.f4415a == null) {
                this.f4415a = new u();
            }
            return this.f4415a;
        }

        public int j() {
            return this.f4417a.size();
        }

        public List<d0> k() {
            return this.f4418a;
        }

        public d0 l(long j, int i, boolean z) {
            for (int size = this.f4417a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f4417a.get(size);
                if (d0Var.k() == j && !d0Var.L()) {
                    if (i == d0Var.l()) {
                        d0Var.b(32);
                        if (d0Var.v() && !RecyclerView.this.f4330a.e()) {
                            d0Var.F(2, 14);
                        }
                        return d0Var;
                    }
                    if (!z) {
                        this.f4417a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f4387a, false);
                        y(d0Var.f4387a);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.c.get(size2);
                if (d0Var2.k() == j && !d0Var2.r()) {
                    if (i == d0Var2.l()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return d0Var2;
                    }
                    if (!z) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        public d0 m(int i, boolean z) {
            View viewE;
            int size = this.f4417a.size();
            for (int i2 = 0; i2 < size; i2++) {
                d0 d0Var = this.f4417a.get(i2);
                if (!d0Var.L() && d0Var.m() == i && !d0Var.t() && (RecyclerView.this.f4330a.f4377b || !d0Var.v())) {
                    d0Var.b(32);
                    return d0Var;
                }
            }
            if (z || (viewE = RecyclerView.this.f4322a.e(i)) == null) {
                int size2 = this.c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d0 d0Var2 = this.c.get(i3);
                    if (!d0Var2.t() && d0Var2.m() == i && !d0Var2.r()) {
                        if (!z) {
                            this.c.remove(i3);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 d0VarG0 = RecyclerView.g0(viewE);
            RecyclerView.this.f4322a.s(viewE);
            int iM = RecyclerView.this.f4322a.m(viewE);
            if (iM != -1) {
                RecyclerView.this.f4322a.d(iM);
                D(viewE);
                d0VarG0.b(8224);
                return d0VarG0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + d0VarG0 + RecyclerView.this.Q());
        }

        public View n(int i) {
            return this.f4417a.get(i).f4387a;
        }

        public View o(int i) {
            return p(i, false);
        }

        public View p(int i, boolean z) {
            return I(i, z, Long.MAX_VALUE).f4387a;
        }

        public final void q(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z) {
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

        public final void r(d0 d0Var) {
            View view = d0Var.f4387a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public void s() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                p pVar = (p) this.c.get(i).f4387a.getLayoutParams();
                if (pVar != null) {
                    pVar.b = true;
                }
            }
        }

        public void t() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                d0 d0Var = this.c.get(i);
                if (d0Var != null) {
                    d0Var.b(6);
                    d0Var.a(null);
                }
            }
            g gVar = RecyclerView.this.f4332a;
            if (gVar == null || !gVar.h()) {
                z();
            }
        }

        public void u(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                d0 d0Var = this.c.get(i3);
                if (d0Var != null && d0Var.f8228a >= i) {
                    d0Var.A(i2, true);
                }
            }
        }

        public void v(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.c.size();
            for (int i7 = 0; i7 < size; i7++) {
                d0 d0Var = this.c.get(i7);
                if (d0Var != null && (i6 = d0Var.f8228a) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        d0Var.A(i2 - i, false);
                    } else {
                        d0Var.A(i3, false);
                    }
                }
            }
        }

        public void w(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.c.get(size);
                if (d0Var != null) {
                    int i4 = d0Var.f8228a;
                    if (i4 >= i3) {
                        d0Var.A(-i2, z);
                    } else if (i4 >= i) {
                        d0Var.b(8);
                        A(size);
                    }
                }
            }
        }

        public void x(g gVar, g gVar2, boolean z) {
            c();
            i().h(gVar, gVar2, z);
        }

        public void y(View view) {
            d0 d0VarG0 = RecyclerView.g0(view);
            d0VarG0.f4389a = null;
            d0VarG0.f4393a = false;
            d0VarG0.e();
            C(d0VarG0);
        }

        public void z() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.c.clear();
            if (RecyclerView.t) {
                RecyclerView.this.f4317a.b();
            }
        }
    }

    public interface w {
        void a(d0 d0Var);
    }

    public class x extends i {
        public x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.p(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f4330a.f4376a = true;
            recyclerView.O0(true);
            if (RecyclerView.this.f4320a.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i, int i2, Object obj) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f4320a.r(i, i2, obj)) {
                e();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i, int i2, int i3) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f4320a.s(i, i2, i3)) {
                e();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i, int i2) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f4320a.t(i, i2)) {
                e();
            }
        }

        public void e() {
            if (RecyclerView.s) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f4362d && recyclerView.f4359c) {
                    eh.c0(recyclerView, recyclerView.f4345a);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.f4370j = true;
            recyclerView2.requestLayout();
        }
    }

    public static class y extends ak {
        public static final Parcelable.Creator<y> CREATOR = new bq();
        public Parcelable b;

        public y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.b = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        public y(Parcelable parcelable) {
            super(parcelable);
        }

        public void r(y yVar) {
            this.b = yVar.b;
        }

        @Override // a.ak, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.b, 0);
        }
    }

    public static abstract class z {
        public abstract int a();

        public abstract boolean b();

        public abstract boolean c();

        public abstract void d(int i, int i2);

        public abstract void e(View view);

        public abstract void f(int i);

        public final void g() {
            throw null;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        q = i2 == 18 || i2 == 19 || i2 == 20;
        r = Build.VERSION.SDK_INT >= 23;
        s = Build.VERSION.SDK_INT >= 16;
        t = Build.VERSION.SDK_INT >= 21;
        u = Build.VERSION.SDK_INT <= 15;
        v = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        f4314a = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f8222a = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, co.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4343a = new x();
        this.f4341a = new v();
        this.f4324a = new mq();
        this.f4345a = new a();
        this.f4325a = new Rect();
        this.f4350b = new Rect();
        this.f4326a = new RectF();
        this.f4346a = new ArrayList<>();
        this.f4353b = new ArrayList<>();
        this.f4316a = 0;
        this.f4371k = false;
        this.f4372l = false;
        this.c = 0;
        this.d = 0;
        this.f4334a = new k();
        this.f4336a = new to();
        this.f4364e = 0;
        this.f = -1;
        this.f4315a = Float.MIN_VALUE;
        this.b = Float.MIN_VALUE;
        boolean z2 = true;
        this.f4373m = true;
        this.f4331a = new c0();
        this.f4317a = t ? new ap.a() : null;
        this.f4330a = new a0();
        this.n = false;
        this.o = false;
        this.f4335a = new m();
        this.p = false;
        this.f4348a = new int[2];
        this.f4356b = new int[2];
        this.f4360c = new int[2];
        this.f4363d = new int[2];
        this.f4358c = new ArrayList();
        this.f4352b = new b();
        this.f4323a = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.k = viewConfiguration.getScaledTouchSlop();
        this.f4315a = fh.b(viewConfiguration, context);
        this.b = fh.d(viewConfiguration, context);
        this.l = viewConfiguration.getScaledMinimumFlingVelocity();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f4336a.w(this.f4335a);
        o0();
        q0();
        p0();
        if (eh.w(this) == 0) {
            eh.t0(this, 1);
        }
        this.f4328a = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new dq(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, fo.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, fo.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(fo.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(fo.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f4355b = typedArrayObtainStyledAttributes.getBoolean(fo.RecyclerView_android_clipToPadding, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(fo.RecyclerView_fastScrollEnabled, false);
        this.f4365e = z3;
        if (z3) {
            r0((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(fo.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(fo.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(fo.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(fo.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        w(context, string, attributeSet, i2, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, e, i2, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, e, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
            }
            z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z2);
    }

    public static RecyclerView X(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewX = X(viewGroup.getChildAt(i2));
            if (recyclerViewX != null) {
                return recyclerViewX;
            }
        }
        return null;
    }

    public static d0 g0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f4412a;
    }

    private ig getScrollingChildHelper() {
        if (this.f4321a == null) {
            this.f4321a = new ig(this);
        }
        return this.f4321a;
    }

    public static void h0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f8237a;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    public static void s(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f4391a;
        if (weakReference != null) {
            Object parent = weakReference.get();
            while (true) {
                for (View view = (View) parent; view != null; view = null) {
                    if (view == d0Var.f4387a) {
                        return;
                    }
                    parent = view.getParent();
                    if (parent instanceof View) {
                        break;
                    }
                }
                d0Var.f4391a = null;
                return;
            }
        }
    }

    public void A(View view) {
        d0 d0VarG0 = g0(view);
        E0(view);
        g gVar = this.f4332a;
        if (gVar != null && d0VarG0 != null) {
            gVar.t(d0VarG0);
        }
        List<q> list = this.f4347a;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4347a.get(size).b(view);
            }
        }
    }

    public void A0(int i2, int i3) {
        int iJ = this.f4322a.j();
        for (int i4 = 0; i4 < iJ; i4++) {
            d0 d0VarG0 = g0(this.f4322a.i(i4));
            if (d0VarG0 != null && !d0VarG0.J() && d0VarG0.f8228a >= i2) {
                d0VarG0.A(i3, false);
                this.f4330a.f4376a = true;
            }
        }
        this.f4341a.u(i2, i3);
        requestLayout();
    }

    public final void B() {
        int i2 = this.f4349b;
        this.f4349b = 0;
        if (i2 == 0 || !t0()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        mi.b(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public void B0(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iJ = this.f4322a.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < iJ; i8++) {
            d0 d0VarG0 = g0(this.f4322a.i(i8));
            if (d0VarG0 != null && (i7 = d0VarG0.f8228a) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    d0VarG0.A(i3 - i2, false);
                } else {
                    d0VarG0.A(i6, false);
                }
                this.f4330a.f4376a = true;
            }
        }
        this.f4341a.v(i2, i3);
        requestLayout();
    }

    public void C() {
        String str;
        if (this.f4332a == null) {
            str = "No adapter attached; skipping layout";
        } else {
            if (this.f4337a != null) {
                a0 a0Var = this.f4330a;
                a0Var.f4379d = false;
                if (a0Var.d != 1) {
                    if (!this.f4320a.q() && this.f4337a.t0() == getWidth() && this.f4337a.g0() == getHeight()) {
                        this.f4337a.F1(this);
                    }
                    F();
                    return;
                }
                D();
                this.f4337a.F1(this);
                E();
                F();
                return;
            }
            str = "No layout manager attached; skipping layout";
        }
        Log.e("RecyclerView", str);
    }

    public void C0(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iJ = this.f4322a.j();
        for (int i5 = 0; i5 < iJ; i5++) {
            d0 d0VarG0 = g0(this.f4322a.i(i5));
            if (d0VarG0 != null && !d0VarG0.J()) {
                int i6 = d0VarG0.f8228a;
                if (i6 >= i4) {
                    d0VarG0.A(-i3, z2);
                } else if (i6 >= i2) {
                    d0VarG0.i(i2 - 1, -i3, z2);
                }
                this.f4330a.f4376a = true;
            }
        }
        this.f4341a.w(i2, i3, z2);
        requestLayout();
    }

    public final void D() {
        this.f4330a.a(1);
        R(this.f4330a);
        this.f4330a.f4379d = false;
        p1();
        this.f4324a.f();
        F0();
        N0();
        d1();
        a0 a0Var = this.f4330a;
        a0Var.f4378c = a0Var.f4380e && this.o;
        this.o = false;
        this.n = false;
        a0 a0Var2 = this.f4330a;
        a0Var2.f4377b = a0Var2.f4381f;
        a0Var2.e = this.f4332a.e();
        W(this.f4348a);
        if (this.f4330a.f4380e) {
            int iG = this.f4322a.g();
            for (int i2 = 0; i2 < iG; i2++) {
                d0 d0VarG0 = g0(this.f4322a.f(i2));
                if (!d0VarG0.J() && (!d0VarG0.t() || this.f4332a.h())) {
                    this.f4324a.e(d0VarG0, this.f4336a.u(this.f4330a, d0VarG0, l.e(d0VarG0), d0VarG0.o()));
                    if (this.f4330a.f4378c && d0VarG0.y() && !d0VarG0.v() && !d0VarG0.J() && !d0VarG0.t()) {
                        this.f4324a.c(e0(d0VarG0), d0VarG0);
                    }
                }
            }
        }
        if (this.f4330a.f4381f) {
            e1();
            a0 a0Var3 = this.f4330a;
            boolean z2 = a0Var3.f4376a;
            a0Var3.f4376a = false;
            this.f4337a.d1(this.f4341a, a0Var3);
            this.f4330a.f4376a = z2;
            for (int i3 = 0; i3 < this.f4322a.g(); i3++) {
                d0 d0VarG02 = g0(this.f4322a.f(i3));
                if (!d0VarG02.J() && !this.f4324a.i(d0VarG02)) {
                    int iE = l.e(d0VarG02);
                    boolean zP = d0VarG02.p(8192);
                    if (!zP) {
                        iE |= 4096;
                    }
                    l.b bVarU = this.f4336a.u(this.f4330a, d0VarG02, iE, d0VarG02.o());
                    if (zP) {
                        Q0(d0VarG02, bVarU);
                    } else {
                        this.f4324a.a(d0VarG02, bVarU);
                    }
                }
            }
        }
        t();
        G0();
        r1(false);
        this.f4330a.d = 2;
    }

    public void D0(View view) {
    }

    public final void E() {
        p1();
        F0();
        this.f4330a.a(6);
        this.f4320a.j();
        this.f4330a.e = this.f4332a.e();
        a0 a0Var = this.f4330a;
        a0Var.c = 0;
        a0Var.f4377b = false;
        this.f4337a.d1(this.f4341a, a0Var);
        a0 a0Var2 = this.f4330a;
        a0Var2.f4376a = false;
        this.f4344a = null;
        a0Var2.f4380e = a0Var2.f4380e && this.f4336a != null;
        this.f4330a.d = 4;
        G0();
        r1(false);
    }

    public void E0(View view) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.F():void");
    }

    public void F0() {
        this.c++;
    }

    public boolean G(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    public void G0() {
        H0(true);
    }

    public final void H(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void H0(boolean z2) {
        int i2 = this.c - 1;
        this.c = i2;
        if (i2 < 1) {
            this.c = 0;
            if (z2) {
                B();
                K();
            }
        }
    }

    public void I(int i2) {
        o oVar = this.f4337a;
        if (oVar != null) {
            oVar.k1(i2);
        }
        J0(i2);
        t tVar = this.f4340a;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List<t> list = this.f4354b;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4354b.get(size).a(this, i2);
            }
        }
    }

    public final void I0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.i = x2;
            this.g = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.j = y2;
            this.h = y2;
        }
    }

    public void J(int i2, int i3) {
        this.d++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        K0(i2, i3);
        t tVar = this.f4340a;
        if (tVar != null) {
            tVar.b(this, i2, i3);
        }
        List<t> list = this.f4354b;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4354b.get(size).b(this, i2, i3);
            }
        }
        this.d--;
    }

    public void J0(int i2) {
    }

    public void K() {
        int i2;
        for (int size = this.f4358c.size() - 1; size >= 0; size--) {
            d0 d0Var = this.f4358c.get(size);
            if (d0Var.f4387a.getParent() == this && !d0Var.J() && (i2 = d0Var.h) != -1) {
                eh.t0(d0Var.f4387a, i2);
                d0Var.h = -1;
            }
        }
        this.f4358c.clear();
    }

    public void K0(int i2, int i3) {
    }

    public final boolean L(MotionEvent motionEvent) {
        s sVar = this.f4339a;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return V(motionEvent);
        }
        sVar.d(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f4339a = null;
        }
        return true;
    }

    public void L0() {
        if (this.p || !this.f4359c) {
            return;
        }
        eh.c0(this, this.f4352b);
        this.p = true;
    }

    public void M() {
        int measuredWidth;
        int measuredHeight;
        if (this.f4361d != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f4334a.a(this, 3);
        this.f4361d = edgeEffectA;
        if (this.f4355b) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffectA.setSize(measuredWidth, measuredHeight);
    }

    public final boolean M0() {
        return this.f4336a != null && this.f4337a.P1();
    }

    public void N() {
        int measuredHeight;
        int measuredWidth;
        if (this.f4329a != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f4334a.a(this, 0);
        this.f4329a = edgeEffectA;
        if (this.f4355b) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffectA.setSize(measuredHeight, measuredWidth);
    }

    public final void N0() {
        if (this.f4371k) {
            this.f4320a.x();
            if (this.f4372l) {
                this.f4337a.Y0(this);
            }
        }
        if (M0()) {
            this.f4320a.v();
        } else {
            this.f4320a.j();
        }
        boolean z2 = false;
        boolean z3 = this.n || this.o;
        this.f4330a.f4380e = this.f4366f && this.f4336a != null && (this.f4371k || z3 || this.f4337a.f4406b) && (!this.f4371k || this.f4332a.h());
        a0 a0Var = this.f4330a;
        if (a0Var.f4380e && z3 && !this.f4371k && M0()) {
            z2 = true;
        }
        a0Var.f4381f = z2;
    }

    public void O() {
        int measuredHeight;
        int measuredWidth;
        if (this.f4357c != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f4334a.a(this, 2);
        this.f4357c = edgeEffectA;
        if (this.f4355b) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffectA.setSize(measuredHeight, measuredWidth);
    }

    public void O0(boolean z2) {
        this.f4372l = z2 | this.f4372l;
        this.f4371k = true;
        x0();
    }

    public void P() {
        int measuredWidth;
        int measuredHeight;
        if (this.f4351b != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.f4334a.a(this, 1);
        this.f4351b = edgeEffectA;
        if (this.f4355b) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffectA.setSize(measuredWidth, measuredHeight);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.N()
            android.widget.EdgeEffect r1 = r6.f4329a
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
        L1c:
            a.hj.a(r1, r4, r9)
            r9 = r3
            goto L39
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L38
            r6.O()
            android.widget.EdgeEffect r1 = r6.f4357c
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L53
            r6.P()
            android.widget.EdgeEffect r9 = r6.f4351b
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            a.hj.a(r9, r1, r7)
            goto L6f
        L53:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L6e
            r6.M()
            android.widget.EdgeEffect r9 = r6.f4361d
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            a.hj.a(r9, r1, r2)
            goto L6f
        L6e:
            r3 = r9
        L6f:
            if (r3 != 0) goto L79
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            a.eh.b0(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.P0(float, float, float, float):void");
    }

    public String Q() {
        return " " + super.toString() + ", adapter:" + this.f4332a + ", layout:" + this.f4337a + ", context:" + getContext();
    }

    public void Q0(d0 d0Var, l.b bVar) {
        d0Var.F(0, 8192);
        if (this.f4330a.f4378c && d0Var.y() && !d0Var.v() && !d0Var.J()) {
            this.f4324a.c(e0(d0Var), d0Var);
        }
        this.f4324a.e(d0Var, bVar);
    }

    public final void R(a0 a0Var) {
        if (getScrollState() != 2) {
            a0Var.h = 0;
            a0Var.i = 0;
        } else {
            OverScroller overScroller = this.f4331a.f4383a;
            a0Var.h = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.i = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public final void R0() {
        View viewFindViewById;
        if (!this.f4373m || this.f4332a == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!v || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.f4322a.n(focusedChild)) {
                    return;
                }
            } else if (this.f4322a.g() == 0) {
                requestFocus();
                return;
            }
        }
        View viewY = null;
        d0 d0VarA0 = (this.f4330a.f4374a == -1 || !this.f4332a.h()) ? null : a0(this.f4330a.f4374a);
        if (d0VarA0 != null && !this.f4322a.n(d0VarA0.f4387a) && d0VarA0.f4387a.hasFocusable()) {
            viewY = d0VarA0.f4387a;
        } else if (this.f4322a.g() > 0) {
            viewY = Y();
        }
        if (viewY != null) {
            int i2 = this.f4330a.g;
            if (i2 != -1 && (viewFindViewById = viewY.findViewById(i2)) != null && viewFindViewById.isFocusable()) {
                viewY = viewFindViewById;
            }
            viewY.requestFocus();
        }
    }

    public View S(float f2, float f3) {
        for (int iG = this.f4322a.g() - 1; iG >= 0; iG--) {
            View viewF = this.f4322a.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (f2 >= viewF.getLeft() + translationX && f2 <= viewF.getRight() + translationX && f3 >= viewF.getTop() + translationY && f3 <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    public final void S0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f4329a;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f4329a.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f4351b;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f4351b.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f4357c;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f4357c.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f4361d;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f4361d.isFinished();
        }
        if (zIsFinished) {
            eh.b0(this);
        }
    }

    public View T(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public void T0() {
        l lVar = this.f4336a;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.f4337a;
        if (oVar != null) {
            oVar.q1(this.f4341a);
            this.f4337a.r1(this.f4341a);
        }
        this.f4341a.c();
    }

    public d0 U(View view) {
        View viewT = T(view);
        if (viewT == null) {
            return null;
        }
        return f0(viewT);
    }

    public boolean U0(View view) {
        p1();
        boolean zR = this.f4322a.r(view);
        if (zR) {
            d0 d0VarG0 = g0(view);
            this.f4341a.J(d0VarG0);
            this.f4341a.C(d0VarG0);
        }
        r1(!zR);
        return zR;
    }

    public final boolean V(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f4353b.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = this.f4353b.get(i2);
            if (sVar.c(this, motionEvent) && action != 3) {
                this.f4339a = sVar;
                return true;
            }
        }
        return false;
    }

    public void V0(n nVar) {
        o oVar = this.f4337a;
        if (oVar != null) {
            oVar.q("Cannot remove item decoration during a scroll  or layout");
        }
        this.f4346a.remove(nVar);
        if (this.f4346a.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        w0();
        requestLayout();
    }

    public final void W(int[] iArr) {
        int iG = this.f4322a.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iG; i4++) {
            d0 d0VarG0 = g0(this.f4322a.f(i4));
            if (!d0VarG0.J()) {
                int iM = d0VarG0.m();
                if (iM < i2) {
                    i2 = iM;
                }
                if (iM > i3) {
                    i3 = iM;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public void W0(q qVar) {
        List<q> list = this.f4347a;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    public void X0(s sVar) {
        this.f4353b.remove(sVar);
        if (this.f4339a == sVar) {
            this.f4339a = null;
        }
    }

    public final View Y() {
        d0 d0VarZ;
        int i2 = this.f4330a.f;
        if (i2 == -1) {
            i2 = 0;
        }
        int iB = this.f4330a.b();
        for (int i3 = i2; i3 < iB; i3++) {
            d0 d0VarZ2 = Z(i3);
            if (d0VarZ2 == null) {
                break;
            }
            if (d0VarZ2.f4387a.hasFocusable()) {
                return d0VarZ2.f4387a;
            }
        }
        int iMin = Math.min(iB, i2);
        do {
            iMin--;
            if (iMin < 0 || (d0VarZ = Z(iMin)) == null) {
                return null;
            }
        } while (!d0VarZ.f4387a.hasFocusable());
        return d0VarZ.f4387a;
    }

    public void Y0(t tVar) {
        List<t> list = this.f4354b;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public d0 Z(int i2) {
        d0 d0Var = null;
        if (this.f4371k) {
            return null;
        }
        int iJ = this.f4322a.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            d0 d0VarG0 = g0(this.f4322a.i(i3));
            if (d0VarG0 != null && !d0VarG0.v() && d0(d0VarG0) == i2) {
                if (!this.f4322a.n(d0VarG0.f4387a)) {
                    return d0VarG0;
                }
                d0Var = d0VarG0;
            }
        }
        return d0Var;
    }

    public void Z0() {
        d0 d0Var;
        int iG = this.f4322a.g();
        for (int i2 = 0; i2 < iG; i2++) {
            View viewF = this.f4322a.f(i2);
            d0 d0VarF0 = f0(viewF);
            if (d0VarF0 != null && (d0Var = d0VarF0.f4394b) != null) {
                View view = d0Var.f4387a;
                int left = viewF.getLeft();
                int top = viewF.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void a(int i2, int i3) {
        if (i2 < 0) {
            N();
            if (this.f4329a.isFinished()) {
                this.f4329a.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            O();
            if (this.f4357c.isFinished()) {
                this.f4357c.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            P();
            if (this.f4351b.isFinished()) {
                this.f4351b.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            M();
            if (this.f4361d.isFinished()) {
                this.f4361d.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        eh.b0(this);
    }

    public d0 a0(long j2) {
        g gVar = this.f4332a;
        d0 d0Var = null;
        if (gVar != null && gVar.h()) {
            int iJ = this.f4322a.j();
            for (int i2 = 0; i2 < iJ; i2++) {
                d0 d0VarG0 = g0(this.f4322a.i(i2));
                if (d0VarG0 != null && !d0VarG0.v() && d0VarG0.k() == j2) {
                    if (!this.f4322a.n(d0VarG0.f4387a)) {
                        return d0VarG0;
                    }
                    d0Var = d0VarG0;
                }
            }
        }
        return d0Var;
    }

    public final void a1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f4325a.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.b) {
                Rect rect = pVar.f8237a;
                Rect rect2 = this.f4325a;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f4325a);
            offsetRectIntoDescendantCoords(view, this.f4325a);
        }
        this.f4337a.y1(this, view, this.f4325a, !this.f4366f, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        o oVar = this.f4337a;
        if (oVar == null || !oVar.L0(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.d0 b0(int r6, boolean r7) {
        /*
            r5 = this;
            a.io r0 = r5.f4322a
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            a.io r3 = r5.f4322a
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$d0 r3 = g0(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.v()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f8228a
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            a.io r1 = r5.f4322a
            android.view.View r4 = r3.f4387a
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.b0(int, boolean):androidx.recyclerview.widget.RecyclerView$d0");
    }

    public final void b1() {
        a0 a0Var = this.f4330a;
        a0Var.f4374a = -1L;
        a0Var.f = -1;
        a0Var.g = -1;
    }

    public boolean c0(int i2, int i3) {
        o oVar = this.f4337a;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f4368h) {
            return false;
        }
        boolean zU = oVar.u();
        boolean zV = this.f4337a.v();
        if (!zU || Math.abs(i2) < this.l) {
            i2 = 0;
        }
        if (!zV || Math.abs(i3) < this.l) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z2 = zU || zV;
            dispatchNestedFling(f2, f3, z2);
            r rVar = this.f4338a;
            if (rVar != null && rVar.a(i2, i3)) {
                return true;
            }
            if (z2) {
                int i4 = zU ? 1 : 0;
                if (zV) {
                    i4 |= 2;
                }
                q1(i4, 1);
                int i5 = this.m;
                int iMax = Math.max(-i5, Math.min(i2, i5));
                int i6 = this.m;
                this.f4331a.c(iMax, Math.max(-i6, Math.min(i3, i6)));
                return true;
            }
        }
        return false;
    }

    public final void c1() {
        VelocityTracker velocityTracker = this.f4327a;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        s1(0);
        S0();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.f4337a.w((p) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.f4337a;
        if (oVar != null && oVar.u()) {
            return this.f4337a.A(this.f4330a);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.f4337a;
        if (oVar != null && oVar.u()) {
            return this.f4337a.B(this.f4330a);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.f4337a;
        if (oVar != null && oVar.u()) {
            return this.f4337a.C(this.f4330a);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.f4337a;
        if (oVar != null && oVar.v()) {
            return this.f4337a.D(this.f4330a);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.f4337a;
        if (oVar != null && oVar.v()) {
            return this.f4337a.E(this.f4330a);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.f4337a;
        if (oVar != null && oVar.v()) {
            return this.f4337a.F(this.f4330a);
        }
        return 0;
    }

    public int d0(d0 d0Var) {
        if (d0Var.p(524) || !d0Var.s()) {
            return -1;
        }
        return this.f4320a.e(d0Var.f8228a);
    }

    public final void d1() {
        View focusedChild = (this.f4373m && hasFocus() && this.f4332a != null) ? getFocusedChild() : null;
        d0 d0VarU = focusedChild != null ? U(focusedChild) : null;
        if (d0VarU == null) {
            b1();
            return;
        }
        this.f4330a.f4374a = this.f4332a.h() ? d0VarU.k() : -1L;
        this.f4330a.f = this.f4371k ? -1 : d0VarU.v() ? d0VarU.b : d0VarU.j();
        this.f4330a.g = i0(d0VarU.f4387a);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
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
        boolean z2;
        float paddingRight;
        int paddingBottom;
        super.draw(canvas);
        int size = this.f4346a.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.f4346a.get(i2).j(canvas, this, this.f4330a);
        }
        EdgeEffect edgeEffect = this.f4329a;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom2 = this.f4355b ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom2, 0.0f);
            EdgeEffect edgeEffect2 = this.f4329a;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f4351b;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f4355b) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f4351b;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f4357c;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f4355b ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f4357c;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f4361d;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f4355b) {
                paddingRight = (-getWidth()) + getPaddingRight();
                paddingBottom = (-getHeight()) + getPaddingBottom();
            } else {
                paddingRight = -getWidth();
                paddingBottom = -getHeight();
            }
            canvas.translate(paddingRight, paddingBottom);
            EdgeEffect edgeEffect8 = this.f4361d;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.f4336a == null || this.f4346a.size() <= 0 || !this.f4336a.p()) ? z2 : true) {
            eh.b0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public long e0(d0 d0Var) {
        return this.f4332a.h() ? d0Var.k() : d0Var.f8228a;
    }

    public void e1() {
        int iJ = this.f4322a.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            d0 d0VarG0 = g0(this.f4322a.i(i2));
            if (!d0VarG0.J()) {
                d0VarG0.E();
            }
        }
    }

    public d0 f0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return g0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean f1(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        v();
        if (this.f4332a != null) {
            int[] iArr = this.f4363d;
            iArr[0] = 0;
            iArr[1] = 0;
            g1(i2, i3, iArr);
            int[] iArr2 = this.f4363d;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i4 = i9;
            i5 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.f4346a.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.f4363d;
        iArr3[0] = 0;
        iArr3[1] = 0;
        H(i5, i4, i6, i7, this.f4356b, 0, iArr3);
        int[] iArr4 = this.f4363d;
        int i10 = i6 - iArr4[0];
        int i11 = i7 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.i;
        int[] iArr5 = this.f4356b;
        this.i = i12 - iArr5[0];
        this.j -= iArr5[1];
        int[] iArr6 = this.f4360c;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !gg.a(motionEvent, 8194)) {
                P0(motionEvent.getX(), i10, motionEvent.getY(), i11);
            }
            u(i2, i3);
        }
        if (i5 != 0 || i4 != 0) {
            J(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i5 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewP0;
        boolean z2;
        View viewW0 = this.f4337a.W0(view, i2);
        if (viewW0 != null) {
            return viewW0;
        }
        boolean z3 = (this.f4332a == null || this.f4337a == null || u0() || this.f4368h) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.f4337a.v()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (u) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.f4337a.u()) {
                int i4 = (this.f4337a.i0() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (u) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                v();
                if (T(view) == null) {
                    return null;
                }
                p1();
                this.f4337a.P0(view, i2, this.f4341a, this.f4330a);
                r1(false);
            }
            viewP0 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z3) {
                v();
                if (T(view) == null) {
                    return null;
                }
                p1();
                viewP0 = this.f4337a.P0(view, i2, this.f4341a, this.f4330a);
                r1(false);
            } else {
                viewP0 = viewFindNextFocus;
            }
        }
        if (viewP0 == null || viewP0.hasFocusable()) {
            return v0(view, viewP0, i2) ? viewP0 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a1(viewP0, null);
        return view;
    }

    public final void g(d0 d0Var) {
        View view = d0Var.f4387a;
        boolean z2 = view.getParent() == this;
        this.f4341a.J(f0(view));
        if (d0Var.x()) {
            this.f4322a.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        io ioVar = this.f4322a;
        if (z2) {
            ioVar.k(view);
        } else {
            ioVar.b(view, true);
        }
    }

    public void g1(int i2, int i3, int[] iArr) {
        p1();
        F0();
        ud.a("RV Scroll");
        R(this.f4330a);
        int iC1 = i2 != 0 ? this.f4337a.C1(i2, this.f4341a, this.f4330a) : 0;
        int iE1 = i3 != 0 ? this.f4337a.E1(i3, this.f4341a, this.f4330a) : 0;
        ud.b();
        Z0();
        G0();
        r1(false);
        if (iArr != null) {
            iArr[0] = iC1;
            iArr[1] = iE1;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.f4337a;
        if (oVar != null) {
            return oVar.N();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.f4337a;
        if (oVar != null) {
            return oVar.O(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.f4337a;
        if (oVar != null) {
            return oVar.P(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.f4332a;
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.f4337a;
        return oVar != null ? oVar.Q() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.f4333a;
        return jVar == null ? super.getChildDrawingOrder(i2, i3) : jVar.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f4355b;
    }

    public dq getCompatAccessibilityDelegate() {
        return this.f4319a;
    }

    public k getEdgeEffectFactory() {
        return this.f4334a;
    }

    public l getItemAnimator() {
        return this.f4336a;
    }

    public int getItemDecorationCount() {
        return this.f4346a.size();
    }

    public o getLayoutManager() {
        return this.f4337a;
    }

    public int getMaxFlingVelocity() {
        return this.m;
    }

    public int getMinFlingVelocity() {
        return this.l;
    }

    public long getNanoTime() {
        if (t) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.f4338a;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f4373m;
    }

    public u getRecycledViewPool() {
        return this.f4341a.i();
    }

    public int getScrollState() {
        return this.f4364e;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    public void h1(int i2) {
        if (this.f4368h) {
            return;
        }
        t1();
        o oVar = this.f4337a;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.D1(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(n nVar, int i2) {
        o oVar = this.f4337a;
        if (oVar != null) {
            oVar.q("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f4346a.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.f4346a.add(nVar);
        } else {
            this.f4346a.add(i2, nVar);
        }
        w0();
        requestLayout();
    }

    public final int i0(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    public final void i1(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.f4332a;
        if (gVar2 != null) {
            gVar2.w(this.f4343a);
            this.f4332a.q(this);
        }
        if (!z2 || z3) {
            T0();
        }
        this.f4320a.x();
        g gVar3 = this.f4332a;
        this.f4332a = gVar;
        if (gVar != null) {
            gVar.v(this.f4343a);
            gVar.m(this);
        }
        o oVar = this.f4337a;
        if (oVar != null) {
            oVar.K0(gVar3, this.f4332a);
        }
        this.f4341a.x(gVar3, this.f4332a, z2);
        this.f4330a.f4376a = true;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f4359c;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f4368h;
    }

    @Override // android.view.View, a.hg
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(q qVar) {
        if (this.f4347a == null) {
            this.f4347a = new ArrayList();
        }
        this.f4347a.add(qVar);
    }

    public final String j0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    public boolean j1(d0 d0Var, int i2) {
        if (!u0()) {
            eh.t0(d0Var.f4387a, i2);
            return true;
        }
        d0Var.h = i2;
        this.f4358c.add(d0Var);
        return false;
    }

    public void k(s sVar) {
        this.f4353b.add(sVar);
    }

    public Rect k0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.b) {
            return pVar.f8237a;
        }
        if (this.f4330a.e() && (pVar.r() || pVar.t())) {
            return pVar.f8237a;
        }
        Rect rect = pVar.f8237a;
        rect.set(0, 0, 0, 0);
        int size = this.f4346a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4325a.set(0, 0, 0, 0);
            this.f4346a.get(i2).g(this.f4325a, view, this, this.f4330a);
            int i3 = rect.left;
            Rect rect2 = this.f4325a;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.b = false;
        return rect;
    }

    public boolean k1(AccessibilityEvent accessibilityEvent) {
        if (!u0()) {
            return false;
        }
        int iA = accessibilityEvent != null ? mi.a(accessibilityEvent) : 0;
        this.f4349b |= iA != 0 ? iA : 0;
        return true;
    }

    public void l(t tVar) {
        if (this.f4354b == null) {
            this.f4354b = new ArrayList();
        }
        this.f4354b.add(tVar);
    }

    public final void l0(long j2, d0 d0Var, d0 d0Var2) {
        int iG = this.f4322a.g();
        for (int i2 = 0; i2 < iG; i2++) {
            d0 d0VarG0 = g0(this.f4322a.f(i2));
            if (d0VarG0 != d0Var && e0(d0VarG0) == j2) {
                g gVar = this.f4332a;
                if (gVar == null || !gVar.h()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + d0VarG0 + " \n View Holder 2:" + d0Var + Q());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + d0VarG0 + " \n View Holder 2:" + d0Var + Q());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + Q());
    }

    public void l1(int i2, int i3) {
        m1(i2, i3, null);
    }

    public void m(d0 d0Var, l.b bVar, l.b bVar2) {
        d0Var.G(false);
        if (this.f4336a.a(d0Var, bVar, bVar2)) {
            L0();
        }
    }

    public boolean m0() {
        return !this.f4366f || this.f4371k || this.f4320a.p();
    }

    public void m1(int i2, int i3, Interpolator interpolator) {
        n1(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public final void n(d0 d0Var, d0 d0Var2, l.b bVar, l.b bVar2, boolean z2, boolean z3) {
        d0Var.G(false);
        if (z2) {
            g(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z3) {
                g(d0Var2);
            }
            d0Var.f4388a = d0Var2;
            g(d0Var);
            this.f4341a.J(d0Var);
            d0Var2.G(false);
            d0Var2.f4394b = d0Var;
        }
        if (this.f4336a.b(d0Var, d0Var2, bVar, bVar2)) {
            L0();
        }
    }

    public final boolean n0() {
        int iG = this.f4322a.g();
        for (int i2 = 0; i2 < iG; i2++) {
            d0 d0VarG0 = g0(this.f4322a.f(i2));
            if (d0VarG0 != null && !d0VarG0.J() && d0VarG0.y()) {
                return true;
            }
        }
        return false;
    }

    public void n1(int i2, int i3, Interpolator interpolator, int i4) {
        o1(i2, i3, interpolator, i4, false);
    }

    public void o(d0 d0Var, l.b bVar, l.b bVar2) {
        g(d0Var);
        d0Var.G(false);
        if (this.f4336a.c(d0Var, bVar, bVar2)) {
            L0();
        }
    }

    public void o0() {
        this.f4320a = new go(new f());
    }

    public void o1(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        o oVar = this.f4337a;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f4368h) {
            return;
        }
        if (!oVar.u()) {
            i2 = 0;
        }
        if (!this.f4337a.v()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (!(i4 == Integer.MIN_VALUE || i4 > 0)) {
            scrollBy(i2, i3);
            return;
        }
        if (z2) {
            int i5 = i2 != 0 ? 1 : 0;
            if (i3 != 0) {
                i5 |= 2;
            }
            q1(i5, 1);
        }
        this.f4331a.f(i2, i3, i4, interpolator);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = 0;
        this.f4359c = true;
        this.f4366f = this.f4366f && !isLayoutRequested();
        o oVar = this.f4337a;
        if (oVar != null) {
            oVar.J(this);
        }
        this.p = false;
        if (t) {
            ap apVar = ap.f5627a.get();
            this.f4318a = apVar;
            if (apVar == null) {
                this.f4318a = new ap();
                Display displayS = eh.s(this);
                float f2 = 60.0f;
                if (!isInEditMode() && displayS != null) {
                    float refreshRate = displayS.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                ap apVar2 = this.f4318a;
                apVar2.b = (long) (1.0E9f / f2);
                ap.f5627a.set(apVar2);
            }
            this.f4318a.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ap apVar;
        super.onDetachedFromWindow();
        l lVar = this.f4336a;
        if (lVar != null) {
            lVar.k();
        }
        t1();
        this.f4359c = false;
        o oVar = this.f4337a;
        if (oVar != null) {
            oVar.K(this, this.f4341a);
        }
        this.f4358c.clear();
        removeCallbacks(this.f4352b);
        this.f4324a.j();
        if (!t || (apVar = this.f4318a) == null) {
            return;
        }
        apVar.j(this);
        this.f4318a = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f4346a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4346a.get(i2).i(canvas, this, this.f4330a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f4337a
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f4368h
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.f4337a
            boolean r0 = r0.v()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f4337a
            boolean r3 = r3.u()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f4337a
            boolean r3 = r3.v()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.f4337a
            boolean r3 = r3.u()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.f4315a
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.b
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.f1(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.f4368h) {
            return false;
        }
        this.f4339a = null;
        if (V(motionEvent)) {
            r();
            return true;
        }
        o oVar = this.f4337a;
        if (oVar == null) {
            return false;
        }
        boolean zU = oVar.u();
        boolean zV = this.f4337a.v();
        if (this.f4327a == null) {
            this.f4327a = VelocityTracker.obtain();
        }
        this.f4327a.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f4369i) {
                this.f4369i = false;
            }
            this.f = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.i = x2;
            this.g = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.j = y2;
            this.h = y2;
            if (this.f4364e == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                s1(1);
            }
            int[] iArr = this.f4360c;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zU ? 1 : 0;
            if (zV) {
                i2 |= 2;
            }
            q1(i2, 0);
        } else if (actionMasked == 1) {
            this.f4327a.clear();
            s1(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f4364e != 1) {
                int i3 = x3 - this.g;
                int i4 = y3 - this.h;
                if (!zU || Math.abs(i3) <= this.k) {
                    z2 = false;
                } else {
                    this.i = x3;
                    z2 = true;
                }
                if (zV && Math.abs(i4) > this.k) {
                    this.j = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.f = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.i = x4;
            this.g = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.j = y4;
            this.h = y4;
        } else if (actionMasked == 6) {
            I0(motionEvent);
        }
        return this.f4364e == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        ud.a("RV OnLayout");
        C();
        ud.b();
        this.f4366f = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        o oVar = this.f4337a;
        if (oVar == null) {
            x(i2, i3);
            return;
        }
        boolean z2 = false;
        if (oVar.x0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.f4337a.f1(this.f4341a, this.f4330a, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (z2 || this.f4332a == null) {
                return;
            }
            if (this.f4330a.d == 1) {
                D();
            }
            this.f4337a.G1(i2, i3);
            this.f4330a.f4379d = true;
            E();
            this.f4337a.J1(i2, i3);
            if (this.f4337a.M1()) {
                this.f4337a.G1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.f4330a.f4379d = true;
                E();
                this.f4337a.J1(i2, i3);
                return;
            }
            return;
        }
        if (this.f4362d) {
            this.f4337a.f1(this.f4341a, this.f4330a, i2, i3);
            return;
        }
        if (this.f4370j) {
            p1();
            F0();
            N0();
            G0();
            a0 a0Var = this.f4330a;
            if (a0Var.f4381f) {
                a0Var.f4377b = true;
            } else {
                this.f4320a.j();
                this.f4330a.f4377b = false;
            }
            this.f4370j = false;
            r1(false);
        } else if (this.f4330a.f4381f) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.f4332a;
        if (gVar != null) {
            this.f4330a.e = gVar.e();
        } else {
            this.f4330a.e = 0;
        }
        p1();
        this.f4337a.f1(this.f4341a, this.f4330a, i2, i3);
        r1(false);
        this.f4330a.f4377b = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (u0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.f4344a = yVar;
        super.onRestoreInstanceState(yVar.q());
        o oVar = this.f4337a;
        if (oVar == null || (parcelable2 = this.f4344a.b) == null) {
            return;
        }
        oVar.i1(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.f4344a;
        if (yVar2 != null) {
            yVar.r(yVar2);
        } else {
            o oVar = this.f4337a;
            yVar.b = oVar != null ? oVar.j1() : null;
        }
        return yVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        s0();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd A[PHI: r0
  0x00dd: PHI (r0v42 int) = (r0v31 int), (r0v46 int) binds: [B:41:0x00c8, B:46:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(String str) {
        if (u0()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + Q());
        }
        if (this.d > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + Q()));
        }
    }

    @SuppressLint({"InlinedApi"})
    public final void p0() {
        if (eh.x(this) == 0) {
            eh.u0(this, 8);
        }
    }

    public void p1() {
        int i2 = this.f4316a + 1;
        this.f4316a = i2;
        if (i2 != 1 || this.f4368h) {
            return;
        }
        this.f4367g = false;
    }

    public boolean q(d0 d0Var) {
        l lVar = this.f4336a;
        return lVar == null || lVar.g(d0Var, d0Var.o());
    }

    public final void q0() {
        this.f4322a = new io(new e());
    }

    public boolean q1(int i2, int i3) {
        return getScrollingChildHelper().p(i2, i3);
    }

    public final void r() {
        c1();
        setScrollState(0);
    }

    public void r0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new yo(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(Cdo.fastscroll_default_thickness), resources.getDimensionPixelSize(Cdo.fastscroll_minimum_range), resources.getDimensionPixelOffset(Cdo.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + Q());
        }
    }

    public void r1(boolean z2) {
        if (this.f4316a < 1) {
            this.f4316a = 1;
        }
        if (!z2 && !this.f4368h) {
            this.f4367g = false;
        }
        if (this.f4316a == 1) {
            if (z2 && this.f4367g && !this.f4368h && this.f4337a != null && this.f4332a != null) {
                C();
            }
            if (!this.f4368h) {
                this.f4367g = false;
            }
        }
        this.f4316a--;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        d0 d0VarG0 = g0(view);
        if (d0VarG0 != null) {
            if (d0VarG0.x()) {
                d0VarG0.f();
            } else if (!d0VarG0.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + d0VarG0 + Q());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f4337a.h1(this, this.f4330a, view, view2) && view2 != null) {
            a1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.f4337a.x1(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.f4353b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4353b.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f4316a != 0 || this.f4368h) {
            this.f4367g = true;
        } else {
            super.requestLayout();
        }
    }

    public void s0() {
        this.f4361d = null;
        this.f4351b = null;
        this.f4357c = null;
        this.f4329a = null;
    }

    public void s1(int i2) {
        getScrollingChildHelper().r(i2);
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        o oVar = this.f4337a;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f4368h) {
            return;
        }
        boolean zU = oVar.u();
        boolean zV = this.f4337a.v();
        if (zU || zV) {
            if (!zU) {
                i2 = 0;
            }
            if (!zV) {
                i3 = 0;
            }
            f1(i2, i3, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (k1(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(dq dqVar) {
        this.f4319a = dqVar;
        eh.k0(this, dqVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        i1(gVar, false, true);
        O0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.f4333a) {
            return;
        }
        this.f4333a = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.f4355b) {
            s0();
        }
        this.f4355b = z2;
        super.setClipToPadding(z2);
        if (this.f4366f) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        pf.b(kVar);
        this.f4334a = kVar;
        s0();
    }

    public void setHasFixedSize(boolean z2) {
        this.f4362d = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.f4336a;
        if (lVar2 != null) {
            lVar2.k();
            this.f4336a.w(null);
        }
        this.f4336a = lVar;
        if (lVar != null) {
            lVar.w(this.f4335a);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f4341a.G(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.f4337a) {
            return;
        }
        t1();
        if (this.f4337a != null) {
            l lVar = this.f4336a;
            if (lVar != null) {
                lVar.k();
            }
            this.f4337a.q1(this.f4341a);
            this.f4337a.r1(this.f4341a);
            this.f4341a.c();
            if (this.f4359c) {
                this.f4337a.K(this, this.f4341a);
            }
            this.f4337a.K1(null);
            this.f4337a = null;
        } else {
            this.f4341a.c();
        }
        this.f4322a.o();
        this.f4337a = oVar;
        if (oVar != null) {
            if (oVar.f4403a != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f4403a.Q());
            }
            oVar.K1(this);
            if (this.f4359c) {
                this.f4337a.J(this);
            }
        }
        this.f4341a.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().m(z2);
    }

    public void setOnFlingListener(r rVar) {
        this.f4338a = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.f4340a = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.f4373m = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.f4341a.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.f4342a = wVar;
    }

    public void setScrollState(int i2) {
        if (i2 == this.f4364e) {
            return;
        }
        this.f4364e = i2;
        if (i2 != 2) {
            u1();
        }
        I(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 == 0) {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else if (i2 != 1) {
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        } else {
            scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        }
        this.k = scaledTouchSlop;
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.f4341a.F(b0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().o(i2);
    }

    @Override // android.view.View, a.hg
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.f4368h) {
            p("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f4368h = true;
                this.f4369i = true;
                t1();
                return;
            }
            this.f4368h = false;
            if (this.f4367g && this.f4337a != null && this.f4332a != null) {
                requestLayout();
            }
            this.f4367g = false;
        }
    }

    public void t() {
        int iJ = this.f4322a.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            d0 d0VarG0 = g0(this.f4322a.i(i2));
            if (!d0VarG0.J()) {
                d0VarG0.c();
            }
        }
        this.f4341a.d();
    }

    public boolean t0() {
        AccessibilityManager accessibilityManager = this.f4328a;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public void t1() {
        setScrollState(0);
        u1();
    }

    public void u(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f4329a;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.f4329a.onRelease();
            zIsFinished = this.f4329a.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f4357c;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.f4357c.onRelease();
            zIsFinished |= this.f4357c.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f4351b;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.f4351b.onRelease();
            zIsFinished |= this.f4351b.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f4361d;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.f4361d.onRelease();
            zIsFinished |= this.f4361d.isFinished();
        }
        if (zIsFinished) {
            eh.b0(this);
        }
    }

    public boolean u0() {
        return this.c > 0;
    }

    public final void u1() {
        this.f4331a.g();
        o oVar = this.f4337a;
        if (oVar != null) {
            oVar.O1();
        }
    }

    public void v() {
        if (!this.f4366f || this.f4371k) {
            ud.a("RV FullInvalidate");
            C();
            ud.b();
            return;
        }
        if (this.f4320a.p()) {
            if (this.f4320a.o(4) && !this.f4320a.o(11)) {
                ud.a("RV PartialInvalidate");
                p1();
                F0();
                this.f4320a.v();
                if (!this.f4367g) {
                    if (n0()) {
                        C();
                    } else {
                        this.f4320a.i();
                    }
                }
                r1(true);
                G0();
            } else {
                if (!this.f4320a.p()) {
                    return;
                }
                ud.a("RV FullInvalidate");
                C();
            }
            ud.b();
        }
    }

    public final boolean v0(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || T(view2) == null) {
            return false;
        }
        if (view == null || T(view) == null) {
            return true;
        }
        this.f4325a.set(0, 0, view.getWidth(), view.getHeight());
        this.f4350b.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f4325a);
        offsetDescendantRectToMyCoords(view2, this.f4350b);
        byte b2 = -1;
        int i4 = this.f4337a.i0() == 1 ? -1 : 1;
        Rect rect = this.f4325a;
        int i5 = rect.left;
        int i6 = this.f4350b.left;
        if ((i5 < i6 || rect.right <= i6) && this.f4325a.right < this.f4350b.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.f4325a;
            int i7 = rect2.right;
            int i8 = this.f4350b.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.f4325a.left > this.f4350b.left) ? -1 : 0;
        }
        Rect rect3 = this.f4325a;
        int i9 = rect3.top;
        int i10 = this.f4350b.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.f4325a.bottom < this.f4350b.bottom) {
            b2 = 1;
        } else {
            Rect rect4 = this.f4325a;
            int i11 = rect4.bottom;
            int i12 = this.f4350b.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.f4325a.top <= this.f4350b.top) {
                b2 = 0;
            }
        }
        if (i2 == 1) {
            return b2 < 0 || (b2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return b2 > 0 || (b2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return b2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return b2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + Q());
    }

    public void v1(int i2, int i3, Object obj) {
        int i4;
        int iJ = this.f4322a.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < iJ; i6++) {
            View viewI = this.f4322a.i(i6);
            d0 d0VarG0 = g0(viewI);
            if (d0VarG0 != null && !d0VarG0.J() && (i4 = d0VarG0.f8228a) >= i2 && i4 < i5) {
                d0VarG0.b(2);
                d0VarG0.a(obj);
                ((p) viewI.getLayoutParams()).b = true;
            }
        }
        this.f4341a.M(i2, i3);
    }

    public final void w(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String strJ0 = j0(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(strJ0, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(f4314a);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strJ0, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strJ0, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strJ0, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strJ0, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strJ0, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strJ0, e8);
            }
        }
    }

    public void w0() {
        int iJ = this.f4322a.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            ((p) this.f4322a.i(i2).getLayoutParams()).b = true;
        }
        this.f4341a.s();
    }

    public void x(int i2, int i3) {
        setMeasuredDimension(o.x(i2, getPaddingLeft() + getPaddingRight(), eh.A(this)), o.x(i3, getPaddingTop() + getPaddingBottom(), eh.z(this)));
    }

    public void x0() {
        int iJ = this.f4322a.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            d0 d0VarG0 = g0(this.f4322a.i(i2));
            if (d0VarG0 != null && !d0VarG0.J()) {
                d0VarG0.b(6);
            }
        }
        w0();
        this.f4341a.t();
    }

    public final boolean y(int i2, int i3) {
        W(this.f4348a);
        int[] iArr = this.f4348a;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    public void y0(int i2) {
        int iG = this.f4322a.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.f4322a.f(i3).offsetLeftAndRight(i2);
        }
    }

    public void z(View view) {
        d0 d0VarG0 = g0(view);
        D0(view);
        g gVar = this.f4332a;
        if (gVar != null && d0VarG0 != null) {
            gVar.s(d0VarG0);
        }
        List<q> list = this.f4347a;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f4347a.get(size).e(view);
            }
        }
    }

    public void z0(int i2) {
        int iG = this.f4322a.g();
        for (int i3 = 0; i3 < iG; i3++) {
            this.f4322a.f(i3).offsetTopAndBottom(i2);
        }
    }
}
