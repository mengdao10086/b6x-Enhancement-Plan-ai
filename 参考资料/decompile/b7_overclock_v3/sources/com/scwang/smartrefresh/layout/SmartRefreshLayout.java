package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.f0;
import androidx.core.view.i0;
import androidx.core.view.j0;
import androidx.core.view.u0;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements mg.j, i0 {
    public static mg.a D8;
    public static mg.b E8;
    public static mg.c F8;
    public static ViewGroup.MarginLayoutParams G8 = new ViewGroup.MarginLayoutParams(-1, -1);
    public VelocityTracker A;
    public MotionEvent A8;
    public Interpolator B;
    public Runnable B8;
    public int[] C;
    public boolean C1;
    public boolean C2;
    public ValueAnimator C8;
    public boolean D;
    public boolean E7;
    public boolean F7;
    public boolean G7;
    public boolean H7;
    public boolean I7;
    public boolean J7;
    public boolean K0;
    public boolean K1;
    public boolean K2;
    public boolean K7;
    public boolean L7;
    public boolean M7;
    public boolean N7;
    public boolean O7;
    public boolean P7;
    public boolean Q7;
    public sg.d R7;
    public sg.b S7;
    public sg.c T7;
    public mg.k U7;
    public int V7;
    public boolean W7;
    public int[] X7;
    public f0 Y7;
    public j0 Z7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22188a;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public int f22189a8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22190b;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public ng.a f22191b8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22192c;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public int f22193c8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22194d;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public ng.a f22195d8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22196e;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public int f22197e8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f22198f;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public int f22199f8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22200g;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public float f22201g8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f22202h;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public float f22203h8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f22204i;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public float f22205i8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f22206j;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public float f22207j8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f22208k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f22209k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f22210k1;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public mg.h f22211k8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f22212l;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public mg.h f22213l8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f22214m;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public mg.e f22215m8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f22216n;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public Paint f22217n8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public char f22218o;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public Handler f22219o8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f22220p;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public mg.i f22221p8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f22222q;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public RefreshState f22223q8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f22224r;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public RefreshState f22225r8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f22226s;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public long f22227s8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f22228t;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public int f22229t8;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f22230u;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public int f22231u8;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f22232v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f22233v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f22234v2;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public boolean f22235v8;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f22236w;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public boolean f22237w8;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f22238x;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public boolean f22239x8;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f22240y;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public boolean f22241y8;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Scroller f22242z;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public boolean f22243z8;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22244a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f22244a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22244a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22244a[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22244a[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22244a[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f22244a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f22244a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f22244a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f22244a[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f22244a[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f22244a[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f22244a[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22245a;

        public b(boolean z10) {
            this.f22245a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.setStateDirectLoading(this.f22245a);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22247a;

        public c(boolean z10) {
            this.f22247a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout.this.f22227s8 = System.currentTimeMillis();
                SmartRefreshLayout.this.C0(RefreshState.Refreshing);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                sg.d dVar = smartRefreshLayout.R7;
                if (dVar != null) {
                    if (this.f22247a) {
                        dVar.o(smartRefreshLayout);
                    }
                } else if (smartRefreshLayout.T7 == null) {
                    smartRefreshLayout.u(3000);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                mg.h hVar = smartRefreshLayout2.f22211k8;
                if (hVar != null) {
                    int i10 = smartRefreshLayout2.f22189a8;
                    hVar.b(smartRefreshLayout2, i10, (int) (smartRefreshLayout2.f22201g8 * i10));
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                sg.c cVar = smartRefreshLayout3.T7;
                if (cVar == null || !(smartRefreshLayout3.f22211k8 instanceof mg.g)) {
                    return;
                }
                if (this.f22247a) {
                    cVar.o(smartRefreshLayout3);
                }
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                sg.c cVar2 = smartRefreshLayout4.T7;
                mg.g gVar = (mg.g) smartRefreshLayout4.f22211k8;
                int i11 = smartRefreshLayout4.f22189a8;
                cVar2.c(gVar, i11, (int) (smartRefreshLayout4.f22201g8 * i11));
            }
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RefreshState refreshState;
            RefreshState refreshState2;
            if (animator == null || animator.getDuration() != 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.C8 = null;
                if (smartRefreshLayout.f22190b == 0 && (refreshState = smartRefreshLayout.f22223q8) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
                    smartRefreshLayout.C0(refreshState2);
                    return;
                }
                RefreshState refreshState3 = smartRefreshLayout.f22223q8;
                if (refreshState3 != smartRefreshLayout.f22225r8) {
                    smartRefreshLayout.setViceState(refreshState3);
                }
            }
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.C8 != null) {
                smartRefreshLayout.f22221p8.k(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            sg.b bVar = smartRefreshLayout.S7;
            if (bVar != null) {
                bVar.g(smartRefreshLayout);
            } else if (smartRefreshLayout.T7 == null) {
                smartRefreshLayout.X(2000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            sg.c cVar = smartRefreshLayout2.T7;
            if (cVar != null) {
                cVar.g(smartRefreshLayout2);
            }
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22252a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Boolean f22254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f22255d;

        public g(int i10, Boolean bool, boolean z10) {
            this.f22253b = i10;
            this.f22254c = bool;
            this.f22255d = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f22252a;
            if (i10 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout.f22223q8;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 && smartRefreshLayout.f22225r8 == RefreshState.Refreshing) {
                    smartRefreshLayout.f22225r8 = refreshState2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.C8;
                    if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.C8.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.C8 = null;
                        if (smartRefreshLayout2.f22221p8.f(0) == null) {
                            SmartRefreshLayout.this.C0(refreshState2);
                        } else {
                            SmartRefreshLayout.this.C0(RefreshState.PullDownCanceled);
                        }
                    } else if (refreshState == RefreshState.Refreshing && smartRefreshLayout.f22211k8 != null && smartRefreshLayout.f22215m8 != null) {
                        this.f22252a = i10 + 1;
                        smartRefreshLayout.f22219o8.postDelayed(this, this.f22253b);
                        SmartRefreshLayout.this.C0(RefreshState.RefreshFinish);
                        if (this.f22254c == Boolean.FALSE) {
                            SmartRefreshLayout.this.a(false);
                        }
                    }
                }
                if (this.f22254c == Boolean.TRUE) {
                    SmartRefreshLayout.this.a(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int iL = smartRefreshLayout3.f22211k8.l(smartRefreshLayout3, this.f22255d);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            sg.c cVar = smartRefreshLayout4.T7;
            if (cVar != null) {
                mg.h hVar = smartRefreshLayout4.f22211k8;
                if (hVar instanceof mg.g) {
                    cVar.e((mg.g) hVar, this.f22255d);
                }
            }
            if (iL < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                if (smartRefreshLayout5.f22220p || smartRefreshLayout5.W7) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.f22220p) {
                        float f10 = smartRefreshLayout6.f22208k;
                        smartRefreshLayout6.f22204i = f10;
                        smartRefreshLayout6.f22194d = 0;
                        smartRefreshLayout6.f22220p = false;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout6.f22206j, (f10 + smartRefreshLayout6.f22190b) - (smartRefreshLayout6.f22188a * 2), 0));
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout7.f22206j, smartRefreshLayout7.f22208k + smartRefreshLayout7.f22190b, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.W7) {
                        smartRefreshLayout8.V7 = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout8.f22206j, smartRefreshLayout8.f22208k, 0));
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        smartRefreshLayout9.W7 = false;
                        smartRefreshLayout9.f22194d = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i11 = smartRefreshLayout10.f22190b;
                if (i11 <= 0) {
                    if (i11 < 0) {
                        smartRefreshLayout10.w0(0, iL, smartRefreshLayout10.B, smartRefreshLayout10.f22198f);
                        return;
                    } else {
                        smartRefreshLayout10.f22221p8.k(0, false);
                        SmartRefreshLayout.this.f22221p8.b(RefreshState.None);
                        return;
                    }
                }
                ValueAnimator valueAnimatorW0 = smartRefreshLayout10.w0(0, iL, smartRefreshLayout10.B, smartRefreshLayout10.f22198f);
                SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerG = smartRefreshLayout11.H7 ? smartRefreshLayout11.f22215m8.g(smartRefreshLayout11.f22190b) : null;
                if (valueAnimatorW0 == null || animatorUpdateListenerG == null) {
                    return;
                }
                valueAnimatorW0.addUpdateListener(animatorUpdateListenerG);
            }
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22257a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f22259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f22260d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f22262a;

            /* JADX INFO: renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$h$a$a, reason: collision with other inner class name */
            public class C0240a extends AnimatorListenerAdapter {
                public C0240a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator == null || animator.getDuration() != 0) {
                        h hVar = h.this;
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.f22241y8 = false;
                        if (hVar.f22259c) {
                            smartRefreshLayout.a(true);
                        }
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        if (smartRefreshLayout2.f22223q8 == RefreshState.LoadFinish) {
                            smartRefreshLayout2.C0(RefreshState.None);
                        }
                    }
                }
            }

            public a(int i10) {
                this.f22262a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerG;
                ValueAnimator valueAnimatorF;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.G7 || this.f22262a >= 0) {
                    animatorUpdateListenerG = null;
                } else {
                    animatorUpdateListenerG = smartRefreshLayout.f22215m8.g(smartRefreshLayout.f22190b);
                    if (animatorUpdateListenerG != null) {
                        animatorUpdateListenerG.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                C0240a c0240a = new C0240a();
                h hVar = h.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i10 = smartRefreshLayout2.f22190b;
                if (i10 > 0) {
                    valueAnimatorF = smartRefreshLayout2.f22221p8.f(0);
                } else {
                    if (animatorUpdateListenerG != null || i10 == 0) {
                        ValueAnimator valueAnimator = smartRefreshLayout2.C8;
                        if (valueAnimator != null) {
                            valueAnimator.setDuration(0L);
                            SmartRefreshLayout.this.C8.cancel();
                            SmartRefreshLayout.this.C8 = null;
                        }
                        SmartRefreshLayout.this.f22221p8.k(0, false);
                        SmartRefreshLayout.this.f22221p8.b(RefreshState.None);
                    } else if (hVar.f22259c && smartRefreshLayout2.K1) {
                        int i11 = smartRefreshLayout2.f22193c8;
                        if (i10 >= (-i11)) {
                            smartRefreshLayout2.C0(RefreshState.None);
                        } else {
                            valueAnimatorF = smartRefreshLayout2.f22221p8.f(-i11);
                        }
                    } else {
                        valueAnimatorF = smartRefreshLayout2.f22221p8.f(0);
                    }
                    valueAnimatorF = null;
                }
                if (valueAnimatorF != null) {
                    valueAnimatorF.addListener(c0240a);
                } else {
                    c0240a.onAnimationEnd(null);
                }
            }
        }

        public h(int i10, boolean z10, boolean z11) {
            this.f22258b = i10;
            this.f22259c = z10;
            this.f22260d = z11;
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 329
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.h.run():void");
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f22265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f22267c;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.C8 == null || smartRefreshLayout.f22211k8 == null) {
                    return;
                }
                smartRefreshLayout.f22221p8.k(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.C8 = null;
                    if (smartRefreshLayout.f22211k8 == null) {
                        smartRefreshLayout.f22221p8.b(RefreshState.None);
                        return;
                    }
                    RefreshState refreshState = smartRefreshLayout.f22223q8;
                    RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                    if (refreshState != refreshState2) {
                        smartRefreshLayout.f22221p8.b(refreshState2);
                    }
                    SmartRefreshLayout.this.setStateRefreshing(!r5.f22267c);
                }
            }
        }

        public i(float f10, int i10, boolean z10) {
            this.f22265a = f10;
            this.f22266b = i10;
            this.f22267c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f22225r8 != RefreshState.Refreshing) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.C8;
            if (valueAnimator != null) {
                valueAnimator.setDuration(0L);
                SmartRefreshLayout.this.C8.cancel();
                SmartRefreshLayout.this.C8 = null;
            }
            SmartRefreshLayout.this.f22206j = r0.getMeasuredWidth() / 2.0f;
            SmartRefreshLayout.this.f22221p8.b(RefreshState.PullDownToRefresh);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.C8 = ValueAnimator.ofInt(smartRefreshLayout2.f22190b, (int) (smartRefreshLayout2.f22189a8 * this.f22265a));
            SmartRefreshLayout.this.C8.setDuration(this.f22266b);
            SmartRefreshLayout.this.C8.setInterpolator(new tg.b(tg.b.f51276b));
            SmartRefreshLayout.this.C8.addUpdateListener(new a());
            SmartRefreshLayout.this.C8.addListener(new b());
            SmartRefreshLayout.this.C8.start();
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f22271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f22273c;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.C8 == null || smartRefreshLayout.f22213l8 == null) {
                    return;
                }
                smartRefreshLayout.f22221p8.k(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.C8 = null;
                    if (smartRefreshLayout.f22213l8 == null) {
                        smartRefreshLayout.f22221p8.b(RefreshState.None);
                        return;
                    }
                    RefreshState refreshState = smartRefreshLayout.f22223q8;
                    RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                    if (refreshState != refreshState2) {
                        smartRefreshLayout.f22221p8.b(refreshState2);
                    }
                    SmartRefreshLayout.this.setStateLoading(!r5.f22273c);
                }
            }
        }

        public j(float f10, int i10, boolean z10) {
            this.f22271a = f10;
            this.f22272b = i10;
            this.f22273c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f22225r8 != RefreshState.Loading) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.C8;
            if (valueAnimator != null) {
                valueAnimator.setDuration(0L);
                SmartRefreshLayout.this.C8.cancel();
                SmartRefreshLayout.this.C8 = null;
            }
            SmartRefreshLayout.this.f22206j = r0.getMeasuredWidth() / 2.0f;
            SmartRefreshLayout.this.f22221p8.b(RefreshState.PullUpToLoad);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.C8 = ValueAnimator.ofInt(smartRefreshLayout2.f22190b, -((int) (smartRefreshLayout2.f22193c8 * this.f22271a)));
            SmartRefreshLayout.this.C8.setDuration(this.f22272b);
            SmartRefreshLayout.this.C8.setInterpolator(new tg.b(tg.b.f51276b));
            SmartRefreshLayout.this.C8.addUpdateListener(new a());
            SmartRefreshLayout.this.C8.addListener(new b());
            SmartRefreshLayout.this.C8.start();
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22279c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f22282f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22277a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22278b = 10;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f22281e = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f22280d = AnimationUtils.currentAnimationTimeMillis();

        public k(float f10, int i10) {
            this.f22282f = f10;
            this.f22279c = i10;
            SmartRefreshLayout.this.f22219o8.postDelayed(this, this.f22278b);
            if (f10 > 0.0f) {
                SmartRefreshLayout.this.f22221p8.b(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.f22221p8.b(RefreshState.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.B8 != this || smartRefreshLayout.f22223q8.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.f22190b) < Math.abs(this.f22279c)) {
                double d10 = this.f22282f;
                this.f22277a = this.f22277a + 1;
                this.f22282f = (float) (d10 * Math.pow(0.949999988079071d, r4 * 2));
            } else if (this.f22279c != 0) {
                double d11 = this.f22282f;
                this.f22277a = this.f22277a + 1;
                this.f22282f = (float) (d11 * Math.pow(0.44999998807907104d, r4 * 2));
            } else {
                double d12 = this.f22282f;
                this.f22277a = this.f22277a + 1;
                this.f22282f = (float) (d12 * Math.pow(0.8500000238418579d, r4 * 2));
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f10 = this.f22282f * (((jCurrentAnimationTimeMillis - this.f22280d) * 1.0f) / 1000.0f);
            if (Math.abs(f10) >= 1.0f) {
                this.f22280d = jCurrentAnimationTimeMillis;
                float f11 = this.f22281e + f10;
                this.f22281e = f11;
                SmartRefreshLayout.this.B0(f11);
                SmartRefreshLayout.this.f22219o8.postDelayed(this, this.f22278b);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshState refreshState = smartRefreshLayout2.f22225r8;
            boolean z10 = refreshState.isDragging;
            if (z10 && refreshState.isHeader) {
                smartRefreshLayout2.f22221p8.b(RefreshState.PullDownCanceled);
            } else if (z10 && refreshState.isFooter) {
                smartRefreshLayout2.f22221p8.b(RefreshState.PullUpCanceled);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.B8 = null;
            if (Math.abs(smartRefreshLayout3.f22190b) >= Math.abs(this.f22279c)) {
                int iMin = Math.min(Math.max((int) tg.b.j(Math.abs(SmartRefreshLayout.this.f22190b - this.f22279c)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.w0(this.f22279c, 0, smartRefreshLayout4.B, iMin);
            }
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22284a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f22287d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22285b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22286c = 10;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f22288e = 0.98f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f22289f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f22290g = AnimationUtils.currentAnimationTimeMillis();

        public l(float f10) {
            this.f22287d = f10;
            this.f22284a = SmartRefreshLayout.this.f22190b;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Runnable a() {
            /*
                r11 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f22223q8
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto La
                return r3
            La:
                int r2 = r0.f22190b
                if (r2 == 0) goto Lab
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L26
                boolean r1 = r0.M7
                if (r1 == 0) goto L59
                boolean r1 = r0.K1
                if (r1 == 0) goto L59
                boolean r1 = r0.N7
                if (r1 == 0) goto L59
                boolean r1 = r0.f22209k0
                boolean r0 = r0.z0(r1)
                if (r0 == 0) goto L59
            L26:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f22223q8
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
                if (r1 == r2) goto L42
                boolean r1 = r0.M7
                if (r1 == 0) goto L4b
                boolean r1 = r0.K1
                if (r1 == 0) goto L4b
                boolean r1 = r0.N7
                if (r1 == 0) goto L4b
                boolean r1 = r0.f22209k0
                boolean r0 = r0.z0(r1)
                if (r0 == 0) goto L4b
            L42:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r0.f22190b
                int r0 = r0.f22193c8
                int r0 = -r0
                if (r1 < r0) goto L59
            L4b:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f22223q8
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto Lab
                int r1 = r0.f22190b
                int r0 = r0.f22189a8
                if (r1 <= r0) goto Lab
            L59:
                r0 = 0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.f22190b
                float r2 = r11.f22287d
                r4 = r1
            L61:
                int r5 = r1 * r4
                if (r5 <= 0) goto Lab
                double r5 = (double) r2
                float r2 = r11.f22288e
                double r7 = (double) r2
                int r0 = r0 + 1
                int r2 = r11.f22286c
                int r2 = r2 * r0
                float r2 = (float) r2
                r9 = 1092616192(0x41200000, float:10.0)
                float r2 = r2 / r9
                double r9 = (double) r2
                double r7 = java.lang.Math.pow(r7, r9)
                double r5 = r5 * r7
                float r2 = (float) r5
                int r5 = r11.f22286c
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r2
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto La7
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f22223q8
                boolean r2 = r1.isOpening
                if (r2 == 0) goto La6
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto L9f
                int r5 = r0.f22189a8
                if (r4 > r5) goto La6
            L9f:
                if (r1 == r2) goto Lab
                int r0 = r0.f22193c8
                int r0 = -r0
                if (r4 >= r0) goto Lab
            La6:
                return r3
            La7:
                float r4 = (float) r4
                float r4 = r4 + r5
                int r4 = (int) r4
                goto L61
            Lab:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r11.f22289f = r0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.f22219o8
                int r1 = r11.f22286c
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.l.a():java.lang.Runnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.B8 != this || smartRefreshLayout.f22223q8.isFinishing) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j10 = jCurrentAnimationTimeMillis - this.f22290g;
            float fPow = (float) (((double) this.f22287d) * Math.pow(this.f22288e, (jCurrentAnimationTimeMillis - this.f22289f) / (1000.0f / this.f22286c)));
            this.f22287d = fPow;
            float f10 = fPow * ((j10 * 1.0f) / 1000.0f);
            if (Math.abs(f10) <= 1.0f) {
                SmartRefreshLayout.this.B8 = null;
                return;
            }
            this.f22290g = jCurrentAnimationTimeMillis;
            int i10 = (int) (this.f22284a + f10);
            this.f22284a = i10;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.f22190b * i10 > 0) {
                smartRefreshLayout2.f22221p8.k(i10, true);
                SmartRefreshLayout.this.f22219o8.postDelayed(this, this.f22286c);
                return;
            }
            smartRefreshLayout2.B8 = null;
            smartRefreshLayout2.f22221p8.k(0, true);
            tg.b.e(SmartRefreshLayout.this.f22215m8.i(), (int) (-this.f22287d));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.f22241y8 || f10 <= 0.0f) {
                return;
            }
            smartRefreshLayout3.f22241y8 = false;
        }
    }

    public class n implements mg.i {

        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == null || animator.getDuration() != 0) {
                    SmartRefreshLayout.this.f22221p8.b(RefreshState.TwoLevel);
                }
            }
        }

        public n() {
        }

        @Override // mg.i
        public mg.i a(int i10, float f10, float f11) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f22196e = i10;
            smartRefreshLayout.f22212l = f10;
            smartRefreshLayout.f22214m = f11;
            return this;
        }

        @Override // mg.i
        public mg.i b(@n0 RefreshState refreshState) {
            switch (a.f22244a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.f22223q8;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.f22190b == 0) {
                        smartRefreshLayout.C0(refreshState3);
                    } else if (smartRefreshLayout.f22190b != 0) {
                        f(0);
                    }
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.f22223q8.isOpening && smartRefreshLayout2.z0(smartRefreshLayout2.D)) {
                        SmartRefreshLayout.this.C0(RefreshState.PullDownToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    }
                    break;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.z0(smartRefreshLayout3.f22209k0)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.f22223q8;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.M7 || !smartRefreshLayout4.K1 || !smartRefreshLayout4.N7)) {
                            smartRefreshLayout4.C0(RefreshState.PullUpToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.f22223q8.isOpening && smartRefreshLayout5.z0(smartRefreshLayout5.D)) {
                        SmartRefreshLayout.this.C0(RefreshState.PullDownCanceled);
                        b(RefreshState.None);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    }
                    break;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.z0(smartRefreshLayout6.f22209k0)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.f22223q8.isOpening && (!smartRefreshLayout7.M7 || !smartRefreshLayout7.K1 || !smartRefreshLayout7.N7)) {
                            smartRefreshLayout7.C0(RefreshState.PullUpCanceled);
                            b(RefreshState.None);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.f22223q8.isOpening && smartRefreshLayout8.z0(smartRefreshLayout8.D)) {
                        SmartRefreshLayout.this.C0(RefreshState.ReleaseToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    }
                    break;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.z0(smartRefreshLayout9.f22209k0)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.f22223q8;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.M7 || !smartRefreshLayout10.K1 || !smartRefreshLayout10.N7)) {
                            smartRefreshLayout10.C0(RefreshState.ReleaseToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.f22223q8.isOpening && smartRefreshLayout11.z0(smartRefreshLayout11.D)) {
                        SmartRefreshLayout.this.C0(RefreshState.ReleaseToTwoLevel);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    }
                    break;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.f22223q8.isOpening && smartRefreshLayout12.z0(smartRefreshLayout12.D)) {
                        SmartRefreshLayout.this.C0(RefreshState.RefreshReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.f22223q8.isOpening && smartRefreshLayout13.z0(smartRefreshLayout13.f22209k0)) {
                        SmartRefreshLayout.this.C0(RefreshState.LoadReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    break;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    break;
                default:
                    SmartRefreshLayout.this.C0(refreshState);
                    break;
            }
            return null;
        }

        @Override // mg.i
        public mg.i c(@n0 mg.h hVar) {
            if (hVar.equals(SmartRefreshLayout.this.f22211k8)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ng.a aVar = smartRefreshLayout.f22191b8;
                if (aVar.f42142b) {
                    smartRefreshLayout.f22191b8 = aVar.c();
                }
            } else if (hVar.equals(SmartRefreshLayout.this.f22213l8)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                ng.a aVar2 = smartRefreshLayout2.f22195d8;
                if (aVar2.f42142b) {
                    smartRefreshLayout2.f22195d8 = aVar2.c();
                }
            }
            return this;
        }

        @Override // mg.i
        @n0
        public mg.e d() {
            return SmartRefreshLayout.this.f22215m8;
        }

        @Override // mg.i
        public mg.i e() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f22223q8 == RefreshState.TwoLevel) {
                smartRefreshLayout.f22221p8.b(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.f22190b == 0) {
                    k(0, false);
                    SmartRefreshLayout.this.C0(RefreshState.None);
                } else {
                    f(0).setDuration(SmartRefreshLayout.this.f22196e);
                }
            }
            return this;
        }

        @Override // mg.i
        public ValueAnimator f(int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.w0(i10, 0, smartRefreshLayout.B, smartRefreshLayout.f22198f);
        }

        @Override // mg.i
        public mg.i g(@n0 mg.h hVar, int i10) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f22217n8 == null && i10 != 0) {
                smartRefreshLayout.f22217n8 = new Paint();
            }
            if (hVar.equals(SmartRefreshLayout.this.f22211k8)) {
                SmartRefreshLayout.this.f22229t8 = i10;
            } else if (hVar.equals(SmartRefreshLayout.this.f22213l8)) {
                SmartRefreshLayout.this.f22231u8 = i10;
            }
            return this;
        }

        @Override // mg.i
        @n0
        public mg.j h() {
            return SmartRefreshLayout.this;
        }

        @Override // mg.i
        public mg.i i(@n0 mg.h hVar, boolean z10) {
            if (hVar.equals(SmartRefreshLayout.this.f22211k8)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.P7) {
                    smartRefreshLayout.P7 = true;
                    smartRefreshLayout.f22233v1 = z10;
                }
            } else if (hVar.equals(SmartRefreshLayout.this.f22213l8)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.Q7) {
                    smartRefreshLayout2.Q7 = true;
                    smartRefreshLayout2.C1 = z10;
                }
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
        @Override // mg.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public mg.i j(boolean r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L38
                com.scwang.smartrefresh.layout.SmartRefreshLayout$n$a r4 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$n$a
                r4.<init>()
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.getMeasuredHeight()
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r1 = r1.f22212l
                r2 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r2 <= 0) goto L19
                int r0 = (int) r1
                goto L1d
            L19:
                float r0 = (float) r0
                float r0 = r0 * r1
                int r0 = (int) r0
            L1d:
                android.animation.ValueAnimator r0 = r3.f(r0)
                if (r0 == 0) goto L33
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.animation.ValueAnimator r2 = r1.C8
                if (r0 != r2) goto L33
                int r1 = r1.f22196e
                long r1 = (long) r1
                r0.setDuration(r1)
                r0.addListener(r4)
                goto L46
            L33:
                r0 = 0
                r4.onAnimationEnd(r0)
                goto L46
            L38:
                r4 = 0
                android.animation.ValueAnimator r4 = r3.f(r4)
                if (r4 != 0) goto L46
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.None
                r4.C0(r0)
            L46:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.n.j(boolean):mg.i");
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
        @Override // mg.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public mg.i k(int r19, boolean r20) {
            /*
                Method dump skipped, instruction units count: 897
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.n.k(int, boolean):mg.i");
        }

        @Override // mg.i
        public mg.i l(@n0 mg.h hVar, boolean z10) {
            if (hVar.equals(SmartRefreshLayout.this.f22211k8)) {
                SmartRefreshLayout.this.f22235v8 = z10;
            } else if (hVar.equals(SmartRefreshLayout.this.f22213l8)) {
                SmartRefreshLayout.this.f22237w8 = z10;
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@n0 mg.a aVar) {
        D8 = aVar;
    }

    public static void setDefaultRefreshHeaderCreator(@n0 mg.b bVar) {
        E8 = bVar;
    }

    public static void setDefaultRefreshInitializer(@n0 mg.c cVar) {
        F8 = cVar;
    }

    @Override // mg.j
    public mg.j A(boolean z10) {
        this.K2 = z10;
        return this;
    }

    public boolean A0(boolean z10, mg.h hVar) {
        return z10 || this.F7 || hVar == null || hVar.getSpinnerStyle() == ng.b.f42145f;
    }

    public void B0(float f10) {
        RefreshState refreshState;
        if (this.W7 && !this.I7 && f10 < 0.0f && !this.f22215m8.h()) {
            f10 = 0.0f;
        }
        if (f10 > this.f22200g * 5 && getTag() == null) {
            float f11 = this.f22208k;
            int i10 = this.f22200g;
            if (f11 < i10 / 6.0f && this.f22206j < i10 / 16.0f) {
                Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                setTag("你这么死拉，臣妾做不到啊！");
            }
        }
        RefreshState refreshState2 = this.f22223q8;
        if (refreshState2 == RefreshState.TwoLevel && f10 > 0.0f && this.f22215m8 != null) {
            int measuredHeight = getMeasuredHeight();
            float f12 = this.f22212l;
            this.f22221p8.k(Math.min((int) f10, f12 > 1.0f ? (int) f12 : (int) (measuredHeight * f12)), true);
        } else if (refreshState2 == RefreshState.Refreshing && f10 >= 0.0f) {
            int i11 = this.f22189a8;
            if (f10 < i11) {
                this.f22221p8.k((int) f10, true);
            } else {
                float f13 = (this.f22201g8 - 1.0f) * i11;
                int iMax = Math.max((this.f22200g * 4) / 3, getHeight());
                int i12 = this.f22189a8;
                float f14 = iMax - i12;
                float fMax = Math.max(0.0f, (f10 - i12) * this.f22216n);
                float f15 = -fMax;
                if (f14 == 0.0f) {
                    f14 = 1.0f;
                }
                this.f22221p8.k(((int) Math.min(f13 * (1.0f - ((float) Math.pow(100.0d, f15 / f14))), fMax)) + this.f22189a8, true);
            }
        } else if (f10 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.K1 && this.M7 && this.N7 && z0(this.f22209k0)) || (this.E7 && !this.M7 && z0(this.f22209k0))))) {
            int i13 = this.f22193c8;
            if (f10 > (-i13)) {
                this.f22221p8.k((int) f10, true);
            } else {
                float f16 = (this.f22203h8 - 1.0f) * i13;
                int iMax2 = Math.max((this.f22200g * 4) / 3, getHeight());
                int i14 = this.f22193c8;
                float f17 = iMax2 - i14;
                float f18 = -Math.min(0.0f, (i14 + f10) * this.f22216n);
                float f19 = -f18;
                if (f17 == 0.0f) {
                    f17 = 1.0f;
                }
                this.f22221p8.k(((int) (-Math.min(f16 * (1.0f - ((float) Math.pow(100.0d, f19 / f17))), f18))) - this.f22193c8, true);
            }
        } else if (f10 >= 0.0f) {
            float f20 = this.f22201g8 * this.f22189a8;
            float fMax2 = Math.max(this.f22200g / 2, getHeight());
            float fMax3 = Math.max(0.0f, this.f22216n * f10);
            float f21 = -fMax3;
            if (fMax2 == 0.0f) {
                fMax2 = 1.0f;
            }
            this.f22221p8.k((int) Math.min(f20 * (1.0f - ((float) Math.pow(100.0d, f21 / fMax2))), fMax3), true);
        } else {
            float f22 = this.f22203h8 * this.f22193c8;
            float fMax4 = Math.max(this.f22200g / 2, getHeight());
            float f23 = -Math.min(0.0f, this.f22216n * f10);
            float f24 = -f23;
            if (fMax4 == 0.0f) {
                fMax4 = 1.0f;
            }
            this.f22221p8.k((int) (-Math.min(f22 * (1.0f - ((float) Math.pow(100.0d, f24 / fMax4))), f23)), true);
        }
        if (!this.E7 || this.M7 || !z0(this.f22209k0) || f10 >= 0.0f || (refreshState = this.f22223q8) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish) {
            return;
        }
        if (this.L7) {
            this.B8 = null;
            this.f22221p8.f(-this.f22193c8);
        }
        setStateDirectLoading(false);
        this.f22219o8.postDelayed(new f(), this.f22198f);
    }

    @Override // mg.j
    public mg.j C(boolean z10) {
        this.D = z10;
        return this;
    }

    public void C0(RefreshState refreshState) {
        RefreshState refreshState2 = this.f22223q8;
        if (refreshState2 == refreshState) {
            if (this.f22225r8 != refreshState2) {
                this.f22225r8 = refreshState2;
                return;
            }
            return;
        }
        this.f22223q8 = refreshState;
        this.f22225r8 = refreshState;
        mg.h hVar = this.f22211k8;
        mg.h hVar2 = this.f22213l8;
        sg.c cVar = this.T7;
        if (hVar != null) {
            hVar.h(this, refreshState2, refreshState);
        }
        if (hVar2 != null) {
            hVar2.h(this, refreshState2, refreshState);
        }
        if (cVar != null) {
            cVar.h(this, refreshState2, refreshState);
        }
        if (refreshState == RefreshState.LoadFinish) {
            this.f22241y8 = false;
        }
    }

    public void D0() {
        RefreshState refreshState = this.f22223q8;
        if (refreshState == RefreshState.TwoLevel) {
            int measuredHeight = getMeasuredHeight();
            float f10 = this.f22212l;
            int i10 = f10 > 1.0f ? (int) f10 : (int) (measuredHeight * f10);
            if (this.f22240y <= -1000 || this.f22190b <= i10 / 2) {
                if (this.f22220p) {
                    this.f22221p8.e();
                    return;
                }
                return;
            } else {
                ValueAnimator valueAnimatorF = this.f22221p8.f(i10);
                if (valueAnimatorF != null) {
                    valueAnimatorF.setDuration(this.f22196e);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState == refreshState2 || (this.K1 && this.M7 && this.N7 && this.f22190b < 0 && z0(this.f22209k0))) {
            int i11 = this.f22190b;
            int i12 = this.f22193c8;
            if (i11 < (-i12)) {
                this.f22221p8.f(-i12);
                return;
            } else {
                if (i11 > 0) {
                    this.f22221p8.f(0);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState3 = this.f22223q8;
        RefreshState refreshState4 = RefreshState.Refreshing;
        if (refreshState3 == refreshState4) {
            int i13 = this.f22190b;
            int i14 = this.f22189a8;
            if (i13 > i14) {
                this.f22221p8.f(i14);
                return;
            } else {
                if (i13 < 0) {
                    this.f22221p8.f(0);
                    return;
                }
                return;
            }
        }
        if (refreshState3 == RefreshState.PullDownToRefresh) {
            this.f22221p8.b(RefreshState.PullDownCanceled);
            return;
        }
        if (refreshState3 == RefreshState.PullUpToLoad) {
            this.f22221p8.b(RefreshState.PullUpCanceled);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToRefresh) {
            this.f22221p8.b(refreshState4);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToLoad) {
            this.f22221p8.b(refreshState2);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
            this.f22221p8.b(RefreshState.TwoLevelReleased);
            return;
        }
        if (refreshState3 == RefreshState.RefreshReleased) {
            if (this.C8 == null) {
                this.f22221p8.f(this.f22189a8);
            }
        } else if (refreshState3 == RefreshState.LoadReleased) {
            if (this.C8 == null) {
                this.f22221p8.f(-this.f22193c8);
            }
        } else {
            if (refreshState3 == RefreshState.LoadFinish || this.f22190b == 0) {
                return;
            }
            this.f22221p8.f(0);
        }
    }

    @Override // mg.j
    public mg.j E() {
        return a(false);
    }

    public boolean E0(float f10) {
        if (f10 == 0.0f) {
            f10 = this.f22240y;
        }
        if (Build.VERSION.SDK_INT > 27 && this.f22215m8 != null) {
            getScaleY();
            View view = this.f22215m8.getView();
            if (getScaleY() == -1.0f && view.getScaleY() == -1.0f) {
                f10 = -f10;
            }
        }
        if (Math.abs(f10) > this.f22236w) {
            int i10 = this.f22190b;
            if (i10 * f10 < 0.0f) {
                RefreshState refreshState = this.f22223q8;
                if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading || (i10 < 0 && this.M7)) {
                    this.B8 = new l(f10).a();
                    return true;
                }
                if (refreshState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f10 < 0.0f && ((this.C2 && (this.f22209k0 || this.K2)) || ((this.f22223q8 == RefreshState.Loading && i10 >= 0) || (this.E7 && z0(this.f22209k0))))) || (f10 > 0.0f && ((this.C2 && this.D) || this.K2 || (this.f22223q8 == RefreshState.Refreshing && this.f22190b <= 0)))) {
                this.f22243z8 = false;
                this.f22242z.fling(0, 0, 0, (int) (-f10), 0, 0, lr.h.f40228g, Integer.MAX_VALUE);
                this.f22242z.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    @Override // mg.j
    public mg.j F(sg.c cVar) {
        this.T7 = cVar;
        return this;
    }

    @Override // mg.j
    public mg.j I(boolean z10) {
        return U(z10 ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f22227s8))), 300) << 16 : 0, z10, false);
    }

    @Override // mg.j
    public mg.j L(sg.d dVar) {
        this.R7 = dVar;
        return this;
    }

    @Override // mg.j
    public mg.j M() {
        return j0(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f22227s8))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // mg.j
    public mg.j N() {
        return m(true);
    }

    @Override // mg.j
    public boolean O(int i10, int i11, float f10, boolean z10) {
        if (this.f22223q8 != RefreshState.None || !z0(this.D)) {
            return false;
        }
        i iVar = new i(f10, i11, z10);
        setViceState(RefreshState.Refreshing);
        if (i10 > 0) {
            this.f22219o8.postDelayed(iVar, i10);
            return true;
        }
        iVar.run();
        return true;
    }

    @Override // mg.j
    public mg.j P(float f10) {
        this.f22199f8 = tg.b.d(f10);
        return this;
    }

    @Override // mg.j
    public mg.j Q(@n0 mg.g gVar, int i10, int i11) {
        mg.h hVar;
        mg.h hVar2 = this.f22211k8;
        if (hVar2 != null) {
            super.removeView(hVar2.getView());
        }
        this.f22211k8 = gVar;
        this.f22229t8 = 0;
        this.f22235v8 = false;
        this.f22191b8 = ng.a.f42128c;
        if (i10 == 0) {
            i10 = -1;
        }
        if (i11 == 0) {
            i11 = -2;
        }
        m mVar = new m(i10, i11);
        ViewGroup.LayoutParams layoutParams = this.f22211k8.getView().getLayoutParams();
        if (layoutParams instanceof m) {
            mVar = (m) layoutParams;
        }
        if (this.f22211k8.getSpinnerStyle().f42150b) {
            super.addView(this.f22211k8.getView(), getChildCount(), mVar);
        } else {
            super.addView(this.f22211k8.getView(), 0, mVar);
        }
        int[] iArr = this.C;
        if (iArr != null && (hVar = this.f22211k8) != null) {
            hVar.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // mg.j
    public mg.j R(float f10) {
        this.f22197e8 = tg.b.d(f10);
        return this;
    }

    @Override // mg.j
    public mg.j S(float f10) {
        this.f22205i8 = f10;
        return this;
    }

    @Override // mg.j
    public mg.j T(boolean z10) {
        this.F7 = z10;
        return this;
    }

    @Override // mg.j
    public mg.j U(int i10, boolean z10, boolean z11) {
        int i11 = i10 >> 16;
        int i12 = (i10 << 16) >> 16;
        h hVar = new h(i11, z11, z10);
        if (i12 > 0) {
            this.f22219o8.postDelayed(hVar, i12);
        } else {
            hVar.run();
        }
        return this;
    }

    @Override // mg.j
    public mg.j V(@n0 Interpolator interpolator) {
        this.B = interpolator;
        return this;
    }

    @Override // mg.j
    public mg.j W(@g.n int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = h0.d.f(getContext(), iArr[i10]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // mg.j
    public mg.j X(int i10) {
        return U(i10, true, false);
    }

    @Override // mg.j
    public boolean Y() {
        int i10 = this.f22239x8 ? 0 : 400;
        int i11 = this.f22198f;
        float f10 = (this.f22201g8 / 2.0f) + 0.5f;
        int i12 = this.f22189a8;
        float f11 = f10 * i12 * 1.0f;
        if (i12 == 0) {
            i12 = 1;
        }
        return O(i10, i11, f11 / i12, true);
    }

    @Override // mg.j
    public mg.j Z(boolean z10) {
        this.f22233v1 = z10;
        this.P7 = true;
        return this;
    }

    @Override // mg.j
    public mg.j a(boolean z10) {
        RefreshState refreshState = this.f22223q8;
        if (refreshState == RefreshState.Refreshing && z10) {
            M();
        } else if (refreshState == RefreshState.Loading && z10) {
            w();
        } else if (this.M7 != z10) {
            this.M7 = z10;
            mg.h hVar = this.f22213l8;
            if (hVar instanceof mg.f) {
                if (((mg.f) hVar).a(z10)) {
                    this.N7 = true;
                    if (this.M7 && this.K1 && this.f22190b > 0 && this.f22213l8.getSpinnerStyle() == ng.b.f42143d && z0(this.f22209k0) && A0(this.D, this.f22211k8)) {
                        this.f22213l8.getView().setTranslationY(this.f22190b);
                    }
                } else {
                    this.N7 = false;
                    new RuntimeException("Footer:" + this.f22213l8 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    @Override // mg.j
    public mg.j a0(boolean z10) {
        this.E7 = z10;
        return this;
    }

    @Override // mg.j
    public mg.j b(boolean z10) {
        this.I7 = z10;
        mg.e eVar = this.f22215m8;
        if (eVar != null) {
            eVar.b(z10);
        }
        return this;
    }

    @Override // mg.j
    public mg.j b0(boolean z10) {
        this.L7 = z10;
        return this;
    }

    @Override // mg.j
    public mg.j c(mg.k kVar) {
        this.U7 = kVar;
        mg.e eVar = this.f22215m8;
        if (eVar != null) {
            eVar.c(kVar);
        }
        return this;
    }

    @Override // mg.j
    public mg.j c0(boolean z10) {
        this.K0 = z10;
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f22242z.getCurrY();
        if (this.f22242z.computeScrollOffset()) {
            int finalY = this.f22242z.getFinalY();
            if ((finalY >= 0 || !((this.D || this.K2) && this.f22215m8.d())) && (finalY <= 0 || !((this.f22209k0 || this.K2) && this.f22215m8.h()))) {
                this.f22243z8 = true;
                invalidate();
            } else {
                if (this.f22243z8) {
                    x0(finalY > 0 ? -this.f22242z.getCurrVelocity() : this.f22242z.getCurrVelocity());
                }
                this.f22242z.forceFinished(true);
            }
        }
    }

    @Override // mg.j
    @Deprecated
    public boolean d(int i10) {
        int i11 = this.f22198f;
        float f10 = (this.f22201g8 / 2.0f) + 0.5f;
        int i12 = this.f22189a8;
        float f11 = f10 * i12 * 1.0f;
        if (i12 == 0) {
            i12 = 1;
        }
        return O(i10, i11, f11 / i12, false);
    }

    @Override // mg.j
    public mg.j d0(boolean z10) {
        this.G7 = z10;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00dc, code lost:
    
        if (r2.isFooter == false) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instruction units count: 890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        Paint paint;
        Paint paint2;
        mg.e eVar = this.f22215m8;
        View view2 = eVar != null ? eVar.getView() : null;
        mg.h hVar = this.f22211k8;
        if (hVar != null && hVar.getView() == view) {
            if (!z0(this.D) || (!this.f22234v2 && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getTop() + view2.getPaddingTop() + this.f22190b, view.getTop());
                int i10 = this.f22229t8;
                if (i10 != 0 && (paint2 = this.f22217n8) != null) {
                    paint2.setColor(i10);
                    if (this.f22211k8.getSpinnerStyle().f42151c) {
                        iMax = view.getBottom();
                    } else if (this.f22211k8.getSpinnerStyle() == ng.b.f42143d) {
                        iMax = view.getBottom() + this.f22190b;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), iMax, this.f22217n8);
                }
                if ((this.K0 && this.f22211k8.getSpinnerStyle() == ng.b.f42145f) || this.f22211k8.getSpinnerStyle().f42151c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j10);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        mg.h hVar2 = this.f22213l8;
        if (hVar2 != null && hVar2.getView() == view) {
            if (!z0(this.f22209k0) || (!this.f22234v2 && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f22190b, view.getBottom());
                int i11 = this.f22231u8;
                if (i11 != 0 && (paint = this.f22217n8) != null) {
                    paint.setColor(i11);
                    if (this.f22213l8.getSpinnerStyle().f42151c) {
                        iMin = view.getTop();
                    } else if (this.f22213l8.getSpinnerStyle() == ng.b.f42143d) {
                        iMin = view.getTop() + this.f22190b;
                    }
                    canvas.drawRect(0.0f, iMin, getWidth(), view.getBottom(), this.f22217n8);
                }
                if ((this.f22210k1 && this.f22213l8.getSpinnerStyle() == ng.b.f42145f) || this.f22213l8.getSpinnerStyle().f42151c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j10);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // mg.j
    public boolean e() {
        int i10 = this.f22198f;
        int i11 = this.f22193c8;
        float f10 = i11 * ((this.f22203h8 / 2.0f) + 0.5f) * 1.0f;
        if (i11 == 0) {
            i11 = 1;
        }
        return o(0, i10, f10 / i11, true);
    }

    @Override // mg.j
    public mg.j e0(@n0 mg.f fVar) {
        return h(fVar, 0, 0);
    }

    @Override // mg.j
    public mg.j f(boolean z10) {
        this.C2 = z10;
        return this;
    }

    @Override // mg.j
    public mg.j f0(boolean z10) {
        this.f22210k1 = z10;
        return this;
    }

    @Override // mg.j
    public mg.j g() {
        return I(true);
    }

    @Override // mg.j
    public mg.j g0(float f10) {
        this.f22216n = f10;
        return this;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }

    @Override // mg.j
    @n0
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.i0
    public int getNestedScrollAxes() {
        return this.Z7.a();
    }

    @Override // mg.j
    @p0
    public mg.f getRefreshFooter() {
        mg.h hVar = this.f22213l8;
        if (hVar instanceof mg.f) {
            return (mg.f) hVar;
        }
        return null;
    }

    @Override // mg.j
    @p0
    public mg.g getRefreshHeader() {
        mg.h hVar = this.f22211k8;
        if (hVar instanceof mg.g) {
            return (mg.g) hVar;
        }
        return null;
    }

    @Override // mg.j
    @n0
    public RefreshState getState() {
        return this.f22223q8;
    }

    @Override // mg.j
    public mg.j h(@n0 mg.f fVar, int i10, int i11) {
        mg.h hVar;
        mg.h hVar2 = this.f22213l8;
        if (hVar2 != null) {
            super.removeView(hVar2.getView());
        }
        this.f22213l8 = fVar;
        this.f22241y8 = false;
        this.f22231u8 = 0;
        this.N7 = false;
        this.f22237w8 = false;
        this.f22195d8 = ng.a.f42128c;
        this.f22209k0 = !this.O7 || this.f22209k0;
        if (i10 == 0) {
            i10 = -1;
        }
        if (i11 == 0) {
            i11 = -2;
        }
        m mVar = new m(i10, i11);
        ViewGroup.LayoutParams layoutParams = this.f22213l8.getView().getLayoutParams();
        if (layoutParams instanceof m) {
            mVar = (m) layoutParams;
        }
        if (this.f22213l8.getSpinnerStyle().f42150b) {
            super.addView(this.f22213l8.getView(), getChildCount(), mVar);
        } else {
            super.addView(this.f22213l8.getView(), 0, mVar);
        }
        int[] iArr = this.C;
        if (iArr != null && (hVar = this.f22213l8) != null) {
            hVar.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // mg.j
    public mg.j h0(boolean z10) {
        this.K1 = z10;
        return this;
    }

    @Override // mg.j
    public mg.j i() {
        RefreshState refreshState;
        RefreshState refreshState2 = this.f22223q8;
        RefreshState refreshState3 = RefreshState.None;
        if (refreshState2 == refreshState3 && ((refreshState = this.f22225r8) == RefreshState.Refreshing || refreshState == RefreshState.Loading)) {
            this.f22225r8 = refreshState3;
        }
        if (refreshState2 == RefreshState.Refreshing) {
            N();
        } else if (refreshState2 == RefreshState.Loading) {
            g();
        } else if (this.f22221p8.f(0) == null) {
            C0(refreshState3);
        } else if (this.f22223q8.isHeader) {
            C0(RefreshState.PullDownCanceled);
        } else {
            C0(RefreshState.PullUpCanceled);
        }
        return this;
    }

    @Override // mg.j
    public mg.j i0(float f10) {
        int iD = tg.b.d(f10);
        if (iD == this.f22189a8) {
            return this;
        }
        ng.a aVar = this.f22191b8;
        ng.a aVar2 = ng.a.f42137l;
        if (aVar.a(aVar2)) {
            this.f22189a8 = iD;
            mg.h hVar = this.f22211k8;
            if (hVar != null && this.f22239x8 && this.f22191b8.f42142b) {
                ng.b spinnerStyle = hVar.getSpinnerStyle();
                if (spinnerStyle != ng.b.f42147h && !spinnerStyle.f42151c) {
                    View view = this.f22211k8.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : G8;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.f22189a8 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i10 = marginLayoutParams.leftMargin;
                    int i11 = (marginLayoutParams.topMargin + this.f22197e8) - (spinnerStyle == ng.b.f42143d ? this.f22189a8 : 0);
                    view.layout(i10, i11, view.getMeasuredWidth() + i10, view.getMeasuredHeight() + i11);
                }
                this.f22191b8 = aVar2;
                mg.h hVar2 = this.f22211k8;
                mg.i iVar = this.f22221p8;
                int i12 = this.f22189a8;
                hVar2.n(iVar, i12, (int) (this.f22201g8 * i12));
            } else {
                this.f22191b8 = ng.a.f42136k;
            }
        }
        return this;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.J7 && (this.K2 || this.D || this.f22209k0);
    }

    @Override // mg.j
    public mg.j j(boolean z10) {
        this.K7 = z10;
        return this;
    }

    @Override // mg.j
    public mg.j j0(int i10, boolean z10, Boolean bool) {
        int i11 = i10 >> 16;
        int i12 = (i10 << 16) >> 16;
        g gVar = new g(i11, bool, z10);
        if (i12 > 0) {
            this.f22219o8.postDelayed(gVar, i12);
        } else {
            gVar.run();
        }
        return this;
    }

    @Override // mg.j
    public mg.j k(@n0 View view) {
        return v(view, 0, 0);
    }

    @Override // mg.j
    public boolean k0() {
        int i10 = this.f22198f;
        int i11 = this.f22193c8;
        float f10 = i11 * ((this.f22203h8 / 2.0f) + 0.5f) * 1.0f;
        if (i11 == 0) {
            i11 = 1;
        }
        return o(0, i10, f10 / i11, false);
    }

    @Override // mg.j
    public mg.j l(sg.e eVar) {
        this.R7 = eVar;
        this.S7 = eVar;
        this.f22209k0 = this.f22209k0 || !(this.O7 || eVar == null);
        return this;
    }

    @Override // mg.j
    public mg.j m(boolean z10) {
        return z10 ? j0(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f22227s8))), 300) << 16, true, Boolean.FALSE) : j0(0, false, null);
    }

    @Override // mg.j
    public mg.j m0(boolean z10) {
        this.H7 = z10;
        return this;
    }

    @Override // mg.j
    public mg.j n(float f10) {
        this.f22203h8 = f10;
        mg.h hVar = this.f22213l8;
        if (hVar == null || !this.f22239x8) {
            this.f22195d8 = this.f22195d8.c();
        } else {
            mg.i iVar = this.f22221p8;
            int i10 = this.f22193c8;
            hVar.n(iVar, i10, (int) (i10 * f10));
        }
        return this;
    }

    @Override // mg.j
    public mg.j n0(boolean z10) {
        this.O7 = true;
        this.f22209k0 = z10;
        return this;
    }

    @Override // mg.j
    public boolean o(int i10, int i11, float f10, boolean z10) {
        if (this.f22223q8 != RefreshState.None || !z0(this.f22209k0) || this.M7) {
            return false;
        }
        j jVar = new j(f10, i11, z10);
        setViceState(RefreshState.Loading);
        if (i10 > 0) {
            this.f22219o8.postDelayed(jVar, i10);
            return true;
        }
        jVar.run();
        return true;
    }

    @Override // mg.j
    @Deprecated
    public mg.j o0(boolean z10) {
        this.K1 = z10;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        mg.h hVar;
        super.onAttachedToWindow();
        boolean z10 = true;
        this.f22239x8 = true;
        if (!isInEditMode()) {
            if (this.f22211k8 == null) {
                mg.b bVar = E8;
                if (bVar != null) {
                    mg.g gVarA = bVar.a(getContext(), this);
                    if (gVarA == null) {
                        throw new RuntimeException("DefaultRefreshHeaderCreator can not return null");
                    }
                    p(gVarA);
                } else {
                    p(new pg.a(getContext()));
                }
            }
            if (this.f22213l8 == null) {
                mg.a aVar = D8;
                if (aVar != null) {
                    mg.f fVarA = aVar.a(getContext(), this);
                    if (fVarA == null) {
                        throw new RuntimeException("DefaultRefreshFooterCreator can not return null");
                    }
                    e0(fVarA);
                } else {
                    boolean z11 = this.f22209k0;
                    e0(new og.a(getContext()));
                    this.f22209k0 = z11;
                }
            } else {
                if (!this.f22209k0 && this.O7) {
                    z10 = false;
                }
                this.f22209k0 = z10;
            }
            if (this.f22215m8 == null) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    mg.h hVar2 = this.f22211k8;
                    if ((hVar2 == null || childAt != hVar2.getView()) && ((hVar = this.f22213l8) == null || childAt != hVar.getView())) {
                        this.f22215m8 = new qg.a(childAt);
                    }
                }
            }
            if (this.f22215m8 == null) {
                int iD = tg.b.d(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, 0, new m(-1, -1));
                qg.a aVar2 = new qg.a(textView);
                this.f22215m8 = aVar2;
                aVar2.getView().setPadding(iD, iD, iD, iD);
            }
            View viewFindViewById = findViewById(this.f22226s);
            View viewFindViewById2 = findViewById(this.f22228t);
            this.f22215m8.c(this.U7);
            this.f22215m8.b(this.I7);
            this.f22215m8.j(this.f22221p8, viewFindViewById, viewFindViewById2);
            if (this.f22190b != 0) {
                C0(RefreshState.None);
                mg.e eVar = this.f22215m8;
                this.f22190b = 0;
                eVar.f(0, this.f22230u, this.f22232v);
            }
        }
        int[] iArr = this.C;
        if (iArr != null) {
            mg.h hVar3 = this.f22211k8;
            if (hVar3 != null) {
                hVar3.setPrimaryColors(iArr);
            }
            mg.h hVar4 = this.f22213l8;
            if (hVar4 != null) {
                hVar4.setPrimaryColors(this.C);
            }
        }
        mg.e eVar2 = this.f22215m8;
        if (eVar2 != null) {
            super.bringChildToFront(eVar2.getView());
        }
        mg.h hVar5 = this.f22211k8;
        if (hVar5 != null && hVar5.getSpinnerStyle().f42150b) {
            super.bringChildToFront(this.f22211k8.getView());
        }
        mg.h hVar6 = this.f22213l8;
        if (hVar6 == null || !hVar6.getSpinnerStyle().f42150b) {
            return;
        }
        super.bringChildToFront(this.f22213l8.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f22239x8 = false;
        this.O7 = true;
        this.B8 = null;
        ValueAnimator valueAnimator = this.C8;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.C8.removeAllUpdateListeners();
            this.C8.setDuration(0L);
            this.C8.cancel();
            this.C8 = null;
        }
        mg.h hVar = this.f22211k8;
        if (hVar != null && this.f22223q8 == RefreshState.Refreshing) {
            hVar.l(this, false);
        }
        mg.h hVar2 = this.f22213l8;
        if (hVar2 != null && this.f22223q8 == RefreshState.Loading) {
            hVar2.l(this, false);
        }
        if (this.f22190b != 0) {
            this.f22221p8.k(0, true);
        }
        RefreshState refreshState = this.f22223q8;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2) {
            C0(refreshState2);
        }
        Handler handler = this.f22219o8;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f22241y8 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        int i10;
        int i11;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i12 = 0;
        int i13 = -1;
        char c10 = 0;
        while (true) {
            i10 = 2;
            if (i12 >= childCount) {
                break;
            }
            View childAt = super.getChildAt(i12);
            if (tg.b.f(childAt) && (c10 < 2 || i12 == 1)) {
                i13 = i12;
                c10 = 2;
            } else if (!(childAt instanceof mg.h) && c10 < 1) {
                c10 = i12 > 0 ? (char) 1 : (char) 0;
                i13 = i12;
            }
            i12++;
        }
        if (i13 >= 0) {
            this.f22215m8 = new qg.a(super.getChildAt(i13));
            if (i13 != 1) {
                if (childCount == 2) {
                    i11 = -1;
                    i10 = 1;
                }
                i11 = -1;
                i10 = -1;
            } else if (childCount == 3) {
                i11 = 0;
            } else {
                i11 = 0;
                i10 = -1;
            }
        } else {
            i11 = -1;
            i10 = -1;
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = super.getChildAt(i14);
            if (i14 == i11 || (i14 != i10 && i11 == -1 && this.f22211k8 == null && (childAt2 instanceof mg.g))) {
                this.f22211k8 = childAt2 instanceof mg.g ? (mg.g) childAt2 : new qg.c(childAt2);
            } else if (i14 == i10 || (i10 == -1 && (childAt2 instanceof mg.f))) {
                this.f22209k0 = this.f22209k0 || !this.O7;
                this.f22213l8 = childAt2 instanceof mg.f ? (mg.f) childAt2 : new qg.b(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iMax;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = super.getChildAt(i14);
            if (childAt.getVisibility() != 8 && childAt.getTag(R.string.srl_component_falsify) != childAt) {
                mg.e eVar = this.f22215m8;
                if (eVar != null && eVar.getView() == childAt) {
                    boolean z11 = isInEditMode() && this.f22234v2 && z0(this.D) && this.f22211k8 != null;
                    View view = this.f22215m8.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : G8;
                    int i15 = marginLayoutParams.leftMargin + paddingLeft;
                    int i16 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i15;
                    int measuredHeight = view.getMeasuredHeight() + i16;
                    if (z11 && A0(this.f22233v1, this.f22211k8)) {
                        int i17 = this.f22189a8;
                        i16 += i17;
                        measuredHeight += i17;
                    }
                    view.layout(i15, i16, measuredWidth, measuredHeight);
                }
                mg.h hVar = this.f22211k8;
                if (hVar != null && hVar.getView() == childAt) {
                    boolean z12 = isInEditMode() && this.f22234v2 && z0(this.D);
                    View view2 = this.f22211k8.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : G8;
                    int i18 = marginLayoutParams2.leftMargin;
                    int i19 = marginLayoutParams2.topMargin + this.f22197e8;
                    int measuredWidth2 = view2.getMeasuredWidth() + i18;
                    int measuredHeight2 = view2.getMeasuredHeight() + i19;
                    if (!z12 && this.f22211k8.getSpinnerStyle() == ng.b.f42143d) {
                        int i20 = this.f22189a8;
                        i19 -= i20;
                        measuredHeight2 -= i20;
                    }
                    view2.layout(i18, i19, measuredWidth2, measuredHeight2);
                }
                mg.h hVar2 = this.f22213l8;
                if (hVar2 != null && hVar2.getView() == childAt) {
                    boolean z13 = isInEditMode() && this.f22234v2 && z0(this.f22209k0);
                    View view3 = this.f22213l8.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : G8;
                    ng.b spinnerStyle = this.f22213l8.getSpinnerStyle();
                    int i21 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.f22199f8;
                    if (this.M7 && this.N7 && this.K1 && this.f22215m8 != null && this.f22213l8.getSpinnerStyle() == ng.b.f42143d && z0(this.f22209k0)) {
                        View view4 = this.f22215m8.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == ng.b.f42147h) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.f22199f8;
                    } else {
                        if (z13 || spinnerStyle == ng.b.f42146g || spinnerStyle == ng.b.f42145f) {
                            iMax = this.f22193c8;
                        } else if (spinnerStyle.f42151c && this.f22190b < 0) {
                            iMax = Math.max(z0(this.f22209k0) ? -this.f22190b : 0, 0);
                        }
                        measuredHeight3 -= iMax;
                    }
                    view3.layout(i21, measuredHeight3, view3.getMeasuredWidth() + i21, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ec  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedFling(@n0 View view, float f10, float f11, boolean z10) {
        return this.Y7.a(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedPreFling(@n0 View view, float f10, float f11) {
        return (this.f22241y8 && f11 > 0.0f) || E0(-f11) || this.Y7.b(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedPreScroll(@n0 View view, int i10, int i11, @n0 int[] iArr) {
        int i12 = this.V7;
        int i13 = 0;
        if (i11 * i12 > 0) {
            if (Math.abs(i11) > Math.abs(this.V7)) {
                int i14 = this.V7;
                this.V7 = 0;
                i13 = i14;
            } else {
                this.V7 -= i11;
                i13 = i11;
            }
            B0(this.V7);
        } else if (i11 > 0 && this.f22241y8) {
            int i15 = i12 - i11;
            this.V7 = i15;
            B0(i15);
            i13 = i11;
        }
        this.Y7.c(i10, i11 - i13, iArr, null);
        iArr[1] = iArr[1] + i13;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScroll(@n0 View view, int i10, int i11, int i12, int i13) {
        mg.k kVar;
        mg.k kVar2;
        boolean zF = this.Y7.f(i10, i11, i12, i13, this.X7);
        int i14 = i13 + this.X7[1];
        if ((i14 < 0 && ((this.D || this.K2) && (this.V7 != 0 || (kVar2 = this.U7) == null || kVar2.a(this.f22215m8.getView())))) || (i14 > 0 && ((this.f22209k0 || this.K2) && (this.V7 != 0 || (kVar = this.U7) == null || kVar.b(this.f22215m8.getView()))))) {
            RefreshState refreshState = this.f22225r8;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.f22221p8.b(i14 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!zF) {
                    ViewParent parent = getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            int i15 = this.V7 - i14;
            this.V7 = i15;
            B0(i15);
        }
        if (!this.f22241y8 || i11 >= 0) {
            return;
        }
        this.f22241y8 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScrollAccepted(@n0 View view, @n0 View view2, int i10) {
        this.Z7.b(view, view2, i10);
        this.Y7.r(i10 & 2);
        this.V7 = this.f22190b;
        this.W7 = true;
        y0(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onStartNestedScroll(@n0 View view, @n0 View view2, int i10) {
        return (isEnabled() && isNestedScrollingEnabled() && (i10 & 2) != 0) && (this.K2 || this.D || this.f22209k0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onStopNestedScroll(@n0 View view) {
        this.Z7.d(view);
        this.W7 = false;
        this.V7 = 0;
        D0();
        this.Y7.t();
    }

    @Override // mg.j
    public mg.j p(@n0 mg.g gVar) {
        return Q(gVar, 0, 0);
    }

    @Override // mg.j
    public mg.j p0(boolean z10) {
        setNestedScrollingEnabled(z10);
        return this;
    }

    @Override // mg.j
    public mg.j q(int i10) {
        this.f22198f = i10;
        return this;
    }

    @Override // mg.j
    public mg.j r(float f10) {
        this.f22207j8 = f10;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (u0.W0(this.f22215m8.i())) {
            this.f22224r = z10;
            super.requestDisallowInterceptTouchEvent(z10);
        }
    }

    @Override // mg.j
    public mg.j s(boolean z10) {
        this.C1 = z10;
        this.Q7 = true;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.J7 = z10;
        this.Y7.p(z10);
    }

    @Override // mg.j
    public mg.j setPrimaryColors(@g.l int... iArr) {
        mg.h hVar = this.f22211k8;
        if (hVar != null) {
            hVar.setPrimaryColors(iArr);
        }
        mg.h hVar2 = this.f22213l8;
        if (hVar2 != null) {
            hVar2.setPrimaryColors(iArr);
        }
        this.C = iArr;
        return this;
    }

    public void setStateDirectLoading(boolean z10) {
        RefreshState refreshState = this.f22223q8;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.f22227s8 = System.currentTimeMillis();
            this.f22241y8 = true;
            C0(refreshState2);
            sg.b bVar = this.S7;
            if (bVar != null) {
                if (z10) {
                    bVar.g(this);
                }
            } else if (this.T7 == null) {
                X(2000);
            }
            mg.h hVar = this.f22213l8;
            if (hVar != null) {
                int i10 = this.f22193c8;
                hVar.b(this, i10, (int) (this.f22203h8 * i10));
            }
            sg.c cVar = this.T7;
            if (cVar == null || !(this.f22213l8 instanceof mg.f)) {
                return;
            }
            if (z10) {
                cVar.g(this);
            }
            sg.c cVar2 = this.T7;
            mg.f fVar = (mg.f) this.f22213l8;
            int i11 = this.f22193c8;
            cVar2.m(fVar, i11, (int) (this.f22203h8 * i11));
        }
    }

    public void setStateLoading(boolean z10) {
        b bVar = new b(z10);
        C0(RefreshState.LoadReleased);
        ValueAnimator valueAnimatorF = this.f22221p8.f(-this.f22193c8);
        if (valueAnimatorF != null) {
            valueAnimatorF.addListener(bVar);
        }
        mg.h hVar = this.f22213l8;
        if (hVar != null) {
            int i10 = this.f22193c8;
            hVar.i(this, i10, (int) (this.f22203h8 * i10));
        }
        sg.c cVar = this.T7;
        if (cVar != null) {
            mg.h hVar2 = this.f22213l8;
            if (hVar2 instanceof mg.f) {
                int i11 = this.f22193c8;
                cVar.p((mg.f) hVar2, i11, (int) (this.f22203h8 * i11));
            }
        }
        if (valueAnimatorF == null) {
            bVar.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z10) {
        c cVar = new c(z10);
        C0(RefreshState.RefreshReleased);
        ValueAnimator valueAnimatorF = this.f22221p8.f(this.f22189a8);
        if (valueAnimatorF != null) {
            valueAnimatorF.addListener(cVar);
        }
        mg.h hVar = this.f22211k8;
        if (hVar != null) {
            int i10 = this.f22189a8;
            hVar.i(this, i10, (int) (this.f22201g8 * i10));
        }
        sg.c cVar2 = this.T7;
        if (cVar2 != null) {
            mg.h hVar2 = this.f22211k8;
            if (hVar2 instanceof mg.g) {
                int i11 = this.f22189a8;
                cVar2.s((mg.g) hVar2, i11, (int) (this.f22201g8 * i11));
            }
        }
        if (valueAnimatorF == null) {
            cVar.onAnimationEnd(null);
        }
    }

    public void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.f22223q8;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            C0(RefreshState.None);
        }
        if (this.f22225r8 != refreshState) {
            this.f22225r8 = refreshState;
        }
    }

    @Override // mg.j
    public mg.j t(float f10) {
        int iD = tg.b.d(f10);
        if (iD == this.f22193c8) {
            return this;
        }
        ng.a aVar = this.f22195d8;
        ng.a aVar2 = ng.a.f42137l;
        if (aVar.a(aVar2)) {
            this.f22193c8 = iD;
            mg.h hVar = this.f22213l8;
            if (hVar != null && this.f22239x8 && this.f22195d8.f42142b) {
                ng.b spinnerStyle = hVar.getSpinnerStyle();
                if (spinnerStyle != ng.b.f42147h && !spinnerStyle.f42151c) {
                    View view = this.f22213l8.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : G8;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.f22193c8 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i10 = marginLayoutParams.leftMargin;
                    int measuredHeight = ((marginLayoutParams.topMargin + getMeasuredHeight()) - this.f22199f8) - (spinnerStyle != ng.b.f42143d ? this.f22193c8 : 0);
                    view.layout(i10, measuredHeight, view.getMeasuredWidth() + i10, view.getMeasuredHeight() + measuredHeight);
                }
                this.f22195d8 = aVar2;
                mg.h hVar2 = this.f22213l8;
                mg.i iVar = this.f22221p8;
                int i11 = this.f22193c8;
                hVar2.n(iVar, i11, (int) (this.f22203h8 * i11));
            } else {
                this.f22195d8 = ng.a.f42136k;
            }
        }
        return this;
    }

    @Override // mg.j
    public mg.j u(int i10) {
        return j0(i10, true, Boolean.FALSE);
    }

    @Override // mg.j
    public mg.j v(@n0 View view, int i10, int i11) {
        mg.e eVar = this.f22215m8;
        if (eVar != null) {
            super.removeView(eVar.getView());
        }
        if (i10 == 0) {
            i10 = -1;
        }
        if (i11 == 0) {
            i11 = -1;
        }
        m mVar = new m(i10, i11);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof m) {
            mVar = (m) layoutParams;
        }
        super.addView(view, getChildCount(), mVar);
        this.f22215m8 = new qg.a(view);
        if (this.f22239x8) {
            View viewFindViewById = findViewById(this.f22226s);
            View viewFindViewById2 = findViewById(this.f22228t);
            this.f22215m8.c(this.U7);
            this.f22215m8.b(this.I7);
            this.f22215m8.j(this.f22221p8, viewFindViewById, viewFindViewById2);
        }
        mg.h hVar = this.f22211k8;
        if (hVar != null && hVar.getSpinnerStyle().f42150b) {
            super.bringChildToFront(this.f22211k8.getView());
        }
        mg.h hVar2 = this.f22213l8;
        if (hVar2 != null && hVar2.getSpinnerStyle().f42150b) {
            super.bringChildToFront(this.f22213l8.getView());
        }
        return this;
    }

    @Override // mg.j
    public mg.j w() {
        return U(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f22227s8))), 300) << 16, true, true);
    }

    public ValueAnimator w0(int i10, int i11, Interpolator interpolator, int i12) {
        if (this.f22190b == i10) {
            return null;
        }
        ValueAnimator valueAnimator = this.C8;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.C8.cancel();
            this.C8 = null;
        }
        this.B8 = null;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f22190b, i10);
        this.C8 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i12);
        this.C8.setInterpolator(interpolator);
        this.C8.addListener(new d());
        this.C8.addUpdateListener(new e());
        this.C8.setStartDelay(i11);
        this.C8.start();
        return this.C8;
    }

    @Override // mg.j
    public mg.j x(sg.b bVar) {
        this.S7 = bVar;
        this.f22209k0 = this.f22209k0 || !(this.O7 || bVar == null);
        return this;
    }

    public void x0(float f10) {
        RefreshState refreshState;
        if (this.C8 == null) {
            if (f10 > 0.0f && ((refreshState = this.f22223q8) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.B8 = new k(f10, this.f22189a8);
                return;
            }
            if (f10 < 0.0f && (this.f22223q8 == RefreshState.Loading || ((this.K1 && this.M7 && this.N7 && z0(this.f22209k0)) || (this.E7 && !this.M7 && z0(this.f22209k0) && this.f22223q8 != RefreshState.Refreshing)))) {
                this.B8 = new k(f10, -this.f22193c8);
            } else if (this.f22190b == 0 && this.C2) {
                this.B8 = new k(f10, 0);
            }
        }
    }

    @Override // mg.j
    public mg.j y(float f10) {
        this.f22201g8 = f10;
        mg.h hVar = this.f22211k8;
        if (hVar == null || !this.f22239x8) {
            this.f22191b8 = this.f22191b8.c();
        } else {
            mg.i iVar = this.f22221p8;
            int i10 = this.f22189a8;
            hVar.n(iVar, i10, (int) (f10 * i10));
        }
        return this;
    }

    public boolean y0(int i10) {
        if (i10 == 0) {
            if (this.C8 != null) {
                RefreshState refreshState = this.f22223q8;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased || refreshState == RefreshState.RefreshReleased || refreshState == RefreshState.LoadReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.f22221p8.b(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.f22221p8.b(RefreshState.PullUpToLoad);
                }
                this.C8.setDuration(0L);
                this.C8.cancel();
                this.C8 = null;
            }
            this.B8 = null;
        }
        return this.C8 != null;
    }

    @Override // mg.j
    public boolean z() {
        int i10 = this.f22239x8 ? 0 : 400;
        int i11 = this.f22198f;
        float f10 = (this.f22201g8 / 2.0f) + 0.5f;
        int i12 = this.f22189a8;
        float f11 = f10 * i12 * 1.0f;
        if (i12 == 0) {
            i12 = 1;
        }
        return O(i10, i11, f11 / i12, false);
    }

    public boolean z0(boolean z10) {
        return z10 && !this.F7;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22196e = 300;
        this.f22198f = 300;
        this.f22212l = 1.0f;
        this.f22214m = 0.16666667f;
        this.f22216n = 0.5f;
        this.f22218o = 'n';
        this.f22226s = -1;
        this.f22228t = -1;
        this.f22230u = -1;
        this.f22232v = -1;
        this.D = true;
        this.f22209k0 = false;
        this.K0 = true;
        this.f22210k1 = true;
        this.f22233v1 = true;
        this.C1 = true;
        this.K1 = false;
        this.f22234v2 = true;
        this.C2 = true;
        this.K2 = false;
        this.E7 = true;
        this.F7 = false;
        this.G7 = true;
        this.H7 = true;
        this.I7 = true;
        this.J7 = true;
        this.K7 = false;
        this.L7 = false;
        this.M7 = false;
        this.N7 = false;
        this.O7 = false;
        this.P7 = false;
        this.Q7 = false;
        this.X7 = new int[2];
        this.Y7 = new f0(this);
        this.Z7 = new j0(this);
        ng.a aVar = ng.a.f42128c;
        this.f22191b8 = aVar;
        this.f22195d8 = aVar;
        this.f22201g8 = 2.5f;
        this.f22203h8 = 2.5f;
        this.f22205i8 = 1.0f;
        this.f22207j8 = 1.0f;
        this.f22221p8 = new n();
        RefreshState refreshState = RefreshState.None;
        this.f22223q8 = refreshState;
        this.f22225r8 = refreshState;
        this.f22227s8 = 0L;
        this.f22229t8 = 0;
        this.f22231u8 = 0;
        this.f22241y8 = false;
        this.f22243z8 = false;
        this.A8 = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f22219o8 = new Handler();
        this.f22242z = new Scroller(context);
        this.A = VelocityTracker.obtain();
        this.f22200g = context.getResources().getDisplayMetrics().heightPixels;
        this.B = new tg.b(tg.b.f51276b);
        this.f22188a = viewConfiguration.getScaledTouchSlop();
        this.f22236w = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f22238x = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f22193c8 = tg.b.d(60.0f);
        this.f22189a8 = tg.b.d(100.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        if (!typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        mg.c cVar = F8;
        if (cVar != null) {
            cVar.a(context, this);
        }
        this.f22216n = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.f22216n);
        this.f22201g8 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.f22201g8);
        this.f22203h8 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.f22203h8);
        this.f22205i8 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.f22205i8);
        this.f22207j8 = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.f22207j8);
        this.D = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.D);
        this.f22198f = typedArrayObtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f22198f);
        int i10 = R.styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.f22209k0 = typedArrayObtainStyledAttributes.getBoolean(i10, this.f22209k0);
        int i11 = R.styleable.SmartRefreshLayout_srlHeaderHeight;
        this.f22189a8 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i11, this.f22189a8);
        int i12 = R.styleable.SmartRefreshLayout_srlFooterHeight;
        this.f22193c8 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i12, this.f22193c8);
        this.f22197e8 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.f22197e8);
        this.f22199f8 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.f22199f8);
        this.K7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.K7);
        this.L7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.L7);
        int i13 = R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.f22233v1 = typedArrayObtainStyledAttributes.getBoolean(i13, this.f22233v1);
        int i14 = R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.C1 = typedArrayObtainStyledAttributes.getBoolean(i14, this.C1);
        this.f22234v2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.f22234v2);
        this.E7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.E7);
        this.C2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.C2);
        this.F7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.F7);
        this.G7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.G7);
        this.H7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.H7);
        this.I7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.I7);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.K1);
        this.K1 = z10;
        this.K1 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z10);
        this.K0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.K0);
        this.f22210k1 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.f22210k1);
        this.K2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.K2);
        this.f22226s = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.f22226s);
        this.f22228t = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.f22228t);
        this.f22230u = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.f22230u);
        this.f22232v = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.f22232v);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.J7);
        this.J7 = z11;
        this.Y7.p(z11);
        this.O7 = this.O7 || typedArrayObtainStyledAttributes.hasValue(i10);
        this.P7 = this.P7 || typedArrayObtainStyledAttributes.hasValue(i13);
        this.Q7 = this.Q7 || typedArrayObtainStyledAttributes.hasValue(i14);
        this.f22191b8 = typedArrayObtainStyledAttributes.hasValue(i11) ? ng.a.f42134i : this.f22191b8;
        this.f22195d8 = typedArrayObtainStyledAttributes.hasValue(i12) ? ng.a.f42134i : this.f22195d8;
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.C = new int[]{color2, color};
            } else {
                this.C = new int[]{color2};
            }
        } else if (color != 0) {
            this.C = new int[]{0, color};
        }
        if (this.F7 && !this.O7 && !this.f22209k0) {
            this.f22209k0 = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static class m extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ng.b f22293b;

        public m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f22292a = 0;
            this.f22293b = null;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f22292a = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f22292a);
            int i10 = R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                this.f22293b = ng.b.f42148i[typedArrayObtainStyledAttributes.getInt(i10, ng.b.f42143d.f42149a)];
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public m(int i10, int i11) {
            super(i10, i11);
            this.f22292a = 0;
            this.f22293b = null;
        }
    }
}
